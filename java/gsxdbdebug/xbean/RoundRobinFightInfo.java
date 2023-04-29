package xbean;

import xdb.Bean;

public abstract interface RoundRobinFightInfo
  extends Bean
{
  public abstract RoundRobinFightInfo copy();
  
  public abstract RoundRobinFightInfo toData();
  
  public abstract RoundRobinFightInfo toBean();
  
  public abstract RoundRobinFightInfo toDataIf();
  
  public abstract RoundRobinFightInfo toBeanIf();
  
  public abstract long getCorps_a_id();
  
  public abstract long getCorps_b_id();
  
  public abstract int getState();
  
  public abstract long getWatch_roleid();
  
  public abstract long getRecordid();
  
  public abstract long getCorps_a_watch_roleid();
  
  public abstract long getCorps_b_watch_roleid();
  
  public abstract void setCorps_a_id(long paramLong);
  
  public abstract void setCorps_b_id(long paramLong);
  
  public abstract void setState(int paramInt);
  
  public abstract void setWatch_roleid(long paramLong);
  
  public abstract void setRecordid(long paramLong);
  
  public abstract void setCorps_a_watch_roleid(long paramLong);
  
  public abstract void setCorps_b_watch_roleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoundRobinFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */