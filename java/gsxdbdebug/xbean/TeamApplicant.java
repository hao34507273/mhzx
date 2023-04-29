package xbean;

import xdb.Bean;

public abstract interface TeamApplicant
  extends Bean
{
  public abstract TeamApplicant copy();
  
  public abstract TeamApplicant toData();
  
  public abstract TeamApplicant toBean();
  
  public abstract TeamApplicant toDataIf();
  
  public abstract TeamApplicant toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract long getRecommender();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setRecommender(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TeamApplicant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */