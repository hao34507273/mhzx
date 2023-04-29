package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface SkillResult
  extends Bean
{
  public abstract SkillResult copy();
  
  public abstract SkillResult toData();
  
  public abstract SkillResult toBean();
  
  public abstract SkillResult toDataIf();
  
  public abstract SkillResult toBeanIf();
  
  public abstract Map<Integer, Integer> getSkillkillcountinfight();
  
  public abstract Map<Integer, Integer> getSkillkillcountinfightAsData();
  
  public abstract Map<Integer, Integer> getSkilltargetismaininfight();
  
  public abstract Map<Integer, Integer> getSkilltargetismaininfightAsData();
  
  public abstract Map<Integer, Integer> getSkillkillreborncountinfight();
  
  public abstract Map<Integer, Integer> getSkillkillreborncountinfightAsData();
  
  public abstract Map<Integer, Integer> getSkillbedodgecountinfight();
  
  public abstract Map<Integer, Integer> getSkillbedodgecountinfightAsData();
  
  public abstract Map<Integer, Integer> getSkillcriticalcountinround();
  
  public abstract Map<Integer, Integer> getSkillcriticalcountinroundAsData();
  
  public abstract Map<Integer, Integer> getSkillkillcountinround();
  
  public abstract Map<Integer, Integer> getSkillkillcountinroundAsData();
  
  public abstract Map<Integer, Integer> getSkilltargethplesscountinfight();
  
  public abstract Map<Integer, Integer> getSkilltargethplesscountinfightAsData();
  
  public abstract Map<Integer, SkillResultKillMonsterInfo> getKillmonster();
  
  public abstract Map<Integer, SkillResultKillMonsterInfo> getKillmonsterAsData();
  
  public abstract Map<Integer, Integer> getSkillfailedcountinfight();
  
  public abstract Map<Integer, Integer> getSkillfailedcountinfightAsData();
  
  public abstract Map<Integer, SkillReleaseRoundInfos> getSkillreleaseroundsinfight();
  
  public abstract Map<Integer, SkillReleaseRoundInfos> getSkillreleaseroundsinfightAsData();
  
  public abstract Map<Integer, SkillResultAttackTimes> getSkillattacktimesinfight();
  
  public abstract Map<Integer, SkillResultAttackTimes> getSkillattacktimesinfightAsData();
  
  public abstract Map<Integer, SkillResultHitMains> getSkillhitmaintargetinfight();
  
  public abstract Map<Integer, SkillResultHitMains> getSkillhitmaintargetinfightAsData();
  
  public abstract Map<Integer, SkillBuffResult> getSkillbuffinfight();
  
  public abstract Map<Integer, SkillBuffResult> getSkillbuffinfightAsData();
  
  public abstract Map<Integer, SkillMirrorInfo> getSkillmirrorinfoinfight();
  
  public abstract Map<Integer, SkillMirrorInfo> getSkillmirrorinfoinfightAsData();
  
  public abstract List<SkillShareDamageKillInfo> getSkillandsharedamagekillinfight();
  
  public abstract List<SkillShareDamageKillInfo> getSkillandsharedamagekillinfightAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SkillResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */