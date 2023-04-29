package xbean;

import xdb.Bean;

public abstract interface FurnitureInfo
  extends Bean
{
  public abstract FurnitureInfo copy();
  
  public abstract FurnitureInfo toData();
  
  public abstract FurnitureInfo toBean();
  
  public abstract FurnitureInfo toDataIf();
  
  public abstract FurnitureInfo toBeanIf();
  
  public abstract int getX();
  
  public abstract int getY();
  
  public abstract int getDirection();
  
  public abstract int getFurnitureid();
  
  public abstract void setX(int paramInt);
  
  public abstract void setY(int paramInt);
  
  public abstract void setDirection(int paramInt);
  
  public abstract void setFurnitureid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FurnitureInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */