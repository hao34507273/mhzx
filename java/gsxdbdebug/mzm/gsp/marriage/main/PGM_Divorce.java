/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.marriage.SForceDivorceSucRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2marriage;
/*    */ 
/*    */ public class PGM_Divorce extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PGM_Divorce(long roleId)
/*    */   {
/* 15 */     this.roleid = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     Long marriageid = Role2marriage.select(Long.valueOf(this.roleid));
/* 21 */     if (marriageid == null) {
/* 22 */       return false;
/*    */     }
/* 24 */     xbean.Marriage xMarriage = xtable.Marriage.select(marriageid);
/* 25 */     if (xMarriage == null) {
/* 26 */       return false;
/*    */     }
/* 28 */     long roleidA = xMarriage.getRoleida();
/* 29 */     long roleidB = xMarriage.getRoleidb();
/* 30 */     java.util.List<Long> roleidsList = Arrays.asList(new Long[] { Long.valueOf(roleidA), Long.valueOf(roleidB) });
/* 31 */     lock(Role2marriage.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleidA), Long.valueOf(roleidB) }));
/* 32 */     boolean ret = MarriageManager.onForceDivorce(marriageid.longValue(), xMarriage);
/* 33 */     if (!ret) {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     SForceDivorceSucRes sForceDivorceSucRes = new SForceDivorceSucRes();
/* 38 */     OnlineManager.getInstance().sendMulti(sForceDivorceSucRes, roleidsList);
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PGM_Divorce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */