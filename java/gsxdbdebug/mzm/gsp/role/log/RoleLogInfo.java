/*     */ package mzm.gsp.role.log;
/*     */ 
/*     */ 
/*     */ public class RoleLogInfo
/*     */ {
/*     */   private final long roleId;
/*     */   private final String vGameIP;
/*     */   private final String userid;
/*     */   private final int maxValue;
/*     */   private final long logTime;
/*     */   private final int level;
/*     */   private final int curFV;
/*     */   private final int curMFV;
/*     */   private final long balance;
/*     */   private final int rankType;
/*     */   private final int rankIndex;
/*     */   
/*     */   public RoleLogInfo(long roleId, String vGameIP, String userid, int maxValue, long logTime, int level, int curFV, int curMFV, long balance, int rankType, int rankIndex)
/*     */   {
/*  20 */     this.roleId = roleId;
/*  21 */     this.vGameIP = vGameIP;
/*  22 */     this.userid = userid;
/*  23 */     this.maxValue = maxValue;
/*  24 */     this.logTime = logTime;
/*  25 */     this.level = level;
/*  26 */     this.curFV = curFV;
/*  27 */     this.curMFV = curMFV;
/*  28 */     this.balance = balance;
/*  29 */     this.rankType = rankType;
/*  30 */     this.rankIndex = rankIndex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getRoleLogInfo()
/*     */   {
/*  40 */     StringBuffer sb = new StringBuffer();
/*  41 */     sb.append("{");
/*  42 */     sb.append("logTime=").append(this.logTime);
/*  43 */     sb.append("|vGameIP=").append(this.vGameIP);
/*  44 */     sb.append("|userid=").append(this.userid);
/*  45 */     sb.append("|roleId=").append(this.roleId);
/*  46 */     sb.append("|rank_type=").append(this.rankType);
/*  47 */     sb.append("|max_value=").append(this.maxValue);
/*  48 */     sb.append("|rank_index=").append(this.rankIndex);
/*  49 */     sb.append("|level=").append(this.level);
/*  50 */     sb.append("|current_fight_value=").append(this.curFV);
/*  51 */     sb.append("|current_multi_fight_value=").append(this.curMFV);
/*  52 */     sb.append("|balance=").append(this.balance);
/*  53 */     sb.append("}");
/*  54 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public long getRoleId()
/*     */   {
/*  59 */     return this.roleId;
/*     */   }
/*     */   
/*     */   public String getvGameIP()
/*     */   {
/*  64 */     return this.vGameIP;
/*     */   }
/*     */   
/*     */   public String getUserid()
/*     */   {
/*  69 */     return this.userid;
/*     */   }
/*     */   
/*     */   public int getMaxValue()
/*     */   {
/*  74 */     return this.maxValue;
/*     */   }
/*     */   
/*     */   public long getLogTime()
/*     */   {
/*  79 */     return this.logTime;
/*     */   }
/*     */   
/*     */   public int getLevel()
/*     */   {
/*  84 */     return this.level;
/*     */   }
/*     */   
/*     */   public int getCurFV()
/*     */   {
/*  89 */     return this.curFV;
/*     */   }
/*     */   
/*     */   public int getCurMFV()
/*     */   {
/*  94 */     return this.curMFV;
/*     */   }
/*     */   
/*     */   public long getBalance()
/*     */   {
/*  99 */     return this.balance;
/*     */   }
/*     */   
/*     */   public int getRankType()
/*     */   {
/* 104 */     return this.rankType;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\log\RoleLogInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */