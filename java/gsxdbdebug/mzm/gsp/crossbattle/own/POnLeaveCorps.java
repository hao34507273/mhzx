/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.corps.event.LeaveCorpsEventArg;
/*    */ import mzm.gsp.corps.event.LeaveCorpsProcedure;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ 
/*    */ public class POnLeaveCorps
/*    */   extends LeaveCorpsProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     long corpsid = ((LeaveCorpsEventArg)this.arg).getCorpsId();
/* 17 */     for (Iterator i$ = SCrossBattleOwnCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*    */       
/* 19 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new PTryUnregisterOnCorpsMemberChange(corpsid, activityCfgid));
/*    */     }
/*    */     
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\POnLeaveCorps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */