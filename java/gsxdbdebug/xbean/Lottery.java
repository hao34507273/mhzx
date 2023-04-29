package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Lottery
  extends Bean
{
  public abstract Lottery copy();
  
  public abstract Lottery toData();
  
  public abstract Lottery toBean();
  
  public abstract Lottery toDataIf();
  
  public abstract Lottery toBeanIf();
  
  public abstract Map<Integer, LotteryResult> getLottery();
  
  public abstract Map<Integer, LotteryResult> getLotteryAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Lottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */