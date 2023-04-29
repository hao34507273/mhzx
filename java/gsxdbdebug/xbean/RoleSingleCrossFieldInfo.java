package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleSingleCrossFieldInfo
  extends Bean
{
  public abstract RoleSingleCrossFieldInfo copy();
  
  public abstract RoleSingleCrossFieldInfo toData();
  
  public abstract RoleSingleCrossFieldInfo toBean();
  
  public abstract RoleSingleCrossFieldInfo toDataIf();
  
  public abstract RoleSingleCrossFieldInfo toBeanIf();
  
  public abstract long getActive_leave_field_timestamp();
  
  public abstract Map<Integer, RoleSingleCrossFieldSeasonInfo> getSeason_infos();
  
  public abstract Map<Integer, RoleSingleCrossFieldSeasonInfo> getSeason_infosAsData();
  
  public abstract int getWeekly_point_sum();
  
  public abstract long getWeekly_point_sum_timestamp();
  
  public abstract int getDaily_award_times();
  
  public abstract long getDaily_award_times_timestamp();
  
  public abstract void setActive_leave_field_timestamp(long paramLong);
  
  public abstract void setWeekly_point_sum(int paramInt);
  
  public abstract void setWeekly_point_sum_timestamp(long paramLong);
  
  public abstract void setDaily_award_times(int paramInt);
  
  public abstract void setDaily_award_times_timestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleSingleCrossFieldInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */