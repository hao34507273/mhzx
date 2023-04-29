package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleIndianaActivityInfo
  extends Bean
{
  public abstract RoleIndianaActivityInfo copy();
  
  public abstract RoleIndianaActivityInfo toData();
  
  public abstract RoleIndianaActivityInfo toBean();
  
  public abstract RoleIndianaActivityInfo toDataIf();
  
  public abstract RoleIndianaActivityInfo toBeanIf();
  
  public abstract Map<Integer, RoleIndianaTurnInfo> getTurn_infos();
  
  public abstract Map<Integer, RoleIndianaTurnInfo> getTurn_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleIndianaActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */