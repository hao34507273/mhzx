package xbean;

import xdb.Bean;

public abstract interface Location
  extends Bean
{
  public abstract Location copy();
  
  public abstract Location toData();
  
  public abstract Location toBean();
  
  public abstract Location toDataIf();
  
  public abstract Location toBeanIf();
  
  public abstract int getX();
  
  public abstract int getY();
  
  public abstract int getZ();
  
  public abstract int getSceneid();
  
  public abstract void setX(int paramInt);
  
  public abstract void setY(int paramInt);
  
  public abstract void setZ(int paramInt);
  
  public abstract void setSceneid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Location.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */