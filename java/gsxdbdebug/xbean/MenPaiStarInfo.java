package xbean;

import xdb.Bean;

public abstract interface MenPaiStarInfo
  extends Bean
{
  public abstract MenPaiStarInfo copy();
  
  public abstract MenPaiStarInfo toData();
  
  public abstract MenPaiStarInfo toBean();
  
  public abstract MenPaiStarInfo toDataIf();
  
  public abstract MenPaiStarInfo toBeanIf();
  
  public abstract boolean getFinished();
  
  public abstract long getStart_time();
  
  public abstract long getEnd_time();
  
  public abstract long getChampion();
  
  public abstract void setFinished(boolean paramBoolean);
  
  public abstract void setStart_time(long paramLong);
  
  public abstract void setEnd_time(long paramLong);
  
  public abstract void setChampion(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MenPaiStarInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */