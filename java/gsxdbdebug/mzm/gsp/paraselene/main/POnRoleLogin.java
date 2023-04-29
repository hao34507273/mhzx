/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.paraselene.confbean.SParaseleneCfgConsts;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import xbean.Paraselene;
/*    */ import xtable.Role2paraselene;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     long starttime = ParaseleneManager.getActivityStartTime();
/* 24 */     if (!ParaseleneManager.isInParaseleneWorld(((Long)this.arg).longValue()))
/*    */     {
/*    */ 
/* 27 */       RoleStatusInterface.unsetStatus(((Long)this.arg).longValue(), 12);
/*    */ 
/*    */     }
/* 30 */     else if (!ActivityInterface.isActivityOpen(SParaseleneCfgConsts.getInstance().ActivityId))
/*    */     {
/* 32 */       RoleStatusInterface.unsetStatus(((Long)this.arg).longValue(), 12);
/* 33 */       if (ParaseleneManager.isInParaseleneWorld(((Long)this.arg).longValue()))
/*    */       {
/* 35 */         GangInterface.transferToGangMapAsyc(((Long)this.arg).longValue());
/*    */       }
/*    */     }
/*    */     
/* 39 */     Paraselene paraselene = Role2paraselene.get((Long)this.arg);
/* 40 */     if (paraselene != null)
/*    */     {
/*    */ 
/* 43 */       paraselene.setRecentlayer(0);
/* 44 */       if (paraselene.getStarttime() >= starttime)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 50 */         ParaseleneManager.rankRole(((Long)this.arg).longValue(), (int)TimeUnit.MILLISECONDS.toSeconds(paraselene.getFinishtime() - paraselene.getStarttime()));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */