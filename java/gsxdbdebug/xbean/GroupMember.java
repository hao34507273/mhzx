package xbean;

import xdb.Bean;

public abstract interface GroupMember
  extends Bean
{
  public abstract GroupMember copy();
  
  public abstract GroupMember toData();
  
  public abstract GroupMember toBean();
  
  public abstract GroupMember toDataIf();
  
  public abstract GroupMember toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract long getJoin_time();
  
  public abstract long getGroup_basic_info_version();
  
  public abstract long getGroup_info_version();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setJoin_time(long paramLong);
  
  public abstract void setGroup_basic_info_version(long paramLong);
  
  public abstract void setGroup_info_version(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GroupMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */