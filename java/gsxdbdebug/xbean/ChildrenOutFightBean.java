package xbean;

import java.util.Map;
import java.util.Set;
import mzm.gsp.effect.main.OutFightEffect;
import xdb.Bean;

public abstract interface ChildrenOutFightBean
  extends Bean
{
  public abstract ChildrenOutFightBean copy();
  
  public abstract ChildrenOutFightBean toData();
  
  public abstract ChildrenOutFightBean toBean();
  
  public abstract ChildrenOutFightBean toDataIf();
  
  public abstract ChildrenOutFightBean toBeanIf();
  
  public abstract Map<Integer, Integer> getEffectaddpropmap();
  
  public abstract Map<Integer, Integer> getEffectaddpropmapAsData();
  
  public abstract Map<Integer, Integer> getEquipstaticaddpropmap();
  
  public abstract Map<Integer, Integer> getEquipstaticaddpropmapAsData();
  
  public abstract Set<OutFightEffect> getSkilleffectset();
  
  public abstract boolean getFightflag();
  
  public abstract int getLevel();
  
  public abstract void setFightflag(boolean paramBoolean);
  
  public abstract void setLevel(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChildrenOutFightBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */