/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import hub.RoleSelectionFinalInfo;
/*     */ 
/*     */ public class KnockOutRoleInfo implements RoamRoleInfo
/*     */ {
/*     */   private final String userid;
/*     */   private final long roleid;
/*     */   private final String roleName;
/*     */   private final int level;
/*     */   private final int gender;
/*     */   private final int occupation;
/*     */   private final int avatarId;
/*  15 */   private volatile Octets token = null;
/*     */   
/*  17 */   private volatile boolean roamed = false;
/*     */   
/*  19 */   private volatile String basicCache = null;
/*     */   
/*     */   public KnockOutRoleInfo(KnockOutRoleInfo roleCrossBattleInfo)
/*     */   {
/*  23 */     this.userid = roleCrossBattleInfo.userid;
/*  24 */     this.roleid = roleCrossBattleInfo.roleid;
/*  25 */     this.roleName = roleCrossBattleInfo.roleName;
/*  26 */     this.level = roleCrossBattleInfo.level;
/*  27 */     this.gender = roleCrossBattleInfo.gender;
/*  28 */     this.avatarId = roleCrossBattleInfo.avatarId;
/*  29 */     this.occupation = roleCrossBattleInfo.occupation;
/*     */   }
/*     */   
/*     */ 
/*     */   public KnockOutRoleInfo(String userId, long roleId, String roleName, int level, int gender, int occupation, int avatarId)
/*     */   {
/*  35 */     this.userid = userId;
/*  36 */     this.roleid = roleId;
/*  37 */     this.roleName = roleName;
/*  38 */     this.level = level;
/*  39 */     this.gender = gender;
/*  40 */     this.occupation = occupation;
/*  41 */     this.avatarId = avatarId;
/*     */   }
/*     */   
/*     */   public int getAvatarId()
/*     */   {
/*  46 */     return this.avatarId;
/*     */   }
/*     */   
/*     */   public boolean isRoamed()
/*     */   {
/*  51 */     return this.roamed;
/*     */   }
/*     */   
/*     */   public void setRoamed(boolean roamed)
/*     */   {
/*  56 */     this.roamed = roamed;
/*     */   }
/*     */   
/*     */   public String getBasicCache()
/*     */   {
/*  61 */     return this.basicCache;
/*     */   }
/*     */   
/*     */   public void setBasicCache(String basicCache)
/*     */   {
/*  66 */     this.basicCache = basicCache;
/*     */   }
/*     */   
/*     */   public boolean setToken(Octets token)
/*     */   {
/*  71 */     if ((token == null) || (token.equals(this.token)))
/*     */     {
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     this.token = token;
/*     */     
/*  78 */     return true;
/*     */   }
/*     */   
/*     */   public boolean setRoamed()
/*     */   {
/*  83 */     if (this.roamed)
/*     */     {
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     this.roamed = true;
/*     */     
/*  90 */     return true;
/*     */   }
/*     */   
/*     */   public RoleSelectionFinalInfo getHubRoleCrossBattleInfo() throws java.io.UnsupportedEncodingException
/*     */   {
/*  95 */     RoleSelectionFinalInfo roleCrossBattleInfo = new RoleSelectionFinalInfo();
/*  96 */     roleCrossBattleInfo.gender = this.gender;
/*  97 */     roleCrossBattleInfo.level = this.level;
/*  98 */     roleCrossBattleInfo.occupation = this.occupation;
/*  99 */     roleCrossBattleInfo.roleid = this.roleid;
/* 100 */     roleCrossBattleInfo.rolename.setString(this.roleName, "UTF-8");
/* 101 */     roleCrossBattleInfo.userid.setString(this.userid, "UTF-8");
/*     */     
/* 103 */     return roleCrossBattleInfo;
/*     */   }
/*     */   
/*     */   public boolean isRoam()
/*     */   {
/* 108 */     return this.roamed;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getUserid()
/*     */   {
/* 114 */     return this.userid;
/*     */   }
/*     */   
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/* 120 */     return this.roleid;
/*     */   }
/*     */   
/*     */   public String getRoleName()
/*     */   {
/* 125 */     return this.roleName;
/*     */   }
/*     */   
/*     */   public int getLevel()
/*     */   {
/* 130 */     return this.level;
/*     */   }
/*     */   
/*     */   public int getGender()
/*     */   {
/* 135 */     return this.gender;
/*     */   }
/*     */   
/*     */   public int getOccupation()
/*     */   {
/* 140 */     return this.occupation;
/*     */   }
/*     */   
/*     */ 
/*     */   public Octets getToken()
/*     */   {
/* 146 */     return this.token;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 152 */     if (this.basicCache != null)
/*     */     {
/* 154 */       return this.basicCache;
/*     */     }
/* 156 */     StringBuilder sb = new StringBuilder();
/* 157 */     sb.append("[selection_final_role_info]:");
/* 158 */     sb.append("user_id=").append(this.userid);
/* 159 */     sb.append("role_id=").append(this.roamed);
/* 160 */     sb.append("role_name=").append(this.roleName);
/* 161 */     sb.append("level=").append(this.level);
/* 162 */     sb.append("gender=").append(this.gender);
/* 163 */     sb.append("occupation=").append(this.occupation);
/* 164 */     sb.append("avatar_id").append(this.avatarId);
/* 165 */     sb.append("token=").append(this.token);
/* 166 */     sb.append("roamed=").append(this.roamed);
/*     */     
/* 168 */     this.basicCache = sb.toString();
/*     */     
/* 170 */     return this.basicCache;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\KnockOutRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */