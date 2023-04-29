package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ChivalryDayInfo
  extends Bean
{
  public abstract ChivalryDayInfo copy();
  
  public abstract ChivalryDayInfo toData();
  
  public abstract ChivalryDayInfo toBean();
  
  public abstract ChivalryDayInfo toDataIf();
  
  public abstract ChivalryDayInfo toBeanIf();
  
  public abstract long getLastflushtime();
  
  public abstract int getChivalrydaysum();
  
  public abstract Map<Integer, Integer> getActivitydaysum();
  
  public abstract Map<Integer, Integer> getActivitydaysumAsData();
  
  public abstract void setLastflushtime(long paramLong);
  
  public abstract void setChivalrydaysum(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChivalryDayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */