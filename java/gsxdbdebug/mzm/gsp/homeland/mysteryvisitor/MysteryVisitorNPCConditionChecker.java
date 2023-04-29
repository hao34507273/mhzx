/*    */ package mzm.gsp.homeland.mysteryvisitor;
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
/*    */ public class MysteryVisitorNPCConditionChecker
/*    */   implements ConditionChecker
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public MysteryVisitorNPCConditionChecker(long roleid)
/*    */   {
/* 19 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean check()
/*    */   {
/* 25 */     return MapInterface.isNearByMapEntity(this.roleid, MapEntityType.MET_MYSTERY_VISITOR, this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\mysteryvisitor\MysteryVisitorNPCConditionChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */