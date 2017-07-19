package zh.romp.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;


import zh.romp.entity.ChartCount;
/**
 * 
 * 类        名:DBUtils.java
 * 作        者:	张	煌<br>
 * 作        用:  数据库连接+持久层 <br>
 * 创建时间:2015年8月14日上午11:10:28
 */

public  class DBUtils {
    private static Logger logger =  Logger.getLogger(DBUtils.class);
	private static BasicDataSource bds = new BasicDataSource();
	
	static{
		Properties pro = new Properties();
		InputStream is = DBUtils.class.getResourceAsStream("db.properties");
		try {
		    logger.info("开始加载db.properties文件！");
			pro.load(is);
			logger.info("加载db.properties文件成功！");
		} catch (IOException e) {
		    logger.info("加载db.properties文件失败！请检查配置的名称是否正确！");
			e.printStackTrace();
		}
		
		bds.setDriverClassName(pro.getProperty("DCN"));
		bds.setUrl(pro.getProperty("URL"));
		bds.setUsername(pro.getProperty("UNAME"));
		bds.setPassword(pro.getProperty("PASSWORD"));
		bds.setMaxActive(Integer.parseInt(pro.getProperty("MAXACTIVE")));
		bds.setMaxIdle(Integer.parseInt(pro.getProperty("MAXIDLE")));
		bds.setMinIdle(Integer.parseInt(pro.getProperty("MINIDLE")));
		bds.setMaxWait(Long.parseLong(pro.getProperty("MAXWAIT")));
		bds.setInitialSize(Integer.parseInt(pro.getProperty("INITIALSIZE")));
	}
	
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	/***
	 * 链接数据库的方法
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	
	public  Connection getConn() throws ClassNotFoundException, SQLException{
		
		conn = bds.getConnection();
		return conn;
		
	}
	/**
	 * 释放数据库资源
	 */
	public void closeAll(){		
	    long s=System.nanoTime();
	    logger.info("开始关闭数据库连接并且释放资源集合！DBUtils.java");
			try {
				if(rs!=null ){
					rs.close();
				}
				if(ps!=null ){
					ps.close();
				}
				if(conn!=null ){
					conn.close();
				}
			} catch (SQLException e) {
				logger.info("关闭数据库连接或者释放资源集合时失败！DBUtils.java");
				e.printStackTrace();
			}finally{
				conn = null;
				ps = null;
				rs = null;
				long e=System.nanoTime();
				logger.info("关闭数据库连接并且释放资源集合成功！用时"+(e-s)+"纳秒 DBUtils.java");
			}
	}
	/***
	 * 执行增、删、改方法
	 * @param sql     带有？号占位符的SQL语句
	 * @param params   ？号占位符的值
	 * @return   影响的行数
	 */
	public int executeUpdate(String sql,Object[] params){
	    logger.info("进入到executeUpdate（增删改公用方法）！");
	    StringBuffer sb=new StringBuffer();
	    sb.append("[");
	    if(params != null){
	    for (int i = 0; i < params.length; i++) {
	    	String strs=params[i]+"".replaceAll("%", "");
	    	if(params.length==1){
	        sb.append(strs);
	    	}else
	    		if(i+1==params.length){
	    		sb.append(strs);
			}else{
				sb.append(strs+",");
	    	}
		}
	   }
		sb.append("]");
		logger.info("SQL语句的参数是"+sb.toString());
		long s=System.nanoTime();
		try {
			//链接数据库
			conn = this.getConn();
			ps = conn.prepareStatement(sql);
			//判断SQL语句中是否存在?号占位符
			if(params != null && params.length != 0){
				//循环设置?号占位符的值
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
			//执行SQL语句
			int flagss=ps.executeUpdate();
			long e=System.nanoTime();
			logger.info("执行成功!用时："+(e-s)+"纳秒");
			return flagss;
		} catch (ClassNotFoundException e) {
		    logger.info("没有找到Connection，请检查有没有导入java.sql.Connection");
			e.printStackTrace();
		} catch (SQLException e) {
		    logger.info("执行SQL语句时出现问题，请检查SQL语句是否正确");
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return 0;
	}
	
	
	/***
	 * 通用查询
	 * @param <T>
	 * @param sql
	 * @param params
	 * @param cla    查询表所对应的实体对象的类型
	 * @return
	 */
	public <T> List<T> executeQuery(String sql,Object[] params,Class<T> cla){
	    logger.info("进入到公共查询方法，sql语句是"+sql);
	    StringBuffer sb=new StringBuffer();
	    sb.append("[");
	    if(params!=null){
	    for (int i = 0; i < params.length; i++) {
	    	String strs=params[i]+"".replaceAll("%", "");
	    	if(params.length==1){
	        sb.append(strs);
	    	}else
	    		if(i+1==params.length){
	    		sb.append(strs);
	    	}else{
	    		sb.append(strs+",");
	    	}
				}
	    }
	    sb.append("]");
	    logger.info("SQL语句的参数是"+sb.toString());
	    logger.info("查询的POJO是："+cla.getSimpleName());
	    long s=System.nanoTime();
		List<T> list= new ArrayList<T>();
		try {
			//链接数据库
			conn = this.getConn();
			ps = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//判断SQL语句中是否存在?号占位符
			if(params != null && params.length != 0){
				//循环设置?号占位符的值
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
			rs = ps.executeQuery();
			//获得结果集对应的元数据
			ResultSetMetaData rsmt = rs.getMetaData();
			//获得总列数
			int cols = rsmt.getColumnCount();
			//1.从结果集中将数据取出
			while(rs.next()){//获得一行中的所有列
				//创建类的对象
				T obj = cla.newInstance();
				for(int i=0;i<cols;i++){
					//获得某列数据
					Object data = rs.getObject(i+1);
					//获得当前列的列名
					String columnName = rsmt.getColumnName(i+1);
					//将列名拼接为方法名（ｓｅｔ方法）
					String methodName = "set"
					+columnName.substring(0, 1).toUpperCase()
					+columnName.substring(1);
					//根据列名获得属性对象
					Field field = cla.getDeclaredField(columnName);
					//通过方法名获得该方法名所对应的方法对象
					Method method = cla.getMethod(methodName,
							field.getType());
					//调用对象中的方法//转换类型并调用方法
					method.invoke(obj, 
					ConvertUtils.convert(data, field.getType()));
				}
				//将obj添加到list中
				list.add(obj);
			}
			Long e=System.nanoTime();
			logger.info("查询成功！本次用时"+(e-s)+"纳秒");
			//2.将取出的数据封装到实体对象中
			//3.将对象存入到List集合中
			return list;
		} catch (Exception e) {
		    logger.info("出现异常，具体内容是"+e.getMessage());
			e.printStackTrace();
		} finally{
			this.closeAll();
		}
		return null;
	}
	
	/**
	 * 作者:	张	煌<br>
	 * @param sql
	 * @return:  <br>
	 * 本方法功能: 查询数据总条数，用于分页<br>
	 */
	public int queryCount(String sql){
		logger.info("进入到DBUtils.java的queryCount方法，SQL语句是:"+sql);
		int count=0;
		try {
			conn = this.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs.next()){
				count=rs.getInt(1);
				return count;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
		    
			this.closeAll();
		}
		return 0;
		
	}
	/**
	 * 
	 * 描述:		图表统计
	 * @param sql
	 * @return
	 */
	public ArrayList<ChartCount> queryChartCount(String sql){
		logger.info("进入到DBUtils.java的queryChartCount方法，SQL语句是:"+sql);
		try {
			conn = this.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			List<ChartCount> list=new ArrayList<ChartCount>();
			while(rs.next()){
				ChartCount cc=new ChartCount();
				cc.setChartKeys(rs.getInt("chartKeys"));
				cc.setNumber(rs.getInt("number"));
				list.add(cc);
				
			}
			
			return (ArrayList<ChartCount>) list;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{   
			this.closeAll();
		}
		return null;
	}
 
}
