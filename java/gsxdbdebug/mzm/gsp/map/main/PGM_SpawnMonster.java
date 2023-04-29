/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.message.MMH_GMSpawnMonster;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SpawnMonster extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int monsterId;
/*    */   private final int num;
/*    */   
/*    */   public PGM_SpawnMonster(long roleId, int monsterId, int num)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.monsterId = monsterId;
/* 16 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     new MMH_GMSpawnMonster(this.roleId, this.monsterId, this.num).execute();
/*    */     
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PGM_SpawnMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */