/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_AddSpeedFixAdded
/*    */   extends AbstractMapMsgHandler implements MapMsgHandlerDone<MMH_AddSpeedFixAdded>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int fixAdded;
/*    */   private final MapCallback<Boolean> callback;
/* 13 */   private boolean result = false;
/*    */   
/*    */   public MMH_AddSpeedFixAdded(long roleid, int fixAdded, MapCallback<Boolean> callback)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.fixAdded = fixAdded;
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
/*    */       
/* 35 */       return;
/*    */     }
/*    */     
/* 38 */     role.addSpeedFixAdded(this.fixAdded);
/*    */     
/* 40 */     this.result = true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public MapMsgHandlerDone<MMH_AddSpeedFixAdded> getMapMsgHandlerDone()
/*    */   {
/* 47 */     if (this.callback == null)
/*    */     {
/* 49 */       return null;
/*    */     }
/*    */     
/* 52 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 58 */     return this.callback.isCallInProcedure();
/*    */   }
/*    */   
/*    */   public boolean onMapMsgHandlerDone(MMH_AddSpeedFixAdded mmh)
/*    */     throws Exception
/*    */   {
/* 64 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_AddSpeedFixAdded.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */