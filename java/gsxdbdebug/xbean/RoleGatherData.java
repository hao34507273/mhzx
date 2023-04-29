package xbean;

import xdb.Bean;

public abstract interface RoleGatherData
  extends Bean
{
  public abstract RoleGatherData copy();
  
  public abstract RoleGatherData toData();
  
  public abstract RoleGatherData toBean();
  
  public abstract RoleGatherData toDataIf();
  
  public abstract RoleGatherData toBeanIf();
  
  public abstract int getTotalsource();
  
  public abstract int getTotalcount();
  
  public abstract int getPoint();
  
  public abstract long getGatherinstanceid();
  
  public abstract long getGathersessionid();
  
  public abstract void setTotalsource(int paramInt);
  
  public abstract void setTotalcount(int paramInt);
  
  public abstract void setPoint(int paramInt);
  
  public abstract void setGatherinstanceid(long paramLong);
  
  public abstract void setGathersessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleGatherData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */