/*     */ package mzm.gsp.makeup.main;
/*     */ 
/*     */ import mzm.gsp.activity4.confbean.SMakeUpActivityCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.GlobalMakeUpInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PrepareSession
/*     */   extends Session
/*     */ {
/*     */   private final PrepareReason reason;
/*     */   
/*     */   public PrepareSession(long interval, int activityId, PrepareReason reason)
/*     */   {
/*  20 */     super(interval, activityId);
/*  21 */     this.reason = reason;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  27 */     new StartQuestion((int)super.getOwerId()).execute();
/*     */   }
/*     */   
/*     */   private class StartQuestion
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int activityId;
/*     */     
/*     */     public StartQuestion(int activityId)
/*     */     {
/*  37 */       this.activityId = activityId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  43 */       SMakeUpActivityCfg cfg = SMakeUpActivityCfg.get(this.activityId);
/*  44 */       if (cfg == null)
/*     */       {
/*  46 */         MakeUpManager.loggerError("StartQuestion.processImp@SMakeUpActivityCfg is null!|activityId=%d", new Object[] { Integer.valueOf(this.activityId) });
/*  47 */         return false;
/*     */       }
/*  49 */       GlobalMakeUpInfo xGlobalMakeUpInfo = MakeUpManager.getGlobalMakeupInfo(this.activityId);
/*  50 */       if (xGlobalMakeUpInfo == null)
/*     */       {
/*  52 */         return false;
/*     */       }
/*     */       
/*  55 */       xGlobalMakeUpInfo.setPreparesessionid(0L);
/*     */       
/*  57 */       sendQuestion(cfg);
/*  58 */       return true;
/*     */     }
/*     */     
/*     */     private void sendQuestion(SMakeUpActivityCfg cfg)
/*     */     {
/*  63 */       if (!OpenInterface.getOpenStatus(cfg.switchId))
/*     */       {
/*     */ 
/*  66 */         return;
/*     */       }
/*     */       
/*  69 */       MakeUpManager.loggerInfo("-- question start!|activityId=%d", new Object[] { Integer.valueOf(this.activityId) });
/*     */       
/*     */ 
/*  72 */       SendQuestionObserver ob = new SendQuestionObserver(cfg.turnTime, this.activityId);
/*  73 */       if (MakeUpObserverManager.getInstance().addObserver(this.activityId, ob))
/*     */       {
/*     */ 
/*  76 */         MakeUpManager.sendQuestion(this.activityId, PrepareSession.this.reason);
/*  77 */         return;
/*     */       }
/*     */       
/*  80 */       ob.stopTimer();
/*  81 */       MakeUpManager.loggerError("StartQuestion.sendQuestion@addObserver err!|activityId=%d", new Object[] { Integer.valueOf(this.activityId) });
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static enum PrepareReason
/*     */   {
/*  91 */     ACTIVITY_RECOVERY, 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  96 */     ACTIVITY_NORMAL, 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 101 */     ACTIVITY_PREPARE;
/*     */     
/*     */     private PrepareReason() {}
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\main\PrepareSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */