/*    */ package mzm.gsp.factiontask.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.event.GangDissolveProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class POnGangDissolve
/*    */   extends GangDissolveProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     int graphId = GangTaskManager.getGangTaskGraph();
/* 16 */     for (Iterator i$ = ((GangArg)this.arg).extraMemberList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 18 */       Procedure.execute(new PCloseGraph(roleId, graphId));
/*    */     }
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factiontask\main\POnGangDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */