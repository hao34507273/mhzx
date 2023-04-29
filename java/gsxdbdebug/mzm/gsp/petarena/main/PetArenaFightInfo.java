/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ public class PetArenaFightInfo
/*    */ {
/*    */   public final long petid;
/*    */   public final int position;
/*    */   public final int petCfgid;
/*    */   public final int monsterCfgid;
/*    */   public final String name;
/*    */   
/*    */   public PetArenaFightInfo(long petid, int position, int petCfgid, int monsterCfgid, String name)
/*    */   {
/* 13 */     this.petCfgid = petCfgid;
/* 14 */     this.petid = petid;
/* 15 */     this.position = position;
/* 16 */     this.monsterCfgid = monsterCfgid;
/* 17 */     this.name = name;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PetArenaFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */