/*     */ package mzm.gsp.crosscompete.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.crossserver.main.RoamContext;
/*     */ import mzm.gsp.crossserver.main.RoamRoleInfo;
/*     */ import mzm.gsp.crossserver.main.RoamType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EnterContext
/*     */   implements RoamContext
/*     */ {
/*     */   public final long factionid;
/*     */   public final List<EnterRole> roamRoles;
/*     */   public final int roamServerid;
/*     */   public final long contextid;
/*     */   
/*     */   public EnterContext(long factionid, List<EnterRole> roamRoles, int roamServerid, long contextid)
/*     */   {
/*  26 */     this.factionid = factionid;
/*  27 */     this.roamRoles = roamRoles;
/*  28 */     this.roamServerid = roamServerid;
/*  29 */     this.contextid = contextid;
/*     */   }
/*     */   
/*     */   public boolean addToken(long roleid, Octets token)
/*     */   {
/*  34 */     for (EnterRole roleInfo : this.roamRoles) {
/*  35 */       if (roleInfo.getRoleid() == roleid) {
/*  36 */         roleInfo.setToken(token);
/*  37 */         return true;
/*     */       }
/*     */     }
/*     */     
/*  41 */     return false;
/*     */   }
/*     */   
/*     */   public List<RoamRoleInfo> getRoamRoleInfos()
/*     */   {
/*  46 */     return new ArrayList(this.roamRoles);
/*     */   }
/*     */   
/*     */   public long getRoamRoomInstanceid()
/*     */   {
/*  51 */     return this.contextid;
/*     */   }
/*     */   
/*     */   public RoamType getRoamType()
/*     */   {
/*  56 */     return RoamType.CROSS_COMPETE;
/*     */   }
/*     */   
/*     */   public int getRoamZoneid()
/*     */   {
/*  61 */     return this.roamServerid;
/*     */   }
/*     */   
/*     */   public boolean isGenTokenDone()
/*     */   {
/*  66 */     for (EnterRole roamRole : this.roamRoles) {
/*  67 */       if (roamRole.getToken() == null) {
/*  68 */         return false;
/*     */       }
/*     */     }
/*  71 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isRoamDone()
/*     */   {
/*  76 */     for (EnterRole roamRole : this.roamRoles) {
/*  77 */       if (!roamRole.isRoamed()) {
/*  78 */         return false;
/*     */       }
/*     */     }
/*  81 */     return true;
/*     */   }
/*     */   
/*     */   public boolean setRoamed(long roleid)
/*     */   {
/*  86 */     for (EnterRole roamRole : this.roamRoles) {
/*  87 */       if (roamRole.getRoleid() == roleid) {
/*  88 */         roamRole.setRoamed();
/*  89 */         return true;
/*     */       }
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public List<Long> getRoleidList() {
/*  96 */     List<Long> roleList = new ArrayList();
/*  97 */     for (EnterRole roamRole : this.roamRoles) {
/*  98 */       roleList.add(Long.valueOf(roamRole.roleid));
/*     */     }
/* 100 */     return roleList;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\EnterContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */