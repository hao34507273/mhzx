package xbean;

import xdb.Bean;

public abstract interface ParaseleneRankRole
  extends Bean
{
  public abstract ParaseleneRankRole copy();
  
  public abstract ParaseleneRankRole toData();
  
  public abstract ParaseleneRankRole toBean();
  
  public abstract ParaseleneRankRole toDataIf();
  
  public abstract ParaseleneRankRole toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract void setRoleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ParaseleneRankRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */