package mzm.gsp.achievement.main;

import xbean.ActivityAchievementInfo;

public abstract interface AchievementActivityHandler
{
  public abstract boolean isNeedSync(long paramLong, int paramInt, ActivityAchievementInfo paramActivityAchievementInfo);
  
  public abstract boolean isCanTakePartIn(long paramLong, int paramInt);
  
  public abstract boolean isGoalCanTakePartIn(long paramLong, int paramInt1, int paramInt2);
  
  public abstract int getSwitchModule(int paramInt);
  
  public abstract String getGoalStatisTlogName();
  
  public abstract String getScoreAwardedTlogName();
  
  public abstract boolean isTriggerGoalFinishEvent();
  
  public abstract boolean isCanGoalAward();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\AchievementActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */