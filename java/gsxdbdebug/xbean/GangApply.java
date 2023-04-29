package xbean;

import xdb.Bean;

public abstract interface GangApply
  extends Bean
{
  public abstract GangApply copy();
  
  public abstract GangApply toData();
  
  public abstract GangApply toBean();
  
  public abstract GangApply toDataIf();
  
  public abstract GangApply toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract long getInviterid();
  
  public abstract long getTimestamp();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setInviterid(long paramLong);
  
  public abstract void setTimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangApply.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */