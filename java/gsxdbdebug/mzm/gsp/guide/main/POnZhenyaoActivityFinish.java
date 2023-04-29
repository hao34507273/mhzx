/*    */ package mzm.gsp.guide.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.zhenyao.event.ZhenyaoActivityArg;
/*    */ import mzm.gsp.zhenyao.event.ZhenyaoActivityFinishedProcedure;
/*    */ 
/*    */ public class POnZhenyaoActivityFinish extends ZhenyaoActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     int activityid = ((ZhenyaoActivityArg)this.arg).getActivityId();
/* 15 */     for (Iterator i$ = ((ZhenyaoActivityArg)this.arg).getRoleids().iterator(); i$.hasNext();) { final long roleid = ((Long)i$.next()).longValue();
/* 16 */       new LogicProcedure()
/*    */       {
/*    */         protected boolean processImp()
/*    */           throws Exception
/*    */         {
/* 21 */           String userId = RoleInterface.getUserId(roleid);
/* 22 */           GuideManager.activityGuideDeal(roleid, this.val$activityid, ActivityInterface.getActivityCount(userId, roleid, this.val$activityid, false));
/*    */           
/* 24 */           return true;
/*    */         }
/*    */       }.execute();
/*    */     }
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\POnZhenyaoActivityFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */