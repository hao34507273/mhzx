/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.NewerChannel;
/*    */ 
/*    */ public class MergeNewerTimer extends Observer
/*    */ {
/*    */   public MergeNewerTimer(long intervalSeconds)
/*    */   {
/* 11 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 16 */     xdb.Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 21 */         java.util.List<NewerChannel> newerChannels = NewerManager.getNewerChannels();
/* 22 */         NewerManager.mergeNewer(newerChannels);
/* 23 */         return true;
/*    */       }
/* 25 */     });
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\MergeNewerTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */