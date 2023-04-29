package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface OcpEquipBag
  extends Bean
{
  public abstract OcpEquipBag copy();
  
  public abstract OcpEquipBag toData();
  
  public abstract OcpEquipBag toBean();
  
  public abstract OcpEquipBag toDataIf();
  
  public abstract OcpEquipBag toBeanIf();
  
  public abstract Map<Integer, Bag> getOcp2equipbag();
  
  public abstract Map<Integer, Bag> getOcp2equipbagAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\OcpEquipBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */