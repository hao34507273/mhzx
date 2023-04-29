package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface AuctionActivityInfo
  extends Bean
{
  public abstract AuctionActivityInfo copy();
  
  public abstract AuctionActivityInfo toData();
  
  public abstract AuctionActivityInfo toBean();
  
  public abstract AuctionActivityInfo toDataIf();
  
  public abstract AuctionActivityInfo toBeanIf();
  
  public abstract AuctionPeriodInfo getLastperiodinfo();
  
  public abstract AuctionPeriodInfo getCurrentperiodinfo();
  
  public abstract Map<Long, AuctionMergeInfo> getRoleid2mergeinfo();
  
  public abstract Map<Long, AuctionMergeInfo> getRoleid2mergeinfoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AuctionActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */