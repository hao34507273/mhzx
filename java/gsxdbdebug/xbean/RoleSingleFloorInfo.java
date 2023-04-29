package xbean;

import xdb.Bean;

public abstract interface RoleSingleFloorInfo
  extends Bean
{
  public abstract RoleSingleFloorInfo copy();
  
  public abstract RoleSingleFloorInfo toData();
  
  public abstract RoleSingleFloorInfo toBean();
  
  public abstract RoleSingleFloorInfo toDataIf();
  
  public abstract RoleSingleFloorInfo toBeanIf();
  
  public abstract int getUsedtime();
  
  public abstract void setUsedtime(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleSingleFloorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */