package xbean;

import xdb.Bean;

public abstract interface UserRoamedInfo
  extends Bean
{
  public abstract UserRoamedInfo copy();
  
  public abstract UserRoamedInfo toData();
  
  public abstract UserRoamedInfo toBean();
  
  public abstract UserRoamedInfo toDataIf();
  
  public abstract UserRoamedInfo toBeanIf();
  
  public abstract long getInstanceid();
  
  public abstract int getRoam_type();
  
  public abstract void setInstanceid(long paramLong);
  
  public abstract void setRoam_type(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\UserRoamedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */