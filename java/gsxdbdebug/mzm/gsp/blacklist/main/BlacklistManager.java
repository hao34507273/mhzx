/*     */ package mzm.gsp.blacklist.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.blacklist.BlackRole;
/*     */ import mzm.gsp.blacklist.SBlacklistNormalResult;
/*     */ import mzm.gsp.blacklist.SBlacklistRes;
/*     */ import mzm.gsp.blacklist.SDelBlackRoleRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import xbean.Pod;
/*     */ 
/*     */ class BlacklistManager
/*     */ {
/*     */   static xbean.Blacklist getXBlacklistIfNotExist(long roleid)
/*     */   {
/*  21 */     xbean.Blacklist xBlacklist = xtable.Blacklist.get(Long.valueOf(roleid));
/*  22 */     if (xBlacklist == null) {
/*  23 */       xBlacklist = Pod.newBlacklist();
/*  24 */       xtable.Blacklist.insert(Long.valueOf(roleid), xBlacklist);
/*     */     }
/*  26 */     return xBlacklist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void syncBlacklist(long roleid, xbean.Blacklist xBlacklist)
/*     */   {
/*  37 */     SBlacklistRes res = new SBlacklistRes();
/*  38 */     if ((xBlacklist == null) || (xBlacklist.getList().isEmpty())) {
/*  39 */       OnlineManager.getInstance().send(roleid, res);
/*  40 */       return;
/*     */     }
/*  42 */     for (Iterator i$ = xBlacklist.getList().iterator(); i$.hasNext();) { long blackRoleid = ((Long)i$.next()).longValue();
/*  43 */       BlackRole bean = getBlackRoleBean(blackRoleid);
/*  44 */       if (bean != null) {
/*  45 */         res.list.add(bean);
/*     */       }
/*     */     }
/*     */     
/*  49 */     OnlineManager.getInstance().send(roleid, res);
/*     */   }
/*     */   
/*     */   private static BlackRole getBlackRoleBean(long blackRoleid)
/*     */   {
/*  54 */     BlackRole bean = new BlackRole();
/*  55 */     fillBlackRoleBean(blackRoleid, bean);
/*  56 */     return bean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void fillBlackRoleBean(long blackRoleid, BlackRole blackRoleBean)
/*     */   {
/*  67 */     blackRoleBean.roleid = blackRoleid;
/*  68 */     Role role = RoleInterface.getRole(blackRoleid, false);
/*  69 */     blackRoleBean.level = role.getLevel();
/*  70 */     blackRoleBean.name = role.getName();
/*  71 */     blackRoleBean.menpai = role.getOccupationId();
/*  72 */     blackRoleBean.gender = role.getGender();
/*  73 */     blackRoleBean.status = (OnlineManager.getInstance().isOnline(blackRoleid) ? 1 : 0);
/*     */     
/*     */ 
/*  76 */     blackRoleBean.avatarid = AvatarInterface.getCurrentAvatar(blackRoleid);
/*  77 */     blackRoleBean.avatar_frame = AvatarFrameInterface.getCurrentAvatarFrameId(blackRoleid, false);
/*     */   }
/*     */   
/*     */ 
/*     */   static void sendNormalResult(long roleid, int result)
/*     */   {
/*  83 */     SBlacklistNormalResult pro = new SBlacklistNormalResult();
/*  84 */     pro.result = result;
/*  85 */     OnlineManager.getInstance().sendAtOnce(roleid, pro);
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
/*     */   static boolean isInBlacklist(long roleid, long targetRole)
/*     */   {
/*  98 */     xbean.Blacklist xBlacklist = xtable.Blacklist.select(Long.valueOf(roleid));
/*  99 */     if (xBlacklist == null) {
/* 100 */       return false;
/*     */     }
/* 102 */     return xBlacklist.getList().contains(Long.valueOf(targetRole));
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
/*     */   static boolean delBlackRole(long roleid, long targetRole)
/*     */   {
/* 115 */     xbean.Blacklist xBlacklist = xtable.Blacklist.get(Long.valueOf(roleid));
/* 116 */     if (xBlacklist == null) {
/* 117 */       return false;
/*     */     }
/* 119 */     boolean ret = xBlacklist.getList().remove(Long.valueOf(targetRole));
/* 120 */     if (ret) {
/* 121 */       syncDelBlackRole(roleid, targetRole);
/*     */     }
/* 123 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */   static void syncDelBlackRole(long roleid, long targetRole)
/*     */   {
/* 129 */     SDelBlackRoleRes res = new SDelBlackRoleRes();
/* 130 */     res.del_roleid = targetRole;
/* 131 */     OnlineManager.getInstance().send(roleid, res);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\blacklist\main\BlacklistManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */