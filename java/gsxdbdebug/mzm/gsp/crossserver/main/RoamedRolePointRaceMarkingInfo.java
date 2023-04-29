/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import hub.RolePointRaceMarkingInfo;
/*     */ 
/*     */ public class RoamedRolePointRaceMarkingInfo {
/*     */   private final int physZoneid;
/*     */   private final String userid;
/*     */   private final long roleid;
/*   9 */   private volatile boolean dataPrepared = false;
/*  10 */   private volatile boolean logined = false;
/*  11 */   private volatile boolean teamRestore = false;
/*     */   
/*  13 */   private volatile String basicCache = null;
/*     */   
/*     */   public RoamedRolePointRaceMarkingInfo(RolePointRaceMarkingInfo rolePointRaceMarkingInfo)
/*     */   {
/*  17 */     this.physZoneid = rolePointRaceMarkingInfo.phys_zoneid;
/*  18 */     this.userid = rolePointRaceMarkingInfo.userid.getString("UTF-8");
/*  19 */     this.roleid = rolePointRaceMarkingInfo.roleid;
/*     */   }
/*     */   
/*     */   public RoamedRolePointRaceMarkingInfo(int physZoneid, String userid, long roleid)
/*     */   {
/*  24 */     this.physZoneid = physZoneid;
/*  25 */     this.userid = userid;
/*  26 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   public int getPhysZoneid()
/*     */   {
/*  31 */     return this.physZoneid;
/*     */   }
/*     */   
/*     */   public String getUserid()
/*     */   {
/*  36 */     return this.userid;
/*     */   }
/*     */   
/*     */   public long getRoleid()
/*     */   {
/*  41 */     return this.roleid;
/*     */   }
/*     */   
/*     */   public boolean setDataPrepared()
/*     */   {
/*  46 */     if (this.dataPrepared)
/*     */     {
/*  48 */       return false;
/*     */     }
/*  50 */     this.dataPrepared = true;
/*     */     
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isDataPrepared()
/*     */   {
/*  57 */     return this.dataPrepared;
/*     */   }
/*     */   
/*     */   public boolean setLogined()
/*     */   {
/*  62 */     if (this.logined)
/*     */     {
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     this.logined = true;
/*     */     
/*  69 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isLogined()
/*     */   {
/*  74 */     return this.logined;
/*     */   }
/*     */   
/*     */   public boolean setTeamRestore()
/*     */   {
/*  79 */     if (this.teamRestore)
/*     */     {
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     this.teamRestore = true;
/*     */     
/*  86 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isTeamRestore()
/*     */   {
/*  91 */     return this.teamRestore;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/*  97 */     if (this.basicCache != null)
/*     */     {
/*  99 */       return this.basicCache;
/*     */     }
/*     */     
/* 102 */     StringBuffer sb = new StringBuffer();
/* 103 */     sb.append('{');
/* 104 */     sb.append("phys_zoneid=").append(this.physZoneid).append(",");
/* 105 */     sb.append("userid=").append(this.userid).append(",");
/* 106 */     sb.append("roleid=").append(this.roleid).append(",");
/* 107 */     sb.append('}');
/*     */     
/* 109 */     this.basicCache = sb.toString();
/*     */     
/* 111 */     return this.basicCache;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\RoamedRolePointRaceMarkingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */