package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface AuctionPetInfo
  extends Bean
{
  public abstract AuctionPetInfo copy();
  
  public abstract AuctionPetInfo toData();
  
  public abstract AuctionPetInfo toBean();
  
  public abstract AuctionPetInfo toDataIf();
  
  public abstract AuctionPetInfo toBeanIf();
  
  public abstract long getAuctionroleid();
  
  public abstract long getEndtime();
  
  public abstract int getAuctioncount();
  
  public abstract int getAuctionprice();
  
  public abstract int getPetcfgid();
  
  public abstract Set<Long> getAuctionroleset();
  
  public abstract Set<Long> getAuctionrolesetAsData();
  
  public abstract boolean getIssendtip();
  
  public abstract void setAuctionroleid(long paramLong);
  
  public abstract void setEndtime(long paramLong);
  
  public abstract void setAuctioncount(int paramInt);
  
  public abstract void setAuctionprice(int paramInt);
  
  public abstract void setPetcfgid(int paramInt);
  
  public abstract void setIssendtip(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AuctionPetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */