package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface PartnerYuanshenInfo
  extends Bean
{
  public abstract PartnerYuanshenInfo copy();
  
  public abstract PartnerYuanshenInfo toData();
  
  public abstract PartnerYuanshenInfo toBean();
  
  public abstract PartnerYuanshenInfo toDataIf();
  
  public abstract PartnerYuanshenInfo toBeanIf();
  
  public abstract Map<Integer, PartnerYuanshenPositionInfo> getPosition_info_map();
  
  public abstract Map<Integer, PartnerYuanshenPositionInfo> getPosition_info_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PartnerYuanshenInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */