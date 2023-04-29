package xbean;

import java.util.List;
import java.util.Map;
import java.util.Set;
import mzm.gsp.fight.handle.AddAngerHandle;
import mzm.gsp.fight.handle.AddBuffHandle;
import mzm.gsp.fight.handle.AftUseSkilHandle;
import mzm.gsp.fight.handle.AfterAttackHandle;
import mzm.gsp.fight.handle.AfterSummonHandle;
import mzm.gsp.fight.handle.BeDamageHandle;
import mzm.gsp.fight.handle.BeKilledHandle;
import mzm.gsp.fight.handle.BeforeAttackHandle;
import mzm.gsp.fight.handle.BeforeHealHandle;
import mzm.gsp.fight.handle.BeforePoisonHandle;
import mzm.gsp.fight.handle.BeforeSealHandle;
import mzm.gsp.fight.handle.BeforeUseSkilHandle;
import mzm.gsp.fight.handle.ChildEnterFightHandle;
import mzm.gsp.fight.handle.CounterHandle;
import mzm.gsp.fight.handle.DamageHandle;
import mzm.gsp.fight.handle.DrugHandle;
import mzm.gsp.fight.handle.EnterFightHandle;
import mzm.gsp.fight.handle.EscapeHandle;
import mzm.gsp.fight.handle.FighterDeadHandle;
import mzm.gsp.fight.handle.KillOtherHandle;
import mzm.gsp.fight.handle.LoseHpHandle;
import mzm.gsp.fight.handle.OtherBeKilledAfterHandle;
import mzm.gsp.fight.handle.PetEnterFightHandle;
import mzm.gsp.fight.handle.ProtectHandle;
import mzm.gsp.fight.handle.RebirthHandle;
import mzm.gsp.fight.handle.ReboundHandle;
import mzm.gsp.fight.handle.RoundEndHandle;
import mzm.gsp.fight.handle.RoundStartHandle;
import mzm.gsp.fight.handle.SealedHandle;
import mzm.gsp.fight.handle.SkillCausingDeathHandle;
import mzm.gsp.fight.handle.SkillCostHandle;
import mzm.gsp.fight.handle.TargetNumHandle;
import mzm.gsp.fight.handle.TauntHandle;
import mzm.gsp.fight.main.AI;
import mzm.gsp.map.MapModelInfo;
import xdb.Bean;

public abstract interface Fighter
  extends Bean
{
  public abstract Fighter copy();
  
  public abstract Fighter toData();
  
  public abstract Fighter toBean();
  
  public abstract Fighter toDataIf();
  
  public abstract Fighter toBeanIf();
  
  public abstract int getType();
  
  public abstract int getFighterid();
  
  public abstract int getPos();
  
  public abstract int getHp();
  
  public abstract int getMp();
  
  public abstract float getAnger();
  
  public abstract Map<Integer, Integer> getAttrs();
  
  public abstract Map<Integer, Integer> getAttrsAsData();
  
  public abstract Map<Integer, Integer> getEx_attrs();
  
  public abstract Map<Integer, Integer> getEx_attrsAsData();
  
  public abstract AI getAi();
  
  public abstract Map<Integer, Integer> getExtra();
  
  public abstract Map<Integer, Integer> getExtraAsData();
  
  public abstract Map<Integer, Integer> getSkills();
  
  public abstract Map<Integer, Integer> getSkillsAsData();
  
  public abstract Map<Integer, SkillData> getSkilldatas();
  
  public abstract Map<Integer, SkillData> getSkilldatasAsData();
  
  public abstract int getState();
  
  public abstract Map<Integer, Integer> getBuff_states();
  
  public abstract Map<Integer, Integer> getBuff_statesAsData();
  
  public abstract Map<Integer, FighterBuffs> getBuffs();
  
  public abstract MapModelInfo getOriginalmodelid();
  
  public abstract List<Integer> getProtecterids();
  
  public abstract List<Integer> getProtecteridsAsData();
  
  public abstract List<Integer> getChangemodelids();
  
  public abstract List<Integer> getChangemodelidsAsData();
  
  public abstract Map<Integer, Targets> getTargetstatusbuffs();
  
  public abstract Map<Integer, Targets> getTargetstatusbuffsAsData();
  
  public abstract Set<RoundStartHandle> getHandleonroundstart();
  
  public abstract Set<RoundEndHandle> getHandleonroundend();
  
  public abstract Set<DamageHandle> getHandleondamage();
  
  public abstract Set<BeDamageHandle> getHandleonbedamage();
  
  public abstract Set<BeKilledHandle> getHandleonbekilled();
  
  public abstract Set<KillOtherHandle> getHandleonkillother();
  
  public abstract Set<RebirthHandle> getHandleonrebirth();
  
  public abstract Set<BeforeAttackHandle> getHandleonbeforeattack();
  
  public abstract Set<AfterAttackHandle> getHandleonafterattack();
  
  public abstract Set<SkillCostHandle> getHandleonskillcost();
  
  public abstract Set<AddBuffHandle> getHandleonaddbuff();
  
  public abstract Set<SealedHandle> getHandleonsealed();
  
  public abstract Set<CounterHandle> getHandleoncounter();
  
  public abstract Set<ProtectHandle> getHandleonprotect();
  
  public abstract Set<TauntHandle> getHandleontaunt();
  
  public abstract Set<ReboundHandle> getHandleonrebound();
  
  public abstract Set<EnterFightHandle> getHandleonenterfight();
  
  public abstract Set<FighterDeadHandle> getHandleonfighterdead();
  
  public abstract Set<BeforeUseSkilHandle> getHandleonbeforeuseskill();
  
  public abstract Set<AftUseSkilHandle> getHandleonaftuseskill();
  
  public abstract Set<BeforeHealHandle> getHandleonbeforeheal();
  
  public abstract Set<TargetNumHandle> getHandleontargetnumhandle();
  
  public abstract Set<BeforePoisonHandle> getHandleonbeforepoisonhandle();
  
  public abstract Set<PetEnterFightHandle> getHandleonpetenterfighthandle();
  
  public abstract Set<AddAngerHandle> getHandleonaddangerhandle();
  
  public abstract Set<DrugHandle> getHandleondrughandle();
  
  public abstract Set<LoseHpHandle> getHandleonlosehphandle();
  
  public abstract Set<AfterSummonHandle> getHandleonaftsummonhandle();
  
  public abstract FighterMounts getFightermounts();
  
  public abstract List<Integer> getNextroundaddbuffids();
  
  public abstract Set<SkillCausingDeathHandle> getHandleonskillcausingdeath();
  
  public abstract Set<ChildEnterFightHandle> getHandleonchildenterfighthandle();
  
  public abstract SkillResult getSkillresult();
  
  public abstract List<Integer> getDeadrounds();
  
  public abstract List<Integer> getDeadroundsAsData();
  
  public abstract FighterModelCard getChangemodelcard();
  
  public abstract Map<Integer, FighterHealthInfo> getHealthatroundstart();
  
  public abstract Map<Integer, FighterHealthInfo> getHealthatroundstartAsData();
  
  public abstract Set<BeforeSealHandle> getHandleonbeforeseal();
  
  public abstract Map<Integer, FightState> getFightstates();
  
  public abstract Map<Integer, FightState> getFightstatesAsData();
  
  public abstract FightState getDefaultfightstate();
  
  public abstract Map<Integer, Targets> getEffecttargets();
  
  public abstract Map<Integer, Targets> getEffecttargetsAsData();
  
  public abstract FighterOutFightInfo getOutfightinfo();
  
  public abstract Set<EscapeHandle> getHandleonescape();
  
  public abstract Set<OtherBeKilledAfterHandle> getHandleonotherbekilledafter();
  
  public abstract void setType(int paramInt);
  
  public abstract void setFighterid(int paramInt);
  
  public abstract void setPos(int paramInt);
  
  public abstract void setHp(int paramInt);
  
  public abstract void setMp(int paramInt);
  
  public abstract void setAnger(float paramFloat);
  
  public abstract void setAi(AI paramAI);
  
  public abstract void setState(int paramInt);
  
  public abstract void setOriginalmodelid(MapModelInfo paramMapModelInfo);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Fighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */