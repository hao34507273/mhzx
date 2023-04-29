package xbean;

import xdb.Bean;

public abstract interface XAwardData
  extends Bean
{
  public abstract XAwardData copy();
  
  public abstract XAwardData toData();
  
  public abstract XAwardData toBean();
  
  public abstract XAwardData toDataIf();
  
  public abstract XAwardData toBeanIf();
  
  public abstract int getAwardglobal();
  
  public abstract int getCount();
  
  public abstract void setAwardglobal(int paramInt);
  
  public abstract void setCount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\XAwardData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */