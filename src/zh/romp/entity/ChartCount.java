/*
 * 项目名:      **系统
 * 文件名:      ChartNumber.java
 * 类名:        ChartNumber
 *
 */
package zh.romp.entity;

/**
 * 类名:		ChartNumber
 * 描述:		TODO
 * @author 	Administrator
 * @date 	2016年5月9日 下午5:44:11
 *
 */
public class ChartCount {

		private int chartKeys;
		private int number;
		


		public int getChartKeys() {
			return chartKeys;
		}

		public void setChartKeys(int chartKeys) {
			this.chartKeys = chartKeys;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		@Override
        public String toString() {
	        return "ChartCount [chartKeys=" + chartKeys + ", number=" + number + "]";
        }
	
		
}
