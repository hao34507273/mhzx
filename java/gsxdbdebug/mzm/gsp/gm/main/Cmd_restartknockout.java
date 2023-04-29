/*     */ package mzm.gsp.gm.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.crossbattle.knockout.PGM_RestartKnockOut;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Cmd_restartknockout
/*     */   extends CmdBase
/*     */ {
/*     */   private int activityCfgId;
/*     */   private int knockOutType;
/*     */   private int restartFightZone;
/*     */   private int restartFightIndexId;
/*     */   private String prepareWorldBeginTime;
/*     */   
/*     */   protected boolean parse()
/*     */   {
/*  26 */     if (this.m_arguments == null) {
/*  27 */       return false;
/*     */     }
/*  29 */     int index = 0;
/*     */     
/*  31 */     if (index >= this.m_arguments.size()) {
/*  32 */       return false;
/*     */     }
/*  34 */     Integer I_activityCfgId = parseInt((String)this.m_arguments.get(index++));
/*  35 */     if (I_activityCfgId == null) {
/*  36 */       return false;
/*     */     }
/*  38 */     this.activityCfgId = I_activityCfgId.intValue();
/*     */     
/*  40 */     if (index >= this.m_arguments.size()) {
/*  41 */       return false;
/*     */     }
/*  43 */     Integer I_knockOutType = parseInt((String)this.m_arguments.get(index++));
/*  44 */     if (I_knockOutType == null) {
/*  45 */       return false;
/*     */     }
/*  47 */     this.knockOutType = I_knockOutType.intValue();
/*     */     
/*  49 */     if (index >= this.m_arguments.size()) {
/*  50 */       return false;
/*     */     }
/*  52 */     Integer I_restartFightZone = parseInt((String)this.m_arguments.get(index++));
/*  53 */     if (I_restartFightZone == null) {
/*  54 */       return false;
/*     */     }
/*  56 */     this.restartFightZone = I_restartFightZone.intValue();
/*     */     
/*  58 */     if (index >= this.m_arguments.size()) {
/*  59 */       return false;
/*     */     }
/*  61 */     Integer I_restartFightIndexId = parseInt((String)this.m_arguments.get(index++));
/*  62 */     if (I_restartFightIndexId == null) {
/*  63 */       return false;
/*     */     }
/*  65 */     this.restartFightIndexId = I_restartFightIndexId.intValue();
/*     */     
/*  67 */     if (index >= this.m_arguments.size()) {
/*  68 */       return false;
/*     */     }
/*  70 */     this.prepareWorldBeginTime = ((String)this.m_arguments.get(index++));
/*  71 */     if (index != this.m_arguments.size()) {
/*  72 */       return false;
/*     */     }
/*  74 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean fillData()
/*     */   {
/*  83 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void run()
/*     */   {
/*  90 */     if (this.prepareWorldBeginTime.length() != 14)
/*     */     {
/*  92 */       GmManager.getInstance().sendResultToGM(this.m_gmRole.getRoleid(), "date format error(yyyymmddhhMMss).");
/*     */     }
/*     */     
/*  95 */     Calendar calendar = DateTimeUtils.getCalendar();
/*  96 */     calendar.set(1, Integer.valueOf(this.prepareWorldBeginTime.substring(0, 4)).intValue());
/*  97 */     calendar.set(2, Integer.valueOf(this.prepareWorldBeginTime.substring(4, 6)).intValue() - 1);
/*  98 */     calendar.set(5, Integer.valueOf(this.prepareWorldBeginTime.substring(6, 8)).intValue());
/*  99 */     calendar.set(11, Integer.valueOf(this.prepareWorldBeginTime.substring(8, 10)).intValue());
/* 100 */     calendar.set(12, Integer.valueOf(this.prepareWorldBeginTime.substring(10, 12)).intValue());
/* 101 */     calendar.set(13, Integer.valueOf(this.prepareWorldBeginTime.substring(12, 14)).intValue());
/* 102 */     calendar.set(14, 0);
/* 103 */     long timestamp = calendar.getTimeInMillis();
/*     */     
/* 105 */     new PGM_RestartKnockOut(this.m_gmRole.getRoleid(), this.activityCfgId, this.knockOutType, this.restartFightZone, this.restartFightIndexId, timestamp / 1000L).execute();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_restartknockout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */