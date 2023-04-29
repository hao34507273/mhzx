/*    */ package mzm.gsp.zoo.main;
/*    */ 
/*    */ public class EscapeInfo
/*    */   implements Comparable<EscapeInfo>
/*    */ {
/*    */   public final long animalid;
/*    */   public final int stage;
/*    */   public final int hatchDays;
/*    */   public final long birthTime;
/*    */   public final int starType;
/*    */   public final int awardCfgid;
/*    */   
/*    */   public EscapeInfo(long animalid, int stage, int hatchDays, long birthTime, int starType, int awardCfgid)
/*    */   {
/* 15 */     this.animalid = animalid;
/* 16 */     this.stage = stage;
/* 17 */     this.hatchDays = hatchDays;
/* 18 */     this.birthTime = birthTime;
/* 19 */     this.starType = starType;
/* 20 */     this.awardCfgid = awardCfgid;
/*    */   }
/*    */   
/*    */ 
/*    */   public int compareTo(EscapeInfo o)
/*    */   {
/* 26 */     int result = 0;
/*    */     
/* 28 */     result = o.stage - this.stage;
/* 29 */     if (result != 0)
/*    */     {
/* 31 */       return result;
/*    */     }
/*    */     
/* 34 */     if (this.stage == 0)
/*    */     {
/*    */ 
/* 37 */       result = this.hatchDays - o.hatchDays;
/* 38 */       if (result != 0)
/*    */       {
/* 40 */         return result;
/*    */       }
/* 42 */       return (int)(o.animalid - this.animalid);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 47 */     result = this.starType - o.starType;
/* 48 */     if (result != 0)
/*    */     {
/* 50 */       return result;
/*    */     }
/*    */     
/* 53 */     if ((this.awardCfgid != 0) && (o.awardCfgid != 0))
/*    */     {
/* 55 */       return (int)(o.birthTime - this.birthTime);
/*    */     }
/* 57 */     if ((this.awardCfgid == 0) && (o.awardCfgid == 0))
/*    */     {
/* 59 */       return (int)(o.birthTime - this.birthTime);
/*    */     }
/*    */     
/*    */ 
/* 63 */     result = this.awardCfgid - o.awardCfgid;
/*    */     
/*    */ 
/*    */ 
/* 67 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\EscapeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */