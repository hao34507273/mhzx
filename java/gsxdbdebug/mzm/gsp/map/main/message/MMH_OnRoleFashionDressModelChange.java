/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.roledye.ColorIds;
/*    */ 
/*    */ public class MMH_OnRoleFashionDressModelChange extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final ColorIds colorIds;
/*    */   
/*    */   public MMH_OnRoleFashionDressModelChange(long roleid, ColorIds colorIds)
/*    */   {
/* 13 */     this.roleid = roleid;
/* 14 */     this.colorIds = colorIds;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 20 */     mzm.gsp.map.main.scene.object.MapRole mapRole = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 21 */     if (mapRole == null)
/*    */     {
/* 23 */       return;
/*    */     }
/*    */     
/* 26 */     mapRole.onRoleFashionDressModelChange(this.colorIds.fashiondresscfgid, this.colorIds.hairid, this.colorIds.clothid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_OnRoleFashionDressModelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */