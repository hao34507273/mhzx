/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class RedeemBangGongObserver
/*    */   extends DateObserver
/*    */ {
/* 15 */   public static long UPDATE_TIMESTAMP = 0L;
/*    */   
/*    */   public RedeemBangGongObserver(int timeCommonCfgId) {
/* 18 */     super(timeCommonCfgId);
/* 19 */     UPDATE_TIMESTAMP = getPrevTriggerTime();
/*    */   }
/*    */   
/*    */   protected boolean onTimeOut()
/*    */   {
/* 24 */     UPDATE_TIMESTAMP = DateTimeUtils.getCurrTimeInMillis();
/* 25 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception {
/* 28 */         List<Long> roles = OnlineManager.getInstance().getAllRolesInWorld();
/* 29 */         for (final Long roleId : roles) {
/* 30 */           NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */           {
/*    */             protected boolean processImp() throws Exception
/*    */             {
/* 34 */               GangMember xGangMember = Role2gangmember.get(roleId);
/* 35 */               if (xGangMember == null) {
/* 36 */                 return false;
/*    */               }
/* 38 */               long gangId = xGangMember.getGangid();
/*    */               
/* 40 */               xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/* 41 */               if ((xGang == null) || (!GangManager.isInGang(xGang, roleId.longValue()))) {
/* 42 */                 return false;
/*    */               }
/* 44 */               xGangMember.setRedeembanggong(0L);
/* 45 */               xGangMember.setYuanbao_redeem_bang_gong(0);
/* 46 */               xGangMember.setNextupdateredeemtimestamp(DateTimeUtils.getCurrTimeInMillis());
/* 47 */               return true;
/*    */             }
/*    */           });
/*    */         }
/* 51 */         return true;
/*    */       }
/* 53 */     }.execute();
/* 54 */     return true;
/*    */   }
/*    */   
/*    */   public static boolean checkUpdate(long updateTimeStamp) {
/* 58 */     return updateTimeStamp < UPDATE_TIMESTAMP;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RedeemBangGongObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */