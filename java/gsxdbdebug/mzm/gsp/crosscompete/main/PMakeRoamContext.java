/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import hub.CrossCompeteEnterRole;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.CrossCompete;
/*    */ import xbean.CrossCompeteAgainst;
/*    */ import xbean.FactionCrossCompete;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class PMakeRoamContext
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long factionid;
/*    */   private final List<CrossCompeteEnterRole> roles;
/*    */   private final long contextid;
/*    */   public EnterContext roamContext;
/*    */   
/*    */   public PMakeRoamContext(long factionid, List<CrossCompeteEnterRole> roles, long contextid)
/*    */   {
/* 22 */     this.factionid = factionid;
/* 23 */     this.roles = roles;
/* 24 */     this.contextid = contextid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 29 */     List<Long> roleList = new ArrayList();
/*    */     
/* 31 */     List<EnterRole> roamRoles = new ArrayList();
/* 32 */     for (CrossCompeteEnterRole role : this.roles) {
/* 33 */       EnterRole roamRole = new EnterRole(role.userid, role.roleid);
/* 34 */       roamRoles.add(roamRole);
/* 35 */       roleList.add(Long.valueOf(role.roleid));
/*    */     }
/*    */     
/*    */ 
/* 39 */     lock(Basic.getTable(), roleList);
/*    */     
/*    */ 
/* 42 */     FactionCrossCompete xFactionCompete = CrossCompeteManager.getXFactionCrossCompete(this.factionid, false);
/*    */     
/*    */ 
/* 45 */     if (xFactionCompete == null) {
/* 46 */       CrossCompeteManager.logError("PMakeRoamContext.processImp@no xdb faction cross compete|factionid=%d|roles=%s", new Object[] { Long.valueOf(this.factionid), this.roles });
/*    */       
/*    */ 
/* 49 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 53 */     CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/* 54 */     if (xCompete == null) {
/* 55 */       CrossCompeteManager.logError("PMakeRoamContext.processImp@no xdb cross compete|factionid=%d|roles=%s", new Object[] { Long.valueOf(this.factionid), this.roles });
/*    */       
/*    */ 
/* 58 */       return false;
/*    */     }
/*    */     
/* 61 */     CrossCompeteAgainst xAgainst = CrossCompeteManager.getXAgainst(xCompete, this.factionid, xFactionCompete.getOpponent());
/*    */     
/* 63 */     if (xAgainst == null) {
/* 64 */       CrossCompeteManager.logError("PMakeRoamContext.processImp@no xdb against|factionid=%d|roles=%s", new Object[] { Long.valueOf(this.factionid), this.roles });
/*    */       
/*    */ 
/* 67 */       return false;
/*    */     }
/*    */     
/* 70 */     this.roamContext = new EnterContext(this.factionid, roamRoles, xAgainst.getRoam_serverid(), this.contextid);
/*    */     
/*    */ 
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\PMakeRoamContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */