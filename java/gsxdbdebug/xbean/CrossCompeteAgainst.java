package xbean;

import xdb.Bean;

public abstract interface CrossCompeteAgainst
  extends Bean
{
  public abstract CrossCompeteAgainst copy();
  
  public abstract CrossCompeteAgainst toData();
  
  public abstract CrossCompeteAgainst toBean();
  
  public abstract CrossCompeteAgainst toDataIf();
  
  public abstract CrossCompeteAgainst toBeanIf();
  
  public abstract CrossCompeteMatchFaction getFront_faction();
  
  public abstract CrossCompeteMatchFaction getBehind_faction();
  
  public abstract int getCompete_index();
  
  public abstract int getRoam_serverid();
  
  public abstract long getWinner();
  
  public abstract long getMercenary_faction();
  
  public abstract void setCompete_index(int paramInt);
  
  public abstract void setRoam_serverid(int paramInt);
  
  public abstract void setWinner(long paramLong);
  
  public abstract void setMercenary_faction(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossCompeteAgainst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */