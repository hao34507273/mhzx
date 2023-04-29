/*    */ package mzm.gsp.children.childhood;
/*    */ 
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.ChildInfo;
/*    */ import xbean.DailyCourseInfo;
/*    */ 
/*    */ public class PGM_ClearChildCourse extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final long childid;
/*    */   
/*    */   public PGM_ClearChildCourse(long gmRoleid, long roleid, long childid)
/*    */   {
/* 16 */     this.gmRoleid = gmRoleid;
/* 17 */     this.roleid = roleid;
/* 18 */     this.childid = childid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     ChildInfo xChildInfo = xtable.Children.get(Long.valueOf(this.childid));
/* 25 */     if (xChildInfo == null)
/*    */     {
/* 27 */       notifyClient("子女不存在");
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     if ((xChildInfo.getOwn_role_id() != this.roleid) && (xChildInfo.getAnother_parent_role_id() != this.roleid))
/*    */     {
/* 33 */       notifyClient("不是自己的子女");
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     if (xChildInfo.getChild_period() != 1)
/*    */     {
/* 39 */       notifyClient("子女不是童年期阶段");
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     xbean.ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/* 44 */     DailyCourseInfo xDailyCourseInfo = xChildhoodInfo.getDaily_curse();
/* 45 */     xDailyCourseInfo.setNum(0);
/* 46 */     xDailyCourseInfo.setLast_time(0L);
/*    */     
/* 48 */     notifyClient("清除每日学习课程次数成功");
/* 49 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 54 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 55 */     messagetip.result = Integer.MAX_VALUE;
/* 56 */     messagetip.args.add(str);
/* 57 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\childhood\PGM_ClearChildCourse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */