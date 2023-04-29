package xbean;

import xdb.Bean;

public abstract interface CompetitionAgainst
  extends Bean
{
  public abstract CompetitionAgainst copy();
  
  public abstract CompetitionAgainst toData();
  
  public abstract CompetitionAgainst toBean();
  
  public abstract CompetitionAgainst toDataIf();
  
  public abstract CompetitionAgainst toBeanIf();
  
  public abstract boolean getFinished();
  
  public abstract long getMercenary_faction();
  
  public abstract void setFinished(boolean paramBoolean);
  
  public abstract void setMercenary_faction(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CompetitionAgainst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */