package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface BeRecalledBackGameInfo
  extends Bean
{
  public static final int STATUS_INIT = 0;
  public static final int FRIEND_RECALL_BACK = 1;
  public static final int NORMAL_BACK = 2;
  
  public abstract BeRecalledBackGameInfo copy();
  
  public abstract BeRecalledBackGameInfo toData();
  
  public abstract BeRecalledBackGameInfo toBean();
  
  public abstract BeRecalledBackGameInfo toDataIf();
  
  public abstract BeRecalledBackGameInfo toBeanIf();
  
  public abstract long getBack_game_time();
  
  public abstract int getBack_game_reason();
  
  public abstract long getPeriod_begin_time();
  
  public abstract int getCurrent_period_be_recalled_times();
  
  public abstract Set<String> getRecall_user_set();
  
  public abstract Set<String> getRecall_user_setAsData();
  
  public abstract Set<Integer> getSign_awarded_day_set();
  
  public abstract Set<Integer> getSign_awarded_day_setAsData();
  
  public abstract boolean getBig_gift_awarded_state();
  
  public abstract void setBack_game_time(long paramLong);
  
  public abstract void setBack_game_reason(int paramInt);
  
  public abstract void setPeriod_begin_time(long paramLong);
  
  public abstract void setCurrent_period_be_recalled_times(int paramInt);
  
  public abstract void setBig_gift_awarded_state(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BeRecalledBackGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */