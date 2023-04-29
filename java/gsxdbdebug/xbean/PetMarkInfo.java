package xbean;

import xdb.Bean;

public abstract interface PetMarkInfo
  extends Bean
{
  public abstract PetMarkInfo copy();
  
  public abstract PetMarkInfo toData();
  
  public abstract PetMarkInfo toBean();
  
  public abstract PetMarkInfo toDataIf();
  
  public abstract PetMarkInfo toBeanIf();
  
  public abstract int getPet_mark_cfg_id();
  
  public abstract int getLevel();
  
  public abstract int getExp();
  
  public abstract long getPet_id();
  
  public abstract void setPet_mark_cfg_id(int paramInt);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setExp(int paramInt);
  
  public abstract void setPet_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetMarkInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */