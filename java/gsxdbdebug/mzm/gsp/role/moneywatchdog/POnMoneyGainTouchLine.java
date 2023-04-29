/*    */ package mzm.gsp.role.moneywatchdog;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.event.MoneyGainTouchLineProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnMoneyGainTouchLine
/*    */   extends MoneyGainTouchLineProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     long roleId = ((MoneyGainTouchLineArg)this.arg).getRoleId();
/* 21 */     String userId = RoleInterface.getUserId(roleId);
/* 22 */     long totalCash = QingfuInterface.getTotalCash(userId, true);
/* 23 */     String fatalStr = String.format("RoleMoneyAbnormal|roleid=%d|role_level=%d|occupation_id=%d|currency_type=%d|current_value_sum=%d|total_cash=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(((MoneyGainTouchLineArg)this.arg).getCurLevel()), Integer.valueOf(((MoneyGainTouchLineArg)this.arg).getOccId()), Integer.valueOf(((MoneyGainTouchLineArg)this.arg).getCurrencyType()), Long.valueOf(((MoneyGainTouchLineArg)this.arg).getTotalValue()), Long.valueOf(totalCash) });
/*    */     
/*    */ 
/* 26 */     GameServer.surveillanceLogger().fatal(fatalStr);
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\moneywatchdog\POnMoneyGainTouchLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */