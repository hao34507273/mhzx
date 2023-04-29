/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import xbean.FightCache;
/*    */ 
/*    */ public class POnPetSkillChange extends mzm.gsp.pet.event.PetSkillChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     if (mzm.gsp.pet.main.PetInterface.isInFight(((PetEventArg)this.arg).roleId, ((PetEventArg)this.arg).petId)) {
/* 13 */       return false;
/*    */     }
/* 15 */     FightCache fightCache = xtable.Rolefightcache.get(Long.valueOf(((PetEventArg)this.arg).roleId));
/* 16 */     if (fightCache == null) {
/* 17 */       return false;
/*    */     }
/* 19 */     if (fightCache.getPet_default_skills().containsKey(Long.valueOf(((PetEventArg)this.arg).petId))) {
/* 20 */       int skillId = ((Integer)fightCache.getPet_default_skills().get(Long.valueOf(((PetEventArg)this.arg).petId))).intValue();
/* 21 */       List<Integer> skillList = mzm.gsp.pet.main.PetInterface.getPetSkillList(((PetEventArg)this.arg).roleId, ((PetEventArg)this.arg).petId);
/* 22 */       if ((!FightManager.isCommonSkill(skillId, -1)) && (!skillList.contains(Integer.valueOf(skillId)))) { java.util.Iterator i$;
/* 23 */         if (skillList.size() > 0) {
/* 24 */           for (i$ = skillList.iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/* 25 */             mzm.gsp.skill.confbean.SSkillCfg skillCfg = mzm.gsp.skill.confbean.SSkillCfg.get(skillId);
/* 26 */             if ((skillCfg != null) && (skillCfg.canAuto)) {
/* 27 */               fightCache.getPet_default_skills().put(Long.valueOf(((PetEventArg)this.arg).petId), Integer.valueOf(skillid));
/*    */             }
/*    */           }
/*    */         }
/* 31 */         int setSkillid = ((Integer)fightCache.getPet_default_skills().get(Long.valueOf(((PetEventArg)this.arg).petId))).intValue();
/* 32 */         if (!skillList.contains(Integer.valueOf(setSkillid))) {
/* 33 */           fightCache.getPet_default_skills().put(Long.valueOf(((PetEventArg)this.arg).petId), Integer.valueOf(FightManager.getNormalAttack(-1)));
/*    */         }
/* 35 */         FightInterface.syncAutoState(((PetEventArg)this.arg).roleId);
/*    */       }
/*    */     }
/*    */     
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\POnPetSkillChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */