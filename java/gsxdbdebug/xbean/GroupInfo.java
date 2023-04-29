package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GroupInfo
  extends Bean
{
  public abstract GroupInfo copy();
  
  public abstract GroupInfo toData();
  
  public abstract GroupInfo toBean();
  
  public abstract GroupInfo toDataIf();
  
  public abstract GroupInfo toBeanIf();
  
  public abstract Map<Long, GroupSetting> getCreate_same_zone_groupids();
  
  public abstract Map<Long, GroupSetting> getCreate_same_zone_groupidsAsData();
  
  public abstract Map<Long, GroupSetting> getJoin_same_zone_groupids();
  
  public abstract Map<Long, GroupSetting> getJoin_same_zone_groupidsAsData();
  
  public abstract Map<Long, Long> getOffline_group_join_infos();
  
  public abstract Map<Long, Long> getOffline_group_join_infosAsData();
  
  public abstract Map<Long, Long> getOffline_group_kick_infos();
  
  public abstract Map<Long, Long> getOffline_group_kick_infosAsData();
  
  public abstract Map<Long, String> getOffline_group_dissolve_infos();
  
  public abstract Map<Long, String> getOffline_group_dissolve_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */