/*    */ package mzm.gsp.legoushangcheng.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.legoushangcheng.SGetBuyInfoRsp;
/*    */ import mzm.gsp.legoushangcheng.confbean.LeGouShangChengConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.LeGouShangChengInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LeGouShangChengManager
/*    */ {
/*    */   static boolean checkRoleLevelAndServerTime(long roleId)
/*    */   {
/* 19 */     int roleLevel = RoleInterface.getLevel(roleId);
/* 20 */     if (roleLevel < LeGouShangChengConsts.getInstance().roleMinLevel)
/*    */     {
/* 22 */       return false;
/*    */     }
/* 24 */     long serverOpenTimeStamp = GameServerInfoManager.getOpenServerTimestamp();
/* 25 */     int diffDays = DateTimeUtils.diffDaysFromNow(serverOpenTimeStamp) + 1;
/* 26 */     return diffDays <= LeGouShangChengConsts.getInstance().dayCount;
/*    */   }
/*    */   
/*    */   static void synLeGouShangchengInfo(long roleId, LeGouShangChengInfo xLeGouShangChengInfo)
/*    */   {
/* 31 */     SGetBuyInfoRsp getBuyInfoRsp = new SGetBuyInfoRsp();
/* 32 */     if (xLeGouShangChengInfo != null)
/*    */     {
/* 34 */       Map<Integer, Integer> xCfgId2buyCount = xLeGouShangChengInfo.getCfgid2buycount();
/* 35 */       getBuyInfoRsp.cfgid2buycount.putAll(xCfgId2buyCount);
/*    */     }
/* 37 */     OnlineManager.getInstance().send(roleId, getBuyInfoRsp);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\legoushangcheng\main\LeGouShangChengManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */