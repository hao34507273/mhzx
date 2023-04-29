package xbean;

import java.util.Map;
import java.util.Set;
import mzm.gsp.effect.main.OutFightEffect;
import xdb.Bean;

public abstract interface PartnerOutFightBean
  extends Bean
{
  public abstract PartnerOutFightBean copy();
  
  public abstract PartnerOutFightBean toData();
  
  public abstract PartnerOutFightBean toBean();
  
  public abstract PartnerOutFightBean toDataIf();
  
  public abstract PartnerOutFightBean toBeanIf();
  
  public abstract Map<Integer, Integer> getEffectaddpropmap();
  
  public abstract Map<Integer, Integer> getEffectaddpropmapAsData();
  
  public abstract Map<Integer, Integer> getEquipstaticaddpropmap();
  
  public abstract Map<Integer, Integer> getEquipstaticaddpropmapAsData();
  
  public abstract Set<OutFightEffect> getSkilleffectset();
  
  public abstract Map<Integer, Integer> getYuanshenpropmap();
  
  public abstract Map<Integer, Integer> getYuanshenpropmapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PartnerOutFightBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */