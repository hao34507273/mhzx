/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.marriage.SForceDivorceSucRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Role2marriage;
/*    */ 
/*    */ public class ForceDivorceSession extends Session
/*    */ {
/*    */   public ForceDivorceSession(long interval, long roleId)
/*    */   {
/* 16 */     super(interval, roleId);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 21 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 25 */         long roleid = ForceDivorceSession.this.getOwerId();
/* 26 */         Long marriageid = Role2marriage.select(Long.valueOf(roleid));
/* 27 */         if (marriageid == null) {
/* 28 */           GameServer.logger().info(String.format("ForceDivorceSession.processImp@不存在婚姻数据了|roleid=%d", new Object[] { Long.valueOf(ForceDivorceSession.this.getOwerId()) }));
/*    */           
/* 30 */           return false;
/*    */         }
/* 32 */         xbean.Marriage xMarriage = xtable.Marriage.select(marriageid);
/* 33 */         if (xMarriage == null) {
/* 34 */           GameServer.logger().info(String.format("ForceDivorceSession.processImp@不存在婚姻数据了|roleid=%d", new Object[] { Long.valueOf(ForceDivorceSession.this.getOwerId()) }));
/*    */           
/* 36 */           return false;
/*    */         }
/* 38 */         if (!xMarriage.getParammap().containsKey(Integer.valueOf(2))) {
/* 39 */           GameServer.logger().info(String.format("ForceDivorceSession.processImp@不存在强制离婚的人了|roleid=%d", new Object[] { Long.valueOf(ForceDivorceSession.this.getOwerId()) }));
/*    */           
/* 41 */           return false;
/*    */         }
/* 43 */         long roleidA = xMarriage.getRoleida();
/* 44 */         long roleidB = xMarriage.getRoleidb();
/* 45 */         java.util.List<Long> roleidsList = Arrays.asList(new Long[] { Long.valueOf(roleidA), Long.valueOf(roleidB) });
/* 46 */         lock(Role2marriage.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleidA), Long.valueOf(roleidB) }));
/* 47 */         boolean ret = MarriageManager.onForceDivorce(marriageid.longValue(), xMarriage);
/* 48 */         if (!ret) {
/* 49 */           return false;
/*    */         }
/* 51 */         xtable.Role2forcedivorcetimer.remove(Long.valueOf(roleid));
/*    */         
/* 53 */         SForceDivorceSucRes sForceDivorceSucRes = new SForceDivorceSucRes();
/* 54 */         OnlineManager.getInstance().sendMulti(sForceDivorceSucRes, roleidsList);
/* 55 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\ForceDivorceSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */