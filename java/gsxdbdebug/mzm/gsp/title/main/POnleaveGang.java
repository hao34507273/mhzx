/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.event.LeaveGangArg;
/*    */ import mzm.gsp.gang.event.LeaveGangProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class POnleaveGang
/*    */   extends LeaveGangProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     for (Iterator i$ = ((LeaveGangArg)this.arg).extraMemberList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 15 */       NoneRealTimeTaskManager.getInstance().addTask(new PRoleLeaveGang(roleId, ((LeaveGangArg)this.arg).gangId));
/*    */     }
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\POnleaveGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */