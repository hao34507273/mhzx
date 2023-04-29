package xbean;

import xdb.Bean;

public abstract interface BigBossActivity
  extends Bean
{
  public abstract BigBossActivity copy();
  
  public abstract BigBossActivity toData();
  
  public abstract BigBossActivity toBean();
  
  public abstract BigBossActivity toDataIf();
  
  public abstract BigBossActivity toBeanIf();
  
  public abstract long getStarttime();
  
  public abstract long getEndtime();
  
  public abstract int getMonsterid();
  
  public abstract int getReserved();
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setEndtime(long paramLong);
  
  public abstract void setMonsterid(int paramInt);
  
  public abstract void setReserved(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BigBossActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */