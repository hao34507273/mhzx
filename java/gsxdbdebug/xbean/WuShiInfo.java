package xbean;

import xdb.Bean;

public abstract interface WuShiInfo
  extends Bean
{
  public abstract WuShiInfo copy();
  
  public abstract WuShiInfo toData();
  
  public abstract WuShiInfo toBean();
  
  public abstract WuShiInfo toDataIf();
  
  public abstract WuShiInfo toBeanIf();
  
  public abstract int getIsactivate();
  
  public abstract int getFragmentcount();
  
  public abstract void setIsactivate(int paramInt);
  
  public abstract void setFragmentcount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WuShiInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */