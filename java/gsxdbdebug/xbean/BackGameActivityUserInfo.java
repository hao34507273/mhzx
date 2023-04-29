package xbean;

import xdb.Bean;

public abstract interface BackGameActivityUserInfo
  extends Bean
{
  public abstract BackGameActivityUserInfo copy();
  
  public abstract BackGameActivityUserInfo toData();
  
  public abstract BackGameActivityUserInfo toBean();
  
  public abstract BackGameActivityUserInfo toDataIf();
  
  public abstract BackGameActivityUserInfo toBeanIf();
  
  public abstract BackGameActivityRechargeInfo getRechargeinfo();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BackGameActivityUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */