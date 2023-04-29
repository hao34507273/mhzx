package xbean;

import xdb.Bean;

public abstract interface BanquestData
  extends Bean
{
  public abstract BanquestData copy();
  
  public abstract BanquestData toData();
  
  public abstract BanquestData toBean();
  
  public abstract BanquestData toDataIf();
  
  public abstract BanquestData toBeanIf();
  
  public abstract long getStarttime();
  
  public abstract void setStarttime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BanquestData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */