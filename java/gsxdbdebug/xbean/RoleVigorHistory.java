package xbean;

import xdb.Bean;

public abstract interface RoleVigorHistory
  extends Bean
{
  public abstract RoleVigorHistory copy();
  
  public abstract RoleVigorHistory toData();
  
  public abstract RoleVigorHistory toBean();
  
  public abstract RoleVigorHistory toDataIf();
  
  public abstract RoleVigorHistory toBeanIf();
  
  public abstract int getCount();
  
  public abstract int getVigor();
  
  public abstract void setCount(int paramInt);
  
  public abstract void setVigor(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleVigorHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */