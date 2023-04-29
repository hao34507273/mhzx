/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ import mzm.gsp.map.main.scene.zone.type.PKZone;
/*    */ 
/*    */ public class MMH_GetSingleRoleCollectionFromPKZone
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final int sceneid;
/*    */   private final Collection<Long> result;
/*    */   
/*    */   public MMH_GetSingleRoleCollectionFromPKZone(int sceneid, Collection<Long> result)
/*    */   {
/* 16 */     this.sceneid = sceneid;
/* 17 */     this.result = result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 23 */     Scene scene = SceneManager.getInstance().getScene(this.sceneid);
/* 24 */     if (scene == null)
/*    */     {
/* 26 */       return;
/*    */     }
/* 28 */     PKZone zone = scene.getPkZone();
/* 29 */     if (zone == null)
/*    */     {
/* 31 */       return;
/*    */     }
/* 33 */     zone.fillSingleRole(this.result);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetSingleRoleCollectionFromPKZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */