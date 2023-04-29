package xbean;

import java.util.List;
import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface DeliveryStatus
  extends Bean
{
  public abstract DeliveryStatus copy();
  
  public abstract DeliveryStatus toData();
  
  public abstract DeliveryStatus toBean();
  
  public abstract DeliveryStatus toDataIf();
  
  public abstract DeliveryStatus toBeanIf();
  
  public abstract int getDelivery_count();
  
  public abstract List<Long> getRecycled_item_list();
  
  public abstract List<Long> getRecycled_item_listAsData();
  
  public abstract Map<Long, Integer> getItem_holders();
  
  public abstract Map<Long, Integer> getItem_holdersAsData();
  
  public abstract int getSend_card_count();
  
  public abstract Set<Long> getMail_receivers();
  
  public abstract Set<Long> getMail_receiversAsData();
  
  public abstract void setDelivery_count(int paramInt);
  
  public abstract void setSend_card_count(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DeliveryStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */