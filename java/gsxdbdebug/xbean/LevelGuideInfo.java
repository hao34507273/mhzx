package xbean;

import xdb.Bean;

public abstract interface LevelGuideInfo
  extends Bean
{
  public abstract LevelGuideInfo copy();
  
  public abstract LevelGuideInfo toData();
  
  public abstract LevelGuideInfo toBean();
  
  public abstract LevelGuideInfo toDataIf();
  
  public abstract LevelGuideInfo toBeanIf();
  
  public abstract int getTargetid();
  
  public abstract int getTargetstate();
  
  public abstract int getTargetparam();
  
  public abstract void setTargetid(int paramInt);
  
  public abstract void setTargetstate(int paramInt);
  
  public abstract void setTargetparam(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LevelGuideInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */