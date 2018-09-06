/*
 * 项目名:      romp系统
 * 文件名:      PlantNames.java
 * 类名:        PlantNames
 *
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
public class UserRoles {
    public HashMap<Integer ,String> InitRoles(){
        HashMap<Integer, String> roles=new HashMap<Integer ,String>();
        roles.put(1,"感兴趣的人员");
        roles.put(2,"管理员");
        roles.put(3,"教学人员");
        roles.put(4,"研究人员");
     
    return  roles;
   }
    public String getR(int index){
        HashMap<Integer, String> pMap= this.InitRoles();
      return pMap.get(index);
    }
  
}
