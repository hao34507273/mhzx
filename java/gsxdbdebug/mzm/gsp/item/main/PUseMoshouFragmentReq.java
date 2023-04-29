/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.item.SUseMoshuFragmentRes;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.shimen.confbean.ShimenActivityCfgConsts;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DayPerfectRingCout;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2dayperfectringcount;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PUseMoshouFragmentReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int itemId;
/*     */   private final int exchangeType;
/*     */   
/*     */   public PUseMoshouFragmentReq(long roleId, int itemId, int exchangeType)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.itemId = itemId;
/*  29 */     this.exchangeType = exchangeType;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (!ItemModuleSwitchInterface.isMoShouFragmentExchangeSwitchOpenForRole(this.roleId))
/*     */     {
/*  37 */       return false;
/*     */     }
/*  39 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleId))
/*     */     {
/*  41 */       String logStr = String.format("[item]PUseMoshouFragmentReq.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  43 */       ItemManager.logger.info(logStr);
/*  44 */       return false;
/*     */     }
/*  46 */     String userid = RoleInterface.getUserId(this.roleId);
/*  47 */     if (userid == null)
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     lock(Lockeys.get(User.getTable(), userid));
/*  53 */     lock(Lockeys.get(xtable.Role2properties.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*  55 */     if (ItemConfigManager.getItemTypeByItemId(this.itemId) != 81)
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if (this.exchangeType == 0)
/*     */     {
/*  62 */       if (!NpcInterface.checkNpcService(ShimenActivityCfgConsts.getInstance().EXCHANGE_NPC_ID, ShimenActivityCfgConsts.getInstance().EXCHANGE_MOSHOU_NPC_SERVICE, this.roleId))
/*     */       {
/*     */ 
/*  65 */         return false;
/*     */       }
/*  67 */       DayPerfectRingCout xDayPerfectRingCout = Role2dayperfectringcount.get(Long.valueOf(this.roleId));
/*  68 */       if (xDayPerfectRingCout == null)
/*     */       {
/*  70 */         String logStr = String.format("[item]PUseMoshouFragmentReq.processImp@xDayPerfectRingCout error,null|roleid=%d|itemId=%d|exchangeType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(this.exchangeType) });
/*     */         
/*     */ 
/*  73 */         ItemManager.logger.info(logStr);
/*  74 */         return false;
/*     */       }
/*  76 */       if (xDayPerfectRingCout.getExchangecount() >= ShimenActivityCfgConsts.getInstance().EXCHANGE_MOSHOU_MAX_COUNT)
/*     */       {
/*  78 */         ItemManager.sendWrongInfo(this.roleId, 1131, new String[] { String.valueOf(ShimenActivityCfgConsts.getInstance().EXCHANGE_MOSHOU_MAX_COUNT) });
/*     */         
/*     */ 
/*  81 */         return false;
/*     */       }
/*     */       
/*  84 */       TLogArg logArg = new TLogArg(LogReason.ITEM_USE_EXHANGE_MOSHOU_REWARD, this.itemId);
/*  85 */       boolean ret = ItemInterface.removeItemsByType(this.roleId, 81, ShimenActivityCfgConsts.getInstance().EXCHANGE_MOSHOU_REWARD_NEED_ITEM_NUM, logArg);
/*     */       
/*  87 */       if (!ret)
/*     */       {
/*  89 */         ItemManager.sendWrongInfo(this.roleId, 1130, new String[] { String.valueOf(ShimenActivityCfgConsts.getInstance().EXCHANGE_MOSHOU_REWARD_NEED_ITEM_NUM) });
/*     */         
/*     */ 
/*  92 */         String logStr = String.format("[item]PUseMoshouFragmentReq.processImp@exchange moshou error,cut item error|roleid=%d|itemId=%d|cutItemNum=%d|rewardId=%d|exchangeType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(ShimenActivityCfgConsts.getInstance().EXCHANGE_MOSHOU_REWARD_NEED_ITEM_NUM), Integer.valueOf(ShimenActivityCfgConsts.getInstance().MOSHOU_REWARD), Integer.valueOf(this.exchangeType) });
/*     */         
/*     */ 
/*     */ 
/*  96 */         ItemManager.logger.error(logStr);
/*  97 */         return false;
/*     */       }
/*     */       
/* 100 */       AwardModel awardModel = AwardInterface.awardFixAward(ShimenActivityCfgConsts.getInstance().MOSHOU_REWARD, userid, this.roleId, true, true, new AwardReason(LogReason.ITEM_USE_EXHANGE_MOSHOU_REWARD, this.itemId));
/*     */       
/* 102 */       if (awardModel != null)
/*     */       {
/* 104 */         String logStr = String.format("[item]PUseMoshouFragmentReq.processImp@exchange moshou success|roleid=%d|itemId=%d|cutItemNum=%d|rewardId=%d|exchangeType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(ShimenActivityCfgConsts.getInstance().EXCHANGE_MOSHOU_REWARD_NEED_ITEM_NUM), Integer.valueOf(ShimenActivityCfgConsts.getInstance().MOSHOU_REWARD), Integer.valueOf(this.exchangeType) });
/*     */         
/*     */ 
/*     */ 
/* 108 */         ItemManager.logger.info(logStr);
/* 109 */         xDayPerfectRingCout.setExchangecount(xDayPerfectRingCout.getExchangecount() + 1);
/* 110 */         sendSuccessRes(ShimenActivityCfgConsts.getInstance().EXCHANGE_MOSHOU_REWARD_NEED_ITEM_NUM);
/* 111 */         ItemManager.sendSSynMoshouExchangeCountRes(this.roleId, xDayPerfectRingCout.getExchangecount() + 1);
/* 112 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 116 */       String logStr = String.format("[item]PUseMoshouFragmentReq.processImp@exchange moshou error,awardmodel null|roleid=%d|itemId=%d|cutItemNum=%d|rewardId=%d|exchangeType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(ShimenActivityCfgConsts.getInstance().EXCHANGE_MOSHOU_REWARD_NEED_ITEM_NUM), Integer.valueOf(ShimenActivityCfgConsts.getInstance().MOSHOU_REWARD), Integer.valueOf(this.exchangeType) });
/*     */       
/*     */ 
/*     */ 
/* 120 */       ItemManager.logger.error(logStr);
/* 121 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 127 */     if (!NpcInterface.checkNpcService(ShimenActivityCfgConsts.getInstance().EXCHANGE_NPC_ID, ShimenActivityCfgConsts.getInstance().EXCHANGE_NORMAL_NPC_SERVICE, this.roleId))
/*     */     {
/*     */ 
/* 130 */       return false;
/*     */     }
/* 132 */     TLogArg logArg = new TLogArg(LogReason.ITEM_USE_EXHANGE_NORMAL_REWARD, this.itemId);
/* 133 */     boolean ret = ItemInterface.removeItemById(this.roleId, this.itemId, ShimenActivityCfgConsts.getInstance().EXCHANGE_NORMAL_REWARD_NEED_ITEM_NUM, logArg);
/*     */     
/* 135 */     if (!ret)
/*     */     {
/* 137 */       ItemManager.sendWrongInfo(this.roleId, 1130, new String[] { String.valueOf(ShimenActivityCfgConsts.getInstance().EXCHANGE_NORMAL_REWARD_NEED_ITEM_NUM) });
/*     */       
/*     */ 
/* 140 */       String logStr = String.format("[item]PUseMoshouFragmentReq.processImp@exchange normal reward error,cut item error|roleid=%d|itemId=%d|cutItemNum=%d|rewardId=%d|exchangeType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(ShimenActivityCfgConsts.getInstance().EXCHANGE_NORMAL_REWARD_NEED_ITEM_NUM), Integer.valueOf(ShimenActivityCfgConsts.getInstance().NORMAL_REWARD), Integer.valueOf(this.exchangeType) });
/*     */       
/*     */ 
/*     */ 
/* 144 */       ItemManager.logger.error(logStr);
/* 145 */       return false;
/*     */     }
/*     */     
/* 148 */     AwardModel awardModel = AwardInterface.awardFixAward(ShimenActivityCfgConsts.getInstance().NORMAL_REWARD, userid, this.roleId, true, true, new AwardReason(LogReason.ITEM_USE_EXHANGE_NORMAL_REWARD, this.itemId));
/*     */     
/* 150 */     if (awardModel != null)
/*     */     {
/* 152 */       String logStr = String.format("[item]PUseMoshouFragmentReq.processImp@exchange normal reward success|roleid=%d|itemId=%d|cutItemNum=%d|rewardId=%d|exchangeType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(ShimenActivityCfgConsts.getInstance().EXCHANGE_NORMAL_REWARD_NEED_ITEM_NUM), Integer.valueOf(ShimenActivityCfgConsts.getInstance().NORMAL_REWARD), Integer.valueOf(this.exchangeType) });
/*     */       
/*     */ 
/*     */ 
/* 156 */       ItemManager.logger.info(logStr);
/* 157 */       sendSuccessRes(ShimenActivityCfgConsts.getInstance().EXCHANGE_NORMAL_REWARD_NEED_ITEM_NUM);
/* 158 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 162 */     String logStr = String.format("[item]PUseMoshouFragmentReq.processImp@exchange normal reward error,awardmodel null|roleid=%d|itemId=%d|cutItemNum=%d|rewardId=%d|exchangeType=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(ShimenActivityCfgConsts.getInstance().EXCHANGE_NORMAL_REWARD_NEED_ITEM_NUM), Integer.valueOf(ShimenActivityCfgConsts.getInstance().NORMAL_REWARD), Integer.valueOf(this.exchangeType) });
/*     */     
/*     */ 
/*     */ 
/* 166 */     ItemManager.logger.error(logStr);
/* 167 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void sendSuccessRes(int num)
/*     */   {
/* 176 */     SUseMoshuFragmentRes res = new SUseMoshuFragmentRes();
/* 177 */     res.itemid = this.itemId;
/* 178 */     res.cutitemnum = num;
/* 179 */     res.exchangetype = this.exchangeType;
/* 180 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PUseMoshouFragmentReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */