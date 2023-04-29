package xbean;

import xdb.Bean;

public abstract interface ModelId2DyeId
  extends Bean
{
  public abstract ModelId2DyeId copy();
  
  public abstract ModelId2DyeId toData();
  
  public abstract ModelId2DyeId toBean();
  
  public abstract ModelId2DyeId toDataIf();
  
  public abstract ModelId2DyeId toBeanIf();
  
  public abstract int getModelid();
  
  public abstract int getDyeid();
  
  public abstract void setModelid(int paramInt);
  
  public abstract void setDyeid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ModelId2DyeId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */