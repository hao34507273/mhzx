package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface DayTargetData
  extends Bean
{
  public abstract DayTargetData copy();
  
  public abstract DayTargetData toData();
  
  public abstract DayTargetData toBean();
  
  public abstract DayTargetData toDataIf();
  
  public abstract DayTargetData toBeanIf();
  
  public abstract Map<Integer, TargetData> getTargets();
  
  public abstract Map<Integer, TargetData> getTargetsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DayTargetData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */