package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface BigBoss
  extends Bean
{
  public abstract BigBoss copy();
  
  public abstract BigBoss toData();
  
  public abstract BigBoss toBean();
  
  public abstract BigBoss toDataIf();
  
  public abstract BigBoss toBeanIf();
  
  public abstract int getDamagepoint();
  
  public abstract int getRank();
  
  public abstract int getBuycount();
  
  public abstract int getRestbuycount();
  
  public abstract int getChallengecount();
  
  public abstract int getFightcount();
  
  public abstract long getStarttime();
  
  public abstract boolean getIsawarded();
  
  public abstract boolean getIskilledmonster();
  
  public abstract int getReserved();
  
  public abstract Map<Integer, Integer> getOcp2damagepoint();
  
  public abstract Map<Integer, Integer> getOcp2damagepointAsData();
  
  public abstract void setDamagepoint(int paramInt);
  
  public abstract void setRank(int paramInt);
  
  public abstract void setBuycount(int paramInt);
  
  public abstract void setRestbuycount(int paramInt);
  
  public abstract void setChallengecount(int paramInt);
  
  public abstract void setFightcount(int paramInt);
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setIsawarded(boolean paramBoolean);
  
  public abstract void setIskilledmonster(boolean paramBoolean);
  
  public abstract void setReserved(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BigBoss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */