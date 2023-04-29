/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SMountsActiveStarLifeSuccess;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.confbean.MountsStarLifeLevelBean;
/*     */ import mzm.gsp.mounts.confbean.MountsStarLifePropertyBean;
/*     */ import mzm.gsp.mounts.confbean.SMountsStarLifeCfg;
/*     */ import mzm.gsp.mounts.event.MountsRolePropertyChangeArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BattleMountsInfo;
/*     */ import xbean.MountsInfo;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2mounts;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCMountsActiveStarLife extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long mountsId;
/*     */   private final int isUseYuanBao;
/*     */   private final long clientYuanBao;
/*     */   private final int needYuanBao;
/*     */   
/*     */   public PCMountsActiveStarLife(long roleId, long mountsId, int isUseYuanBao, long currentYuanBao, int needYuanBao)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.mountsId = mountsId;
/*  36 */     this.clientYuanBao = currentYuanBao;
/*  37 */     this.needYuanBao = needYuanBao;
/*  38 */     this.isUseYuanBao = isUseYuanBao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (((this.isUseYuanBao != 0) && (this.isUseYuanBao != 1)) || (this.needYuanBao < 0) || (this.clientYuanBao < 0L))
/*     */     {
/*     */ 
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCMountsActiveStarLife.processImp"))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!MountsManager.isLevelOpen(this.roleId, "PCMountsActiveStarLife.processImp"))
/*     */     {
/*  57 */       return false;
/*     */     }
/*  59 */     String userId = RoleInterface.getUserId(this.roleId);
/*  60 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  62 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1034, true, true))
/*     */     {
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     Role2MountsInfo xRole2MountsInfo = Role2mounts.get(Long.valueOf(this.roleId));
/*  68 */     if (xRole2MountsInfo == null)
/*     */     {
/*  70 */       onMountsActiveStarLifeFailed(2);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     MountsInfo xMountsInfo = (MountsInfo)xRole2MountsInfo.getMounts_info_map().get(Long.valueOf(this.mountsId));
/*  75 */     if (xMountsInfo == null)
/*     */     {
/*  77 */       onMountsActiveStarLifeFailed(4);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     int mountsCfgId = xMountsInfo.getMounts_cfg_id();
/*  82 */     SMountsStarLifeCfg sMountsStarLifeCfg = SMountsStarLifeCfg.get(mountsCfgId);
/*  83 */     if (sMountsStarLifeCfg == null)
/*     */     {
/*  85 */       onMountsActiveStarLifeFailed(25);
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     int currentStarLifeLevel = xMountsInfo.getCurrent_mounts_star_level();
/*  90 */     int currentStarMaxNum = xMountsInfo.getCurrent_max_star_num();
/*     */     
/*     */ 
/*  93 */     TreeMap<Integer, MountsStarLifeLevelBean> mountsStarLevelMap = sMountsStarLifeCfg.starLifeLevelMap;
/*     */     
/*  95 */     if (mountsStarLevelMap.isEmpty())
/*     */     {
/*  97 */       onMountsActiveStarLifeFailed(26);
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     MountsStarLifeLevelBean mountsStarLifeLevelBean = (MountsStarLifeLevelBean)mountsStarLevelMap.get(Integer.valueOf(currentStarLifeLevel));
/*     */     
/* 104 */     if (mountsStarLifeLevelBean == null)
/*     */     {
/* 106 */       onMountsActiveStarLifeFailed(26);
/* 107 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 111 */     TreeMap<Integer, MountsStarLifePropertyBean> moutsStarNumMap = mountsStarLifeLevelBean.starNumMap;
/* 112 */     if (moutsStarNumMap.isEmpty())
/*     */     {
/* 114 */       onMountsActiveStarLifeFailed(28);
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     if ((currentStarLifeLevel == ((Integer)mountsStarLevelMap.lastKey()).intValue()) && (currentStarMaxNum == ((Integer)moutsStarNumMap.lastKey()).intValue()))
/*     */     {
/* 120 */       onMountsActiveStarLifeFailed(27);
/* 121 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 125 */     if (currentStarMaxNum == ((Integer)moutsStarNumMap.lastKey()).intValue())
/*     */     {
/* 127 */       currentStarLifeLevel++;
/*     */       
/* 129 */       mountsStarLifeLevelBean = (MountsStarLifeLevelBean)sMountsStarLifeCfg.starLifeLevelMap.get(Integer.valueOf(currentStarLifeLevel));
/* 130 */       if (mountsStarLifeLevelBean == null)
/*     */       {
/*     */ 
/* 133 */         GameServer.logger().error(String.format("[mounts]PCMountsActiveStarLife.processImp@active mounts star life failed|current_star_life_level=%d|role_id=%d|mounts_id=%d|is_use_yuan_bao=%d|client_yuan_bao=%d|need_yuan_bao=%d|server_yuan_bao=%d", new Object[] { Integer.valueOf(currentStarLifeLevel), Long.valueOf(this.roleId), Long.valueOf(this.mountsId), Integer.valueOf(this.isUseYuanBao), Long.valueOf(this.clientYuanBao), Integer.valueOf(this.needYuanBao), Long.valueOf(this.clientYuanBao) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 138 */         onMountsActiveStarLifeFailed(26);
/*     */         
/* 140 */         return false;
/*     */       }
/* 142 */       currentStarMaxNum = 0;
/*     */     }
/*     */     
/* 145 */     MountsStarLifePropertyBean mountsStarLifePropertyBean = (MountsStarLifePropertyBean)mountsStarLifeLevelBean.starNumMap.get(Integer.valueOf(currentStarMaxNum + 1));
/* 146 */     if (mountsStarLifePropertyBean == null)
/*     */     {
/*     */ 
/* 149 */       GameServer.logger().error(String.format("[mounts]PCMountsActiveStarLife.processImp@star num cfg not exist|current_star_max_num=%d|role_id=%d|mounts_id=%d|is_use_yuan_bao=%d|current_yuan_bao=%d|need_yuan_bao=%d|server_yuan_bao=%d", new Object[] { Integer.valueOf(currentStarMaxNum), Long.valueOf(this.roleId), Long.valueOf(this.mountsId), Integer.valueOf(this.isUseYuanBao), Long.valueOf(this.clientYuanBao), Integer.valueOf(this.needYuanBao), Long.valueOf(this.clientYuanBao) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 154 */       onMountsActiveStarLifeFailed(28);
/* 155 */       return false;
/*     */     }
/*     */     
/* 158 */     int needUnLockRank = mountsStarLifePropertyBean.unLockRank;
/* 159 */     if (needUnLockRank > xMountsInfo.getMounts_rank())
/*     */     {
/* 161 */       onMountsActiveStarLifeFailed(29);
/* 162 */       return false;
/*     */     }
/*     */     
/* 165 */     boolean result = MountsManager.costItem(userId, this.roleId, this.isUseYuanBao, this.clientYuanBao, this.needYuanBao, mountsStarLifePropertyBean.costItemType, mountsStarLifePropertyBean.costItemId, mountsStarLifePropertyBean.costItemNum, CostType.COST_BIND_FIRST_MOUNTS_ACTIVE_STAR_LIFE, LogReason.MOUNTS_STAR_LIFE_UP_COST_ITEM);
/*     */     
/*     */ 
/*     */ 
/* 169 */     if (!result)
/*     */     {
/* 171 */       return false;
/*     */     }
/*     */     
/* 174 */     currentStarMaxNum++;
/* 175 */     xMountsInfo.setCurrent_max_star_num(currentStarMaxNum);
/* 176 */     xMountsInfo.setCurrent_mounts_star_level(currentStarLifeLevel);
/*     */     
/*     */ 
/* 179 */     for (BattleMountsInfo xBattleMountsInfo : xRole2MountsInfo.getBattle_mounts_info_map().values())
/*     */     {
/* 181 */       if (xBattleMountsInfo.getMounts_id() == this.mountsId)
/*     */       {
/* 183 */         MountsManager.triggerMountsRolePropertyChangeEvent(new MountsRolePropertyChangeArg(this.roleId));
/* 184 */         break;
/*     */       }
/*     */     }
/* 187 */     SMountsActiveStarLifeSuccess activeStarLifeSuccess = new SMountsActiveStarLifeSuccess();
/* 188 */     activeStarLifeSuccess.mounts_id = this.mountsId;
/* 189 */     if (currentStarMaxNum == ((Integer)mountsStarLifeLevelBean.starNumMap.lastKey()).intValue())
/*     */     {
/* 191 */       activeStarLifeSuccess.star_level = (currentStarLifeLevel + 1);
/* 192 */       activeStarLifeSuccess.star_num = 0;
/*     */     }
/*     */     else
/*     */     {
/* 196 */       activeStarLifeSuccess.star_level = currentStarLifeLevel;
/* 197 */       activeStarLifeSuccess.star_num = currentStarMaxNum;
/*     */     }
/*     */     
/* 200 */     OnlineManager.getInstance().send(this.roleId, activeStarLifeSuccess);
/*     */     
/* 202 */     MountsManager.tlogMountsActiveStarLife(userId, this.roleId, this.mountsId, xMountsInfo.getMounts_cfg_id(), xMountsInfo.getMounts_rank(), currentStarLifeLevel, currentStarMaxNum, this.isUseYuanBao);
/*     */     
/*     */ 
/* 205 */     GameServer.logger().info(String.format("[mounts]PCMountsActiveStarLife.processImp@handle active mounts star life success|role_id=%d|mounts_id=%d|current_star_level=%d|current_star_max_num=%d|is_use_yuan_bao=%d|client_yuan_bao=%d|need_yuan_bao=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.mountsId), Integer.valueOf(currentStarLifeLevel), Integer.valueOf(currentStarMaxNum), Integer.valueOf(this.isUseYuanBao), Long.valueOf(this.clientYuanBao), Integer.valueOf(this.needYuanBao) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 210 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onMountsActiveStarLifeFailed(int ret)
/*     */   {
/* 221 */     GameServer.logger().error(String.format("[mounts]PCMountsActiveStarLife.processImp@active mounts star life failed|ret=%d|role_id=%d|mounts_id=%d|is_use_yuan_bao=%d|client_yuan_bao=%d|need_yuan_bao=%d", new Object[] { Integer.valueOf(ret), Long.valueOf(this.roleId), Long.valueOf(this.mountsId), Integer.valueOf(this.isUseYuanBao), Long.valueOf(this.clientYuanBao), Integer.valueOf(this.needYuanBao) }));
/*     */     
/*     */ 
/*     */ 
/* 225 */     SMountsNormalFail sMountsNormalFail = new SMountsNormalFail();
/* 226 */     sMountsNormalFail.result = ret;
/*     */     
/* 228 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sMountsNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCMountsActiveStarLife.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */