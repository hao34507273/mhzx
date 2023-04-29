/*    */ package mzm.gsp.paraselene.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JigsawFinish extends mzm.event.BasicEvent<JigsawFinishArg>
/*    */ {
/*  7 */   private static EventManager<JigsawFinishArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JigsawFinishArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.paraselene.main.POnJigsawFinished());
/* 16 */     manager.register(new mzm.gsp.coupledaily.main.POnJigsawFinished());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\event\JigsawFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */