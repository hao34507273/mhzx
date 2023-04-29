package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface AuctionItemInfo
  extends Bean
{
  public abstract AuctionItemInfo copy();
  
  public abstract AuctionItemInfo toData();
  
  public abstract AuctionItemInfo toBean();
  
  public abstract AuctionItemInfo toDataIf();
  
  public abstract AuctionItemInfo toBeanIf();
  
  public abstract long getAuctionroleid();
  
  public abstract long getEndtime();
  
  public abstract int getAuctioncount();
  
  public abstract int getAuctionprice();
  
  public abstract int getItemid();
  
  public abstract Set<Long> getAuctionroleset();
  
  public abstract Set<Long> getAuctionrolesetAsData();
  
  public abstract int getItemnum();
  
  public abstract boolean getIssendtip();
  
  public abstract void setAuctionroleid(long paramLong);
  
  public abstract void setEndtime(long paramLong);
  
  public abstract void setAuctioncount(int paramInt);
  
  public abstract void setAuctionprice(int paramInt);
  
  public abstract void setItemid(int paramInt);
  
  public abstract void setItemnum(int paramInt);
  
  public abstract void setIssendtip(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AuctionItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */