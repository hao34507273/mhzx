/*     */ package mzm.gsp.chat.question;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.confbean.WorldQuestionConsts;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PSetNewQuestionNoticTime
/*     */   extends LogicProcedure
/*     */ {
/*     */   private WorldQuestion worldQuestion;
/*     */   
/*     */   public PSetNewQuestionNoticTime()
/*     */   {
/*  22 */     this.worldQuestion = WorldQuestion.getInstance();
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception {
/*  26 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  28 */       GameServer.logger().info(String.format("[worldquestion]PSetNewQuestionNoticTime.processImp@isRoamServer!", new Object[0]));
/*  29 */       return false;
/*     */     }
/*  31 */     long interval = getRanInterval(getNowMinute());
/*  32 */     if (interval <= 0L) {
/*  33 */       return false;
/*     */     }
/*     */     
/*  36 */     new PNoticeAllSession(interval);
/*  37 */     GameServer.logger().info("[worldquestion]" + interval + "秒后，文曲星下凡！");
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   private int getNowMinute() {
/*  42 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  43 */     Map<Integer, Integer> timeDetails = this.worldQuestion.getHMSOf(now);
/*  44 */     int nowMin = ((Integer)timeDetails.get(Integer.valueOf(12))).intValue();
/*  45 */     return nowMin;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private long getRanInterval(int nowMin)
/*     */   {
/*  53 */     int min = getMin(nowMin, getMaxTimeNum());
/*  54 */     if (min <= 0) {
/*  55 */       return -1L;
/*     */     }
/*  57 */     return min * 60 + getRanNum(min);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getRanNum(int min)
/*     */   {
/*  66 */     Random random = Xdb.random();
/*  67 */     int ran = random.nextInt(getSeed(getMaxTimeNum(), min));
/*  68 */     return ran;
/*     */   }
/*     */   
/*     */   private static int getSeed(int max, int min) {
/*  72 */     return (max - min) * 60;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getMin(int nowMin, int max)
/*     */   {
/*  82 */     int min = getMinTimeNum();
/*  83 */     int avg = min + (max - min) / 2;
/*  84 */     if (avg < nowMin) {
/*  85 */       return -1;
/*     */     }
/*  87 */     min = Math.max(nowMin, min);
/*  88 */     if (min >= max) {
/*  89 */       return -1;
/*     */     }
/*  91 */     return min;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMaxTimeNum()
/*     */   {
/* 100 */     return WorldQuestionConsts.getInstance().RAN_TIME_HIGH;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMinTimeNum()
/*     */   {
/* 108 */     return WorldQuestionConsts.getInstance().RAN_TIME_LOW;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\PSetNewQuestionNoticTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */