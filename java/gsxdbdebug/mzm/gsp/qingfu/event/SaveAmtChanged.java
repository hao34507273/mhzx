/*    */ package mzm.gsp.qingfu.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class SaveAmtChanged extends mzm.event.BasicEvent<SaveAmtChangedArg>
/*    */ {
/*  7 */   private static EventManager<SaveAmtChangedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<SaveAmtChangedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.qingfu.main.ROnUserSaveAmtChanged());
/* 16 */     manager.register(new mzm.gsp.signaward.main.POnUserSaveAmtChanged());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnUserSaveAmtChanged());
/* 18 */     manager.register(new mzm.gsp.backgame.main.POnUserSaveAmtChanged());
/* 19 */     manager.register(new mzm.gsp.msdkprofile.main.POnUserSaveAmtChanged());
/* 20 */     manager.register(new mzm.gsp.msdkprofile.main.POnUserYuanbaoChanged());
/* 21 */     manager.register(new mzm.gsp.grc.main.ROnUserSaveAmtChanged());
/* 22 */     manager.register(new mzm.gsp.backgameactivity.main.POnUserSaveAmtChanged());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\event\SaveAmtChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */