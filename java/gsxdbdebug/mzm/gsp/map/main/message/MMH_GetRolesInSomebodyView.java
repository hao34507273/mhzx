/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_GetRolesInSomebodyView
/*    */   extends AbstractMapMsgHandler
/*    */   implements MapMsgHandlerDone<MMH_GetRolesInSomebodyView>
/*    */ {
/*    */   private final long roleid;
/*    */   private final MapCallback<Collection<Long>> callback;
/* 14 */   private Collection<Long> roleids = null;
/*    */   
/*    */   public MMH_GetRolesInSomebodyView(long roleid)
/*    */   {
/* 18 */     this(roleid, null);
/*    */   }
/*    */   
/*    */   public MMH_GetRolesInSomebodyView(long roleid, MapCallback<Collection<Long>> callback)
/*    */   {
/* 23 */     this.roleid = roleid;
/* 24 */     this.callback = callback;
/*    */   }
/*    */   
/*    */   public Collection<Long> getRoleids()
/*    */   {
/* 29 */     return this.roleids;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 35 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 36 */     if (role == null)
/*    */     {
/* 38 */       return;
/*    */     }
/*    */     
/* 41 */     this.roleids = role.getPlayersInMyView(false);
/*    */   }
/*    */   
/*    */ 
/*    */   protected MapMsgHandlerDone<MMH_GetRolesInSomebodyView> getMapMsgHandlerDone()
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
/*    */   public boolean onMapMsgHandlerDone(MMH_GetRolesInSomebodyView mmh)
/*    */     throws Exception
/*    */   {
/* 64 */     return this.callback.onResult(getRoleids());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetRolesInSomebodyView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */