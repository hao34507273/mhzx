package xbean;

import xdb.Bean;

public abstract interface TempExtraProInfo
  extends Bean
{
  public abstract TempExtraProInfo copy();
  
  public abstract TempExtraProInfo toData();
  
  public abstract TempExtraProInfo toBean();
  
  public abstract TempExtraProInfo toDataIf();
  
  public abstract TempExtraProInfo toBeanIf();
  
  public abstract int getProtype();
  
  public abstract int getProvalue();
  
  public abstract void setProtype(int paramInt);
  
  public abstract void setProvalue(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TempExtraProInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */