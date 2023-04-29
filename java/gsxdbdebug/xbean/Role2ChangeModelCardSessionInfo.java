package xbean;

import xdb.Bean;

public abstract interface Role2ChangeModelCardSessionInfo
  extends Bean
{
  public abstract Role2ChangeModelCardSessionInfo copy();
  
  public abstract Role2ChangeModelCardSessionInfo toData();
  
  public abstract Role2ChangeModelCardSessionInfo toBean();
  
  public abstract Role2ChangeModelCardSessionInfo toDataIf();
  
  public abstract Role2ChangeModelCardSessionInfo toBeanIf();
  
  public abstract long getMain_session_id();
  
  public abstract long getExpire_notify_session_id();
  
  public abstract void setMain_session_id(long paramLong);
  
  public abstract void setExpire_notify_session_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2ChangeModelCardSessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */