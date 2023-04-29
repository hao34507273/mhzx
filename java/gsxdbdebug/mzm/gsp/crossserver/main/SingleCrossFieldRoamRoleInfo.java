/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import hub.SingleCrossFieldRoleMatchInfo;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SingleCrossFieldRoamRoleInfo
/*     */   implements RoamRoleInfo
/*     */ {
/*     */   private final int physZoneid;
/*     */   private final String userid;
/*     */   private final long roleid;
/*     */   private final int season;
/*     */   private final int starNum;
/*     */   private final int level;
/*     */   private final int fightValue;
/*     */   private final long startTimestamp;
/*  25 */   private volatile byte process = 0;
/*  26 */   private volatile Octets token = null;
/*  27 */   private volatile boolean roamed = false;
/*  28 */   private volatile String basicCache = null;
/*     */   
/*     */ 
/*     */   public SingleCrossFieldRoamRoleInfo(int physZoneid, String userid, long roleid, int season, int starNum, int level, int fightValue)
/*     */   {
/*  33 */     this.physZoneid = physZoneid;
/*  34 */     this.userid = userid;
/*  35 */     this.roleid = roleid;
/*  36 */     this.season = season;
/*  37 */     this.starNum = starNum;
/*  38 */     this.level = level;
/*  39 */     this.fightValue = fightValue;
/*  40 */     this.startTimestamp = DateTimeUtils.getCurrTimeInMillis();
/*     */   }
/*     */   
/*     */ 
/*     */   public SingleCrossFieldRoamRoleInfo(String userid, long roleid, int season, int starNum, int level, int fightValue)
/*     */   {
/*  46 */     this(GameServerInfoManager.getZoneId(), userid, roleid, season, starNum, level, fightValue);
/*     */   }
/*     */   
/*     */   public SingleCrossFieldRoamRoleInfo(SingleCrossFieldRoleMatchInfo roleMatchInfo)
/*     */   {
/*  51 */     this(roleMatchInfo.phys_zoneid, roleMatchInfo.userid.getString("UTF-8"), roleMatchInfo.roleid, roleMatchInfo.season, roleMatchInfo.star_num, roleMatchInfo.level, roleMatchInfo.fight_value);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getPhysZoneid()
/*     */   {
/*  57 */     return this.physZoneid;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getUserid()
/*     */   {
/*  63 */     return this.userid;
/*     */   }
/*     */   
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/*  69 */     return this.roleid;
/*     */   }
/*     */   
/*     */   public int getSeason()
/*     */   {
/*  74 */     return this.season;
/*     */   }
/*     */   
/*     */   public int getStarNum()
/*     */   {
/*  79 */     return this.starNum;
/*     */   }
/*     */   
/*     */   public int getLevel()
/*     */   {
/*  84 */     return this.level;
/*     */   }
/*     */   
/*     */   public int getFightValue()
/*     */   {
/*  89 */     return this.fightValue;
/*     */   }
/*     */   
/*     */   public boolean setProcess(byte process)
/*     */   {
/*  94 */     this.process = process;
/*  95 */     return true;
/*     */   }
/*     */   
/*     */   public byte getProcess()
/*     */   {
/* 100 */     return this.process;
/*     */   }
/*     */   
/*     */   public boolean setToken(Octets token)
/*     */   {
/* 105 */     if ((token == null) || (token.equals(this.token)))
/*     */     {
/* 107 */       return false;
/*     */     }
/* 109 */     this.token = token;
/* 110 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public Octets getToken()
/*     */   {
/* 116 */     return this.token;
/*     */   }
/*     */   
/*     */   public boolean setRoamed()
/*     */   {
/* 121 */     if (this.roamed)
/*     */     {
/* 123 */       return false;
/*     */     }
/* 125 */     this.roamed = true;
/* 126 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isRoam()
/*     */   {
/* 131 */     return this.roamed;
/*     */   }
/*     */   
/*     */   public SingleCrossFieldRoleMatchInfo getHubSingleCrossFieldRoleMatchInfo()
/*     */   {
/*     */     try
/*     */     {
/* 138 */       SingleCrossFieldRoleMatchInfo roleMatchInfo = new SingleCrossFieldRoleMatchInfo();
/* 139 */       roleMatchInfo.phys_zoneid = this.physZoneid;
/* 140 */       roleMatchInfo.userid.setString(this.userid, "UTF-8");
/* 141 */       roleMatchInfo.roleid = this.roleid;
/* 142 */       roleMatchInfo.season = this.season;
/* 143 */       roleMatchInfo.star_num = this.starNum;
/* 144 */       roleMatchInfo.level = this.level;
/* 145 */       roleMatchInfo.fight_value = this.fightValue;
/* 146 */       roleMatchInfo.start_timestamp = this.startTimestamp;
/* 147 */       return roleMatchInfo;
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/* 152 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void fillHubSingleCrossFieldRoleMatchInfo(SingleCrossFieldRoleMatchInfo roleMatchInfo)
/*     */   {
/*     */     try
/*     */     {
/* 160 */       roleMatchInfo.phys_zoneid = this.physZoneid;
/* 161 */       roleMatchInfo.userid.setString(this.userid, "UTF-8");
/* 162 */       roleMatchInfo.roleid = this.roleid;
/* 163 */       roleMatchInfo.season = this.season;
/* 164 */       roleMatchInfo.star_num = this.starNum;
/* 165 */       roleMatchInfo.level = this.level;
/* 166 */       roleMatchInfo.fight_value = this.fightValue;
/* 167 */       roleMatchInfo.start_timestamp = this.startTimestamp;
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 178 */     if (this.basicCache != null)
/*     */     {
/* 180 */       return this.basicCache;
/*     */     }
/* 182 */     StringBuffer sb = new StringBuffer();
/* 183 */     sb.append('{');
/* 184 */     sb.append("phys_zoneid=").append(this.physZoneid).append(",");
/* 185 */     sb.append("userid=").append(this.userid).append(",");
/* 186 */     sb.append("roleid=").append(this.roleid).append(",");
/* 187 */     sb.append("season=").append(this.season).append(",");
/* 188 */     sb.append("star_num=").append(this.starNum).append(",");
/* 189 */     sb.append("level=").append(this.level).append(",");
/* 190 */     sb.append("fight_value=").append(this.fightValue).append(",");
/* 191 */     sb.append("start_timestamp=").append(this.startTimestamp).append(",");
/* 192 */     sb.append('}');
/* 193 */     this.basicCache = sb.toString();
/* 194 */     return this.basicCache;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\SingleCrossFieldRoamRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */