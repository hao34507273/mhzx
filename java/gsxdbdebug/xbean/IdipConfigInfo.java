package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface IdipConfigInfo
  extends Bean
{
  public abstract IdipConfigInfo copy();
  
  public abstract IdipConfigInfo toData();
  
  public abstract IdipConfigInfo toBean();
  
  public abstract IdipConfigInfo toDataIf();
  
  public abstract IdipConfigInfo toBeanIf();
  
  public abstract Map<Long, RoleRankForbid> getRank_forbids();
  
  public abstract Map<Long, RoleRankForbid> getRank_forbidsAsData();
  
  public abstract Map<Long, IdipForbidInfo> getZero_profits();
  
  public abstract Map<Long, IdipForbidInfo> getZero_profitsAsData();
  
  public abstract Map<Long, RolePlayForbid> getPlay_forbids();
  
  public abstract Map<Long, RolePlayForbid> getPlay_forbidsAsData();
  
  public abstract Map<Long, RoleInfoForbid> getInfo_forbids();
  
  public abstract Map<Long, RoleInfoForbid> getInfo_forbidsAsData();
  
  public abstract Map<Integer, IdipNTimesAwardInfo> getN_times_award();
  
  public abstract Map<Integer, IdipNTimesAwardInfo> getN_times_awardAsData();
  
  public abstract Set<Long> getNotices();
  
  public abstract Set<Long> getNoticesAsData();
  
  public abstract Set<Long> getMarquees();
  
  public abstract Set<Long> getMarqueesAsData();
  
  public abstract Map<Integer, HideItemInfo> getHide_items();
  
  public abstract Map<Integer, HideItemInfo> getHide_itemsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\IdipConfigInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */