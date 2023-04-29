package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface ArenaTmp
  extends Bean
{
  public abstract ArenaTmp copy();
  
  public abstract ArenaTmp toData();
  
  public abstract ArenaTmp toBean();
  
  public abstract ArenaTmp toDataIf();
  
  public abstract ArenaTmp toBeanIf();
  
  public abstract long getWorld();
  
  public abstract Set<Long> getFights();
  
  public abstract Set<Long> getFightsAsData();
  
  public abstract void setWorld(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ArenaTmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */