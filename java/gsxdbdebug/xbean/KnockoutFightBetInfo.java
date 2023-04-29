package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface KnockoutFightBetInfo
  extends Bean
{
  public abstract KnockoutFightBetInfo copy();
  
  public abstract KnockoutFightBetInfo toData();
  
  public abstract KnockoutFightBetInfo toBean();
  
  public abstract KnockoutFightBetInfo toDataIf();
  
  public abstract KnockoutFightBetInfo toBeanIf();
  
  public abstract long getA_corps_id();
  
  public abstract long getB_corps_id();
  
  public abstract int getCal_fight_result();
  
  public abstract boolean getHas_set_cal_fight_result();
  
  public abstract Map<Long, RoleKnockoutFightBetInfo> getRole_bet_infos();
  
  public abstract Map<Long, RoleKnockoutFightBetInfo> getRole_bet_infosAsData();
  
  public abstract void setA_corps_id(long paramLong);
  
  public abstract void setB_corps_id(long paramLong);
  
  public abstract void setCal_fight_result(int paramInt);
  
  public abstract void setHas_set_cal_fight_result(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\KnockoutFightBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */