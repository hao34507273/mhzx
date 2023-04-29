/*    */ package mzm.gsp.husong.main;
/*    */ 
/*    */ import xbean.HuSongDataBean;
/*    */ 
/*    */ public class POnRoleoffLine extends mzm.gsp.online.event.PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     HuSongDataBean xHuSongDataBean = xtable.Role2husong.get((Long)this.arg);
/*  9 */     if (xHuSongDataBean != null)
/*    */     {
/* 11 */       xHuSongDataBean.getParammap().clear();
/* 12 */       HuSongManager.unsetRoleHuSongStatus(((Long)this.arg).longValue());
/*    */     }
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\husong\main\POnRoleoffLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */