package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CrossBattleKnockoutBet
  extends Bean
{
  public abstract CrossBattleKnockoutBet copy();
  
  public abstract CrossBattleKnockoutBet toData();
  
  public abstract CrossBattleKnockoutBet toBean();
  
  public abstract CrossBattleKnockoutBet toDataIf();
  
  public abstract CrossBattleKnockoutBet toBeanIf();
  
  public abstract Map<Integer, KnockoutTypeBetInfo> getKnockout_type_bet_infos();
  
  public abstract Map<Integer, KnockoutTypeBetInfo> getKnockout_type_bet_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossBattleKnockoutBet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */