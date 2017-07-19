package zh.romp.entity;
/**
 * 
 * 类名:		Identity
 * 描述:		身份实体类
 * @author 	张煌
 * @date 	2016年4月11日 下午5:09:00
 *
 */
public class Identity {

	private int iid;//(id)
	private String iname;//(身份名称)	
	private String idemo;//(备注 允许空)  (研究人员、教学人员、管理员、感兴趣的人员)
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getIdemo() {
		return idemo;
	}
	public void setIdemo(String idemo) {
		this.idemo = idemo;
	}
}
