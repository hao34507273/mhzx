package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface BanquestGlobal
  extends Bean
{
  public abstract BanquestGlobal copy();
  
  public abstract BanquestGlobal toData();
  
  public abstract BanquestGlobal toBean();
  
  public abstract BanquestGlobal toDataIf();
  
  public abstract BanquestGlobal toBeanIf();
  
  public abstract Map<Long, BanquestData> getRole2banquestdata();
  
  public abstract Map<Long, BanquestData> getRole2banquestdataAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BanquestGlobal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */