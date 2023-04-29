/*     */ package mzm.gsp.petmark.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.petmark.SPetMarkUpgradeWithItemFail;
/*     */ import mzm.gsp.petmark.SPetMarkUpgradeWithItemSuccess;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkCfg;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkConstants;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkItemCfg;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkLevelCfg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetMarkInfo;
/*     */ import xbean.Role2PetMarkInfo;
/*     */ 
/*     */ public class PCPetMarkUpgradeWithItemReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long mainPetMarkId;
/*     */   private final int costItemCfgId;
/*     */   private final boolean useAll;
/*     */   
/*     */   public PCPetMarkUpgradeWithItemReq(long roleId, long mainPetMarkId, int costItemCfgId, byte useAll)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.mainPetMarkId = mainPetMarkId;
/*  30 */     this.costItemCfgId = costItemCfgId;
/*  31 */     this.useAll = (useAll > 0);
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!PetMarkManager.isPetMarkOpen(this.roleId))
/*     */     {
/*  40 */       String logstr = String.format("[petmark]PCPetMarkUpgradeWithItemReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  42 */       GameServer.logger().info(logstr);
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 2135, true))
/*     */     {
/*  49 */       String logstr = String.format("[petmark]PCPetMarkUpgradeWithItemReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  51 */       GameServer.logger().info(logstr);
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     if (!PetMarkManager.checkRoleLevel(this.roleId))
/*     */     {
/*  58 */       onFail(-1);
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  63 */     Role2PetMarkInfo xRole2PetMarkInfo = PetMarkManager.getRolePetMarkInfo(this.roleId);
/*  64 */     PetMarkInfo xMainPetMarkInfo = (PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(Long.valueOf(this.mainPetMarkId));
/*  65 */     if (null == xMainPetMarkInfo)
/*     */     {
/*  67 */       onFail(-2);
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     int mainPetMarkCfgId = xMainPetMarkInfo.getPet_mark_cfg_id();
/*  73 */     int mainPetMarkLevel = xMainPetMarkInfo.getLevel();
/*  74 */     SPetMarkLevelCfg mainPetMarkLevelCfg = SPetMarkLevelCfg.get(mainPetMarkCfgId);
/*  75 */     if (PetMarkManager.isLevelMax(mainPetMarkLevelCfg, mainPetMarkLevel))
/*     */     {
/*  77 */       onFail(-3);
/*  78 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  82 */     if (PetMarkManager.isLevelMaxByRoleLevel(this.roleId, mainPetMarkLevelCfg, mainPetMarkLevel))
/*     */     {
/*  84 */       onFail(-7);
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     SPetMarkItemCfg costPetMarkItemCfg = SPetMarkItemCfg.get(this.costItemCfgId);
/*  90 */     if (null == costPetMarkItemCfg)
/*     */     {
/*  92 */       onFail(-5);
/*  93 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  97 */     int costPetMarkCfgId = costPetMarkItemCfg.petMarkCfgId;
/*  98 */     SPetMarkCfg costPetMarkCfg = SPetMarkCfg.get(xMainPetMarkInfo.getPet_mark_cfg_id());
/*  99 */     if (costPetMarkCfg.quality != SPetMarkCfg.get(costPetMarkCfgId).quality)
/*     */     {
/* 101 */       onFail(-6);
/* 102 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 106 */     int itemNum = ItemInterface.getItemNumberById(this.roleId, 340600009, this.costItemCfgId);
/* 107 */     if (itemNum == 0)
/*     */     {
/* 109 */       onFail(-4);
/* 110 */       return false;
/*     */     }
/*     */     
/*     */     int singleAddExp;
/*     */     int singleAddExp;
/* 115 */     if (costPetMarkCfgId == mainPetMarkCfgId)
/*     */     {
/* 117 */       singleAddExp = costPetMarkItemCfg.provideExp;
/*     */     }
/*     */     else
/*     */     {
/* 121 */       int reduceRatio = SPetMarkConstants.getInstance().DIFFRENT_MARK_EXP_REDUSE_RATIO;
/* 122 */       singleAddExp = costPetMarkItemCfg.provideExp / reduceRatio;
/*     */     }
/*     */     
/*     */ 
/* 126 */     int maxNum = this.useAll ? itemNum : 1;
/* 127 */     int remainNum = maxNum;
/* 128 */     while (remainNum > 0)
/*     */     {
/* 130 */       remainNum--;
/* 131 */       if (PetMarkManager.addPetMarkExp(this.roleId, this.mainPetMarkId, xMainPetMarkInfo, singleAddExp))
/*     */       {
/* 133 */         int newLevel = xMainPetMarkInfo.getLevel();
/* 134 */         if ((PetMarkManager.isLevelMax(mainPetMarkLevelCfg, newLevel)) || (PetMarkManager.isLevelMaxByRoleLevel(this.roleId, mainPetMarkLevelCfg, newLevel))) {
/*     */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 144 */     int costNum = maxNum - remainNum;
/* 145 */     TLogArg logArg = new TLogArg(LogReason.PET_MARK_UPGRADE_COST);
/* 146 */     ItemInterface.removeItemById(this.roleId, 340600009, this.costItemCfgId, costNum, logArg);
/*     */     
/*     */ 
/* 149 */     onSuccess(xMainPetMarkInfo, costNum * singleAddExp);
/*     */     
/* 151 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onSuccess(PetMarkInfo xPetMarkInfo, int addExp)
/*     */   {
/* 157 */     int nowLevel = xPetMarkInfo.getLevel();
/* 158 */     int nowExp = xPetMarkInfo.getExp();
/* 159 */     SPetMarkUpgradeWithItemSuccess proto = new SPetMarkUpgradeWithItemSuccess();
/* 160 */     proto.main_pet_mark_id = this.mainPetMarkId;
/* 161 */     proto.add_exp = addExp;
/* 162 */     proto.now_level = nowLevel;
/* 163 */     proto.now_exp = nowExp;
/* 164 */     OnlineManager.getInstance().send(this.roleId, proto);
/*     */     
/*     */ 
/* 167 */     String logstr = String.format("[petmark]PCPetMarkUpgradeWithItemReq.onSuccess@PCPetMarkUpgradeWithItemReq success|roleId=%d,mainPetMarkId=%d,addExp=%d,newLevel=%d,newExp=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mainPetMarkId), Integer.valueOf(addExp), Integer.valueOf(nowLevel), Integer.valueOf(nowExp) });
/*     */     
/*     */ 
/* 170 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 173 */     PetMarkTLogManager.addPetMarkUpgradeTLog(this.roleId, this.mainPetMarkId, xPetMarkInfo.getPet_mark_cfg_id(), xPetMarkInfo.getLevel(), xPetMarkInfo.getExp(), addExp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 180 */     SPetMarkUpgradeWithItemFail proto = new SPetMarkUpgradeWithItemFail();
/* 181 */     proto.error_code = errorCode;
/* 182 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 185 */     String logstr = String.format("[petmark]PCPetMarkUpgradeWithItemReq.onFail@PCPetMarkUpgradeWithItemReq failed|roleId=%d,petMarkId=%d,reason=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mainPetMarkId), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 188 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\main\PCPetMarkUpgradeWithItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */