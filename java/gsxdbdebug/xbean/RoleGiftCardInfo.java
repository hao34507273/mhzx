package xbean;

import xdb.Bean;

public abstract interface RoleGiftCardInfo
  extends Bean
{
  public abstract RoleGiftCardInfo copy();
  
  public abstract RoleGiftCardInfo toData();
  
  public abstract RoleGiftCardInfo toBean();
  
  public abstract RoleGiftCardInfo toDataIf();
  
  public abstract RoleGiftCardInfo toBeanIf();
  
  public abstract long getUsetime();
  
  public abstract void setUsetime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleGiftCardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */