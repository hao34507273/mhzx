package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface CrossCompeteAgainstTmp
  extends Bean
{
  public abstract CrossCompeteAgainstTmp copy();
  
  public abstract CrossCompeteAgainstTmp toData();
  
  public abstract CrossCompeteAgainstTmp toBean();
  
  public abstract CrossCompeteAgainstTmp toDataIf();
  
  public abstract CrossCompeteAgainstTmp toBeanIf();
  
  public abstract Set<Long> getPvp_fights();
  
  public abstract Set<Long> getPvp_fightsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossCompeteAgainstTmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */