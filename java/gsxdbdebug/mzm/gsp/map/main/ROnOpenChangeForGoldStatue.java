/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ 
/*    */ public class ROnOpenChangeForGoldStatue extends mzm.gsp.open.event.OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception {
/*  8 */     if (((OpenChangeComplexArg)this.arg).getType() != 443)
/*    */     {
/* 10 */       return;
/*    */     }
/*    */     
/* 13 */     GoldStatueManager.getInstance().onOpenChanged(((OpenChangeComplexArg)this.arg).isOpen());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ROnOpenChangeForGoldStatue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */