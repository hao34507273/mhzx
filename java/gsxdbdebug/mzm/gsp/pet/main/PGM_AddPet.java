/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PGM_AddPet
/*    */   extends LogicProcedure
/*    */ {
/*  9 */   private static final Logger logger = Logger.getLogger(PGM_AddPet.class);
/*    */   private final long roleId;
/*    */   private final int petCfgId;
/*    */   
/*    */   public PGM_AddPet(long roleId, int petCfgId) {
/* 14 */     this.roleId = roleId;
/* 15 */     this.petCfgId = petCfgId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     long petId = PetInterface.addPet(this.roleId, this.petCfgId);
/* 21 */     if (petId < 0L) {
/* 22 */       logger.error("gm 指令新增宠物失败");
/* 23 */       return false;
/*    */     }
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PGM_AddPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */