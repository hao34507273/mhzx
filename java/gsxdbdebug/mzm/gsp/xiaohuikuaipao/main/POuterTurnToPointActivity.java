/*    */ package mzm.gsp.xiaohuikuaipao.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.mall.main.JifenOperateResult;
/*    */ import mzm.gsp.mall.main.MallInterface;
/*    */ import mzm.gsp.xiaohuikuaipao.confbean.XiaoHuiKuaiPaoTurnCountToPointActivityCfg;
/*    */ import xbean.XiaoHuiKuaiPaoActivityInfo;
/*    */ import xbean.XiaoHuiKuaiPaoInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POuterTurnToPointActivity extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   
/*    */   public POuterTurnToPointActivity(long roleId)
/*    */   {
/* 22 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*    */     
/* 30 */     lock(Lockeys.get(xtable.User.getTable(), userId));
/*    */     
/* 32 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*    */     
/* 34 */     XiaoHuiKuaiPaoActivityInfo xXiaoHuiKuaiPaoActivityInfo = xtable.Role2xiaohuikuaipaoactivityinfo.get(Long.valueOf(this.roleId));
/*    */     
/* 36 */     if (xXiaoHuiKuaiPaoActivityInfo == null)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 47 */     for (Map.Entry<Integer, XiaoHuiKuaiPaoTurnCountToPointActivityCfg> entry : XiaoHuiKuaiPaoTurnCountToPointActivityCfg.getAll().entrySet())
/*    */     {
/* 49 */       xiaoHuiKuaiPaoTurnCountToPointActivityCfg = (XiaoHuiKuaiPaoTurnCountToPointActivityCfg)entry.getValue();
/*    */       
/* 51 */       ActivityJoinResult activityJoinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, xiaoHuiKuaiPaoTurnCountToPointActivityCfg.compensateActivityId);
/*    */       
/* 53 */       if (activityJoinResult.isCanJoin())
/*    */       {
/*    */ 
/*    */ 
/* 57 */         for (i$ = xiaoHuiKuaiPaoTurnCountToPointActivityCfg.activityIdList.iterator(); i$.hasNext();) { int xhkpActivityId = ((Integer)i$.next()).intValue();
/*    */           
/* 59 */           if (xXiaoHuiKuaiPaoActivityInfo.getActivityid2xiaohuikuaipaoinfo().containsKey(Integer.valueOf(xhkpActivityId)))
/*    */           {
/*    */ 
/*    */ 
/* 63 */             XiaoHuiKuaiPaoInfo xXiaoHuiKuaiPaoInfo = (XiaoHuiKuaiPaoInfo)xXiaoHuiKuaiPaoActivityInfo.getActivityid2xiaohuikuaipaoinfo().get(Integer.valueOf(xhkpActivityId));
/* 64 */             if (xXiaoHuiKuaiPaoInfo.getIsouterturnconverttopoint() != 1)
/*    */             {
/*    */ 
/*    */ 
/* 68 */               int outerTurnCount = xXiaoHuiKuaiPaoInfo.getAccumulateturncount();
/* 69 */               if (outerTurnCount == 0)
/*    */               {
/* 71 */                 xXiaoHuiKuaiPaoInfo.setIsouterturnconverttopoint(1);
/*    */               }
/*    */               else {
/* 74 */                 int convertPointCount = outerTurnCount * xiaoHuiKuaiPaoTurnCountToPointActivityCfg.pointPerTurn;
/* 75 */                 JifenOperateResult jifenOperateResult = MallInterface.addJifen(this.roleId, convertPointCount, 12, true, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.XIAO_HUI_KUAI_PAO_OUTER_TURN_CONVERT_TO_POINT));
/*    */                 
/*    */ 
/* 78 */                 if (jifenOperateResult.isSuccess())
/*    */                 {
/*    */ 
/*    */ 
/* 82 */                   xXiaoHuiKuaiPaoInfo.setIsouterturnconverttopoint(1);
/*    */                   
/* 84 */                   XiaoHuiKuaiPaoTLogManager.tLogOuterTurnConvertPoint(this.roleId, xiaoHuiKuaiPaoTurnCountToPointActivityCfg.compensateActivityId, xhkpActivityId, outerTurnCount, convertPointCount);
/*    */                 }
/*    */               }
/*    */             }
/*    */           } } } }
/*    */     XiaoHuiKuaiPaoTurnCountToPointActivityCfg xiaoHuiKuaiPaoTurnCountToPointActivityCfg;
/*    */     Iterator i$;
/* 91 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\POuterTurnToPointActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */