package xbean;

import xdb.Bean;

public abstract interface AccountNumBean
  extends Bean
{
  public abstract AccountNumBean copy();
  
  public abstract AccountNumBean toData();
  
  public abstract AccountNumBean toBean();
  
  public abstract AccountNumBean toDataIf();
  
  public abstract AccountNumBean toBeanIf();
  
  public abstract int getUsernum();
  
  public abstract void setUsernum(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AccountNumBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */