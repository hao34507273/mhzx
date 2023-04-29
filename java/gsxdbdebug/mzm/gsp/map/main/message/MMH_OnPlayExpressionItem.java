/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.SNotifyExpressionPlayByUseItem;
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.Grid;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ import mzm.gsp.map.main.scene.SceneManager;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_OnPlayExpressionItem
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final int itemCfgid;
/*    */   
/*    */   public MMH_OnPlayExpressionItem(long roleid, int itemCfgid)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.itemCfgid = itemCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 28 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 29 */     if (role == null)
/*    */     {
/* 31 */       return;
/*    */     }
/*    */     
/* 34 */     Position pos = role.getPositionForInner();
/* 35 */     Scene scene = SceneManager.getInstance().getScene(pos.getSceneId());
/* 36 */     if (scene == null)
/*    */     {
/* 38 */       return;
/*    */     }
/*    */     
/* 41 */     List<Grid> grids = scene.getGrids(pos, 8);
/* 42 */     if (grids == null)
/*    */     {
/* 44 */       return;
/*    */     }
/*    */     
/* 47 */     SNotifyExpressionPlayByUseItem notify = new SNotifyExpressionPlayByUseItem();
/* 48 */     notify.roleid = this.roleid;
/* 49 */     notify.rolename = role.getName();
/* 50 */     notify.x = pos.getX();
/* 51 */     notify.y = pos.getY();
/* 52 */     notify.item_cfgid = this.itemCfgid;
/* 53 */     for (Grid grid : grids)
/*    */     {
/* 55 */       Collection<Long> roleids = role.isServerDominateGroup() ? grid.getRoleIds() : grid.getRoleIds(role.getChannelid());
/*    */       
/* 57 */       if (roleids != null)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 62 */         MapProtocolSendQueue.getInstance().sendMulti(roleids, notify);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_OnPlayExpressionItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */