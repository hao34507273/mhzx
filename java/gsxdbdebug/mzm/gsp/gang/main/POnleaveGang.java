/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.SSyncCancelTanHe;
/*    */ import mzm.gsp.gang.event.LeaveGangArg;
/*    */ import mzm.gsp.gang.event.LeaveGangProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class POnleaveGang
/*    */   extends LeaveGangProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(((LeaveGangArg)this.arg).gangId));
/* 16 */     if (xGang == null)
/* 17 */       return false;
/*    */     Iterator i$;
/* 19 */     if (xGang.getTanheroleid() > 0L) {
/* 20 */       for (i$ = ((LeaveGangArg)this.arg).extraMemberList.iterator(); i$.hasNext();) { long gangMemberId = ((Long)i$.next()).longValue();
/* 21 */         if (xGang.getTanheroleid() == gangMemberId) {
/* 22 */           xGang.setTanheroleid(0L);
/* 23 */           xGang.setTanheendtime(0L);
/* 24 */           GangTanHeObserver.stopTanHe(((LeaveGangArg)this.arg).gangId);
/*    */           
/* 26 */           SSyncCancelTanHe sSyncCancelTanHe = new SSyncCancelTanHe();
/* 27 */           sSyncCancelTanHe.roleid = gangMemberId;
/* 28 */           GangManager.broadcast(xGang, sSyncCancelTanHe);
/*    */           
/* 30 */           Procedure.execute(new PAddTanHeCanelTlog(gangMemberId, xGang.getBangzhuid(), ((LeaveGangArg)this.arg).gangId, xGang.getDisplayid()));
/* 31 */           break;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\POnleaveGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */