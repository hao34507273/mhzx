/*    */ package mzm.gsp.firework.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity3.confbean.SFireworkCfg;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FireworkInfo;
/*    */ import xbean.FireworkRecord;
/*    */ import xtable.Globalfirework;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FireworkShowCountDownSession
/*    */   extends Session
/*    */ {
/*    */   public FireworkShowCountDownSession(long interval, int activityId)
/*    */   {
/* 22 */     super(interval, activityId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 28 */     new PrepareFirework((int)getOwerId()).execute();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private final class PrepareFirework
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final int activityId;
/*    */     
/*    */ 
/*    */ 
/*    */     public PrepareFirework(int activityId)
/*    */     {
/* 43 */       this.activityId = activityId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 49 */       FireworkManager.loggerInfo("show start!|activityId=%d", new Object[] { Integer.valueOf(this.activityId) });
/*    */       
/* 51 */       SFireworkCfg cfg = SFireworkCfg.get(this.activityId);
/* 52 */       if (cfg == null)
/*    */       {
/* 54 */         return false;
/*    */       }
/*    */       
/* 57 */       FireworkInfo xFireworkInfo = Globalfirework.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 58 */       if (xFireworkInfo == null)
/*    */       {
/* 60 */         return false;
/*    */       }
/* 62 */       FireworkRecord xFireworkRecord = (FireworkRecord)xFireworkInfo.getActivityid2record().get(Integer.valueOf(this.activityId));
/* 63 */       if (xFireworkRecord == null)
/*    */       {
/* 65 */         return false;
/*    */       }
/* 67 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 68 */       xFireworkRecord.setFireworkstarttime(curTime);
/*    */       
/* 70 */       OnlineManager.getInstance().sendAll(FireworkManager.getSynStageProtocol(this.activityId, 3, curTime));
/*    */       
/*    */ 
/* 73 */       new FireworkAwardObserver(cfg.awardInterval, this.activityId, curTime);
/* 74 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\FireworkShowCountDownSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */