/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ 
/*     */ 
/*     */ public class RoleMatchMarkingInfo
/*     */   implements MatchMarkingRanking, RoamRoleInfo
/*     */ {
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
/*  23 */   private volatile Octets token = null;
/*  24 */   private volatile boolean roamed = false;
/*     */   
/*  26 */   private volatile String basicCache = null;
/*     */   
/*     */   public RoleMatchMarkingInfo(hub.RoleMatchMarkingInfo roleMatchMarkingInfo)
/*     */   {
/*  30 */     this.physZoneid = roleMatchMarkingInfo.phys_zoneid;
/*  31 */     this.userid = roleMatchMarkingInfo.userid.getString("UTF-8");
/*  32 */     this.roleid = roleMatchMarkingInfo.roleid;
/*  33 */     this.ranking = roleMatchMarkingInfo.ranking;
/*  34 */     this.winNum = roleMatchMarkingInfo.win_num;
/*  35 */     this.loseNum = roleMatchMarkingInfo.lose_num;
/*  36 */     this.displayRank = roleMatchMarkingInfo.display_rank;
/*  37 */     this.roleName = roleMatchMarkingInfo.rolename.getString("UTF-8");
/*  38 */     this.level = roleMatchMarkingInfo.level;
/*  39 */     this.gender = roleMatchMarkingInfo.gender;
/*  40 */     this.occupation = roleMatchMarkingInfo.occupation;
/*  41 */     this.avatarid = roleMatchMarkingInfo.avatarid;
/*  42 */     this.avatarFrameid = roleMatchMarkingInfo.avatar_frameid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public RoleMatchMarkingInfo(String userid, long roleid, int ranking, int winNum, int loseNum, int displayRank, String roleName, int level, int gender, int occupation, int avatarid, int avatarFrameid)
/*     */   {
/*  49 */     this(GameServerInfoManager.getZoneId(), userid, roleid, ranking, winNum, loseNum, displayRank, roleName, level, gender, occupation, avatarid, avatarFrameid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public RoleMatchMarkingInfo(int physZoneid, String userid, long roleid, int ranking, int winNum, int loseNum, int displayRank, String roleName, int level, int gender, int occupation, int avatarid, int avatarFrameid)
/*     */   {
/*  57 */     this.physZoneid = physZoneid;
/*  58 */     this.userid = userid;
/*  59 */     this.roleid = roleid;
/*  60 */     this.ranking = ranking;
/*  61 */     this.winNum = winNum;
/*  62 */     this.loseNum = loseNum;
/*  63 */     this.displayRank = displayRank;
/*  64 */     this.roleName = roleName;
/*  65 */     this.level = level;
/*  66 */     this.gender = gender;
/*  67 */     this.occupation = occupation;
/*  68 */     this.avatarid = avatarid;
/*  69 */     this.avatarFrameid = avatarFrameid;
/*     */   }
/*     */   
/*     */   public int getPhysZoneid()
/*     */   {
/*  74 */     return this.physZoneid;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getUserid()
/*     */   {
/*  80 */     return this.userid;
/*     */   }
/*     */   
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/*  86 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getRanking()
/*     */   {
/*  92 */     return this.ranking;
/*     */   }
/*     */   
/*     */   public int getWinNum()
/*     */   {
/*  97 */     return this.winNum;
/*     */   }
/*     */   
/*     */   public int getLoseNum()
/*     */   {
/* 102 */     return this.loseNum;
/*     */   }
/*     */   
/*     */   public int getDisplayRank()
/*     */   {
/* 107 */     return this.displayRank;
/*     */   }
/*     */   
/*     */   public String getRoleName()
/*     */   {
/* 112 */     return this.roleName;
/*     */   }
/*     */   
/*     */   public int getLevel()
/*     */   {
/* 117 */     return this.level;
/*     */   }
/*     */   
/*     */   public int getGender()
/*     */   {
/* 122 */     return this.gender;
/*     */   }
/*     */   
/*     */   public int getOccupation()
/*     */   {
/* 127 */     return this.occupation;
/*     */   }
/*     */   
/*     */   public int getAvatarid()
/*     */   {
/* 132 */     return this.avatarid;
/*     */   }
/*     */   
/*     */   public int getAvatarFrameid()
/*     */   {
/* 137 */     return this.avatarFrameid;
/*     */   }
/*     */   
/*     */ 
/*     */   public Octets getToken()
/*     */   {
/* 143 */     return this.token;
/*     */   }
/*     */   
/*     */   public boolean isRoam()
/*     */   {
/* 148 */     return this.roamed;
/*     */   }
/*     */   
/*     */   public boolean setToken(Octets token)
/*     */   {
/* 153 */     if ((token == null) || (token.equals(this.token)))
/*     */     {
/* 155 */       return false;
/*     */     }
/*     */     
/* 158 */     this.token = token;
/*     */     
/* 160 */     return true;
/*     */   }
/*     */   
/*     */   public boolean setRoamed()
/*     */   {
/* 165 */     if (this.roamed)
/*     */     {
/* 167 */       return false;
/*     */     }
/*     */     
/* 170 */     this.roamed = true;
/*     */     
/* 172 */     return true;
/*     */   }
/*     */   
/*     */   public hub.RoleMatchMarkingInfo getHubRoleMatchMarkingInfo()
/*     */   {
/*     */     try
/*     */     {
/* 179 */       hub.RoleMatchMarkingInfo roleMatchMarkingInfo = new hub.RoleMatchMarkingInfo();
/* 180 */       roleMatchMarkingInfo.phys_zoneid = this.physZoneid;
/* 181 */       roleMatchMarkingInfo.userid.setString(this.userid, "UTF-8");
/* 182 */       roleMatchMarkingInfo.roleid = this.roleid;
/* 183 */       roleMatchMarkingInfo.ranking = this.ranking;
/* 184 */       roleMatchMarkingInfo.win_num = this.winNum;
/* 185 */       roleMatchMarkingInfo.lose_num = this.loseNum;
/* 186 */       roleMatchMarkingInfo.display_rank = this.displayRank;
/* 187 */       roleMatchMarkingInfo.rolename.setString(this.roleName, "UTF-8");
/* 188 */       roleMatchMarkingInfo.level = this.level;
/* 189 */       roleMatchMarkingInfo.gender = this.gender;
/* 190 */       roleMatchMarkingInfo.occupation = this.occupation;
/* 191 */       roleMatchMarkingInfo.avatarid = this.avatarid;
/* 192 */       roleMatchMarkingInfo.avatar_frameid = this.avatarFrameid;
/* 193 */       return roleMatchMarkingInfo;
/*     */     }
/*     */     catch (Exception e) {}
/*     */     
/*     */ 
/* 198 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 205 */     if (this.basicCache != null)
/*     */     {
/* 207 */       return this.basicCache;
/*     */     }
/*     */     
/* 210 */     StringBuffer sb = new StringBuffer();
/* 211 */     sb.append('{');
/* 212 */     sb.append("phys_zoneid=").append(this.physZoneid).append(",");
/* 213 */     sb.append("userid=").append(this.userid).append(",");
/* 214 */     sb.append("roleid=").append(this.roleid).append(",");
/* 215 */     sb.append("ranking=").append(this.ranking).append(",");
/* 216 */     sb.append("win_num=").append(this.winNum).append(",");
/* 217 */     sb.append("lose_num=").append(this.loseNum).append(",");
/* 218 */     sb.append("display_rank=").append(this.displayRank).append(",");
/* 219 */     sb.append("rolename=").append(this.roleName).append(",");
/* 220 */     sb.append("level=").append(this.level).append(",");
/* 221 */     sb.append("gender=").append(this.gender).append(",");
/* 222 */     sb.append("occupation=").append(this.occupation).append(",");
/* 223 */     sb.append("avatarid=").append(this.avatarid).append(",");
/* 224 */     sb.append("avatar_frameid=").append(this.avatarFrameid);
/* 225 */     sb.append('}');
/*     */     
/* 227 */     this.basicCache = sb.toString();
/*     */     
/* 229 */     return this.basicCache;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\RoleMatchMarkingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */