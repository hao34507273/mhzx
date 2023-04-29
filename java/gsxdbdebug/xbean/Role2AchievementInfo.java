package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Role2AchievementInfo
  extends Bean
{
  public abstract Role2AchievementInfo copy();
  
  public abstract Role2AchievementInfo toData();
  
  public abstract Role2AchievementInfo toBean();
  
  public abstract Role2AchievementInfo toDataIf();
  
  public abstract Role2AchievementInfo toBeanIf();
  
  public abstract Map<Integer, ActivityAchievementInfo> getActivity_achievement_info();
  
  public abstract Map<Integer, ActivityAchievementInfo> getActivity_achievement_infoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2AchievementInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */