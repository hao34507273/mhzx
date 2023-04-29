/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.GangVitalityChangedArg;
/*    */ import mzm.gsp.gang.event.GangVitalityChangedRunnable;
/*    */ 
/*    */ public class ROnGangVitalityChanged
/*    */   extends GangVitalityChangedRunnable
/*    */ {
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 12 */     new PCheckCancelSignUpByVitality(((GangVitalityChangedArg)this.arg).gangid, ((GangVitalityChangedArg)this.arg).newVitality).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\ROnGangVitalityChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */