package xbean;

import xdb.Bean;

public abstract interface DeleteState
  extends Bean
{
  public abstract DeleteState copy();
  
  public abstract DeleteState toData();
  
  public abstract DeleteState toBean();
  
  public abstract DeleteState toDataIf();
  
  public abstract DeleteState toBeanIf();
  
  public abstract int getDeletestate();
  
  public abstract long getDeleteendtime();
  
  public abstract void setDeletestate(int paramInt);
  
  public abstract void setDeleteendtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DeleteState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */