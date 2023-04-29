package xbean;

import xdb.Bean;

public abstract interface DressedInfo
  extends Bean
{
  public abstract DressedInfo copy();
  
  public abstract DressedInfo toData();
  
  public abstract DressedInfo toBean();
  
  public abstract DressedInfo toDataIf();
  
  public abstract DressedInfo toBeanIf();
  
  public abstract int getFashion_cfgid();
  
  public abstract long getOwner_roleid();
  
  public abstract void setFashion_cfgid(int paramInt);
  
  public abstract void setOwner_roleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DressedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */