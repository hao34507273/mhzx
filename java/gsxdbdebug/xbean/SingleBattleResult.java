package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface SingleBattleResult
  extends Bean
{
  public abstract SingleBattleResult copy();
  
  public abstract SingleBattleResult toData();
  
  public abstract SingleBattleResult toBean();
  
  public abstract SingleBattleResult toDataIf();
  
  public abstract SingleBattleResult toBeanIf();
  
  public abstract int getWinnercampid();
  
  public abstract Map<Integer, Long> getCampmvps();
  
  public abstract Map<Integer, Long> getCampmvpsAsData();
  
  public abstract void setWinnercampid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SingleBattleResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */