package zh.romp.entity;

/**
 * 
 * 类名:		Imagejian
 * 描述:		依图鉴定实体类
 * @author 	张煌
 * @date 	2016年4月11日 下午5:08:29
 *
 */
public class Imagejian {
	private int imgid ;// (主键)    
	private String imgpath;// (图片路径)
	private int uid;// (图片上传作者)
	private String uploadtime;//(上传时间)
	private String imgdemo;//(备注 允许空)
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getImgid() {
		return imgid;
	}
	public void setImgid(int imgid) {
		this.imgid = imgid;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}
	public String getImgdemo() {
		return imgdemo;
	}
	public void setImgdemo(String imgdemo) {
		this.imgdemo = imgdemo;
	}
	@Override
	public String toString() {
		return "Imagejian [imgid=" + imgid + ", imgpath=" + imgpath + ", uid="
				+ uid + ", uploadtime=" + uploadtime + ", imgdemo=" + imgdemo
				+ "]";
	}
	
	
}
