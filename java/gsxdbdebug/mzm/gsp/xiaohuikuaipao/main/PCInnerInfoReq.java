/*    */ package mzm.gsp.xiaohuikuaipao.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.xiaohuikuaipao.SInnerInfoRsp;
/*    */ import mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoActivityCfg;
/*    */ import xbean.XiaoHuiKuaiPaoActivityInfo;
/*    */ import xbean.XiaoHuiKuaiPaoInfo;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCInnerInfoReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   final int activityId;
/*    */   
/*    */   public PCInnerInfoReq(long roleId, int activityId)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!OpenInterface.getOpenStatus(482))
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 39 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1842, true))
/*    */     {
/* 41 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 45 */     SActivityCfg activityCfg = SActivityCfg.get(this.activityId);
/* 46 */     if (activityCfg == null)
/*    */     {
/* 48 */       return false;
/*    */     }
/* 50 */     XiaoHuiKuaiPaoActivityCfg xiaoHuiKuaiPaoActivityCfg = XiaoHuiKuaiPaoActivityCfg.get(this.activityId);
/* 51 */     if (xiaoHuiKuaiPaoActivityCfg == null)
/*    */     {
/* 53 */       return false;
/*    */     }
/* 55 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 56 */     lock(User.getTable(), Arrays.asList(new String[] { userId }));
/* 57 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 58 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId);
/*    */     
/* 60 */     if (!activityJoinResult.isCanJoin())
/*    */     {
/* 62 */       return false;
/*    */     }
/*    */     
/* 65 */     SInnerInfoRsp innerInfoRsp = new SInnerInfoRsp();
/* 66 */     innerInfoRsp.activityid = this.activityId;
/*    */     
/* 68 */     XiaoHuiKuaiPaoActivityInfo xXiaoHuiKuaiPaoActivityInfo = xtable.Role2xiaohuikuaipaoactivityinfo.get(Long.valueOf(this.roleId));
/*    */     
/* 70 */     if (xXiaoHuiKuaiPaoActivityInfo == null)
/*    */     {
/* 72 */       innerInfoRsp.innerinfo.ticketcount = 0;
/* 73 */       OnlineManager.getInstance().send(this.roleId, innerInfoRsp);
/* 74 */       return true;
/*    */     }
/* 76 */     XiaoHuiKuaiPaoInfo xXiaoHuiKuaiPaoInfo = (XiaoHuiKuaiPaoInfo)xXiaoHuiKuaiPaoActivityInfo.getActivityid2xiaohuikuaipaoinfo().get(Integer.valueOf(this.activityId));
/*    */     
/* 78 */     if (xXiaoHuiKuaiPaoInfo == null)
/*    */     {
/* 80 */       innerInfoRsp.innerinfo.ticketcount = 0;
/* 81 */       OnlineManager.getInstance().send(this.roleId, innerInfoRsp);
/* 82 */       return true;
/*    */     }
/*    */     
/* 85 */     innerInfoRsp.innerinfo.ticketcount = xXiaoHuiKuaiPaoInfo.getTicketcount();
/* 86 */     innerInfoRsp.innerinfo.hitindexes.addAll(xXiaoHuiKuaiPaoInfo.getHitindexes());
/* 87 */     OnlineManager.getInstance().send(this.roleId, innerInfoRsp);
/* 88 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\PCInnerInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */