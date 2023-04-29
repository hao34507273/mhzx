package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MoneyCostDayData
  extends Bean
{
  public abstract MoneyCostDayData copy();
  
  public abstract MoneyCostDayData toData();
  
  public abstract MoneyCostDayData toBean();
  
  public abstract MoneyCostDayData toDataIf();
  
  public abstract MoneyCostDayData toBeanIf();
  
  public abstract long getStarttime();
  
  public abstract Map<Integer, EachMoneyDayCostData> getMoneyinfo();
  
  public abstract Map<Integer, EachMoneyDayCostData> getMoneyinfoAsData();
  
  public abstract void setStarttime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MoneyCostDayData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */