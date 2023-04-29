/*    */ package mzm.gsp.children.fetuseducationmusic;
/*    */ 
/*    */ import mzm.gsp.musicgame.event.MusicGameContext;
/*    */ 
/*    */ public class FetusEducationMusicGameContext implements MusicGameContext
/*    */ {
/*    */   public final long marriageid;
/*    */   public final long partnerid;
/*    */   
/*    */   public FetusEducationMusicGameContext(long marriageid, long partnerid)
/*    */   {
/* 12 */     this.marriageid = marriageid;
/* 13 */     this.partnerid = partnerid;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 19 */     return String.format("marriageid=%d|partnerid=%d", new Object[] { Long.valueOf(this.marriageid), Long.valueOf(this.partnerid) });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\fetuseducationmusic\FetusEducationMusicGameContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */