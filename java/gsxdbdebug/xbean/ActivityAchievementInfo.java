package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface ActivityAchievementInfo
  extends Bean
{
  public abstract ActivityAchievementInfo copy();
  
  public abstract ActivityAchievementInfo toData();
  
  public abstract ActivityAchievementInfo toBean();
  
  public abstract ActivityAchievementInfo toDataIf();
  
  public abstract ActivityAchievementInfo toBeanIf();
  
  public abstract Map<Integer, AchievementInfo> getGoal_info();
  
  public abstract Map<Integer, AchievementInfo> getGoal_infoAsData();
  
  public abstract int getScore_value();
  
  public abstract Set<Integer> getAleardy_awarded_score();
  
  public abstract Set<Integer> getAleardy_awarded_scoreAsData();
  
  public abstract Map<Long, String> getActivity_parameters_extra();
  
  public abstract Map<Long, String> getActivity_parameters_extraAsData();
  
  public abstract void setScore_value(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ActivityAchievementInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */