/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*    */ import mzm.gsp.npc.main.ConditionChecker;
/*    */ 
/*    */ public class HomeServiceChecker
/*    */   implements ConditionChecker
/*    */ {
/*    */   private final long roleid;
/*    */   private final long maidUuid;
/*    */   
/*    */   public HomeServiceChecker(long roleid, long maidUuid)
/*    */   {
/* 15 */     this.roleid = roleid;
/* 16 */     this.maidUuid = maidUuid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean check()
/*    */   {
/* 22 */     return MapInterface.isNearByMapEntity(this.roleid, MapEntityType.MGT_SERVANT, this.maidUuid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\HomeServiceChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */