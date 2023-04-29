package xbean;

import xdb.Bean;

public abstract interface ExchangeAwardInfo
  extends Bean
{
  public abstract ExchangeAwardInfo copy();
  
  public abstract ExchangeAwardInfo toData();
  
  public abstract ExchangeAwardInfo toBean();
  
  public abstract ExchangeAwardInfo toDataIf();
  
  public abstract ExchangeAwardInfo toBeanIf();
  
  public abstract int getExchange_times();
  
  public abstract void setExchange_times(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ExchangeAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */