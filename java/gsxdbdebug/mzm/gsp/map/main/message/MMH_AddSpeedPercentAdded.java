/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_AddSpeedPercentAdded
/*    */   extends AbstractMapMsgHandler implements MapMsgHandlerDone<MMH_AddSpeedPercentAdded>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int percentAdded;
/*    */   private final MapCallback<Boolean> callback;
/* 13 */   private boolean result = false;
/*    */   
/*    */   public MMH_AddSpeedPercentAdded(long roleid, int percentAdded, MapCallback<Boolean> callback)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.percentAdded = percentAdded;
/* 19 */     this.callback = callback;
/*    */   }
/*    */   
/*    */   public boolean getResult()
/*    */   {
/* 24 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 30 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 31 */     if (role == null)
/*    */     {
/* 33 */       PendingMessageManager.getRolePendingMessageManager().addPendingMessage(Long.valueOf(this.roleid), this);
/* 34 */       return;
/*    */     }
/*    */     
/* 37 */     role.addSpeedPercentAdded(this.percentAdded);
/*    */     
/* 39 */     this.result = true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public MapMsgHandlerDone<MMH_AddSpeedPercentAdded> getMapMsgHandlerDone()
/*    */   {
/* 46 */     if (this.callback == null)
/*    */     {
/* 48 */       return null;
/*    */     }
/*    */     
/* 51 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 57 */     return this.callback.isCallInProcedure();
/*    */   }
/*    */   
/*    */   public boolean onMapMsgHandlerDone(MMH_AddSpeedPercentAdded mmh)
/*    */     throws Exception
/*    */   {
/* 63 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_AddSpeedPercentAdded.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */