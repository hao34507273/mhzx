/*     */ package mzm.gsp.magicmark.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.confbean.SMagicMarkItemCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.magicmark.confbean.SMagicMarkConsts;
/*     */ import mzm.gsp.magicmark.confbean.SMagicMarkTypeCfg;
/*     */ import mzm.gsp.magicmark.event.MagicMarkModelChangeEvent;
/*     */ import mzm.gsp.magicmark.event.MagicMarkPassiveSkillChangeEvent;
/*     */ import mzm.gsp.magicmark.event.MagicMarkTypeUpdateArg;
/*     */ import mzm.gsp.magicmark.event.MagicMarkTypeUpdateEvent;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.MagicMarkInfo;
/*     */ import xbean.MagicMarkSys;
/*     */ import xtable.Role2magicmark;
/*     */ 
/*     */ class MagicMarkManager
/*     */ {
/*     */   static final int LOG_MAGIC_MARK_UNLOCK = 1;
/*     */   static final int LOG_MAGIC_MARK_EQUIP = 2;
/*     */   static final int LOG_MAGIC_MARK_UNEQUIP = 3;
/*     */   static final int LOG_MAGIC_MARK_EXTEND = 4;
/*     */   static final int LOG_MAGIC_MARK_OUT_OF_DATE = 5;
/*     */   static final int LOG_MAGIC_MARK_SELECT_PROP = 6;
/*     */   static final int LOG_MAGIC_MARK_UNSELECT_PROP = 7;
/*     */   
/*     */   static MagicMarkSys getXMagicMarkSys(long roleid, boolean retainLock)
/*     */   {
/*  37 */     if (retainLock) {
/*  38 */       return Role2magicmark.get(Long.valueOf(roleid));
/*     */     }
/*  40 */     return Role2magicmark.select(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */   static MagicMarkSys getXMagicMarkSysCreateIfNotExist(long roleid)
/*     */   {
/*  45 */     MagicMarkSys xMagicMarkSys = Role2magicmark.get(Long.valueOf(roleid));
/*  46 */     if (xMagicMarkSys == null) {
/*  47 */       xMagicMarkSys = xbean.Pod.newMagicMarkSys();
/*  48 */       Role2magicmark.insert(Long.valueOf(roleid), xMagicMarkSys);
/*     */     }
/*  50 */     return xMagicMarkSys;
/*     */   }
/*     */   
/*     */   static boolean isOpenLevel(long roleid) {
/*  54 */     int level = RoleInterface.getLevel(roleid);
/*  55 */     return level >= SMagicMarkConsts.getInstance().MAGIC_MARK_OPEN_LEVEL;
/*     */   }
/*     */   
/*     */   static boolean handleExtendOrUnLockResult(long roleid, MagicMarkExtendResult magicMarkExtendResult, MagicMarkInfo xMagicMarkInfo, List<Integer> magicMarkItems, TLogArg logArg)
/*     */   {
/*  60 */     if (magicMarkExtendResult.foreverItemid > 0) {
/*  61 */       boolean ret = ItemInterface.removeItemById(roleid, magicMarkExtendResult.foreverItemid, 1, logArg);
/*  62 */       if (!ret) {
/*  63 */         return false;
/*     */       }
/*     */       
/*  66 */       xMagicMarkInfo.setExpiredtime(-1L);
/*  67 */       MagicMarkSessionManager.remRoleSession(roleid, magicMarkExtendResult.magicMarkType);
/*  68 */       return true;
/*     */     }
/*  70 */     for (Iterator i$ = magicMarkItems.iterator(); i$.hasNext();) { int itemid = ((Integer)i$.next()).intValue();
/*  71 */       boolean ret = ItemInterface.removeItemById(roleid, itemid, 1, logArg);
/*  72 */       if (!ret) {
/*  73 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  77 */     long startTime = xMagicMarkInfo.getExpiredtime();
/*  78 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  79 */     if (startTime < curTime) {
/*  80 */       startTime = curTime;
/*     */     }
/*  82 */     xMagicMarkInfo.setExpiredtime(startTime + magicMarkExtendResult.hours * 3600000L);
/*  83 */     MagicMarkSessionManager.addRoleSession(roleid, magicMarkExtendResult.magicMarkType, xMagicMarkInfo.getExpiredtime());
/*     */     
/*  85 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isMargicMarkAvailable(MagicMarkInfo xMagicMarkInfo)
/*     */   {
/*  90 */     if (xMagicMarkInfo == null) {
/*  91 */       return false;
/*     */     }
/*  93 */     if (xMagicMarkInfo.getExpiredtime() < 0L)
/*  94 */       return true;
/*  95 */     if (xMagicMarkInfo.getExpiredtime() <= DateTimeUtils.getCurrTimeInMillis()) {
/*  96 */       return false;
/*     */     }
/*  98 */     return true;
/*     */   }
/*     */   
/*     */   static MagicMarkExtendResult checkAndGetMagicMarkExtendOrUnLockResult(List<Integer> magicMarkItems)
/*     */   {
/* 103 */     int magicMarkType = 0;
/* 104 */     int foreverItemid = 0;
/* 105 */     int hours = 0;
/* 106 */     for (Iterator i$ = magicMarkItems.iterator(); i$.hasNext();) { int magicMarkItemid = ((Integer)i$.next()).intValue();
/* 107 */       SMagicMarkItemCfg magicMarkItemCfg = SMagicMarkItemCfg.get(magicMarkItemid);
/* 108 */       if (magicMarkItemCfg == null) {
/* 109 */         return new MagicMarkExtendResult(false);
/*     */       }
/* 111 */       if (magicMarkType == 0) {
/* 112 */         magicMarkType = magicMarkItemCfg.magicType;
/* 113 */       } else if (magicMarkType != magicMarkItemCfg.magicType) {
/* 114 */         return new MagicMarkExtendResult(false);
/*     */       }
/* 116 */       if (magicMarkItemCfg.lastHour < 0) {
/* 117 */         foreverItemid = magicMarkItemCfg.id;
/*     */       } else {
/* 119 */         hours += magicMarkItemCfg.lastHour;
/*     */       }
/*     */     }
/* 122 */     return new MagicMarkExtendResult(magicMarkType, foreverItemid, hours);
/*     */   }
/*     */   
/*     */   static void onMagicMarkOutOfDate(long roleid, MagicMarkSys xMagicMarkSys, int magicMarkType, long expiredTime) {
/* 126 */     if (xMagicMarkSys.getEuqipedmagicmarktype() == magicMarkType) {
/* 127 */       xMagicMarkSys.setEuqipedmagicmarktype(0);
/* 128 */       MagicMarkModelChangeEvent magicMarkModelChangeEvent = new MagicMarkModelChangeEvent();
/* 129 */       TriggerEventsManger.getInstance().triggerEvent(magicMarkModelChangeEvent, Long.valueOf(roleid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*     */       
/* 131 */       tlogMagicMark(roleid, magicMarkType, 3, expiredTime);
/*     */     }
/* 133 */     if (xMagicMarkSys.getPropmagicmarktype() == magicMarkType) {
/* 134 */       xMagicMarkSys.setPropmagicmarktype(0);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 140 */       tlogMagicMark(roleid, magicMarkType, 7, expiredTime);
/*     */     }
/* 142 */     List<String> titleArgs = null;
/* 143 */     List<String> contentArgs = new java.util.ArrayList();
/* 144 */     SMagicMarkTypeCfg magicMarkTypeCfg = SMagicMarkTypeCfg.get(magicMarkType);
/* 145 */     if (magicMarkTypeCfg != null) {
/* 146 */       contentArgs.add(magicMarkTypeCfg.magicMarkName);
/*     */     } else {
/* 148 */       GameServer.logger().warn(String.format("[MagicMark]MagicMarkManager.onMagicMarkOutOfDate@magicMark type is not exist|type=%d|roleid=%d", new Object[] { Integer.valueOf(magicMarkType), Long.valueOf(roleid) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 155 */     mzm.gsp.mail.main.MailInterface.synBuildAndSendMail(roleid, SMagicMarkConsts.getInstance().OUT_DATE_MAIL_ID, titleArgs, contentArgs, new TLogArg(mzm.gsp.tlog.LogReason.MAGIC_MARK_OUT_OF_DATE_MAIL));
/*     */     
/* 157 */     tlogMagicMark(roleid, magicMarkType, 5, expiredTime);
/*     */     
/*     */ 
/* 160 */     MagicMarkTypeUpdateEvent updateEvent = new MagicMarkTypeUpdateEvent();
/* 161 */     TriggerEventsManger.getInstance().triggerEvent(updateEvent, new MagicMarkTypeUpdateArg(roleid, magicMarkType, 1));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 166 */     MagicMarkPassiveSkillChangeEvent magicMarkPassiveSkillChangeEvent = new MagicMarkPassiveSkillChangeEvent();
/* 167 */     TriggerEventsManger.getInstance().triggerEvent(magicMarkPassiveSkillChangeEvent, Long.valueOf(roleid), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleid)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkMutexStatus(long roleId)
/*     */   {
/* 175 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleId, 821, true)) {
/* 176 */       GameServer.logger().error(String.format("[MagicMark]MagicMarkManager.checkMutexStatus@contains mutex state|role_id=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/*     */ 
/* 179 */       return false;
/*     */     }
/* 181 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int removeMagicMarkByItem(long roleId, int itemId)
/*     */   {
/* 191 */     SMagicMarkItemCfg itemCfg = SMagicMarkItemCfg.get(itemId);
/* 192 */     if (itemCfg == null)
/*     */     {
/* 194 */       return -1;
/*     */     }
/* 196 */     MagicMarkSys xMagicMarkSys = Role2magicmark.get(Long.valueOf(roleId));
/* 197 */     if (xMagicMarkSys == null)
/*     */     {
/* 199 */       return -1;
/*     */     }
/* 201 */     MagicMarkInfo xMagicMarkInfo = (MagicMarkInfo)xMagicMarkSys.getMagicmarkinfos().get(Integer.valueOf(itemCfg.magicType));
/* 202 */     if (xMagicMarkInfo == null)
/*     */     {
/* 204 */       return -1;
/*     */     }
/*     */     boolean changeExpireTimeOnly;
/*     */     boolean changeExpireTimeOnly;
/* 208 */     if (itemCfg.lastHour != -1)
/*     */     {
/* 210 */       long newExpireTime = xMagicMarkInfo.getExpiredtime() - itemCfg.lastHour * 3600000L;
/* 211 */       changeExpireTimeOnly = newExpireTime > DateTimeUtils.getCurrTimeInMillis();
/*     */     }
/*     */     else
/*     */     {
/* 215 */       changeExpireTimeOnly = false;
/*     */     }
/*     */     
/* 218 */     if (changeExpireTimeOnly)
/*     */     {
/* 220 */       long newExpireTime = xMagicMarkInfo.getExpiredtime() - itemCfg.lastHour * 3600000L;
/* 221 */       xMagicMarkInfo.setExpiredtime(newExpireTime);
/* 222 */       MagicMarkSessionManager.addRoleSession(roleId, itemCfg.magicType, newExpireTime);
/*     */     }
/*     */     else
/*     */     {
/* 226 */       xMagicMarkSys.getMagicmarkinfos().remove(Integer.valueOf(itemCfg.magicType));
/* 227 */       MagicMarkTypeUpdateArg updateArg = new MagicMarkTypeUpdateArg(roleId, itemCfg.magicType, 3);
/*     */       
/* 229 */       TriggerEventsManger.getInstance().triggerEvent(new MagicMarkTypeUpdateEvent(), updateArg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */       
/*     */ 
/* 232 */       if (xMagicMarkSys.getEuqipedmagicmarktype() == itemCfg.magicType)
/*     */       {
/* 234 */         xMagicMarkSys.setEuqipedmagicmarktype(0);
/* 235 */         TriggerEventsManger.getInstance().triggerEvent(new MagicMarkModelChangeEvent(), Long.valueOf(roleId), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */       }
/*     */       
/* 238 */       if (xMagicMarkSys.getPropmagicmarktype() == itemCfg.magicType)
/*     */       {
/* 240 */         xMagicMarkSys.setPropmagicmarktype(0);
/* 241 */         TriggerEventsManger.getInstance().triggerEvent(new MagicMarkPassiveSkillChangeEvent(), Long.valueOf(roleId), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 246 */     int cutDuration = changeExpireTimeOnly ? itemCfg.lastHour : 0;
/* 247 */     tlogRemoveMagicMark(roleId, itemCfg.magicType, cutDuration);
/* 248 */     OnlineManager.getInstance().forceReconnect(roleId);
/* 249 */     return cutDuration;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogMagicMark(long roleid, int magicMarkType, int operator, long expriedTime)
/*     */   {
/* 269 */     String userid = RoleInterface.getUserId(roleid);
/* 270 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/*     */ 
/* 273 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { mzm.gsp.GameServerInfoManager.getHostIP(), userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(magicMarkType), Integer.valueOf(operator), Long.valueOf(expriedTime) });
/*     */     
/* 275 */     TLogManager.getInstance().addLog(roleid, "MagicMark", logStr);
/*     */   }
/*     */   
/*     */   static void tlogRemoveMagicMark(long roleId, int magicMarkType, int duration)
/*     */   {
/* 280 */     String userId = RoleInterface.getUserId(roleId);
/* 281 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 282 */     TLogManager.getInstance().addLog(roleId, "RemoveMagicMark", new Object[] { mzm.gsp.GameServerInfoManager.getHostIP(), userId, Long.valueOf(roleId), Integer.valueOf(roleLevel), Integer.valueOf(magicMarkType), Integer.valueOf(duration) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\MagicMarkManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */