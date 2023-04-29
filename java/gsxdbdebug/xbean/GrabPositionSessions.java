package xbean;

import xdb.Bean;

public abstract interface GrabPositionSessions
  extends Bean
{
  public abstract GrabPositionSessions copy();
  
  public abstract GrabPositionSessions toData();
  
  public abstract GrabPositionSessions toBean();
  
  public abstract GrabPositionSessions toDataIf();
  
  public abstract GrabPositionSessions toBeanIf();
  
  public abstract long getProtectsessionid();
  
  public abstract void setProtectsessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GrabPositionSessions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */