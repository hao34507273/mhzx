package xbean;

import xdb.Bean;

public abstract interface NoneRealRoleFightValueBean
  extends Bean
{
  public abstract NoneRealRoleFightValueBean copy();
  
  public abstract NoneRealRoleFightValueBean toData();
  
  public abstract NoneRealRoleFightValueBean toBean();
  
  public abstract NoneRealRoleFightValueBean toDataIf();
  
  public abstract NoneRealRoleFightValueBean toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract int getFightvalue();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setFightvalue(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NoneRealRoleFightValueBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */