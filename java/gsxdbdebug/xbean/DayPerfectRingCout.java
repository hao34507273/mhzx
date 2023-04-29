package xbean;

import xdb.Bean;

public abstract interface DayPerfectRingCout
  extends Bean
{
  public abstract DayPerfectRingCout copy();
  
  public abstract DayPerfectRingCout toData();
  
  public abstract DayPerfectRingCout toBean();
  
  public abstract DayPerfectRingCout toDataIf();
  
  public abstract DayPerfectRingCout toBeanIf();
  
  public abstract boolean getHasgiveup();
  
  public abstract int getCurrentring();
  
  public abstract long getCleantime();
  
  public abstract int getShimencount();
  
  public abstract int getReservedexp();
  
  public abstract int getExchangecount();
  
  public abstract void setHasgiveup(boolean paramBoolean);
  
  public abstract void setCurrentring(int paramInt);
  
  public abstract void setCleantime(long paramLong);
  
  public abstract void setShimencount(int paramInt);
  
  public abstract void setReservedexp(int paramInt);
  
  public abstract void setExchangecount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DayPerfectRingCout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */