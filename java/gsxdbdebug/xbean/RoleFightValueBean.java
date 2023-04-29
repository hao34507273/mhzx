package xbean;

import xdb.Bean;

public abstract interface RoleFightValueBean
  extends Bean
{
  public abstract RoleFightValueBean copy();
  
  public abstract RoleFightValueBean toData();
  
  public abstract RoleFightValueBean toBean();
  
  public abstract RoleFightValueBean toDataIf();
  
  public abstract RoleFightValueBean toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract void setRoleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleFightValueBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */