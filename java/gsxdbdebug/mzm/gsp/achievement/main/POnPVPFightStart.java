/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.fight.event.PVPFightStartArg;
/*    */ import mzm.gsp.fight.event.PVPFightStartProcedure;
/*    */ import mzm.gsp.qmhw.main.QMHWFightContext;
/*    */ 
/*    */ public class POnPVPFightStart extends PVPFightStartProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     AchievementManager.collectLocks(((PVPFightStartArg)this.arg).getAllRoles());
/*    */     
/*    */     Iterator i$;
/* 16 */     if ((((PVPFightStartArg)this.arg).context instanceof QMHWFightContext))
/*    */     {
/* 18 */       for (i$ = ((PVPFightStartArg)this.arg).getAllRoles().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */         
/* 20 */         AchievementManager.updateGoalTypeState(roleId, 5100, Integer.valueOf(1), "POnPVPFightStart.processImp@handle QYHW_FINISH_FIGHT success");
/*    */       }
/*    */     }
/*    */     
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnPVPFightStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */