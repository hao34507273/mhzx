/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PPayAllGangs
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     Set<Long> gangids = GangManager.getAllGangIdSet();
/* 18 */     for (Iterator i$ = gangids.iterator(); i$.hasNext();) { long gangid = ((Long)i$.next()).longValue();
/* 19 */       NoneRealTimeTaskManager.getInstance().addTask(new PPayOneGang(gangid));
/*    */     }
/*    */     
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PPayAllGangs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */