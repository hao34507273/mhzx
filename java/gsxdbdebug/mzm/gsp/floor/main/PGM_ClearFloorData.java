/*    */ package mzm.gsp.floor.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.GlobalFloorActivityInfo;
/*    */ 
/*    */ public class PGM_ClearFloorData extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   
/*    */   public PGM_ClearFloorData(long roleId, int activityId)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     GlobalFloorActivityInfo xGlobalInfo = xtable.Globalfloor.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 24 */     if (xGlobalInfo == null)
/*    */     {
/* 26 */       GameServer.logger().error(String.format("[floor]PGM_ClearFloorData.processImp@ no xGlobalInfo!|activityId=%d", new Object[] { Integer.valueOf(this.activityId) }));
/*    */       
/* 28 */       return false;
/*    */     }
/* 30 */     xGlobalInfo.getActivityinfo().remove(Integer.valueOf(this.activityId));
/* 31 */     GmManager.getInstance().sendResultToGM(this.roleId, "重置楼层信息成功！");
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\PGM_ClearFloorData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */