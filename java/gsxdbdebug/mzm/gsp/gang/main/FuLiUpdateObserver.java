/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.confbean.SGangCangKuCfg;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CangKu;
/*    */ 
/*    */ public class FuLiUpdateObserver
/*    */   extends DateObserver
/*    */ {
/*    */   public FuLiUpdateObserver()
/*    */   {
/* 18 */     super(SGangConst.getInstance().GANG_FULI_REFRESH_TIME_ID);
/*    */   }
/*    */   
/*    */   protected boolean onTimeOut()
/*    */   {
/* 23 */     Set<Long> gangIdSet = GangManager.getAllGangIdSet();
/* 24 */     for (final Long gangId : gangIdSet) {
/* 25 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */       {
/*    */         protected boolean processImp() throws Exception
/*    */         {
/* 29 */           xbean.Gang xGang = xtable.Gang.get(gangId);
/* 30 */           if (xGang == null) {
/* 31 */             return false;
/*    */           }
/* 33 */           CangKu xCangKu = xGang.getCangku();
/* 34 */           SGangCangKuCfg sGangCangKuCfg = SGangCangKuCfg.get(xCangKu.getLevel());
/* 35 */           if (sGangCangKuCfg == null)
/*    */           {
/* 37 */             xCangKu.setAvaliablefulinum(xCangKu.getFulinumtotal());
/* 38 */             String logStr = String.format("FuLiUpdateObserver.onTimeOut@can not find SGangCangKuCfg|cangkulevel=%d|gangid=%d", new Object[] { Integer.valueOf(xGang.getCangku().getLevel()), gangId });
/*    */             
/* 40 */             GangManager.logger.error(logStr);
/*    */           }
/*    */           else {
/* 43 */             xCangKu.setFulinumtotal(sGangCangKuCfg.fuLiNum);
/* 44 */             xCangKu.setAvaliablefulinum(sGangCangKuCfg.fuLiNum);
/*    */           }
/*    */           
/* 47 */           xCangKu.setLastupdatefulitime(DateTimeUtils.getCurrTimeInMillis());
/* 48 */           return true;
/*    */         }
/*    */       });
/*    */     }
/* 52 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\FuLiUpdateObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */