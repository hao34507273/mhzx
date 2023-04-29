package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface PetSoulBag
  extends Bean
{
  public abstract PetSoulBag copy();
  
  public abstract PetSoulBag toData();
  
  public abstract PetSoulBag toBean();
  
  public abstract PetSoulBag toDataIf();
  
  public abstract PetSoulBag toBeanIf();
  
  public abstract Map<Integer, PetSoul> getSoulmap();
  
  public abstract Map<Integer, PetSoul> getSoulmapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetSoulBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */