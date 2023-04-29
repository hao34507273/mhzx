package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface DeliveryStatuses
  extends Bean
{
  public abstract DeliveryStatuses copy();
  
  public abstract DeliveryStatuses toData();
  
  public abstract DeliveryStatuses toBean();
  
  public abstract DeliveryStatuses toDataIf();
  
  public abstract DeliveryStatuses toBeanIf();
  
  public abstract int getDate();
  
  public abstract Map<Integer, DeliveryStatus> getStatuses();
  
  public abstract Map<Integer, DeliveryStatus> getStatusesAsData();
  
  public abstract void setDate(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DeliveryStatuses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */