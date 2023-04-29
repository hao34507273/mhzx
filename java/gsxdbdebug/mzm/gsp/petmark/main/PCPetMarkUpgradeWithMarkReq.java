/*     */ package mzm.gsp.petmark.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.petmark.SPetMarkUpgradeWithMarkFail;
/*     */ import mzm.gsp.petmark.SPetMarkUpgradeWithMarkSuccess;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkCfg;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkConstants;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkLevelBean;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkLevelCfg;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2PetMarkInfo;
/*     */ 
/*     */ public class PCPetMarkUpgradeWithMarkReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long mainPetMarkId;
/*     */   private final long costPetMarkId;
/*     */   
/*     */   public PCPetMarkUpgradeWithMarkReq(long roleId, long mainPetMarkId, long costPetMarkId)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.mainPetMarkId = mainPetMarkId;
/*  29 */     this.costPetMarkId = costPetMarkId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     if (!PetMarkManager.isPetMarkOpen(this.roleId))
/*     */     {
/*  38 */       String logstr = String.format("[petmark]PCPetMarkUpgradeWithMarkReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  40 */       GameServer.logger().info(logstr);
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 2134, true))
/*     */     {
/*  47 */       String logstr = String.format("[petmark]PCPetMarkUpgradeWithMarkReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  49 */       GameServer.logger().info(logstr);
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     if (!PetMarkManager.checkRoleLevel(this.roleId))
/*     */     {
/*  56 */       onFail(-1);
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     if (this.mainPetMarkId == this.costPetMarkId)
/*     */     {
/*  63 */       onFail(-8);
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     Role2PetMarkInfo xRole2PetMarkInfo = PetMarkManager.getRolePetMarkInfo(this.roleId);
/*  69 */     xbean.PetMarkInfo xMainPetMarkInfo = (xbean.PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(Long.valueOf(this.mainPetMarkId));
/*  70 */     if (null == xMainPetMarkInfo)
/*     */     {
/*  72 */       onFail(-2);
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     int mainPetMarkCfgId = xMainPetMarkInfo.getPet_mark_cfg_id();
/*  78 */     int mainPetMarkLevel = xMainPetMarkInfo.getLevel();
/*  79 */     if (PetMarkManager.isLevelMax(SPetMarkLevelCfg.get(mainPetMarkCfgId), mainPetMarkLevel))
/*     */     {
/*  81 */       onFail(-3);
/*  82 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  86 */     if (PetMarkManager.isLevelMaxByRoleLevel(this.roleId, SPetMarkLevelCfg.get(mainPetMarkCfgId), mainPetMarkLevel))
/*     */     {
/*  88 */       onFail(-7);
/*  89 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  93 */     xbean.PetMarkInfo xCostPetMarkInfo = (xbean.PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(Long.valueOf(this.costPetMarkId));
/*  94 */     if (null == xCostPetMarkInfo)
/*     */     {
/*  96 */       onFail(-4);
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     if (xCostPetMarkInfo.getPet_id() > 0L)
/*     */     {
/* 102 */       onFail(-6);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     int costPetMarkCfgId = xCostPetMarkInfo.getPet_mark_cfg_id();
/* 107 */     int costPetMarkLevel = xCostPetMarkInfo.getLevel();
/*     */     
/*     */ 
/* 110 */     SPetMarkCfg sCostPetMarkCfg = SPetMarkCfg.get(costPetMarkCfgId);
/* 111 */     if (SPetMarkCfg.get(mainPetMarkCfgId).quality != sCostPetMarkCfg.quality)
/*     */     {
/* 113 */       onFail(-5);
/* 114 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 118 */     SPetMarkLevelBean sCostPetMarkLevelBean = (SPetMarkLevelBean)SPetMarkLevelCfg.get(costPetMarkCfgId).level2Bean.get(Integer.valueOf(costPetMarkLevel));
/* 119 */     int addExp = sCostPetMarkLevelBean.provideExp + xCostPetMarkInfo.getExp();
/*     */     
/*     */     long addPetMarkId;
/*     */     long addPetMarkId;
/* 123 */     if ((sCostPetMarkCfg.type != 2) && (costPetMarkLevel > mainPetMarkLevel))
/*     */     {
/*     */ 
/* 126 */       SPetMarkLevelBean sAddPetMarkLevelBean = (SPetMarkLevelBean)SPetMarkLevelCfg.get(costPetMarkCfgId).level2Bean.get(Integer.valueOf(1));
/* 127 */       addExp -= sAddPetMarkLevelBean.provideExp;
/* 128 */       addPetMarkId = PetMarkManager.addPetMark(this.roleId, xRole2PetMarkInfo, costPetMarkCfgId, 1, PetMarkManager.AddPetMarkReason.UPGRADE_COST_HIGHER_LEVEL);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 133 */       addPetMarkId = 0L;
/*     */     }
/*     */     
/*     */ 
/* 137 */     if (mainPetMarkCfgId != costPetMarkCfgId)
/*     */     {
/* 139 */       int reduceRatio = SPetMarkConstants.getInstance().DIFFRENT_MARK_EXP_REDUSE_RATIO;
/* 140 */       addExp /= reduceRatio;
/*     */     }
/*     */     
/*     */ 
/* 144 */     PetMarkManager.addPetMarkExp(this.roleId, this.mainPetMarkId, xMainPetMarkInfo, addExp);
/*     */     
/*     */ 
/* 147 */     PetMarkManager.removePetMark(this.roleId, this.costPetMarkId, xRole2PetMarkInfo, PetMarkManager.RemovePetMarkReason.LEVEL_UP);
/*     */     
/*     */ 
/* 150 */     onSuccess(addExp, addPetMarkId, xMainPetMarkInfo, xRole2PetMarkInfo);
/*     */     
/* 152 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onSuccess(int addExp, long addPetMarkId, xbean.PetMarkInfo xPetMarkInfo, Role2PetMarkInfo xRole2PetMarkInfo)
/*     */   {
/* 159 */     SPetMarkUpgradeWithMarkSuccess proto = new SPetMarkUpgradeWithMarkSuccess();
/* 160 */     proto.main_pet_mark_id = this.mainPetMarkId;
/* 161 */     proto.cost_pet_mark_id = this.costPetMarkId;
/* 162 */     proto.add_exp = addExp;
/* 163 */     proto.now_level = xPetMarkInfo.getLevel();
/* 164 */     proto.now_exp = xPetMarkInfo.getExp();
/* 165 */     if (addPetMarkId > 0L)
/*     */     {
/* 167 */       xbean.PetMarkInfo xAddPetMarkInfo = (xbean.PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(Long.valueOf(addPetMarkId));
/* 168 */       mzm.gsp.petmark.PetMarkInfo petMarkInfoBean = new mzm.gsp.petmark.PetMarkInfo();
/* 169 */       petMarkInfoBean.pet_mark_cfg_id = xAddPetMarkInfo.getPet_mark_cfg_id();
/* 170 */       petMarkInfoBean.level = xAddPetMarkInfo.getLevel();
/* 171 */       petMarkInfoBean.exp = xAddPetMarkInfo.getExp();
/* 172 */       petMarkInfoBean.pet_id = xAddPetMarkInfo.getPet_id();
/* 173 */       proto.new_pet_mark_info_map.put(Long.valueOf(addPetMarkId), petMarkInfoBean);
/*     */     }
/*     */     
/* 176 */     OnlineManager.getInstance().send(this.roleId, proto);
/*     */     
/*     */ 
/* 179 */     String logstr = String.format("[petmark]PCPetMarkUpgradeWithMarkReq.onSuccess@PCPetMarkUpgradeWithMarkReq success|roleId=%d,mainPetMarkId=%d,costPetMarkId=%d,addExp=%d,xPetMarkInfo=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mainPetMarkId), Long.valueOf(this.costPetMarkId), Integer.valueOf(addExp), xPetMarkInfo });
/*     */     
/*     */ 
/* 182 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 185 */     PetMarkTLogManager.addPetMarkUpgradeTLog(this.roleId, this.mainPetMarkId, xPetMarkInfo.getPet_mark_cfg_id(), xPetMarkInfo.getLevel(), xPetMarkInfo.getExp(), addExp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 192 */     SPetMarkUpgradeWithMarkFail proto = new SPetMarkUpgradeWithMarkFail();
/* 193 */     proto.error_code = errorCode;
/* 194 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 197 */     String logstr = String.format("[petmark]PCPetMarkUpgradeWithMarkReq.onFail@PCPetMarkUpgradeWithMarkReq failed|roleId=%d,mainPetMarkId=%d,costPetMarkId=%d,reason=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mainPetMarkId), Long.valueOf(this.costPetMarkId), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 200 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\main\PCPetMarkUpgradeWithMarkReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */