package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface AuctionPeriodInfo
  extends Bean
{
  public static final int BIDDING = 0;
  public static final int BID_CLOSE = 1;
  
  public abstract AuctionPeriodInfo copy();
  
  public abstract AuctionPeriodInfo toData();
  
  public abstract AuctionPeriodInfo toBean();
  
  public abstract AuctionPeriodInfo toDataIf();
  
  public abstract AuctionPeriodInfo toBeanIf();
  
  public abstract Map<Integer, AuctionTurnInfo> getTurnindex2turninfo();
  
  public abstract Map<Integer, AuctionTurnInfo> getTurnindex2turninfoAsData();
  
  public abstract long getPeriodstarttimestamp();
  
  public abstract long getPeriodendtimestamp();
  
  public abstract int getStatus();
  
  public abstract void setPeriodstarttimestamp(long paramLong);
  
  public abstract void setPeriodendtimestamp(long paramLong);
  
  public abstract void setStatus(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AuctionPeriodInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */