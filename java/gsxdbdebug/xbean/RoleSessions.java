package xbean;

import xdb.Bean;

public abstract interface RoleSessions
  extends Bean
{
  public abstract RoleSessions copy();
  
  public abstract RoleSessions toData();
  
  public abstract RoleSessions toBean();
  
  public abstract RoleSessions toDataIf();
  
  public abstract RoleSessions toBeanIf();
  
  public abstract long getDiesessionid();
  
  public abstract long getProtectsessionid();
  
  public abstract void setDiesessionid(long paramLong);
  
  public abstract void setProtectsessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleSessions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */