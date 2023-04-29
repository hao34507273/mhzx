package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ReportedInfo
  extends Bean
{
  public abstract ReportedInfo copy();
  
  public abstract ReportedInfo toData();
  
  public abstract ReportedInfo toBean();
  
  public abstract ReportedInfo toDataIf();
  
  public abstract ReportedInfo toBeanIf();
  
  public abstract Map<Long, Integer> getReport_time_map();
  
  public abstract Map<Long, Integer> getReport_time_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ReportedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */