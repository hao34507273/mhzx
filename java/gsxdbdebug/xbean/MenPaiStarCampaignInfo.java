package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface MenPaiStarCampaignInfo
  extends Bean
{
  public abstract MenPaiStarCampaignInfo copy();
  
  public abstract MenPaiStarCampaignInfo toData();
  
  public abstract MenPaiStarCampaignInfo toBean();
  
  public abstract MenPaiStarCampaignInfo toDataIf();
  
  public abstract MenPaiStarCampaignInfo toBeanIf();
  
  public abstract int getToday_campaign_num();
  
  public abstract long getLast_campaign_time();
  
  public abstract Map<Integer, Campaign> getCampaigns();
  
  public abstract Map<Integer, Campaign> getCampaignsAsData();
  
  public abstract void setToday_campaign_num(int paramInt);
  
  public abstract void setLast_campaign_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MenPaiStarCampaignInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */