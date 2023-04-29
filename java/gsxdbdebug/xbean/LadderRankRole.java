package xbean;

import xdb.Bean;

public abstract interface LadderRankRole
  extends Bean
{
  public abstract LadderRankRole copy();
  
  public abstract LadderRankRole toData();
  
  public abstract LadderRankRole toBean();
  
  public abstract LadderRankRole toDataIf();
  
  public abstract LadderRankRole toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract void setRoleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LadderRankRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */