/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ 
/*    */ 
/*    */ public class MMH_AddCloneRoleNpc
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long worldid;
/*    */   private final int npcCfgid;
/*    */   private final Octets npcModelData;
/*    */   
/*    */   public MMH_AddCloneRoleNpc(long worldid, int npcCfgid, Octets npcModelData)
/*    */   {
/* 17 */     this.worldid = worldid;
/* 18 */     this.npcCfgid = npcCfgid;
/* 19 */     this.npcModelData = npcModelData;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 25 */     WorldInstance worldInstance = WorldManager.getInstance().getWorldInstance(this.worldid);
/* 26 */     if (worldInstance == null)
/*    */     {
/* 28 */       return;
/*    */     }
/*    */     
/* 31 */     worldInstance.addCloneRoleNpcModelData(this.npcCfgid, this.npcModelData);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_AddCloneRoleNpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */