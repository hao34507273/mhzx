package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface LadderActivity
  extends Bean
{
  public abstract LadderActivity copy();
  
  public abstract LadderActivity toData();
  
  public abstract LadderActivity toBean();
  
  public abstract LadderActivity toDataIf();
  
  public abstract LadderActivity toBeanIf();
  
  public abstract Set<Long> getRoleids();
  
  public abstract Set<Long> getRoleidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LadderActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */