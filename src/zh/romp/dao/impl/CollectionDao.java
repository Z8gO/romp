package zh.romp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import zh.romp.dao.ICollectionDao;
import zh.romp.entity.Collection;
import zh.romp.pager.Expression;
import zh.romp.pager.PageBean;
import zh.romp.pager.PageConstants;
import zh.romp.util.DBUtils;
/**
 * 
 * 类名:		CollectionDao
 * 描述:		Collection 的Dao实现层
 * @author 	张煌
 * @date 	2016年4月11日 下午5:11:54
 *
 */
public class CollectionDao implements ICollectionDao {
	DBUtils dbutil=new DBUtils();
	@Override
	public boolean insert(Collection coll) {
		String sql="insert into collection_romp(pname,cuid,cdate,pid)  values(?,?,?,?)";
		int update = dbutil.executeUpdate(sql, new Object[]{coll.getPname(),coll.getCuid(),coll.getCdate(),coll.getPid()});
		return update==1;
	}
/**
 * 
 */
	@Override
	public boolean delete(int cid) {
			String sql="delete from collection_romp  where cid=?";
			int i = dbutil.executeUpdate(sql, new Object[]{cid});
			return i==1;
	}

	/**
	 * 通用查询
	 */
	@Override
	public PageBean<Collection> findByCriteria(List<Expression> exprList, int pc) {
		//设置每页显示的数据量
		int ps=PageConstants.COLLECTION_PAGE_SIZE;
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
		String sql="select * from collection_romp"+whereSql;
		int tr =dbutil.executeQuery(sql, params.toArray(),Collection.class ).size();
		/**
		 * 得到beanList，即当前页记录
		 */
		sql="select * from collection_romp"+whereSql+" limit ?,?";
		
		
		params.add((pc-1)*ps);  //第一个问号,当前页首行记录的下标
		params.add(ps);//一页多少个			
		//查到数据集合
		List<Collection> list = dbutil.executeQuery(sql, params.toArray(), Collection.class);
		PageBean<Collection> pb=new PageBean<Collection>();
		pb.setList(list);
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(tr);
		return pb;
	}

	@Override
	public Collection findByNameAndUid(String pname, String uid) {
		String sql ="select * from collection_romp where pname=? and cuid=?";
		List<Collection> list = dbutil.executeQuery(sql, new Object[]{pname,uid}, Collection.class);
		if(list.size()!=0){
		return list.get(0);
		}else{
			return null;
		}
	}
	}

