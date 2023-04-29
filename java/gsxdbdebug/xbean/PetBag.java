package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface PetBag
  extends Bean
{
  public abstract PetBag copy();
  
  public abstract PetBag toData();
  
  public abstract PetBag toBean();
  
  public abstract PetBag toDataIf();
  
  public abstract PetBag toBeanIf();
  
  public abstract long getFightpet();
  
  public abstract long getShowpet();
  
  public abstract int getBagsize();
  
  public abstract Map<Long, Pet> getPetmap();
  
  public abstract Map<Long, Pet> getPetmapAsData();
  
  public abstract void setFightpet(long paramLong);
  
  public abstract void setShowpet(long paramLong);
  
  public abstract void setBagsize(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */