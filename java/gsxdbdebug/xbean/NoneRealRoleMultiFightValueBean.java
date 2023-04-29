package xbean;

import xdb.Bean;

public abstract interface NoneRealRoleMultiFightValueBean
  extends Bean
{
  public abstract NoneRealRoleMultiFightValueBean copy();
  
  public abstract NoneRealRoleMultiFightValueBean toData();
  
  public abstract NoneRealRoleMultiFightValueBean toBean();
  
  public abstract NoneRealRoleMultiFightValueBean toDataIf();
  
  public abstract NoneRealRoleMultiFightValueBean toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract int getMultifightvalue();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setMultifightvalue(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NoneRealRoleMultiFightValueBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */