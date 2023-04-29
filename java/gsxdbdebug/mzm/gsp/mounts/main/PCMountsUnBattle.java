/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.SMountsUnBattleSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleMountsInfo;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xtable.Role2mounts;
/*     */ 
/*     */ public class PCMountsUnBattle extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int cellId;
/*     */   
/*     */   public PCMountsUnBattle(long roleId, int cellId)
/*     */   {
/*  22 */     this.roleId = roleId;
/*  23 */     this.cellId = cellId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     if (this.cellId <= 0)
/*     */     {
/*  31 */       return false;
/*     */     }
/*     */     
/*  34 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCMountsUnBattle.processImp"))
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     if (!MountsManager.isLevelOpen(this.roleId, "PCMountsUnBattle.processImp"))
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  45 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*     */     
/*  47 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1044, true, true))
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  53 */     if (xRole2MountsInfo == null)
/*     */     {
/*  55 */       onMountsUnBattleFail(2);
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     BattleMountsInfo xBattleMountsInfo = (BattleMountsInfo)xRole2MountsInfo.getBattle_mounts_info_map().remove(Integer.valueOf(this.cellId));
/*  60 */     if (xBattleMountsInfo == null)
/*     */     {
/*  62 */       onMountsUnBattleFail(10);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     MountsInfo xMountsInfo = (MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(xBattleMountsInfo.getMounts_id()));
/*  67 */     if (xMountsInfo == null)
/*     */     {
/*  69 */       onMountsUnBattleFail(4);
/*  70 */       return false;
/*     */     }
/*  72 */     if (this.cellId == xRole2MountsInfo.getCurrent_chief_battle_mounts())
/*     */     {
/*  74 */       xRole2MountsInfo.setCurrent_chief_battle_mounts(-1);
/*     */     }
/*     */     
/*  77 */     MountsManager.triggerMountsRolePropertyChangeEvent(new mzm.gsp.mounts.event.MountsRolePropertyChangeArg(this.roleId));
/*     */     
/*  79 */     for (Iterator i$ = xBattleMountsInfo.getProtect_pet_id_list().iterator(); i$.hasNext();) { long petId = ((Long)i$.next()).longValue();
/*     */       
/*  81 */       MountsManager.triggerMountsPetPassiveSkillChangeEvent(new mzm.gsp.mounts.event.MountsPetPassiveSkillChangeArg(this.roleId, petId));
/*     */     }
/*     */     
/*  84 */     SMountsUnBattleSuccess sMountsUnBattleSuccess = new SMountsUnBattleSuccess();
/*  85 */     sMountsUnBattleSuccess.cell_id = this.cellId;
/*  86 */     OnlineManager.getInstance().send(this.roleId, sMountsUnBattleSuccess);
/*     */     
/*  88 */     MountsManager.tlogMountsBattle(userId, this.roleId, xBattleMountsInfo.getMounts_id(), xMountsInfo.getMounts_cfg_id(), xMountsInfo.getMounts_rank(), 0);
/*     */     
/*     */ 
/*  91 */     GameServer.logger().info(String.format("[mounts]PCMountsUnBattle.processImp@handle mounts un battle success|role_id=%d|cell_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.cellId) }));
/*     */     
/*     */ 
/*  94 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onMountsUnBattleFail(int ret)
/*     */   {
/* 105 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 106 */     sMountsNormalFail.result = ret;
/* 107 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */     
/* 109 */     GameServer.logger().error(String.format("[mounts]PCMountsUnBattle.processImp@handle mounts un battle success|ret=%d|role_id=%d|cell_id=%d", new Object[] { Integer.valueOf(ret), Long.valueOf(this.roleId), Integer.valueOf(this.cellId) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCMountsUnBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */