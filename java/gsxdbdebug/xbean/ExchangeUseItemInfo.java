package xbean;

import xdb.Bean;

public abstract interface ExchangeUseItemInfo
  extends Bean
{
  public abstract ExchangeUseItemInfo copy();
  
  public abstract ExchangeUseItemInfo toData();
  
  public abstract ExchangeUseItemInfo toBean();
  
  public abstract ExchangeUseItemInfo toDataIf();
  
  public abstract ExchangeUseItemInfo toBeanIf();
  
  public abstract int getExchange_times();
  
  public abstract int getDaily_exchange_times();
  
  public abstract long getTimestamp();
  
  public abstract void setExchange_times(int paramInt);
  
  public abstract void setDaily_exchange_times(int paramInt);
  
  public abstract void setTimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ExchangeUseItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */