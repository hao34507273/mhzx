package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface IndianaInfo
  extends Bean
{
  public abstract IndianaInfo copy();
  
  public abstract IndianaInfo toData();
  
  public abstract IndianaInfo toBean();
  
  public abstract IndianaInfo toDataIf();
  
  public abstract IndianaInfo toBeanIf();
  
  public abstract Map<Integer, IndianaTurnInfo> getTurn_infos();
  
  public abstract Map<Integer, IndianaTurnInfo> getTurn_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\IndianaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */