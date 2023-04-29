/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.CCallLevelUpDonateReq;
/*    */ import mzm.gsp.gang.SSyncGangLevelUpDonate;
/*    */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.GangMember;
/*    */ 
/*    */ public class PCallGangLevelUpDonateReq extends GangProcedure<CCallLevelUpDonateReq>
/*    */ {
/*    */   public PCallGangLevelUpDonateReq(CCallLevelUpDonateReq protocol)
/*    */   {
/* 13 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CCallLevelUpDonateReq protocol)
/*    */   {
/* 19 */     GangMember xGangMember = xtable.Role2gangmember.get(Long.valueOf(roleId));
/* 20 */     if (xGangMember == null) {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/* 25 */     if (xGang == null) {
/* 26 */       return false;
/*    */     }
/* 28 */     if (!GangManager.isInGang(xGang, roleId)) {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     SGangDutyCfg gangDutyCfg = GangManager.getDutyCfg(xGangMember);
/* 33 */     if (!gangDutyCfg.isCanLevelUpGang) {
/* 34 */       return false;
/*    */     }
/* 36 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 37 */     if (xGang.getLeveluptime() < curTime) {
/* 38 */       return false;
/*    */     }
/* 40 */     SSyncGangLevelUpDonate sSyncGangLevelUpDonate = new SSyncGangLevelUpDonate();
/* 41 */     GangManager.broadcast(xGang, sSyncGangLevelUpDonate);
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCallGangLevelUpDonateReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */