/*    */ package mzm.gsp.idip.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class UnbanPlay extends mzm.event.BasicEvent<UnbanPlayArg>
/*    */ {
/*  7 */   private static EventManager<UnbanPlayArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<UnbanPlayArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\event\UnbanPlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */