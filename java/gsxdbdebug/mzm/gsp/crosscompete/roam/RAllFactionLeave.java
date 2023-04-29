/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xbean.RoamCrossCompeteFaction;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ class RAllFactionLeave
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long factionid;
/*    */   
/*    */   RAllFactionLeave(long factionid)
/*    */   {
/* 23 */     this.factionid = factionid;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 29 */     RoamCrossCompeteFaction xFaction = CrossCompeteRoamManager.getXRoamCrossCompeteFaction(this.factionid, false);
/*    */     
/*    */ 
/* 32 */     if (xFaction == null) {
/* 33 */       CrossCompeteManager.logError("RAllFactionLeave.process@faction null|factionid=%d", new Object[] { Long.valueOf(this.factionid) });
/*    */       
/* 35 */       return;
/*    */     }
/*    */     
/* 38 */     List<Long> members = CrossCompeteRoamManager.getMembers(xFaction);
/* 39 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 40 */       new PTryReturnOriginalServer(roleid).call();
/*    */     }
/*    */   }
/*    */   
/*    */   static class PTryReturnOriginalServer extends LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     
/*    */     PTryReturnOriginalServer(long roleid) {
/* 49 */       this.roleid = roleid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 55 */       String userid = RoleInterface.getUserId(this.roleid);
/*    */       
/* 57 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */       
/* 59 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */       
/* 61 */       boolean ret = RoleStatusInterface.unsetStatus(this.roleid, 1502);
/* 62 */       if (ret) {
/* 63 */         CrossCompeteRoamManager.returnOriginalServer(userid, this.roleid);
/*    */         
/* 65 */         CrossCompeteManager.logInfo("PTryReturnOriginalServer.processImp@return succeed|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       }
/*    */       
/*    */ 
/* 69 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\RAllFactionLeave.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */