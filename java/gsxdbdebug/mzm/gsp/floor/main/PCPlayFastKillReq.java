/*    */ package mzm.gsp.floor.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FloorFightRes;
/*    */ 
/*    */ public class PCPlayFastKillReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   private final int floor;
/*    */   
/*    */   public PCPlayFastKillReq(long roleId, int activityId, int floor)
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
/* 31 */     xbean.GlobalSingleFloorInfo xGlobalSingleFloorInfo = FloorManager.selectGlobalSingleFloorInfo(this.activityId, this.floor);
/* 32 */     if (xGlobalSingleFloorInfo == null)
/*    */     {
/* 34 */       GameServer.logger().error(String.format("[floor]PCPlayFastKillReq.processImp@ no xGlobalSingleFloorInfo!|activityId=%d|floor=%d", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(this.floor) }));
/*    */       
/*    */ 
/* 37 */       return false;
/*    */     }
/* 39 */     FloorFightRes xFastKill = xGlobalSingleFloorInfo.getFastkill();
/*    */     
/* 41 */     if (xFastKill.getRadioid() <= 0L)
/*    */     {
/* 43 */       GameServer.logger().error(String.format("[floor]PCPlayFastKillReq.processImp@ no fast kill redio!|roleId=%d|activityId=%d|floor=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(this.floor) }));
/*    */       
/*    */ 
/* 46 */       return false;
/*    */     }
/* 48 */     mzm.gsp.fight.main.FightInterface.watchFightRecord(this.roleId, xFastKill.getRadioid());
/*    */     
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\PCPlayFastKillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */