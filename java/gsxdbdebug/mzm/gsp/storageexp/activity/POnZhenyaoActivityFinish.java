/*    */ package mzm.gsp.storageexp.activity;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.zhenyao.event.ZhenyaoActivityArg;
/*    */ import mzm.gsp.zhenyao.event.ZhenyaoActivityFinishedProcedure;
/*    */ import mzm.gsp.zhenyao.main.ZhenyaoInterface;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ public class POnZhenyaoActivityFinish
/*    */   extends ZhenyaoActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     int activityId = ZhenyaoInterface.getZhenYaoActivityId();
/* 21 */     for (Iterator i$ = ((ZhenyaoActivityArg)this.arg).getRoleids().iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 23 */       Procedure.execute(new LogicProcedure()
/*    */       {
/*    */ 
/*    */         protected boolean processImp()
/*    */           throws Exception
/*    */         {
/*    */ 
/* 30 */           int count = ActivityInterface.getActivityCount(RoleInterface.getUserId(roleId), roleId, this.val$activityId, false);
/* 31 */           return LostAwardManager.onActivityCountAdd(roleId, this.val$activityId, count);
/*    */         }
/*    */       });
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\activity\POnZhenyaoActivityFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */