/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RobotPetPositionInfo
/*    */ {
/*    */   public final long petid;
/*    */   public final int position;
/*    */   public final int petFightSkill;
/* 16 */   public final Map<Integer, Integer> properties = new HashMap();
/*    */   
/*    */ 
/*    */   public RobotPetPositionInfo(long petid, int position, int petFightSkill, Map<Integer, Integer> properties)
/*    */   {
/* 21 */     this.petid = petid;
/* 22 */     this.position = position;
/* 23 */     this.petFightSkill = petFightSkill;
/* 24 */     if (properties != null)
/*    */     {
/* 26 */       this.properties.putAll(properties);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\RobotPetPositionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */