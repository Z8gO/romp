package zh.romp.entity;
/**
 * 
 * 类名:		User
 * 描述:		用户实体类
 * @author 	张煌
 * @date 	2016年4月11日 下午5:09:47
 *
 */
public class User {
	private int uid;    // （id）
	private String uname ;//(用户名)
	private String password ;//(密码)
	private String workunit;//（工作单位）	
	private String email;//    (邮箱)
	private String lasttime ;//(上一次访问时间)
	private int iid;//(外键-引用identity表的主键)
	private String udemo;// （备注  允许空）
	private String status;
	
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWorkunit() {
		return workunit;
	}
	public void setWorkunit(String workunit) {
		this.workunit = workunit;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLasttime() {
		return lasttime;
	}
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public String getUdemo() {
		return udemo;
	}
	public void setUdemo(String udemo) {
		this.udemo = udemo;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", password="
				+ password + ", workunit=" + workunit + ", email=" + email
				+ ", lasttime=" + lasttime + ", iid=" + iid + ", udemo="
				+ udemo + ", status=" + status + "]";
	}
	
	
	
}
