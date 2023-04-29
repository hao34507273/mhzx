/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ 
/*    */ public class PetArenaFightResultContext
/*    */ {
/*    */   public final long recordid;
/*    */   public final Map<Long, Integer> damages;
/*    */   public final int addPoint;
/*    */   
/*    */   public PetArenaFightResultContext(long recordid, Map<Long, Integer> damages, int addPoint)
/*    */   {
/* 13 */     this.recordid = recordid;
/* 14 */     this.damages = damages;
/* 15 */     this.addPoint = addPoint;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PetArenaFightResultContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */