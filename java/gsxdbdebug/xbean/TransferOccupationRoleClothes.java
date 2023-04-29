package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface TransferOccupationRoleClothes
  extends Bean
{
  public abstract TransferOccupationRoleClothes copy();
  
  public abstract TransferOccupationRoleClothes toData();
  
  public abstract TransferOccupationRoleClothes toBean();
  
  public abstract TransferOccupationRoleClothes toDataIf();
  
  public abstract TransferOccupationRoleClothes toBeanIf();
  
  public abstract int getNextid();
  
  public abstract int getCurid();
  
  public abstract int getDefid();
  
  public abstract int getMaxcount();
  
  public abstract List<ClothColor> getClothes();
  
  public abstract List<ClothColor> getClothesAsData();
  
  public abstract Map<Integer, Integer> getFashion_dress_cloth_map();
  
  public abstract Map<Integer, Integer> getFashion_dress_cloth_mapAsData();
  
  public abstract void setNextid(int paramInt);
  
  public abstract void setCurid(int paramInt);
  
  public abstract void setDefid(int paramInt);
  
  public abstract void setMaxcount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TransferOccupationRoleClothes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */