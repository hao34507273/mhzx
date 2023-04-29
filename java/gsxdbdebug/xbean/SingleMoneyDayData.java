package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface SingleMoneyDayData
  extends Bean
{
  public static final int GOLD__YUAN_BAO_BUY = 0;
  public static final int GOLD__TRADE_SOLD = 1;
  
  public abstract SingleMoneyDayData copy();
  
  public abstract SingleMoneyDayData toData();
  
  public abstract SingleMoneyDayData toBean();
  
  public abstract SingleMoneyDayData toDataIf();
  
  public abstract SingleMoneyDayData toBeanIf();
  
  public abstract Map<Integer, Long> getGaintype2value();
  
  public abstract Map<Integer, Long> getGaintype2valueAsData();
  
  public abstract long getTotalvalue();
  
  public abstract boolean getTouchedline();
  
  public abstract void setTotalvalue(long paramLong);
  
  public abstract void setTouchedline(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SingleMoneyDayData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */