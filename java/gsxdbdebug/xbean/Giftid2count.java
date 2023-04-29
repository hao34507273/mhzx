package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Giftid2count
  extends Bean
{
  public abstract Giftid2count copy();
  
  public abstract Giftid2count toData();
  
  public abstract Giftid2count toBean();
  
  public abstract Giftid2count toDataIf();
  
  public abstract Giftid2count toBeanIf();
  
  public abstract Map<Integer, Integer> getGiftid2count();
  
  public abstract Map<Integer, Integer> getGiftid2countAsData();
  
  public abstract Map<Integer, TimeLimitGiftInfo> getGift_cfg_id2gift_info();
  
  public abstract Map<Integer, TimeLimitGiftInfo> getGift_cfg_id2gift_infoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Giftid2count.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */