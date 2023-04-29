package xbean;

import xdb.Bean;

public abstract interface BanquestSessionInfo
  extends Bean
{
  public abstract BanquestSessionInfo copy();
  
  public abstract BanquestSessionInfo toData();
  
  public abstract BanquestSessionInfo toBean();
  
  public abstract BanquestSessionInfo toDataIf();
  
  public abstract BanquestSessionInfo toBeanIf();
  
  public abstract long getBanquestendsessionid();
  
  public abstract long getBanquestsessionid();
  
  public abstract long getClearcontrollersessionid();
  
  public abstract void setBanquestendsessionid(long paramLong);
  
  public abstract void setBanquestsessionid(long paramLong);
  
  public abstract void setClearcontrollersessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BanquestSessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */