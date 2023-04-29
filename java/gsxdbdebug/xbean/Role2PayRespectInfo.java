package xbean;

import xdb.Bean;

public abstract interface Role2PayRespectInfo
  extends Bean
{
  public abstract Role2PayRespectInfo copy();
  
  public abstract Role2PayRespectInfo toData();
  
  public abstract Role2PayRespectInfo toBean();
  
  public abstract Role2PayRespectInfo toDataIf();
  
  public abstract Role2PayRespectInfo toBeanIf();
  
  public abstract boolean getMaster_is_paying_respect();
  
  public abstract boolean getApprentice_is_paying_respect();
  
  public abstract void setMaster_is_paying_respect(boolean paramBoolean);
  
  public abstract void setApprentice_is_paying_respect(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2PayRespectInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */