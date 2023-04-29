/*     */ package mzm.gsp.online.main;
/*     */ 
/*     */ import gnet.link.Onlines;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.chat.confbean.ReportConsts;
/*     */ import mzm.gsp.idip.SIdipBanRoleAddFriend;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.confbean.SServerTextCfg;
/*     */ import xbean.ForbidInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.ReportedInfo;
/*     */ import xdb.Procedure;
/*     */ import xtable.Roleforbid;
/*     */ import xtable.Rolefriendforbid;
/*     */ import xtable.Roletalkforbid;
/*     */ import xtable.Userforbid;
/*     */ import xtable.Userfriendforbid;
/*     */ 
/*     */ public class ForbidInfoManager
/*     */ {
/*  33 */   private static final java.util.Set<String> forbiddenChannels = java.util.Collections.synchronizedSet(new java.util.HashSet());
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final boolean containsForbiddenChannel(String channelName)
/*     */   {
/*  45 */     return forbiddenChannels.contains(channelName);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final boolean addForbiddenChannel(String channelName)
/*     */   {
/*  57 */     return forbiddenChannels.add(channelName);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final boolean removeForbiddenChannel(String channelName)
/*     */   {
/*  69 */     return forbiddenChannels.remove(channelName);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isUserForbid(String userid)
/*     */   {
/*  81 */     long currTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  82 */     ForbidInfo forbidInfo = Userforbid.get(userid);
/*  83 */     if (forbidInfo == null)
/*     */     {
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     if (forbidInfo.getExpiretime() <= currTimeMillis)
/*     */     {
/*     */ 
/*  92 */       forbidInfo = null;
/*  93 */       Userforbid.remove(userid);
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  98 */     return true;
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
/*     */   public static boolean isRoleForbid(long roleid)
/*     */   {
/* 111 */     if (getRoleForbideTime(roleid) > 0L)
/*     */     {
/* 113 */       return true;
/*     */     }
/* 115 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getRoleForbideTime(long roleid)
/*     */   {
/* 126 */     long currTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 127 */     ForbidInfo forbidInfo = Roleforbid.get(Long.valueOf(roleid));
/* 128 */     if (forbidInfo == null)
/*     */     {
/* 130 */       return -1L;
/*     */     }
/*     */     
/*     */ 
/* 134 */     if (forbidInfo.getExpiretime() <= currTimeMillis)
/*     */     {
/*     */ 
/* 137 */       forbidInfo = null;
/* 138 */       Roleforbid.remove(Long.valueOf(roleid));
/* 139 */       return -1L;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 144 */     return forbidInfo.getExpiretime() - forbidInfo.getStarttime();
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
/*     */   public static long getRoleForbideEndTime(long roleid)
/*     */   {
/* 158 */     ForbidInfo forbidInfo = Roleforbid.select(Long.valueOf(roleid));
/* 159 */     if (forbidInfo == null)
/*     */     {
/* 161 */       return 0L;
/*     */     }
/*     */     
/*     */ 
/* 165 */     if (forbidInfo.getExpiretime() < DateTimeUtils.getCurrTimeInMillis())
/*     */     {
/* 167 */       return 0L;
/*     */     }
/* 169 */     return forbidInfo.getExpiretime();
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
/*     */   public static void forbidRole(long roleId, long periodSec, String reason)
/*     */   {
/* 186 */     ForbidInfo xforbidden = Roleforbid.get(Long.valueOf(roleId));
/* 187 */     if (xforbidden == null)
/*     */     {
/* 189 */       xforbidden = Pod.newForbidInfo();
/* 190 */       Roleforbid.add(Long.valueOf(roleId), xforbidden);
/*     */     }
/* 192 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 193 */     xforbidden.setExpiretime(TimeUnit.SECONDS.toMillis(periodSec) + now);
/* 194 */     xforbidden.setStarttime(now);
/* 195 */     xforbidden.setReason(reason);
/* 196 */     Onlines.getInstance().kick(Long.valueOf(roleId), 2049);
/*     */     
/* 198 */     broadcastForbidRole(roleId, reason, xforbidden.getExpiretime());
/* 199 */     sendForbidRoleFeedbackMail(roleId, xforbidden.getExpiretime());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void unforbidRole(long roleId)
/*     */   {
/* 210 */     Roleforbid.remove(Long.valueOf(roleId));
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
/*     */   public static void forbidTalk(long roleId, long periodSec, String reason)
/*     */   {
/* 224 */     ForbidInfo xforbidden = Roletalkforbid.get(Long.valueOf(roleId));
/* 225 */     if (xforbidden == null)
/*     */     {
/* 227 */       xforbidden = Pod.newForbidInfo();
/* 228 */       Roletalkforbid.add(Long.valueOf(roleId), xforbidden);
/*     */     }
/* 230 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 231 */     xforbidden.setExpiretime(TimeUnit.SECONDS.toMillis(periodSec) + now);
/* 232 */     xforbidden.setStarttime(now);
/* 233 */     xforbidden.setReason(reason);
/*     */     
/* 235 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.online.event.PlayerForbidTalk(), Long.valueOf(roleId), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */     
/*     */ 
/* 238 */     broadcastForbidTalk(roleId, reason, xforbidden.getExpiretime());
/* 239 */     sendForbidTalkFeedbackMail(roleId, xforbidden.getExpiretime());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void unforbidTalk(long roleId)
/*     */   {
/* 250 */     Roletalkforbid.remove(Long.valueOf(roleId));
/*     */     
/* 252 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.online.event.PlayerUnForbidTalk(), Long.valueOf(roleId), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isForbidTalk(long roleId)
/*     */   {
/* 264 */     ForbidInfo xforbidden = Roletalkforbid.select(Long.valueOf(roleId));
/* 265 */     if (xforbidden == null)
/*     */     {
/* 267 */       return false;
/*     */     }
/* 269 */     if (xforbidden.getExpiretime() < DateTimeUtils.getCurrTimeInMillis())
/*     */     {
/* 271 */       Procedure.execute(new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 277 */           Roleforbid.remove(Long.valueOf(this.val$roleId));
/* 278 */           return true;
/*     */         }
/* 280 */       });
/* 281 */       return false;
/*     */     }
/* 283 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getFirbidTalkTime(long roleId)
/*     */   {
/* 294 */     ForbidInfo xforbidden = Roletalkforbid.select(Long.valueOf(roleId));
/* 295 */     if (xforbidden == null)
/*     */     {
/* 297 */       return 0L;
/*     */     }
/* 299 */     if (xforbidden.getExpiretime() < DateTimeUtils.getCurrTimeInMillis())
/*     */     {
/* 301 */       return 0L;
/*     */     }
/* 303 */     return xforbidden.getExpiretime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getFirbidRoleTime(long roleId)
/*     */   {
/* 314 */     ForbidInfo xforbidden = Roleforbid.select(Long.valueOf(roleId));
/* 315 */     if (xforbidden == null)
/*     */     {
/* 317 */       return 0L;
/*     */     }
/* 319 */     if (xforbidden.getExpiretime() < DateTimeUtils.getCurrTimeInMillis())
/*     */     {
/* 321 */       return 0L;
/*     */     }
/* 323 */     return xforbidden.getExpiretime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getFirbidTalkReason(long roleId)
/*     */   {
/* 334 */     ForbidInfo xforbidden = Roletalkforbid.select(Long.valueOf(roleId));
/* 335 */     if (xforbidden == null)
/*     */     {
/* 337 */       return null;
/*     */     }
/* 339 */     return xforbidden.getReason();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getFirbidRoleReason(long roleId)
/*     */   {
/* 351 */     ForbidInfo xforbidden = Roleforbid.select(Long.valueOf(roleId));
/* 352 */     if (xforbidden == null)
/*     */     {
/* 354 */       return null;
/*     */     }
/* 356 */     return xforbidden.getReason();
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
/*     */   public static void forbidUser(String userId, int second, String reason)
/*     */   {
/* 369 */     forbidUser(userId, second, reason, 2049, true);
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
/*     */   public static void forbidUser(String userId, int second, String reason, int reasonid)
/*     */   {
/* 383 */     forbidUser(userId, second, reason, reasonid, true);
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
/*     */   public static void forbidUser(String userId, int second, String reason, int reasonid, boolean send)
/*     */   {
/* 399 */     ForbidInfo xForbidInfo = Userforbid.get(userId);
/* 400 */     if (xForbidInfo == null)
/*     */     {
/* 402 */       xForbidInfo = Pod.newForbidInfo();
/* 403 */       Userforbid.add(userId, xForbidInfo);
/*     */     }
/* 405 */     xForbidInfo.setReason(reason);
/*     */     
/* 407 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 408 */     xForbidInfo.setStarttime(now);
/* 409 */     xForbidInfo.setExpiretime(now + TimeUnit.SECONDS.toMillis(second));
/*     */     
/*     */ 
/* 412 */     Long roleId = Onlines.getInstance().getRoleid(userId);
/* 413 */     if (roleId != null)
/*     */     {
/* 415 */       Onlines.getInstance().kick(roleId, reasonid);
/*     */     }
/* 417 */     if (send)
/*     */     {
/* 419 */       broadcastForbidUser(userId, reason, xForbidInfo.getExpiretime());
/* 420 */       asyncSendForbidUserFeedbackMail(userId, xForbidInfo.getExpiretime());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void unforbidUser(String userId)
/*     */   {
/* 432 */     Userforbid.remove(userId);
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
/*     */   public static void forbidFriend(long roleId, long periodSec, String reason)
/*     */   {
/* 447 */     ForbidInfo xforbidden = Rolefriendforbid.get(Long.valueOf(roleId));
/* 448 */     if (xforbidden == null)
/*     */     {
/* 450 */       xforbidden = Pod.newForbidInfo();
/* 451 */       Rolefriendforbid.add(Long.valueOf(roleId), xforbidden);
/*     */     }
/* 453 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 454 */     xforbidden.setExpiretime(TimeUnit.SECONDS.toMillis(periodSec) + now);
/* 455 */     xforbidden.setStarttime(now);
/* 456 */     xforbidden.setReason(reason);
/* 457 */     sendForbidFriendMsg(roleId, xforbidden.getExpiretime(), reason);
/*     */   }
/*     */   
/*     */   public static void sendForbidFriendMsg(long roleid, long expiretime, String reason)
/*     */   {
/* 462 */     SIdipBanRoleAddFriend banRoleAddFriend = new SIdipBanRoleAddFriend();
/* 463 */     banRoleAddFriend.unbantime = (expiretime / 1000L);
/*     */     try
/*     */     {
/* 466 */       banRoleAddFriend.reason.setString(reason, "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/* 472 */     OnlineManager.getInstance().sendAtOnce(roleid, banRoleAddFriend);
/*     */   }
/*     */   
/*     */   public static void sendForbidFriendMsg(String userid, long expiretime, String reason)
/*     */   {
/* 477 */     SIdipBanRoleAddFriend banRoleAddFriend = new SIdipBanRoleAddFriend();
/* 478 */     banRoleAddFriend.unbantime = (expiretime / 1000L);
/*     */     try
/*     */     {
/* 481 */       banRoleAddFriend.reason.setString(reason, "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/* 487 */     OnlineManager.getInstance().sendAtOnce(userid, banRoleAddFriend);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void unforbidFriend(long roleId)
/*     */   {
/* 499 */     Rolefriendforbid.remove(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isForbidFriend(long roleId)
/*     */   {
/* 510 */     ForbidInfo xforbidden = Rolefriendforbid.select(Long.valueOf(roleId));
/* 511 */     if (xforbidden == null)
/*     */     {
/* 513 */       return false;
/*     */     }
/* 515 */     if (xforbidden.getExpiretime() < DateTimeUtils.getCurrTimeInMillis())
/*     */     {
/* 517 */       Procedure.execute(new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 523 */           Rolefriendforbid.remove(Long.valueOf(this.val$roleId));
/* 524 */           return true;
/*     */         }
/* 526 */       });
/* 527 */       return false;
/*     */     }
/* 529 */     sendForbidFriendMsg(roleId, xforbidden.getExpiretime(), xforbidden.getReason());
/* 530 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getFirbidFriendTime(long roleId)
/*     */   {
/* 541 */     ForbidInfo xforbidden = Rolefriendforbid.select(Long.valueOf(roleId));
/* 542 */     if (xforbidden == null)
/*     */     {
/* 544 */       return 0L;
/*     */     }
/* 546 */     if (xforbidden.getExpiretime() < DateTimeUtils.getCurrTimeInMillis())
/*     */     {
/* 548 */       Procedure.execute(new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 554 */           Rolefriendforbid.remove(Long.valueOf(this.val$roleId));
/* 555 */           return true;
/*     */         }
/* 557 */       });
/* 558 */       return 0L;
/*     */     }
/* 560 */     return xforbidden.getExpiretime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getFirbidFriendReason(long roleId)
/*     */   {
/* 571 */     ForbidInfo xforbidden = Rolefriendforbid.select(Long.valueOf(roleId));
/* 572 */     if (xforbidden == null)
/*     */     {
/* 574 */       return null;
/*     */     }
/* 576 */     return xforbidden.getReason();
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
/*     */   public static void forbidUserFriend(String userid, long periodSec, String reason)
/*     */   {
/* 591 */     ForbidInfo xforbidden = Userfriendforbid.get(userid);
/* 592 */     if (xforbidden == null)
/*     */     {
/* 594 */       xforbidden = Pod.newForbidInfo();
/* 595 */       Userfriendforbid.add(userid, xforbidden);
/*     */     }
/* 597 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 598 */     xforbidden.setExpiretime(TimeUnit.SECONDS.toMillis(periodSec) + now);
/* 599 */     xforbidden.setStarttime(now);
/* 600 */     xforbidden.setReason(reason);
/* 601 */     sendForbidFriendMsg(userid, xforbidden.getExpiretime(), reason);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void unforbidUserFriend(String userid)
/*     */   {
/* 613 */     Userfriendforbid.remove(userid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isForbidUserFriend(String userid)
/*     */   {
/* 625 */     ForbidInfo xforbidden = Userfriendforbid.select(userid);
/* 626 */     if (xforbidden == null)
/*     */     {
/* 628 */       return false;
/*     */     }
/* 630 */     if (xforbidden.getExpiretime() < DateTimeUtils.getCurrTimeInMillis())
/*     */     {
/* 632 */       Procedure.execute(new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 638 */           Userfriendforbid.remove(this.val$userid);
/* 639 */           return true;
/*     */         }
/* 641 */       });
/* 642 */       return false;
/*     */     }
/* 644 */     sendForbidFriendMsg(userid, xforbidden.getExpiretime(), xforbidden.getReason());
/* 645 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getFirbidUserFriendTime(String userid)
/*     */   {
/* 656 */     ForbidInfo xforbidden = Userfriendforbid.select(userid);
/* 657 */     if (xforbidden == null)
/*     */     {
/* 659 */       return 0L;
/*     */     }
/* 661 */     if (xforbidden.getExpiretime() < DateTimeUtils.getCurrTimeInMillis())
/*     */     {
/* 663 */       Procedure.execute(new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 669 */           Userfriendforbid.remove(this.val$userid);
/* 670 */           return true;
/*     */         }
/* 672 */       });
/* 673 */       return 0L;
/*     */     }
/* 675 */     return xforbidden.getExpiretime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getFirbidUserFriendReason(String userid)
/*     */   {
/* 686 */     ForbidInfo xforbidden = Userfriendforbid.select(userid);
/* 687 */     if (xforbidden == null)
/*     */     {
/* 689 */       return null;
/*     */     }
/* 691 */     return xforbidden.getReason();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static List<String> getSeparatedTimeUnits(int timestamp)
/*     */   {
/* 699 */     String str = DateTimeUtils.formatTimestamp(timestamp * 1000L);
/* 700 */     List<String> list = new ArrayList(6);
/* 701 */     list.add(str.substring(0, 4));
/* 702 */     list.add(str.substring(4, 6));
/* 703 */     list.add(str.substring(6, 8));
/* 704 */     list.add(str.substring(8, 10));
/* 705 */     list.add(str.substring(10, 12));
/* 706 */     list.add(str.substring(12, 14));
/* 707 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void broadcastForbidTalk(long roleId, String reason, long expireTimeInMillis)
/*     */   {
/* 715 */     if (!OpenInterface.getOpenStatus(496))
/* 716 */       return;
/* 717 */     SServerTextCfg textCfg = SServerTextCfg.get(ReportConsts.getInstance().FORBID_TALK_SYSTEM_NOTICE_SERVER_TEXT_ID);
/* 718 */     if (textCfg == null) {
/* 719 */       return;
/*     */     }
/* 721 */     String roleName = RoleInterface.getName(roleId);
/* 722 */     if (roleName == null)
/* 723 */       return;
/* 724 */     List<String> expireTimeStrings = getSeparatedTimeUnits((int)(expireTimeInMillis / 1000L));
/* 725 */     mzm.gsp.bulletin.main.BulletinInterface.sendNotice(String.format(textCfg.text, new Object[] { roleName, reason, expireTimeStrings }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void sendForbidTalkFeedbackMail(long roleId, long expireTimeInMillis)
/*     */   {
/* 733 */     if (!OpenInterface.getOpenStatus(495)) {
/* 734 */       return;
/*     */     }
/*     */     
/* 737 */     TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.MAIL_REPORT_FEEDBACK_RELATED);
/* 738 */     List<String> contentArgs = new ArrayList();
/* 739 */     contentArgs.addAll(getSeparatedTimeUnits((int)(expireTimeInMillis / 1000L)));
/* 740 */     MailInterface.asynBuildAndSendMail(roleId, ReportConsts.getInstance().FORBID_TALK_NOTIFY_MAIL_ID, null, contentArgs, tLogArg);
/*     */     
/*     */ 
/* 743 */     ReportedInfo xReportedInfo = xtable.Role2reported.get(Long.valueOf(roleId));
/* 744 */     if (xReportedInfo == null)
/* 745 */       return;
/* 746 */     int mailId = ReportConsts.getInstance().FORBID_TALK_FEEDBACK_MAIL_ID;
/* 747 */     String roleName = RoleInterface.getName(roleId);
/* 748 */     if (roleName == null)
/* 749 */       return;
/* 750 */     List<String> expireTimeStrings = getSeparatedTimeUnits((int)(expireTimeInMillis / 1000L));
/* 751 */     for (Map.Entry<Long, Integer> entry : xReportedInfo.getReport_time_map().entrySet())
/*     */     {
/*     */ 
/* 754 */       List<String> contents = new ArrayList(13);
/* 755 */       contents.addAll(getSeparatedTimeUnits(((Integer)entry.getValue()).intValue()));
/* 756 */       contents.add(roleName);
/* 757 */       contents.addAll(expireTimeStrings);
/* 758 */       MailInterface.asynBuildAndSendMail(((Long)entry.getKey()).longValue(), mailId, null, contents, tLogArg);
/*     */     }
/* 760 */     xReportedInfo.getReport_time_map().clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void broadcastForbidRole(long roleId, String reason, long expireTimeInMillis)
/*     */   {
/* 768 */     if (!OpenInterface.getOpenStatus(496))
/* 769 */       return;
/* 770 */     SServerTextCfg textCfg = SServerTextCfg.get(ReportConsts.getInstance().FORBID_ROLE_SYSTEM_NOTICE_SERVER_TEXT_ID);
/* 771 */     if (textCfg == null) {
/* 772 */       return;
/*     */     }
/* 774 */     String roleName = RoleInterface.getName(roleId);
/* 775 */     if (roleName == null)
/* 776 */       return;
/* 777 */     List<String> expireTimeStrings = getSeparatedTimeUnits((int)(expireTimeInMillis / 1000L));
/* 778 */     mzm.gsp.bulletin.main.BulletinInterface.sendNotice(String.format(textCfg.text, new Object[] { roleName, reason, expireTimeStrings }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void sendForbidRoleFeedbackMail(long roleId, long expireTimeInMillis)
/*     */   {
/* 786 */     if (!OpenInterface.getOpenStatus(495))
/* 787 */       return;
/* 788 */     ReportedInfo xReportedInfo = xtable.Role2reported.get(Long.valueOf(roleId));
/* 789 */     if (xReportedInfo == null)
/* 790 */       return;
/* 791 */     TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.MAIL_REPORT_FEEDBACK_RELATED);
/* 792 */     int mailId = ReportConsts.getInstance().FORBID_ROLE_FEEDBACK_MAIL_ID;
/* 793 */     String roleName = RoleInterface.getName(roleId);
/* 794 */     if (roleName == null)
/* 795 */       return;
/* 796 */     List<String> expireTimeStrings = getSeparatedTimeUnits((int)(expireTimeInMillis / 1000L));
/* 797 */     for (Map.Entry<Long, Integer> entry : xReportedInfo.getReport_time_map().entrySet())
/*     */     {
/*     */ 
/* 800 */       List<String> contents = new ArrayList(13);
/* 801 */       contents.addAll(getSeparatedTimeUnits(((Integer)entry.getValue()).intValue()));
/* 802 */       contents.add(roleName);
/* 803 */       contents.addAll(expireTimeStrings);
/* 804 */       MailInterface.asynBuildAndSendMail(((Long)entry.getKey()).longValue(), mailId, null, contents, tLogArg);
/*     */     }
/* 806 */     xReportedInfo.getReport_time_map().clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void broadcastForbidUser(String userId, String reason, long expireTimeInMillis)
/*     */   {
/* 814 */     if (!OpenInterface.getOpenStatus(496))
/* 815 */       return;
/* 816 */     SServerTextCfg textCfg = SServerTextCfg.get(ReportConsts.getInstance().FORBID_USER_SYSTEM_NOTICE_SERVER_TEXT_ID);
/* 817 */     if (textCfg == null) {
/* 818 */       return;
/*     */     }
/* 820 */     String openId = mzm.gsp.util.CommonUtils.getOpenId(userId);
/* 821 */     if (openId == null)
/* 822 */       return;
/* 823 */     List<String> expireTimeStrings = getSeparatedTimeUnits((int)(expireTimeInMillis / 1000L));
/* 824 */     mzm.gsp.bulletin.main.BulletinInterface.sendNotice(String.format(textCfg.text, new Object[] { openId, reason, expireTimeStrings }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void asyncSendForbidUserFeedbackMail(String userId, long expireTimeInMillis)
/*     */   {
/* 832 */     if (!OpenInterface.getOpenStatus(495))
/* 833 */       return;
/* 834 */     xbean.User xUser = xtable.User.get(userId);
/* 835 */     if (xUser == null)
/* 836 */       return;
/* 837 */     final TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.MAIL_REPORT_FEEDBACK_RELATED);
/* 838 */     final int mailId = ReportConsts.getInstance().FORBID_USER_FEEDBACK_MAIL_ID;
/* 839 */     final List<String> expireTimeStrings = getSeparatedTimeUnits((int)(expireTimeInMillis / 1000L));
/* 840 */     for (Long roleId : xUser.getRoleids())
/*     */     {
/* 842 */       RoleOneByOneManager.getInstance().addLogicProcedure(roleId, new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 847 */           String roleName = RoleInterface.getName(this.val$roleId.longValue());
/* 848 */           if (roleName == null)
/* 849 */             return false;
/* 850 */           ReportedInfo xReportedInfo = xtable.Role2reported.get(this.val$roleId);
/* 851 */           if (xReportedInfo == null)
/* 852 */             return false;
/* 853 */           for (Map.Entry<Long, Integer> entry : xReportedInfo.getReport_time_map().entrySet())
/*     */           {
/*     */ 
/* 856 */             List<String> contents = new ArrayList(13);
/* 857 */             contents.addAll(ForbidInfoManager.getSeparatedTimeUnits(((Integer)entry.getValue()).intValue()));
/* 858 */             contents.add(roleName);
/* 859 */             contents.addAll(expireTimeStrings);
/* 860 */             MailInterface.asynBuildAndSendMail(((Long)entry.getKey()).longValue(), mailId, null, contents, tLogArg);
/*     */           }
/* 862 */           xReportedInfo.getReport_time_map().clear();
/* 863 */           return true;
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\ForbidInfoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */