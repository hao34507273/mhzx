/*     */ package mzm.gsp.marriage.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.marriage.SFriendSendGift;
/*     */ import mzm.gsp.marriage.SSendGiftToFriendRes;
/*     */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*     */ import mzm.gsp.marriage.confbean.SMarriageGiftCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.PresentResult;
/*     */ import mzm.gsp.qingfu.main.PresentType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MarriageFriendInfo;
/*     */ import xtable.Role2marriage;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCSendGiftToFriend extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long friendid;
/*     */   private final int giftid;
/*     */   
/*     */   public PCSendGiftToFriend(long operatorRoleid, long friendid, int giftid)
/*     */   {
/*  33 */     this.roleid = operatorRoleid;
/*  34 */     this.friendid = friendid;
/*  35 */     this.giftid = giftid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  40 */     SMarriageGiftCfg marriageGiftCfg = SMarriageGiftCfg.get(this.giftid);
/*  41 */     if (marriageGiftCfg == null) {
/*  42 */       GameServer.logger().info(String.format("PCSendGiftToFriend.processImp@giftid not exist|giftid=%d", new Object[] { Integer.valueOf(this.giftid) }));
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     String userid = RoleInterface.getUserId(this.roleid);
/*  48 */     String friendUserid = RoleInterface.getUserId(this.friendid);
/*  49 */     lock(User.getTable(), Arrays.asList(new String[] { userid, friendUserid }));
/*     */     
/*  51 */     lock(Role2marriage.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.friendid) }));
/*  52 */     boolean isFriend = FriendInterface.isFriend(this.roleid, this.friendid, true);
/*  53 */     if (!isFriend) {
/*  54 */       GameServer.logger().info(String.format("PCSendGiftToFriend.processImp@they are not friends!", new Object[0]));
/*  55 */       return false;
/*     */     }
/*  57 */     Long marriageId = Role2marriage.get(Long.valueOf(this.friendid));
/*  58 */     if (marriageId == null) {
/*  59 */       MarriageManager.sendNormalResult(this.roleid, 60, new String[0]);
/*  60 */       return false;
/*     */     }
/*  62 */     xbean.Marriage xMarriage = xtable.Marriage.get(marriageId);
/*  63 */     if (xMarriage == null) {
/*  64 */       GameServer.logger().error(String.format("PCSendGiftToFriend.processImp@marriage date wrong|roleid=%d", new Object[] { Long.valueOf(this.friendid) }));
/*     */       
/*  66 */       return false;
/*     */     }
/*  68 */     long time = xMarriage.getMarrytime() + SMarriageConsts.getInstance().giftTime * 60000;
/*     */     
/*  70 */     if (DateTimeUtils.getCurrTimeInMillis() > time) {
/*  71 */       MarriageManager.sendNormalResult(this.roleid, 61, new String[0]);
/*  72 */       return false;
/*     */     }
/*  74 */     if (xMarriage.getRoleida() == this.friendid) {
/*  75 */       if (xMarriage.getFriendainfos().containsKey(Long.valueOf(this.roleid))) {
/*  76 */         MarriageManager.sendNormalResult(this.roleid, 62, new String[0]);
/*  77 */         return false;
/*     */       }
/*     */     }
/*  80 */     else if (xMarriage.getFriendbinfos().containsKey(Long.valueOf(this.roleid))) {
/*  81 */       MarriageManager.sendNormalResult(this.roleid, 62, new String[0]);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     switch (marriageGiftCfg.moneyType) {
/*     */     case 2: 
/*  87 */       long gold = RoleInterface.getGold(this.roleid);
/*  88 */       if (gold < marriageGiftCfg.moneyNum) {
/*  89 */         GameServer.logger().error(String.format("[Marriage]PCSendGiftToFriend.processImp@|player do not has enough glod|needNum=%d", new Object[] { Integer.valueOf(marriageGiftCfg.moneyNum) }));
/*     */         
/*     */ 
/*     */ 
/*  93 */         return false;
/*     */       }
/*  95 */       RoleInterface.cutGold(this.roleid, marriageGiftCfg.moneyNum, new TLogArg(LogReason.MARRIAGE_SEND_GIFT_COST));
/*  96 */       RoleInterface.addGold(this.friendid, marriageGiftCfg.moneyNum, new TLogArg(LogReason.MARRIAGE_GET_GIFT_ADD));
/*  97 */       break;
/*     */     case 3: 
/*  99 */       long silver = RoleInterface.getSilver(this.roleid);
/* 100 */       if (silver < marriageGiftCfg.moneyNum) {
/* 101 */         GameServer.logger().error(String.format("[Marriage]PCSendGiftToFriend.processImp@|player do not has enough silver|needNum=%d", new Object[] { Integer.valueOf(marriageGiftCfg.moneyNum) }));
/*     */         
/*     */ 
/*     */ 
/* 105 */         return false;
/*     */       }
/* 107 */       RoleInterface.cutSilver(this.roleid, marriageGiftCfg.moneyNum, new TLogArg(LogReason.MARRIAGE_SEND_GIFT_COST));
/* 108 */       RoleInterface.addSilver(this.friendid, marriageGiftCfg.moneyNum, new TLogArg(LogReason.MARRIAGE_GET_GIFT_ADD));
/* 109 */       break;
/*     */     case 1: 
/* 111 */       long yuanbao = QingfuInterface.getYuanbao(userid, true);
/* 112 */       if (yuanbao < marriageGiftCfg.moneyNum) {
/* 113 */         GameServer.logger().error(String.format("[Marriage]PCSendGiftToFriend.processImp@|player do not has enough yuanbao|needNum=%d", new Object[] { Integer.valueOf(marriageGiftCfg.moneyNum) }));
/*     */         
/*     */ 
/*     */ 
/* 117 */         return false;
/*     */       }
/* 119 */       boolean suc = QingfuInterface.costYuanbao(userid, this.roleid, marriageGiftCfg.moneyNum, CostType.COST_UNBIND_MARRIAGE_SEND_GIFT, new TLogArg(LogReason.MARRIAGE_SEND_GIFT_COST)) == mzm.gsp.qingfu.main.CostResult.Success;
/*     */       
/* 121 */       if (!suc) {
/* 122 */         return false;
/*     */       }
/* 124 */       boolean addRet = QingfuInterface.presentYuanbao(friendUserid, this.friendid, marriageGiftCfg.moneyNum, PresentType.PRSENT_BIND_MARRIAGE_RECEIVE_GIFT, new TLogArg(LogReason.MARRIAGE_GET_GIFT_ADD)) == PresentResult.Success;
/*     */       
/* 126 */       if (!addRet) {
/* 127 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     default: 
/* 132 */       GameServer.logger().error(String.format("[Marriage]PCSendGiftToFriend.processImp@|not exist moneytype|moneyType=%d", new Object[] { Integer.valueOf(marriageGiftCfg.moneyType) }));
/*     */       
/*     */ 
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     int timeSec = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*     */     
/* 140 */     SFriendSendGift sFriendSendGift = new SFriendSendGift();
/* 141 */     sFriendSendGift.giftid = this.giftid;
/* 142 */     sFriendSendGift.roleid = this.roleid;
/* 143 */     sFriendSendGift.timesec = timeSec;
/*     */     
/* 145 */     boolean isSuc = OnlineManager.getInstance().send(this.friendid, sFriendSendGift);
/*     */     
/* 147 */     MarriageFriendInfo xMarriageFriendInfo = xbean.Pod.newMarriageFriendInfo();
/* 148 */     xMarriageFriendInfo.setGiftid(this.giftid);
/* 149 */     xMarriageFriendInfo.setIsnotified(isSuc);
/* 150 */     if (xMarriage.getRoleida() == this.friendid) {
/* 151 */       xMarriage.getFriendainfos().put(Long.valueOf(this.roleid), xMarriageFriendInfo);
/*     */     } else {
/* 153 */       xMarriage.getFriendbinfos().put(Long.valueOf(this.roleid), xMarriageFriendInfo);
/*     */     }
/*     */     
/* 156 */     SSendGiftToFriendRes sendGiftToFriendRes = new SSendGiftToFriendRes();
/* 157 */     sendGiftToFriendRes.giftid = this.giftid;
/* 158 */     sendGiftToFriendRes.roleid = this.friendid;
/* 159 */     sendGiftToFriendRes.timesec = timeSec;
/* 160 */     OnlineManager.getInstance().send(this.roleid, sendGiftToFriendRes);
/* 161 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PCSendGiftToFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */