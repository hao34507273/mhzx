package xbean;

import xdb.Bean;

public abstract interface GatherItemData
  extends Bean
{
  public abstract GatherItemData copy();
  
  public abstract GatherItemData toData();
  
  public abstract GatherItemData toBean();
  
  public abstract GatherItemData toDataIf();
  
  public abstract GatherItemData toBeanIf();
  
  public abstract int getGathercfgid();
  
  public abstract boolean getGathering();
  
  public abstract void setGathercfgid(int paramInt);
  
  public abstract void setGathering(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GatherItemData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */