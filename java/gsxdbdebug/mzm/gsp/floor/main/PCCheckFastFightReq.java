/*    */ package mzm.gsp.floor.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.floor.SCheckFastFightRep;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FloorFightRes;
/*    */ import xbean.GlobalSingleFloorInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCCheckFastFightReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   private final int floor;
/*    */   
/*    */   public PCCheckFastFightReq(long roleId, int activityId, int floor)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.activityId = activityId;
/* 24 */     this.floor = floor;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     GlobalSingleFloorInfo xGlobalSingleFloorInfo = FloorManager.selectGlobalSingleFloorInfo(this.activityId, this.floor);
/* 31 */     if (xGlobalSingleFloorInfo == null)
/*    */     {
/* 33 */       GameServer.logger().error(String.format("[floor]PCChekFastFightReq.processImp@ no xGlobalSingleFloorInfo!|activityId=%d|floor=%d", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(this.floor) }));
/*    */       
/*    */ 
/* 36 */       return false;
/*    */     }
/* 38 */     FloorFightRes xFastKill = xGlobalSingleFloorInfo.getFastkill();
/* 39 */     if (xFastKill.getKilltime() <= 0)
/*    */     {
/* 41 */       GameServer.logger().warn(String.format("[floor]PCChekFastFightReq.processImp@ no fast kill info!|activityId=%d|floor=%d", new Object[] { Integer.valueOf(this.activityId), Integer.valueOf(this.floor) }));
/*    */       
/*    */ 
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     SCheckFastFightRep p = new SCheckFastFightRep();
/* 48 */     p.activityid = this.activityId;
/* 49 */     p.floor = this.floor;
/* 50 */     FloorManager.fillFloorFightRes(xFastKill, p.fightinfo);
/* 51 */     OnlineManager.getInstance().send(this.roleId, p);
/*    */     
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\PCCheckFastFightReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */