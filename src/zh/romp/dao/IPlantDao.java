package zh.romp.dao;

import java.util.List;

import zh.romp.entity.ChartCount;
import zh.romp.entity.Plant;
import zh.romp.pager.Expression;
import zh.romp.pager.PageBean;

public interface IPlantDao {
	
		public boolean getPlantByName(String zwword);
		
		public Plant getPlantById(int pid);
			
		public boolean insert(Plant plant);	
		
		public boolean del(int pid);
		
		public PageBean<Plant>  findByCriteria(List<Expression> exprList,int pc);
		
		public boolean shuiYinSuccess(int pid);
			
		public Plant getPlantByname(String zwword);
		
		public boolean updatePlant(Plant plant);
		
		public List<Plant>  indexPlants();
		
		public List<ChartCount>  plantChat();
}
