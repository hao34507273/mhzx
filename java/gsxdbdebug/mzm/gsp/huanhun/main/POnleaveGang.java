/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.event.LeaveGangArg;
/*    */ import mzm.gsp.gang.event.LeaveGangProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ public class POnleaveGang
/*    */   extends LeaveGangProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     lock(Basic.getTable(), ((LeaveGangArg)this.arg).extraMemberList);
/* 18 */     for (Iterator i$ = ((LeaveGangArg)this.arg).extraMemberList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 20 */       NoneRealTimeTaskManager.getInstance().addTask(new PRmRoleAllHelp(roleId, ((LeaveGangArg)this.arg).gangId));
/*    */     }
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\POnleaveGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */