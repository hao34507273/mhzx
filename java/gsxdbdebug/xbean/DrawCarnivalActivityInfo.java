package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface DrawCarnivalActivityInfo
  extends Bean
{
  public abstract DrawCarnivalActivityInfo copy();
  
  public abstract DrawCarnivalActivityInfo toData();
  
  public abstract DrawCarnivalActivityInfo toBean();
  
  public abstract DrawCarnivalActivityInfo toDataIf();
  
  public abstract DrawCarnivalActivityInfo toBeanIf();
  
  public abstract DrawCarnivalAwardWinnerInfo getLast_winner_role_info();
  
  public abstract long getAccumulate_yuan_bao_cost_count();
  
  public abstract Map<Integer, Integer> getPass_type_id2extra_rate_per_pass();
  
  public abstract Map<Integer, Integer> getPass_type_id2extra_rate_per_passAsData();
  
  public abstract int getBig_award_count();
  
  public abstract Map<Integer, Integer> getRandom_type_id2chest_count();
  
  public abstract Map<Integer, Integer> getRandom_type_id2chest_countAsData();
  
  public abstract void setAccumulate_yuan_bao_cost_count(long paramLong);
  
  public abstract void setBig_award_count(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DrawCarnivalActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */