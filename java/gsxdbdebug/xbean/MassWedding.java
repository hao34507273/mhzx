package xbean;

import xdb.Bean;

public abstract interface MassWedding
  extends Bean
{
  public static final int END_EARLIER_DEFAULT = 0;
  public static final int END_EARLIER_TRUE = 1;
  
  public abstract MassWedding copy();
  
  public abstract MassWedding toData();
  
  public abstract MassWedding toBean();
  
  public abstract MassWedding toDataIf();
  
  public abstract MassWedding toBeanIf();
  
  public abstract long getWorldid();
  
  public abstract int getEndearlier();
  
  public abstract int getStage();
  
  public abstract void setWorldid(long paramLong);
  
  public abstract void setEndearlier(int paramInt);
  
  public abstract void setStage(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MassWedding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */