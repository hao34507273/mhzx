package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface Pet
  extends Bean
{
  public abstract Pet copy();
  
  public abstract Pet toData();
  
  public abstract Pet toBean();
  
  public abstract Pet toDataIf();
  
  public abstract Pet toBeanIf();
  
  public abstract long getId();
  
  public abstract int getTemplateid();
  
  public abstract String getPetname();
  
  public abstract Octets getPetnameOctets();
  
  public abstract int getLevel();
  
  public abstract int getHp();
  
  public abstract int getMp();
  
  public abstract int getExp();
  
  public abstract int getLife();
  
  public abstract Map<Integer, Integer> getBasicproperty();
  
  public abstract Map<Integer, Integer> getBasicpropertyAsData();
  
  public abstract boolean getIsautospecialpoint();
  
  public abstract Map<Integer, Integer> getAutospecialpointcase();
  
  public abstract Map<Integer, Integer> getAutospecialpointcaseAsData();
  
  public abstract int getPotentialpoint();
  
  public abstract Aptitude getAptitude();
  
  public abstract float getGrow();
  
  public abstract int getRememberskillid();
  
  public abstract PetEquipBag getEquipbag();
  
  public abstract List<PetSkill> getSkilllist();
  
  public abstract List<PetSkill> getSkilllistAsData();
  
  public abstract int getIsbinded();
  
  public abstract int getYaoli();
  
  public abstract long getMarketbuytime();
  
  public abstract int getLianguitemusenum();
  
  public abstract int getGrowitemusenum();
  
  public abstract int getFanshengunbianyinum();
  
  public abstract int getStagelevel();
  
  public abstract long getChangeyaolitime();
  
  public abstract int getExtramodelcfgid();
  
  public abstract PetSoulBag getSoulbag();
  
  public abstract List<Integer> getOwnextramodelcfgids();
  
  public abstract List<Integer> getOwnextramodelcfgidsAsData();
  
  public abstract void setId(long paramLong);
  
  public abstract void setTemplateid(int paramInt);
  
  public abstract void setPetname(String paramString);
  
  public abstract void setPetnameOctets(Octets paramOctets);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setHp(int paramInt);
  
  public abstract void setMp(int paramInt);
  
  public abstract void setExp(int paramInt);
  
  public abstract void setLife(int paramInt);
  
  public abstract void setIsautospecialpoint(boolean paramBoolean);
  
  public abstract void setPotentialpoint(int paramInt);
  
  public abstract void setGrow(float paramFloat);
  
  public abstract void setRememberskillid(int paramInt);
  
  public abstract void setIsbinded(int paramInt);
  
  public abstract void setYaoli(int paramInt);
  
  public abstract void setMarketbuytime(long paramLong);
  
  public abstract void setLianguitemusenum(int paramInt);
  
  public abstract void setGrowitemusenum(int paramInt);
  
  public abstract void setFanshengunbianyinum(int paramInt);
  
  public abstract void setStagelevel(int paramInt);
  
  public abstract void setChangeyaolitime(long paramLong);
  
  public abstract void setExtramodelcfgid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Pet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */