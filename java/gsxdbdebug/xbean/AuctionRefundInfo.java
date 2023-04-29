package xbean;

import xdb.Bean;

public abstract interface AuctionRefundInfo
  extends Bean
{
  public abstract AuctionRefundInfo copy();
  
  public abstract AuctionRefundInfo toData();
  
  public abstract AuctionRefundInfo toBean();
  
  public abstract AuctionRefundInfo toDataIf();
  
  public abstract AuctionRefundInfo toBeanIf();
  
  public abstract long getActivityperiodstarttimestamp();
  
  public abstract long getActivityperiodendtimestamp();
  
  public abstract int getTurnindex();
  
  public abstract long getTurnstarttimestamp();
  
  public abstract long getTurnendtimestamp();
  
  public abstract int getItemcfgid();
  
  public abstract long getMoneycount();
  
  public abstract void setActivityperiodstarttimestamp(long paramLong);
  
  public abstract void setActivityperiodendtimestamp(long paramLong);
  
  public abstract void setTurnindex(int paramInt);
  
  public abstract void setTurnstarttimestamp(long paramLong);
  
  public abstract void setTurnendtimestamp(long paramLong);
  
  public abstract void setItemcfgid(int paramInt);
  
  public abstract void setMoneycount(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AuctionRefundInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */