package xbean;

import xdb.Bean;

public abstract interface WingProperty
  extends Bean
{
  public abstract WingProperty copy();
  
  public abstract WingProperty toData();
  
  public abstract WingProperty toBean();
  
  public abstract WingProperty toDataIf();
  
  public abstract WingProperty toBeanIf();
  
  public abstract int getPropertytype();
  
  public abstract int getPropertyvalue();
  
  public abstract int getPropertyphase();
  
  public abstract void setPropertytype(int paramInt);
  
  public abstract void setPropertyvalue(int paramInt);
  
  public abstract void setPropertyphase(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WingProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */