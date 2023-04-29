/*    */ package mzm.gsp.map.main.message;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.main.WorldInstance;
/*    */ import mzm.gsp.map.main.WorldManager;
/*    */ 
/*    */ 
/*    */ public class MMH_GetSingleRoleAndTeamInWorld
/*    */   extends AbstractMapMsgHandler
/*    */ {
/*    */   private final long worldId;
/* 13 */   private List<List<Long>> result = Collections.emptyList();
/*    */   
/*    */   public MMH_GetSingleRoleAndTeamInWorld(long worldId)
/*    */   {
/* 17 */     this.worldId = worldId;
/*    */   }
/*    */   
/*    */   public List<List<Long>> getSingleRoleAndTeamWorld()
/*    */   {
/* 22 */     return this.result;
/*    */   }
/*    */   
/*    */ 
/*    */   public void doProcess()
/*    */   {
/* 28 */     WorldInstance instance = WorldManager.getInstance().getWorldInstance(this.worldId);
/* 29 */     if (instance == null)
/*    */     {
/* 31 */       return;
/*    */     }
/* 33 */     this.result = instance.getAllTeamMemberList();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\message\MMH_GetSingleRoleAndTeamInWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */