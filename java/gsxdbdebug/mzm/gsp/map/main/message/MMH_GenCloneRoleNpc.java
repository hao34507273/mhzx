/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.scene.object.MapNPC;
/*    */ 
/*    */ public class MMH_GenCloneRoleNpc extends AbstractMapMsgHandler
/*    */ {
/*    */   private final int npcId;
/*    */   
/*    */   public MMH_GenCloneRoleNpc(int npcId)
/*    */   {
/* 12 */     this.npcId = npcId;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 18 */     MapNPC npc = MapObjectInstanceManager.getInstance().getNPCByCfgId(this.npcId);
/* 19 */     if (npc == null)
/*    */     {
/* 21 */       return;
/*    */     }
/* 23 */     npc.updateModel();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GenCloneRoleNpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */