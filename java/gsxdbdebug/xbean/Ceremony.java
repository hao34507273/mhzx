package xbean;

import xdb.Bean;

public abstract interface Ceremony
  extends Bean
{
  public abstract Ceremony copy();
  
  public abstract Ceremony toData();
  
  public abstract Ceremony toBean();
  
  public abstract Ceremony toDataIf();
  
  public abstract Ceremony toBeanIf();
  
  public abstract long getRoleid1();
  
  public abstract long getRoleid2();
  
  public abstract int getStage();
  
  public abstract int getLevel();
  
  public abstract void setRoleid1(long paramLong);
  
  public abstract void setRoleid2(long paramLong);
  
  public abstract void setStage(int paramInt);
  
  public abstract void setLevel(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Ceremony.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */