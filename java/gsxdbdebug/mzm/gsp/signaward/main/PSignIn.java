/*     */ package mzm.gsp.signaward.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.LotteryManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.signaward.confbean.Date2SignAward;
/*     */ import mzm.gsp.signaward.confbean.SignAwardCfgConsts;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.Pod;
/*     */ import xbean.Sign;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2sign;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PSignIn
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int signday;
/*     */   private final long clientYuanBao;
/*     */   private final int isUseYuanBao;
/*     */   
/*     */   public PSignIn(long roleid, int signday, long clientYuanBao, int isUseYuanBao)
/*     */   {
/*  36 */     this.roleId = roleid;
/*  37 */     this.signday = signday;
/*  38 */     this.clientYuanBao = clientYuanBao;
/*  39 */     this.isUseYuanBao = isUseYuanBao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (!SignAwardManager.isSignSwitchOpenForRole(this.roleId))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/*  53 */     String userid = RoleInterface.getUserId(this.roleId);
/*  54 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*  57 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 138, true, true))
/*     */     {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*  63 */     if (roleLevel < SignAwardCfgConsts.getInstance().CAN_SIGN_LEVEL)
/*     */     {
/*  65 */       String logstr = String.format("[sign]PSignIn.processImp@role level error|userid=%s|roleid=%d|level=%d|cansignlevel=%d|signday=%d", new Object[] { userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(SignAwardCfgConsts.getInstance().CAN_SIGN_LEVEL), Integer.valueOf(this.signday) });
/*     */       
/*     */ 
/*  68 */       SignAwardManager.logger.info(logstr);
/*  69 */       SignAwardManager.sendErrorProtocal(this.roleId, 4);
/*  70 */       return false;
/*     */     }
/*  72 */     if (!SignAwardManager.isSignDayFormatRight(this.signday))
/*     */     {
/*  74 */       SignAwardManager.sendErrorProtocal(this.roleId, 1);
/*  75 */       String logstr = String.format("[sign]PSignIn.processImp@signday error|userid=%s|roleid=%d|level=%d|signday=%d", new Object[] { userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(this.signday) });
/*     */       
/*  77 */       SignAwardManager.logger.error(logstr);
/*  78 */       return false;
/*     */     }
/*  80 */     SignDayBean signDayBean = new SignDayBean(this.signday);
/*  81 */     if (!SignAwardManager.isSignDayAvailable(now, signDayBean))
/*     */     {
/*  83 */       String logstr = String.format("[sign]PSignIn.processImp@signday not available|userid=%s|roleid=%d|level=%d|signday=%d", new Object[] { userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(this.signday) });
/*     */       
/*     */ 
/*  86 */       SignAwardManager.logger.error(logstr);
/*  87 */       SignAwardManager.sendErrorProtocal(this.roleId, 2);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     Sign xSign = Role2sign.get(Long.valueOf(this.roleId));
/*  92 */     if (xSign == null)
/*     */     {
/*  94 */       xSign = Pod.newSign();
/*  95 */       Role2sign.insert(Long.valueOf(this.roleId), xSign);
/*     */     }
/*     */     
/*  98 */     if (!LotteryManager.canAdd(this.roleId, 9))
/*     */     {
/* 100 */       SignAwardManager.sendErrorProtocal(this.roleId, 24);
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     if (SignAwardManager.isTodaySignIn(xSign, now))
/*     */     {
/* 106 */       SignAwardManager.sendErrorProtocal(this.roleId, 5);
/*     */       
/* 108 */       String logstr = String.format("[sign]PSignIn.processImp@role already signed today|userid=%s|roleid=%d|level=%d|signday=%d", new Object[] { userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(this.signday) });
/*     */       
/*     */ 
/* 111 */       SignAwardManager.logger.error(logstr);
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     int alreadySignday = xSign.getSignday();
/* 116 */     if (alreadySignday == 0)
/*     */     {
/* 118 */       if (signDayBean.getDay() != 1)
/*     */       {
/* 120 */         String logstr = String.format("[sign]PSignIn.processImp@the first day is not signed|userid=%s|roleid=%d|level=%d|signday=%d|alreadySignday=%d", new Object[] { userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(this.signday), Integer.valueOf(alreadySignday) });
/*     */         
/*     */ 
/* 123 */         SignAwardManager.logger.error(logstr);
/*     */         
/* 125 */         SignAwardManager.sendErrorProtocal(this.roleId, 2);
/* 126 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 131 */     else if (!SignAwardManager.isAlreadySignDayAndSignDayRight(alreadySignday, this.signday))
/*     */     {
/* 133 */       String logstr = String.format("[sign]PSignIn.processImp@sign day error|userid=%s|roleid=%d|level=%d|signday=%d|alreadySignday=%d", new Object[] { userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(this.signday), Integer.valueOf(alreadySignday) });
/*     */       
/*     */ 
/* 136 */       SignAwardManager.logger.error(logstr);
/*     */       
/* 138 */       SignAwardManager.sendErrorProtocal(this.roleId, 2);
/* 139 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 144 */     boolean ret = SignAwardManager.signIn(xSign, this.signday, now);
/* 145 */     if (!ret)
/*     */     {
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     Date2SignAward award = SignAwardManager.getSSignAward(this.signday);
/* 151 */     if (award == null)
/*     */     {
/* 153 */       String logstr = String.format("[sign]PSignIn.processImp@sign award error,null|userid=%s|roleid=%d|level=%d|signday=%d|alreadySignday=%d", new Object[] { userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(this.signday), Integer.valueOf(alreadySignday) });
/*     */       
/*     */ 
/* 156 */       SignAwardManager.logger.error(logstr);
/* 157 */       return false;
/*     */     }
/* 159 */     TLogArg logArg = new TLogArg(LogReason.SIGN_IN_ADD, award.id);
/* 160 */     int rewardid = ItemInterface.getGiftbagItemRewardId(award.itemid);
/* 161 */     boolean isDirectlyUse = ItemInterface.isDirectlyUseGiftbagItem(award.itemid);
/* 162 */     int awardItemId = 0;
/* 163 */     int awardItemCount = 0;
/* 164 */     if ((!isDirectlyUse) || (rewardid == -1))
/*     */     {
/* 166 */       boolean isbind = ItemInterface.isItemFromShanghuiOrBaitan(award.itemid);
/* 167 */       List<Item> xItems = ItemInterface.createXItem(award.itemid, award.itemcount, null, isbind);
/* 168 */       ItemOperateResult result = ItemInterface.addItem(this.roleId, xItems, true, logArg);
/* 169 */       if (result.isBagFull())
/*     */       {
/* 171 */         ItemInterface.sendSpecificBagGridNotEnough(this.roleId, result.getFullBagId());
/* 172 */         return false;
/*     */       }
/* 174 */       awardItemId = award.itemid;
/* 175 */       awardItemCount = award.itemcount;
/*     */       
/* 177 */       SignAwardManager.triggerSignEvent(this.roleId, this.signday, award.itemid, award.itemcount, false);
/*     */     }
/*     */     else
/*     */     {
/* 181 */       for (int i = 0; i < award.itemcount; i++)
/*     */       {
/* 183 */         boolean r = SignAwardManager.useGiftbag(userid, this.roleId, rewardid, logArg);
/* 184 */         if (!r)
/*     */         {
/* 186 */           String logstr = String.format("[sign]PSignIn.processImp@reward error|userid=%s|roleid=%d|level=%d|signday=%d|alreadySignday=%d|rewardid=%d", new Object[] { userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(this.signday), Integer.valueOf(alreadySignday), Integer.valueOf(rewardid) });
/*     */           
/*     */ 
/* 189 */           SignAwardManager.logger.error(logstr);
/* 190 */           return false;
/*     */         }
/*     */       }
/* 193 */       SignAwardManager.triggerSignEvent(this.roleId, this.signday, award.itemid, award.itemcount, false);
/*     */     }
/*     */     
/*     */ 
/* 197 */     if (SignAwardManager.isSignPreciousSwitchOpen(this.roleId))
/*     */     {
/*     */ 
/* 200 */       boolean handleSignPreciousResult = SignAwardManager.handleSignPrecious(userid, this.roleId, xSign, roleLevel, this.clientYuanBao, this.isUseYuanBao);
/*     */       
/* 202 */       if (!handleSignPreciousResult)
/*     */       {
/* 204 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 208 */     SignAwardManager.sendSSignInRes(this.roleId, xSign, now, awardItemId, awardItemCount);
/*     */     
/* 210 */     SignAwardManager.tlogSign(this.roleId, award.id, this.signday, SignType.SIGN.value, this.isUseYuanBao, xSign.getCurrent_precious_cell_num());
/*     */     
/*     */ 
/* 213 */     GameServer.logger().info(String.format("[sign]PSignIn.processImp@sign in success|role_id=%d|cell_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(xSign.getCurrent_precious_cell_num()) }));
/*     */     
/*     */ 
/* 216 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\PSignIn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */