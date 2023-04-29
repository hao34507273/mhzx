package xbean;

import xdb.Bean;

public abstract interface GlobleKeJuInfo
  extends Bean
{
  public abstract GlobleKeJuInfo copy();
  
  public abstract GlobleKeJuInfo toData();
  
  public abstract GlobleKeJuInfo toBean();
  
  public abstract GlobleKeJuInfo toDataIf();
  
  public abstract GlobleKeJuInfo toBeanIf();
  
  public abstract long getWorldid();
  
  public abstract void setWorldid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GlobleKeJuInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */