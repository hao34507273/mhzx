package xbean;

import xdb.Bean;

public abstract interface FightAgainstInfo
  extends Bean
{
  public abstract FightAgainstInfo copy();
  
  public abstract FightAgainstInfo toData();
  
  public abstract FightAgainstInfo toBean();
  
  public abstract FightAgainstInfo toDataIf();
  
  public abstract FightAgainstInfo toBeanIf();
  
  public abstract long getA_corps_id();
  
  public abstract long getB_corps_id();
  
  public abstract int getFight_status();
  
  public abstract int getA_corps_id_result();
  
  public abstract int getB_corps_id_result();
  
  public abstract int getCal_fight_result();
  
  public abstract long getRecord_id();
  
  public abstract void setA_corps_id(long paramLong);
  
  public abstract void setB_corps_id(long paramLong);
  
  public abstract void setFight_status(int paramInt);
  
  public abstract void setA_corps_id_result(int paramInt);
  
  public abstract void setB_corps_id_result(int paramInt);
  
  public abstract void setCal_fight_result(int paramInt);
  
  public abstract void setRecord_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightAgainstInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */