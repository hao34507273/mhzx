package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface BackGameActivityInfo
  extends Bean
{
  public abstract BackGameActivityInfo copy();
  
  public abstract BackGameActivityInfo toData();
  
  public abstract BackGameActivityInfo toBean();
  
  public abstract BackGameActivityInfo toDataIf();
  
  public abstract BackGameActivityInfo toBeanIf();
  
  public abstract int getActivity_id();
  
  public abstract long getJoin_time();
  
  public abstract int getJoin_level();
  
  public abstract int getJoin_recharge();
  
  public abstract int getSign_count();
  
  public abstract long getLast_sign_time();
  
  public abstract List<Integer> getAlready_get_point_awards();
  
  public abstract List<Integer> getAlready_get_point_awardsAsData();
  
  public abstract long getLast_get_point_award_time();
  
  public abstract List<Integer> getAlready_get_exp_awards();
  
  public abstract List<Integer> getAlready_get_exp_awardsAsData();
  
  public abstract int getLogin_count();
  
  public abstract long getLast_login_time();
  
  public abstract boolean getHave_got_back_game_award();
  
  public abstract Map<Integer, Integer> getGift_buy_count_map();
  
  public abstract Map<Integer, Integer> getGift_buy_count_mapAsData();
  
  public abstract long getLast_buy_gift_time();
  
  public abstract long getLast_get_task_award_time();
  
  public abstract void setActivity_id(int paramInt);
  
  public abstract void setJoin_time(long paramLong);
  
  public abstract void setJoin_level(int paramInt);
  
  public abstract void setJoin_recharge(int paramInt);
  
  public abstract void setSign_count(int paramInt);
  
  public abstract void setLast_sign_time(long paramLong);
  
  public abstract void setLast_get_point_award_time(long paramLong);
  
  public abstract void setLogin_count(int paramInt);
  
  public abstract void setLast_login_time(long paramLong);
  
  public abstract void setHave_got_back_game_award(boolean paramBoolean);
  
  public abstract void setLast_buy_gift_time(long paramLong);
  
  public abstract void setLast_get_task_award_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BackGameActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */