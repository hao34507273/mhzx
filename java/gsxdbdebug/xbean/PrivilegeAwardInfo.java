package xbean;

import xdb.Bean;

public abstract interface PrivilegeAwardInfo
  extends Bean
{
  public abstract PrivilegeAwardInfo copy();
  
  public abstract PrivilegeAwardInfo toData();
  
  public abstract PrivilegeAwardInfo toBean();
  
  public abstract PrivilegeAwardInfo toDataIf();
  
  public abstract PrivilegeAwardInfo toBeanIf();
  
  public abstract long getAward_timestamp();
  
  public abstract int getAward_num();
  
  public abstract void setAward_timestamp(long paramLong);
  
  public abstract void setAward_num(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PrivilegeAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */