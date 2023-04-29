package xbean;

import xdb.Bean;

public abstract interface RolePKInformation
  extends Bean
{
  public abstract RolePKInformation copy();
  
  public abstract RolePKInformation toData();
  
  public abstract RolePKInformation toBean();
  
  public abstract RolePKInformation toDataIf();
  
  public abstract RolePKInformation toBeanIf();
  
  public abstract int getUpdate_time();
  
  public abstract int getPk_mode_expire_time();
  
  public abstract int getProtection_expire_time();
  
  public abstract int getForce_protection_expire_time();
  
  public abstract int getActive_pk_times();
  
  public abstract int getPk_death_times();
  
  public abstract int getBought_moral_value();
  
  public abstract void setUpdate_time(int paramInt);
  
  public abstract void setPk_mode_expire_time(int paramInt);
  
  public abstract void setProtection_expire_time(int paramInt);
  
  public abstract void setForce_protection_expire_time(int paramInt);
  
  public abstract void setActive_pk_times(int paramInt);
  
  public abstract void setPk_death_times(int paramInt);
  
  public abstract void setBought_moral_value(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RolePKInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */