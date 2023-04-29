package xbean;

import java.util.List;
import mzm.gsp.floplottery.RewardItem;
import xdb.Bean;

public abstract interface FlopLotteryAwardPoolResult
  extends Bean
{
  public abstract FlopLotteryAwardPoolResult copy();
  
  public abstract FlopLotteryAwardPoolResult toData();
  
  public abstract FlopLotteryAwardPoolResult toBean();
  
  public abstract FlopLotteryAwardPoolResult toDataIf();
  
  public abstract FlopLotteryAwardPoolResult toBeanIf();
  
  public abstract int getIndex();
  
  public abstract List<RewardItem> getResultlist();
  
  public abstract void setIndex(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FlopLotteryAwardPoolResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */