package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleRideBag
  extends Bean
{
  public abstract RoleRideBag copy();
  
  public abstract RoleRideBag toData();
  
  public abstract RoleRideBag toBean();
  
  public abstract RoleRideBag toDataIf();
  
  public abstract RoleRideBag toBeanIf();
  
  public abstract int getMountid();
  
  public abstract Map<Integer, RideInfo> getRidemap();
  
  public abstract Map<Integer, RideInfo> getRidemapAsData();
  
  public abstract void setMountid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleRideBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */