package xbean;

import xdb.Bean;

public abstract interface ClothColor
  extends Bean
{
  public abstract ClothColor copy();
  
  public abstract ClothColor toData();
  
  public abstract ClothColor toBean();
  
  public abstract ClothColor toDataIf();
  
  public abstract ClothColor toBeanIf();
  
  public abstract int getId();
  
  public abstract int getHair();
  
  public abstract int getFashion_dress_cfg_id();
  
  public abstract int getCloth();
  
  public abstract void setId(int paramInt);
  
  public abstract void setHair(int paramInt);
  
  public abstract void setFashion_dress_cfg_id(int paramInt);
  
  public abstract void setCloth(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ClothColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */