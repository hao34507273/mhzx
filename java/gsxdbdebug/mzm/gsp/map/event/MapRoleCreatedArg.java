/*    */ package mzm.gsp.map.event;
/*    */ 
/*    */ public class MapRoleCreatedArg
/*    */ {
/*    */   public final long roleid;
/*    */   public final long worldid;
/*    */   public final int mapid;
/*    */   
/*    */   public MapRoleCreatedArg(long roleid, long worldid, int mapid) {
/* 10 */     this.roleid = roleid;
/* 11 */     this.worldid = worldid;
/* 12 */     this.mapid = mapid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\event\MapRoleCreatedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */