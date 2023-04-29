/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapItem;
/*    */ 
/*    */ public class MMH_OnMapItemGatherReqProcedureDone extends AbstractMapMsgHandler
/*    */ {
/*    */   private final int instanceid;
/*    */   
/*    */   public MMH_OnMapItemGatherReqProcedureDone(int instanceid)
/*    */   {
/* 12 */     this.instanceid = instanceid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 18 */     MapItem item = MapObjectInstanceManager.getInstance().getMapItem(this.instanceid);
/* 19 */     if (item != null)
/*    */     {
/* 21 */       item.onMapItemGatherReqProdureDone();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_OnMapItemGatherReqProcedureDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */