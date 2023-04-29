package xbean;

import xdb.Bean;

public abstract interface XiangFang
  extends Bean
{
  public abstract XiangFang copy();
  
  public abstract XiangFang toData();
  
  public abstract XiangFang toBean();
  
  public abstract XiangFang toDataIf();
  
  public abstract XiangFang toBeanIf();
  
  public abstract int getLevel();
  
  public abstract long getLevelupendtime();
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setLevelupendtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\XiangFang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */