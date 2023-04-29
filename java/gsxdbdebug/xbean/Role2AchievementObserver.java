package xbean;

import java.util.Map;
import mzm.gsp.achievement.main.PAchievementActivityFinishMailAward.AchievementAwardMailObserver;
import xdb.Bean;

public abstract interface Role2AchievementObserver
  extends Bean
{
  public abstract Role2AchievementObserver copy();
  
  public abstract Role2AchievementObserver toData();
  
  public abstract Role2AchievementObserver toBean();
  
  public abstract Role2AchievementObserver toDataIf();
  
  public abstract Role2AchievementObserver toBeanIf();
  
  public abstract Map<Integer, PAchievementActivityFinishMailAward.AchievementAwardMailObserver> getObserver_map();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2AchievementObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */