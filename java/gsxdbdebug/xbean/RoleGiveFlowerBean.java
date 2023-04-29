package xbean;

import xdb.Bean;

public abstract interface RoleGiveFlowerBean
  extends Bean
{
  public abstract RoleGiveFlowerBean copy();
  
  public abstract RoleGiveFlowerBean toData();
  
  public abstract RoleGiveFlowerBean toBean();
  
  public abstract RoleGiveFlowerBean toDataIf();
  
  public abstract RoleGiveFlowerBean toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract int getPoint();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setPoint(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleGiveFlowerBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */