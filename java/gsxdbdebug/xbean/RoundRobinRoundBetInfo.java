package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface RoundRobinRoundBetInfo
  extends Bean
{
  public abstract RoundRobinRoundBetInfo copy();
  
  public abstract RoundRobinRoundBetInfo toData();
  
  public abstract RoundRobinRoundBetInfo toBean();
  
  public abstract RoundRobinRoundBetInfo toDataIf();
  
  public abstract RoundRobinRoundBetInfo toBeanIf();
  
  public abstract List<RoundRobinFightBetInfo> getFight_bet_infos();
  
  public abstract List<RoundRobinFightBetInfo> getFight_bet_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoundRobinRoundBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */