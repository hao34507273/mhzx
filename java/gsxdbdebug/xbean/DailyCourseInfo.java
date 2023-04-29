package xbean;

import xdb.Bean;

public abstract interface DailyCourseInfo
  extends Bean
{
  public abstract DailyCourseInfo copy();
  
  public abstract DailyCourseInfo toData();
  
  public abstract DailyCourseInfo toBean();
  
  public abstract DailyCourseInfo toDataIf();
  
  public abstract DailyCourseInfo toBeanIf();
  
  public abstract long getLast_time();
  
  public abstract int getNum();
  
  public abstract void setLast_time(long paramLong);
  
  public abstract void setNum(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DailyCourseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */