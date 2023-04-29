/*     */ package mzm.gsp.signaward.main;
/*     */ 
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.signaward.SSignPreciousNotifyLuckyLottery;
/*     */ import mzm.gsp.signaward.confbean.SGiftCode;
/*     */ import mzm.gsp.signprecious.confbean.LuckyGoldPerciousBean;
/*     */ import mzm.gsp.signprecious.confbean.SChessBoxAwardCfg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogManager;
/*     */ import xbean.Sign;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2sign;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SignAwardInterface
/*     */ {
/*     */   public static SGiftCode getSGiftCode(int cardtype, int parenttype)
/*     */   {
/*  32 */     return SignAwardManager.getSGiftCode(cardtype, parenttype);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isCardnumberUsed(long roleid, String cardnumber)
/*     */   {
/*  44 */     return SignAwardManager.isCardnumberUsed(roleid, cardnumber);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void tlogGiftcode(long roleid, int giftid, String giftcode)
/*     */   {
/*  50 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  51 */     String userid = RoleInterface.getUserId(roleid);
/*  52 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/*  54 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(giftid), giftcode };
/*  55 */     TLogManager.getInstance().addLog(roleid, "Giftcode", columnns);
/*     */   }
/*     */   
/*     */   public static void logGiftcode(String userId, long roleid, String giftcode)
/*     */   {
/*  60 */     int platform = RoleInterface.getPlatform(roleid);
/*  61 */     String channel = RoleInterface.getChannel(roleid);
/*  62 */     String mac = RoleInterface.getMac(roleid);
/*     */     
/*  64 */     Object[] columnns = { Integer.valueOf(platform), channel, mac, userId, Long.valueOf(roleid), giftcode };
/*  65 */     LogManager.getInstance().addLog("usegiftcard", columnns);
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
/*     */   public static boolean triggerLuckyPrecious(String userId, long roleId)
/*     */   {
/*  78 */     Sign xSign = Role2sign.get(Long.valueOf(roleId));
/*  79 */     if (xSign == null)
/*     */     {
/*  81 */       SignAwardManager.sendErrorProtocal(roleId, 14);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     int xLuckyPreciousBoxBuffId = xSign.getLucky_box_sign_box_buff_id();
/*  86 */     if (xLuckyPreciousBoxBuffId > 0)
/*     */     {
/*  88 */       BuffInterface.installBuff(roleId, xLuckyPreciousBoxBuffId);
/*  89 */       xSign.setLucky_box_sign_box_buff_id(0);
/*  90 */       xSign.setLucky_box_gold_precious_cfg_id(0);
/*  91 */       SignAwardManager.sendSSignInRes(roleId, xSign, DateTimeUtils.getCurrTimeInMillis(), 0, 0);
/*  92 */       return true;
/*     */     }
/*     */     
/*  95 */     int xSignPreciousBoxBuffId = xSign.getCurrent_precious_box_buff_id();
/*  96 */     if (xSignPreciousBoxBuffId > 0)
/*     */     {
/*  98 */       BuffInterface.installBuff(roleId, xSignPreciousBoxBuffId);
/*  99 */       xSign.setCurrent_precious_box_buff_id(0);
/* 100 */       SignAwardManager.sendSSignInRes(roleId, xSign, DateTimeUtils.getCurrTimeInMillis(), 0, 0);
/*     */     }
/*     */     
/*     */ 
/* 104 */     int currentPreciousCellNum = xSign.getCurrent_precious_cell_num();
/* 105 */     SChessBoxAwardCfg sChessBoxAwardCfg = SChessBoxAwardCfg.get(currentPreciousCellNum);
/* 106 */     if (sChessBoxAwardCfg == null)
/*     */     {
/* 108 */       return true;
/*     */     }
/*     */     
/* 111 */     int randomTriggerLuckyResult = Xdb.random().nextInt(CommonUtils.WAN_PERCENT);
/* 112 */     if (xSign.getBox_sign_award_state() == 3)
/*     */     {
/* 114 */       xSign.setBox_sign_award_state(2);
/* 115 */       if (randomTriggerLuckyResult >= sChessBoxAwardCfg.normal_arrive_lucky_rate)
/*     */       {
/* 117 */         return true;
/*     */       }
/* 119 */       tlogTriggerLuckyBox(userId, roleId, 1);
/*     */     }
/* 121 */     else if (xSign.getBox_sign_award_state() == 4)
/*     */     {
/* 123 */       xSign.setBox_sign_award_state(2);
/* 124 */       if (randomTriggerLuckyResult >= sChessBoxAwardCfg.yuan_bao_arrive_lucky_rate)
/*     */       {
/* 126 */         return true;
/*     */       }
/* 128 */       tlogTriggerLuckyBox(userId, roleId, 2);
/*     */     }
/* 130 */     else if (xSign.getBox_sign_award_state() == 1)
/*     */     {
/* 132 */       xSign.setBox_sign_award_state(2);
/* 133 */       tlogTriggerLuckyBox(userId, roleId, 0);
/*     */     }
/*     */     
/* 136 */     TreeMap<Integer, LuckyGoldPerciousBean> luckyGoldPerciousBeanMap = sChessBoxAwardCfg.lucky_gold_percious_random_map;
/*     */     
/* 138 */     int randomLuckyGoldPreciousResult = Xdb.random().nextInt(CommonUtils.WAN_PERCENT);
/*     */     
/* 140 */     Map.Entry<Integer, LuckyGoldPerciousBean> entry = luckyGoldPerciousBeanMap.ceilingEntry(Integer.valueOf(randomLuckyGoldPreciousResult));
/* 141 */     if (entry == null)
/*     */     {
/* 143 */       SignAwardManager.sendErrorProtocal(roleId, 25);
/* 144 */       return false;
/*     */     }
/*     */     
/* 147 */     LuckyGoldPerciousBean luckyGoldPerciousBean = (LuckyGoldPerciousBean)entry.getValue();
/* 148 */     xSign.setLucky_box_gold_precious_cfg_id(luckyGoldPerciousBean.lucky_gold_precious_cfg_id);
/*     */     
/* 150 */     SSignPreciousNotifyLuckyLottery notifyLuckyLottery = new SSignPreciousNotifyLuckyLottery();
/* 151 */     notifyLuckyLottery.box_type = luckyGoldPerciousBean.box_award_type;
/* 152 */     notifyLuckyLottery.cost_yuan_bao = luckyGoldPerciousBean.cost_yuan_bao;
/* 153 */     notifyLuckyLottery.precious_box_cfg_id = luckyGoldPerciousBean.lucky_gold_precious_cfg_id;
/*     */     
/* 155 */     OnlineManager.getInstance().send(roleId, notifyLuckyLottery);
/*     */     
/* 157 */     return true;
/*     */   }
/*     */   
/*     */   private static void tlogTriggerLuckyBox(String userId, long roleId, int triggerReason)
/*     */   {
/* 162 */     int roleLevel = RoleInterface.getLevel(roleId);
/*     */     
/* 164 */     StringBuilder sbLog = new StringBuilder();
/* 165 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 166 */     sbLog.append(userId).append('|');
/* 167 */     sbLog.append(roleId).append('|');
/* 168 */     sbLog.append(roleLevel).append('|');
/*     */     
/* 170 */     sbLog.append(triggerReason);
/*     */     
/* 172 */     TLogManager.getInstance().addLog(roleId, "LuckyBoxTrigger", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\SignAwardInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */