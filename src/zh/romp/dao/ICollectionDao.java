package zh.romp.dao;

import java.util.List;

import zh.romp.entity.Collection;
import zh.romp.pager.Expression;
import zh.romp.pager.PageBean;

public interface ICollectionDao {
			public boolean insert(Collection coll);
			
			public boolean delete(int cid);
			
			public PageBean<Collection>  findByCriteria(List<Expression> exprList,int pc);
			
			public Collection findByNameAndUid(String pname,String uid);
}
