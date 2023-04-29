package xbean;

import xdb.Bean;

public abstract interface ActivityFireData
  extends Bean
{
  public abstract ActivityFireData copy();
  
  public abstract ActivityFireData toData();
  
  public abstract ActivityFireData toBean();
  
  public abstract ActivityFireData toDataIf();
  
  public abstract ActivityFireData toBeanIf();
  
  public abstract int getHitawardcount();
  
  public abstract long getUpdatatime();
  
  public abstract void setHitawardcount(int paramInt);
  
  public abstract void setUpdatatime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ActivityFireData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */