/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ import mzm.gsp.map.main.scene.TransferType;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_GMCmdDragPlayer extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleId;
/*    */   private final int sceneId;
/*    */   private final int posX;
/*    */   private final int posY;
/*    */   
/*    */   public MMH_GMCmdDragPlayer(long roleId, int sceneId, int posX, int posY)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.sceneId = sceneId;
/* 20 */     this.posX = posX;
/* 21 */     this.posY = posY;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 27 */     Scene scene = SceneManager.getInstance().getScene(this.sceneId);
/* 28 */     if (scene == null)
/*    */     {
/* 30 */       return;
/*    */     }
/* 32 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/* 33 */     role.teleportWithProtocol(this.posX, this.posY, 0, this.posX, this.posY, this.sceneId, TransferType.TRANSPOS);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GMCmdDragPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */