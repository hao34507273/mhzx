package xbean;

import xdb.Bean;

public abstract interface MondayFree
  extends Bean
{
  public abstract MondayFree copy();
  
  public abstract MondayFree toData();
  
  public abstract MondayFree toBean();
  
  public abstract MondayFree toDataIf();
  
  public abstract MondayFree toBeanIf();
  
  public abstract long getSunday_award_time();
  
  public abstract long getMonday_award_time();
  
  public abstract long getFinish_shimen_time();
  
  public abstract long getFinish_baotu_time();
  
  public abstract void setSunday_award_time(long paramLong);
  
  public abstract void setMonday_award_time(long paramLong);
  
  public abstract void setFinish_shimen_time(long paramLong);
  
  public abstract void setFinish_baotu_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MondayFree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */