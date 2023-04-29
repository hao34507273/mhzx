package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface Properties
  extends Bean
{
  public static final int BP_SYS_1 = 0;
  public static final int BP_SYS_2 = 1;
  public static final int BP_SYS_3 = 2;
  
  public abstract Properties copy();
  
  public abstract Properties toData();
  
  public abstract Properties toBean();
  
  public abstract Properties toDataIf();
  
  public abstract Properties toBeanIf();
  
  public abstract int getLevel();
  
  public abstract int getExp();
  
  public abstract int getHp();
  
  public abstract int getMp();
  
  public abstract int getAnger();
  
  public abstract int getVigor();
  
  public abstract Map<Integer, BasicPropertiesSystem> getPropertysysmap();
  
  public abstract Map<Integer, BasicPropertiesSystem> getPropertysysmapAsData();
  
  public abstract int getActivitybpsys();
  
  public abstract int getTodaypropsysswitchcount();
  
  public abstract long getTimestamp();
  
  public abstract Location getLocation();
  
  public abstract long getGold();
  
  public abstract long getSilver();
  
  public abstract long getGoldingot();
  
  public abstract int getDyecolorid();
  
  public abstract int getBaoshidu();
  
  public abstract long getLastlogintime();
  
  public abstract long getLastlogofftime();
  
  public abstract long getKeeponlinetime();
  
  public abstract int getFightvalue();
  
  public abstract long getLeveluptime();
  
  public abstract long getAccumulateleveluptime();
  
  public abstract long getVigorrefreshtime();
  
  public abstract int getConvertxiulianexp();
  
  public abstract Set<Long> getCompensates();
  
  public abstract Set<Long> getCompensatesAsData();
  
  public abstract Map<Integer, GatherMapItemInfo> getGather_map_item_infos();
  
  public abstract Map<Integer, GatherMapItemInfo> getGather_map_item_infosAsData();
  
  public abstract long getLastcalcuatetime();
  
  public abstract int getDayonlineseconds();
  
  public abstract long getOnlineseconds();
  
  public abstract int getSend_recharge_times_tip_mail_no();
  
  public abstract long getLevelupcurtime();
  
  public abstract Map<Integer, TransferOccupationPropertiesSys> getTransfer_occupation_property_sys_map();
  
  public abstract Map<Integer, TransferOccupationPropertiesSys> getTransfer_occupation_property_sys_mapAsData();
  
  public abstract Map<Integer, CoinInfo> getCoins();
  
  public abstract Map<Integer, CoinInfo> getCoinsAsData();
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setExp(int paramInt);
  
  public abstract void setHp(int paramInt);
  
  public abstract void setMp(int paramInt);
  
  public abstract void setAnger(int paramInt);
  
  public abstract void setVigor(int paramInt);
  
  public abstract void setActivitybpsys(int paramInt);
  
  public abstract void setTodaypropsysswitchcount(int paramInt);
  
  public abstract void setTimestamp(long paramLong);
  
  public abstract void setGold(long paramLong);
  
  public abstract void setSilver(long paramLong);
  
  public abstract void setGoldingot(long paramLong);
  
  public abstract void setDyecolorid(int paramInt);
  
  public abstract void setBaoshidu(int paramInt);
  
  public abstract void setLastlogintime(long paramLong);
  
  public abstract void setLastlogofftime(long paramLong);
  
  public abstract void setKeeponlinetime(long paramLong);
  
  public abstract void setFightvalue(int paramInt);
  
  public abstract void setLeveluptime(long paramLong);
  
  public abstract void setAccumulateleveluptime(long paramLong);
  
  public abstract void setVigorrefreshtime(long paramLong);
  
  public abstract void setConvertxiulianexp(int paramInt);
  
  public abstract void setLastcalcuatetime(long paramLong);
  
  public abstract void setDayonlineseconds(int paramInt);
  
  public abstract void setOnlineseconds(long paramLong);
  
  public abstract void setSend_recharge_times_tip_mail_no(int paramInt);
  
  public abstract void setLevelupcurtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Properties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */