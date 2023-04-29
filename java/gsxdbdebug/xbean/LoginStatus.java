package xbean;

import xdb.Bean;

public abstract interface LoginStatus
  extends Bean
{
  public abstract LoginStatus copy();
  
  public abstract LoginStatus toData();
  
  public abstract LoginStatus toBean();
  
  public abstract LoginStatus toDataIf();
  
  public abstract LoginStatus toBeanIf();
  
  public abstract int getStatus();
  
  public abstract void setStatus(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LoginStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */