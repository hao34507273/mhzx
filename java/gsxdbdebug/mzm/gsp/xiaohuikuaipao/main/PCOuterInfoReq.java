/*    */ package mzm.gsp.xiaohuikuaipao.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.xiaohuikuaipao.SOuterInfoRsp;
/*    */ import mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoActivityCfg;
/*    */ import xbean.XiaoHuiKuaiPaoActivityInfo;
/*    */ import xbean.XiaoHuiKuaiPaoInfo;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCOuterInfoReq extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   final int activityId;
/*    */   
/*    */   public PCOuterInfoReq(long roleId, int activityId)
/*    */   {
/* 26 */     this.roleId = roleId;
/* 27 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (!OpenInterface.getOpenStatus(482))
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 40 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1844, true))
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 46 */     SActivityCfg activityCfg = SActivityCfg.get(this.activityId);
/* 47 */     if (activityCfg == null)
/*    */     {
/* 49 */       return false;
/*    */     }
/* 51 */     XiaoHuiKuaiPaoActivityCfg xiaoHuiKuaiPaoActivityCfg = XiaoHuiKuaiPaoActivityCfg.get(this.activityId);
/* 52 */     if (xiaoHuiKuaiPaoActivityCfg == null)
/*    */     {
/* 54 */       return false;
/*    */     }
/* 56 */     String userId = RoleInterface.getUserId(this.roleId);
/* 57 */     lock(User.getTable(), Arrays.asList(new String[] { userId }));
/* 58 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 59 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId);
/*    */     
/* 61 */     if (!activityJoinResult.isCanJoin())
/*    */     {
/* 63 */       return false;
/*    */     }
/*    */     
/* 66 */     SOuterInfoRsp outerInfoRsp = new SOuterInfoRsp();
/* 67 */     outerInfoRsp.activityid = this.activityId;
/*    */     
/* 69 */     XiaoHuiKuaiPaoActivityInfo xXiaoHuiKuaiPaoPointInfo = xtable.Role2xiaohuikuaipaoactivityinfo.get(Long.valueOf(this.roleId));
/*    */     
/* 71 */     if (xXiaoHuiKuaiPaoPointInfo == null)
/*    */     {
/* 73 */       outerInfoRsp.turninfo.accumulateturncount = 0;
/* 74 */       outerInfoRsp.turninfo.index = 0;
/* 75 */       outerInfoRsp.turninfo.ticketcount = 0;
/* 76 */       OnlineManager.getInstance().send(this.roleId, outerInfoRsp);
/* 77 */       return true;
/*    */     }
/* 79 */     Map<Integer, XiaoHuiKuaiPaoInfo> xActivityId2Info = xXiaoHuiKuaiPaoPointInfo.getActivityid2xiaohuikuaipaoinfo();
/* 80 */     if (!xActivityId2Info.containsKey(Integer.valueOf(this.activityId)))
/*    */     {
/* 82 */       outerInfoRsp.turninfo.accumulateturncount = 0;
/* 83 */       outerInfoRsp.turninfo.index = 0;
/* 84 */       outerInfoRsp.turninfo.ticketcount = 0;
/* 85 */       OnlineManager.getInstance().send(this.roleId, outerInfoRsp);
/* 86 */       return true;
/*    */     }
/* 88 */     XiaoHuiKuaiPaoInfo xXiaoHuiKuaiPaoInfo = (XiaoHuiKuaiPaoInfo)xActivityId2Info.get(Integer.valueOf(this.activityId));
/* 89 */     outerInfoRsp.turninfo.accumulateturncount = xXiaoHuiKuaiPaoInfo.getAccumulateturncount();
/* 90 */     outerInfoRsp.turninfo.index = xXiaoHuiKuaiPaoInfo.getIndex();
/* 91 */     outerInfoRsp.turninfo.ticketcount = xXiaoHuiKuaiPaoInfo.getTicketcount();
/*    */     
/* 93 */     OnlineManager.getInstance().send(this.roleId, outerInfoRsp);
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\PCOuterInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */