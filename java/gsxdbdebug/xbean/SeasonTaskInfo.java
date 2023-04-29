package xbean;

import xdb.Bean;

public abstract interface SeasonTaskInfo
  extends Bean
{
  public abstract SeasonTaskInfo copy();
  
  public abstract SeasonTaskInfo toData();
  
  public abstract SeasonTaskInfo toBean();
  
  public abstract SeasonTaskInfo toDataIf();
  
  public abstract SeasonTaskInfo toBeanIf();
  
  public abstract SeasonSingleTaskInfo getSingleinfo();
  
  public abstract SeasonMultiTaskInfo getMultiinfo();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SeasonTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */