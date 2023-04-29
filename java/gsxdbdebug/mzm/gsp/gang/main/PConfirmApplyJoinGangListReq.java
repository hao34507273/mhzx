/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.gang.CConfirmApplyJoinGangListReq;
/*    */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.GangMember;
/*    */ import xbean.GangMemoryBean;
/*    */ import xtable.Gangmemory;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PConfirmApplyJoinGangListReq extends GangProcedure<CConfirmApplyJoinGangListReq>
/*    */ {
/*    */   public PConfirmApplyJoinGangListReq(CConfirmApplyJoinGangListReq protocol)
/*    */   {
/* 18 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CConfirmApplyJoinGangListReq protocol)
/*    */   {
/* 24 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/* 25 */     if (xGangMember == null) {
/* 26 */       return false;
/*    */     }
/* 28 */     SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xGangMember);
/* 29 */     if (!dutyCfg.isCanMgeApplyList) {
/* 30 */       if (GangManager.logger.isDebugEnabled()) {
/* 31 */         GangManager.logDebug("PConfirmApplyJoinGangListReq.processImp@can not mgeapply!|roleid=%d", new Object[] { Long.valueOf(roleId) });
/*    */       }
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     long gangId = xGangMember.getGangid();
/*    */     
/* 38 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/* 39 */     if (xGang == null) {
/* 40 */       return false;
/*    */     }
/* 42 */     if (!GangManager.isInGang(xGang, roleId)) {
/* 43 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 47 */     GangMemoryBean xGangMemory = Gangmemory.select(Long.valueOf(gangId));
/* 48 */     ArrayList<Long> applicants = GangManager.getApplicants(xGangMemory);
/*    */     
/* 50 */     NoneRealTimeTaskManager.getInstance().addTask(new ROnAddGangApplys(roleId, applicants));
/*    */     
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   static class ROnAddGangApplys extends LogicRunnable
/*    */   {
/*    */     private final long operatorRoleId;
/*    */     private final ArrayList<Long> applicants;
/*    */     
/*    */     ROnAddGangApplys(long operatorRoleId, ArrayList<Long> applicants) {
/* 61 */       this.applicants = applicants;
/* 62 */       this.operatorRoleId = operatorRoleId;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 68 */       for (int i = this.applicants.size() - 1; i >= 0; i--) {
/* 69 */         long applicant = ((Long)this.applicants.get(i)).longValue();
/* 70 */         new PConfirmApplyJoinGangReq(this.operatorRoleId, applicant).call();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PConfirmApplyJoinGangListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */