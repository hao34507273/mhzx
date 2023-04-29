/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.crosscompete.team.PDesignTeam;
/*    */ import mzm.gsp.crosscompete.team.RTryRestoreTeam;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class RLoginByTeamBack extends LogicRunnable
/*    */ {
/*    */   private final long roleid;
/*    */   private final long contextid;
/*    */   
/*    */   RLoginByTeamBack(long roleid, long contextid)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.contextid = contextid;
/*    */   }
/*    */   
/*    */   public void process() throws Exception
/*    */   {
/* 24 */     TeamBackContext context = TeamBackContextManager.getInstance().getContext(this.contextid);
/* 25 */     if (context == null) {
/* 26 */       return;
/*    */     }
/*    */     
/* 29 */     if (!context.setRoleLogin(this.roleid))
/*    */     {
/* 31 */       return;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 36 */     long factionid = GangInterface.getGangId(this.roleid);
/* 37 */     if (factionid > 0L) {
/* 38 */       GangInterface.transferToGangMap(this.roleid, factionid);
/*    */     }
/*    */     else {
/* 41 */       MapInterface.forceTransferWhenFault(this.roleid);
/*    */     }
/*    */     
/* 44 */     List<Long> memberList = context.getRoleidList();
/*    */     
/* 46 */     new RTryRestoreTeam(this.roleid, memberList).run();
/*    */     
/* 48 */     context.setRoleTeamRestore(this.roleid);
/*    */     
/* 50 */     if ((context.isTeamRestore()) || (context.isAllLogin())) {
/* 51 */       if (TeamBackContextManager.getInstance().removeContext(this.contextid) == null) {
/* 52 */         if (CrossCompeteManager.isLoggerDebugEnabled()) {
/* 53 */           CrossCompeteManager.logDebug("RLoginByTeamBack.process@context already removed|roleid=%d|contextid=%d|memberlist=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.contextid), memberList });
/*    */         }
/*    */         
/*    */ 
/* 57 */         return;
/*    */       }
/*    */       
/*    */ 
/* 61 */       Session.removeSession(context.getSessionid());
/*    */       
/*    */ 
/* 64 */       new PDesignTeam(memberList).call();
/*    */       
/* 66 */       CrossCompeteManager.logInfo("RLoginByTeamBack.process@design team|roleid=%d|contextid=%d|memberlist=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.contextid), memberList });
/*    */       
/*    */ 
/* 69 */       return;
/*    */     }
/*    */     
/* 72 */     CrossCompeteManager.logInfo("RLoginByTeamBack.process@wait all role login|roleid=%d|contextid=%d|memberlist=%s", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.contextid), memberList });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\RLoginByTeamBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */