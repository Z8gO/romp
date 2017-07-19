package zh.romp.pager;
/**
 * 
 * 类名:		Expression
 * 描述:      这个类是用来设置一些超链接的类		
 *              目前没有还用到的，但是如果后期
 *              进行更加高大上的功能的话，会有
 *              用的！你懂得！
 * @author 	Administrator
 * @date 	2016年4月11日 下午4:31:50
 *
 */
public class Expression {
	private String name;
	private String operator;
	private String value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Expression [name=" + name + ", operator=" + operator
				+ ", value=" + value + "]";
	}
	public Expression() {
		super();
	}
	public Expression(String name, String operator, String value) {
		super();
		this.name = name;
		this.operator = operator;
		this.value = value;
	}
	

}
