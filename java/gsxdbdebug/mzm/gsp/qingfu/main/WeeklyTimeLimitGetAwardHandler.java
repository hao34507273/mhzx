package mzm.gsp.qingfu.main;

import mzm.gsp.qingfu.confbean.STimeLimitGiftBagCfg;

public abstract interface WeeklyTimeLimitGetAwardHandler
{
  public abstract boolean doAward(String paramString, long paramLong, STimeLimitGiftBagCfg paramSTimeLimitGiftBagCfg);
  
  public abstract int getActivityId();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\WeeklyTimeLimitGetAwardHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */