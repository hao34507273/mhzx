/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import mzm.gsp.drawcarnival.event.ChestAwardEventArg;
/*    */ import mzm.gsp.drawcarnival.event.ChestAwardEventProcedure;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ 
/*    */ public class POnChestAward
/*    */   extends ChestAwardEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     ControllerInterface.triggerWorldControllerWithMaxSpawnNum(1L, ((ChestAwardEventArg)this.arg).controllerId, ((ChestAwardEventArg)this.arg).chestCount);
/*    */     
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\POnChestAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */