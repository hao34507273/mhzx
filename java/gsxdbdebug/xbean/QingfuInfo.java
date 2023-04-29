package xbean;

import com.goldhuman.Common.Octets;
import java.util.Map;
import xdb.Bean;

public abstract interface QingfuInfo
  extends Bean
{
  public abstract QingfuInfo copy();
  
  public abstract QingfuInfo toData();
  
  public abstract QingfuInfo toBean();
  
  public abstract QingfuInfo toDataIf();
  
  public abstract QingfuInfo toBeanIf();
  
  public abstract String getAppid();
  
  public abstract Octets getAppidOctets();
  
  public abstract long getSave_amt();
  
  public abstract long getTotal_cash();
  
  public abstract long getTotal_cost();
  
  public abstract long getTotal_cost_bind();
  
  public abstract long getTotal_present();
  
  public abstract long getTotal_present_bind();
  
  public abstract long getTotal_confirm_cost();
  
  public abstract long getTotal_confirm_cost_bind();
  
  public abstract long getTotal_confirm_present();
  
  public abstract long getTotal_confirm_present_bind();
  
  public abstract String getTss_list();
  
  public abstract Octets getTss_listOctets();
  
  public abstract Map<String, TssSumInfo> getTss_sum_map();
  
  public abstract Map<String, TssSumInfo> getTss_sum_mapAsData();
  
  public abstract int getFirst_recharge_status();
  
  public abstract int getRecharge_times();
  
  public abstract int getStatis_recharge_first_consume_status();
  
  public abstract Map<Integer, SaveAmtActivityInfo> getSave_amt_activity_infos();
  
  public abstract Map<Integer, SaveAmtActivityInfo> getSave_amt_activity_infosAsData();
  
  public abstract Map<Integer, LevelGrowthFundActivityInfo> getLevel_growth_fund_activity_infos();
  
  public abstract Map<Integer, LevelGrowthFundActivityInfo> getLevel_growth_fund_activity_infosAsData();
  
  public abstract Map<Integer, MonthCardActivityInfo> getMoth_card_activity_infos();
  
  public abstract Map<Integer, MonthCardActivityInfo> getMoth_card_activity_infosAsData();
  
  public abstract Map<Integer, AccumTotalCostActivityInfo> getAccum_total_cost_activity_infos();
  
  public abstract Map<Integer, AccumTotalCostActivityInfo> getAccum_total_cost_activity_infosAsData();
  
  public abstract Map<Integer, RMBGiftBagActivityInfo> getRmb_gift_bag_activity_infos();
  
  public abstract Map<Integer, RMBGiftBagActivityInfo> getRmb_gift_bag_activity_infosAsData();
  
  public abstract RecentlyCashInfo getRecently_cash_infos();
  
  public abstract long getTotal_cash_amt();
  
  public abstract long getInner_save_amt();
  
  public abstract void setAppid(String paramString);
  
  public abstract void setAppidOctets(Octets paramOctets);
  
  public abstract void setSave_amt(long paramLong);
  
  public abstract void setTotal_cash(long paramLong);
  
  public abstract void setTotal_cost(long paramLong);
  
  public abstract void setTotal_cost_bind(long paramLong);
  
  public abstract void setTotal_present(long paramLong);
  
  public abstract void setTotal_present_bind(long paramLong);
  
  public abstract void setTotal_confirm_cost(long paramLong);
  
  public abstract void setTotal_confirm_cost_bind(long paramLong);
  
  public abstract void setTotal_confirm_present(long paramLong);
  
  public abstract void setTotal_confirm_present_bind(long paramLong);
  
  public abstract void setTss_list(String paramString);
  
  public abstract void setTss_listOctets(Octets paramOctets);
  
  public abstract void setFirst_recharge_status(int paramInt);
  
  public abstract void setRecharge_times(int paramInt);
  
  public abstract void setStatis_recharge_first_consume_status(int paramInt);
  
  public abstract void setTotal_cash_amt(long paramLong);
  
  public abstract void setInner_save_amt(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\QingfuInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */