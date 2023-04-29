/*    */ package mzm.gsp.fabao.main;
/*    */ 
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import xbean.Item;
/*    */ import xbean.RoleFabaoSysInfo;
/*    */ 
/*    */ public class PChangeDisPlayFabao extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int fabaoType;
/*    */   
/*    */   public PChangeDisPlayFabao(long roleid, int faobaotype)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.fabaoType = faobaotype;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     if ((!OpenInterface.getOpenStatus(97)) || (OpenInterface.isBanPlay(this.roleid, 97)))
/*    */     {
/* 22 */       OpenInterface.sendBanPlayMsg(this.roleid, 97);
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.createIfNotExist(this.roleid);
/* 27 */     Item xItem = (Item)xRoleFabaoSysInfo.getFabaomap().get(Integer.valueOf(this.fabaoType));
/* 28 */     int fabaoCfgid = 0;
/* 29 */     if (xItem == null) {
/* 30 */       if (this.fabaoType > 0) {
/* 31 */         sendErrorRes(1);
/* 32 */         return false;
/*    */       }
/*    */     } else {
/* 35 */       fabaoCfgid = xItem.getCfgid();
/*    */     }
/* 37 */     FabaoManager.onFaBaoDisplayChange(this.roleid, xRoleFabaoSysInfo, fabaoCfgid, this.fabaoType);
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   private void sendErrorRes(int errorcode) {
/* 42 */     mzm.gsp.fabao.SChangeDisPlayFabaoErrorRes changeDisPlayFabaoErrorRes = new mzm.gsp.fabao.SChangeDisPlayFabaoErrorRes();
/* 43 */     changeDisPlayFabaoErrorRes.errorcode = errorcode;
/* 44 */     mzm.gsp.online.main.OnlineManager.getInstance().sendAtOnce(this.roleid, changeDisPlayFabaoErrorRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PChangeDisPlayFabao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */