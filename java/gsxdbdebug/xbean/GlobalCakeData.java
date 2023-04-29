package xbean;

import xdb.Bean;

public abstract interface GlobalCakeData
  extends Bean
{
  public abstract GlobalCakeData copy();
  
  public abstract GlobalCakeData toData();
  
  public abstract GlobalCakeData toBean();
  
  public abstract GlobalCakeData toDataIf();
  
  public abstract GlobalCakeData toBeanIf();
  
  public abstract int getCurturn();
  
  public abstract int getCurstage();
  
  public abstract boolean getIsgoing();
  
  public abstract long getStagestarttime();
  
  public abstract boolean getRecovery();
  
  public abstract void setCurturn(int paramInt);
  
  public abstract void setCurstage(int paramInt);
  
  public abstract void setIsgoing(boolean paramBoolean);
  
  public abstract void setStagestarttime(long paramLong);
  
  public abstract void setRecovery(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GlobalCakeData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */