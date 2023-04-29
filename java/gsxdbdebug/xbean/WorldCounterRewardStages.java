package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface WorldCounterRewardStages
  extends Bean
{
  public abstract WorldCounterRewardStages copy();
  
  public abstract WorldCounterRewardStages toData();
  
  public abstract WorldCounterRewardStages toBean();
  
  public abstract WorldCounterRewardStages toDataIf();
  
  public abstract WorldCounterRewardStages toBeanIf();
  
  public abstract Set<Integer> getRewarded_stages();
  
  public abstract Set<Integer> getRewarded_stagesAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WorldCounterRewardStages.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */