package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface Channels
  extends Bean
{
  public abstract Channels copy();
  
  public abstract Channels toData();
  
  public abstract Channels toBean();
  
  public abstract Channels toDataIf();
  
  public abstract Channels toBeanIf();
  
  public abstract List<Long> getChannels();
  
  public abstract List<Long> getChannelsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Channels.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */