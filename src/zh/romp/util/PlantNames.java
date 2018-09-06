/*
 * 项目名:      romp系统
 * 文件名:      PlantNames.java
 * 类名:        PlantNames
 */
package zh.romp.util;

import java.util.HashMap;

/**
 * 类名:		PlantNames
 * 描述:		TODO
 * @author 	Administrator
 * @date 	2016年5月3日 下午4:28:28
 *
 */
public class PlantNames {
    public HashMap<Integer ,String> InitPlantNames(){
        HashMap<Integer, String> plantNames=new HashMap<Integer ,String>();
        plantNames.put(1,"杨柳科");
        plantNames.put(2,"桦木科");
        plantNames.put(3,"壳斗科");
        plantNames.put(4,"马尾树科");
        plantNames.put(5,"榆科");
        plantNames.put(6,"杜仲科");
        plantNames.put(7,"桑科");
        plantNames.put(8,"荨麻科");
        plantNames.put(9,"十齿花科");
        plantNames.put(10,"檀香科");
        plantNames.put(11,"桑寄生科");
        plantNames.put(12,"蓼科");
        plantNames.put(13,"商陆科");
        plantNames.put(14,"马齿苋科");
        plantNames.put(15,"石松科");
        plantNames.put(16,"苋科");
        plantNames.put(17,"木兰科");
        plantNames.put(18,"五味子科");
        plantNames.put(19,"樟科");
        plantNames.put(20,"毛茛科");
        plantNames.put(21,"小檗科");
        plantNames.put(22,"木通科");
        plantNames.put(23,"防己科");
        plantNames.put(24,"睡莲科");
        plantNames.put(25,"三白草科");
        plantNames.put(26,"金粟兰科");
        plantNames.put(27,"马兜铃科");
        plantNames.put(28,"芍药科");
        plantNames.put(29,"藤黄科");
        plantNames.put(30,"罂粟科");
        plantNames.put(31,"十字花科");
        plantNames.put(32,"金缕梅科");
        plantNames.put(33,"景天科");
        plantNames.put(34,"虎耳草科");
        plantNames.put(35,"蔷薇科");
        plantNames.put(36,"豆科");
        plantNames.put(37,"蒺藜科");
        plantNames.put(38,"亚麻科");
        plantNames.put(39,"大戟科");
        plantNames.put(40,"芸香科");
        plantNames.put(41,"苦木科");
        plantNames.put(42,"橄榄科");
        plantNames.put(43,"楝科");
        plantNames.put(44,"远志科");
        plantNames.put(45,"漆树科");
        plantNames.put(46,"无患子科");
        plantNames.put(47,"凤仙花科");
        plantNames.put(48,"冬青科");
        plantNames.put(49,"卫矛科");
        plantNames.put(50,"省沽油");
        plantNames.put(51,"鼠李科");
        plantNames.put(52,"葡萄科");
        plantNames.put(53,"锦葵科");
        plantNames.put(54,"椴树科");
        plantNames.put(55,"木棉科");
        plantNames.put(56,"梧桐科");
        plantNames.put(57,"瑞香科");
        plantNames.put(58,"胡颓子科");
        plantNames.put(59,"堇菜科");
        plantNames.put(60,"葫芦科");
        plantNames.put(61,"桃金娘科");
        plantNames.put(62,"使君子科");
        plantNames.put(63,"锁阳科");
        plantNames.put(64,"五加科");
        plantNames.put(65,"山茱萸科");
        plantNames.put(66,"伞形科");
        plantNames.put(67,"杜鹃花科");
        plantNames.put(68,"紫金牛科");
        plantNames.put(69,"报春花科");
        plantNames.put(70,"柿树科");
        plantNames.put(71,"安息香科");
        plantNames.put(72,"马钱科");
        plantNames.put(73,"龙胆科");
        plantNames.put(74,"夹竹桃科");
        plantNames.put(75,"萝藦科");
        plantNames.put(76,"茜草科");
        plantNames.put(77,"旋花科");
        plantNames.put(78,"紫草科");
        plantNames.put(79,"马鞭草科");
        plantNames.put(80,"唇形科");
        plantNames.put(81,"茄科");
        plantNames.put(82,"玄参科");
        plantNames.put(83,"紫葳科");
        plantNames.put(84,"爵床科");
        plantNames.put(85,"胡麻科");
        plantNames.put(86,"苦苣苔科");
        plantNames.put(87,"车前草");
        plantNames.put(88,"忍冬科");
        plantNames.put(89,"败酱科");
        plantNames.put(90,"桔梗科");
        plantNames.put(91,"菊科");
        plantNames.put(92,"泽泻科");
        plantNames.put(93,"百合科");
        plantNames.put(94,"百部科");
        plantNames.put(95,"仙茅科");
        plantNames.put(96,"石蒜科");
        plantNames.put(97,"薯蓣科");
        plantNames.put(98,"鸢尾科");
        plantNames.put(99,"灯心草科");
        plantNames.put(100,"凤梨科");
        plantNames.put(101,"鸭跖草科");
        plantNames.put(102,"禾本科");
        plantNames.put(103,"棕榈科");
        plantNames.put(104,"天南星科");
        plantNames.put(105,"黑三棱科");
        plantNames.put(106,"香蒲科");
        plantNames.put(107,"莎草科");
        plantNames.put(108,"姜科");
        plantNames.put(109,"兰科");
        plantNames.put(110,"柏科");
        plantNames.put(111,"胡椒科");
    return  plantNames;
   }
    public String getPlantName(String id){
        HashMap<Integer, String> pMap= this.InitPlantNames();
        int index=Integer.parseInt(id);
        return pMap.get(index);
    }
    
}
