package zh.romp.userBiz.impl;

import java.util.List;

import org.apache.log4j.Logger;

import zh.romp.dao.ICollectionDao;
import zh.romp.dao.IPlantDao;
import zh.romp.dao.ITuJianPlantDao;
import zh.romp.dao.IUserDao;
import zh.romp.dao.impl.CollectionDao;
import zh.romp.dao.impl.PlantDao;
import zh.romp.dao.impl.TuJianPlantDao;
import zh.romp.dao.impl.UserDao;
import zh.romp.entity.ChartCount;
import zh.romp.entity.Collection;
import zh.romp.entity.Imagejian;
import zh.romp.entity.Plant;
import zh.romp.entity.User;
import zh.romp.pager.Expression;
import zh.romp.pager.PageBean;
import zh.romp.userBiz.IUserBiz;

public class UserBiz implements IUserBiz{
			IUserDao userDao=new UserDao();
			IPlantDao plantDao=new PlantDao();
			ITuJianPlantDao tuJianPlantDao=new TuJianPlantDao();
			ICollectionDao collectionDao=new CollectionDao();
			private static Logger logger =  Logger.getLogger(UserBiz.class);  
	@Override
	public boolean userRegister(User user) {
			int flag = userDao.insert(user);
		if(1==flag){
			return true;
		}else{
		return false;
	}
	}
	@Override
	public User userLogin(String userName, String passWord) {
		User user = userDao.get(userName, passWord);
		return user;
	}
	@Override
	public boolean userLoginOut(String uname, String lasttime, String newtime) {
		boolean loginout = userDao.update(uname, lasttime, newtime);
		return loginout;
	}
	@Override
	public boolean uploadQuestion(Imagejian imagejian) {
		boolean flag = tuJianPlantDao.insert(imagejian);
		return flag;
	}
	@Override
	public PageBean<Imagejian> findAllQuestion(List<Expression> exprList, int pc) {
		
		PageBean<Imagejian> pageBean = tuJianPlantDao.findByCriteria(exprList, pc);
		return pageBean;
	}
	@Override
	public PageBean<User> findSuccessUser(List<Expression> list, int pc) {
		PageBean<User> pageBean = userDao.findByCriteria(list, pc);
		return pageBean;
	}
	@Override
	public boolean updateUserStatus(int uid) {
		User user = userDao.findUserById(uid);
		if("no".equals(user.getStatus())){
			return userDao.updateUserStatus(uid, "yes");
		}
		if("yes".equals(user.getStatus())){
			return userDao.updateUserStatus(uid, "no");
		}
		else	{
			logger.info(user.getUname()+" 状态不是数据库规定的状态!");
			return false;
		}
	}
	@Override
	public boolean updateQueStatus(int imgid) {
		
		return tuJianPlantDao.updateQueStatus(imgid);
	}
	
	
	@Override
	public PageBean<Plant> findAllPlant(List<Expression> list, int pc) {
		PageBean<Plant> pageBean = plantDao.findByCriteria(list, pc);
		return pageBean;
	}
	
	/**
	 * 删除植物
	 */
	@Override
	public boolean delPlant(int pid) {
		return plantDao.del(pid);
	}
	@Override
	public Plant getOnePlant(int pid) {
		return plantDao.getPlantById(pid);
	}
	@Override
	public Imagejian fiandImagejianById(int id) {
		return tuJianPlantDao.findById(id);
	}
	@Override
	public boolean addCollection(Collection coll) {
		
		return collectionDao.insert(coll);
	}
	@Override
	public boolean delCollection(int cid) {
		
		return collectionDao.delete(cid);
	}
	@Override
	public PageBean<Collection> myCollections(List<Expression> list, int pc) {
		
		return collectionDao.findByCriteria(list, pc);
	}
	@Override
	public Collection findCollectionByNameAndUid(String pname,String uid) {
		
		return collectionDao.findByNameAndUid(pname,uid);
	}
	@Override
	public Plant getPlantByname(String name) {		
		return plantDao.getPlantByname(name);
	}
    /* (non-Javadoc)
     * @see zh.romp.userBiz.IUserBiz#updatePlant(zh.romp.entity.Plant)
     */
    @Override
    public boolean updatePlant(Plant p) {
        
        return plantDao.updatePlant(p);
    }
	/* (non-Javadoc)
	 * @see zh.romp.userBiz.IUserBiz#indexPlants()
	 */
    @Override
    public List<Plant> indexPlants() {
	   
	    return plantDao.indexPlants();
    }
	/* (non-Javadoc)
	 * @see zh.romp.userBiz.IUserBiz#plantChat()
	 */
    @Override
    public List<ChartCount> plantChat() {
	    // TODO Auto-generated method stub
	    return plantDao.plantChat();
    }
	/* (non-Javadoc)
	 * @see zh.romp.userBiz.IUserBiz#userChart()
	 */
    @Override
    public List<ChartCount> userChart() {
	    // TODO Auto-generated method stub
	    return userDao.userChart();
    }

}
