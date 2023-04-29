package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface KnockoutZoneBetInfo
  extends Bean
{
  public abstract KnockoutZoneBetInfo copy();
  
  public abstract KnockoutZoneBetInfo toData();
  
  public abstract KnockoutZoneBetInfo toBean();
  
  public abstract KnockoutZoneBetInfo toDataIf();
  
  public abstract KnockoutZoneBetInfo toBeanIf();
  
  public abstract Map<Integer, KnockoutStageBetInfo> getStage_bet_infos();
  
  public abstract Map<Integer, KnockoutStageBetInfo> getStage_bet_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\KnockoutZoneBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */