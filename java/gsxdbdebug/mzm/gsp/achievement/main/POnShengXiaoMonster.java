/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.visiblemonsterfight.confbean.SShengXiaoFightConsts;
/*    */ import mzm.gsp.visiblemonsterfight.event.ShengXiaoMonsterArg;
/*    */ 
/*    */ public class POnShengXiaoMonster extends mzm.gsp.visiblemonsterfight.event.ShengXiaoMonsterEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (!((ShengXiaoMonsterArg)this.arg).isMonsterDead)
/*    */     {
/* 13 */       return false;
/*    */     }
/*    */     
/* 16 */     String logStr = "POnShengXiaoMonster.processImp@handle ACTIVITY_JOIN finish";
/* 17 */     int activityId = SShengXiaoFightConsts.getInstance().ACTIVITYID;
/* 18 */     for (Iterator i$ = ((ShengXiaoMonsterArg)this.arg).roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 20 */       xdb.Procedure.execute(new PUpdateGoalTypeState(roleId, 2400, Integer.valueOf(activityId), "POnShengXiaoMonster.processImp@handle ACTIVITY_JOIN finish"));
/*    */     }
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnShengXiaoMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */