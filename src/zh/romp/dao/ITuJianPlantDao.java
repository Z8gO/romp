package zh.romp.dao;

import java.util.List;

import zh.romp.entity.Imagejian;
import zh.romp.pager.Expression;
import zh.romp.pager.PageBean;

public interface ITuJianPlantDao {

			public boolean insert(Imagejian imageJian);
			
			public Imagejian getById(int id);
			
			public PageBean<Imagejian>  findByCriteria(List<Expression> exprList,int pc);
			
			public Imagejian findById(int pid);
			
			public boolean updateQueStatus(int pid);
			
			public boolean delQue(int imgid);
}









