package xbean;

import xdb.Bean;

public abstract interface RoleResourcePointInfo
  extends Bean
{
  public abstract RoleResourcePointInfo copy();
  
  public abstract RoleResourcePointInfo toData();
  
  public abstract RoleResourcePointInfo toBean();
  
  public abstract RoleResourcePointInfo toDataIf();
  
  public abstract RoleResourcePointInfo toBeanIf();
  
  public abstract int getResource_point();
  
  public abstract int getAdd_resource_sum();
  
  public abstract boolean getIs_in_field();
  
  public abstract void setResource_point(int paramInt);
  
  public abstract void setAdd_resource_sum(int paramInt);
  
  public abstract void setIs_in_field(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleResourcePointInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */