package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface RoleMarketInfo
  extends Bean
{
  public abstract RoleMarketInfo copy();
  
  public abstract RoleMarketInfo toData();
  
  public abstract RoleMarketInfo toBean();
  
  public abstract RoleMarketInfo toDataIf();
  
  public abstract RoleMarketInfo toBeanIf();
  
  public abstract List<Long> getConcern_item_ids();
  
  public abstract List<Long> getConcern_item_idsAsData();
  
  public abstract List<Long> getConcern_pet_ids();
  
  public abstract List<Long> getConcern_pet_idsAsData();
  
  public abstract List<Long> getOnshelf_item_ids();
  
  public abstract List<Long> getOnshelf_item_idsAsData();
  
  public abstract List<Long> getOnshelf_pet_ids();
  
  public abstract List<Long> getOnshelf_pet_idsAsData();
  
  public abstract long getSale_gold_num();
  
  public abstract Map<Long, MarketItem> getMarketid2timeoutorselleditem();
  
  public abstract Map<Long, MarketItem> getMarketid2timeoutorselleditemAsData();
  
  public abstract Map<Long, MarketPet> getMarketid2timeoutorselledpet();
  
  public abstract Map<Long, MarketPet> getMarketid2timeoutorselledpetAsData();
  
  public abstract void setSale_gold_num(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleMarketInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */