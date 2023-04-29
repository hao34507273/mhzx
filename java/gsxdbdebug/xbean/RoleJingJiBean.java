package xbean;

import xdb.Bean;

public abstract interface RoleJingJiBean
  extends Bean
{
  public abstract RoleJingJiBean copy();
  
  public abstract RoleJingJiBean toData();
  
  public abstract RoleJingJiBean toBean();
  
  public abstract RoleJingJiBean toDataIf();
  
  public abstract RoleJingJiBean toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract int getPoint();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setPoint(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleJingJiBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */