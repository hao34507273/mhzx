package xbean;

import xdb.Bean;

public abstract interface RoleGrabSessions
  extends Bean
{
  public abstract RoleGrabSessions copy();
  
  public abstract RoleGrabSessions toData();
  
  public abstract RoleGrabSessions toBean();
  
  public abstract RoleGrabSessions toDataIf();
  
  public abstract RoleGrabSessions toBeanIf();
  
  public abstract long getGrabsessionid();
  
  public abstract void setGrabsessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleGrabSessions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */