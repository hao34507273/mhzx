package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MarketPetEquipConSet
  extends Bean
{
  public abstract MarketPetEquipConSet copy();
  
  public abstract MarketPetEquipConSet toData();
  
  public abstract MarketPetEquipConSet toBean();
  
  public abstract MarketPetEquipConSet toDataIf();
  
  public abstract MarketPetEquipConSet toBeanIf();
  
  public abstract List<MarketPetEquipCon> getPetequipcons();
  
  public abstract List<MarketPetEquipCon> getPetequipconsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MarketPetEquipConSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */