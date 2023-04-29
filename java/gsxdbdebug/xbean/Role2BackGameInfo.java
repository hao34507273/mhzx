package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface Role2BackGameInfo
  extends Bean
{
  public abstract Role2BackGameInfo copy();
  
  public abstract Role2BackGameInfo toData();
  
  public abstract Role2BackGameInfo toBean();
  
  public abstract Role2BackGameInfo toDataIf();
  
  public abstract Role2BackGameInfo toBeanIf();
  
  public abstract long getBack_state_start_time();
  
  public abstract int getOffline_days();
  
  public abstract int getBack_game_level();
  
  public abstract long getClear_score_time();
  
  public abstract List<Integer> getAleardy_awarded_score_index_list();
  
  public abstract List<Integer> getAleardy_awarded_score_index_listAsData();
  
  public abstract int getActive_base_value();
  
  public abstract long getYuan_bao_save_amt_base_value();
  
  public abstract void setBack_state_start_time(long paramLong);
  
  public abstract void setOffline_days(int paramInt);
  
  public abstract void setBack_game_level(int paramInt);
  
  public abstract void setClear_score_time(long paramLong);
  
  public abstract void setActive_base_value(int paramInt);
  
  public abstract void setYuan_bao_save_amt_base_value(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2BackGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */