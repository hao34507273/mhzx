package xbean;

import xdb.Bean;

public abstract interface XExtraProBean
  extends Bean
{
  public abstract XExtraProBean copy();
  
  public abstract XExtraProBean toData();
  
  public abstract XExtraProBean toBean();
  
  public abstract XExtraProBean toDataIf();
  
  public abstract XExtraProBean toBeanIf();
  
  public abstract int getProtype();
  
  public abstract int getProvalue();
  
  public abstract int getIslock();
  
  public abstract void setProtype(int paramInt);
  
  public abstract void setProvalue(int paramInt);
  
  public abstract void setIslock(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\XExtraProBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */