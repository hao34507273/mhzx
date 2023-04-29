/*    */ package mzm.gsp.skill.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.marriage.event.DivorceArg;
/*    */ import xbean.FightCache;
/*    */ import xtable.Rolefightcache;
/*    */ 
/*    */ public class POnDivorce extends mzm.gsp.marriage.event.DivorceEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     Set<Long> roleIds = new HashSet();
/* 14 */     roleIds.add(Long.valueOf(((DivorceArg)this.arg).roleidA));
/* 15 */     roleIds.add(Long.valueOf(((DivorceArg)this.arg).roleidB));
/* 16 */     lock(Rolefightcache.getTable(), roleIds);
/* 17 */     FightCache fightCacheA = Rolefightcache.get(Long.valueOf(((DivorceArg)this.arg).roleidA));
/* 18 */     if (fightCacheA != null) {
/* 19 */       int skill = fightCacheA.getRole_default_skill();
/* 20 */       if ((skill > 0) && (SkillInterface.isMarrySkill(skill))) {
/* 21 */         fightCacheA.setRole_default_skill(0);
/*    */       }
/*    */     }
/* 24 */     FightCache fightCacheB = Rolefightcache.get(Long.valueOf(((DivorceArg)this.arg).roleidB));
/* 25 */     if (fightCacheB != null) {
/* 26 */       int skill = fightCacheB.getRole_default_skill();
/* 27 */       if ((skill > 0) && (SkillInterface.isMarrySkill(skill))) {
/* 28 */         fightCacheB.setRole_default_skill(0);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\POnDivorce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */