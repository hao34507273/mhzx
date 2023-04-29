/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.map.main.scene.TransferType;
/*    */ 
/*    */ public class MMH_GMCmdTeleportToDefaultPos
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleId;
/*    */   private final int targetSceneId;
/*    */   private final int targetX;
/*    */   private final int targetY;
/*    */   
/*    */   public MMH_GMCmdTeleportToDefaultPos(long gmRoleid, long roleId, int targetSceneId, int targetX, int targetY)
/*    */   {
/* 17 */     this.gmRoleid = gmRoleid;
/* 18 */     this.roleId = roleId;
/* 19 */     this.targetSceneId = targetSceneId;
/* 20 */     this.targetX = targetX;
/* 21 */     this.targetY = targetY;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 27 */     new MMH_PlayerTransferToScene(this.roleId, this.targetSceneId, this.targetX, this.targetY, TransferType.FORCE_TRANSFER).doProcess();
/* 28 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, "teleport done");
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GMCmdTeleportToDefaultPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */