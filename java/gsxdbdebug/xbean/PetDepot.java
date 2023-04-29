package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface PetDepot
  extends Bean
{
  public abstract PetDepot copy();
  
  public abstract PetDepot toData();
  
  public abstract PetDepot toBean();
  
  public abstract PetDepot toDataIf();
  
  public abstract PetDepot toBeanIf();
  
  public abstract int getDepotsize();
  
  public abstract Map<Long, Pet> getPetmap();
  
  public abstract Map<Long, Pet> getPetmapAsData();
  
  public abstract void setDepotsize(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetDepot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */