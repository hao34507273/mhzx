/*    */ package mzm.gsp.children.main;
/*    */ 
/*    */ import mzm.gsp.children.SAddChild;
/*    */ import mzm.gsp.children.confbean.SChildrenConsts;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.BabyPeriodInfo;
/*    */ import xbean.ChildInfo;
/*    */ 
/*    */ public class PGM_AddChildHealth extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long childId;
/*    */   private final int score;
/*    */   
/*    */   public PGM_AddChildHealth(long roleId, long childId, int score)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.childId = childId;
/* 20 */     this.score = score;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*    */     {
/* 28 */       notifyClient(this.roleId, "功能开关未打开");
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childId));
/* 33 */     if (xChildInfo == null)
/*    */     {
/* 35 */       notifyClient(this.roleId, "孩子不存在");
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     if (xChildInfo.getChild_period() != 0)
/*    */     {
/* 41 */       notifyClient(this.roleId, "孩子不是童年期");
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     BabyPeriodInfo xBabyPeriodInfo = xChildInfo.getBaby_period_info();
/* 46 */     xBabyPeriodInfo.setHealth_score(xBabyPeriodInfo.getHealth_score() + this.score);
/* 47 */     if (xBabyPeriodInfo.getHealth_score() > SChildrenConsts.getInstance().baby_to_childhood_need_health_value)
/*    */     {
/* 49 */       xBabyPeriodInfo.setHealth_score(SChildrenConsts.getInstance().baby_to_childhood_need_health_value);
/*    */     }
/*    */     
/* 52 */     SAddChild sAddChild = new SAddChild();
/* 53 */     sAddChild.child_id = this.childId;
/* 54 */     ChildrenManager.fillChildBean(xChildInfo.getOwn_role_id(), this.childId, xChildInfo, sAddChild.child_info, false);
/*    */     
/* 56 */     OnlineManager.getInstance().send(this.roleId, sAddChild);
/*    */     
/* 58 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(long roleId, String str)
/*    */   {
/* 63 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 64 */     messagetip.result = Integer.MAX_VALUE;
/* 65 */     messagetip.args.add(str);
/* 66 */     OnlineManager.getInstance().sendAtOnce(roleId, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PGM_AddChildHealth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */