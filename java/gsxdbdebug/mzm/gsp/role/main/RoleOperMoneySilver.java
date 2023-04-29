/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.event.BasicEvent;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.role.event.MoneyChangeArg;
/*    */ import mzm.gsp.role.event.SilveValueChange;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.yuanbao.main.CurrencyType;
/*    */ import xbean.Properties;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleOperMoneySilver
/*    */   extends RoleOperMoney
/*    */ {
/*    */   public RoleOperMoneySilver(long roleId, long addValue, TLogArg arg, boolean withinMax)
/*    */   {
/* 24 */     super(roleId, addValue, arg, withinMax);
/*    */   }
/*    */   
/*    */   public RoleOperMoneySilver(long roleId, long changeValue, TLogArg arg)
/*    */   {
/* 29 */     super(roleId, changeValue, arg);
/*    */   }
/*    */   
/*    */ 
/*    */   public long getRoleOwnMoney(Properties xProperties)
/*    */   {
/* 35 */     return xProperties.getSilver();
/*    */   }
/*    */   
/*    */ 
/*    */   public long getRoleCanOwnMoneyMax()
/*    */   {
/* 41 */     return AwardInterface.getMoneyOwnMax(3);
/*    */   }
/*    */   
/*    */ 
/*    */   public int reachMaxErrCode()
/*    */   {
/* 47 */     return 10;
/*    */   }
/*    */   
/*    */ 
/*    */   public long setXMoneyValue(Properties xProperties, long value)
/*    */   {
/* 53 */     xProperties.setSilver(value);
/* 54 */     return xProperties.getSilver();
/*    */   }
/*    */   
/*    */ 
/*    */   public CurrencyType getCurrencyType()
/*    */   {
/* 60 */     return CurrencyType.CURRENCY_SILVE;
/*    */   }
/*    */   
/*    */ 
/*    */   BasicEvent<MoneyChangeArg> getEvent()
/*    */   {
/* 66 */     return new SilveValueChange();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleOperMoneySilver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */