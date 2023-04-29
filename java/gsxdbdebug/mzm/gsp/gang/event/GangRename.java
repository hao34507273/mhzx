/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GangRename extends mzm.event.BasicEvent<GangRenameArg>
/*    */ {
/*  7 */   private static EventManager<GangRenameArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GangRenameArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.title.main.POnGangRename());
/* 16 */     manager.register(new mzm.gsp.msdkprofile.main.POnGangRename());
/* 17 */     manager.register(new mzm.gsp.worship.main.POnGangRename());
/* 18 */     manager.register(new mzm.gsp.friendscircle.main.POnGangRename());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\GangRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */