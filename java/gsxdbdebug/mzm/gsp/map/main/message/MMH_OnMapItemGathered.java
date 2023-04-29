/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapItem;
/*    */ 
/*    */ 
/*    */ public class MMH_OnMapItemGathered
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   public final int mapItemInstanceid;
/*    */   
/*    */   public MMH_OnMapItemGathered(long roleid, int mapItemInstanceid)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.mapItemInstanceid = mapItemInstanceid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 22 */     MapItem item = MapObjectInstanceManager.getInstance().getMapItem(this.mapItemInstanceid);
/* 23 */     if (item == null)
/*    */     {
/* 25 */       return;
/*    */     }
/*    */     
/* 28 */     item.onGathered();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_OnMapItemGathered.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */