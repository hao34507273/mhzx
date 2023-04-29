/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.SSyncBaoShiDuInfo;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Properties;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGMSetBaoShiDu
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int value;
/*    */   
/*    */   public PGMSetBaoShiDu(long roleId, int value)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.value = value;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     int baoShiDu = this.value;
/* 28 */     if (baoShiDu < 0)
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     Properties xProperties = Role2properties.get(Long.valueOf(this.roleId));
/* 33 */     if (baoShiDu >= RoleCommonConstants.getInstance().BAOSHIDU_LIMIT)
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     xProperties.setBaoshidu(baoShiDu);
/* 38 */     SSyncBaoShiDuInfo info = new SSyncBaoShiDuInfo();
/* 39 */     info.baoshudu = baoShiDu;
/* 40 */     OnlineManager.getInstance().send(this.roleId, info);
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PGMSetBaoShiDu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */