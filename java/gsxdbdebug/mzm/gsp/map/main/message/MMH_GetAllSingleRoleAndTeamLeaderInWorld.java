/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ 
/*    */ 
/*    */ public class MMH_GetAllSingleRoleAndTeamLeaderInWorld
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long worldId;
/*    */   private final int mapCfgid;
/* 15 */   private List<Long> result = Collections.emptyList();
/*    */   
/*    */   public MMH_GetAllSingleRoleAndTeamLeaderInWorld(long worldId)
/*    */   {
/* 19 */     this(worldId, -1);
/*    */   }
/*    */   
/*    */   public MMH_GetAllSingleRoleAndTeamLeaderInWorld(long worldId, int mapCfgid)
/*    */   {
/* 24 */     this.worldId = worldId;
/* 25 */     this.mapCfgid = mapCfgid;
/*    */   }
/*    */   
/*    */   public List<Long> getAllSingleRoleAndTeamLeader()
/*    */   {
/* 30 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 36 */     WorldInstance instance = WorldManager.getInstance().getWorldInstance(this.worldId);
/* 37 */     if (instance == null)
/*    */     {
/* 39 */       return;
/*    */     }
/* 41 */     if (this.mapCfgid == -1)
/*    */     {
/* 43 */       this.result = instance.getAllSingleRoleAndTeamLeader();
/* 44 */       return;
/*    */     }
/*    */     
/* 47 */     Scene scene = instance.getSceneByCfgId(this.mapCfgid);
/* 48 */     if (scene == null)
/*    */     {
/* 50 */       return;
/*    */     }
/* 52 */     this.result = scene.getAllSingleRoleAndTeamLeader();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetAllSingleRoleAndTeamLeaderInWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */