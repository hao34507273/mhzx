/*    */ package mzm.gsp.genius.main;
/*    */ 
/*    */ public class GeniusSkillInfo implements Comparable<GeniusSkillInfo>
/*    */ {
/*    */   public final int geniusCfgid;
/*    */   public final int addPoint;
/*    */   
/*    */   public GeniusSkillInfo(int geniusCfgid, int addPoint)
/*    */   {
/* 10 */     this.geniusCfgid = geniusCfgid;
/* 11 */     this.addPoint = addPoint;
/*    */   }
/*    */   
/*    */ 
/*    */   public int compareTo(GeniusSkillInfo o)
/*    */   {
/* 17 */     if (o == null)
/*    */     {
/* 19 */       return 1;
/*    */     }
/*    */     
/* 22 */     return this.geniusCfgid - o.geniusCfgid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\main\GeniusSkillInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */