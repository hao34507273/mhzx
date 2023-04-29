package xbean;

import java.util.List;
import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface MasterInfo
  extends Bean
{
  public abstract MasterInfo copy();
  
  public abstract MasterInfo toData();
  
  public abstract MasterInfo toBean();
  
  public abstract MasterInfo toDataIf();
  
  public abstract MasterInfo toBeanIf();
  
  public abstract Map<Long, ShiTuTimeInfo> getApprentice_now();
  
  public abstract Map<Long, ShiTuTimeInfo> getApprentice_nowAsData();
  
  public abstract List<Long> getApprentice_role_list();
  
  public abstract List<Long> getApprentice_role_listAsData();
  
  public abstract Map<Long, ShiTuTimeInfo> getApprentice_graduate();
  
  public abstract Map<Long, ShiTuTimeInfo> getApprentice_graduateAsData();
  
  public abstract Map<Long, ShiTuTimeInfo> getForce_relieve();
  
  public abstract Map<Long, ShiTuTimeInfo> getForce_relieveAsData();
  
  public abstract Set<Integer> getAlwardy_awarded_cfg_set();
  
  public abstract Set<Integer> getAlwardy_awarded_cfg_setAsData();
  
  public abstract List<Long> getNow_apprentice_role_list();
  
  public abstract List<Long> getNow_apprentice_role_listAsData();
  
  public abstract long getPublish_reset_time();
  
  public abstract int getPublish_times();
  
  public abstract void setPublish_reset_time(long paramLong);
  
  public abstract void setPublish_times(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MasterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */