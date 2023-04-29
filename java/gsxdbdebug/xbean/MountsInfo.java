package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MountsInfo
  extends Bean
{
  public abstract MountsInfo copy();
  
  public abstract MountsInfo toData();
  
  public abstract MountsInfo toBean();
  
  public abstract MountsInfo toDataIf();
  
  public abstract MountsInfo toBeanIf();
  
  public abstract int getMounts_cfg_id();
  
  public abstract int getMounts_rank();
  
  public abstract int getMounts_dye_color_id();
  
  public abstract List<PassiveSkillInfo> getMounts_passive_skill_list();
  
  public abstract List<PassiveSkillInfo> getMounts_passive_skill_listAsData();
  
  public abstract int getCurrent_mounts_star_level();
  
  public abstract int getCurrent_max_star_num();
  
  public abstract int getCurrent_score();
  
  public abstract int getCurrent_ornament_rank();
  
  public abstract int getProtect_pet_expand_size();
  
  public abstract void setMounts_cfg_id(int paramInt);
  
  public abstract void setMounts_rank(int paramInt);
  
  public abstract void setMounts_dye_color_id(int paramInt);
  
  public abstract void setCurrent_mounts_star_level(int paramInt);
  
  public abstract void setCurrent_max_star_num(int paramInt);
  
  public abstract void setCurrent_score(int paramInt);
  
  public abstract void setCurrent_ornament_rank(int paramInt);
  
  public abstract void setProtect_pet_expand_size(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MountsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */