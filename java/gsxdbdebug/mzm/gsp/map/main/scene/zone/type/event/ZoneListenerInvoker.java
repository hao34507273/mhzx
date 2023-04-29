/*    */ package mzm.gsp.map.main.scene.zone.type.event;
/*    */ 
/*    */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*    */ 
/*    */ class ZoneListenerInvoker extends mzm.gsp.util.LogicRunnable
/*    */ {
/*    */   private final IZoneListener listener;
/*    */   private final ListenerCallbackType lct;
/*    */   private final long roleid;
/*    */   private final ZoneForm zoneForm;
/*    */   
/*    */   static enum ListenerCallbackType {
/* 13 */     ENTER_ROLE, 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 18 */     LEAVE_ROLE;
/*    */     
/*    */ 
/*    */ 
/*    */     private ListenerCallbackType() {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public ZoneListenerInvoker(IZoneListener listener, ListenerCallbackType lct, long roleid, ZoneForm zoneForm)
/*    */   {
/* 29 */     this.listener = listener;
/* 30 */     this.lct = lct;
/* 31 */     this.roleid = roleid;
/* 32 */     this.zoneForm = zoneForm;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 38 */     switch (this.lct)
/*    */     {
/*    */     case ENTER_ROLE: 
/* 41 */       this.listener.onEnterRole(this.roleid, this.zoneForm);
/* 42 */       break;
/*    */     
/*    */     case LEAVE_ROLE: 
/* 45 */       this.listener.onLeaveRole(this.roleid, this.zoneForm);
/* 46 */       break;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\zone\type\event\ZoneListenerInvoker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */