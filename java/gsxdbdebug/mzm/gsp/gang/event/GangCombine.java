/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GangCombine extends mzm.event.BasicEvent<GangCombineArg>
/*    */ {
/*  7 */   private static EventManager<GangCombineArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GangCombineArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.title.main.POnGangCombine());
/* 16 */     manager.register(new mzm.gsp.huanhun.main.POnGangCombine());
/* 17 */     manager.register(new mzm.gsp.chatgift.main.ROnGangCombine());
/* 18 */     manager.register(new mzm.gsp.worship.main.POnGangCombine());
/* 19 */     manager.register(new mzm.gsp.cake.main.POnGangCombine());
/* 20 */     manager.register(new mzm.gsp.chat.main.ROnGangCombineForChatContentBuffer());
/* 21 */     manager.register(new mzm.gsp.makeup.main.POnGangCombine());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\GangCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */