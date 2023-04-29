/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapNPC;
/*    */ import mzm.gsp.map.main.scene.object.MapRole;
/*    */ 
/*    */ public class MMH_GMOpNpcView extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long roleid;
/*    */   private final int npcCfgid;
/*    */   private final boolean enterView;
/*    */   
/*    */   public MMH_GMOpNpcView(long roleid, int npcCfgid, boolean enterView)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.npcCfgid = npcCfgid;
/* 17 */     this.enterView = enterView;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 23 */     MapRole role = MapObjectInstanceManager.getInstance().getMapRole(this.roleid);
/* 24 */     if (role == null)
/*    */     {
/* 26 */       return;
/*    */     }
/*    */     
/* 29 */     MapNPC npc = MapObjectInstanceManager.getInstance().getNPCByCfgId(this.npcCfgid);
/* 30 */     if (npc == null)
/*    */     {
/* 32 */       return;
/*    */     }
/*    */     
/* 35 */     role.sendMapProtocol(this.enterView ? npc.createEnterView() : npc.createLeaveView());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GMOpNpcView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */