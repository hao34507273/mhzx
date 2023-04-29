package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface AuctionMergeInfo
  extends Bean
{
  public abstract AuctionMergeInfo copy();
  
  public abstract AuctionMergeInfo toData();
  
  public abstract AuctionMergeInfo toBean();
  
  public abstract AuctionMergeInfo toDataIf();
  
  public abstract AuctionMergeInfo toBeanIf();
  
  public abstract List<AuctionRefundInfo> getRefundinfolist();
  
  public abstract List<AuctionRefundInfo> getRefundinfolistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AuctionMergeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */