/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import hub.SingleCrossFieldRoleMatchInfo;
/*     */ 
/*     */ public class SingleCrossFieldRoamedRoleInfo {
/*     */   private final int physZoneid;
/*     */   private final String userid;
/*     */   private final long roleid;
/*     */   private final int season;
/*     */   private final int starNum;
/*     */   private final int level;
/*     */   private final int fightValue;
/*     */   private final long startTimestamp;
/*  14 */   private volatile boolean dataPrepared = false;
/*  15 */   private volatile boolean logined = false;
/*     */   
/*  17 */   private volatile String basicCache = null;
/*     */   
/*     */   public SingleCrossFieldRoamedRoleInfo(SingleCrossFieldRoleMatchInfo roleMatchInfo)
/*     */   {
/*  21 */     this(roleMatchInfo.phys_zoneid, roleMatchInfo.userid.getString("UTF-8"), roleMatchInfo.roleid, roleMatchInfo.season, roleMatchInfo.star_num, roleMatchInfo.level, roleMatchInfo.fight_value, roleMatchInfo.start_timestamp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SingleCrossFieldRoamedRoleInfo(int physZoneid, String userid, long roleid, int season, int starNum, int level, int fightValue, long startTimestamp)
/*     */   {
/*  28 */     this.physZoneid = physZoneid;
/*  29 */     this.userid = userid;
/*  30 */     this.roleid = roleid;
/*  31 */     this.season = season;
/*  32 */     this.starNum = starNum;
/*  33 */     this.level = level;
/*  34 */     this.fightValue = fightValue;
/*  35 */     this.startTimestamp = startTimestamp;
/*     */   }
/*     */   
/*     */   public int getPhysZoneid()
/*     */   {
/*  40 */     return this.physZoneid;
/*     */   }
/*     */   
/*     */   public String getUserid()
/*     */   {
/*  45 */     return this.userid;
/*     */   }
/*     */   
/*     */   public long getRoleid()
/*     */   {
/*  50 */     return this.roleid;
/*     */   }
/*     */   
/*     */   public int getSeason()
/*     */   {
/*  55 */     return this.season;
/*     */   }
/*     */   
/*     */   public int getStarNum()
/*     */   {
/*  60 */     return this.starNum;
/*     */   }
/*     */   
/*     */   public int getLevel()
/*     */   {
/*  65 */     return this.level;
/*     */   }
/*     */   
/*     */   public int getFightValue()
/*     */   {
/*  70 */     return this.fightValue;
/*     */   }
/*     */   
/*     */   public long getStartTimestamp()
/*     */   {
/*  75 */     return this.startTimestamp;
/*     */   }
/*     */   
/*     */   public boolean setDataPrepared()
/*     */   {
/*  80 */     if (this.dataPrepared)
/*     */     {
/*  82 */       return false;
/*     */     }
/*  84 */     this.dataPrepared = true;
/*  85 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isDataPrepared()
/*     */   {
/*  90 */     return this.dataPrepared;
/*     */   }
/*     */   
/*     */   public boolean setLogined()
/*     */   {
/*  95 */     if (this.logined)
/*     */     {
/*  97 */       return false;
/*     */     }
/*  99 */     this.logined = true;
/* 100 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isLogined()
/*     */   {
/* 105 */     return this.logined;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 111 */     if (this.basicCache != null)
/*     */     {
/* 113 */       return this.basicCache;
/*     */     }
/* 115 */     StringBuffer sb = new StringBuffer();
/* 116 */     sb.append('{');
/* 117 */     sb.append("phys_zoneid=").append(this.physZoneid).append(",");
/* 118 */     sb.append("userid=").append(this.userid).append(",");
/* 119 */     sb.append("roleid=").append(this.roleid).append(",");
/* 120 */     sb.append("season=").append(this.season).append(",");
/* 121 */     sb.append("star_num=").append(this.starNum).append(",");
/* 122 */     sb.append("level=").append(this.level).append(",");
/* 123 */     sb.append("fight_value=").append(this.fightValue).append(",");
/* 124 */     sb.append("start_timestamp=").append(this.startTimestamp).append(",");
/* 125 */     sb.append('}');
/* 126 */     this.basicCache = sb.toString();
/* 127 */     return this.basicCache;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\SingleCrossFieldRoamedRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */