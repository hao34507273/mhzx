package xbean;

import mzm.gsp.award.main.AwardModel;
import xdb.Bean;

public abstract interface FightAwardTip
  extends Bean
{
  public abstract FightAwardTip copy();
  
  public abstract FightAwardTip toData();
  
  public abstract FightAwardTip toBean();
  
  public abstract FightAwardTip toDataIf();
  
  public abstract FightAwardTip toBeanIf();
  
  public abstract AwardModel getFightawardtip();
  
  public abstract void setFightawardtip(AwardModel paramAwardModel);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightAwardTip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */