package xbean;

import xdb.Bean;

public abstract interface CorpsMember
  extends Bean
{
  public abstract CorpsMember copy();
  
  public abstract CorpsMember toData();
  
  public abstract CorpsMember toBean();
  
  public abstract CorpsMember toDataIf();
  
  public abstract CorpsMember toBeanIf();
  
  public abstract long getCorpsid();
  
  public abstract long getJointime();
  
  public abstract int getDuty();
  
  public abstract void setCorpsid(long paramLong);
  
  public abstract void setJointime(long paramLong);
  
  public abstract void setDuty(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CorpsMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */