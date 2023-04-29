/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ import mzm.gsp.map.main.scene.zone.type.PKZone;
/*    */ 
/*    */ public class MMH_IsRoleInPkZone
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final int sceneid;
/* 12 */   private boolean result = false;
/*    */   
/*    */   public MMH_IsRoleInPkZone(long roleid, int sceneid)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.sceneid = sceneid;
/*    */   }
/*    */   
/*    */   public boolean getResult()
/*    */   {
/* 22 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 28 */     Scene scene = SceneManager.getInstance().getScene(this.sceneid);
/* 29 */     if (scene == null)
/*    */     {
/* 31 */       return;
/*    */     }
/* 33 */     PKZone zone = scene.getPkZone();
/* 34 */     if (zone == null)
/*    */     {
/* 36 */       return;
/*    */     }
/*    */     
/* 39 */     this.result = zone.containRole(this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_IsRoleInPkZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */