/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.CStartBuildingLevelUpReq;
/*    */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PStartBuildingLevelUpReq extends GangProcedure<CStartBuildingLevelUpReq>
/*    */ {
/*    */   public PStartBuildingLevelUpReq(CStartBuildingLevelUpReq protocol)
/*    */   {
/* 13 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CStartBuildingLevelUpReq protocol)
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
/* 29 */     SGangDutyCfg dutyCfg = SGangDutyCfg.get(xGangMember.getDuty());
/* 30 */     if (!dutyCfg.isCanLevelUpGang) {
/* 31 */       return false;
/*    */     }
/* 33 */     AbsGangBuilding building = BuildingFactory.createGangBuilding(gangId, xGang, protocol.buildingtype);
/* 34 */     if (building.isMaxLv()) {
/* 35 */       return false;
/*    */     }
/* 37 */     if (building.getLevelUpEndTime() > DateTimeUtils.getCurrTimeInMillis()) {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     GangManager.logInfo("PStartBuildingLevelUpReq.processImp@gang building levelup start|operaterid=%d|gangid=%d|building_type=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(gangId), Integer.valueOf(building.buildingType) });
/* 42 */     return building.startLevelUp(roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PStartBuildingLevelUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */