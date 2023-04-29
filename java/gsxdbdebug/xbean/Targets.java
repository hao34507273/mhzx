package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface Targets
  extends Bean
{
  public abstract Targets copy();
  
  public abstract Targets toData();
  
  public abstract Targets toBean();
  
  public abstract Targets toDataIf();
  
  public abstract Targets toBeanIf();
  
  public abstract Set<Integer> getTargets();
  
  public abstract Set<Integer> getTargetsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Targets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */