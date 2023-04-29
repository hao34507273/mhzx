package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleGroupShoppingRecords
  extends Bean
{
  public abstract RoleGroupShoppingRecords copy();
  
  public abstract RoleGroupShoppingRecords toData();
  
  public abstract RoleGroupShoppingRecords toBean();
  
  public abstract RoleGroupShoppingRecords toDataIf();
  
  public abstract RoleGroupShoppingRecords toBeanIf();
  
  public abstract Map<Integer, RoleGroupShoppingRecord> getRecords();
  
  public abstract Map<Integer, RoleGroupShoppingRecord> getRecordsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleGroupShoppingRecords.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */