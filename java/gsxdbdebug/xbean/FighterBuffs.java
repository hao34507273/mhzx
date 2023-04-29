package xbean;

import java.util.List;
import mzm.gsp.fight.main.FighterBuff;
import xdb.Bean;

public abstract interface FighterBuffs
  extends Bean
{
  public abstract FighterBuffs copy();
  
  public abstract FighterBuffs toData();
  
  public abstract FighterBuffs toBean();
  
  public abstract FighterBuffs toDataIf();
  
  public abstract FighterBuffs toBeanIf();
  
  public abstract List<FighterBuff> getBuffs();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FighterBuffs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */