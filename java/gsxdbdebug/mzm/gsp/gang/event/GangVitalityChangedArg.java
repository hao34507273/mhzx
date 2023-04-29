/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ 
/*    */ public class GangVitalityChangedArg
/*    */ {
/*    */   public final long gangid;
/*    */   
/*    */   public final int oldVitality;
/*    */   
/*    */   public final int newVitality;
/*    */   
/*    */ 
/*    */   public GangVitalityChangedArg(long gangid, int oldVitality, int newVitality)
/*    */   {
/* 15 */     this.gangid = gangid;
/* 16 */     this.oldVitality = oldVitality;
/* 17 */     this.newVitality = newVitality;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\GangVitalityChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */