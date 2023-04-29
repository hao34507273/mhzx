package xbean;

import xdb.Bean;

public abstract interface FeiShengInfo
  extends Bean
{
  public abstract FeiShengInfo copy();
  
  public abstract FeiShengInfo toData();
  
  public abstract FeiShengInfo toBean();
  
  public abstract FeiShengInfo toDataIf();
  
  public abstract FeiShengInfo toBeanIf();
  
  public abstract boolean getIs_activity_complete();
  
  public abstract boolean getHave_get_activity_award();
  
  public abstract boolean getAlready_play_effect();
  
  public abstract void setIs_activity_complete(boolean paramBoolean);
  
  public abstract void setHave_get_activity_award(boolean paramBoolean);
  
  public abstract void setAlready_play_effect(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FeiShengInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */