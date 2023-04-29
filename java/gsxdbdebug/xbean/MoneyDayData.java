package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MoneyDayData
  extends Bean
{
  public abstract MoneyDayData copy();
  
  public abstract MoneyDayData toData();
  
  public abstract MoneyDayData toBean();
  
  public abstract MoneyDayData toDataIf();
  
  public abstract MoneyDayData toBeanIf();
  
  public abstract long getStarttime();
  
  public abstract Map<Integer, SingleMoneyDayData> getMoneyinfo();
  
  public abstract Map<Integer, SingleMoneyDayData> getMoneyinfoAsData();
  
  public abstract void setStarttime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MoneyDayData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */