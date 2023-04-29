package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RoleFeiShengZhuXianJianZhenInfo
  extends Bean
{
  public abstract RoleFeiShengZhuXianJianZhenInfo copy();
  
  public abstract RoleFeiShengZhuXianJianZhenInfo toData();
  
  public abstract RoleFeiShengZhuXianJianZhenInfo toBean();
  
  public abstract RoleFeiShengZhuXianJianZhenInfo toDataIf();
  
  public abstract RoleFeiShengZhuXianJianZhenInfo toBeanIf();
  
  public abstract Map<Integer, FeiShengZhuXianJianZhenInfo> getFei_sheng_zhu_xian_jian_zhen_infos();
  
  public abstract Map<Integer, FeiShengZhuXianJianZhenInfo> getFei_sheng_zhu_xian_jian_zhen_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleFeiShengZhuXianJianZhenInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */