/*     */ package mzm.gsp.pk.main;
/*     */ 
/*     */ import mzm.gsp.pk.confbean.SPKConsts;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.RolePKInformation;
/*     */ import xbean.RolePKTimerInformation;
/*     */ import xtable.Role2pk_info;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PKStatusManager
/*     */ {
/*     */   public static int setPKEnabled(long roleId)
/*     */   {
/*  19 */     if (RoleStatusInterface.setStatus(roleId, 1621, false)) {
/*  20 */       int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*  21 */       int expireTime = now + (int)(SPKConsts.getInstance().PK_MINUTES * 60L);
/*  22 */       PKManager.getOrCreateRolePKInformation(roleId).setPk_mode_expire_time(expireTime);
/*  23 */       PKManager.getOrCreateRolePKTimerInformation(roleId).setPk_mode_session_id(new PKEnabledSession(expireTime - now, roleId).getSessionId());
/*  24 */       PKLogManager.tlogPKEnabled(roleId, expireTime);
/*  25 */       return expireTime;
/*     */     }
/*  27 */     PKLogManager.error(String.format("PKStatusManager.setPKEnabled()@failed|roleid=%d", new Object[] { Long.valueOf(roleId) }));
/*  28 */     return 0;
/*     */   }
/*     */   
/*     */   public static void unsetPKEnabled(long roleId)
/*     */   {
/*  33 */     unsetPKEnabled(roleId, true);
/*     */   }
/*     */   
/*     */   public static void unsetPKEnabled(long roleId, boolean removeSession)
/*     */   {
/*  38 */     if (RoleStatusInterface.unsetStatus(roleId, 1621)) {
/*  39 */       PKManager.getOrCreateRolePKInformation(roleId).setPk_mode_expire_time(0);
/*  40 */       RolePKTimerInformation xRolePKTimerInformation = PKManager.getOrCreateRolePKTimerInformation(roleId);
/*  41 */       if (removeSession) {
/*  42 */         Session.removeSession(xRolePKTimerInformation.getPk_mode_session_id(), roleId);
/*     */       }
/*  44 */       xRolePKTimerInformation.setPk_mode_session_id(0L);
/*     */     }
/*     */   }
/*     */   
/*     */   public static int setProtection(long roleId)
/*     */   {
/*  50 */     if (RoleStatusInterface.setStatus(roleId, 1622, false)) {
/*  51 */       int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*  52 */       int expireTime = now + (int)(SPKConsts.getInstance().PK_DEATH_PROTECTION_MINUTES * 60L);
/*  53 */       PKManager.getOrCreateRolePKInformation(roleId).setProtection_expire_time(expireTime);
/*  54 */       PKManager.getOrCreateRolePKTimerInformation(roleId).setProtection_session_id(new ProtectionSession(expireTime - now, roleId).getSessionId());
/*  55 */       PKLogManager.tlogPKProtected(roleId, Role2pk_info.selectPk_death_times(Long.valueOf(roleId)).intValue(), expireTime);
/*  56 */       return expireTime;
/*     */     }
/*  58 */     PKLogManager.error(String.format("PKStatusManager.setProtection()@failed|roleid=%d", new Object[] { Long.valueOf(roleId) }));
/*  59 */     return 0;
/*     */   }
/*     */   
/*     */   public static void unsetProtection(long roleId)
/*     */   {
/*  64 */     unsetProtection(roleId, true);
/*     */   }
/*     */   
/*     */   public static void unsetProtection(long roleId, boolean removeSession)
/*     */   {
/*  69 */     if (RoleStatusInterface.unsetStatus(roleId, 1622)) {
/*  70 */       PKManager.getOrCreateRolePKInformation(roleId).setProtection_expire_time(0);
/*  71 */       RolePKTimerInformation xRolePKTimerInformation = PKManager.getOrCreateRolePKTimerInformation(roleId);
/*  72 */       if (removeSession) {
/*  73 */         Session.removeSession(xRolePKTimerInformation.getProtection_session_id(), roleId);
/*     */       }
/*  75 */       xRolePKTimerInformation.setProtection_session_id(0L);
/*     */     }
/*     */   }
/*     */   
/*     */   public static int setForceProtection(long roleId)
/*     */   {
/*  81 */     if (RoleStatusInterface.setStatus(roleId, 1623, false)) {
/*  82 */       unsetPKEnabled(roleId);
/*  83 */       unsetProtection(roleId);
/*  84 */       int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*  85 */       int expireTime = now + (int)(SPKConsts.getInstance().PK_FORCE_PROTECTION_MINUTES * 60L);
/*  86 */       PKManager.getOrCreateRolePKInformation(roleId).setForce_protection_expire_time(expireTime);
/*  87 */       PKManager.getOrCreateRolePKTimerInformation(roleId).setForce_protection_session_id(new ForceProtectionSession(expireTime - now, roleId).getSessionId());
/*  88 */       PKLogManager.tlogPKForceProtected(roleId, expireTime);
/*  89 */       return expireTime;
/*     */     }
/*  91 */     PKLogManager.error(String.format("PKStatusManager.setForceProtection()@failed|roleid=%d", new Object[] { Long.valueOf(roleId) }));
/*  92 */     return 0;
/*     */   }
/*     */   
/*     */   public static void unsetForceProtection(long roleId)
/*     */   {
/*  97 */     unsetForceProtection(roleId, true);
/*     */   }
/*     */   
/*     */   public static void unsetForceProtection(long roleId, boolean removeSession)
/*     */   {
/* 102 */     if (RoleStatusInterface.unsetStatus(roleId, 1623)) {
/* 103 */       PKManager.getOrCreateRolePKInformation(roleId).setForce_protection_expire_time(0);
/* 104 */       RolePKTimerInformation xRolePKTimerInformation = PKManager.getOrCreateRolePKTimerInformation(roleId);
/* 105 */       if (removeSession) {
/* 106 */         Session.removeSession(xRolePKTimerInformation.getForce_protection_session_id(), roleId);
/*     */       }
/* 108 */       xRolePKTimerInformation.setForce_protection_session_id(0L);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void syncStatusAndStartSessions(long roleId)
/*     */   {
/* 114 */     RolePKInformation xRolePKInformation = PKManager.getRolePKInformation(roleId);
/* 115 */     if (xRolePKInformation != null) {
/* 116 */       RolePKTimerInformation xRolePKTimerInformation = null;
/* 117 */       int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 118 */       int expireTimeForPKMode = xRolePKInformation.getPk_mode_expire_time();
/* 119 */       if (expireTimeForPKMode != 0) {
/* 120 */         int interval = expireTimeForPKMode - now;
/* 121 */         if (interval > 0) {
/* 122 */           boolean statusIsSet = true;
/* 123 */           if (!RoleStatusInterface.containsStatus(roleId, 1621)) {
/* 124 */             statusIsSet = RoleStatusInterface.setStatus(roleId, 1621, false);
/* 125 */             if (!statusIsSet) {
/* 126 */               PKLogManager.error("PKStatusManager.syncStatusAndStartSessions()@init pk status failed|roleid");
/* 127 */               xRolePKInformation.setPk_mode_expire_time(0);
/*     */             }
/*     */           }
/* 130 */           if (statusIsSet) {
/* 131 */             Session session = new PKEnabledSession(interval, roleId);
/* 132 */             xRolePKTimerInformation = PKManager.getOrCreateRolePKTimerInformation(roleId);
/* 133 */             xRolePKTimerInformation.setPk_mode_session_id(session.getSessionId());
/*     */           }
/*     */         } else {
/* 136 */           xRolePKInformation.setPk_mode_expire_time(0);
/* 137 */           if (RoleStatusInterface.containsStatus(roleId, 1621)) {
/* 138 */             RoleStatusInterface.unsetStatus(roleId, 1621);
/*     */           }
/*     */         }
/*     */       }
/* 142 */       int expireTimeForProtection = xRolePKInformation.getProtection_expire_time();
/* 143 */       if (expireTimeForProtection != 0) {
/* 144 */         int interval2 = expireTimeForProtection - now;
/* 145 */         if (now > 0) {
/* 146 */           boolean statusIsSet2 = true;
/* 147 */           if (!RoleStatusInterface.containsStatus(roleId, 1622)) {
/* 148 */             statusIsSet2 = RoleStatusInterface.setStatus(roleId, 1622, false);
/* 149 */             if (!statusIsSet2) {
/* 150 */               PKLogManager.error(String.format("PKStatusManager.syncStatusAndStartSessions()@init protection failed|roleid=%d", new Object[] { Long.valueOf(roleId) }));
/* 151 */               xRolePKInformation.setProtection_expire_time(0);
/*     */             }
/*     */           }
/* 154 */           if (statusIsSet2) {
/* 155 */             Session session2 = new ProtectionSession(interval2, roleId);
/* 156 */             if (xRolePKTimerInformation == null) {
/* 157 */               xRolePKTimerInformation = PKManager.getOrCreateRolePKTimerInformation(roleId);
/*     */             }
/* 159 */             xRolePKTimerInformation.setProtection_session_id(session2.getSessionId());
/*     */           }
/*     */         } else {
/* 162 */           xRolePKInformation.setProtection_expire_time(0);
/* 163 */           if (RoleStatusInterface.containsStatus(roleId, 1622)) {
/* 164 */             RoleStatusInterface.unsetStatus(roleId, 1622);
/*     */           }
/*     */         }
/*     */       }
/* 168 */       int expireTimeForForceProtection = xRolePKInformation.getForce_protection_expire_time();
/* 169 */       if (expireTimeForForceProtection != 0) {
/* 170 */         int interval3 = expireTimeForForceProtection - now;
/* 171 */         if (interval3 > 0) {
/* 172 */           boolean statusIsSet3 = true;
/* 173 */           if (!RoleStatusInterface.containsStatus(roleId, 1623)) {
/* 174 */             statusIsSet3 = RoleStatusInterface.setStatus(roleId, 1623, false);
/* 175 */             if (!statusIsSet3) {
/* 176 */               PKLogManager.error(String.format("PKStatusManager.syncStatusAndStartSessions()@init force protection failed|roleid=%d", new Object[] { Long.valueOf(roleId) }));
/* 177 */               xRolePKInformation.setForce_protection_expire_time(0);
/*     */             }
/*     */           }
/* 180 */           if (statusIsSet3) {
/* 181 */             Session session3 = new ForceProtectionSession(interval3, roleId);
/* 182 */             if (xRolePKTimerInformation == null) {
/* 183 */               xRolePKTimerInformation = PKManager.getOrCreateRolePKTimerInformation(roleId);
/*     */             }
/* 185 */             xRolePKTimerInformation.setForce_protection_session_id(session3.getSessionId());
/* 186 */             return;
/*     */           }
/* 188 */           return;
/*     */         }
/* 190 */         xRolePKInformation.setForce_protection_expire_time(0);
/* 191 */         if (RoleStatusInterface.containsStatus(roleId, 1623)) {
/* 192 */           RoleStatusInterface.unsetStatus(roleId, 1623);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void stopStatusSessions(long roleId)
/*     */   {
/* 200 */     RolePKTimerInformation xRolePKTimerInformation = PKManager.getRolePKTimerInformation(roleId);
/* 201 */     if (xRolePKTimerInformation != null) {
/* 202 */       long sessionIdForPKMode = xRolePKTimerInformation.getPk_mode_session_id();
/* 203 */       if (sessionIdForPKMode != 0L) {
/* 204 */         Session.removeSession(sessionIdForPKMode, roleId);
/* 205 */         xRolePKTimerInformation.setPk_mode_session_id(0L);
/*     */       }
/* 207 */       long sessionIdForProtection = xRolePKTimerInformation.getProtection_session_id();
/* 208 */       if (sessionIdForProtection != 0L) {
/* 209 */         Session.removeSession(sessionIdForProtection, roleId);
/* 210 */         xRolePKTimerInformation.setProtection_session_id(0L);
/*     */       }
/* 212 */       long sessionIdForForceProtection = xRolePKTimerInformation.getForce_protection_session_id();
/* 213 */       if (sessionIdForForceProtection != 0L) {
/* 214 */         Session.removeSession(sessionIdForForceProtection, roleId);
/* 215 */         xRolePKTimerInformation.setForce_protection_session_id(0L);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PKEnabledSession extends Session
/*     */   {
/*     */     final long roleId;
/*     */     
/*     */     PKEnabledSession(long interval, long roleId) {
/* 225 */       super(roleId);
/* 226 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     protected void onTimeOut()
/*     */     {
/* 231 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception {
/* 234 */           RolePKTimerInformation xRolePKTimerInformation = PKManager.getRolePKTimerInformation(PKStatusManager.PKEnabledSession.this.roleId);
/* 235 */           if (xRolePKTimerInformation == null) {
/* 236 */             return false;
/*     */           }
/* 238 */           if (xRolePKTimerInformation.getPk_mode_session_id() != PKStatusManager.PKEnabledSession.this.getSessionId()) {
/* 239 */             return true;
/*     */           }
/* 241 */           PKStatusManager.unsetPKEnabled(PKStatusManager.PKEnabledSession.this.roleId, false);
/* 242 */           return true;
/*     */         }
/*     */       }.execute();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ProtectionSession extends Session {
/*     */     final long roleId;
/*     */     
/*     */     ProtectionSession(long interval, long roleId) {
/* 252 */       super(roleId);
/* 253 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     protected void onTimeOut()
/*     */     {
/* 258 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception {
/* 261 */           RolePKTimerInformation xRolePKTimerInformation = PKManager.getRolePKTimerInformation(PKStatusManager.ProtectionSession.this.roleId);
/* 262 */           if (xRolePKTimerInformation == null) {
/* 263 */             return false;
/*     */           }
/* 265 */           if (xRolePKTimerInformation.getProtection_session_id() != PKStatusManager.ProtectionSession.this.getSessionId()) {
/* 266 */             return true;
/*     */           }
/* 268 */           PKStatusManager.unsetProtection(PKStatusManager.ProtectionSession.this.roleId, false);
/* 269 */           return true;
/*     */         }
/*     */       }.execute();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ForceProtectionSession extends Session
/*     */   {
/*     */     final long roleId;
/*     */     
/*     */     ForceProtectionSession(long interval, long roleId) {
/* 280 */       super(roleId);
/* 281 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */     protected void onTimeOut()
/*     */     {
/* 286 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception {
/* 289 */           RolePKTimerInformation xRolePKTimerInformation = PKManager.getRolePKTimerInformation(PKStatusManager.ForceProtectionSession.this.roleId);
/* 290 */           if (xRolePKTimerInformation == null) {
/* 291 */             return false;
/*     */           }
/* 293 */           if (xRolePKTimerInformation.getForce_protection_session_id() != PKStatusManager.ForceProtectionSession.this.getSessionId()) {
/* 294 */             return true;
/*     */           }
/* 296 */           PKStatusManager.unsetForceProtection(PKStatusManager.ForceProtectionSession.this.roleId, false);
/* 297 */           return true;
/*     */         }
/*     */       }.execute();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PKStatusManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */