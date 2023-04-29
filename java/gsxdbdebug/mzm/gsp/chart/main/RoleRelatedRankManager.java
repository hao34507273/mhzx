package mzm.gsp.chart.main;

import java.util.List;

public abstract interface RoleRelatedRankManager<TChartObj>
  extends RankManager
{
  public abstract boolean removeByRoleid(long paramLong, boolean paramBoolean);
  
  public abstract void addRankRoleForIDIP(long paramLong);
  
  public abstract void clearRoleRankData(long paramLong);
  
  public abstract int getMaxRank(long paramLong);
  
  public abstract List<TChartObj> getRankObjs(int paramInt1, int paramInt2);
  
  public abstract void saveToDB();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\RoleRelatedRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */