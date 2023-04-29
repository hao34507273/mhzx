/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.SMountsRefreshPassiveSkillSuccess;
/*     */ import mzm.gsp.mounts.confbean.MountsPassiveSkillBean;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.PassiveSkillInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2mounts;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCMountsRefreshPassiveSkill extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long mountsId;
/*     */   private final int passiveSkillCfgId;
/*     */   private final long clientYuanBao;
/*     */   private final int needYuanBao;
/*     */   private final int isUseYuanBao;
/*     */   
/*     */   public PCMountsRefreshPassiveSkill(long roleId, long mountsId, int passiveSkillCfgId, long currentYuanBao, int needYuanBao, int isUseYuanBao)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.mountsId = mountsId;
/*  33 */     this.passiveSkillCfgId = passiveSkillCfgId;
/*  34 */     this.clientYuanBao = currentYuanBao;
/*  35 */     this.needYuanBao = needYuanBao;
/*  36 */     this.isUseYuanBao = isUseYuanBao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if ((this.passiveSkillCfgId <= 0) || ((this.isUseYuanBao != 1) && (this.isUseYuanBao != 0)) || (this.clientYuanBao < 0L) || (this.needYuanBao < 0))
/*     */     {
/*     */ 
/*     */ 
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCMountsRefreshPassiveSkill.processImp"))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     if (!MountsManager.isLevelOpen(this.roleId, "PCMountsRefreshPassiveSkill.processImp"))
/*     */     {
/*  56 */       return false;
/*     */     }
/*  58 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  59 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  61 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1039, true, true))
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  67 */     if (xRole2MountsInfo == null)
/*     */     {
/*  69 */       onRefreshPassiveSkillFail(2);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     MountsInfo xMountsInfo = (MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(this.mountsId));
/*  74 */     if (xMountsInfo == null)
/*     */     {
/*  76 */       onRefreshPassiveSkillFail(4);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     PassiveSkillInfo xRefreshPassiveSkillInfo = null;
/*  81 */     for (PassiveSkillInfo xPassiveSkillInfo : xMountsInfo.getMounts_passive_skill_list())
/*     */     {
/*  83 */       if (xPassiveSkillInfo.getPassive_skill_cfg_id() == this.passiveSkillCfgId)
/*     */       {
/*  85 */         xRefreshPassiveSkillInfo = xPassiveSkillInfo;
/*     */       }
/*     */     }
/*     */     
/*  89 */     if (xRefreshPassiveSkillInfo == null)
/*     */     {
/*     */ 
/*  92 */       onRefreshPassiveSkillFail(5);
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     int mountsCfgId = xMountsInfo.getMounts_cfg_id();
/*  97 */     MountsPassiveSkillBean mountsPassiveSkillBean = MountsManager.getPassiveSkillCfgIdRank(mountsCfgId, this.passiveSkillCfgId);
/*     */     
/*  99 */     if (mountsPassiveSkillBean == null)
/*     */     {
/*     */ 
/* 102 */       onRefreshPassiveSkillFail(6);
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     Map<Integer, Integer> randomPassiveSkillProbMap = mountsPassiveSkillBean.randomPassiveSkillProbMap;
/* 107 */     if (mountsPassiveSkillBean.randomPassiveSkillProbMap.size() < 2)
/*     */     {
/*     */ 
/* 110 */       onRefreshPassiveSkillFail(50);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     if ((mountsPassiveSkillBean.randomPassiveSkillProbMap.size() == 2) && (xRefreshPassiveSkillInfo.getRefresh_passive_skill_cfg_id() != 0))
/*     */     {
/*     */ 
/* 117 */       onRefreshPassiveSkillFail(49);
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     boolean result = MountsManager.costItem(userId, this.roleId, this.isUseYuanBao, this.clientYuanBao, this.needYuanBao, mountsPassiveSkillBean.refreshCostItemType, mountsPassiveSkillBean.refreshCostItemId, mountsPassiveSkillBean.refreshCostItemNum, CostType.COST_BIND_FIRST_MOUNTS_REFRESH_SKILL, LogReason.MOUNTS_REFRESH_COST_ITEM);
/*     */     
/*     */ 
/*     */ 
/* 125 */     if (!result)
/*     */     {
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     int refreshPassiveSkillCfgId = MountsManager.getRefreshPassiveSkillCfgId(randomPassiveSkillProbMap, this.passiveSkillCfgId, xRefreshPassiveSkillInfo.getRefresh_passive_skill_cfg_id());
/*     */     
/* 132 */     xRefreshPassiveSkillInfo.setRefresh_passive_skill_cfg_id(refreshPassiveSkillCfgId);
/*     */     
/* 134 */     SMountsRefreshPassiveSkillSuccess refreshSuccess = new SMountsRefreshPassiveSkillSuccess();
/* 135 */     refreshSuccess.mounts_id = this.mountsId;
/* 136 */     refreshSuccess.refresh_passive_skill_result.current_passive_skill_cfg_id = this.passiveSkillCfgId;
/* 137 */     refreshSuccess.refresh_passive_skill_result.refresh_passive_skill_cfg_id = refreshPassiveSkillCfgId;
/*     */     
/* 139 */     OnlineManager.getInstance().send(this.roleId, refreshSuccess);
/*     */     
/* 141 */     MountsManager.tlogMountsRefreshPassiveSkill(userId, this.roleId, this.mountsId, xMountsInfo.getMounts_cfg_id(), xMountsInfo.getMounts_rank(), this.passiveSkillCfgId, refreshPassiveSkillCfgId, this.isUseYuanBao, xMountsInfo.getMounts_passive_skill_list());
/*     */     
/*     */ 
/*     */ 
/* 145 */     GameServer.logger().info(String.format("[mounts]PCMountsRefreshPassiveSkill.processImp@handle refresh passive skill cfg id success|role_id=%d|mounts_id=%d|passive_cfg_id=%d|refresh_passive_cfg_id=%d|is_use_yuan=%d|client_yuan_bao=%d|need_yuan_bao=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mountsId), Integer.valueOf(this.passiveSkillCfgId), Integer.valueOf(refreshPassiveSkillCfgId), Integer.valueOf(this.isUseYuanBao), Long.valueOf(this.clientYuanBao), Integer.valueOf(this.needYuanBao) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 150 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onRefreshPassiveSkillFail(int ret)
/*     */   {
/* 161 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 162 */     sMountsNormalFail.result = ret;
/* 163 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */     
/* 165 */     GameServer.logger().error(String.format("[mounts]PCMountsRefreshPassiveSkill.processImp@refresh passive skill failed|ret=%d|role_id=%d|mounts_id=%d|passive_skill_cfg_id=%d|is_use_yuan_bao=%b|current_yuan_bao=%d|need_yuan_bao=%d", new Object[] { Integer.valueOf(ret), Long.valueOf(this.roleId), Long.valueOf(this.mountsId), Integer.valueOf(this.passiveSkillCfgId), Integer.valueOf(this.isUseYuanBao), Long.valueOf(this.clientYuanBao), Integer.valueOf(this.needYuanBao) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCMountsRefreshPassiveSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */