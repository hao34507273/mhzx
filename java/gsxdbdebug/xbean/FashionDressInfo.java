package xbean;

import xdb.Bean;

public abstract interface FashionDressInfo
  extends Bean
{
  public abstract FashionDressInfo copy();
  
  public abstract FashionDressInfo toData();
  
  public abstract FashionDressInfo toBean();
  
  public abstract FashionDressInfo toDataIf();
  
  public abstract FashionDressInfo toBeanIf();
  
  public abstract long getStart_time();
  
  public abstract long getExtend_time();
  
  public abstract void setStart_time(long paramLong);
  
  public abstract void setExtend_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FashionDressInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */