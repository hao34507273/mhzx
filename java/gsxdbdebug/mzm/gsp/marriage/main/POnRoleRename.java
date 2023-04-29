/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.marriage.confbean.SMarriageTitileCfg;
/*    */ import mzm.gsp.role.event.RoleRenameProcedure;
/*    */ import mzm.gsp.title.main.TitleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnRoleRename extends RoleRenameProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     Long marriageId = xtable.Role2marriage.select((Long)this.arg);
/* 15 */     if (marriageId == null) {
/* 16 */       return false;
/*    */     }
/* 18 */     xbean.Marriage xMarriage = xtable.Marriage.select(marriageId);
/* 19 */     if (xMarriage == null) {
/* 20 */       return false;
/*    */     }
/* 22 */     int titleId = xMarriage.getMarriagetitle();
/* 23 */     SMarriageTitileCfg sMarriageTitileCfg = SMarriageTitileCfg.get(xMarriage.getMarriagetitle());
/* 24 */     if (sMarriageTitileCfg == null) {
/* 25 */       GameServer.logger().error(String.format("[Marriage]POnRoleRename.processImp@marriage title config is not exsit|cfgid=%d", new Object[] { Integer.valueOf(titleId) }));
/*    */       
/*    */ 
/* 28 */       return false;
/*    */     }
/* 30 */     String newName = mzm.gsp.role.main.RoleInterface.getName(((Long)this.arg).longValue());
/* 31 */     if (((Long)this.arg).longValue() == xMarriage.getRoleida()) {
/* 32 */       TitleInterface.replaceAppellationArgs(xMarriage.getRoleidb(), sMarriageTitileCfg.womenTitle, Arrays.asList(new String[] { newName }));
/*    */     }
/*    */     else {
/* 35 */       TitleInterface.replaceAppellationArgs(xMarriage.getRoleida(), sMarriageTitileCfg.manTitle, Arrays.asList(new String[] { newName }));
/*    */     }
/*    */     
/*    */ 
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\POnRoleRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */