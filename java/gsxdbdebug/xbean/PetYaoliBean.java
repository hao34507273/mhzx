package xbean;

import xdb.Bean;

public abstract interface PetYaoliBean
  extends Bean
{
  public abstract PetYaoliBean copy();
  
  public abstract PetYaoliBean toData();
  
  public abstract PetYaoliBean toBean();
  
  public abstract PetYaoliBean toDataIf();
  
  public abstract PetYaoliBean toBeanIf();
  
  public abstract long getPetid();
  
  public abstract long getRoleid();
  
  public abstract void setPetid(long paramLong);
  
  public abstract void setRoleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetYaoliBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */