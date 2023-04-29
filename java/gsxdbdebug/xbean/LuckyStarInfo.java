package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface LuckyStarInfo
  extends Bean
{
  public abstract LuckyStarInfo copy();
  
  public abstract LuckyStarInfo toData();
  
  public abstract LuckyStarInfo toBean();
  
  public abstract LuckyStarInfo toDataIf();
  
  public abstract LuckyStarInfo toBeanIf();
  
  public abstract List<BuyGiftInfo> getBuy_gift_info_list();
  
  public abstract List<BuyGiftInfo> getBuy_gift_info_listAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LuckyStarInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */