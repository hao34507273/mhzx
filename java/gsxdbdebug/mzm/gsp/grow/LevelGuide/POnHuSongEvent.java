/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import mzm.gsp.husong.event.HuSongArg;
/*    */ import mzm.gsp.husong.event.HuSongEventProcedure;
/*    */ import mzm.gsp.husong.main.HuSongInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnHuSongEvent
/*    */   extends HuSongEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     if (!((HuSongArg)this.arg).success)
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     int activityId = HuSongInterface.getHuSongActivityid();
/* 22 */     return LevelGuideManager.finishActivity(((HuSongArg)this.arg).roleid, activityId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnHuSongEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */