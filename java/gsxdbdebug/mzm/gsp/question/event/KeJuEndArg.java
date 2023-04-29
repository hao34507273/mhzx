/*    */ package mzm.gsp.question.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class KeJuEndArg
/*    */ {
/*    */   private final List<Long> rankList;
/*    */   
/*    */   public KeJuEndArg(List<Long> ranklList)
/*    */   {
/* 12 */     this.rankList = ranklList;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getZhuangYuanRoleid()
/*    */   {
/* 23 */     if (this.rankList.size() < 1)
/*    */     {
/* 25 */       return -1L;
/*    */     }
/* 27 */     return ((Long)this.rankList.get(0)).longValue();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getBangYanRoleid()
/*    */   {
/* 38 */     if (this.rankList.size() < 2)
/*    */     {
/* 40 */       return -1L;
/*    */     }
/* 42 */     return ((Long)this.rankList.get(1)).longValue();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getTanHuaRoleid()
/*    */   {
/* 53 */     if (this.rankList.size() < 3)
/*    */     {
/* 55 */       return -1L;
/*    */     }
/* 57 */     return ((Long)this.rankList.get(2)).longValue();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Long> getJinShiList()
/*    */   {
/* 68 */     List<Long> jinShiList = new ArrayList();
/* 69 */     for (int i = 3; i < this.rankList.size(); i++)
/*    */     {
/* 71 */       jinShiList.add(this.rankList.get(i));
/*    */     }
/* 73 */     return jinShiList;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Long> getAllRankList()
/*    */   {
/* 83 */     return new ArrayList(this.rankList);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\event\KeJuEndArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */