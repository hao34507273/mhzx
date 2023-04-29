/*    */ package mzm.gsp.chart.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.chart.PetOwner;
/*    */ import mzm.gsp.chart.STopModelListRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.main.Pet;
/*    */ import mzm.gsp.pet.main.PetBag;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ import mzm.gsp.pubdata.ModelInfo;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PGetPetModelListReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int chartType;
/*    */   private List<PetOwner> petOwnerList;
/*    */   
/*    */   public PGetPetModelListReq(long roleId, int chartType, List<PetOwner> petOwnerList)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.chartType = chartType;
/* 26 */     this.petOwnerList = petOwnerList;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 31 */     STopModelListRes res = new STopModelListRes();
/* 32 */     for (PetOwner po : this.petOwnerList) {
/* 33 */       PetBag petBag = PetInterface.getPetBag(po.roleid, false);
/* 34 */       ModelInfo modelInfo = new ModelInfo();
/* 35 */       if (petBag == null) {
/* 36 */         res.datalist.add(modelInfo);
/*    */       }
/*    */       else {
/* 39 */         Pet pet = petBag.getPetById(po.petid);
/*    */         
/* 41 */         if (null != pet) {
/* 42 */           pet.getModel(modelInfo);
/*    */         } else {
/* 44 */           pet = PetInterface.getDepotPetByPetId(po.roleid, po.petid, false);
/* 45 */           if (null != pet) {
/* 46 */             pet.getModel(modelInfo);
/*    */           }
/*    */         }
/* 49 */         res.datalist.add(modelInfo);
/*    */       }
/*    */     }
/* 52 */     res.charttype = this.chartType;
/* 53 */     OnlineManager.getInstance().send(this.roleId, res);
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\PGetPetModelListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */