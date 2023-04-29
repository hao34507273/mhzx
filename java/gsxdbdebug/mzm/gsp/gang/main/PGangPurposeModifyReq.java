/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.gang.SSyncNewGangPurpose;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.sensitive.main.SensitiveInterface;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PGangPurposeModifyReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private String purpose;
/*    */   
/*    */   public PGangPurposeModifyReq(long roleId, String purpose)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.purpose = purpose;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 28 */     if (Math.ceil(CommonUtils.getUTF16Length(this.purpose) / 2.0D) > SGangConst.getInstance().GANG_PURPOSE_MAX_LENGTH) {
/* 29 */       return false;
/*    */     }
/* 31 */     if (SensitiveInterface.isContentSensitive(this.purpose)) {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.roleId));
/* 36 */     if (xGangMember == null) {
/* 37 */       return false;
/*    */     }
/* 39 */     SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xGangMember);
/* 40 */     if (!dutyCfg.isCanModifyPurpose) {
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/* 45 */     if (xGang == null) {
/* 46 */       return false;
/*    */     }
/* 48 */     if (!GangManager.isInGang(xGang, this.roleId)) {
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     if (SensitiveInterface.isContentSensitive(this.purpose)) {
/* 53 */       SGangNormalResult result = new SGangNormalResult();
/* 54 */       result.result = 1;
/* 55 */       OnlineManager.getInstance().sendAtOnce(this.roleId, result);
/* 56 */       return false;
/*    */     }
/* 58 */     xGang.setPurpose(this.purpose);
/* 59 */     SSyncNewGangPurpose sSyncNewGangPurpose = new SSyncNewGangPurpose();
/* 60 */     sSyncNewGangPurpose.purpose = this.purpose;
/* 61 */     GangManager.broadcast(xGang, sSyncNewGangPurpose);
/*    */     
/* 63 */     GangManager.logInfo("PGangPurposeModifyReq.processImp@modify gang purpose success|roleid=%d|gangid=%d|purpose=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(xGangMember.getGangid()), this.purpose });
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGangPurposeModifyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */