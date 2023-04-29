package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface KnockoutTypeBetInfo
  extends Bean
{
  public abstract KnockoutTypeBetInfo copy();
  
  public abstract KnockoutTypeBetInfo toData();
  
  public abstract KnockoutTypeBetInfo toBean();
  
  public abstract KnockoutTypeBetInfo toDataIf();
  
  public abstract KnockoutTypeBetInfo toBeanIf();
  
  public abstract Map<Integer, KnockoutZoneBetInfo> getZone_bet_infos();
  
  public abstract Map<Integer, KnockoutZoneBetInfo> getZone_bet_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\KnockoutTypeBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */