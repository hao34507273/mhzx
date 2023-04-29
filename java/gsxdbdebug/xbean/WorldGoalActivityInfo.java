package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface WorldGoalActivityInfo
  extends Bean
{
  public abstract WorldGoalActivityInfo copy();
  
  public abstract WorldGoalActivityInfo toData();
  
  public abstract WorldGoalActivityInfo toBean();
  
  public abstract WorldGoalActivityInfo toDataIf();
  
  public abstract WorldGoalActivityInfo toBeanIf();
  
  public abstract Set<Integer> getAward_section_ids();
  
  public abstract Set<Integer> getAward_section_idsAsData();
  
  public abstract int getExtra_award_num();
  
  public abstract long getExtra_award_num_timestamp();
  
  public abstract int getCommit_item_sum();
  
  public abstract boolean getHas_try_send_commit_item_sum_award();
  
  public abstract void setExtra_award_num(int paramInt);
  
  public abstract void setExtra_award_num_timestamp(long paramLong);
  
  public abstract void setCommit_item_sum(int paramInt);
  
  public abstract void setHas_try_send_commit_item_sum_award(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WorldGoalActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */