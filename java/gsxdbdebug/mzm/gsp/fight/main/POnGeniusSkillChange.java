/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.genius.event.GeniusSkillChangeArg;
/*    */ import xbean.FightCache;
/*    */ 
/*    */ public class POnGeniusSkillChange extends mzm.gsp.genius.event.GeniusSkillChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     long roleid = ((GeniusSkillChangeArg)this.arg).roleid;
/* 11 */     FightCache xFightCache = xtable.Rolefightcache.get(Long.valueOf(roleid));
/* 12 */     if (xFightCache == null)
/*    */     {
/* 14 */       return false;
/*    */     }
/*    */     
/* 17 */     int skill = xFightCache.getRole_default_skill();
/* 18 */     if (skill <= 0)
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     int realSkillCfgid = mzm.gsp.skill.main.SkillInterface.getRealSkillCfgid(roleid, skill, true);
/* 24 */     if (realSkillCfgid == skill)
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     xFightCache.setRole_default_skill(realSkillCfgid);
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\POnGeniusSkillChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */