/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapItem;
/*    */ 
/*    */ public class MMH_DestroyItem extends AbstractMapMsgHandler
/*    */ {
/*    */   private final int instanceid;
/*    */   
/*    */   public MMH_DestroyItem(int instanceid)
/*    */   {
/* 12 */     this.instanceid = instanceid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 18 */     MapItem mapItem = MapObjectInstanceManager.getInstance().getMapItem(this.instanceid);
/* 19 */     if (mapItem != null)
/*    */     {
/* 21 */       mapItem.destroy();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_DestroyItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */