/*    */ package mzm.gsp.firework.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.MapItemGatherSavePostionContext;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCCollectFireworkReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int instanceId;
/*    */   
/*    */   public PCCollectFireworkReq(long roleId, int instanceId)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.instanceId = instanceId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     MapInterface.gatherMapItem(this.roleId, this.instanceId, new CollectFireworkContext());
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   class CollectFireworkContext implements MapItemGatherSavePostionContext
/*    */   {
/* 28 */     private Position pos = null;
/*    */     
/*    */     CollectFireworkContext() {}
/*    */     
/*    */     public void saveMapItemPosition(Position pos) {
/* 33 */       this.pos = pos;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     public Position getPos()
/*    */     {
/* 43 */       return this.pos;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\PCCollectFireworkReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */