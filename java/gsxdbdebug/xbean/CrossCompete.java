package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface CrossCompete
  extends Bean
{
  public abstract CrossCompete copy();
  
  public abstract CrossCompete toData();
  
  public abstract CrossCompete toBean();
  
  public abstract CrossCompete toDataIf();
  
  public abstract CrossCompete toBeanIf();
  
  public abstract Map<Long, CrossCompeteSignUp> getSignup_factions();
  
  public abstract Map<Long, CrossCompeteSignUp> getSignup_factionsAsData();
  
  public abstract int getMatchtimes();
  
  public abstract Map<CrossCompeteMatch, CrossCompeteAgainst> getAgainsts();
  
  public abstract Map<CrossCompeteMatch, CrossCompeteAgainst> getAgainstsAsData();
  
  public abstract Set<Long> getMiss_turn_factions();
  
  public abstract Set<Long> getMiss_turn_factionsAsData();
  
  public abstract void setMatchtimes(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossCompete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */