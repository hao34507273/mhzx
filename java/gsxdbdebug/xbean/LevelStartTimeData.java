package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface LevelStartTimeData
  extends Bean
{
  public abstract LevelStartTimeData copy();
  
  public abstract LevelStartTimeData toData();
  
  public abstract LevelStartTimeData toBean();
  
  public abstract LevelStartTimeData toDataIf();
  
  public abstract LevelStartTimeData toBeanIf();
  
  public abstract Map<Integer, Long> getServerlevel2starttime();
  
  public abstract Map<Integer, Long> getServerlevel2starttimeAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LevelStartTimeData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */