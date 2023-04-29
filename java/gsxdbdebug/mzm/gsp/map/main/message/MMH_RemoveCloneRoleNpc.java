/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import mzm.gsp.map.main.MapObjectInstanceManager;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ import mzm.gsp.map.main.scene.object.MapNPC;
/*    */ 
/*    */ public class MMH_RemoveCloneRoleNpc extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long worldid;
/*    */   private final int npcCfgid;
/*    */   
/*    */   public MMH_RemoveCloneRoleNpc(int npcCfgid)
/*    */   {
/* 15 */     this(1L, npcCfgid);
/*    */   }
/*    */   
/*    */   public MMH_RemoveCloneRoleNpc(long worldid, int npcCfgid)
/*    */   {
/* 20 */     this.worldid = worldid;
/* 21 */     this.npcCfgid = npcCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 27 */     if (this.worldid == 1L)
/*    */     {
/* 29 */       MapNPC npc = MapObjectInstanceManager.getInstance().getNPCByCfgId(this.npcCfgid);
/* 30 */       if (npc == null)
/*    */       {
/* 32 */         return;
/*    */       }
/*    */       
/* 35 */       npc.updateModel(null);
/*    */       
/* 37 */       return;
/*    */     }
/*    */     
/* 40 */     WorldInstance worldInstance = WorldManager.getInstance().getWorldInstance(this.worldid);
/* 41 */     if (worldInstance == null)
/*    */     {
/* 43 */       return;
/*    */     }
/* 45 */     worldInstance.removeCloneRoleNpcModelData(this.npcCfgid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_RemoveCloneRoleNpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */