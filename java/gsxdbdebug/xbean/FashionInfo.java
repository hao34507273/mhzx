package xbean;

import xdb.Bean;

public abstract interface FashionInfo
  extends Bean
{
  public abstract FashionInfo copy();
  
  public abstract FashionInfo toData();
  
  public abstract FashionInfo toBean();
  
  public abstract FashionInfo toDataIf();
  
  public abstract FashionInfo toBeanIf();
  
  public abstract long getStart_time();
  
  public abstract void setStart_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FashionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */