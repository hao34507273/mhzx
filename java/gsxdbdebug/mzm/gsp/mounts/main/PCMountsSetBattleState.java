/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.SMountsSetBattleStateSuccess;
/*     */ import mzm.gsp.mounts.confbean.SMountsConsts;
/*     */ import mzm.gsp.mounts.event.MountsRoleActiveSkillChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleMountsInfo;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xtable.Role2mounts;
/*     */ 
/*     */ public class PCMountsSetBattleState extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int cellId;
/*     */   private final int battleMountsState;
/*     */   
/*     */   public PCMountsSetBattleState(long roleId, int cellId, int battleMountsState)
/*     */   {
/*  26 */     this.roleId = roleId;
/*  27 */     this.cellId = cellId;
/*  28 */     this.battleMountsState = battleMountsState;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if ((this.cellId <= 0) || ((this.battleMountsState != 1) && (this.battleMountsState != 0)))
/*     */     {
/*     */ 
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCMountsSetBattleState.processImp"))
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!MountsManager.isLevelOpen(this.roleId, "PCMountsSetBattleState.processImp"))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  51 */     lock(xdb.Lockeys.get(xtable.User.getTable(), userId));
/*     */     
/*  53 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1043, true, true))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  59 */     if (xRole2MountsInfo == null)
/*     */     {
/*  61 */       onMountsSetBattleStateFail(2);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     Map<Integer, BattleMountsInfo> xBattleMountsInfoMap = xRole2MountsInfo.getBattle_mounts_info_map();
/*  66 */     BattleMountsInfo xBattleMountsInfo = (BattleMountsInfo)xBattleMountsInfoMap.get(Integer.valueOf(this.cellId));
/*  67 */     if (xBattleMountsInfo == null)
/*     */     {
/*  69 */       onMountsSetBattleStateFail(3);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     long mountsId = xBattleMountsInfo.getMounts_id();
/*  74 */     MountsInfo xMountsInfo = (MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(xBattleMountsInfo.getMounts_id()));
/*  75 */     if (xMountsInfo == null)
/*     */     {
/*  77 */       onMountsSetBattleStateFail(4);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     int xCurrentChiefBattleCellId = xRole2MountsInfo.getCurrent_chief_battle_mounts();
/*     */     
/*     */ 
/*  84 */     if ((this.battleMountsState == 0) && (xCurrentChiefBattleCellId == this.cellId))
/*     */     {
/*  86 */       xRole2MountsInfo.setCurrent_chief_battle_mounts(-1);
/*  87 */       MountsManager.triggerMountsRoleActiveSkillChangeEvent(new MountsRoleActiveSkillChangeArg(this.roleId));
/*     */     }
/*     */     
/*     */ 
/*  91 */     if ((this.battleMountsState == 1) && (xCurrentChiefBattleCellId != this.cellId))
/*     */     {
/*     */ 
/*  94 */       int chiefMountsCellId = SMountsConsts.getInstance().chiefMountsCellId;
/*     */       
/*  96 */       BattleMountsInfo xOldChiefBattleMountsInfo = (BattleMountsInfo)xBattleMountsInfoMap.get(Integer.valueOf(chiefMountsCellId));
/*  97 */       if ((xCurrentChiefBattleCellId == chiefMountsCellId) && (xOldChiefBattleMountsInfo != null))
/*     */       {
/*  99 */         swapBattleMountsInfo(xBattleMountsInfo, xOldChiefBattleMountsInfo, this.cellId, chiefMountsCellId, xBattleMountsInfoMap);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 104 */         if (xOldChiefBattleMountsInfo != null)
/*     */         {
/* 106 */           if (this.cellId == chiefMountsCellId)
/*     */           {
/* 108 */             xRole2MountsInfo.setCurrent_chief_battle_mounts(chiefMountsCellId);
/*     */           }
/*     */           else
/*     */           {
/* 112 */             swapBattleMountsInfo(xOldChiefBattleMountsInfo, xBattleMountsInfo, chiefMountsCellId, this.cellId, xBattleMountsInfoMap);
/*     */           }
/*     */           
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 119 */           BattleMountsInfo xChiefBattleMountsInfo = Pod.newBattleMountsInfo();
/* 120 */           xChiefBattleMountsInfo.setMounts_id(xBattleMountsInfo.getMounts_id());
/* 121 */           xChiefBattleMountsInfo.getProtect_pet_id_list().addAll(xBattleMountsInfo.getProtect_pet_id_list());
/*     */           
/* 123 */           xBattleMountsInfoMap.put(Integer.valueOf(chiefMountsCellId), xChiefBattleMountsInfo);
/* 124 */           xBattleMountsInfoMap.remove(Integer.valueOf(this.cellId));
/*     */         }
/* 126 */         xRole2MountsInfo.setCurrent_chief_battle_mounts(chiefMountsCellId);
/*     */       }
/*     */       
/* 129 */       MountsManager.triggerMountsRoleActiveSkillChangeEvent(new MountsRoleActiveSkillChangeArg(this.roleId));
/*     */     }
/*     */     
/* 132 */     MountsManager.tlogMountsSetChiefBattle(userId, this.roleId, mountsId, xMountsInfo.getMounts_cfg_id(), xMountsInfo.getMounts_rank(), this.battleMountsState);
/*     */     
/*     */ 
/* 135 */     SMountsSetBattleStateSuccess sSetBattleStateSuccess = new SMountsSetBattleStateSuccess();
/* 136 */     MountsManager.fillBattleMountsInfoProtocol(xRole2MountsInfo, sSetBattleStateSuccess.battle_mounts_info_map);
/*     */     
/* 138 */     OnlineManager.getInstance().send(this.roleId, sSetBattleStateSuccess);
/*     */     
/* 140 */     GameServer.logger().info(String.format("[mounts]PCMountsSetBattleState.processImp@protect pet success|role_id=%d|cell_id=%d|battle_mounts_state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.cellId), Integer.valueOf(this.battleMountsState) }));
/*     */     
/*     */ 
/*     */ 
/* 144 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onMountsSetBattleStateFail(int ret)
/*     */   {
/* 155 */     GameServer.logger().error(String.format("[mounts]PCMountsSetBattleState.processImp@protect pet failed|ret=%d|role_id=%d|cell_id=%d|battle_mounts_state=%d", new Object[] { Integer.valueOf(ret), Long.valueOf(this.roleId), Integer.valueOf(this.cellId), Integer.valueOf(this.battleMountsState) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 160 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 161 */     sMountsNormalFail.result = ret;
/* 162 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void swapBattleMountsInfo(BattleMountsInfo xBattleMountsInfoA, BattleMountsInfo xBattleMountsInfoB, int cellIdA, int cellIdB, Map<Integer, BattleMountsInfo> xBattleMountsInfoMap)
/*     */   {
/* 185 */     xBattleMountsInfoMap.remove(Integer.valueOf(cellIdA));
/* 186 */     xBattleMountsInfoMap.remove(Integer.valueOf(cellIdB));
/*     */     
/*     */ 
/* 189 */     BattleMountsInfo xNewBattleMountsInfoA = Pod.newBattleMountsInfo();
/* 190 */     BattleMountsInfo xNewBattleMountsInfoB = Pod.newBattleMountsInfo();
/*     */     
/*     */ 
/* 193 */     xNewBattleMountsInfoA.setMounts_id(xBattleMountsInfoB.getMounts_id());
/* 194 */     xNewBattleMountsInfoA.getProtect_pet_id_list().addAll(xBattleMountsInfoB.getProtect_pet_id_list());
/*     */     
/* 196 */     xNewBattleMountsInfoB.setMounts_id(xBattleMountsInfoA.getMounts_id());
/* 197 */     xNewBattleMountsInfoB.getProtect_pet_id_list().addAll(xBattleMountsInfoA.getProtect_pet_id_list());
/*     */     
/*     */ 
/* 200 */     xBattleMountsInfoMap.put(Integer.valueOf(cellIdA), xNewBattleMountsInfoA);
/* 201 */     xBattleMountsInfoMap.put(Integer.valueOf(cellIdB), xNewBattleMountsInfoB);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCMountsSetBattleState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */