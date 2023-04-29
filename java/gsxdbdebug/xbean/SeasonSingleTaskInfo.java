package xbean;

import xdb.Bean;

public abstract interface SeasonSingleTaskInfo
  extends Bean
{
  public abstract SeasonSingleTaskInfo copy();
  
  public abstract SeasonSingleTaskInfo toData();
  
  public abstract SeasonSingleTaskInfo toBean();
  
  public abstract SeasonSingleTaskInfo toDataIf();
  
  public abstract SeasonSingleTaskInfo toBeanIf();
  
  public abstract boolean getIsperfect();
  
  public abstract void setIsperfect(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SeasonSingleTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */