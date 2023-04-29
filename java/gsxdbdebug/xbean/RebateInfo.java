package xbean;

import xdb.Bean;

public abstract interface RebateInfo
  extends Bean
{
  public abstract RebateInfo copy();
  
  public abstract RebateInfo toData();
  
  public abstract RebateInfo toBean();
  
  public abstract RebateInfo toDataIf();
  
  public abstract RebateInfo toBeanIf();
  
  public abstract int getTotal_num();
  
  public abstract long getReceive_time();
  
  public abstract int getReceive_num();
  
  public abstract void setTotal_num(int paramInt);
  
  public abstract void setReceive_time(long paramLong);
  
  public abstract void setReceive_num(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RebateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */