package xbean;

import xdb.Bean;

public abstract interface RoleLevelBean
  extends Bean
{
  public abstract RoleLevelBean copy();
  
  public abstract RoleLevelBean toData();
  
  public abstract RoleLevelBean toBean();
  
  public abstract RoleLevelBean toDataIf();
  
  public abstract RoleLevelBean toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract void setRoleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleLevelBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */