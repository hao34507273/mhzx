package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface PopularityRankData
  extends Bean
{
  public abstract PopularityRankData copy();
  
  public abstract PopularityRankData toData();
  
  public abstract PopularityRankData toBean();
  
  public abstract PopularityRankData toDataIf();
  
  public abstract PopularityRankData toBeanIf();
  
  public abstract List<RolePopularityRankData> getRank_data_list();
  
  public abstract List<RolePopularityRankData> getRank_data_listAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PopularityRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */