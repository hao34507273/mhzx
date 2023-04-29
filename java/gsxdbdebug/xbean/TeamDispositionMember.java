package xbean;

import xdb.Bean;

public abstract interface TeamDispositionMember
  extends Bean
{
  public abstract TeamDispositionMember copy();
  
  public abstract TeamDispositionMember toData();
  
  public abstract TeamDispositionMember toBean();
  
  public abstract TeamDispositionMember toDataIf();
  
  public abstract TeamDispositionMember toBeanIf();
  
  public abstract long getDispositionmemberid();
  
  public abstract int getDispositionmembertype();
  
  public abstract void setDispositionmemberid(long paramLong);
  
  public abstract void setDispositionmembertype(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TeamDispositionMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */