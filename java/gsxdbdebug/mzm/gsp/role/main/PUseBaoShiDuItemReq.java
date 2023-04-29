/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.item.confbean.SBaoshiduItem;
/*    */ import mzm.gsp.item.main.BasicItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ import mzm.gsp.role.SAddBaoShiDuRes;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PUseBaoShiDuItemReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int itemKey;
/*    */   
/*    */   public PUseBaoShiDuItemReq(long roleId, int itemKey)
/*    */   {
/* 30 */     this.roleId = roleId;
/* 31 */     this.itemKey = itemKey;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 37 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 220, true))
/*    */     {
/* 39 */       return false;
/*    */     }
/* 41 */     BasicItem item = ItemInterface.getItem(this.roleId, 340600000, this.itemKey);
/* 42 */     if (item == null)
/*    */     {
/* 44 */       return false;
/*    */     }
/* 46 */     SBaoshiduItem sBaoshiduItem = SBaoshiduItem.get(item.getCfgId());
/* 47 */     if (sBaoshiduItem == null)
/*    */     {
/* 49 */       return false;
/*    */     }
/* 51 */     if (!ItemInterface.removeItemByUuid(this.roleId, item.getFirstUuid().longValue(), 1, new TLogArg(LogReason.ROLE_USE_BAOSHIDU_ITEM_REM, item.getCfgId())))
/*    */     {
/*    */ 
/* 54 */       return false;
/*    */     }
/* 56 */     RoleOutFightObj roleOuFightObj = RoleInterface.getRoleOutFightObject(this.roleId);
/* 57 */     boolean ret = roleOuFightObj.addBaoShiDu(sBaoshiduItem.baoshiduNum);
/* 58 */     if (!ret)
/*    */     {
/* 60 */       return false;
/*    */     }
/* 62 */     roleOuFightObj.setHpAndMpFull();
/*    */     
/* 64 */     Set<Long> petids = PetInterface.getPetList(this.roleId, true);
/* 65 */     for (Iterator i$ = petids.iterator(); i$.hasNext();) { long petid = ((Long)i$.next()).longValue();
/*    */       
/* 67 */       PetInterface.recoveryHPAndMP(this.roleId, petid);
/*    */     }
/* 69 */     SAddBaoShiDuRes res = new SAddBaoShiDuRes();
/* 70 */     res.addbaoshudu = sBaoshiduItem.baoshiduNum;
/* 71 */     OnlineManager.getInstance().send(this.roleId, res);
/* 72 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PUseBaoShiDuItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */