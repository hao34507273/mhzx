/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.CClearApplyListReq;
/*    */ import mzm.gsp.gang.SSyncClearApplyList;
/*    */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*    */ import xbean.GangMember;
/*    */ import xbean.GangMemoryBean;
/*    */ import xtable.Gangmemory;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PClearApplyListReq
/*    */   extends GangProcedure<CClearApplyListReq>
/*    */ {
/*    */   public PClearApplyListReq(CClearApplyListReq protocol)
/*    */   {
/* 17 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CClearApplyListReq protocol)
/*    */   {
/* 23 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/* 24 */     if (xGangMember == null) {
/* 25 */       return false;
/*    */     }
/* 27 */     SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xGangMember);
/* 28 */     if (!dutyCfg.isCanMgeApplyList) {
/* 29 */       return false;
/*    */     }
/* 31 */     long gangId = xGangMember.getGangid();
/*    */     
/* 33 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/* 34 */     if (xGang == null) {
/* 35 */       return false;
/*    */     }
/* 37 */     if (!GangManager.isInGang(xGang, roleId)) {
/* 38 */       return false;
/*    */     }
/* 40 */     GangMemoryBean xGangMemory = Gangmemory.get(Long.valueOf(gangId));
/*    */     
/* 42 */     List<Long> applicants = GangManager.getApplicants(xGangMemory);
/* 43 */     xGangMemory.getApplylist().clear();
/* 44 */     ApplyObserver.removeObserver(gangId);
/* 45 */     SSyncClearApplyList sSyncClearApplyList = new SSyncClearApplyList();
/* 46 */     GangManager.broadcast(xGang, sSyncClearApplyList);
/*    */     
/*    */ 
/* 49 */     GangManager.asyncClearJoinApplicants(gangId, applicants);
/*    */     
/* 51 */     GangManager.logInfo("PClearApplyListReq.processImp@gang clear apply member list|roleid=%d", new Object[] { Long.valueOf(roleId) });
/*    */     
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PClearApplyListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */