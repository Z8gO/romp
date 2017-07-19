package zh.romp.dao;

import java.util.List;

import zh.romp.entity.ChartCount;
import zh.romp.entity.User;
import zh.romp.pager.Expression;
import zh.romp.pager.PageBean;

public interface IUserDao {
		public boolean findUser(String username);
		
		public int insert(User user);
		
		public User get(String userName,String passWord);
		
		public boolean update(String uname,String key,String newdate);
		
		public PageBean<User>  findByCriteria(List<Expression> exprList,int pc);
		
		public User findUserById(int uid);
		
		public boolean updateUserStatus(int uid,String newStatus);
		
		public List<ChartCount>  userChart();
}
