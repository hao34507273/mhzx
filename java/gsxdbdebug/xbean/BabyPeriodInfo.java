package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface BabyPeriodInfo
  extends Bean
{
  public static final int NO_OPERATOR_STATUS = -1;
  
  public abstract BabyPeriodInfo copy();
  
  public abstract BabyPeriodInfo toData();
  
  public abstract BabyPeriodInfo toBean();
  
  public abstract BabyPeriodInfo toDataIf();
  
  public abstract BabyPeriodInfo toBeanIf();
  
  public abstract Map<Integer, Integer> getBaby_property_info_map();
  
  public abstract Map<Integer, Integer> getBaby_property_info_mapAsData();
  
  public abstract int getHealth_score();
  
  public abstract long getHealth_refresh_time();
  
  public abstract int getBaby_period_operator();
  
  public abstract long getBaby_period_operator_start_time();
  
  public abstract int getBaby_model_cfg_id();
  
  public abstract boolean getAuto_breed();
  
  public abstract void setHealth_score(int paramInt);
  
  public abstract void setHealth_refresh_time(long paramLong);
  
  public abstract void setBaby_period_operator(int paramInt);
  
  public abstract void setBaby_period_operator_start_time(long paramLong);
  
  public abstract void setBaby_model_cfg_id(int paramInt);
  
  public abstract void setAuto_breed(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BabyPeriodInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */