package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface WorldCounterRewardInfo
  extends Bean
{
  public abstract WorldCounterRewardInfo copy();
  
  public abstract WorldCounterRewardInfo toData();
  
  public abstract WorldCounterRewardInfo toBean();
  
  public abstract WorldCounterRewardInfo toDataIf();
  
  public abstract WorldCounterRewardInfo toBeanIf();
  
  public abstract Map<Integer, WorldCounterRewardStages> getIndex2reward_stages();
  
  public abstract Map<Integer, WorldCounterRewardStages> getIndex2reward_stagesAsData();
  
  public abstract boolean getSended_reward_mail();
  
  public abstract void setSended_reward_mail(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WorldCounterRewardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */