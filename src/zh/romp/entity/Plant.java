package zh.romp.entity;
/**
 * 
 * 类名:		Plant
 * 描述:		植物
 * @author 	张煌
 * @date 	2016年4月11日 下午5:09:59
 *
 */
public class Plant {
	private int pid;  //(主键)      
	private String zwword;  //（中文词名）   
	private String ywword;  // （英文词名）  
	private String ldword;  //	(拉丁文名)  
	private String picpath;  // (图片路径)
	private String xw;  //（性味）
	private String ke;//属于什么科
	private String gj;  //（归经）
	private String zzgn;  //（主治功能）
	private String yfyl;  //（用法用量）
	
	private String yybw;//（药用部位）
	private int pimguid ;  //(图片上传作者)
	private int perfectuid ;  //(完善信息作者)
	private String uploadtime;  //(上传时间)
	private String pdemo;  //(备注 允许空)
	private String shuiyinstatus;
	
	
	public String getYfyl() {
		return yfyl;
	}
	public void setYfyl(String yfyl) {
		this.yfyl = yfyl;
	}
	public String getShuiyinstatus() {
		return shuiyinstatus;
	}
	public void setShuiyinstatus(String shuiyinstatus) {
		this.shuiyinstatus = shuiyinstatus;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getZwword() {
		return zwword;
	}
	public void setZwword(String zwword) {
		this.zwword = zwword;
	}
	public String getYwword() {
		return ywword;
	}
	public void setYwword(String ywword) {
		this.ywword = ywword;
	}
	public String getLdword() {
		return ldword;
	}
	public void setLdword(String ldword) {
		this.ldword = ldword;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public String getXw() {
		return xw;
	}
	public void setXw(String xw) {
		this.xw = xw;
	}
	public String getGj() {
		return gj;
	}
	public void setGj(String gj) {
		this.gj = gj;
	}
	public String getZzgn() {
		return zzgn;
	}
	public void setZzgn(String zzgn) {
		this.zzgn = zzgn;
	}
	
	public String getYybw() {
		return yybw;
	}
	public void setYybw(String yybw) {
		this.yybw = yybw;
	}
	public int getPimguid() {
		return pimguid;
	}
	public void setPimguid(int pimguid) {
		this.pimguid = pimguid;
	}
	public int getPerfectuid() {
		return perfectuid;
	}
	public void setPerfectuid(int perfectuid) {
		this.perfectuid = perfectuid;
	}
	public String getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}
	public String getPdemo() {
		return pdemo;
	}
	public void setPdemo(String pdemo) {
		this.pdemo = pdemo;
	}
	public String getKe() {
		return ke;
	}
	public void setKe(String ke) {
		this.ke = ke;
	}
	@Override
	public String toString() {
		return "Plant [pid=" + pid + ", zwword=" + zwword + ", ywword="
				+ ywword + ", ldword=" + ldword + ", picpath=" + picpath
				+ ", xw=" + xw + ", ke=" + ke + ", gj=" + gj + ", zzgn=" + zzgn
				+ ", usage=" + yfyl + ", yybw=" + yybw + ", pimguid="
				+ pimguid + ", perfectuid=" + perfectuid + ", uploadtime="
				+ uploadtime + ", pdemo=" + pdemo + "]";
	}
	
}
