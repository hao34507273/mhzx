/*    */ package mzm.gsp.factiontask.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.gang.event.LeaveGangArg;
/*    */ import mzm.gsp.gang.event.LeaveGangProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class POnleaveGang extends LeaveGangProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     int graphId = GangTaskManager.getGangTaskGraph();
/* 13 */     for (Iterator i$ = ((LeaveGangArg)this.arg).extraMemberList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 14 */       Procedure.execute(new PCloseGraph(roleId, graphId));
/*    */     }
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factiontask\main\POnleaveGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */