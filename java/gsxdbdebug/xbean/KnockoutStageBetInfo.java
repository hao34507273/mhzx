package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface KnockoutStageBetInfo
  extends Bean
{
  public abstract KnockoutStageBetInfo copy();
  
  public abstract KnockoutStageBetInfo toData();
  
  public abstract KnockoutStageBetInfo toBean();
  
  public abstract KnockoutStageBetInfo toDataIf();
  
  public abstract KnockoutStageBetInfo toBeanIf();
  
  public abstract Map<Integer, KnockoutFightBetInfo> getFight_bet_infos();
  
  public abstract Map<Integer, KnockoutFightBetInfo> getFight_bet_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\KnockoutStageBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */