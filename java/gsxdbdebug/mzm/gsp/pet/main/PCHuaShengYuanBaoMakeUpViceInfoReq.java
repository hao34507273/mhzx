/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.pet.SHuaShengYuanBaoMakeUpViceInfoRsp;
/*    */ import mzm.gsp.pet.confbean.PetConstants;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.Pet;
/*    */ import xbean.PetBag;
/*    */ import xtable.Role2petbag;
/*    */ 
/*    */ public class PCHuaShengYuanBaoMakeUpViceInfoReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   final long mainPetId;
/*    */   
/*    */   public PCHuaShengYuanBaoMakeUpViceInfoReq(long roleId, long mainPetId)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.mainPetId = mainPetId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (!OpenInterface.getOpenStatus(498))
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     if (!PetManager.isPetSwitchOpenForRole(this.roleId))
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     if (RoleInterface.getLevel(this.roleId) < PetConstants.getInstance().PET_HUASHENG_OPEN_LEVEL)
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 44 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 1801, true))
/*    */     {
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/* 50 */     if (xPetBag == null)
/*    */     {
/* 52 */       return false;
/*    */     }
/* 54 */     Pet xMainPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.mainPetId));
/* 55 */     if (xMainPet == null)
/*    */     {
/* 57 */       return false;
/*    */     }
/*    */     
/* 60 */     VicePetMakeUpPriceInfo vicePetMakeUpPriceInfo = PetHuaShengYuanBaoMakeUpViceManager.getMakeUpVicePetPrice(xMainPet);
/*    */     
/* 62 */     if (vicePetMakeUpPriceInfo == null)
/*    */     {
/* 64 */       return false;
/*    */     }
/*    */     
/* 67 */     SHuaShengYuanBaoMakeUpViceInfoRsp huaShengYuanBaoMakeUpViceInfoRsp = new SHuaShengYuanBaoMakeUpViceInfoRsp();
/* 68 */     huaShengYuanBaoMakeUpViceInfoRsp.mainpetid = this.mainPetId;
/* 69 */     huaShengYuanBaoMakeUpViceInfoRsp.vicecfgid = vicePetMakeUpPriceInfo.vicePetMakeUpCfgId;
/* 70 */     huaShengYuanBaoMakeUpViceInfoRsp.needyuanbaocount = vicePetMakeUpPriceInfo.vicePetMakeUpPrice;
/* 71 */     huaShengYuanBaoMakeUpViceInfoRsp.skillcount = vicePetMakeUpPriceInfo.skillCount;
/* 72 */     OnlineManager.getInstance().send(this.roleId, huaShengYuanBaoMakeUpViceInfoRsp);
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PCHuaShengYuanBaoMakeUpViceInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */