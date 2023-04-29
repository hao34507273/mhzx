package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleFeiShengDevelopItemInfo
  extends Bean
{
  public abstract RoleFeiShengDevelopItemInfo copy();
  
  public abstract RoleFeiShengDevelopItemInfo toData();
  
  public abstract RoleFeiShengDevelopItemInfo toBean();
  
  public abstract RoleFeiShengDevelopItemInfo toDataIf();
  
  public abstract RoleFeiShengDevelopItemInfo toBeanIf();
  
  public abstract Map<Integer, FeiShengDevelopItemInfo> getFei_sheng_develop_item_infos();
  
  public abstract Map<Integer, FeiShengDevelopItemInfo> getFei_sheng_develop_item_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleFeiShengDevelopItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */