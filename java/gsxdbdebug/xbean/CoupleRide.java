package xbean;

import xdb.Bean;

public abstract interface CoupleRide
  extends Bean
{
  public abstract CoupleRide copy();
  
  public abstract CoupleRide toData();
  
  public abstract CoupleRide toBean();
  
  public abstract CoupleRide toDataIf();
  
  public abstract CoupleRide toBeanIf();
  
  public abstract long getRolea();
  
  public abstract long getRoleb();
  
  public abstract void setRolea(long paramLong);
  
  public abstract void setRoleb(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CoupleRide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */