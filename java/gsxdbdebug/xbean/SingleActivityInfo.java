package xbean;

import xdb.Bean;

public abstract interface SingleActivityInfo
  extends Bean
{
  public abstract SingleActivityInfo copy();
  
  public abstract SingleActivityInfo toData();
  
  public abstract SingleActivityInfo toBean();
  
  public abstract SingleActivityInfo toDataIf();
  
  public abstract SingleActivityInfo toBeanIf();
  
  public abstract int getLastgraphid();
  
  public abstract void setLastgraphid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SingleActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */