/*    */ package mzm.gsp.watchmoon.main;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*    */ import mzm.gsp.map.main.scene.zone.type.event.IZoneListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WatchmoonZoneListener
/*    */   implements IZoneListener
/*    */ {
/*    */   public void onEnterRole(long roleId, ZoneForm zoneForm)
/*    */   {
/* 14 */     new PStartWatchMoonReq(roleId).execute();
/*    */   }
/*    */   
/*    */   public void onLeaveRole(long roleId, ZoneForm zoneForm) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\main\WatchmoonZoneListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */