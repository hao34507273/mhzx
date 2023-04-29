package xbean;

import xdb.Bean;

public abstract interface ShoppingGroupSessionInfo
  extends Bean
{
  public abstract ShoppingGroupSessionInfo copy();
  
  public abstract ShoppingGroupSessionInfo toData();
  
  public abstract ShoppingGroupSessionInfo toBean();
  
  public abstract ShoppingGroupSessionInfo toDataIf();
  
  public abstract ShoppingGroupSessionInfo toBeanIf();
  
  public abstract long getSession_id();
  
  public abstract void setSession_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ShoppingGroupSessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */