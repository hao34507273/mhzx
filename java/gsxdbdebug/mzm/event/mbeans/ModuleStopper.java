/*    */ package mzm.event.mbeans;
/*    */ 
/*    */ public class ModuleStopper extends BasicMXBean implements ModuleStopperMXBean {
/*    */   ModuleStopperMXBean implementation;
/*    */   
/*    */   public void setImplementation(ModuleStopperMXBean impl) {
/*  7 */     this.implementation = impl;
/*    */   }
/*    */   
/*    */   public void cancel()
/*    */   {
/* 12 */     if (this.implementation != null) {
/* 13 */       this.implementation.cancel();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void run()
/*    */   {
/* 20 */     if (this.implementation != null) {
/* 21 */       this.implementation.run();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\mbeans\ModuleStopper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */