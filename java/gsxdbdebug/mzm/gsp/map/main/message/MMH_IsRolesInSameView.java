/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ import mzm.gsp.map.main.scene.view.IView;
/*    */ 
/*    */ public class MMH_IsRolesInSameView extends AbstractMapMsgHandler
/*    */ {
/*    */   private final Collection<Long> roles;
/* 14 */   private boolean result = false;
/*    */   
/*    */   public MMH_IsRolesInSameView(Collection<Long> roles)
/*    */   {
/* 18 */     this.roles = roles;
/*    */   }
/*    */   
/*    */   public final boolean getResult()
/*    */   {
/* 23 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 29 */     List<MapRole> mapRoles = new ArrayList(this.roles.size());
/* 30 */     for (Long roleid : this.roles)
/*    */     {
/* 32 */       MapRole mapRole = MapObjectInstanceManager.getInstance().getMapRole(roleid.longValue());
/* 33 */       if (mapRole == null)
/*    */       {
/* 35 */         return;
/*    */       }
/*    */       
/* 38 */       mapRoles.add(mapRole);
/*    */     }
/*    */     
/* 41 */     int size = mapRoles.size();
/* 42 */     for (int i = 0; i < size; i++)
/*    */     {
/* 44 */       MapRole mapRole1 = (MapRole)mapRoles.get(i);
/* 45 */       for (int j = i + 1; j < size; j++)
/*    */       {
/* 47 */         MapRole mapRole2 = (MapRole)mapRoles.get(j);
/* 48 */         if (mapRole1.getPositionForInner().getSceneId() != mapRole2.getPositionForInner().getSceneId())
/*    */         {
/* 50 */           return;
/*    */         }
/* 52 */         if (mapRole1.getChannelid() != mapRole2.getChannelid())
/*    */         {
/* 54 */           return;
/*    */         }
/* 56 */         if (!mapRole1.getView().getPlayers().contains(mapRole2))
/*    */         {
/* 58 */           return;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 63 */     this.result = true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_IsRolesInSameView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */