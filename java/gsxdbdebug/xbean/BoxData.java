package xbean;

import xdb.Bean;

public abstract interface BoxData
  extends Bean
{
  public abstract BoxData copy();
  
  public abstract BoxData toData();
  
  public abstract BoxData toBean();
  
  public abstract BoxData toDataIf();
  
  public abstract BoxData toBeanIf();
  
  public abstract int getItemid();
  
  public abstract int getNum();
  
  public abstract long getStarttime();
  
  public abstract void setItemid(int paramInt);
  
  public abstract void setNum(int paramInt);
  
  public abstract void setStarttime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BoxData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */