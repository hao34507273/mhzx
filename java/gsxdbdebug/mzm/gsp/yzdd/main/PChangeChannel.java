/*    */ package mzm.gsp.yzdd.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class PChangeChannel extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   final int channelId;
/*    */   
/*    */   public PChangeChannel(long roleId, int channelId)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.channelId = channelId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleId);
/* 23 */     if (role.getChannelid() != this.channelId) {
/* 24 */       role.setChannelid(this.channelId);
/*    */     }
/* 26 */     MapObjectInstanceManager.getInstance().addMapRole(role);
/* 27 */     Scene scene = SceneManager.getInstance().getScene(role.getPositionForInner());
/* 28 */     if (scene == null) {
/* 29 */       Position pos = mzm.gsp.map.main.WorldManager.getInstance().getBigWorldInstance().getPosition(this.roleId);
/* 30 */       role.setPosition(pos.getX(), pos.getY(), pos.getZ(), pos.getSceneId());
/* 31 */       scene = SceneManager.getInstance().getScene(role.getPositionForInner());
/*    */     }
/* 33 */     role.spawnMe();
/* 34 */     scene.sendWorldShareMapEntityEnterViewToRole(role);
/* 35 */     scene.sendNotOwnViewMapEntityEnterViewToRole(role);
/* 36 */     scene.sendTransferEnterViewToRole(role);
/* 37 */     role.reSyncAllView();
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yzdd\main\PChangeChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */