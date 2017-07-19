package zh.romp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import zh.romp.dao.ITuJianPlantDao;
import zh.romp.entity.Imagejian;
import zh.romp.pager.Expression;
import zh.romp.pager.PageBean;
import zh.romp.pager.PageConstants;
import zh.romp.util.DBUtils;

public class TuJianPlantDao implements ITuJianPlantDao {
	DBUtils dbutil=new DBUtils();
	
	@Override
	public boolean insert(Imagejian imageJian) {
		String sql="insert into imagejian (imgpath,uid,uploadtime,imgdemo,status) values(?,?,?,?,?)";
		int flag = dbutil.executeUpdate(sql, new Object[]{imageJian.getImgpath(),imageJian.getUid(),imageJian.getUploadtime(),imageJian.getImgdemo(),"no"});
		return flag==1;
	}
	
	/**
	 * 通用查询
	 */
	@Override
	public PageBean<Imagejian> findByCriteria(List<Expression> exprList, int pc) {
		//设置每页显示的数据量
		int ps=PageConstants.PLANT_PAGE_SIZE;
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
		 */
		String sql="select * from imagejian"+whereSql;
		List<Imagejian> list2 = dbutil.executeQuery(sql, params.toArray(), Imagejian.class);
			int tr=list2.size();
		/**
		 * 得到beanList，即当前页记录
		 */
		sql="select * from imagejian"+whereSql+" limit ?,?";
		
		
		
		params.add((pc-1)*ps);  //第一个问号,当前页首行记录的下标
		params.add(ps);//一页多少个
		
		//查到数据集合
		List<Imagejian> list = dbutil.executeQuery(sql, params.toArray(), Imagejian.class);
		
		PageBean<Imagejian> pb=new PageBean<Imagejian>();
		pb.setList(list);
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(tr);
		return pb;
	}

	@Override
	public Imagejian findById(int pid) {
		String sql="select * from imagejian where imgid=?";
		List<Imagejian> list = dbutil.executeQuery(sql, new Object[]{pid}, Imagejian.class);
		return list.get(0);
	}

	@Override
	public boolean updateQueStatus(int pid) {
		String sql="update imagejian set status=? where imgid=?";
		int i=dbutil.executeUpdate(sql, new Object[]{"yes",pid});
		return i==1;
	}

	@Override
	public Imagejian getById(int id) {
		String sql="select * from imagejian where imgid=?";
		
		List<Imagejian> list = dbutil.executeQuery(sql, new Object[]{id},Imagejian.class);
		return list.get(0);
	}

	@Override
	public boolean delQue(int imgid) {
		String sql="delete from imagejian where imgid=?";
		return dbutil.executeUpdate(sql, new Object[]{imgid})==1;
	}


	/*public static void main(String[] args) {
		TuJianPlantDao tuJianPlantDao=new TuJianPlantDao();
		List<Expression> exprList=new ArrayList<Expression>();
		
		exprList.add(new Expression("imgid","> 0",null));
		
		tuJianPlantDao.findByCriteria(exprList, 2);
	}
	*/

}
