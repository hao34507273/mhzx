package xbean;

import xdb.Bean;

public abstract interface GlobalMakeUpInfo
  extends Bean
{
  public abstract GlobalMakeUpInfo copy();
  
  public abstract GlobalMakeUpInfo toData();
  
  public abstract GlobalMakeUpInfo toBean();
  
  public abstract GlobalMakeUpInfo toDataIf();
  
  public abstract GlobalMakeUpInfo toBeanIf();
  
  public abstract int getTurn();
  
  public abstract boolean getQuetioning();
  
  public abstract long getPreparesessionid();
  
  public abstract void setTurn(int paramInt);
  
  public abstract void setQuetioning(boolean paramBoolean);
  
  public abstract void setPreparesessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GlobalMakeUpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */