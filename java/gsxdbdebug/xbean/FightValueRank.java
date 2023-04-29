package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface FightValueRank
  extends Bean
{
  public abstract FightValueRank copy();
  
  public abstract FightValueRank toData();
  
  public abstract FightValueRank toBean();
  
  public abstract FightValueRank toDataIf();
  
  public abstract FightValueRank toBeanIf();
  
  public abstract List<RoleFightValueBean> getRolerankdatas();
  
  public abstract List<RoleFightValueBean> getRolerankdatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightValueRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */