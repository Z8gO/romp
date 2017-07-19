package zh.romp.entity;
/**
 * 
 * 类名:		Collection
 * 描述:		收藏实体类
 * @author 	张煌
 * @date 	2016年4月11日 下午5:09:28
 *
 */
public class Collection {
	private int cid;// (主键)
	private int pid;// (植物name  )
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	private String pname;// (植物name  )
	private int cuid;// (收藏人id)
	private String cdate;// 	(收藏时间)

	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCuid() {
		return cuid;
	}
	public void setCuid(int cuid) {
		this.cuid = cuid;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
	
}
