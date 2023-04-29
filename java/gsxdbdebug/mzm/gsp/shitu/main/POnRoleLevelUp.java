/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ import mzm.gsp.server.main.ServerInterface;
/*    */ import mzm.gsp.shitu.confbean.SMasterRecommendConsts;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import xbean.ApprenticeInfo;
/*    */ import xbean.role2ShiTuInfo;
/*    */ import xtable.Role2shitu;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLevelUp
/*    */   extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     long roleId = ((RoleLevelUpArg)this.arg).roleId;
/* 24 */     int oldLevel = ((RoleLevelUpArg)this.arg).oldLevel;
/* 25 */     int newLevel = ((RoleLevelUpArg)this.arg).newLevel;
/*    */     
/*    */ 
/* 28 */     if (!ShiTuManager.isShiTuRecommemdOpen(roleId))
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     int serverLevel = ServerInterface.getCurrentServerLevel();
/*    */     
/*    */ 
/* 36 */     if (serverLevel < SMasterRecommendConsts.getInstance().OPEN_SERVER_LEVEL)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (newLevel < SMasterRecommendConsts.getInstance().APPRENTICE_MIN_LEVEL)
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     if (oldLevel >= SMasterRecommendConsts.getInstance().APPRENTICE_MAX_LEVEL)
/*    */     {
/* 48 */       return false;
/*    */     }
/* 50 */     int oldInterval = (oldLevel - SMasterRecommendConsts.getInstance().APPRENTICE_MIN_LEVEL) / SMasterRecommendConsts.getInstance().RECOMMEND_INTERVAL_LEVEL;
/*    */     
/* 52 */     int newInterval = (newLevel - SMasterRecommendConsts.getInstance().APPRENTICE_MIN_LEVEL) / SMasterRecommendConsts.getInstance().RECOMMEND_INTERVAL_LEVEL;
/*    */     
/*    */ 
/* 55 */     if ((newInterval - oldInterval <= 0) && (oldLevel >= SMasterRecommendConsts.getInstance().APPRENTICE_MIN_LEVEL))
/*    */     {
/* 57 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 61 */     role2ShiTuInfo xShiTuInfo = Role2shitu.get(Long.valueOf(roleId));
/* 62 */     if (xShiTuInfo == null)
/*    */     {
/* 64 */       return false;
/*    */     }
/*    */     
/* 67 */     if (!RoleStatusInterface.checkCanSetStatus(roleId, 1643, false, true))
/*    */     {
/* 69 */       return false;
/*    */     }
/*    */     
/* 72 */     if (xShiTuInfo.getRefusemasterrecommend())
/*    */     {
/* 74 */       return false;
/*    */     }
/*    */     
/* 77 */     if (xShiTuInfo.getApprenticeinfo().getMasterroleid() > 0L)
/*    */     {
/* 79 */       return false;
/*    */     }
/*    */     
/* 82 */     int minLevel = Math.min(SMasterRecommendConsts.getInstance().MASTER_MIN_LEVEL, serverLevel - SMasterRecommendConsts.getInstance().MASTER_SERVER_DIVERSITY_LEVEL) - 1;
/*    */     
/*    */ 
/* 85 */     minLevel = Math.max(minLevel, newLevel);
/*    */     
/* 87 */     List<Long> recommendMasterRoleIdList = OnlineManager.getInstance().getOnlineHigherRoleidList(minLevel);
/* 88 */     if (recommendMasterRoleIdList.size() < SMasterRecommendConsts.getInstance().MIN_MASTER_RECOMMEND_NUM)
/*    */     {
/*    */ 
/* 91 */       ShiTuManager.triggerMasterRecommendEvent(roleId, recommendMasterRoleIdList, false);
/* 92 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 96 */     new PFilterAndSendMasterRecommend(roleId, recommendMasterRoleIdList).execute();
/*    */     
/* 98 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */