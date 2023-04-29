package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface FighterMounts
  extends Bean
{
  public abstract FighterMounts copy();
  
  public abstract FighterMounts toData();
  
  public abstract FighterMounts toBean();
  
  public abstract FighterMounts toDataIf();
  
  public abstract FighterMounts toBeanIf();
  
  public abstract long getMountuuid();
  
  public abstract int getMountcfgid();
  
  public abstract Map<Integer, Integer> getSkillmap();
  
  public abstract Map<Integer, Integer> getSkillmapAsData();
  
  public abstract void setMountuuid(long paramLong);
  
  public abstract void setMountcfgid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FighterMounts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */