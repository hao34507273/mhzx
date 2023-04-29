package xbean;

import xdb.Bean;

public abstract interface RoleMultiFightValueBean
  extends Bean
{
  public abstract RoleMultiFightValueBean copy();
  
  public abstract RoleMultiFightValueBean toData();
  
  public abstract RoleMultiFightValueBean toBean();
  
  public abstract RoleMultiFightValueBean toDataIf();
  
  public abstract RoleMultiFightValueBean toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract void setRoleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleMultiFightValueBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */