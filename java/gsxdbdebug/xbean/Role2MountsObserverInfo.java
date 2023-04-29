package xbean;

import java.util.Map;
import mzm.gsp.mounts.main.MountsExpiredMillObserver;
import xdb.Bean;

public abstract interface Role2MountsObserverInfo
  extends Bean
{
  public abstract Role2MountsObserverInfo copy();
  
  public abstract Role2MountsObserverInfo toData();
  
  public abstract Role2MountsObserverInfo toBean();
  
  public abstract Role2MountsObserverInfo toDataIf();
  
  public abstract Role2MountsObserverInfo toBeanIf();
  
  public abstract Map<Long, MountsExpiredMillObserver> getObserver_map();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2MountsObserverInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */