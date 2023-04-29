package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleAxeActivityInfo
  extends Bean
{
  public abstract RoleAxeActivityInfo copy();
  
  public abstract RoleAxeActivityInfo toData();
  
  public abstract RoleAxeActivityInfo toBean();
  
  public abstract RoleAxeActivityInfo toDataIf();
  
  public abstract RoleAxeActivityInfo toBeanIf();
  
  public abstract Map<Integer, AxeActivityInfo> getAxe_activity_infos();
  
  public abstract Map<Integer, AxeActivityInfo> getAxe_activity_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleAxeActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */