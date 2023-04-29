/*    */ package mzm.gsp.chatgift.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangCombineArg;
/*    */ import mzm.gsp.gang.event.GangCombineRunnable;
/*    */ 
/*    */ 
/*    */ public class ROnGangCombine
/*    */   extends GangCombineRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 13 */     new POnGangCombine(((GangCombineArg)this.arg).viceGangid).call();
/* 14 */     new POnGangCombine(((GangCombineArg)this.arg).mainGangid).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\ROnGangCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */