/*    */ package mzm.gsp.firework.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FireworkInfo;
/*    */ import xbean.FireworkRecord;
/*    */ import xdb.Procedure;
/*    */ import xtable.Globalfirework;
/*    */ 
/*    */ public class CleanFireworkSession
/*    */   extends Session
/*    */ {
/*    */   public CleanFireworkSession(long interval, int activityId)
/*    */   {
/* 17 */     super(interval, activityId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 23 */     Procedure.execute(new CleanAllControllers((int)super.getOwerId(), getSessionId()));
/*    */   }
/*    */   
/*    */   private class CleanAllControllers extends LogicProcedure
/*    */   {
/*    */     private final int activityId;
/*    */     private final long sesssionId;
/*    */     
/*    */     public CleanAllControllers(int activityId, long sessionId)
/*    */     {
/* 33 */       this.activityId = activityId;
/* 34 */       this.sesssionId = sessionId;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 41 */       FireworkInfo xFireworkInfo = Globalfirework.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 42 */       if (xFireworkInfo == null)
/*    */       {
/* 44 */         return false;
/*    */       }
/* 46 */       FireworkRecord xFireworkRecord = (FireworkRecord)xFireworkInfo.getActivityid2record().get(Integer.valueOf(this.activityId));
/* 47 */       if (xFireworkRecord == null)
/*    */       {
/* 49 */         return false;
/*    */       }
/* 51 */       if (xFireworkRecord.getCleansessionid() != this.sesssionId)
/*    */       {
/*    */ 
/* 54 */         return false;
/*    */       }
/* 56 */       xFireworkRecord.setCleansessionid(0L);
/*    */       
/* 58 */       FireworkManager.startFirework(this.activityId, OperFireorkReason.TIG_TIME_OUT, xFireworkRecord);
/* 59 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\CleanFireworkSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */