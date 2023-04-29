package xbean;

import java.util.NavigableMap;
import xdb.Bean;

public abstract interface ActivityCompensate
  extends Bean
{
  public abstract ActivityCompensate copy();
  
  public abstract ActivityCompensate toData();
  
  public abstract ActivityCompensate toBean();
  
  public abstract ActivityCompensate toDataIf();
  
  public abstract ActivityCompensate toBeanIf();
  
  public abstract NavigableMap<Long, Integer> getStart_time2get_times();
  
  public abstract NavigableMap<Long, Integer> getStart_time2get_timesAsData();
  
  public abstract long getCan_join_time();
  
  public abstract long getLatest_start_time();
  
  public abstract void setCan_join_time(long paramLong);
  
  public abstract void setLatest_start_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ActivityCompensate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */