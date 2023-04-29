package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface NewerChannel
  extends Bean
{
  public abstract NewerChannel copy();
  
  public abstract NewerChannel toData();
  
  public abstract NewerChannel toBean();
  
  public abstract NewerChannel toDataIf();
  
  public abstract NewerChannel toBeanIf();
  
  public abstract Set<Long> getNewerids();
  
  public abstract Set<Long> getNeweridsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NewerChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */