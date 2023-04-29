/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_SetXunLuoState extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final boolean setting;
/*    */   
/*    */   public MMH_SetXunLuoState(long roleid, boolean setting)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.setting = setting;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 20 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 21 */     if (role == null)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     role.setXunLuoState(this.setting);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_SetXunLuoState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */