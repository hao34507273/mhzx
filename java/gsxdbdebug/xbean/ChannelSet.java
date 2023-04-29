package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface ChannelSet
  extends Bean
{
  public abstract ChannelSet copy();
  
  public abstract ChannelSet toData();
  
  public abstract ChannelSet toBean();
  
  public abstract ChannelSet toDataIf();
  
  public abstract ChannelSet toBeanIf();
  
  public abstract Set<Long> getChanelids();
  
  public abstract Set<Long> getChanelidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChannelSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */