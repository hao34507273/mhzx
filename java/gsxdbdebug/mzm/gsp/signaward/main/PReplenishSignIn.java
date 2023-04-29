/*     */ package mzm.gsp.signaward.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
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
/*     */ import xbean.Sign;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2sign;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PReplenishSignIn
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int signday;
/*     */   private final long clientYuanBao;
/*     */   private final int isUseYuanBao;
/*     */   
/*     */   public PReplenishSignIn(long roleid, int signday, long clientYuanBao, int isUseYuanBao)
/*     */   {
/*  35 */     this.roleid = roleid;
/*  36 */     this.signday = signday;
/*  37 */     this.clientYuanBao = clientYuanBao;
/*  38 */     this.isUseYuanBao = isUseYuanBao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!SignAwardManager.isSignSwitchOpenForRole(this.roleid))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/*  52 */     String userid = RoleInterface.getUserId(this.roleid);
/*  53 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*  56 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 138, true, true))
/*     */     {
/*  58 */       return false;
/*     */     }
/*     */     
/*  61 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*  62 */     if (roleLevel < SignAwardCfgConsts.getInstance().CAN_SIGN_LEVEL)
/*     */     {
/*  64 */       String logstr = String.format("[sign]PReplenishSignIn.processImp@role level error|userid=%s|roleid=%d|level=%d|cansignlevel=%d|signday=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Integer.valueOf(SignAwardCfgConsts.getInstance().CAN_SIGN_LEVEL), Integer.valueOf(this.signday) });
/*     */       
/*     */ 
/*  67 */       SignAwardManager.logger.info(logstr);
/*  68 */       SignAwardManager.sendErrorProtocal(this.roleid, 4);
/*  69 */       return false;
/*     */     }
/*  71 */     if (!SignAwardManager.isSignDayFormatRight(this.signday))
/*     */     {
/*  73 */       String logstr = String.format("[sign]PReplenishSignIn.processImp@signday error|userid=%s|roleid=%d|level=%d|signday=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Integer.valueOf(this.signday) });
/*     */       
/*     */ 
/*  76 */       SignAwardManager.logger.info(logstr);
/*  77 */       SignAwardManager.sendErrorProtocal(this.roleid, 1);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     SignDayBean signDayBean = new SignDayBean(this.signday);
/*  82 */     if (!SignAwardManager.isSignDayAvailable(now, signDayBean))
/*     */     {
/*  84 */       String logstr = String.format("[sign]PReplenishSignIn.processImp@signday is not available|userid=%s|roleid=%d|level=%d|signday=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Integer.valueOf(this.signday) });
/*     */       
/*     */ 
/*  87 */       SignAwardManager.logger.info(logstr);
/*  88 */       SignAwardManager.sendErrorProtocal(this.roleid, 2);
/*  89 */       return false;
/*     */     }
/*  91 */     Sign xSign = Role2sign.get(Long.valueOf(this.roleid));
/*  92 */     if (xSign == null)
/*     */     {
/*  94 */       return false;
/*     */     }
/*  96 */     if (xSign.getFillincount() <= 0)
/*     */     {
/*  98 */       return false;
/*     */     }
/* 100 */     if (xSign.getSignday() == 0)
/*     */     {
/*     */ 
/* 103 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 107 */     long signTime = xSign.getSigntime();
/* 108 */     if (!DateTimeUtils.isInSameDay(now, signTime))
/*     */     {
/* 110 */       return false;
/*     */     }
/* 112 */     int alreadySignday = xSign.getSignday();
/* 113 */     if (!SignAwardManager.isAlreadySignDayAndSignDayRight(alreadySignday, this.signday))
/*     */     {
/* 115 */       String logstr = String.format("[sign]PReplenishSignIn.processImp@sign day error|userid=%s|roleid=%d|level=%d|signday=%d|alreadySignday=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Integer.valueOf(this.signday), Integer.valueOf(alreadySignday) });
/*     */       
/*     */ 
/* 118 */       SignAwardManager.logger.error(logstr);
/* 119 */       SignAwardManager.sendErrorProtocal(this.roleid, 2);
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     boolean ret = SignAwardManager.replenishSignIn(xSign, this.signday, now);
/* 124 */     if (!ret)
/*     */     {
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     Date2SignAward award = SignAwardManager.getSSignAward(this.signday);
/* 130 */     if (award == null)
/*     */     {
/* 132 */       String logstr = String.format("[sign]PReplenishSignIn.processImp@sign award error,null|userid=%s|roleid=%d|level=%d|signday=%d|alreadySignday=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Integer.valueOf(this.signday), Integer.valueOf(alreadySignday) });
/*     */       
/*     */ 
/* 135 */       SignAwardManager.logger.error(logstr);
/* 136 */       return false;
/*     */     }
/* 138 */     TLogArg logArg = new TLogArg(LogReason.RE_SIGN_IN_ADD, award.id);
/* 139 */     int rewardid = ItemInterface.getGiftbagItemRewardId(award.itemid);
/* 140 */     int itemid = 0;
/* 141 */     int itemcount = 0;
/* 142 */     boolean isDirectlyUse = ItemInterface.isDirectlyUseGiftbagItem(award.itemid);
/* 143 */     if ((!isDirectlyUse) || (rewardid == -1))
/*     */     {
/* 145 */       boolean isbind = ItemInterface.isItemFromShanghuiOrBaitan(award.itemid);
/*     */       
/* 147 */       List<Item> xItems = ItemInterface.createXItem(award.itemid, award.itemcount, null, isbind);
/* 148 */       ItemOperateResult result = ItemInterface.addItem(this.roleid, xItems, true, logArg);
/* 149 */       if (result.isBagFull())
/*     */       {
/* 151 */         ItemInterface.sendSpecificBagGridNotEnough(this.roleid, result.getFullBagId());
/* 152 */         return false;
/*     */       }
/* 154 */       SignAwardManager.triggerSignEvent(this.roleid, this.signday, award.itemid, award.itemcount, true);
/* 155 */       itemid = award.itemid;
/* 156 */       itemcount = award.itemcount;
/*     */     }
/*     */     else
/*     */     {
/* 160 */       for (int i = 0; i < award.itemcount; i++)
/*     */       {
/* 162 */         boolean r = SignAwardManager.useGiftbag(userid, this.roleid, rewardid, logArg);
/* 163 */         if (!r)
/*     */         {
/* 165 */           String logstr = String.format("[sign]PReplenishSignIn.processImp@reward error|userid=%s|roleid=%d|level=%d|signday=%d|alreadySignday=%d|rewardid=%d", new Object[] { userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Integer.valueOf(this.signday), Integer.valueOf(alreadySignday), Integer.valueOf(rewardid) });
/*     */           
/*     */ 
/* 168 */           SignAwardManager.logger.error(logstr);
/* 169 */           return false;
/*     */         }
/*     */       }
/* 172 */       SignAwardManager.triggerSignEvent(this.roleid, this.signday, award.itemid, award.itemcount, true);
/*     */     }
/*     */     
/*     */ 
/* 176 */     if (SignAwardManager.isSignPreciousSwitchOpen(this.roleid))
/*     */     {
/*     */ 
/* 179 */       boolean handleSignPreciousResult = SignAwardManager.handleSignPrecious(userid, this.roleid, xSign, roleLevel, this.clientYuanBao, this.isUseYuanBao);
/*     */       
/* 181 */       if (!handleSignPreciousResult)
/*     */       {
/* 183 */         return false;
/*     */       }
/*     */     }
/* 186 */     SignAwardManager.sendSSignInRes(this.roleid, xSign, now, itemid, itemcount);
/*     */     
/* 188 */     SignAwardManager.tlogSign(this.roleid, award.id, this.signday, SignType.RE_SIGN.value, this.isUseYuanBao, xSign.getCurrent_precious_cell_num());
/*     */     
/*     */ 
/* 191 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\PReplenishSignIn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */