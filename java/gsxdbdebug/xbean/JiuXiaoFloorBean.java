package xbean;

import xdb.Bean;

public abstract interface JiuXiaoFloorBean
  extends Bean
{
  public abstract JiuXiaoFloorBean copy();
  
  public abstract JiuXiaoFloorBean toData();
  
  public abstract JiuXiaoFloorBean toBean();
  
  public abstract JiuXiaoFloorBean toDataIf();
  
  public abstract JiuXiaoFloorBean toBeanIf();
  
  public abstract int getIsawarded();
  
  public abstract int getTimesec();
  
  public abstract void setIsawarded(int paramInt);
  
  public abstract void setTimesec(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\JiuXiaoFloorBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */