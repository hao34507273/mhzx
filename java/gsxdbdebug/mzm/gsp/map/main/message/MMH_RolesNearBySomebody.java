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
/*    */ public class MMH_RolesNearBySomebody
/*    */   extends AbstractMapMsgHandler implements MapMsgHandlerDone<MMH_RolesNearBySomebody>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int thresholdDistance;
/*    */   private final MapCallback<List<Long>> callback;
/* 17 */   private List<Long> roleids = null;
/*    */   
/*    */   public MMH_RolesNearBySomebody(long roleid, int thresholdDistance, MapCallback<List<Long>> callback)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.thresholdDistance = thresholdDistance;
/* 23 */     this.callback = callback;
/*    */   }
/*    */   
/*    */   public List<Long> getRoleids()
/*    */   {
/* 28 */     return this.roleids;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 34 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 35 */     if (role == null)
/*    */     {
/* 37 */       return;
/*    */     }
/*    */     
/* 40 */     Collection<MapRole> players = role.getView().getPlayers();
/* 41 */     if (players == null)
/*    */     {
/* 43 */       return;
/*    */     }
/*    */     
/* 46 */     this.roleids = new LinkedList();
/* 47 */     for (MapRole player : players)
/*    */     {
/* 49 */       if (role.getDistance(player) <= this.thresholdDistance)
/*    */       {
/* 51 */         this.roleids.add(Long.valueOf(player.getRoleId()));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   protected MapMsgHandlerDone<MMH_RolesNearBySomebody> getMapMsgHandlerDone()
/*    */   {
/* 59 */     if (this.callback == null)
/*    */     {
/* 61 */       return null;
/*    */     }
/*    */     
/* 64 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isCallInProcedure()
/*    */   {
/* 70 */     return this.callback.isCallInProcedure();
/*    */   }
/*    */   
/*    */   public boolean onMapMsgHandlerDone(MMH_RolesNearBySomebody mmh)
/*    */     throws Exception
/*    */   {
/* 76 */     return this.callback.onResult(getRoleids());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_RolesNearBySomebody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */