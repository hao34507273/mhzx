/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.zhenyao.event.ZhenyaoActivityArg;
/*    */ import mzm.gsp.zhenyao.event.ZhenyaoActivityFinishedProcedure;
/*    */ 
/*    */ public class POnZhenyaoActivityFinished extends ZhenyaoActivityFinishedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     lock(xtable.Role2properties.getTable(), ((ZhenyaoActivityArg)this.arg).getRoleids());
/* 14 */     for (Iterator i$ = ((ZhenyaoActivityArg)this.arg).getRoleids().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 16 */       RoleVigorManager.getInstance().awardAward(roleId, 1, new TLogArg(mzm.gsp.tlog.LogReason.VIGOR_ADD__ZHENYAO, 0));
/*    */     }
/*    */     
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnZhenyaoActivityFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */