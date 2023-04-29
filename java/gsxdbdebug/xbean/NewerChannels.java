package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface NewerChannels
  extends Bean
{
  public abstract NewerChannels copy();
  
  public abstract NewerChannels toData();
  
  public abstract NewerChannels toBean();
  
  public abstract NewerChannels toDataIf();
  
  public abstract NewerChannels toBeanIf();
  
  public abstract List<NewerChannel> getNewerchannels();
  
  public abstract List<NewerChannel> getNewerchannelsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NewerChannels.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */