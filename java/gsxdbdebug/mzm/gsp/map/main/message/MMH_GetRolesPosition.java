/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MMH_GetRolesPosition<T extends Position>
/*    */   extends AbstractMapMsgHandler
/*    */   implements MapMsgHandlerDone<MMH_GetRolesPosition>
/*    */ {
/*    */   private final Collection<Long> roles;
/*    */   private final MapCallback<Map<Long, T>> callback;
/* 19 */   private Map<Long, T> result = null;
/*    */   
/*    */   public MMH_GetRolesPosition(Collection<Long> roles, MapCallback<Map<Long, T>> callback)
/*    */   {
/* 23 */     this.roles = roles;
/* 24 */     this.callback = callback;
/*    */   }
/*    */   
/*    */   public final Map<Long, T> getResult()
/*    */   {
/* 29 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 36 */     Map<Long, T> roleToPos = new HashMap(this.roles.size());
/* 37 */     for (Long roleid : this.roles)
/*    */     {
/* 39 */       MapRole mapRole = MapObjectInstanceManager.getInstance().getMapRole(roleid.longValue());
/* 40 */       if (mapRole != null)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 45 */         roleToPos.put(roleid, mapRole.getPositionWithExtraInfo());
/*    */       }
/*    */     }
/* 48 */     this.result = roleToPos;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected MapMsgHandlerDone<MMH_GetRolesPosition> getMapMsgHandlerDone()
/*    */   {
/* 55 */     if (this.callback == null)
/*    */     {
/* 57 */       return null;
/*    */     }
/*    */     
/* 60 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 66 */     return this.callback.isCallInProcedure();
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onMapMsgHandlerDone(MMH_GetRolesPosition mmh)
/*    */     throws Exception
/*    */   {
/* 73 */     return this.callback.onResult(mmh.getResult());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetRolesPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */