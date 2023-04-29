/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_GetRoleMapId
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/* 12 */   private int mapCfgid = -1;
/*    */   
/*    */   public MMH_GetRoleMapId(long roleid)
/*    */   {
/* 16 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public int getMapCfgid()
/*    */   {
/* 21 */     return this.mapCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 27 */     MapRole mapRole = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 28 */     if (mapRole == null)
/*    */     {
/* 30 */       return;
/*    */     }
/* 32 */     Scene scene = SceneManager.getInstance().getScene(mapRole.getSceneId());
/* 33 */     if (scene == null)
/*    */     {
/* 35 */       return;
/*    */     }
/* 37 */     this.mapCfgid = scene.getCfgId();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetRoleMapId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */