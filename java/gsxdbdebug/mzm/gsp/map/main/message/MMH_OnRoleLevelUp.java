/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_OnRoleLevelUp extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final int level;
/*    */   
/*    */   public MMH_OnRoleLevelUp(long roleid, int level)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.level = level;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 20 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 21 */     if (role != null)
/*    */     {
/* 23 */       role.setLevel(this.level);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_OnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */