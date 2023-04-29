package xbean;

import xdb.Bean;

public abstract interface RolePKTimerInformation
  extends Bean
{
  public abstract RolePKTimerInformation copy();
  
  public abstract RolePKTimerInformation toData();
  
  public abstract RolePKTimerInformation toBean();
  
  public abstract RolePKTimerInformation toDataIf();
  
  public abstract RolePKTimerInformation toBeanIf();
  
  public abstract long getPk_mode_session_id();
  
  public abstract long getProtection_session_id();
  
  public abstract long getForce_protection_session_id();
  
  public abstract void setPk_mode_session_id(long paramLong);
  
  public abstract void setProtection_session_id(long paramLong);
  
  public abstract void setForce_protection_session_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RolePKTimerInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */