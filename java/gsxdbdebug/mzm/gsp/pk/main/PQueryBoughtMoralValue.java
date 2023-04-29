/*    */ package mzm.gsp.pk.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pk.SQueryBoughtMoralValueRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RolePKInformation;
/*    */ 
/*    */ 
/*    */ public class PQueryBoughtMoralValue
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PQueryBoughtMoralValue(long roleId)
/*    */   {
/* 17 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (PKManager.isNotEnable())
/*    */     {
/* 25 */       return false;
/*    */     }
/* 27 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     RolePKInformation xRolePKInformation = PKManager.getRolePKInformation(this.roleId);
/* 32 */     if (xRolePKInformation == null)
/*    */     {
/* 34 */       response(0);
/*    */     }
/*    */     else
/*    */     {
/* 38 */       response(xRolePKInformation.getBought_moral_value());
/*    */     }
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   private void response(int boughtMoralValue)
/*    */   {
/* 45 */     SQueryBoughtMoralValueRes res = new SQueryBoughtMoralValueRes();
/* 46 */     res.bought_moral_value = boughtMoralValue;
/* 47 */     OnlineManager.getInstance().send(this.roleId, res);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PQueryBoughtMoralValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */