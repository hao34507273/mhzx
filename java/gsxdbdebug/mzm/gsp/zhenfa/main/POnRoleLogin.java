/*    */ package mzm.gsp.zhenfa.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.zhenfa.SSyncAllZhenfaInfo;
/*    */ import mzm.gsp.zhenfa.ZhenfaBean;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     long roleId = ((Long)this.arg).longValue();
/* 16 */     RoleZhenfaInfo roleZhenfaInfo = ZhenfaInterface.getRoleZhenfaInfo(roleId);
/*    */     
/* 18 */     SSyncAllZhenfaInfo allZhenfaInfo = new SSyncAllZhenfaInfo();
/* 19 */     for (RoleZhenfaInfo.ZhenfaBeanInfo zhenfaBean : roleZhenfaInfo.getAllZhenfaBeans()) {
/* 20 */       allZhenfaInfo.zhenfabeanlist.add(new ZhenfaBean(zhenfaBean.getZhenfaId(), zhenfaBean.getZhenfalevel(), zhenfaBean.getZhenfaexp()));
/*    */     }
/* 22 */     OnlineManager.getInstance().send(roleId, allZhenfaInfo);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */