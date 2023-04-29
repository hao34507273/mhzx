package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface CrossBattleRoundRobinBet
  extends Bean
{
  public abstract CrossBattleRoundRobinBet copy();
  
  public abstract CrossBattleRoundRobinBet toData();
  
  public abstract CrossBattleRoundRobinBet toBean();
  
  public abstract CrossBattleRoundRobinBet toDataIf();
  
  public abstract CrossBattleRoundRobinBet toBeanIf();
  
  public abstract List<RoundRobinRoundBetInfo> getRound_bet_infos();
  
  public abstract List<RoundRobinRoundBetInfo> getRound_bet_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossBattleRoundRobinBet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */