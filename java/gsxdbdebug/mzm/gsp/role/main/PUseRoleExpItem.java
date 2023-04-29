/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.item.confbean.SRoleExpItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemModuleSwitchInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.SUseExpItemRes;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUseRoleExpItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int itemKey;
/*     */   private boolean isAllUse;
/*     */   
/*     */   public PUseRoleExpItem(long roleId, int itemKey, boolean isAllUse)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.itemKey = itemKey;
/*  36 */     this.isAllUse = isAllUse;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 223, true))
/*     */     {
/*  44 */       return false;
/*     */     }
/*  46 */     if (!ItemModuleSwitchInterface.isUseRoleExpItemSwitchOpenForRole(this.roleId))
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     String userid = RoleInterface.getUserId(this.roleId);
/*  52 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  54 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.itemKey);
/*  55 */     if ((basicItem == null) || (basicItem.getNumber() <= 0))
/*     */     {
/*     */ 
/*  58 */       String logStr = String.format("PUseRoleExpItem.processImp@item num error|roleid=%d|grid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey), Integer.valueOf(basicItem == null ? 0 : basicItem.getCfgId()) });
/*     */       
/*  60 */       RoleManager.logger.error(logStr);
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  71 */     SRoleExpItem sRoleExpItem = (SRoleExpItem)SRoleExpItem.getAllSelf().get(Integer.valueOf(basicItem.getCfgId()));
/*  72 */     if (sRoleExpItem == null)
/*     */     {
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     int rolelevel = RoleInterface.getLevel(this.roleId);
/*  78 */     if (rolelevel < sRoleExpItem.useLevel)
/*     */     {
/*  80 */       String logStr = String.format("PUseRoleExpItem.processImp@role level errror|roleid=%d|rolelevel=%d|uselevel=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(rolelevel), Integer.valueOf(sRoleExpItem.useLevel) });
/*     */       
/*  82 */       RoleManager.logger.error(logStr);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     int exp = 0;
/*     */     
/*  88 */     int num = 1;
/*  89 */     if (this.isAllUse)
/*     */     {
/*  91 */       num = basicItem.getNumber();
/*     */     }
/*  93 */     int todayusecount = ItemInterface.getItemUseCount(this.roleId, basicItem.getCfgId());
/*  94 */     int canUseNum = Math.min(sRoleExpItem.maxUseCount - todayusecount, num);
/*  95 */     if (canUseNum <= 0)
/*     */     {
/*  97 */       ItemInterface.sendWrongInfo(this.roleId, 103, new String[] { String.valueOf(basicItem.getCfgId()), String.valueOf(sRoleExpItem.maxUseCount) });
/*     */       
/*     */ 
/* 100 */       return false;
/*     */     }
/* 102 */     TLogArg logArg = new TLogArg(LogReason.ROLE_USE_EXP_ITEM, basicItem.getCfgId());
/*     */     
/* 104 */     AwardReason reason = new AwardReason(LogReason.ROLE_USE_EXP_ITEM);
/* 105 */     AwardModel awardModel = AwardInterface.getRoleAwardModel(sRoleExpItem.rewardid, this.roleId, -1, reason);
/*     */     
/* 107 */     if ((awardModel == null) || (awardModel.getRoleExp() <= 0))
/*     */     {
/* 109 */       String logStr = String.format("PUseRoleExpItem.processImp@exp errror|roleid=%d|itemid=%d|rewardid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(basicItem.getCfgId()), Integer.valueOf(sRoleExpItem.rewardid) });
/*     */       
/* 111 */       RoleManager.logger.error(logStr);
/* 112 */       return false;
/*     */     }
/* 114 */     exp = awardModel.getRoleExp();
/* 115 */     int usednum = 0;
/* 116 */     int totaladdexp = 0;
/* 117 */     for (int i = 0; i < canUseNum; i++)
/*     */     {
/* 119 */       boolean ret = RoleInterface.addExp(userid, this.roleId, exp, logArg);
/* 120 */       if (!ret) {
/*     */         break;
/*     */       }
/*     */       
/* 124 */       usednum++;
/* 125 */       totaladdexp += exp;
/*     */     }
/*     */     
/* 128 */     if (usednum > 0)
/*     */     {
/* 130 */       if (!ItemInterface.addItemUseCount(this.roleId, basicItem.getCfgId(), usednum))
/*     */       {
/* 132 */         return false;
/*     */       }
/*     */       
/* 135 */       SUseExpItemRes sUseExpItemRes = new SUseExpItemRes();
/* 136 */       sUseExpItemRes.itemid = basicItem.getCfgId();
/* 137 */       sUseExpItemRes.addexp = totaladdexp;
/* 138 */       sUseExpItemRes.usednum = (todayusecount + usednum);
/* 139 */       sUseExpItemRes.leftnum = (sRoleExpItem.maxUseCount - todayusecount - usednum);
/* 140 */       OnlineManager.getInstance().send(this.roleId, sUseExpItemRes);
/*     */       
/* 142 */       String logStr = String.format("PUseRoleExpItem.processImp@use role expitem success|roleid=%d|todayusecount=%d|restusecount=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(sUseExpItemRes.usednum), Integer.valueOf(sUseExpItemRes.leftnum), Integer.valueOf(basicItem.getCfgId()) });
/*     */       
/*     */ 
/* 145 */       RoleManager.logger.info(logStr);
/*     */       
/* 147 */       boolean ret = ItemInterface.removeItemByGrid(this.roleId, 340600000, this.itemKey, usednum, logArg);
/* 148 */       return ret;
/*     */     }
/*     */     
/*     */ 
/* 152 */     ItemInterface.sendWrongInfo(this.roleId, 1050, new String[0]);
/* 153 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PUseRoleExpItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */