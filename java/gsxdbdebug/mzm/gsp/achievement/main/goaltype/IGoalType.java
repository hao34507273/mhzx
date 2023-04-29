package mzm.gsp.achievement.main.goaltype;

import mzm.gsp.achievement.confbean.SAchievementGoalCfg;
import xbean.AchievementInfo;
import xbean.ActivityAchievementInfo;

public abstract interface IGoalType
{
  public abstract int getType();
  
  public abstract void initParams(AchievementInfo paramAchievementInfo);
  
  public abstract boolean updateState(long paramLong, AchievementInfo paramAchievementInfo, SAchievementGoalCfg paramSAchievementGoalCfg, Object paramObject);
  
  public abstract boolean correctState(long paramLong, SAchievementGoalCfg paramSAchievementGoalCfg, ActivityAchievementInfo paramActivityAchievementInfo);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\goaltype\IGoalType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */