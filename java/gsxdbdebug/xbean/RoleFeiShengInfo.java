package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleFeiShengInfo
  extends Bean
{
  public abstract RoleFeiShengInfo copy();
  
  public abstract RoleFeiShengInfo toData();
  
  public abstract RoleFeiShengInfo toBean();
  
  public abstract RoleFeiShengInfo toDataIf();
  
  public abstract RoleFeiShengInfo toBeanIf();
  
  public abstract Map<Integer, FeiShengInfo> getFei_sheng_infos();
  
  public abstract Map<Integer, FeiShengInfo> getFei_sheng_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleFeiShengInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */