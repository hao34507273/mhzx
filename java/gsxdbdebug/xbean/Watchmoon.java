package xbean;

import xdb.Bean;

public abstract interface Watchmoon
  extends Bean
{
  public abstract Watchmoon copy();
  
  public abstract Watchmoon toData();
  
  public abstract Watchmoon toBean();
  
  public abstract Watchmoon toDataIf();
  
  public abstract Watchmoon toBeanIf();
  
  public abstract long getInvitetime();
  
  public abstract int getMapid();
  
  public abstract boolean getIscouple();
  
  public abstract long getPartenerroleid();
  
  public abstract long getGroupid();
  
  public abstract long getSessionid();
  
  public abstract void setInvitetime(long paramLong);
  
  public abstract void setMapid(int paramInt);
  
  public abstract void setIscouple(boolean paramBoolean);
  
  public abstract void setPartenerroleid(long paramLong);
  
  public abstract void setGroupid(long paramLong);
  
  public abstract void setSessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Watchmoon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */