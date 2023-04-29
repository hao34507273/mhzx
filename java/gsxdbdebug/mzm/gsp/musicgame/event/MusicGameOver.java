/*    */ package mzm.gsp.musicgame.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class MusicGameOver extends mzm.event.BasicEvent<MusicGameOverArg>
/*    */ {
/*  7 */   private static EventManager<MusicGameOverArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<MusicGameOverArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.children.fetuseducationmusic.POnMusicGameOver());
/* 16 */     manager.register(new mzm.gsp.homeland.mysteryvisitor.POnMusicGameOver());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\musicgame\event\MusicGameOver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */