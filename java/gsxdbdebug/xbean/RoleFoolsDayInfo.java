package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleFoolsDayInfo
  extends Bean
{
  public abstract RoleFoolsDayInfo copy();
  
  public abstract RoleFoolsDayInfo toData();
  
  public abstract RoleFoolsDayInfo toBean();
  
  public abstract RoleFoolsDayInfo toDataIf();
  
  public abstract RoleFoolsDayInfo toBeanIf();
  
  public abstract Map<Integer, FoolsDayInfo> getFools_day_infos();
  
  public abstract Map<Integer, FoolsDayInfo> getFools_day_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleFoolsDayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */