package xbean;

import xdb.Bean;

public abstract interface RideInfo
  extends Bean
{
  public abstract RideInfo copy();
  
  public abstract RideInfo toData();
  
  public abstract RideInfo toBean();
  
  public abstract RideInfo toDataIf();
  
  public abstract RideInfo toBeanIf();
  
  public abstract int getRidecfgid();
  
  public abstract int getColorid();
  
  public abstract void setRidecfgid(int paramInt);
  
  public abstract void setColorid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RideInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */