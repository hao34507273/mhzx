/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*    */ import mzm.gsp.npc.main.ConditionChecker;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGoalNPCConditionChecker
/*    */   implements ConditionChecker
/*    */ {
/*    */   private final long roleid;
/*    */   private final long entityInstanceid;
/*    */   
/*    */   public WorldGoalNPCConditionChecker(long roleid, long entityInstanceid)
/*    */   {
/* 20 */     this.roleid = roleid;
/* 21 */     this.entityInstanceid = entityInstanceid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean check()
/*    */   {
/* 27 */     return MapInterface.isNearByMapEntity(this.roleid, MapEntityType.MGT_WORLD_GOAL_INFO, this.entityInstanceid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\WorldGoalNPCConditionChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */