package xbean;

import xdb.Bean;

public abstract interface MemoryQuestion
  extends Bean
{
  public abstract MemoryQuestion copy();
  
  public abstract MemoryQuestion toData();
  
  public abstract MemoryQuestion toBean();
  
  public abstract MemoryQuestion toDataIf();
  
  public abstract MemoryQuestion toBeanIf();
  
  public abstract int getQuestion_id();
  
  public abstract boolean getAnswer_result();
  
  public abstract long getAnswer_time();
  
  public abstract int getAnswer_id();
  
  public abstract void setQuestion_id(int paramInt);
  
  public abstract void setAnswer_result(boolean paramBoolean);
  
  public abstract void setAnswer_time(long paramLong);
  
  public abstract void setAnswer_id(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MemoryQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */