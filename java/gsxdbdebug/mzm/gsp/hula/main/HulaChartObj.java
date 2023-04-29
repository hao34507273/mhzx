/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.chart.main.RoleKeyChartObj;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HulaChartObj
/*    */   extends RoleKeyChartObj<HulaChartObj>
/*    */ {
/*    */   private final long roleid;
/*    */   private final int score;
/*    */   private final TreeMap<Integer, Integer> deleteTypes;
/*    */   
/*    */   public HulaChartObj(long roleid, int score, Map<Integer, Integer> deleteTypes)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.score = score;
/* 24 */     this.deleteTypes = new TreeMap();
/* 25 */     if (deleteTypes != null)
/*    */     {
/* 27 */       this.deleteTypes.putAll(deleteTypes);
/*    */     }
/*    */   }
/*    */   
/*    */   private int getBiggestDeleteType()
/*    */   {
/* 33 */     Integer biggestType = Integer.valueOf(0);
/* 34 */     if (!this.deleteTypes.isEmpty())
/*    */     {
/* 36 */       biggestType = (Integer)this.deleteTypes.lastKey();
/*    */     }
/* 38 */     return biggestType.intValue();
/*    */   }
/*    */   
/*    */   private int getDeleteTypeCount(int delteType)
/*    */   {
/* 43 */     Integer count = (Integer)this.deleteTypes.get(Integer.valueOf(delteType));
/* 44 */     if (count == null)
/*    */     {
/* 46 */       return 0;
/*    */     }
/* 48 */     return count.intValue();
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isAvailable()
/*    */   {
/* 54 */     if (this.score <= 0)
/*    */     {
/* 56 */       return false;
/*    */     }
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isTopThan(HulaChartObj rankObj)
/*    */   {
/* 64 */     if (this.score != rankObj.score)
/*    */     {
/* 66 */       return this.score > rankObj.score;
/*    */     }
/*    */     
/*    */ 
/* 70 */     Integer biggestType = Integer.valueOf(getBiggestDeleteType());
/* 71 */     Integer biggerstTypeParam = Integer.valueOf(rankObj.getBiggestDeleteType());
/* 72 */     if (biggestType != biggerstTypeParam)
/*    */     {
/* 74 */       return biggestType.intValue() > biggerstTypeParam.intValue();
/*    */     }
/*    */     
/* 77 */     for (int delteType = biggestType.intValue(); delteType > 0; delteType--)
/*    */     {
/* 79 */       Integer count = Integer.valueOf(getDeleteTypeCount(delteType));
/* 80 */       Integer countParam = Integer.valueOf(rankObj.getDeleteTypeCount(delteType));
/* 81 */       if (count != countParam)
/*    */       {
/* 83 */         return count.intValue() > countParam.intValue();
/*    */       }
/*    */     }
/* 86 */     return this.roleid > rankObj.roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Long getKey()
/*    */   {
/* 94 */     return Long.valueOf(this.roleid);
/*    */   }
/*    */   
/*    */   public int getScore()
/*    */   {
/* 99 */     return this.score;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\HulaChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */