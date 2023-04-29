/*    */ package mzm.event;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public abstract class EventProcedure<Args> extends LogicProcedure implements EventListener<Args> { protected Args arg;
/*    */   
/*  7 */   public void setArg(Args arg) { this.arg = arg; }
/*    */   
/*    */   public Object clone()
/*    */     throws CloneNotSupportedException
/*    */   {
/* 12 */     return super.clone();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\EventProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */