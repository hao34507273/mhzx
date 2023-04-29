/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ import mzm.gsp.map.main.scene.Scene;
/*    */ 
/*    */ 
/*    */ public class MMH_GetAllTeamInWorld
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long worldId;
/*    */   private final int mapCfgid;
/* 15 */   private List<Long> result = Collections.emptyList();
/*    */   
/*    */   public MMH_GetAllTeamInWorld(long worldId)
/*    */   {
/* 19 */     this(worldId, -1);
/*    */   }
/*    */   
/*    */   public MMH_GetAllTeamInWorld(long worldId, int mapCfgid)
/*    */   {
/* 24 */     this.worldId = worldId;
/* 25 */     this.mapCfgid = mapCfgid;
/*    */   }
/*    */   
/*    */   public List<Long> getAllTeamIdList()
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
/*    */     
/* 42 */     if (this.mapCfgid == -1)
/*    */     {
/* 44 */       this.result = instance.getAllTeamIdList();
/* 45 */       return;
/*    */     }
/*    */     
/* 48 */     Scene scene = instance.getSceneByCfgId(this.mapCfgid);
/* 49 */     if (scene == null)
/*    */     {
/* 51 */       return;
/*    */     }
/* 53 */     this.result = scene.getAllTeamIdList();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetAllTeamInWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */