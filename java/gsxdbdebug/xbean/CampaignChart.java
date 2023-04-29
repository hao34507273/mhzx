package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface CampaignChart
  extends Bean
{
  public abstract CampaignChart copy();
  
  public abstract CampaignChart toData();
  
  public abstract CampaignChart toBean();
  
  public abstract CampaignChart toDataIf();
  
  public abstract CampaignChart toBeanIf();
  
  public abstract List<Long> getRanks();
  
  public abstract List<Long> getRanksAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CampaignChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */