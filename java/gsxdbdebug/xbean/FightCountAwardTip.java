package xbean;

import mzm.gsp.award.main.AwardModel;
import xdb.Bean;

public abstract interface FightCountAwardTip
  extends Bean
{
  public abstract FightCountAwardTip copy();
  
  public abstract FightCountAwardTip toData();
  
  public abstract FightCountAwardTip toBean();
  
  public abstract FightCountAwardTip toDataIf();
  
  public abstract FightCountAwardTip toBeanIf();
  
  public abstract AwardModel getFightcountawardtip();
  
  public abstract int getCount();
  
  public abstract void setFightcountawardtip(AwardModel paramAwardModel);
  
  public abstract void setCount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightCountAwardTip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */