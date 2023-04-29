package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CatBag
  extends Bean
{
  public abstract CatBag copy();
  
  public abstract CatBag toData();
  
  public abstract CatBag toBean();
  
  public abstract CatBag toDataIf();
  
  public abstract CatBag toBeanIf();
  
  public abstract Map<Long, CatInfo> getCats();
  
  public abstract Map<Long, CatInfo> getCatsAsData();
  
  public abstract Map<Long, Item> getItems();
  
  public abstract Map<Long, Item> getItemsAsData();
  
  public abstract FeedInfo getFeed_info();
  
  public abstract Map<Integer, Integer> getAward_info();
  
  public abstract Map<Integer, Integer> getAward_infoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CatBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */