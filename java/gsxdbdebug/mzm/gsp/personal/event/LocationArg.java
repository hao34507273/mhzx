/*    */ package mzm.gsp.personal.event;
/*    */ 
/*    */ import mzm.gsp.personal.Location;
/*    */ 
/*    */ public class LocationArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final Location oldLocation;
/*    */   public final Location newLocation;
/*    */   
/*    */   public LocationArg(long roleId, Location oldLocation, Location newLocation)
/*    */   {
/* 13 */     this.roleId = roleId;
/* 14 */     this.oldLocation = oldLocation;
/* 15 */     this.newLocation = newLocation;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\event\LocationArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */