package mzm.gsp.util;

import java.util.List;

public abstract interface RankPageCache<TKey, TRankObj extends RankObj<TKey>>
{
  public abstract void onAddRankObj(TRankObj paramTRankObj);
  
  public abstract void onRemRankObj(TRankObj paramTRankObj);
  
  public abstract void clear();
  
  public abstract List<TRankObj> getAscendRankObjs(int paramInt);
  
  public abstract List<TRankObj> getDesendRankObjs(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\RankPageCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */