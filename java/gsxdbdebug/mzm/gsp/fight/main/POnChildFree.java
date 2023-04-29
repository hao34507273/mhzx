/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import mzm.gsp.children.event.ChildFreeArg;
/*    */ 
/*    */ public class POnChildFree extends mzm.gsp.children.event.ChildFreeProcedure {
/*    */   protected boolean processImp() throws Exception {
/*  7 */     xbean.FightCache fightCache = xtable.Rolefightcache.get(Long.valueOf(((ChildFreeArg)this.arg).roleId));
/*  8 */     if (fightCache == null) {
/*  9 */       return false;
/*    */     }
/* 11 */     if (fightCache.getChild_default_skills().remove(Long.valueOf(((ChildFreeArg)this.arg).childId)) != null) {
/* 12 */       FightInterface.syncAutoState(((ChildFreeArg)this.arg).roleId);
/* 13 */       return true;
/*    */     }
/* 15 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\POnChildFree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */