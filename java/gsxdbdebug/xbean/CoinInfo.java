package xbean;

import xdb.Bean;

public abstract interface CoinInfo
  extends Bean
{
  public abstract CoinInfo copy();
  
  public abstract CoinInfo toData();
  
  public abstract CoinInfo toBean();
  
  public abstract CoinInfo toDataIf();
  
  public abstract CoinInfo toBeanIf();
  
  public abstract long getSrc_total();
  
  public abstract long getSrc_total_cost();
  
  public abstract long getSrc_reset_time();
  
  public abstract long getDst_total();
  
  public abstract long getDst_total_cost();
  
  public abstract long getDst_reset_time();
  
  public abstract void setSrc_total(long paramLong);
  
  public abstract void setSrc_total_cost(long paramLong);
  
  public abstract void setSrc_reset_time(long paramLong);
  
  public abstract void setDst_total(long paramLong);
  
  public abstract void setDst_total_cost(long paramLong);
  
  public abstract void setDst_reset_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CoinInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */