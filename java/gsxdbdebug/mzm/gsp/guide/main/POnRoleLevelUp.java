/*    */ package mzm.gsp.guide.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnRoleLevelUp
/*    */   extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     long roleid = ((RoleLevelUpArg)this.arg).roleId;
/* 16 */     int oldLevel = ((RoleLevelUpArg)this.arg).oldLevel;
/* 17 */     int newLevel = ((RoleLevelUpArg)this.arg).newLevel;
/*    */     
/*    */ 
/* 20 */     Set<Integer> newGuideids = new HashSet();
/* 21 */     Set<Integer> toremove = new HashSet();
/* 22 */     for (int i = oldLevel + 1; i <= newLevel; i++) {
/* 23 */       Set<Integer> guideids = GuideManager.getGuideIdsByRoleLevel(i);
/*    */       
/* 25 */       GuideManager.filterMenpaiGuide(((RoleLevelUpArg)this.arg).roleId, guideids);
/*    */       
/*    */ 
/* 28 */       for (Iterator i$ = guideids.iterator(); i$.hasNext();) { int guideid = ((Integer)i$.next()).intValue();
/* 29 */         if (GuideManager.isGuided(((RoleLevelUpArg)this.arg).roleId, guideid)) {
/* 30 */           toremove.add(Integer.valueOf(guideid));
/*    */         }
/*    */         else
/* 33 */           GuideManager.setUnGuidedState(roleid, guideid);
/*    */       }
/* 35 */       newGuideids.addAll(guideids);
/*    */     }
/*    */     
/*    */ 
/* 39 */     newGuideids.removeAll(toremove);
/* 40 */     if (!newGuideids.isEmpty())
/*    */     {
/* 42 */       GuideManager.sendCanGuideids(roleid, newGuideids);
/*    */       
/* 44 */       String logstr = String.format("[guide]POnRoleLevelUp.processImp@send can guideid success roleid=%d|oldlevel=%d|newlevel=%d|guideids=%s", new Object[] { Long.valueOf(((RoleLevelUpArg)this.arg).roleId), Integer.valueOf(((RoleLevelUpArg)this.arg).oldLevel), Integer.valueOf(((RoleLevelUpArg)this.arg).newLevel), newGuideids.toString() });
/* 45 */       GuideManager.logger.info(logstr);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */