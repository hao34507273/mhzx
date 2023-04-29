package xbean;

import xdb.Bean;

public abstract interface ChangeModelCardInfo
  extends Bean
{
  public abstract ChangeModelCardInfo copy();
  
  public abstract ChangeModelCardInfo toData();
  
  public abstract ChangeModelCardInfo toBean();
  
  public abstract ChangeModelCardInfo toDataIf();
  
  public abstract ChangeModelCardInfo toBeanIf();
  
  public abstract int getCard_cfg_id();
  
  public abstract int getLevel();
  
  public abstract int getExp();
  
  public abstract int getUse_count();
  
  public abstract void setCard_cfg_id(int paramInt);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setExp(int paramInt);
  
  public abstract void setUse_count(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChangeModelCardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */