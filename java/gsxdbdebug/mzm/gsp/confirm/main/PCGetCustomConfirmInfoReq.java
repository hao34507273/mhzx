/*    */ package mzm.gsp.confirm.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.confirm.SGetCustomConfirmInfoRep;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ 
/*    */ public class PCGetCustomConfirmInfoReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCGetCustomConfirmInfoReq(long roleId)
/*    */   {
/* 13 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     xbean.SystemSetting xSystemSetting = xtable.Role2systemsetting.get(Long.valueOf(this.roleId));
/* 21 */     if (xSystemSetting == null)
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     SGetCustomConfirmInfoRep p = new SGetCustomConfirmInfoRep();
/* 27 */     p.confirminfos.putAll(ConfirmManager.getConformInfos(xSystemSetting));
/* 28 */     OnlineManager.getInstance().send(this.roleId, p);
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confirm\main\PCGetCustomConfirmInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */