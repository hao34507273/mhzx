/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.CBuildingLevelUpDonateReq;
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PBuildingLevelUpDonateReq extends GangProcedure<CBuildingLevelUpDonateReq>
/*    */ {
/*    */   public PBuildingLevelUpDonateReq(CBuildingLevelUpDonateReq protocol)
/*    */   {
/* 13 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CBuildingLevelUpDonateReq protocol)
/*    */   {
/* 19 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/* 20 */     if (xGangMember == null) {
/* 21 */       return false;
/*    */     }
/* 23 */     long gangId = xGangMember.getGangid();
/*    */     
/* 25 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/* 26 */     if (!GangManager.isInGang(xGang, roleId)) {
/* 27 */       return false;
/*    */     }
/* 29 */     AbsGangBuilding gangBuilding = BuildingFactory.createGangBuilding(gangId, xGang, protocol.buildingtype);
/* 30 */     if (gangBuilding.getLevelUpEndTime() < mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis()) {
/* 31 */       SGangNormalResult sGangNormalResult = new SGangNormalResult();
/* 32 */       sGangNormalResult.result = 32;
/* 33 */       OnlineManager.getInstance().sendAtOnce(roleId, sGangNormalResult);
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     GangManager.logInfo("PBuildingLevelUpDonateReq.doProcess@gang building levelup donate|roleid=%d|buildingtype=%d|donatelv=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(protocol.buildingtype), Integer.valueOf(protocol.donatelv) });
/* 38 */     return gangBuilding.donate(roleId, protocol.donatelv);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PBuildingLevelUpDonateReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */