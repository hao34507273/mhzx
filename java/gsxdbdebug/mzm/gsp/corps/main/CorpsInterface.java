/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import xbean.CorpsMember;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2corps;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CorpsInterface
/*     */ {
/*     */   public static long getRoleCorpsId(long roleId, boolean remainRoleLock)
/*     */   {
/*  24 */     CorpsMember xCorpsMember = null;
/*  25 */     if (remainRoleLock)
/*     */     {
/*  27 */       xCorpsMember = Role2corps.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  31 */       xCorpsMember = Role2corps.select(Long.valueOf(roleId));
/*     */     }
/*  33 */     if (xCorpsMember == null)
/*     */     {
/*  35 */       return -1L;
/*     */     }
/*  37 */     return xCorpsMember.getCorpsid();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean hasCorps(long roleId)
/*     */   {
/*  51 */     return getRoleCorpsId(roleId, false) > 0L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static RoleCorpsInfo getRoleCorpsInfo(long roleId, boolean remainRoleLock)
/*     */   {
/*  67 */     CorpsMember xCorpsMember = null;
/*  68 */     if (remainRoleLock)
/*     */     {
/*  70 */       xCorpsMember = Role2corps.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  74 */       xCorpsMember = Role2corps.select(Long.valueOf(roleId));
/*     */     }
/*  76 */     if (xCorpsMember == null)
/*     */     {
/*  78 */       return null;
/*     */     }
/*  80 */     return new RoleCorpsInfo(roleId, xCorpsMember);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static CorpsInfo getCorpsInfoByCorpsId(long corpsId, boolean remainCorpsLock)
/*     */   {
/*  96 */     xbean.Corps xCorps = null;
/*  97 */     if (remainCorpsLock)
/*     */     {
/*  99 */       xCorps = xtable.Corps.get(Long.valueOf(corpsId));
/*     */     }
/*     */     else
/*     */     {
/* 103 */       xCorps = xtable.Corps.select(Long.valueOf(corpsId));
/*     */     }
/* 105 */     if (xCorps == null)
/*     */     {
/* 107 */       return null;
/*     */     }
/* 109 */     return new CorpsInfo(xCorps);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static CorpsInfo getCorpsInfoByRoleId(long roleId, boolean remainRoleLock, boolean remainCorpsLock)
/*     */   {
/* 126 */     long corpsId = getRoleCorpsId(roleId, remainRoleLock);
/* 127 */     if (corpsId <= 0L)
/*     */     {
/* 129 */       return null;
/*     */     }
/* 131 */     return getCorpsInfoByCorpsId(corpsId, remainCorpsLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static PJoinCorps joinCorpsByIdip(long roleId, long corpsId)
/*     */   {
/* 144 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { RoleInterface.getUserId(roleId) }));
/*     */     
/* 146 */     Lockeys.lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*     */     
/* 148 */     PJoinCorps joinCorps = new PJoinCorpsByIDIP(roleId, xtable.Corps.get(Long.valueOf(corpsId)), -1L);
/* 149 */     joinCorps.joinCorps();
/*     */     
/* 151 */     return joinCorps;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static AppointCaptainRes appointCaptainByIdip(long roleId)
/*     */   {
/* 162 */     RoleCorpsInfo corpsInfo = getRoleCorpsInfo(roleId, false);
/* 163 */     if (corpsInfo == null)
/*     */     {
/* 165 */       AppointCaptainRes res = new AppointCaptainRes();
/* 166 */       res.setErrReason(AppointCaptainRes.AppointCaptianErrReason.NotInCorps);
/* 167 */       return res;
/*     */     }
/* 169 */     PCAppointCaptainReq p = new PCAppointCaptainReq(corpsInfo.getCorpsId(), roleId);
/* 170 */     if ((!p.call()) && (p.getRes().isSuc()))
/*     */     {
/*     */ 
/* 173 */       p.getRes().setErrReason(AppointCaptainRes.AppointCaptianErrReason.Other);
/*     */     }
/* 175 */     return p.getRes();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\CorpsInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */