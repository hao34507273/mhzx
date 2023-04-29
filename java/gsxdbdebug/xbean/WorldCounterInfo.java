package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface WorldCounterInfo
  extends Bean
{
  public abstract WorldCounterInfo copy();
  
  public abstract WorldCounterInfo toData();
  
  public abstract WorldCounterInfo toBean();
  
  public abstract WorldCounterInfo toDataIf();
  
  public abstract WorldCounterInfo toBeanIf();
  
  public abstract Map<Integer, Long> getIndex2times();
  
  public abstract Map<Integer, Long> getIndex2timesAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WorldCounterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */