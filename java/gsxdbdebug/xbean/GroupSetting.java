package xbean;

import xdb.Bean;

public abstract interface GroupSetting
  extends Bean
{
  public abstract GroupSetting copy();
  
  public abstract GroupSetting toData();
  
  public abstract GroupSetting toBean();
  
  public abstract GroupSetting toDataIf();
  
  public abstract GroupSetting toBeanIf();
  
  public abstract int getMessage_state();
  
  public abstract void setMessage_state(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GroupSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */