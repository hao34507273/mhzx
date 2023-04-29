/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.npc.confbean.SNpc;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.pk.confbean.SPKConsts;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JailWorldManager
/*    */ {
/*    */   private final long worldId;
/*    */   private final List<Integer> mapCfgIds;
/*    */   
/*    */   private static class InstanceHolder
/*    */   {
/* 22 */     private static final JailWorldManager INSTANCE = new JailWorldManager(null);
/*    */   }
/*    */   
/*    */   private JailWorldManager()
/*    */   {
/* 27 */     this.mapCfgIds = Arrays.asList(new Integer[] { Integer.valueOf(SPKConsts.getInstance().PRISON_MAP_ID) });
/*    */     
/* 29 */     this.worldId = MapInterface.createWorld(this.mapCfgIds);
/*    */     
/* 31 */     TeamInterface.registerJoinTeam(this.worldId, new JailJoinTeamCheckHandler());
/*    */     
/* 33 */     ControllerInterface.triggerWorldController(this.worldId, NpcInterface.getNpc(SPKConsts.getInstance().RESCUE_NPC_ID).controllerId);
/*    */     
/*    */ 
/* 36 */     ControllerInterface.triggerWorldController(this.worldId, NpcInterface.getNpc(SPKConsts.getInstance().PRISON_BREAK_NPC_ID).controllerId);
/*    */   }
/*    */   
/*    */ 
/*    */   public static JailWorldManager getInstance()
/*    */   {
/* 42 */     return InstanceHolder.INSTANCE;
/*    */   }
/*    */   
/*    */   public long getWorldId()
/*    */   {
/* 47 */     return this.worldId;
/*    */   }
/*    */   
/*    */   public List<Integer> getMapCfgIds()
/*    */   {
/* 52 */     return this.mapCfgIds;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void destroyWorld()
/*    */   {
/* 59 */     ControllerInterface.collectWorldController(this.worldId, NpcInterface.getNpc(SPKConsts.getInstance().RESCUE_NPC_ID).controllerId);
/*    */     
/*    */ 
/* 62 */     ControllerInterface.collectWorldController(this.worldId, NpcInterface.getNpc(SPKConsts.getInstance().PRISON_BREAK_NPC_ID).controllerId);
/*    */     
/*    */ 
/*    */ 
/* 66 */     TeamInterface.unRegisterJoinTeam(this.worldId);
/*    */     
/*    */ 
/* 69 */     MapInterface.destroyWorld(this.worldId);
/*    */   }
/*    */   
/*    */   public boolean isJailMap(int mapCfgId)
/*    */   {
/* 74 */     return this.mapCfgIds.contains(Integer.valueOf(mapCfgId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\JailWorldManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */