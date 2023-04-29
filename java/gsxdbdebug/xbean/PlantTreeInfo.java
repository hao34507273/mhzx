package xbean;

import java.util.List;
import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface PlantTreeInfo
  extends Bean
{
  public abstract PlantTreeInfo copy();
  
  public abstract PlantTreeInfo toData();
  
  public abstract PlantTreeInfo toBean();
  
  public abstract PlantTreeInfo toDataIf();
  
  public abstract PlantTreeInfo toBeanIf();
  
  public abstract Map<Integer, Integer> getSections();
  
  public abstract Map<Integer, Integer> getSectionsAsData();
  
  public abstract int getCurrent_section_id();
  
  public abstract int getSpecial_state_index();
  
  public abstract List<PlantTreeLog> getLogs();
  
  public abstract List<PlantTreeLog> getLogsAsData();
  
  public abstract long getSpecial_state_refresh_sessionid();
  
  public abstract Set<Integer> getAward_section_ids();
  
  public abstract Set<Integer> getAward_section_idsAsData();
  
  public abstract boolean getHas_get_activity_complete_award();
  
  public abstract int getAdd_point_times();
  
  public abstract int getRemove_special_state_award_times();
  
  public abstract int getOnline_reward_point();
  
  public abstract long getOnline_reward_point_timestamp();
  
  public abstract void setCurrent_section_id(int paramInt);
  
  public abstract void setSpecial_state_index(int paramInt);
  
  public abstract void setSpecial_state_refresh_sessionid(long paramLong);
  
  public abstract void setHas_get_activity_complete_award(boolean paramBoolean);
  
  public abstract void setAdd_point_times(int paramInt);
  
  public abstract void setRemove_special_state_award_times(int paramInt);
  
  public abstract void setOnline_reward_point(int paramInt);
  
  public abstract void setOnline_reward_point_timestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PlantTreeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */