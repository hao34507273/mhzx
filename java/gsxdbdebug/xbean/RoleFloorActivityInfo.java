package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleFloorActivityInfo
  extends Bean
{
  public abstract RoleFloorActivityInfo copy();
  
  public abstract RoleFloorActivityInfo toData();
  
  public abstract RoleFloorActivityInfo toBean();
  
  public abstract RoleFloorActivityInfo toDataIf();
  
  public abstract RoleFloorActivityInfo toBeanIf();
  
  public abstract Map<Integer, RoleFloorInfo> getActivityinfo();
  
  public abstract Map<Integer, RoleFloorInfo> getActivityinfoAsData();
  
  public abstract Map<Integer, Integer> getHelpdata();
  
  public abstract Map<Integer, Integer> getHelpdataAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleFloorActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */