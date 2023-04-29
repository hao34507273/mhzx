package xbean;

import java.util.List;
import mzm.gsp.floplottery.main.FlopLotteryHandlerInterface;
import xdb.Bean;

public abstract interface FlopLotteryEntry
  extends Bean
{
  public static final int COND_DONE = 0;
  public static final int COND_NOT_DONE = 1;
  
  public abstract FlopLotteryEntry copy();
  
  public abstract FlopLotteryEntry toData();
  
  public abstract FlopLotteryEntry toBean();
  
  public abstract FlopLotteryEntry toDataIf();
  
  public abstract FlopLotteryEntry toBeanIf();
  
  public abstract long getUid();
  
  public abstract int getFloplotterymaincfgid();
  
  public abstract List<FlopLotteryAwardPoolResult> getFloplotteryawardpoolresultlist();
  
  public abstract int getIsconddone();
  
  public abstract long getExpiretimestamp();
  
  public abstract FlopLotteryHandlerInterface getFloplotteryhandler();
  
  public abstract void setUid(long paramLong);
  
  public abstract void setFloplotterymaincfgid(int paramInt);
  
  public abstract void setIsconddone(int paramInt);
  
  public abstract void setExpiretimestamp(long paramLong);
  
  public abstract void setFloplotteryhandler(FlopLotteryHandlerInterface paramFlopLotteryHandlerInterface);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FlopLotteryEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */