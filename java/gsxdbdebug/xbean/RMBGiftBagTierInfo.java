package xbean;

import xdb.Bean;

public abstract interface RMBGiftBagTierInfo
  extends Bean
{
  public abstract RMBGiftBagTierInfo copy();
  
  public abstract RMBGiftBagTierInfo toData();
  
  public abstract RMBGiftBagTierInfo toBean();
  
  public abstract RMBGiftBagTierInfo toDataIf();
  
  public abstract RMBGiftBagTierInfo toBeanIf();
  
  public abstract int getProduct_serviceid();
  
  public abstract long getBase_num();
  
  public abstract int getAward_times();
  
  public abstract long getAward_timestamp();
  
  public abstract int getAward_cfgid();
  
  public abstract void setProduct_serviceid(int paramInt);
  
  public abstract void setBase_num(long paramLong);
  
  public abstract void setAward_times(int paramInt);
  
  public abstract void setAward_timestamp(long paramLong);
  
  public abstract void setAward_cfgid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RMBGiftBagTierInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */