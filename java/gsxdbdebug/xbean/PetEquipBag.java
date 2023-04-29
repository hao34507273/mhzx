package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface PetEquipBag
  extends Bean
{
  public static final int EQUIP_POS_HELMET = 0;
  public static final int EQUIP_POS_NECKLACE = 1;
  public static final int EQUIP_POS_AMULET = 2;
  public static final int EQUIP_POS_DECORATE = 3;
  
  public abstract PetEquipBag copy();
  
  public abstract PetEquipBag toData();
  
  public abstract PetEquipBag toBean();
  
  public abstract PetEquipBag toDataIf();
  
  public abstract PetEquipBag toBeanIf();
  
  public abstract Map<Integer, Item> getEquip2item();
  
  public abstract Map<Integer, Item> getEquip2itemAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetEquipBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */