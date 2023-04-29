/*    */ package mzm.gsp.singlebattle.gather;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MapCallBack_RemoveMapEntity
/*    */   implements MapCallback<Boolean>
/*    */ {
/*    */   private final long battleId;
/*    */   private final long instanceId;
/*    */   private final int gatherItemCfgId;
/*    */   private final RemoveGatherItemReason reason;
/*    */   
/*    */   MapCallBack_RemoveMapEntity(long battleId, long instanceId, int gatherItemId, RemoveGatherItemReason reason)
/*    */   {
/* 24 */     this.battleId = battleId;
/* 25 */     this.instanceId = instanceId;
/* 26 */     this.gatherItemCfgId = gatherItemId;
/* 27 */     this.reason = reason;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static enum RemoveGatherItemReason
/*    */   {
/* 38 */     GATHERED, 
/* 39 */     TIME_OUT, 
/* 40 */     MATCH_END, 
/* 41 */     OTHER;
/*    */     
/*    */     private RemoveGatherItemReason() {}
/*    */   }
/*    */   
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 48 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onResult(Boolean result)
/*    */   {
/* 54 */     GameServer.logger().info(String.format("[battlegather]MapCallBack_RemoveMapEntity.onResult@ after remove mapEntity!|battleid=%d|instanceId=%d|gatherItemCfgId=%d|reason=%s|result=%s", new Object[] { Long.valueOf(this.battleId), Long.valueOf(this.instanceId), Integer.valueOf(this.gatherItemCfgId), this.reason, result }));
/*    */     
/*    */ 
/*    */ 
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\gather\MapCallBack_RemoveMapEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */