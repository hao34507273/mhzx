package xbean;

import java.util.Map;
import java.util.Set;
import mzm.gsp.effect.main.OutFightEffect;
import xdb.Bean;

public abstract interface RoleOutFightBean
  extends Bean
{
  public static final int TYPE__EFFECT = 0;
  public static final int TYPE__EQUIP = 1;
  public static final int TYPE__WING = 2;
  public static final int TYPE__FA_BAO = 3;
  public static final int TYPE__APPELLATION = 4;
  public static final int TYPE__FASHION = 5;
  public static final int TYPE__RIDE = 6;
  public static final int TYPE__AVATAR = 7;
  public static final int TYPE__FA_BAO_LING_QI = 8;
  public static final int TYPE__BIAN_SHEN_CARD = 9;
  public static final int TYPE__AIRCRAFT = 10;
  
  public abstract RoleOutFightBean copy();
  
  public abstract RoleOutFightBean toData();
  
  public abstract RoleOutFightBean toBean();
  
  public abstract RoleOutFightBean toDataIf();
  
  public abstract RoleOutFightBean toBeanIf();
  
  public abstract Map<Integer, Integer> getEffectaddpropmap();
  
  public abstract Map<Integer, Integer> getEffectaddpropmapAsData();
  
  public abstract Map<Integer, Integer> getEquipstaticaddpropmap();
  
  public abstract Map<Integer, Integer> getEquipstaticaddpropmapAsData();
  
  public abstract Map<Integer, Integer> getWingstaticaddpropmap();
  
  public abstract Map<Integer, Integer> getWingstaticaddpropmapAsData();
  
  public abstract Set<OutFightEffect> getEquipeffectset();
  
  public abstract Set<OutFightEffect> getSkilleffectset();
  
  public abstract Map<Integer, Integer> getAppellationaddpropmap();
  
  public abstract Map<Integer, Integer> getAppellationaddpropmapAsData();
  
  public abstract Map<Integer, Integer> getFabaoaddpropmap();
  
  public abstract Map<Integer, Integer> getFabaoaddpropmapAsData();
  
  public abstract Map<Integer, RoleProBean> getExtroprop();
  
  public abstract Map<Integer, RoleProBean> getExtropropAsData();
  
  public abstract Map<Integer, RoleEffectBean> getExtroeffect();
  
  public abstract RoleReviseProBean getExtro_revise_pro();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleOutFightBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */