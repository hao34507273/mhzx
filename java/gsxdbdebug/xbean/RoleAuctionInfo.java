package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface RoleAuctionInfo
  extends Bean
{
  public abstract RoleAuctionInfo copy();
  
  public abstract RoleAuctionInfo toData();
  
  public abstract RoleAuctionInfo toBean();
  
  public abstract RoleAuctionInfo toDataIf();
  
  public abstract RoleAuctionInfo toBeanIf();
  
  public abstract List<Long> getAuction_item_ids();
  
  public abstract List<Long> getAuction_item_idsAsData();
  
  public abstract List<Long> getAuction_pet_ids();
  
  public abstract List<Long> getAuction_pet_idsAsData();
  
  public abstract Map<Long, Item> getMarketid2auctionitem();
  
  public abstract Map<Long, Item> getMarketid2auctionitemAsData();
  
  public abstract Map<Long, Pet> getMarketid2auctionpet();
  
  public abstract Map<Long, Pet> getMarketid2auctionpetAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleAuctionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */