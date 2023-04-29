package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface AchievementInfo
  extends Bean
{
  public abstract AchievementInfo copy();
  
  public abstract AchievementInfo toData();
  
  public abstract AchievementInfo toBean();
  
  public abstract AchievementInfo toDataIf();
  
  public abstract AchievementInfo toBeanIf();
  
  public abstract int getGoal_state();
  
  public abstract List<Integer> getGoal_parameters();
  
  public abstract List<Integer> getGoal_parametersAsData();
  
  public abstract Map<Long, String> getGoal_parameters_extra();
  
  public abstract Map<Long, String> getGoal_parameters_extraAsData();
  
  public abstract long getGoal_achieve_time();
  
  public abstract void setGoal_state(int paramInt);
  
  public abstract void setGoal_achieve_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AchievementInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */