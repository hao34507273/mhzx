/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.paraselene.SStartJigsawRes;
/*    */ import mzm.gsp.paraselene.confbean.SJigsawCfg;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xtable.Jigsawinfo;
/*    */ import xtable.Role2jigsaw;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLoginSendJigsaw
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     Long jigsawid = Role2jigsaw.select((Long)this.arg);
/* 23 */     if (jigsawid == null)
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 29 */     Integer cfgid = Jigsawinfo.selectCfgid(jigsawid);
/* 30 */     Long endtime = Jigsawinfo.selectEndtime(jigsawid);
/* 31 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 32 */     if ((cfgid == null) || (endtime == null) || (endtime.longValue() < now))
/*    */     {
/* 34 */       Role2jigsaw.remove((Long)this.arg);
/* 35 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 39 */     SJigsawCfg jigsawCfg = SJigsawCfg.get(cfgid.intValue());
/* 40 */     if (jigsawCfg == null)
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     long clientendtime = TimeUnit.MILLISECONDS.toSeconds(endtime.longValue()) + 1L;
/*    */     
/* 47 */     SStartJigsawRes res = new SStartJigsawRes();
/* 48 */     res.endtime = clientendtime;
/* 49 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), res);
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\POnRoleLoginSendJigsaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */