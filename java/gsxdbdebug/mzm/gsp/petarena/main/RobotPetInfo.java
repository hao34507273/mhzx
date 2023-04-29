/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ 
/*    */ public class RobotPetInfo
/*    */ {
/*    */   public final int monsterCfgid;
/*    */   public final int modelRation;
/*    */   public final int level;
/*    */   public final int grade;
/*    */   public final int score;
/*    */   public final String name;
/*    */   
/*    */   public RobotPetInfo(int monsterCfgid, int modelRation, int level, int grade, int score, String name)
/*    */   {
/* 15 */     this.monsterCfgid = monsterCfgid;
/* 16 */     this.modelRation = modelRation;
/* 17 */     this.level = level;
/* 18 */     this.grade = grade;
/* 19 */     this.score = score;
/* 20 */     this.name = name;
/*    */   }
/*    */   
/*    */   public mzm.gsp.petarena.RobotPetInfo buildRobotPetInfo()
/*    */   {
/* 25 */     mzm.gsp.petarena.RobotPetInfo result = new mzm.gsp.petarena.RobotPetInfo();
/* 26 */     result.model_ratio = this.modelRation;
/* 27 */     result.monster_cfgid = this.monsterCfgid;
/* 28 */     result.grade = this.grade;
/* 29 */     result.score = this.score;
/* 30 */     result.level = this.level;
/* 31 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\RobotPetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */