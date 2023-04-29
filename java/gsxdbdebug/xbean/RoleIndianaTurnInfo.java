package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleIndianaTurnInfo
  extends Bean
{
  public abstract RoleIndianaTurnInfo copy();
  
  public abstract RoleIndianaTurnInfo toData();
  
  public abstract RoleIndianaTurnInfo toBean();
  
  public abstract RoleIndianaTurnInfo toDataIf();
  
  public abstract RoleIndianaTurnInfo toBeanIf();
  
  public abstract Map<Integer, RoleIndianaNumberInfo> getNumber_infos();
  
  public abstract Map<Integer, RoleIndianaNumberInfo> getNumber_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleIndianaTurnInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */