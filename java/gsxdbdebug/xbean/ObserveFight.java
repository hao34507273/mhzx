package xbean;

import xdb.Bean;

public abstract interface ObserveFight
  extends Bean
{
  public static final int OBSERVE_ROLE = 0;
  public static final int OBSERVE_MONSTER = 1;
  
  public abstract ObserveFight copy();
  
  public abstract ObserveFight toData();
  
  public abstract ObserveFight toBean();
  
  public abstract ObserveFight toDataIf();
  
  public abstract ObserveFight toBeanIf();
  
  public abstract long getFightid();
  
  public abstract int getObservetype();
  
  public abstract long getObservevalue();
  
  public abstract int getObserveteamtype();
  
  public abstract void setFightid(long paramLong);
  
  public abstract void setObservetype(int paramInt);
  
  public abstract void setObservevalue(long paramLong);
  
  public abstract void setObserveteamtype(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ObserveFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */