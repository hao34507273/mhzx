package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CampaignCharts
  extends Bean
{
  public abstract CampaignCharts copy();
  
  public abstract CampaignCharts toData();
  
  public abstract CampaignCharts toBean();
  
  public abstract CampaignCharts toDataIf();
  
  public abstract CampaignCharts toBeanIf();
  
  public abstract Map<Integer, CampaignChart> getCharts();
  
  public abstract Map<Integer, CampaignChart> getChartsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CampaignCharts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */