/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.CCallBuildingLevelUpDonateReq;
/*    */ import mzm.gsp.gang.SSyncCallBuildingLevelUpDonate;
/*    */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PCallBuildingLevelUpDonateReq
/*    */   extends GangProcedure<CCallBuildingLevelUpDonateReq>
/*    */ {
/*    */   public PCallBuildingLevelUpDonateReq(CCallBuildingLevelUpDonateReq protocol)
/*    */   {
/* 14 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CCallBuildingLevelUpDonateReq protocol)
/*    */   {
/* 20 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/* 21 */     if (xGangMember == null) {
/* 22 */       return false;
/*    */     }
/* 24 */     long gangId = xGangMember.getGangid();
/*    */     
/* 26 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/* 27 */     if (!GangManager.isInGang(xGang, roleId)) {
/* 28 */       return false;
/*    */     }
/* 30 */     SGangDutyCfg dutyCfg = SGangDutyCfg.get(xGangMember.getDuty());
/* 31 */     if (!dutyCfg.isCanLevelUpGang) {
/* 32 */       return false;
/*    */     }
/* 34 */     SSyncCallBuildingLevelUpDonate sSyncCallBuildingLevelUpDonate = new SSyncCallBuildingLevelUpDonate();
/* 35 */     sSyncCallBuildingLevelUpDonate.buildingtype = protocol.buildingtype;
/* 36 */     GangManager.broadcast(xGang, sSyncCallBuildingLevelUpDonate);
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PCallBuildingLevelUpDonateReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */