package xbean;

import xdb.Bean;

public abstract interface Jingji
  extends Bean
{
  public abstract Jingji copy();
  
  public abstract Jingji toData();
  
  public abstract Jingji toBean();
  
  public abstract Jingji toDataIf();
  
  public abstract Jingji toBeanIf();
  
  public abstract long getSeasonstarttime();
  
  public abstract long getRankrefreshtime();
  
  public abstract int getTotalcount();
  
  public abstract int getMerge_clear();
  
  public abstract void setSeasonstarttime(long paramLong);
  
  public abstract void setRankrefreshtime(long paramLong);
  
  public abstract void setTotalcount(int paramInt);
  
  public abstract void setMerge_clear(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Jingji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */