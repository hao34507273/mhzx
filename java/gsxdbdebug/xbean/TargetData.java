package xbean;

import xdb.Bean;

public abstract interface TargetData
  extends Bean
{
  public abstract TargetData copy();
  
  public abstract TargetData toData();
  
  public abstract TargetData toBean();
  
  public abstract TargetData toDataIf();
  
  public abstract TargetData toBeanIf();
  
  public abstract int getTargetid();
  
  public abstract int getTargetstate();
  
  public abstract int getTargetparam();
  
  public abstract void setTargetid(int paramInt);
  
  public abstract void setTargetstate(int paramInt);
  
  public abstract void setTargetparam(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TargetData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */