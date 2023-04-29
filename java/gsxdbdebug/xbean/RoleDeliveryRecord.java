package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleDeliveryRecord
  extends Bean
{
  public abstract RoleDeliveryRecord copy();
  
  public abstract RoleDeliveryRecord toData();
  
  public abstract RoleDeliveryRecord toBean();
  
  public abstract RoleDeliveryRecord toDataIf();
  
  public abstract RoleDeliveryRecord toBeanIf();
  
  public abstract Map<Integer, RoleDeliveryStatus> getStatuses();
  
  public abstract Map<Integer, RoleDeliveryStatus> getStatusesAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleDeliveryRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */