package xbean;

import java.util.List;
import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface MassWeddingRankInfos
  extends Bean
{
  public abstract MassWeddingRankInfos copy();
  
  public abstract MassWeddingRankInfos toData();
  
  public abstract MassWeddingRankInfos toBean();
  
  public abstract MassWeddingRankInfos toDataIf();
  
  public abstract MassWeddingRankInfos toBeanIf();
  
  public abstract List<MassWeddingRankInfo> getMassweddingrankinfos();
  
  public abstract List<MassWeddingRankInfo> getMassweddingrankinfosAsData();
  
  public abstract Map<Long, Integer> getRoleid2index();
  
  public abstract Map<Long, Integer> getRoleid2indexAsData();
  
  public abstract Set<Long> getNotbackcoinsroleids();
  
  public abstract Set<Long> getNotbackcoinsroleidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MassWeddingRankInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */