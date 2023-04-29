/*    */ package mzm.gsp.sworn.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xbean.SwornBuilder;
/*    */ import xtable.Role2swornmember;
/*    */ import xtable.Swornbuilder;
/*    */ 
/*    */ public class SwornWaitSession extends Session
/*    */ {
/*    */   private final int status;
/*    */   
/*    */   public SwornWaitSession(long interval, long swornid, int _status)
/*    */   {
/* 16 */     super(interval, swornid);
/* 17 */     this.status = _status;
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 22 */     final long swornid = getOwerId();
/* 23 */     xdb.Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 28 */         List<Long> roleids = mzm.gsp.team.main.TeamInterface.getTeamMemberList(swornid, false);
/* 29 */         if (roleids.size() < 0) {
/* 30 */           return false;
/*    */         }
/*    */         
/* 33 */         lock(Role2swornmember.getTable(), roleids);
/*    */         
/* 35 */         SwornBuilder swornBuilder = Swornbuilder.get(Long.valueOf(swornid));
/* 36 */         if (swornBuilder == null) {
/* 37 */           return false;
/*    */         }
/*    */         
/*    */ 
/* 41 */         if ((roleids.size() != swornBuilder.getRoleids().size()) || (!swornBuilder.getRoleids().containsAll(roleids))) {
/* 42 */           return false;
/*    */         }
/*    */         
/* 45 */         int swornStatus = swornBuilder.getStatus();
/*    */         
/* 47 */         if (SwornWaitSession.this.status != swornStatus) {
/* 48 */           SwornManager.logDebug(String.format("SwornWaitSession time out, status error id=%d, status:[%d/%d]", new Object[] { Long.valueOf(swornid), Integer.valueOf(SwornWaitSession.this.status), Integer.valueOf(swornStatus) }));
/* 49 */           return false;
/*    */         }
/*    */         
/* 52 */         switch (swornStatus)
/*    */         {
/*    */         case 0: 
/*    */           break;
/*    */         case 1: 
/*    */           break;
/*    */         case 2: 
/*    */           break;
/*    */         case 3: 
/*    */           break;
/*    */         case 4: 
/*    */           break;
/*    */         }
/*    */         
/*    */         
/* 67 */         SwornManager.logDebug(String.format("SwornWaitSession time out: %d %d", new Object[] { Long.valueOf(swornid), Integer.valueOf(swornStatus) }));
/* 68 */         swornBuilder.setTimer(null);
/*    */         
/* 70 */         OnlineManager.getInstance().sendMulti(new mzm.gsp.sworn.SCreateSwornFailRes(9, "", ""), roleids);
/*    */         
/*    */ 
/* 73 */         swornBuilder = null;
/* 74 */         Swornbuilder.remove(Long.valueOf(swornid));
/*    */         
/* 76 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\SwornWaitSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */