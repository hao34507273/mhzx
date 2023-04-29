package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface DaySessionInfo
  extends Bean
{
  public abstract DaySessionInfo copy();
  
  public abstract DaySessionInfo toData();
  
  public abstract DaySessionInfo toBean();
  
  public abstract DaySessionInfo toDataIf();
  
  public abstract DaySessionInfo toBeanIf();
  
  public abstract Map<Integer, Long> getSessionids();
  
  public abstract Map<Integer, Long> getSessionidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DaySessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */