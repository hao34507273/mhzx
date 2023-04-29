package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleFeiShengFightInfo
  extends Bean
{
  public abstract RoleFeiShengFightInfo copy();
  
  public abstract RoleFeiShengFightInfo toData();
  
  public abstract RoleFeiShengFightInfo toBean();
  
  public abstract RoleFeiShengFightInfo toDataIf();
  
  public abstract RoleFeiShengFightInfo toBeanIf();
  
  public abstract Map<Integer, FeiShengFightInfo> getFei_sheng_fight_infos();
  
  public abstract Map<Integer, FeiShengFightInfo> getFei_sheng_fight_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleFeiShengFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */