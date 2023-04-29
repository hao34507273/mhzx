package xbean;

import xdb.Bean;

public abstract interface DoubleTime
  extends Bean
{
  public abstract DoubleTime copy();
  
  public abstract DoubleTime toData();
  
  public abstract DoubleTime toBean();
  
  public abstract DoubleTime toDataIf();
  
  public abstract DoubleTime toBeanIf();
  
  public abstract long getPointoffertime();
  
  public abstract long getItemcountcleartime();
  
  public abstract void setPointoffertime(long paramLong);
  
  public abstract void setItemcountcleartime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DoubleTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */