/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.SMapCommonResult;
/*    */ import mzm.gsp.map.main.MapItemGatherContext;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapItem;
/*    */ 
/*    */ public class MMH_AddMapItemGatherTask extends AbstractMapMsgHandler
/*    */ {
/*    */   public final long roleid;
/*    */   private final int instanceid;
/*    */   private final MapItemGatherContext context;
/*    */   
/*    */   public MMH_AddMapItemGatherTask(long roleid, int instanceid, MapItemGatherContext context)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.instanceid = instanceid;
/* 18 */     this.context = context;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 24 */     MapItem item = MapObjectInstanceManager.getInstance().getMapItem(this.instanceid);
/* 25 */     if (item == null)
/*    */     {
/* 27 */       SMapCommonResult mapCommonResult = new SMapCommonResult();
/* 28 */       mapCommonResult.result = 102;
/* 29 */       MapProtocolSendQueue.getInstance().send(this.roleid, mapCommonResult);
/* 30 */       return;
/*    */     }
/*    */     
/* 33 */     item.addGatherTask(this.roleid, this.context);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_AddMapItemGatherTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */