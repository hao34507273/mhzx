/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.map.main.scene.TransferType;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_TransformToRole
/*    */   extends AbstractMapMsgHandler
/*    */   implements MapMsgHandlerDone<MMH_TransformToRole>
/*    */ {
/*    */   public final long transferRoleId;
/*    */   public final long targetRoleId;
/*    */   private final MapCallback<Boolean> callback;
/* 16 */   private boolean result = false;
/*    */   
/*    */   public MMH_TransformToRole(long transferRoleId, long targetRoleId, MapCallback<Boolean> callback)
/*    */   {
/* 20 */     this.transferRoleId = transferRoleId;
/* 21 */     this.targetRoleId = targetRoleId;
/* 22 */     this.callback = callback;
/*    */   }
/*    */   
/*    */   public boolean getResult()
/*    */   {
/* 27 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 33 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.transferRoleId);
/* 34 */     MapRole target = MapObjectInstanceManager.getInstance().getMapRole(this.targetRoleId);
/* 35 */     if ((role == null) || (target == null))
/*    */     {
/* 37 */       return;
/*    */     }
/*    */     
/* 40 */     role.setXunLuoState(false);
/*    */     
/* 42 */     Position targetPos = target.getPositionForInner();
/* 43 */     new MMH_PlayerTransferToScene(this.transferRoleId, targetPos.getSceneId(), targetPos.getX(), targetPos.getY(), targetPos.getX(), targetPos.getY(), target.getChannelid(), TransferType.TRANSPOS, this.callback).doProcess();
/*    */     
/*    */ 
/*    */ 
/* 47 */     this.result = true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected MapMsgHandlerDone<MMH_TransformToRole> getMapMsgHandlerDone()
/*    */   {
/* 54 */     if (this.callback == null)
/*    */     {
/* 56 */       return null;
/*    */     }
/*    */     
/* 59 */     return this;
/*    */   }
/*    */   
/*    */   public boolean onMapMsgHandlerDone(MMH_TransformToRole mmh)
/*    */     throws Exception
/*    */   {
/* 65 */     return this.callback.onResult(Boolean.valueOf(mmh.getResult()));
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 71 */     return this.callback.isCallInProcedure();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_TransformToRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */