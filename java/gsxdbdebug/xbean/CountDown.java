package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface CountDown
  extends Bean
{
  public abstract CountDown copy();
  
  public abstract CountDown toData();
  
  public abstract CountDown toBean();
  
  public abstract CountDown toDataIf();
  
  public abstract CountDown toBeanIf();
  
  public abstract Set<Long> getCan_get_red_packet_roleids();
  
  public abstract Set<Long> getCan_get_red_packet_roleidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CountDown.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */