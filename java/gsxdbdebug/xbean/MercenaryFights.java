package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface MercenaryFights
  extends Bean
{
  public abstract MercenaryFights copy();
  
  public abstract MercenaryFights toData();
  
  public abstract MercenaryFights toBean();
  
  public abstract MercenaryFights toDataIf();
  
  public abstract MercenaryFights toBeanIf();
  
  public abstract Set<Long> getFights();
  
  public abstract Set<Long> getFightsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MercenaryFights.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */