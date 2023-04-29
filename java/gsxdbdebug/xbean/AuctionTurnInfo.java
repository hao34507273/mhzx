package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface AuctionTurnInfo
  extends Bean
{
  public abstract AuctionTurnInfo copy();
  
  public abstract AuctionTurnInfo toData();
  
  public abstract AuctionTurnInfo toBean();
  
  public abstract AuctionTurnInfo toDataIf();
  
  public abstract AuctionTurnInfo toBeanIf();
  
  public abstract Map<Integer, AucItemInfo> getTemplateid2iteminfo();
  
  public abstract Map<Integer, AucItemInfo> getTemplateid2iteminfoAsData();
  
  public abstract long getTurnstarttimestamp();
  
  public abstract long getTurnendtimestamp();
  
  public abstract void setTurnstarttimestamp(long paramLong);
  
  public abstract void setTurnendtimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AuctionTurnInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */