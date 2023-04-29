package xbean;

import xdb.Bean;

public abstract interface JailStatInfo
  extends Bean
{
  public abstract JailStatInfo copy();
  
  public abstract JailStatInfo toData();
  
  public abstract JailStatInfo toBean();
  
  public abstract JailStatInfo toDataIf();
  
  public abstract JailStatInfo toBeanIf();
  
  public abstract int getJailcount();
  
  public abstract void setJailcount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\JailStatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */