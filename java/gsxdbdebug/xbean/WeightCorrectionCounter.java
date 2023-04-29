package xbean;

import xdb.Bean;

public abstract interface WeightCorrectionCounter
  extends Bean
{
  public abstract WeightCorrectionCounter copy();
  
  public abstract WeightCorrectionCounter toData();
  
  public abstract WeightCorrectionCounter toBean();
  
  public abstract WeightCorrectionCounter toDataIf();
  
  public abstract WeightCorrectionCounter toBeanIf();
  
  public abstract int getCount();
  
  public abstract long getModifytime();
  
  public abstract void setCount(int paramInt);
  
  public abstract void setModifytime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WeightCorrectionCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */