package xbean;

import xdb.Bean;

public abstract interface QMHWRankRole
  extends Bean
{
  public abstract QMHWRankRole copy();
  
  public abstract QMHWRankRole toData();
  
  public abstract QMHWRankRole toBean();
  
  public abstract QMHWRankRole toDataIf();
  
  public abstract QMHWRankRole toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract int getScore();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setScore(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\QMHWRankRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */