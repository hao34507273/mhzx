/*    */ package mzm.event;
/*    */ 
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public abstract class EventRunnable<Args> extends LogicRunnable implements EventListener<Args> {
/*    */   protected Args arg;
/*    */   
/*  8 */   public void setArg(Args arg) { this.arg = arg; }
/*    */   
/*    */   public Object clone()
/*    */     throws CloneNotSupportedException
/*    */   {
/* 13 */     return super.clone();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\EventRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */