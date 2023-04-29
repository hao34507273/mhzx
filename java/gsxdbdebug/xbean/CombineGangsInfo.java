package xbean;

import xdb.Bean;

public abstract interface CombineGangsInfo
  extends Bean
{
  public abstract CombineGangsInfo copy();
  
  public abstract CombineGangsInfo toData();
  
  public abstract CombineGangsInfo toBean();
  
  public abstract CombineGangsInfo toDataIf();
  
  public abstract CombineGangsInfo toBeanIf();
  
  public abstract long getTimestamp();
  
  public abstract boolean getIscombining();
  
  public abstract void setTimestamp(long paramLong);
  
  public abstract void setIscombining(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CombineGangsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */