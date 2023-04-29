/*    */ package mzm.gsp.signaward.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Pod;
/*    */ import xbean.Sign;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2sign;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 22 */     String userid = RoleInterface.getUserId(roleId);
/* 23 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 25 */     Sign xSign = Role2sign.get(Long.valueOf(roleId));
/* 26 */     if (xSign == null)
/*    */     {
/* 28 */       xSign = Pod.newSign();
/* 29 */       xSign.setFillincount(0);
/* 30 */       xSign.setSigncount(0);
/* 31 */       xSign.setSigntime(0L);
/* 32 */       xSign.setSignday(0);
/* 33 */       xSign.setAwardedfillincount(0);
/*    */       
/* 35 */       Role2sign.insert(Long.valueOf(roleId), xSign);
/*    */     }
/*    */     
/* 38 */     long cur = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 40 */     long xSignTime = xSign.getSigntime();
/*    */     
/* 42 */     int signYearMonth = DateTimeUtils.getYear(xSignTime) * 100 + (DateTimeUtils.getMonth(xSignTime) + 1);
/*    */     
/* 44 */     int nowYearMonth = DateTimeUtils.getYear(cur) * 100 + (DateTimeUtils.getMonth(cur) + 1);
/* 45 */     long taotalcash = QingfuInterface.getSaveAmt(userid, true);
/* 46 */     int canAwardFillcount = SignAwardManager.getAwardfillcount(taotalcash);
/*    */     
/* 48 */     if (signYearMonth < nowYearMonth)
/*    */     {
/* 50 */       xSign.setSigncount(0);
/* 51 */       xSign.setSigntime(0L);
/* 52 */       xSign.setSignday(0);
/* 53 */       xSign.setFillincount(canAwardFillcount);
/* 54 */       xSign.setAwardedfillincount(canAwardFillcount);
/* 55 */       xSign.setCurrent_precious_cell_num(0);
/* 56 */       xSign.setCurrent_precious_box_buff_id(0);
/* 57 */       xSign.setLucky_box_sign_box_buff_id(0);
/* 58 */       xSign.setLucky_box_gold_precious_cfg_id(0);
/*    */       
/* 60 */       String logstr = String.format("[sign]POnRoleLogin.processImp@role init sign count|userid=%s|roleid=%d|addnum=%d|taotalcash=%d", new Object[] { userid, this.arg, Integer.valueOf(canAwardFillcount), Long.valueOf(taotalcash) });
/*    */       
/*    */ 
/* 63 */       SignAwardManager.logger.info(logstr);
/*    */     }
/*    */     else
/*    */     {
/* 67 */       int delta = canAwardFillcount - xSign.getAwardedfillincount();
/* 68 */       if (delta > 0)
/*    */       {
/* 70 */         xSign.setFillincount(xSign.getFillincount() + delta);
/* 71 */         xSign.setAwardedfillincount(canAwardFillcount);
/*    */         
/* 73 */         String logstr = String.format("[sign]POnRoleLogin.processImp@role add sign count|userid=%s|roleid=%d|addnum=%d|taotalcash=%d", new Object[] { userid, this.arg, Integer.valueOf(delta), Long.valueOf(taotalcash) });
/*    */         
/*    */ 
/* 76 */         SignAwardManager.logger.info(logstr);
/*    */       }
/*    */       else
/*    */       {
/* 80 */         String logstr = String.format("[sign]POnRoleLogin.processImp@role add no sign count|userid=%s|roleid=%d|addnum=%d|taotalcash=%d|canawardfillcount=%d|awardedcount=%d", new Object[] { userid, this.arg, Integer.valueOf(delta), Long.valueOf(taotalcash), Integer.valueOf(canAwardFillcount), Integer.valueOf(xSign.getAwardedfillincount()) });
/*    */         
/*    */ 
/* 83 */         SignAwardManager.logger.info(logstr);
/*    */       }
/*    */     }
/* 86 */     SignAwardManager.sendSSignInRes(roleId, xSign, cur, 0, 0);
/* 87 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */