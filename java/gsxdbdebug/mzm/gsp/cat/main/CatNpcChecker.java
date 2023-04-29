/*    */ package mzm.gsp.cat.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*    */ import mzm.gsp.npc.main.ConditionChecker;
/*    */ 
/*    */ public class CatNpcChecker implements ConditionChecker
/*    */ {
/*    */   private final long roleid;
/*    */   private final long catid;
/*    */   
/*    */   public CatNpcChecker(long roleid, long catid)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.catid = catid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean check()
/*    */   {
/* 21 */     return MapInterface.isNearByMapEntity(this.roleid, MapEntityType.MGT_EXPLORE_CAT, this.catid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\CatNpcChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */