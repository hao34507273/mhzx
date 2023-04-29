/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class FightEndAwardObserver extends Observer
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public FightEndAwardObserver(long intervalSeconds, long roleid)
/*    */   {
/* 13 */     super(intervalSeconds);
/* 14 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 20 */     new PFightEnd(this.roleid).execute();
/* 21 */     return false;
/*    */   }
/*    */   
/*    */   private static class PFightEnd extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     
/*    */     public PFightEnd(long roleid)
/*    */     {
/* 30 */       this.roleid = roleid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 36 */       if (!PetArenaManager.getPetArenaAward(this.roleid))
/*    */       {
/* 38 */         GameServer.logger().info(String.format("[petarena]PFightEnd.processImp@get award failed|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */         
/* 40 */         return false;
/*    */       }
/*    */       
/* 43 */       GameServer.logger().info(String.format("[petarena]PFightEnd.processImp@get award success|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/* 44 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\FightEndAwardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */