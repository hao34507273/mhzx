/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import hub.RoleMatchMarkingInfo;
/*     */ 
/*     */ public class RoamedRoleMatchMarkingInfo implements MatchMarkingRanking {
/*     */   private final int physZoneid;
/*     */   private final String userid;
/*     */   private final long roleid;
/*     */   private final int ranking;
/*     */   private final int winNum;
/*     */   private final int loseNum;
/*     */   private final int displayRank;
/*     */   private final String roleName;
/*     */   private final int level;
/*     */   private final int gender;
/*     */   private final int occupation;
/*     */   private final int avatarid;
/*     */   private final int avatarFrameid;
/*  19 */   private volatile boolean dataPrepared = false;
/*  20 */   private volatile boolean logined = false;
/*  21 */   private volatile boolean teamRestore = false;
/*     */   
/*  23 */   private volatile String basicCache = null;
/*     */   
/*     */   public RoamedRoleMatchMarkingInfo(RoleMatchMarkingInfo roleMatchMarkingInfo)
/*     */   {
/*  27 */     this.physZoneid = roleMatchMarkingInfo.phys_zoneid;
/*  28 */     this.userid = roleMatchMarkingInfo.userid.getString("UTF-8");
/*  29 */     this.roleid = roleMatchMarkingInfo.roleid;
/*  30 */     this.ranking = roleMatchMarkingInfo.ranking;
/*  31 */     this.winNum = roleMatchMarkingInfo.win_num;
/*  32 */     this.loseNum = roleMatchMarkingInfo.lose_num;
/*  33 */     this.displayRank = roleMatchMarkingInfo.display_rank;
/*  34 */     this.roleName = roleMatchMarkingInfo.rolename.getString("UTF-8");
/*  35 */     this.level = roleMatchMarkingInfo.level;
/*  36 */     this.gender = roleMatchMarkingInfo.gender;
/*  37 */     this.occupation = roleMatchMarkingInfo.occupation;
/*  38 */     this.avatarid = roleMatchMarkingInfo.avatarid;
/*  39 */     this.avatarFrameid = roleMatchMarkingInfo.avatar_frameid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public RoamedRoleMatchMarkingInfo(int physZoneid, String userid, long roleid, int ranking, int winNum, int loseNum, int displayRank, String roleName, int level, int gender, int occupation, int avatarid, int avatarFrameid)
/*     */   {
/*  46 */     this.physZoneid = physZoneid;
/*  47 */     this.userid = userid;
/*  48 */     this.roleid = roleid;
/*  49 */     this.ranking = ranking;
/*  50 */     this.winNum = winNum;
/*  51 */     this.loseNum = loseNum;
/*  52 */     this.displayRank = displayRank;
/*  53 */     this.roleName = roleName;
/*  54 */     this.level = level;
/*  55 */     this.gender = gender;
/*  56 */     this.occupation = occupation;
/*  57 */     this.avatarid = avatarid;
/*  58 */     this.avatarFrameid = avatarFrameid;
/*     */   }
/*     */   
/*     */   public int getPhysZoneid()
/*     */   {
/*  63 */     return this.physZoneid;
/*     */   }
/*     */   
/*     */   public String getUserid()
/*     */   {
/*  68 */     return this.userid;
/*     */   }
/*     */   
/*     */   public long getRoleid()
/*     */   {
/*  73 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getRanking()
/*     */   {
/*  79 */     return this.ranking;
/*     */   }
/*     */   
/*     */   public int getWinNum()
/*     */   {
/*  84 */     return this.winNum;
/*     */   }
/*     */   
/*     */   public int getLoseNum()
/*     */   {
/*  89 */     return this.loseNum;
/*     */   }
/*     */   
/*     */   public int getDisplayRank()
/*     */   {
/*  94 */     return this.displayRank;
/*     */   }
/*     */   
/*     */   public String getRoleName()
/*     */   {
/*  99 */     return this.roleName;
/*     */   }
/*     */   
/*     */   public int getLevel()
/*     */   {
/* 104 */     return this.level;
/*     */   }
/*     */   
/*     */   public int getGender()
/*     */   {
/* 109 */     return this.gender;
/*     */   }
/*     */   
/*     */   public int getOccupation()
/*     */   {
/* 114 */     return this.occupation;
/*     */   }
/*     */   
/*     */   public int getAvatarid()
/*     */   {
/* 119 */     return this.avatarid;
/*     */   }
/*     */   
/*     */   public int getAvatarFrameid()
/*     */   {
/* 124 */     return this.avatarFrameid;
/*     */   }
/*     */   
/*     */   public boolean setDataPrepared()
/*     */   {
/* 129 */     if (this.dataPrepared)
/*     */     {
/* 131 */       return false;
/*     */     }
/* 133 */     this.dataPrepared = true;
/*     */     
/* 135 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isDataPrepared()
/*     */   {
/* 140 */     return this.dataPrepared;
/*     */   }
/*     */   
/*     */   public boolean setLogined()
/*     */   {
/* 145 */     if (this.logined)
/*     */     {
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     this.logined = true;
/*     */     
/* 152 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isLogined()
/*     */   {
/* 157 */     return this.logined;
/*     */   }
/*     */   
/*     */   public boolean setTeamRestore()
/*     */   {
/* 162 */     if (this.teamRestore)
/*     */     {
/* 164 */       return false;
/*     */     }
/*     */     
/* 167 */     this.teamRestore = true;
/*     */     
/* 169 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isTeamRestore()
/*     */   {
/* 174 */     return this.teamRestore;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 180 */     if (this.basicCache != null)
/*     */     {
/* 182 */       return this.basicCache;
/*     */     }
/*     */     
/* 185 */     StringBuffer sb = new StringBuffer();
/* 186 */     sb.append('{');
/* 187 */     sb.append("phys_zoneid=").append(this.physZoneid).append(",");
/* 188 */     sb.append("userid=").append(this.userid).append(",");
/* 189 */     sb.append("roleid=").append(this.roleid).append(",");
/* 190 */     sb.append("ranking=").append(this.ranking).append(",");
/* 191 */     sb.append("win_num=").append(this.winNum).append(",");
/* 192 */     sb.append("lose_num=").append(this.loseNum).append(",");
/* 193 */     sb.append("display_rank=").append(this.displayRank).append(",");
/* 194 */     sb.append("rolename=").append(this.roleName).append(",");
/* 195 */     sb.append("level=").append(this.level).append(",");
/* 196 */     sb.append("gender=").append(this.gender).append(",");
/* 197 */     sb.append("occupation=").append(this.occupation).append(",");
/* 198 */     sb.append("avatarid=").append(this.avatarid).append(",");
/* 199 */     sb.append("avatar_frameid=").append(this.avatarFrameid);
/* 200 */     sb.append('}');
/*     */     
/* 202 */     this.basicCache = sb.toString();
/*     */     
/* 204 */     return this.basicCache;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\RoamedRoleMatchMarkingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */