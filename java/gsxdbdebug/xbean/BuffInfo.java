package xbean;

import xdb.Bean;

public abstract interface BuffInfo
  extends Bean
{
  public abstract BuffInfo copy();
  
  public abstract BuffInfo toData();
  
  public abstract BuffInfo toBean();
  
  public abstract BuffInfo toDataIf();
  
  public abstract BuffInfo toBeanIf();
  
  public abstract long getMap_entity_instance_id();
  
  public abstract void setMap_entity_instance_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BuffInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */