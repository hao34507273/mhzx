package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MarketEquipConSet
  extends Bean
{
  public abstract MarketEquipConSet copy();
  
  public abstract MarketEquipConSet toData();
  
  public abstract MarketEquipConSet toBean();
  
  public abstract MarketEquipConSet toDataIf();
  
  public abstract MarketEquipConSet toBeanIf();
  
  public abstract List<MarketEquipCon> getEquipcons();
  
  public abstract List<MarketEquipCon> getEquipconsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MarketEquipConSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */