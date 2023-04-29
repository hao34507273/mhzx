package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface TeamMatchBeans
  extends Bean
{
  public abstract TeamMatchBeans copy();
  
  public abstract TeamMatchBeans toData();
  
  public abstract TeamMatchBeans toBean();
  
  public abstract TeamMatchBeans toDataIf();
  
  public abstract TeamMatchBeans toBeanIf();
  
  public abstract Set<Long> getTeammatchmembers();
  
  public abstract Set<Long> getTeammatchmembersAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TeamMatchBeans.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */