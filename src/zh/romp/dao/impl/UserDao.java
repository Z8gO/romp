package zh.romp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import zh.romp.dao.IUserDao;
import zh.romp.entity.ChartCount;
import zh.romp.entity.User;
import zh.romp.pager.Expression;
import zh.romp.pager.PageBean;
import zh.romp.pager.PageConstants;
import zh.romp.util.DBUtils;

/**
 * 
 * 类名:		UserDao
 * 描述:		User实体的dao层实现
 * @author 	张煌
 * @date 	2016年4月11日 下午5:12:44
 *
 */

public class UserDao implements IUserDao {
	
	DBUtils dbutil=new DBUtils();
	@Override
	public boolean findUser(String username) {
		
		String sql="select * from users_romp where uname=?";
		List<User> user = dbutil.executeQuery(sql, new Object[]{username}, User.class);
		return user.size()==0;
	}
	@Override
	public int insert(User user) {
		String sql="insert into users_romp (uname,password,workunit,email,lasttime,iid,udemo,status) values(?,?,?,?,?,?,?,?)";
		int flag = dbutil.executeUpdate(sql, new Object[]{user.getUname(),user.getPassword(),user.getWorkunit(),user.getEmail(),user.getLasttime(),user.getIid(),user.getUdemo(),"no"});
		return flag;
	}
	@Override
	public User get(String userName, String passWord) {
		String sql="select * from users_romp where uname=? and  passWord=?";
		List<User> user = dbutil.executeQuery(sql, new Object[]{userName,passWord}, User.class);
		
		if(user.size()!=0){
			return user.get(0);
		}else{
			return null;
		}
	}
	@Override
	public boolean update(String uname,String key, String newdata) {
		String sql="update users_romp set "+key+"=? where uname=?";
		int flag = dbutil.executeUpdate(sql, new Object[]{newdata,uname});
		
		return flag>0;
	}
	
	
	/**
	 * 通用查询
	 */
	@Override
	public PageBean<User> findByCriteria(List<Expression> exprList, int pc) {
		//设置每页显示的数据量
		int ps=PageConstants.USER_PAGE_SIZE;
		//exprList来生成where子句
		StringBuilder whereSql =new StringBuilder(" where  1=1");
		List<Object>  params=new ArrayList<Object>();//对用SQL中的问号的参数
		for(Expression expr  : exprList){
			whereSql.append(" and ").append(expr.getName()).append(" ")
			.append(expr.getOperator()).append(" ");
			if(!expr.getOperator().equals("> 0")){
				whereSql.append("?");
				params.add(expr.getValue());
			}	
		}
		/**
		 * 查询总记录数
		 * 	String sql="select * from imagejian"+whereSql;
		 *  List<Imagejian> list2 = dbutil.executeQuery(sql, params.toArray(), Imagejian.class);
		 */
		String sql="select * from users_romp"+whereSql;		
		int tr =dbutil.executeQuery(sql, params.toArray(),User.class ).size();
		/**
		 * 得到beanList，即当前页记录
		 */
		sql="select * from users_romp"+whereSql+" limit ?,?";
		
		params.add((pc-1)*ps);  //第一个问号,当前页首行记录的下标
		params.add(ps);//一页多少个			
		//查到数据集合
		List<User> list = dbutil.executeQuery(sql, params.toArray(), User.class);
		PageBean<User> pb=new PageBean<User>();
		pb.setList(list);
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(tr);
		return pb;
	}
	@Override
	public User findUserById(int uid) {
		String sql="select * from users_romp where uid=?";
		List<User> user = dbutil.executeQuery(sql, new Object[]{uid}, User.class);
		return user.get(0);
	}
	@Override
	public boolean updateUserStatus(int uid, String newStatus) {
		String sql="update users_romp set status=? where uid=?";
		int i=dbutil.executeUpdate(sql, new Object[]{newStatus,uid});
		return i==1;
	}
	/* (non-Javadoc)
	 * @see zh.romp.dao.IUserDao#userChart()
	 */
    @Override
    public ArrayList<ChartCount> userChart() {
	   String sql="select iid as chartKeys,count(*) as number from users_romp  where status='yes' group by iid";
	   
	    return dbutil.queryChartCount(sql);
    }
    
    
    
   /* public static void main(String[] args) {
    	UserDao u=new UserDao();
    		List<ChartCount> list=new ArrayList<ChartCount>();
    		list = u.userChart();
    	for (int i = 0; i < list.size(); i++) {
	        	System.out.println("******UserDao*****");
	        	System.out.println(list.get(i).toString());
        }
    }*/
		
}
