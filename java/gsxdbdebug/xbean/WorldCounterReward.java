package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface WorldCounterReward
  extends Bean
{
  public abstract WorldCounterReward copy();
  
  public abstract WorldCounterReward toData();
  
  public abstract WorldCounterReward toBean();
  
  public abstract WorldCounterReward toDataIf();
  
  public abstract WorldCounterReward toBeanIf();
  
  public abstract Map<Integer, WorldCounterRewardInfo> getReward_info();
  
  public abstract Map<Integer, WorldCounterRewardInfo> getReward_infoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WorldCounterReward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */