/*    */ package mzm.gsp.grow.LevelGuide;
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
/* 15 */     int activityId = SShengXiaoFightConsts.getInstance().ACTIVITYID;
/* 16 */     for (Iterator i$ = ((ShengXiaoMonsterArg)this.arg).roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 18 */       xdb.Procedure.execute(new PFinishActivity(roleId, activityId, 1));
/*    */     }
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\LevelGuide\POnShengXiaoMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */