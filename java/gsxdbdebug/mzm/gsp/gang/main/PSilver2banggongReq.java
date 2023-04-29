/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.gang.CSilver2banggongReq;
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.gang.SSilver2banggongRes;
/*    */ import mzm.gsp.gang.confbean.SBangGongRedeemCfg;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.gang.event.RedeemBangGongEvent;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PSilver2banggongReq extends GangProcedure<CSilver2banggongReq>
/*    */ {
/*    */   public PSilver2banggongReq(CSilver2banggongReq protocol)
/*    */   {
/* 22 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CSilver2banggongReq protocol)
/*    */   {
/* 28 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/* 29 */     if (xGangMember == null) {
/* 30 */       return false;
/*    */     }
/* 32 */     long gangId = xGangMember.getGangid();
/*    */     
/* 34 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/* 35 */     if (xGang == null) {
/* 36 */       return false;
/*    */     }
/* 38 */     if (!GangManager.isInGang(xGang, roleId)) {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     if (GangManager.getDiffDay(xGangMember.getJointime(), DateTimeUtils.getCurrTimeInMillis()) < SGangConst.getInstance().REDEEM_BANGGONG_NEED_JOIN_DAY) {
/* 43 */       SGangNormalResult result = new SGangNormalResult();
/* 44 */       result.result = 43;
/* 45 */       OnlineManager.getInstance().sendAtOnce(roleId, result);
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     SBangGongRedeemCfg sBangGongRedeemCfg = SBangGongRedeemCfg.get(protocol.level);
/* 50 */     if (sBangGongRedeemCfg == null) {
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     if (!RoleInterface.cutSilver(roleId, sBangGongRedeemCfg.costSilver, new TLogArg(LogReason.GANG_REDEEM_BANGGONG_SILVER_REM))) {
/* 55 */       return false;
/*    */     }
/* 57 */     int addBangGong = sBangGongRedeemCfg.redeemBangGong;
/* 58 */     long redeemHistory = xGangMember.getRedeembanggong();
/* 59 */     if (redeemHistory == SGangConst.getInstance().SILVER2BANGGONG_LIMIT) {
/* 60 */       return false;
/*    */     }
/* 62 */     long totalRedeem = addBangGong + redeemHistory;
/* 63 */     if (totalRedeem > SGangConst.getInstance().SILVER2BANGGONG_LIMIT) {
/* 64 */       return false;
/*    */     }
/*    */     
/* 67 */     ModBangGongResult modBangGongResult = GangInterface.addBangGongWithinMax(roleId, (int)(totalRedeem - redeemHistory), new TLogArg(LogReason.GANG_BUILDING_LEVELUP_SILVER_DONATE_REM));
/* 68 */     if (!modBangGongResult.isSucceed()) {
/* 69 */       if (modBangGongResult.getRes() == ModBangGongResult.ErrorResult.ERROR_BANGGONG_NUM_HAS_REACH_TOP_LIMIT) {
/* 70 */         SGangNormalResult result = new SGangNormalResult();
/* 71 */         result.result = 52;
/* 72 */         OnlineManager.getInstance().sendAtOnce(roleId, result);
/*    */       }
/* 74 */       return false;
/*    */     }
/*    */     
/* 77 */     xGangMember.setRedeembanggong(totalRedeem);
/* 78 */     xGangMember.setNextupdateredeemtimestamp(DateTimeUtils.getCurrTimeInMillis());
/* 79 */     SSilver2banggongRes res = new SSilver2banggongRes();
/* 80 */     res.level = protocol.level;
/* 81 */     res.silver2banggonghistory = ((int)totalRedeem);
/* 82 */     OnlineManager.getInstance().send(roleId, res);
/*    */     
/* 84 */     TriggerEventsManger.getInstance().triggerEvent(new RedeemBangGongEvent(), Long.valueOf(roleId));
/*    */     
/* 86 */     GangManager.logInfo("PSilver2banggongReq.processImp@silver exchange banggong success|roleid=%d|gangid=%d|exchange_level=%d|banggong_history=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(gangId), Integer.valueOf(res.level), Integer.valueOf(res.silver2banggonghistory) });
/* 87 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PSilver2banggongReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */