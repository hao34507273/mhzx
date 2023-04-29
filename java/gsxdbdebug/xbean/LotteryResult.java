package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface LotteryResult
  extends Bean
{
  public abstract LotteryResult copy();
  
  public abstract LotteryResult toData();
  
  public abstract LotteryResult toBean();
  
  public abstract LotteryResult toDataIf();
  
  public abstract LotteryResult toBeanIf();
  
  public abstract int getLotterytype();
  
  public abstract int getUseditemid();
  
  public abstract int getLogreason();
  
  public abstract int getSubreason();
  
  public abstract Map<Integer, Integer> getMap();
  
  public abstract Map<Integer, Integer> getMapAsData();
  
  public abstract long getSessionid();
  
  public abstract void setLotterytype(int paramInt);
  
  public abstract void setUseditemid(int paramInt);
  
  public abstract void setLogreason(int paramInt);
  
  public abstract void setSubreason(int paramInt);
  
  public abstract void setSessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LotteryResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */