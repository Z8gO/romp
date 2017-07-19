package zh.romp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import zh.romp.dao.IPlantDao;
import zh.romp.entity.ChartCount;
import zh.romp.entity.Plant;
import zh.romp.pager.Expression;
import zh.romp.pager.PageBean;
import zh.romp.pager.PageConstants;
import zh.romp.util.DBUtils;
/**
 * 
 * 类名:		PlantDao
 * 描述:		植物Dao 层实现
 * @author 	张煌
 * @date 	2016年4月11日 下午5:12:21
 *
 */
public class PlantDao implements IPlantDao {

	DBUtils dbutil=new DBUtils();
	@Override
	public boolean getPlantByName(String zwword) {
		String sql="select * from plants_romp where zwword=?";
		List<Plant>  plant=dbutil.executeQuery(sql, new Object[]{zwword}, Plant.class);
		
		return plant.size()==0;
	}
	
	
	@Override
	public boolean insert(Plant plant) {
		
		String sql="insert into plants_romp(zwword,ywword,ldword,picpath,ke,xw,gj,zzgn,yfyl,yybw,pimguid,perfectuid,uploadtime,pdemo,shuiyinstatus) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int insert = dbutil.executeUpdate(sql, new Object[]{
				plant.getZwword(),plant.getYwword(),plant.getLdword(),	
				plant.getPicpath(),plant.getKe(),plant.getXw(),plant.getGj(),plant.getZzgn(),
				plant.getYfyl(),plant.getYybw(),plant.getPimguid(),plant.getPerfectuid(),
				plant.getUploadtime(),plant.getPdemo(),"no"
		});
		return insert==1;
	}

		/**
		 * 通用查询
		 */
		@Override
		public PageBean<Plant> findByCriteria(List<Expression> exprList, int pc) {
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
			String sql="select * from plants_romp"+whereSql;
			int tr =dbutil.executeQuery(sql, params.toArray(),Plant.class ).size();
			/**
			 * 得到beanList，即当前页记录
			 */
			sql="select * from plants_romp"+whereSql+" limit ?,?";
			
			
			params.add((pc-1)*ps);  //第一个问号,当前页首行记录的下标
			params.add(ps);//一页多少个			
			//查到数据集合
			List<Plant> list = dbutil.executeQuery(sql, params.toArray(), Plant.class);
			PageBean<Plant> pb=new PageBean<Plant>();
			pb.setList(list);
			pb.setPc(pc);
			pb.setPs(ps);
			pb.setTr(tr);
			return pb;
		}


		@Override
		public Plant getPlantById(int pid) {
			String sql="select * from plants_romp where pid=?";
			
			List<Plant>  plant=dbutil.executeQuery(sql, new Object[]{pid}, Plant.class);
			if(plant.isEmpty()){
				return null;
			}
			
			return plant.get(0);
		}


		@Override
		public boolean del(int pid) {
			String sql="delete from plants_romp where pid=?";
			 int flag=dbutil.executeUpdate(sql, new Object[]{pid});
			return flag==1;
		}


		@Override
		public boolean shuiYinSuccess(int pid) {
			String sql="update  plants_romp set shuiyinstatus=? where pid=?";
			
			return dbutil.executeUpdate(sql, new Object[]{"yes",pid})==1;
		}


		@Override
		public Plant getPlantByname(String zwword) {
			String sql="select * from plants_romp where zwword=?";
			List<Plant>  plant=dbutil.executeQuery(sql, new Object[]{zwword}, Plant.class);
			
			return plant.get(0);
			}


		/** (non-Javadoc)
		 * @see zh.romp.dao.IPlantDao#updatePlant(zh.romp.entity.Plant)
		 * 修改的时候只能修改：zwword,ywword,ldword,ke,xw,gj,zzgn,yfyl,yybw,pdemo
		 */
        @Override
        public boolean updatePlant(Plant plant) {
            String sql="update  plants_romp set  zzgn =? ,yfyl =? ,"+
                    "pdemo =?   where pid=?";
            Object[]  obj=new Object[]{plant.getZzgn(),plant.getYfyl(),plant.getPdemo(),plant.getPid()};
            		int update=dbutil.executeUpdate(sql, obj);
            return update==1;
        }

		/* (non-Javadoc)
		 * @see zh.romp.dao.IPlantDao#indexPlants()
		 */
        @Override
        public List<Plant> indexPlants() {
	       String sql="select * from plants_romp order by rand() limit ?;";
	       Object[]  obj=new Object[]{4};
	        return dbutil.executeQuery(sql, obj, Plant.class);
        }


		/* (non-Javadoc)
		 * @see zh.romp.dao.IPlantDao#plantChat()
		 */
        @Override
        public List<ChartCount> plantChat() {
        		   String sql="select ke as chartKeys,count(*) as number from plants_romp group by ke";
        		    return dbutil.queryChartCount(sql);
        	    }
        }
