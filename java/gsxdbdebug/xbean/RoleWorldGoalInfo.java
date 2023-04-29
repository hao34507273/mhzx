package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleWorldGoalInfo
  extends Bean
{
  public abstract RoleWorldGoalInfo copy();
  
  public abstract RoleWorldGoalInfo toData();
  
  public abstract RoleWorldGoalInfo toBean();
  
  public abstract RoleWorldGoalInfo toDataIf();
  
  public abstract RoleWorldGoalInfo toBeanIf();
  
  public abstract Map<Integer, WorldGoalActivityInfo> getWorld_goal_activity_infos();
  
  public abstract Map<Integer, WorldGoalActivityInfo> getWorld_goal_activity_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleWorldGoalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */