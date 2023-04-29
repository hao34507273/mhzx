/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PetFightTeam
/*    */ {
/*    */   public final int formationId;
/*    */   public final int formationLevel;
/* 18 */   public final Map<Integer, Position> positions = new HashMap();
/*    */   
/*    */ 
/*    */ 
/*    */   public static class Position
/*    */   {
/*    */     public final long petId;
/*    */     
/*    */ 
/*    */     public final int petFightSkillId;
/*    */     
/* 29 */     public final Map<Integer, Integer> properties = new HashMap();
/*    */     
/*    */     public final int positionNumber;
/*    */     
/*    */ 
/*    */     public Position(long petId, int petFightSkillId, int positionNumber)
/*    */     {
/* 36 */       this.petId = petId;
/* 37 */       this.petFightSkillId = petFightSkillId;
/* 38 */       this.positionNumber = positionNumber;
/*    */     }
/*    */   }
/*    */   
/*    */   public PetFightTeam(int formationId, int formationLevel)
/*    */   {
/* 44 */     this.formationId = formationId;
/* 45 */     this.formationLevel = formationLevel;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetFightTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */