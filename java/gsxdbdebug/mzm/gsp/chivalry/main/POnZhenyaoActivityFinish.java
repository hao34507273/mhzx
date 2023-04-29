/*    */ package mzm.gsp.chivalry.main;
/*    */ 
/*    */ import mzm.gsp.chivalry.confbean.ChivalryConsts;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.zhenyao.event.ZhenyaoActivityArg;
/*    */ import mzm.gsp.zhenyao.event.ZhenyaoActivityFinishedProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnZhenyaoActivityFinish
/*    */   extends ZhenyaoActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     ChivalryManager.addFactionNewGuyTypeChivalry(((ZhenyaoActivityArg)this.arg).getRoleids(), 7, ChivalryConsts.getInstance().ZHEN_YAO_FACTION_ADD_PER_ONE_NEW_GUY, new TLogArg(LogReason.ZHEN_YAO_FACTION_TAKE_NEW_GUY_AWARD));
/*    */     
/*    */ 
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chivalry\main\POnZhenyaoActivityFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */