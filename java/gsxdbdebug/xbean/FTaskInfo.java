package xbean;

import xdb.Bean;

public abstract interface FTaskInfo
  extends Bean
{
  public abstract FTaskInfo copy();
  
  public abstract FTaskInfo toData();
  
  public abstract FTaskInfo toBean();
  
  public abstract FTaskInfo toDataIf();
  
  public abstract FTaskInfo toBeanIf();
  
  public abstract boolean getIsperfect();
  
  public abstract void setIsperfect(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FTaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */