package xbean;

import xdb.Bean;

public abstract interface RoleMysteryVisitorInfo
  extends Bean
{
  public abstract RoleMysteryVisitorInfo copy();
  
  public abstract RoleMysteryVisitorInfo toData();
  
  public abstract RoleMysteryVisitorInfo toBean();
  
  public abstract RoleMysteryVisitorInfo toDataIf();
  
  public abstract RoleMysteryVisitorInfo toBeanIf();
  
  public abstract int getMystery_visitor_cfg_id();
  
  public abstract void setMystery_visitor_cfg_id(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleMysteryVisitorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */