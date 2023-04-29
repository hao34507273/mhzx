package xbean;

import xdb.Bean;

public abstract interface RoleReceiveFlowerBean
  extends Bean
{
  public abstract RoleReceiveFlowerBean copy();
  
  public abstract RoleReceiveFlowerBean toData();
  
  public abstract RoleReceiveFlowerBean toBean();
  
  public abstract RoleReceiveFlowerBean toDataIf();
  
  public abstract RoleReceiveFlowerBean toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract int getPoint();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setPoint(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleReceiveFlowerBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */