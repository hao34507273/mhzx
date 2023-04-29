/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossserver.main.RoamRoleInfo;
/*     */ 
/*     */ 
/*     */ public class RolePointRaceMarkingInfo
/*     */   implements RoamRoleInfo
/*     */ {
/*     */   private final int physZoneid;
/*     */   private final String userid;
/*     */   private final long roleid;
/*  14 */   private volatile Octets token = null;
/*  15 */   private volatile boolean roamed = false;
/*     */   
/*  17 */   private volatile String basicCache = null;
/*     */   
/*     */   public RolePointRaceMarkingInfo(String userid, long roleid)
/*     */   {
/*  21 */     this(GameServerInfoManager.getZoneId(), userid, roleid);
/*     */   }
/*     */   
/*     */   public RolePointRaceMarkingInfo(int physZoneid, String userid, long roleid)
/*     */   {
/*  26 */     this.physZoneid = physZoneid;
/*  27 */     this.userid = userid;
/*  28 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   public int getPhysZoneid()
/*     */   {
/*  33 */     return this.physZoneid;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getUserid()
/*     */   {
/*  39 */     return this.userid;
/*     */   }
/*     */   
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/*  45 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */   public Octets getToken()
/*     */   {
/*  51 */     return this.token;
/*     */   }
/*     */   
/*     */   public boolean isRoam()
/*     */   {
/*  56 */     return this.roamed;
/*     */   }
/*     */   
/*     */   public boolean setToken(Octets token)
/*     */   {
/*  61 */     if ((token == null) || (token.equals(this.token)))
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     this.token = token;
/*     */     
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   public boolean setRoamed()
/*     */   {
/*  73 */     if (this.roamed)
/*     */     {
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     this.roamed = true;
/*     */     
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   public hub.RolePointRaceMarkingInfo getHubRolePointRaceMarkingInfo()
/*     */   {
/*     */     try
/*     */     {
/*  87 */       hub.RolePointRaceMarkingInfo rolePointRaceMarkingInfo = new hub.RolePointRaceMarkingInfo();
/*  88 */       rolePointRaceMarkingInfo.phys_zoneid = this.physZoneid;
/*  89 */       rolePointRaceMarkingInfo.userid.setString(this.userid, "UTF-8");
/*  90 */       rolePointRaceMarkingInfo.roleid = this.roleid;
/*  91 */       return rolePointRaceMarkingInfo;
/*     */     }
/*     */     catch (Exception e) {}
/*     */     
/*     */ 
/*  96 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 103 */     if (this.basicCache != null)
/*     */     {
/* 105 */       return this.basicCache;
/*     */     }
/*     */     
/* 108 */     StringBuffer sb = new StringBuffer();
/* 109 */     sb.append('{');
/* 110 */     sb.append("phys_zoneid=").append(this.physZoneid).append(",");
/* 111 */     sb.append("userid=").append(this.userid).append(",");
/* 112 */     sb.append("roleid=").append(this.roleid);
/* 113 */     sb.append('}');
/*     */     
/* 115 */     this.basicCache = sb.toString();
/*     */     
/* 117 */     return this.basicCache;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\RolePointRaceMarkingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */