package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface RoleFloorInfo
  extends Bean
{
  public abstract RoleFloorInfo copy();
  
  public abstract RoleFloorInfo toData();
  
  public abstract RoleFloorInfo toBean();
  
  public abstract RoleFloorInfo toDataIf();
  
  public abstract RoleFloorInfo toBeanIf();
  
  public abstract Map<Integer, RoleSingleFloorInfo> getFloor2info();
  
  public abstract Map<Integer, RoleSingleFloorInfo> getFloor2infoAsData();
  
  public abstract Set<Integer> getHistoryfloors();
  
  public abstract Set<Integer> getHistoryfloorsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleFloorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */