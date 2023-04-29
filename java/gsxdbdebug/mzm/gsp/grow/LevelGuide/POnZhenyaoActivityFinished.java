/*    */ package mzm.gsp.grow.LevelGuide;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.zhenyao.event.ZhenyaoActivityArg;
/*    */ import mzm.gsp.zhenyao.event.ZhenyaoActivityFinishedProcedure;
/*    */ import mzm.gsp.zhenyao.main.ZhenyaoInterface;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ public class POnZhenyaoActivityFinished
/*    */   extends ZhenyaoActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     int activityId = ZhenyaoInterface.getZhenYaoActivityId();
/* 18 */     for (Iterator i$ = ((ZhenyaoActivityArg)this.arg).getRoleids().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 20 */       Procedure.execute(new PFinishActivity(roleId, activityId, ((ZhenyaoActivityArg)this.arg).getKillMonsterNum()));
/*    */     }
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnZhenyaoActivityFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */