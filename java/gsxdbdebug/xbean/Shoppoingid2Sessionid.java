package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Shoppoingid2Sessionid
  extends Bean
{
  public abstract Shoppoingid2Sessionid copy();
  
  public abstract Shoppoingid2Sessionid toData();
  
  public abstract Shoppoingid2Sessionid toBean();
  
  public abstract Shoppoingid2Sessionid toDataIf();
  
  public abstract Shoppoingid2Sessionid toBeanIf();
  
  public abstract Map<Long, Long> getShoppingid2sessionid();
  
  public abstract Map<Long, Long> getShoppingid2sessionidAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Shoppoingid2Sessionid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */