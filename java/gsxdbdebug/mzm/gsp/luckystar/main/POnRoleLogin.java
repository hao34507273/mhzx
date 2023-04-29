/*    */ package mzm.gsp.luckystar.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.luckystar.confbean.SLuckyStarConsts;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import xbean.LuckyStarInfo;
/*    */ import xbean.Role2LuckyStarInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2luckystar;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 19 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     if (!LuckyStarManager.isLuckyStarSwitchOpen(roleId, false))
/*    */     {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/* 30 */     lock(Lockeys.get(xtable.User.getTable(), userId));
/*    */     
/* 32 */     int luckyStarActivityCfgId = SLuckyStarConsts.getInstance().LUCKY_STAR_ACTIVITY_CFG_ID;
/*    */     
/* 34 */     ActivityJoinResult activityJoinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, luckyStarActivityCfgId);
/*    */     
/* 36 */     if (!activityJoinResult.isCanJoin())
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     Role2LuckyStarInfo xRole2LuckyStarInfo = Role2luckystar.get(Long.valueOf(roleId));
/* 42 */     if (xRole2LuckyStarInfo != null)
/*    */     {
/* 44 */       Map<Integer, LuckyStarInfo> xLuckyStarInfoMap = xRole2LuckyStarInfo.getLucky_star_info_map();
/* 45 */       LuckyStarInfo xLuckyStarInfo = (LuckyStarInfo)xLuckyStarInfoMap.get(Integer.valueOf(luckyStarActivityCfgId));
/* 46 */       if (xLuckyStarInfo != null)
/*    */       {
/* 48 */         LuckyStarManager.sSyncLuckyStarInfo(roleId, xLuckyStarInfo);
/* 49 */         return true;
/*    */       }
/*    */     }
/*    */     
/* 53 */     LuckyStarManager.checkAndInitLuckyStarActivity(userId, roleId, luckyStarActivityCfgId, "POnRoleLogin.processImp");
/*    */     
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */