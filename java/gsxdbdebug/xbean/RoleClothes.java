package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface RoleClothes
  extends Bean
{
  public abstract RoleClothes copy();
  
  public abstract RoleClothes toData();
  
  public abstract RoleClothes toBean();
  
  public abstract RoleClothes toDataIf();
  
  public abstract RoleClothes toBeanIf();
  
  public abstract int getNextid();
  
  public abstract int getCurid();
  
  public abstract int getDefid();
  
  public abstract int getMaxcount();
  
  public abstract List<ClothColor> getClothes();
  
  public abstract List<ClothColor> getClothesAsData();
  
  public abstract Map<Integer, Integer> getFashion_dress_cloth_map();
  
  public abstract Map<Integer, Integer> getFashion_dress_cloth_mapAsData();
  
  public abstract Map<Integer, TransferOccupationRoleClothes> getTransfer_occupation_role_clothes();
  
  public abstract Map<Integer, TransferOccupationRoleClothes> getTransfer_occupation_role_clothesAsData();
  
  public abstract void setNextid(int paramInt);
  
  public abstract void setCurid(int paramInt);
  
  public abstract void setDefid(int paramInt);
  
  public abstract void setMaxcount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleClothes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */