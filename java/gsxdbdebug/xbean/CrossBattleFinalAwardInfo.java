package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface CrossBattleFinalAwardInfo
  extends Bean
{
  public abstract CrossBattleFinalAwardInfo copy();
  
  public abstract CrossBattleFinalAwardInfo toData();
  
  public abstract CrossBattleFinalAwardInfo toBean();
  
  public abstract CrossBattleFinalAwardInfo toDataIf();
  
  public abstract CrossBattleFinalAwardInfo toBeanIf();
  
  public abstract Set<Integer> getChecked_award_rank_set();
  
  public abstract Set<Integer> getChecked_award_rank_setAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossBattleFinalAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */