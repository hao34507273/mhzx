/*    */ package mzm.gsp.makeup.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.event.GangDissolveProcedure;
/*    */ import xbean.FactionMakeUpInfo;
/*    */ import xtable.Gangmakeup;
/*    */ 
/*    */ 
/*    */ public class POnGangInfoChange
/*    */   extends GangDissolveProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     FactionMakeUpInfo xFactionMakeUpInfo = Gangmakeup.get(Long.valueOf(((GangArg)this.arg).gangId));
/* 17 */     if (xFactionMakeUpInfo == null)
/*    */     {
/* 19 */       return false;
/*    */     }
/* 21 */     xFactionMakeUpInfo.getActivityid2record().clear();
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\main\POnGangInfoChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */