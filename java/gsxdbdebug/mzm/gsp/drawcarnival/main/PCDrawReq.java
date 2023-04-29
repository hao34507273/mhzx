/*     */ package mzm.gsp.drawcarnival.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.drawcarnival.SDrawError;
/*     */ import mzm.gsp.drawcarnival.SDrawRsp;
/*     */ import mzm.gsp.drawcarnival.confbean.DrawCarnivalPassItemCfg;
/*     */ import mzm.gsp.drawcarnival.confbean.SDrawCarnivalConsts;
/*     */ import mzm.gsp.drawcarnival.confbean.SDrawCarnivalPassTypeCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import xbean.DrawCarnivalActivityInfo;
/*     */ import xbean.DrawCarnivalGlobalInfo;
/*     */ import xbean.DrawCarnivalRoleActivityInfo;
/*     */ import xbean.DrawCarnivalRoleFreePassInfo;
/*     */ import xbean.DrawCarnivalRoleInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCDrawReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int passTypeId;
/*     */   final int passCount;
/*     */   final byte isUseYuanBao;
/*     */   final boolean isDelayAward;
/*     */   private static final String GS_LOG_CLASS_NAME = "PCDrawReq";
/*  31 */   private final Map<String, String> GS_LOG_PARAMS = new HashMap();
/*     */   
/*     */ 
/*     */   public PCDrawReq(long roleId, int passTypeId, int passCount, byte isUseYuanBao, boolean isDelayAward)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.passTypeId = passTypeId;
/*  38 */     this.passCount = passCount;
/*  39 */     this.isUseYuanBao = isUseYuanBao;
/*  40 */     this.isDelayAward = isDelayAward;
/*     */     
/*  42 */     this.GS_LOG_PARAMS.put("roleId", String.valueOf(this.roleId));
/*  43 */     this.GS_LOG_PARAMS.put("passTypeId", String.valueOf(this.passTypeId));
/*  44 */     this.GS_LOG_PARAMS.put("passCount", String.valueOf(this.passCount));
/*  45 */     this.GS_LOG_PARAMS.put("isUseYuanBao", String.valueOf(this.isUseYuanBao));
/*  46 */     this.GS_LOG_PARAMS.put("isDelayAward", String.valueOf(this.isDelayAward));
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  52 */     if ((this.passTypeId <= 0) || ((this.passCount != 1) && (this.passCount != 10)) || ((this.isUseYuanBao != 1) && (this.isUseYuanBao != 0)))
/*     */     {
/*     */ 
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  59 */     if (!OpenInterface.getOpenStatus(592))
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 2272, true))
/*     */     {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     SDrawCarnivalPassTypeCfg sDrawCarnivalPassTypeCfg = SDrawCarnivalPassTypeCfg.get(this.passTypeId);
/*  71 */     if (sDrawCarnivalPassTypeCfg == null)
/*     */     {
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*     */     
/*     */ 
/*  79 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  81 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  84 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, SDrawCarnivalConsts.getInstance().ACTIVITY_ID);
/*     */     
/*  86 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  88 */       this.GS_LOG_PARAMS.put("reasonValue", String.valueOf(activityJoinResult.getReasonValue()));
/*  89 */       DrawCarnivalManager.gsLog("draw_carnival", "PCDrawReq", "processImp", "cant join activity", this.GS_LOG_PARAMS, 2);
/*     */       
/*  91 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  95 */     DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo = DrawCarnivalManager.getDrawCarnivalGlobalInfoCreateIfNotExist();
/*  96 */     DrawCarnivalActivityInfo xDrawCarnivalActivityInfo = DrawCarnivalManager.getCurrentDrawCarnivalActivityInfoCreateIfNotExist(xDrawCarnivalGlobalInfo.getActivity_id2info());
/*     */     
/*     */ 
/*     */ 
/* 100 */     DrawCarnivalRoleInfo xDrawCarnivalRoleInfo = DrawCarnivalManager.getDrawCarnivalRoleInfoCreateIfNotExist(this.roleId);
/*     */     
/* 102 */     DrawCarnivalRoleActivityInfo xDrawCarnivalRoleActivityInfo = DrawCarnivalManager.getCurrentDrawCarnivalRoleActivityInfoCreateIfNotExist(this.roleId, xDrawCarnivalRoleInfo);
/*     */     
/*     */ 
/*     */ 
/* 106 */     DrawCarnivalManager.checkAndResetFreePasses(xDrawCarnivalRoleActivityInfo);
/*     */     
/* 108 */     DrawCarnivalRoleFreePassInfo xDrawCarnivalRoleFreePassInfo = (DrawCarnivalRoleFreePassInfo)xDrawCarnivalRoleActivityInfo.getFree_pass_type_id2info().get(Integer.valueOf(this.passTypeId));
/*     */     
/*     */ 
/* 111 */     SDrawError sDrawError = new SDrawError();
/* 112 */     sDrawError.is_use_yuan_bao = this.isUseYuanBao;
/* 113 */     sDrawError.pass_type_id = this.passTypeId;
/* 114 */     sDrawError.pass_count = this.passCount;
/* 115 */     DrawCarnivalManager.fillFreePassInfo(xDrawCarnivalRoleFreePassInfo, sDrawError.free_pass_info);
/*     */     
/*     */ 
/* 118 */     boolean ret = mzm.gsp.item.main.LotteryManager.canAdd(this.roleId, 15);
/* 119 */     if (!ret)
/*     */     {
/* 121 */       sDrawError.code = 4;
/* 122 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sDrawError);
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     SDrawRsp sDrawRsp = new SDrawRsp();
/* 127 */     sDrawRsp.pass_count = this.passCount;
/* 128 */     sDrawRsp.pass_type_id = this.passTypeId;
/* 129 */     sDrawRsp.is_use_yuan_bao = this.isUseYuanBao;
/*     */     
/* 131 */     if ((xDrawCarnivalRoleFreePassInfo.getCount() > 0) && (this.passCount == 1))
/*     */     {
/*     */ 
/* 134 */       if (this.isUseYuanBao == 1)
/*     */       {
/* 136 */         sDrawError.code = 2;
/* 137 */         OnlineManager.getInstance().sendAtOnce(this.roleId, sDrawError);
/* 138 */         DrawCarnivalManager.gsLog("draw_carnival", "PCDrawReq", "processImp", "has more free pass", this.GS_LOG_PARAMS, 2);
/*     */         
/* 140 */         return false;
/*     */       }
/*     */       
/* 143 */       ret = DrawCarnivalManager.draw(userId, this.roleId, this.passCount, sDrawCarnivalPassTypeCfg, xDrawCarnivalGlobalInfo, xDrawCarnivalActivityInfo, xDrawCarnivalRoleActivityInfo, xDrawCarnivalRoleFreePassInfo, sDrawRsp, sDrawError, true, this.isDelayAward, this.GS_LOG_PARAMS);
/*     */       
/*     */ 
/*     */ 
/* 147 */       return ret;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 152 */     DrawCarnivalPassItemCfg drawCarnivalPassItemCfg = DrawCarnivalPassItemCfg.get(this.passTypeId);
/* 153 */     if (drawCarnivalPassItemCfg == null)
/*     */     {
/* 155 */       DrawCarnivalManager.gsLog("draw_carnival", "PCDrawReq", "processImp", "drawCarnivalPassItemCfg null", this.GS_LOG_PARAMS, 2);
/*     */       
/* 157 */       return false;
/*     */     }
/* 159 */     UseItemsWithYuanBaoMakeUpResultInfo useItemsWithYuanBaoMakeUpResultInfo = DrawCarnivalManager.useItemsWithYuanBaoMakeUp(userId, this.roleId, drawCarnivalPassItemCfg.itemCfgIdList, this.passCount, sDrawCarnivalPassTypeCfg.yuanBaoPrice);
/*     */     
/*     */ 
/* 162 */     if (useItemsWithYuanBaoMakeUpResultInfo.result == 2)
/*     */     {
/* 164 */       sDrawError.code = 1;
/* 165 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sDrawError);
/* 166 */       DrawCarnivalManager.gsLog("draw_carnival", "PCDrawReq", "processImp", "cut yuan bao fail", this.GS_LOG_PARAMS, 2);
/*     */       
/* 168 */       return false;
/*     */     }
/* 170 */     if (useItemsWithYuanBaoMakeUpResultInfo.result == 3)
/*     */     {
/* 172 */       sDrawError.code = 3;
/* 173 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sDrawError);
/* 174 */       DrawCarnivalManager.gsLog("draw_carnival", "PCDrawReq", "processImp", "remove item fail", this.GS_LOG_PARAMS, 2);
/*     */       
/* 176 */       return false;
/*     */     }
/* 178 */     if (useItemsWithYuanBaoMakeUpResultInfo.result != 1)
/*     */     {
/* 180 */       DrawCarnivalManager.gsLog("draw_carnival", "PCDrawReq", "processImp", "useItemsWithYuanBaoMakeUpResultInfo error", this.GS_LOG_PARAMS, 2);
/*     */       
/* 182 */       return false;
/*     */     }
/* 184 */     if ((useItemsWithYuanBaoMakeUpResultInfo.yuanBaoToCost == 0) && (this.isUseYuanBao == 1))
/*     */     {
/* 186 */       return false;
/*     */     }
/*     */     
/* 189 */     sDrawRsp.cost_yuan_bao_count = useItemsWithYuanBaoMakeUpResultInfo.yuanBaoToCost;
/*     */     
/*     */ 
/* 192 */     ret = DrawCarnivalManager.draw(userId, this.roleId, this.passCount, sDrawCarnivalPassTypeCfg, xDrawCarnivalGlobalInfo, xDrawCarnivalActivityInfo, xDrawCarnivalRoleActivityInfo, xDrawCarnivalRoleFreePassInfo, sDrawRsp, sDrawError, false, this.isDelayAward, this.GS_LOG_PARAMS);
/*     */     
/*     */ 
/*     */ 
/* 196 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\PCDrawReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */