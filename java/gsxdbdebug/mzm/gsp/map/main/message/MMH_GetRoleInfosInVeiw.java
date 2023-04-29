/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ import mzm.gsp.map.main.scene.view.IView;
/*    */ 
/*    */ public class MMH_GetRoleInfosInVeiw
/*    */   extends AbstractMapMsgHandler implements MapMsgHandlerDone<MMH_GetRoleInfosInVeiw>
/*    */ {
/*    */   public final long roleid;
/*    */   private final MapCallback<List<Long>> callback;
/*    */   
/*    */   public MMH_GetRoleInfosInVeiw(long roleid, MapCallback<List<Long>> callback)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.callback = callback;
/*    */   }
/*    */   
/* 23 */   private List<Long> roleids = null;
/*    */   
/*    */   public List<Long> getRoleids()
/*    */   {
/* 27 */     return this.roleids;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 33 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 34 */     if (role == null)
/*    */     {
/* 36 */       return;
/*    */     }
/* 38 */     Collection<MapRole> players = role.getView().getPlayers();
/* 39 */     if (players == null)
/*    */     {
/* 41 */       return;
/*    */     }
/*    */     
/* 44 */     this.roleids = new LinkedList();
/* 45 */     for (MapRole player : players)
/*    */     {
/* 47 */       this.roleids.add(Long.valueOf(player.getRoleId()));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public MapMsgHandlerDone<MMH_GetRoleInfosInVeiw> getMapMsgHandlerDone()
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
/*    */   public boolean onMapMsgHandlerDone(MMH_GetRoleInfosInVeiw mmh)
/*    */     throws Exception
/*    */   {
/* 72 */     return this.callback.onResult(mmh.getRoleids());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetRoleInfosInVeiw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */