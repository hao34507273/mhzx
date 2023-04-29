package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface WorldGoal
  extends Bean
{
  public abstract WorldGoal copy();
  
  public abstract WorldGoal toData();
  
  public abstract WorldGoal toBean();
  
  public abstract WorldGoal toDataIf();
  
  public abstract WorldGoal toBeanIf();
  
  public abstract Map<Integer, Section> getSections();
  
  public abstract Map<Integer, Section> getSectionsAsData();
  
  public abstract int getCurrent_section_id();
  
  public abstract int getExtra_award_num();
  
  public abstract long getExtra_award_num_timestamp();
  
  public abstract Set<Long> getCommit_roles();
  
  public abstract Set<Long> getCommit_rolesAsData();
  
  public abstract long getWorld_id();
  
  public abstract void setCurrent_section_id(int paramInt);
  
  public abstract void setExtra_award_num(int paramInt);
  
  public abstract void setExtra_award_num_timestamp(long paramLong);
  
  public abstract void setWorld_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WorldGoal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */