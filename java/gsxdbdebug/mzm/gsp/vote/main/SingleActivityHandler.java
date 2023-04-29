package mzm.gsp.vote.main;

import java.util.Set;
import mzm.gsp.activity2.confbean.STCommonVoteCfg;

public abstract interface SingleActivityHandler
{
  public abstract boolean isVoteIdsValid(long paramLong, STCommonVoteCfg paramSTCommonVoteCfg, Set<Integer> paramSet);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\vote\main\SingleActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */