package xbean;

import xdb.Bean;

public abstract interface GMStatus
  extends Bean
{
  public static final int GM_ON = 1;
  public static final int GM_OFF = 2;
  
  public abstract GMStatus copy();
  
  public abstract GMStatus toData();
  
  public abstract GMStatus toBean();
  
  public abstract GMStatus toDataIf();
  
  public abstract GMStatus toBeanIf();
  
  public abstract int getStatus();
  
  public abstract void setStatus(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GMStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */