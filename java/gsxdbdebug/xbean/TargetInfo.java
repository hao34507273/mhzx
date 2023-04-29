package xbean;

import xdb.Bean;

public abstract interface TargetInfo
  extends Bean
{
  public abstract TargetInfo copy();
  
  public abstract TargetInfo toData();
  
  public abstract TargetInfo toBean();
  
  public abstract TargetInfo toDataIf();
  
  public abstract TargetInfo toBeanIf();
  
  public abstract int getTargettype();
  
  public abstract int getTargetstate();
  
  public abstract int getTargetparam();
  
  public abstract void setTargettype(int paramInt);
  
  public abstract void setTargetstate(int paramInt);
  
  public abstract void setTargetparam(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TargetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */