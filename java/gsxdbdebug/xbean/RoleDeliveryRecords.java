package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleDeliveryRecords
  extends Bean
{
  public abstract RoleDeliveryRecords copy();
  
  public abstract RoleDeliveryRecords toData();
  
  public abstract RoleDeliveryRecords toBean();
  
  public abstract RoleDeliveryRecords toDataIf();
  
  public abstract RoleDeliveryRecords toBeanIf();
  
  public abstract Map<Integer, RoleDeliveryRecord> getRecords();
  
  public abstract Map<Integer, RoleDeliveryRecord> getRecordsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleDeliveryRecords.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */