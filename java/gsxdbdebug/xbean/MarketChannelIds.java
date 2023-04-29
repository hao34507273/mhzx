package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface MarketChannelIds
  extends Bean
{
  public abstract MarketChannelIds copy();
  
  public abstract MarketChannelIds toData();
  
  public abstract MarketChannelIds toBean();
  
  public abstract MarketChannelIds toDataIf();
  
  public abstract MarketChannelIds toBeanIf();
  
  public abstract List<Long> getChannel_ids();
  
  public abstract List<Long> getChannel_idsAsData();
  
  public abstract int getSupply_num();
  
  public abstract long getSupply_time();
  
  public abstract int getSupply_skill_equip_num();
  
  public abstract void setSupply_num(int paramInt);
  
  public abstract void setSupply_time(long paramLong);
  
  public abstract void setSupply_skill_equip_num(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MarketChannelIds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */