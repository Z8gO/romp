package zh.romp.userBiz;

import java.util.List;

import zh.romp.entity.ChartCount;
import zh.romp.entity.Collection;
import zh.romp.entity.Imagejian;
import zh.romp.entity.Plant;
import zh.romp.entity.User;
import zh.romp.pager.Expression;
import zh.romp.pager.PageBean;

public interface IUserBiz {
		public boolean userRegister(User user);
		
		public User userLogin(String userName,String passWord);
		
		public boolean userLoginOut(String uname,String lasttime,String newtime);
		
		public boolean uploadQuestion(Imagejian imagejian);
		
		public Imagejian fiandImagejianById(int id);
		
		public PageBean<Imagejian> findAllQuestion(List<Expression> list, int pc);
		
		public PageBean<Plant> findAllPlant(List<Expression> list, int pc);
		
		public PageBean<User> findSuccessUser(List<Expression> list, int pc);
		
		public boolean updateUserStatus(int uid);
		
		public boolean updateQueStatus(int imgid);
		
		public boolean delPlant(int pid);
		
		public Plant getOnePlant(int pid);
		
		public boolean addCollection(Collection coll);
		
		public boolean delCollection(int cid);
		
		public PageBean<Collection> myCollections(List<Expression> list, int pc);
		
		public Collection findCollectionByNameAndUid(String pname,String uid);
		
		public Plant getPlantByname(String name);
		
		public boolean updatePlant(Plant p);
		
		public List<Plant> indexPlants();
		
		public List<ChartCount>  plantChat();
		
		public List<ChartCount>  userChart();
}
