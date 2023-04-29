package xbean;

import xdb.Bean;

public abstract interface SingleBattleSessions
  extends Bean
{
  public abstract SingleBattleSessions copy();
  
  public abstract SingleBattleSessions toData();
  
  public abstract SingleBattleSessions toBean();
  
  public abstract SingleBattleSessions toDataIf();
  
  public abstract SingleBattleSessions toBeanIf();
  
  public abstract long getSessionprepareid();
  
  public abstract long getSessionbattleplayendid();
  
  public abstract long getSessionbettlerealendid();
  
  public abstract long getSessionbettlewaitcleanid();
  
  public abstract void setSessionprepareid(long paramLong);
  
  public abstract void setSessionbattleplayendid(long paramLong);
  
  public abstract void setSessionbettlerealendid(long paramLong);
  
  public abstract void setSessionbettlewaitcleanid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SingleBattleSessions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */