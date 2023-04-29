package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ReportInfo
  extends Bean
{
  public abstract ReportInfo copy();
  
  public abstract ReportInfo toData();
  
  public abstract ReportInfo toBean();
  
  public abstract ReportInfo toDataIf();
  
  public abstract ReportInfo toBeanIf();
  
  public abstract Map<Long, ReportRecord> getReport_records();
  
  public abstract Map<Long, ReportRecord> getReport_recordsAsData();
  
  public abstract long getReport_timestamp();
  
  public abstract void setReport_timestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ReportInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */