package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ShiTuTaskInfo
  extends Bean
{
  public static final int NO_PUBLISHED = 0;
  public static final int YES_PUBLISHED = 1;
  public static final int APPRENTICE_RECEIVED = 2;
  public static final int RECEIVE_MAX_LEVEL = 3;
  public static final int RECEIVE_MAX_TIMES = 4;
  public static final int LEAVE_MASTER_TODAY = 5;
  public static final int CHU_SHI = 6;
  public static final int MAX_PUBLISH_TIMES = 7;
  
  public abstract ShiTuTaskInfo copy();
  
  public abstract ShiTuTaskInfo toData();
  
  public abstract ShiTuTaskInfo toBean();
  
  public abstract ShiTuTaskInfo toDataIf();
  
  public abstract ShiTuTaskInfo toBeanIf();
  
  public abstract long getReset_time();
  
  public abstract int getPublish_state();
  
  public abstract int getRefresh_times();
  
  public abstract int getShitu_task_count();
  
  public abstract Map<Integer, ShiTuTask> getTask_infos();
  
  public abstract Map<Integer, ShiTuTask> getTask_infosAsData();
  
  public abstract void setReset_time(long paramLong);
  
  public abstract void setPublish_state(int paramInt);
  
  public abstract void setRefresh_times(int paramInt);
  
  public abstract void setShitu_task_count(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ShiTuTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */