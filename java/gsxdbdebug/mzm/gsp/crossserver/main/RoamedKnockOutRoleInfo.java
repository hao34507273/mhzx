/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class RoamedKnockOutRoleInfo
/*     */ {
/*     */   private int physZoneid;
/*   8 */   private String userid = null;
/*     */   private long roleid;
/*  10 */   private String roleName = null;
/*     */   private int level;
/*     */   private int gender;
/*     */   private int occupation;
/*     */   private int avatarId;
/*     */   
/*     */   public int getAvatarId()
/*     */   {
/*  18 */     return this.avatarId;
/*     */   }
/*     */   
/*     */   public void setAvatarId(int avatarId)
/*     */   {
/*  23 */     this.avatarId = avatarId;
/*     */   }
/*     */   
/*  26 */   private volatile Octets token = null;
/*     */   
/*  28 */   private volatile boolean roamed = false;
/*     */   
/*  30 */   private volatile boolean dataPrepared = false;
/*  31 */   private volatile boolean logined = false;
/*  32 */   private volatile boolean teamRestore = false;
/*     */   
/*  34 */   private volatile String basicCache = null;
/*     */   
/*     */   public boolean isRoamed()
/*     */   {
/*  38 */     return this.roamed;
/*     */   }
/*     */   
/*     */   public void setRoamed(boolean roamed)
/*     */   {
/*  43 */     this.roamed = roamed;
/*     */   }
/*     */   
/*     */   public String getBasicCache()
/*     */   {
/*  48 */     return this.basicCache;
/*     */   }
/*     */   
/*     */   public void setBasicCache(String basicCache)
/*     */   {
/*  53 */     this.basicCache = basicCache;
/*     */   }
/*     */   
/*     */   public void setPhysZoneid(int physZoneid)
/*     */   {
/*  58 */     this.physZoneid = physZoneid;
/*     */   }
/*     */   
/*     */   public void setUserid(String userid)
/*     */   {
/*  63 */     this.userid = userid;
/*     */   }
/*     */   
/*     */   public void setRoleid(long roleid)
/*     */   {
/*  68 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   public void setRoleName(String roleName)
/*     */   {
/*  73 */     this.roleName = roleName;
/*     */   }
/*     */   
/*     */   public void setLevel(int level)
/*     */   {
/*  78 */     this.level = level;
/*     */   }
/*     */   
/*     */   public void setGender(int gender)
/*     */   {
/*  83 */     this.gender = gender;
/*     */   }
/*     */   
/*     */   public void setOccupation(int occupation)
/*     */   {
/*  88 */     this.occupation = occupation;
/*     */   }
/*     */   
/*     */   public void setDataPrepared(boolean dataPrepared)
/*     */   {
/*  93 */     this.dataPrepared = dataPrepared;
/*     */   }
/*     */   
/*     */   public void setLogined(boolean logined)
/*     */   {
/*  98 */     this.logined = logined;
/*     */   }
/*     */   
/*     */   public void setTeamRestore(boolean teamRestore)
/*     */   {
/* 103 */     this.teamRestore = teamRestore;
/*     */   }
/*     */   
/*     */   public RoamedKnockOutRoleInfo(RoamedKnockOutRoleInfo roleCrossBattleInfo)
/*     */   {
/* 108 */     this.gender = roleCrossBattleInfo.getGender();
/* 109 */     this.userid = roleCrossBattleInfo.getUserid();
/* 110 */     this.roleid = roleCrossBattleInfo.getRoleid();
/* 111 */     this.roleName = roleCrossBattleInfo.getRoleName();
/* 112 */     this.level = roleCrossBattleInfo.getLevel();
/* 113 */     this.gender = roleCrossBattleInfo.getGender();
/* 114 */     this.occupation = roleCrossBattleInfo.getOccupation();
/*     */   }
/*     */   
/*     */ 
/*     */   public RoamedKnockOutRoleInfo(int physZoneId, String userId, long roleId, String roleName, int level, int gender, int occupation)
/*     */   {
/* 120 */     this.physZoneid = physZoneId;
/* 121 */     this.userid = userId;
/* 122 */     this.roleid = roleId;
/* 123 */     this.roleName = roleName;
/* 124 */     this.level = level;
/* 125 */     this.gender = gender;
/* 126 */     this.occupation = occupation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public RoamedKnockOutRoleInfo() {}
/*     */   
/*     */ 
/*     */   public boolean setToken(Octets token)
/*     */   {
/* 136 */     if ((token == null) || (token.equals(this.token)))
/*     */     {
/* 138 */       return false;
/*     */     }
/*     */     
/* 141 */     this.token = token;
/*     */     
/* 143 */     return true;
/*     */   }
/*     */   
/*     */   public boolean setRoamed()
/*     */   {
/* 148 */     if (this.roamed)
/*     */     {
/* 150 */       return false;
/*     */     }
/*     */     
/* 153 */     this.roamed = true;
/*     */     
/* 155 */     return true;
/*     */   }
/*     */   
/*     */   public hub.RoleSelectionFinalInfo getHubRoleCrossBattleInfo() throws java.io.UnsupportedEncodingException
/*     */   {
/* 160 */     hub.RoleSelectionFinalInfo roleCrossBattleInfo = new hub.RoleSelectionFinalInfo();
/* 161 */     roleCrossBattleInfo.gender = this.gender;
/* 162 */     roleCrossBattleInfo.level = this.level;
/* 163 */     roleCrossBattleInfo.occupation = this.occupation;
/* 164 */     roleCrossBattleInfo.roleid = this.roleid;
/* 165 */     roleCrossBattleInfo.rolename.setString(this.roleName, "UTF-8");
/* 166 */     roleCrossBattleInfo.userid.setString(this.userid, "UTF-8");
/*     */     
/* 168 */     return roleCrossBattleInfo;
/*     */   }
/*     */   
/*     */   public boolean isRoam()
/*     */   {
/* 173 */     return this.roamed;
/*     */   }
/*     */   
/*     */   public int getPhysZoneid()
/*     */   {
/* 178 */     return this.physZoneid;
/*     */   }
/*     */   
/*     */   public String getUserid()
/*     */   {
/* 183 */     return this.userid;
/*     */   }
/*     */   
/*     */   public long getRoleid()
/*     */   {
/* 188 */     return this.roleid;
/*     */   }
/*     */   
/*     */   public String getRoleName()
/*     */   {
/* 193 */     return this.roleName;
/*     */   }
/*     */   
/*     */   public int getLevel()
/*     */   {
/* 198 */     return this.level;
/*     */   }
/*     */   
/*     */   public int getGender()
/*     */   {
/* 203 */     return this.gender;
/*     */   }
/*     */   
/*     */   public int getOccupation()
/*     */   {
/* 208 */     return this.occupation;
/*     */   }
/*     */   
/*     */   public Octets getToken()
/*     */   {
/* 213 */     return this.token;
/*     */   }
/*     */   
/*     */   public boolean setDataPrepared()
/*     */   {
/* 218 */     if (this.dataPrepared)
/*     */     {
/* 220 */       return false;
/*     */     }
/* 222 */     this.dataPrepared = true;
/*     */     
/* 224 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isDataPrepared()
/*     */   {
/* 229 */     return this.dataPrepared;
/*     */   }
/*     */   
/*     */   public boolean setLogined()
/*     */   {
/* 234 */     if (this.logined)
/*     */     {
/* 236 */       return false;
/*     */     }
/*     */     
/* 239 */     this.logined = true;
/*     */     
/* 241 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isLogined()
/*     */   {
/* 246 */     return this.logined;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean setTeamRestore()
/*     */   {
/* 254 */     if (this.teamRestore)
/*     */     {
/* 256 */       return false;
/*     */     }
/*     */     
/* 259 */     this.teamRestore = true;
/*     */     
/* 261 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isTeamRestore()
/*     */   {
/* 266 */     return this.teamRestore;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\RoamedKnockOutRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */