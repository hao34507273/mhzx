/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.children.event.ChildFightSkillChangeArg;
/*    */ import xbean.FightCache;
/*    */ 
/*    */ public class POnChildFightSkillChange extends mzm.gsp.children.event.ChildFightSkillChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (mzm.gsp.children.main.ChildrenInterface.isInFight(((ChildFightSkillChangeArg)this.arg).roleid, ((ChildFightSkillChangeArg)this.arg).childid, false)) {
/* 12 */       return false;
/*    */     }
/* 14 */     FightCache xFightCache = xtable.Rolefightcache.get(Long.valueOf(((ChildFightSkillChangeArg)this.arg).roleid));
/* 15 */     if (xFightCache == null) {
/* 16 */       return false;
/*    */     }
/* 18 */     Integer defaultSkillid = (Integer)xFightCache.getChild_default_skills().get(Long.valueOf(((ChildFightSkillChangeArg)this.arg).childid));
/* 19 */     if (defaultSkillid == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     Set<Integer> fightSkills = mzm.gsp.children.main.ChildrenInterface.getChildFightSkills(((ChildFightSkillChangeArg)this.arg).childid, false);
/* 23 */     if (fightSkills.contains(defaultSkillid)) {
/* 24 */       return false;
/*    */     }
/* 26 */     xFightCache.getChild_default_skills().remove(Long.valueOf(((ChildFightSkillChangeArg)this.arg).childid));
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\POnChildFightSkillChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */