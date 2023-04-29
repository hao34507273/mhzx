/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.visiblemonsterfight.event.KillLuanShiYaoMoArg;
/*    */ import mzm.gsp.visiblemonsterfight.event.KillLuanShiYaoMoProcedure;
/*    */ 
/*    */ public class POnKillLuanShiYaoMo extends KillLuanShiYaoMoProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     lock(xtable.Role2properties.getTable(), ((KillLuanShiYaoMoArg)this.arg).roleIds);
/* 14 */     for (Iterator i$ = ((KillLuanShiYaoMoArg)this.arg).roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 16 */       RoleVigorManager.getInstance().awardAward(roleId, 3, new TLogArg(mzm.gsp.tlog.LogReason.VIGOR_ADD__LUAN_SHI_YAO_MO, 0));
/*    */     }
/*    */     
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\POnKillLuanShiYaoMo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */