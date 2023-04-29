/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.SMountsReplacePassiveSkillSuccess;
/*     */ import mzm.gsp.mounts.event.MountsPetPassiveSkillChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleMountsInfo;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xtable.Role2mounts;
/*     */ 
/*     */ public class PCMountsReplacePassiveSkill extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long mountsId;
/*     */   private final int passiveSkillCfgId;
/*     */   
/*     */   public PCMountsReplacePassiveSkill(long roleId, long mountsId, int passiveSkillCfgId)
/*     */   {
/*  23 */     this.roleId = roleId;
/*  24 */     this.mountsId = mountsId;
/*  25 */     this.passiveSkillCfgId = passiveSkillCfgId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (this.passiveSkillCfgId <= 0)
/*     */     {
/*  33 */       return false;
/*     */     }
/*     */     
/*  36 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCMountsReplacePassiveSkill.processImp"))
/*     */     {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     if (!MountsManager.isLevelOpen(this.roleId, "PCMountsReplacePassiveSkill.processImp"))
/*     */     {
/*  43 */       return false;
/*     */     }
/*  45 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  46 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*     */     
/*  48 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1040, true, true))
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  54 */     if (xRole2MountsInfo == null)
/*     */     {
/*  56 */       onMountsReplacePassiveSkill(2);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     MountsInfo xMountsInfo = (MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(this.mountsId));
/*  61 */     if (xMountsInfo == null)
/*     */     {
/*  63 */       onMountsReplacePassiveSkill(4);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     xbean.PassiveSkillInfo xRefreshPassiveSkillInfo = null;
/*  68 */     for (xbean.PassiveSkillInfo xPassiveSkillInfo : xMountsInfo.getMounts_passive_skill_list())
/*     */     {
/*  70 */       if (xPassiveSkillInfo.getPassive_skill_cfg_id() == this.passiveSkillCfgId)
/*     */       {
/*  72 */         xRefreshPassiveSkillInfo = xPassiveSkillInfo;
/*     */       }
/*     */     }
/*     */     
/*  76 */     if (xRefreshPassiveSkillInfo == null)
/*     */     {
/*  78 */       onMountsReplacePassiveSkill(35);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     int refreshPassiveSkillCfgId = xRefreshPassiveSkillInfo.getRefresh_passive_skill_cfg_id();
/*  83 */     if (xRefreshPassiveSkillInfo.getRefresh_passive_skill_cfg_id() == 0)
/*     */     {
/*  85 */       onMountsReplacePassiveSkill(36);
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     BattleMountsInfo xBattleMountsInfo = MountsManager.getBattleMounts(this.roleId, this.mountsId, xRole2MountsInfo);
/*     */     Iterator i$;
/*  91 */     if (xBattleMountsInfo != null)
/*     */     {
/*  93 */       for (i$ = xBattleMountsInfo.getProtect_pet_id_list().iterator(); i$.hasNext();) { long petId = ((Long)i$.next()).longValue();
/*     */         
/*  95 */         MountsManager.triggerMountsPetPassiveSkillChangeEvent(new MountsPetPassiveSkillChangeArg(this.roleId, petId));
/*     */       }
/*     */     }
/*     */     
/*  99 */     xRefreshPassiveSkillInfo.setPassive_skill_cfg_id(refreshPassiveSkillCfgId);
/* 100 */     xRefreshPassiveSkillInfo.setRefresh_passive_skill_cfg_id(0);
/*     */     
/* 102 */     SMountsReplacePassiveSkillSuccess replacePassiveSkillSuccess = new SMountsReplacePassiveSkillSuccess();
/* 103 */     replacePassiveSkillSuccess.mounts_id = this.mountsId;
/* 104 */     replacePassiveSkillSuccess.old_passive_skill_cfg_id = this.passiveSkillCfgId;
/*     */     
/* 106 */     mzm.gsp.mounts.PassiveSkillInfo passiveSkillInfo = replacePassiveSkillSuccess.refresh_passive_skill_result;
/* 107 */     passiveSkillInfo.current_passive_skill_cfg_id = refreshPassiveSkillCfgId;
/* 108 */     passiveSkillInfo.refresh_passive_skill_cfg_id = 0;
/*     */     
/* 110 */     OnlineManager.getInstance().send(this.roleId, replacePassiveSkillSuccess);
/*     */     
/* 112 */     MountsManager.tlogMountsReplacePassiveSkill(userId, this.roleId, this.mountsId, xMountsInfo.getMounts_cfg_id(), xMountsInfo.getMounts_rank(), this.passiveSkillCfgId, refreshPassiveSkillCfgId, xMountsInfo.getMounts_passive_skill_list());
/*     */     
/*     */ 
/*     */ 
/* 116 */     GameServer.logger().info(String.format("[mounts]PCMountsReplacePassiveSkill.processImp@replace passive skill success|role_id=%d|mounts_id=%d|passive_skill_cfg_id=%d|now_passive_skill_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mountsId), Integer.valueOf(this.passiveSkillCfgId), Integer.valueOf(refreshPassiveSkillCfgId) }));
/*     */     
/*     */ 
/*     */ 
/* 120 */     return true;
/*     */   }
/*     */   
/*     */   private void onMountsReplacePassiveSkill(int ret)
/*     */   {
/* 125 */     GameServer.logger().error(String.format("[mounts]PCMountsReplacePassiveSkill.processImp@replace passive skill failed|ret=%d|role_id=%d|mounts_id=%d|passive_skill_cfg_id=%d", new Object[] { Integer.valueOf(ret), Long.valueOf(this.roleId), Long.valueOf(this.mountsId), Integer.valueOf(this.passiveSkillCfgId) }));
/*     */     
/*     */ 
/*     */ 
/* 129 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 130 */     sMountsNormalFail.result = ret;
/*     */     
/* 132 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCMountsReplacePassiveSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */