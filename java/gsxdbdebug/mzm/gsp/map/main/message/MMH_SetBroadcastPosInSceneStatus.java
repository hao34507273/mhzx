/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ 
/*    */ public class MMH_SetBroadcastPosInSceneStatus
/*    */   extends AbstractMapMsgHandler
/*    */   implements MapMsgHandlerDone<MMH_SetBroadcastPosInSceneStatus>
/*    */ {
/*    */   private final long roleid;
/*    */   private final boolean isBroadcast;
/*    */   private final MapCallback<Boolean> callback;
/* 15 */   private boolean result = false;
/*    */   
/*    */   public MMH_SetBroadcastPosInSceneStatus(long roleid, boolean isBroadcast, MapCallback<Boolean> callback)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.isBroadcast = isBroadcast;
/* 21 */     this.callback = callback;
/*    */   }
/*    */   
/*    */   public boolean getResult()
/*    */   {
/* 26 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 32 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 33 */     if (role == null)
/*    */     {
/* 35 */       return;
/*    */     }
/*    */     
/* 38 */     if (this.isBroadcast)
/*    */     {
/* 40 */       role.setState(16);
/*    */     }
/*    */     else
/*    */     {
/* 44 */       role.unsetState(16);
/*    */     }
/*    */     
/* 47 */     this.result = true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public MapMsgHandlerDone<MMH_SetBroadcastPosInSceneStatus> getMapMsgHandlerDone()
/*    */   {
/* 54 */     if (this.callback == null)
/*    */     {
/* 56 */       return null;
/*    */     }
/*    */     
/* 59 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 65 */     return this.callback.isCallInProcedure();
/*    */   }
/*    */   
/*    */   public boolean onMapMsgHandlerDone(MMH_SetBroadcastPosInSceneStatus mmh)
/*    */     throws Exception
/*    */   {
/* 71 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_SetBroadcastPosInSceneStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */