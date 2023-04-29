package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleCrossBattleOwnInfo
  extends Bean
{
  public abstract RoleCrossBattleOwnInfo copy();
  
  public abstract RoleCrossBattleOwnInfo toData();
  
  public abstract RoleCrossBattleOwnInfo toBean();
  
  public abstract RoleCrossBattleOwnInfo toDataIf();
  
  public abstract RoleCrossBattleOwnInfo toBeanIf();
  
  public abstract Map<Integer, CrossBattleOwnActivityInfo> getCross_battle_own_activity_infos();
  
  public abstract Map<Integer, CrossBattleOwnActivityInfo> getCross_battle_own_activity_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleCrossBattleOwnInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */