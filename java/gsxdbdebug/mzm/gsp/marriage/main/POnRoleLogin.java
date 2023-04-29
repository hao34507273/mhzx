/*     */ package mzm.gsp.marriage.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.marriage.SForceDivorceSucRes;
/*     */ import mzm.gsp.marriage.SSendMarriageMsgToFriend;
/*     */ import mzm.gsp.marriage.SSynMarriageInfo;
/*     */ import mzm.gsp.marriage.confbean.SMarriageTitileCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarriageFriendInfo;
/*     */ import xbean.NotNotifyMarriage;
/*     */ import xtable.Role2marriageskill;
/*     */ 
/*     */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  26 */     Long marriageId = xtable.Role2marriage.select((Long)this.arg);
/*  27 */     if (marriageId != null) {
/*  28 */       boolean divorce = false;
/*  29 */       xbean.Marriage xSelectmarriage = xtable.Marriage.select(marriageId);
/*  30 */       if (xSelectmarriage == null) {
/*  31 */         GameServer.logger().error(String.format("[Marriage]POnRoleLogin.processImp@marriage date is wrong|roleid=%d", new Object[] { this.arg }));
/*     */         
/*  33 */         return false;
/*     */       }
/*     */       
/*  36 */       lock(xtable.Role2marriage.getTable(), Arrays.asList(new Long[] { Long.valueOf(xSelectmarriage.getRoleida()), Long.valueOf(xSelectmarriage.getRoleidb()) }));
/*     */       
/*  38 */       xbean.Marriage xMarriage = xtable.Marriage.get(marriageId);
/*  39 */       long otherRoleid = xMarriage.getRoleida();
/*  40 */       if (xMarriage.getRoleida() == ((Long)this.arg).longValue()) {
/*  41 */         otherRoleid = xMarriage.getRoleidb();
/*  42 */         sendFriendGiftMsg(xMarriage.getFriendainfos());
/*     */       } else {
/*  44 */         sendFriendGiftMsg(xMarriage.getFriendbinfos());
/*     */       }
/*  46 */       int titleId = xMarriage.getMarriagetitle();
/*  47 */       SMarriageTitileCfg sMarriageTitileCfg = SMarriageTitileCfg.get(xMarriage.getMarriagetitle());
/*  48 */       if (sMarriageTitileCfg == null) {
/*  49 */         GameServer.logger().error(String.format("[Marriage]POnRoleLogin.processImp@marriage title config is not exsit|cfgid=%d", new Object[] { Integer.valueOf(titleId) }));
/*     */ 
/*     */ 
/*     */       }
/*  53 */       else if (((Long)this.arg).longValue() == xMarriage.getRoleida()) {
/*  54 */         String name = RoleInterface.getName(xMarriage.getRoleidb());
/*  55 */         mzm.gsp.title.main.TitleInterface.replaceAppellationArgs(((Long)this.arg).longValue(), sMarriageTitileCfg.manTitle, Arrays.asList(new String[] { name }));
/*     */       } else {
/*  57 */         String name = RoleInterface.getName(xMarriage.getRoleida());
/*  58 */         mzm.gsp.title.main.TitleInterface.replaceAppellationArgs(((Long)this.arg).longValue(), sMarriageTitileCfg.womenTitle, Arrays.asList(new String[] { name }));
/*     */       }
/*     */       
/*     */ 
/*  62 */       if (Role2marriageskill.get((Long)this.arg) == null) {
/*  63 */         MarriageManager.initMarrySkill(((Long)this.arg).longValue(), otherRoleid);
/*     */       }
/*     */       
/*  66 */       Integer divorceValue = (Integer)xMarriage.getParammap().get(Integer.valueOf(2));
/*  67 */       if (divorceValue != null) {
/*  68 */         long divorceRoleid = xMarriage.getRoleida();
/*  69 */         if (divorceValue.intValue() == 2) {
/*  70 */           divorceRoleid = xMarriage.getRoleidb();
/*     */         }
/*  72 */         Integer sec = (Integer)xMarriage.getParammap().get(Integer.valueOf(1));
/*  73 */         if (sec == null) {
/*  74 */           GameServer.logger().error(String.format("[Marriage]POnRoleLogin.processImp@marriage divorce time data is wrong|roleid=%d", new Object[] { this.arg }));
/*     */           
/*     */ 
/*     */ 
/*  78 */           return false;
/*     */         }
/*  80 */         int endSec = sec.intValue() + mzm.gsp.marriage.confbean.SMarriageConsts.getInstance().forceDivorceHour * 3600;
/*  81 */         long curSec = DateTimeUtils.getCurrTimeInMillis() / 1000L;
/*  82 */         if (curSec > endSec) {
/*  83 */           divorce = true;
/*  84 */           MarriageManager.onForceDivorce(marriageId.longValue(), xMarriage);
/*     */           
/*  86 */           SForceDivorceSucRes sfoceDivorceSucRes = new SForceDivorceSucRes();
/*  87 */           if (((Long)this.arg).longValue() == xMarriage.getRoleida()) {
/*  88 */             OnlineManager.getInstance().send(xMarriage.getRoleidb(), sfoceDivorceSucRes);
/*     */           } else {
/*  90 */             OnlineManager.getInstance().send(xMarriage.getRoleida(), sfoceDivorceSucRes);
/*     */           }
/*     */         } else {
/*  93 */           xbean.ForcedDivorceTimer xForcedDivorceTimer = xtable.Role2forcedivorcetimer.get(Long.valueOf(divorceRoleid));
/*  94 */           if (xForcedDivorceTimer == null) {
/*  95 */             xForcedDivorceTimer = xbean.Pod.newForcedDivorceTimer();
/*  96 */             xtable.Role2forcedivorcetimer.insert(Long.valueOf(divorceRoleid), xForcedDivorceTimer);
/*  97 */             int interval = (int)Math.max(0L, endSec - curSec);
/*  98 */             ForceDivorceSession forceDivorceSession = new ForceDivorceSession(interval, divorceRoleid);
/*  99 */             xForcedDivorceTimer.setForcedivorcetimer(forceDivorceSession);
/*     */           }
/*     */         }
/*     */       }
/* 103 */       if (!divorce) {
/* 104 */         SSynMarriageInfo synMarriageInfo = new SSynMarriageInfo();
/* 105 */         MarriageManager.fillInMarriageInfo(synMarriageInfo, xSelectmarriage, otherRoleid);
/* 106 */         OnlineManager.getInstance().send(((Long)this.arg).longValue(), synMarriageInfo);
/*     */       }
/*     */     }
/*     */     else {
/* 110 */       Role2marriageskill.remove((Long)this.arg);
/*     */     }
/*     */     
/* 113 */     NotNotifyMarriage xNotifyMarriage = xtable.Role2notnotifymarriage.get((Long)this.arg);
/* 114 */     if (xNotifyMarriage != null) {
/* 115 */       for (Iterator i$ = xNotifyMarriage.getMarriageids().iterator(); i$.hasNext();) { final long marriageid = ((Long)i$.next()).longValue();
/* 116 */         mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*     */         {
/*     */           protected boolean processImp() throws Exception
/*     */           {
/* 120 */             xbean.Marriage xMarriage = xtable.Marriage.select(Long.valueOf(marriageid));
/* 121 */             if (xMarriage != null) {
/* 122 */               long roleidA = xMarriage.getRoleida();
/* 123 */               long roleidB = xMarriage.getRoleidb();
/* 124 */               if (FriendInterface.isFriend(((Long)POnRoleLogin.this.arg).longValue(), roleidA, false)) {
/* 125 */                 SSendMarriageMsgToFriend sendMarriageMsgToFriend = new SSendMarriageMsgToFriend();
/* 126 */                 sendMarriageMsgToFriend.level = xMarriage.getLevel();
/* 127 */                 sendMarriageMsgToFriend.roleid = roleidA;
/* 128 */                 sendMarriageMsgToFriend.roleidaname = RoleInterface.getName(roleidA);
/* 129 */                 sendMarriageMsgToFriend.roleidbname = RoleInterface.getName(roleidB);
/* 130 */                 sendMarriageMsgToFriend.timesec = ((int)(xMarriage.getMarrytime() / 1000L));
/* 131 */                 OnlineManager.getInstance().send(((Long)POnRoleLogin.this.arg).longValue(), sendMarriageMsgToFriend);
/*     */               }
/* 133 */               if (FriendInterface.isFriend(((Long)POnRoleLogin.this.arg).longValue(), roleidB, false)) {
/* 134 */                 SSendMarriageMsgToFriend sendMarriageMsgToFriend = new SSendMarriageMsgToFriend();
/* 135 */                 sendMarriageMsgToFriend.level = xMarriage.getLevel();
/* 136 */                 sendMarriageMsgToFriend.roleid = roleidB;
/* 137 */                 sendMarriageMsgToFriend.roleidaname = RoleInterface.getName(roleidB);
/* 138 */                 sendMarriageMsgToFriend.roleidbname = RoleInterface.getName(roleidA);
/* 139 */                 sendMarriageMsgToFriend.timesec = ((int)(xMarriage.getMarrytime() / 1000L));
/* 140 */                 OnlineManager.getInstance().send(((Long)POnRoleLogin.this.arg).longValue(), sendMarriageMsgToFriend);
/*     */               }
/*     */             }
/* 143 */             return true;
/*     */           }
/*     */         });
/*     */       }
/* 147 */       xNotifyMarriage.getMarriageids().clear();
/*     */     }
/* 149 */     return true;
/*     */   }
/*     */   
/*     */   private void sendFriendGiftMsg(Map<Long, MarriageFriendInfo> friendMap) {
/* 153 */     for (Map.Entry<Long, MarriageFriendInfo> entry : friendMap.entrySet()) {
/* 154 */       if (!((MarriageFriendInfo)entry.getValue()).getIsnotified())
/*     */       {
/*     */ 
/* 157 */         ((MarriageFriendInfo)entry.getValue()).setIsnotified(true);
/* 158 */         mzm.gsp.marriage.SFriendSendGift sFriendSendGift = new mzm.gsp.marriage.SFriendSendGift();
/* 159 */         sFriendSendGift.giftid = ((MarriageFriendInfo)entry.getValue()).getGiftid();
/* 160 */         sFriendSendGift.roleid = ((Long)entry.getKey()).longValue();
/* 161 */         sFriendSendGift.timesec = ((int)(DateTimeUtils.getCurrTimeInMillis() / 1000L));
/* 162 */         OnlineManager.getInstance().send(((Long)this.arg).longValue(), sFriendSendGift);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */