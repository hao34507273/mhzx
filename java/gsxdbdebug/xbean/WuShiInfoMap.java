package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface WuShiInfoMap
  extends Bean
{
  public abstract WuShiInfoMap copy();
  
  public abstract WuShiInfoMap toData();
  
  public abstract WuShiInfoMap toBean();
  
  public abstract WuShiInfoMap toDataIf();
  
  public abstract WuShiInfoMap toBeanIf();
  
  public abstract Map<Integer, WuShiInfo> getWushicfgid2wushiinfo();
  
  public abstract Map<Integer, WuShiInfo> getWushicfgid2wushiinfoAsData();
  
  public abstract int getOnwushicfgid();
  
  public abstract void setOnwushicfgid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WuShiInfoMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */