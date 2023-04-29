package xbean;

import xdb.Bean;

public abstract interface RoleIndianaNumberInfo
  extends Bean
{
  public abstract RoleIndianaNumberInfo copy();
  
  public abstract RoleIndianaNumberInfo toData();
  
  public abstract RoleIndianaNumberInfo toBean();
  
  public abstract RoleIndianaNumberInfo toDataIf();
  
  public abstract RoleIndianaNumberInfo toBeanIf();
  
  public abstract int getNumber();
  
  public abstract void setNumber(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleIndianaNumberInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */