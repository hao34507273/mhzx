package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MergeCompensationInfo
  extends Bean
{
  public abstract MergeCompensationInfo copy();
  
  public abstract MergeCompensationInfo toData();
  
  public abstract MergeCompensationInfo toBean();
  
  public abstract MergeCompensationInfo toDataIf();
  
  public abstract MergeCompensationInfo toBeanIf();
  
  public abstract Map<Long, ServerLevelInfo> getServer_level_infos();
  
  public abstract Map<Long, ServerLevelInfo> getServer_level_infosAsData();
  
  public abstract long getMax_server_level_zoneid();
  
  public abstract long getMerge_system_timestamp();
  
  public abstract long getMerge_time_offset();
  
  public abstract boolean getIs_data_available();
  
  public abstract void setMax_server_level_zoneid(long paramLong);
  
  public abstract void setMerge_system_timestamp(long paramLong);
  
  public abstract void setMerge_time_offset(long paramLong);
  
  public abstract void setIs_data_available(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MergeCompensationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */