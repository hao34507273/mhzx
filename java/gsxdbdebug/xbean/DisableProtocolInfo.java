package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface DisableProtocolInfo
  extends Bean
{
  public abstract DisableProtocolInfo copy();
  
  public abstract DisableProtocolInfo toData();
  
  public abstract DisableProtocolInfo toBean();
  
  public abstract DisableProtocolInfo toDataIf();
  
  public abstract DisableProtocolInfo toBeanIf();
  
  public abstract Set<Integer> getProtocols();
  
  public abstract Set<Integer> getProtocolsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DisableProtocolInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */