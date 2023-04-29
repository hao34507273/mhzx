package xbean;

import xdb.Bean;

public abstract interface XMTaskInfo
  extends Bean
{
  public abstract XMTaskInfo copy();
  
  public abstract XMTaskInfo toData();
  
  public abstract XMTaskInfo toBean();
  
  public abstract XMTaskInfo toDataIf();
  
  public abstract XMTaskInfo toBeanIf();
  
  public abstract int getState();
  
  public abstract void setState(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\XMTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */