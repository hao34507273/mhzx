package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface CrossBattleKnockoutLocalRankInfo
  extends Bean
{
  public static final int CHAMPION_RANK_KEY = 1;
  public static final int SECOND_PLACE_RANK_KEY = 2;
  public static final int DOUBLE_SECOND_PLACE_RANK_KEY = 3;
  public static final int THIRD_PLACE_RANK_KEY = 4;
  
  public abstract CrossBattleKnockoutLocalRankInfo copy();
  
  public abstract CrossBattleKnockoutLocalRankInfo toData();
  
  public abstract CrossBattleKnockoutLocalRankInfo toBean();
  
  public abstract CrossBattleKnockoutLocalRankInfo toDataIf();
  
  public abstract CrossBattleKnockoutLocalRankInfo toBeanIf();
  
  public abstract boolean getIs_server_buff_install();
  
  public abstract Set<Integer> getValid_zone_id_set();
  
  public abstract Set<Integer> getValid_zone_id_setAsData();
  
  public abstract void setIs_server_buff_install(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossBattleKnockoutLocalRankInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */