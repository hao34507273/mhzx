/*    */ package mzm.gsp.map.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ArraivedAtNPC extends mzm.event.BasicEvent<ArraivedAtNPCArg>
/*    */ {
/*  7 */   private static EventManager<ArraivedAtNPCArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ArraivedAtNPCArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.husong.main.POnArraivedAtNPC());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\event\ArraivedAtNPC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */