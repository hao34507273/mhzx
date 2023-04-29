package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface BossFights
  extends Bean
{
  public abstract BossFights copy();
  
  public abstract BossFights toData();
  
  public abstract BossFights toBean();
  
  public abstract BossFights toDataIf();
  
  public abstract BossFights toBeanIf();
  
  public abstract Set<Long> getFights();
  
  public abstract Set<Long> getFightsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BossFights.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */