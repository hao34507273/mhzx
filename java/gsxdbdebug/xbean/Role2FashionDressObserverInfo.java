package xbean;

import java.util.Map;
import mzm.gsp.fashiondress.main.FashionDressExpiredObserver;
import xdb.Bean;

public abstract interface Role2FashionDressObserverInfo
  extends Bean
{
  public abstract Role2FashionDressObserverInfo copy();
  
  public abstract Role2FashionDressObserverInfo toData();
  
  public abstract Role2FashionDressObserverInfo toBean();
  
  public abstract Role2FashionDressObserverInfo toDataIf();
  
  public abstract Role2FashionDressObserverInfo toBeanIf();
  
  public abstract Map<Integer, FashionDressExpiredObserver> getObserver_map();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2FashionDressObserverInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */