/*    */ package mzm.gsp.floor.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import xbean.FloorFightRes;
/*    */ import xbean.GlobalSingleFloorInfo;
/*    */ 
/*    */ public class PCPlayFirstBloodReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   private final int floor;
/*    */   
/*    */   public PCPlayFirstBloodReq(long roleId, int activityId, int floor)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.activityId = activityId;
/* 17 */     this.floor = floor;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!FloorManager.isCheckRecordOpen())
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     if (!FloorManager.isThisFloorOpen(this.activityId, this.floor))
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     GlobalSingleFloorInfo xGlobalSingleFloorInfo = FloorManager.selectGlobalSingleFloorInfo(this.activityId, this.floor);
/* 32 */     if (xGlobalSingleFloorInfo == null)
/*    */     {
/* 34 */       GameServer.logger().error(String.format("[floor]PCChekFastFightReq.processImp@ no xGlobalSingleFloorInfo!|activityId=%d|floor=%d", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(this.floor) }));
/*    */       
/*    */ 
/* 37 */       return false;
/*    */     }
/* 39 */     FloorFightRes xFirstBlood = xGlobalSingleFloorInfo.getFirstblood();
/*    */     
/* 41 */     if (xFirstBlood.getRadioid() <= 0L)
/*    */     {
/* 43 */       return false;
/*    */     }
/* 45 */     mzm.gsp.fight.main.FightInterface.watchFightRecord(this.roleId, xFirstBlood.getRadioid());
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\PCPlayFirstBloodReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */