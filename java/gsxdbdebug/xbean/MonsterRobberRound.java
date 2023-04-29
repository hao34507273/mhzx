package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MonsterRobberRound
  extends Bean
{
  public abstract MonsterRobberRound copy();
  
  public abstract MonsterRobberRound toData();
  
  public abstract MonsterRobberRound toBean();
  
  public abstract MonsterRobberRound toDataIf();
  
  public abstract MonsterRobberRound toBeanIf();
  
  public abstract Map<Integer, Integer> getDeadmonsterandcount();
  
  public abstract Map<Integer, Integer> getDeadmonsterandcountAsData();
  
  public abstract boolean getIsaward();
  
  public abstract void setIsaward(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MonsterRobberRound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */