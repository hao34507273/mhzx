/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.corps.event.CorpsCaptainChangeEventArg;
/*    */ import mzm.gsp.corps.event.CorpsCaptainChangeProcedure;
/*    */ 
/*    */ public class POnCorpsCaptainChange
/*    */   extends CorpsCaptainChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     CorpsManager.HandCorpsAppellationNoneRealTime(((CorpsCaptainChangeEventArg)this.arg).getNewLeaderId(), HandCorpsAppellation.AppellationHandType.CHANGE_ARGS);
/* 12 */     CorpsManager.HandCorpsAppellationNoneRealTime(((CorpsCaptainChangeEventArg)this.arg).getOldLeaderId(), HandCorpsAppellation.AppellationHandType.CHANGE_ARGS);
/* 13 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnCorpsCaptainChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */