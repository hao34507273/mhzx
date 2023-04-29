package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoundRobinFightBetInfo
  extends Bean
{
  public abstract RoundRobinFightBetInfo copy();
  
  public abstract RoundRobinFightBetInfo toData();
  
  public abstract RoundRobinFightBetInfo toBean();
  
  public abstract RoundRobinFightBetInfo toDataIf();
  
  public abstract RoundRobinFightBetInfo toBeanIf();
  
  public abstract long getCorps_a_id();
  
  public abstract long getCorps_b_id();
  
  public abstract long getCorps_a_bet_money_sum();
  
  public abstract long getCorps_b_bet_money_sum();
  
  public abstract Map<Long, RoleRoundRobinFightBetInfo> getRole_bet_infos();
  
  public abstract Map<Long, RoleRoundRobinFightBetInfo> getRole_bet_infosAsData();
  
  public abstract int getState();
  
  public abstract void setCorps_a_id(long paramLong);
  
  public abstract void setCorps_b_id(long paramLong);
  
  public abstract void setCorps_a_bet_money_sum(long paramLong);
  
  public abstract void setCorps_b_bet_money_sum(long paramLong);
  
  public abstract void setState(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoundRobinFightBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */