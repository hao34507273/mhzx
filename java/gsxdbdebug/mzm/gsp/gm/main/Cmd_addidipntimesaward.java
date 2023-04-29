/*     */ package mzm.gsp.gm.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.idip.main.PGM_AddIdipNTimesAwardBuff;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Cmd_addidipntimesaward
/*     */   extends CmdBase
/*     */ {
/*     */   private int awardChannel;
/*     */   private int awardType;
/*     */   private int isInstall;
/*     */   private int roleId;
/*     */   private int nTimes;
/*     */   private long startTime;
/*     */   private long expireTime;
/*     */   
/*     */   protected boolean parse()
/*     */   {
/*  25 */     if (this.m_arguments == null) {
/*  26 */       return false;
/*     */     }
/*  28 */     int index = 0;
/*     */     
/*  30 */     if (index >= this.m_arguments.size()) {
/*  31 */       return false;
/*     */     }
/*  33 */     Integer I_awardChannel = parseInt((String)this.m_arguments.get(index++));
/*  34 */     if (I_awardChannel == null) {
/*  35 */       return false;
/*     */     }
/*  37 */     this.awardChannel = I_awardChannel.intValue();
/*     */     
/*  39 */     if (index >= this.m_arguments.size()) {
/*  40 */       return false;
/*     */     }
/*  42 */     Integer I_awardType = parseInt((String)this.m_arguments.get(index++));
/*  43 */     if (I_awardType == null) {
/*  44 */       return false;
/*     */     }
/*  46 */     this.awardType = I_awardType.intValue();
/*     */     
/*  48 */     if (index >= this.m_arguments.size()) {
/*  49 */       return false;
/*     */     }
/*  51 */     Integer I_isInstall = parseInt((String)this.m_arguments.get(index++));
/*  52 */     if (I_isInstall == null) {
/*  53 */       return false;
/*     */     }
/*  55 */     this.isInstall = I_isInstall.intValue();
/*     */     
/*  57 */     if (index >= this.m_arguments.size()) {
/*  58 */       return false;
/*     */     }
/*  60 */     Integer I_roleId = parseInt((String)this.m_arguments.get(index++));
/*  61 */     if (I_roleId == null) {
/*  62 */       return false;
/*     */     }
/*  64 */     this.roleId = I_roleId.intValue();
/*     */     
/*  66 */     if (index >= this.m_arguments.size()) {
/*  67 */       return false;
/*     */     }
/*  69 */     Integer I_nTimes = parseInt((String)this.m_arguments.get(index++));
/*  70 */     if (I_nTimes == null) {
/*  71 */       return false;
/*     */     }
/*  73 */     this.nTimes = I_nTimes.intValue();
/*     */     
/*  75 */     if (index >= this.m_arguments.size()) {
/*  76 */       return false;
/*     */     }
/*  78 */     Long L_startTime = parseLong((String)this.m_arguments.get(index++));
/*  79 */     if (L_startTime == null)
/*  80 */       return false;
/*  81 */     this.startTime = L_startTime.longValue();
/*     */     
/*  83 */     if (index >= this.m_arguments.size()) {
/*  84 */       return false;
/*     */     }
/*  86 */     Long L_expireTime = parseLong((String)this.m_arguments.get(index++));
/*  87 */     if (L_expireTime == null)
/*  88 */       return false;
/*  89 */     this.expireTime = L_expireTime.longValue();
/*     */     
/*  91 */     if (index != this.m_arguments.size()) {
/*  92 */       return false;
/*     */     }
/*  94 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean fillData()
/*     */   {
/* 103 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void run()
/*     */   {
/* 110 */     new PGM_AddIdipNTimesAwardBuff(this.awardChannel, this.awardType, this.isInstall, this.roleId, this.nTimes, this.startTime, this.expireTime).execute();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_addidipntimesaward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */