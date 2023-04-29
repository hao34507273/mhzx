package xbean;

import java.util.Map;
import java.util.Set;
import mzm.gsp.effect.main.OutFightEffect;
import xdb.Bean;

public abstract interface PetOutFightBean
  extends Bean
{
  public abstract PetOutFightBean copy();
  
  public abstract PetOutFightBean toData();
  
  public abstract PetOutFightBean toBean();
  
  public abstract PetOutFightBean toDataIf();
  
  public abstract PetOutFightBean toBeanIf();
  
  public abstract Map<Integer, Integer> getEffectaddpropmap();
  
  public abstract Map<Integer, Integer> getEffectaddpropmapAsData();
  
  public abstract Map<Integer, Integer> getEquipstaticaddpropmap();
  
  public abstract Map<Integer, Integer> getEquipstaticaddpropmapAsData();
  
  public abstract Set<OutFightEffect> getSkilleffectset();
  
  public abstract int getIsinfight();
  
  public abstract Map<Integer, Integer> getSouladdpropmap();
  
  public abstract Map<Integer, Integer> getSouladdpropmapAsData();
  
  public abstract Map<Integer, Integer> getPetmarkaddpropmap();
  
  public abstract Map<Integer, Integer> getPetmarkaddpropmapAsData();
  
  public abstract void setIsinfight(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PetOutFightBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */