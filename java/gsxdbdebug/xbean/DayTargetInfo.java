package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface DayTargetInfo
  extends Bean
{
  public abstract DayTargetInfo copy();
  
  public abstract DayTargetInfo toData();
  
  public abstract DayTargetInfo toBean();
  
  public abstract DayTargetInfo toDataIf();
  
  public abstract DayTargetInfo toBeanIf();
  
  public abstract long getLastcleartime();
  
  public abstract Map<Integer, TargetInfo> getTargets();
  
  public abstract Map<Integer, TargetInfo> getTargetsAsData();
  
  public abstract void setLastcleartime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DayTargetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */