package zh.romp.pager;

import java.util.List;
/**
 * 分页Bean，在各层之间传递
 * 类        名:PageBean.java
 * 作        者:	张	煌<br>
 * 作        用:   <br>
 * 创建时间:2015年11月3日下午7:42:25
 */
public class PageBean<T> {
	
	private int pc;//当前页
	private int tr;//总记录数
	private int ps;//每页记录数
	private String url;//请求路径
	private List<T> list;
	
	//计算总页数
	public int getTp(){
		int tp=tr / ps;
		return tr % ps==0 ? tp : tp+1;
	}
	
	
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	

}
