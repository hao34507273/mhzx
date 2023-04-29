package xbean;

import xdb.Bean;

public abstract interface RoleBossBean
  extends Bean
{
  public abstract RoleBossBean copy();
  
  public abstract RoleBossBean toData();
  
  public abstract RoleBossBean toBean();
  
  public abstract RoleBossBean toDataIf();
  
  public abstract RoleBossBean toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract void setRoleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleBossBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */