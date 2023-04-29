/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.hula.confbean.SHulaCfgConsts;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import xbean.HulaInfo;
/*    */ import xbean.HulaWorldInfo;
/*    */ import xtable.Hulaworld;
/*    */ import xtable.Role2hula;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     int stage = mzm.gsp.activity.main.ActivityInterface.getActivityStage(SHulaCfgConsts.getInstance().ACTIVITY_ID);
/* 18 */     if (stage == -1)
/*    */     {
/* 20 */       if ((!HulaManager.isInHulaPrepareWorld(((Long)this.arg).longValue())) && (!HulaManager.isInHulaFubenWorld(((Long)this.arg).longValue())))
/*    */       {
/* 22 */         RoleStatusInterface.unsetStatus(((Long)this.arg).longValue(), 450);
/* 23 */         return true;
/*    */       }
/*    */       
/*    */ 
/* 27 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 33 */     HulaInfo xHulaInfo = Role2hula.get((Long)this.arg);
/* 34 */     if (xHulaInfo == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     long key = GameServerInfoManager.toGlobalId(xHulaInfo.getWorldid());
/* 39 */     HulaWorldInfo xHulaWorldInfo = Hulaworld.get(Long.valueOf(key));
/* 40 */     if ((xHulaWorldInfo == null) || (!xHulaWorldInfo.getRoleids().contains(Long.valueOf(((Long)this.arg).longValue()))))
/*    */     {
/* 42 */       return false;
/*    */     }
/* 44 */     if ((RoleStatusInterface.containsStatus(((Long)this.arg).longValue(), 450)) && (MapInterface.getRoleWorldInstanceId(((Long)this.arg).longValue()) == xHulaInfo.getWorldid()))
/*    */     {
/*    */ 
/* 47 */       HulaManager.synSSynMonsterListRes(((Long)this.arg).longValue(), stage, xHulaInfo, xHulaWorldInfo);
/*    */     }
/*    */     
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */