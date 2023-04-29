/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoundRobinScheduleGenerator
/*     */ {
/*     */   private final int realPlayerNum;
/*     */   private final int playerNum;
/*     */   private final int[][] table;
/*     */   private final int roundNum;
/*     */   private final int roundMatchNum;
/*     */   
/*     */   public RoundRobinScheduleGenerator(int realPlayerNum)
/*     */   {
/*  24 */     this.realPlayerNum = realPlayerNum;
/*  25 */     if (realPlayerNum % 2 != 0)
/*     */     {
/*  27 */       this.playerNum = (realPlayerNum + 1);
/*     */     }
/*     */     else
/*     */     {
/*  31 */       this.playerNum = realPlayerNum;
/*     */     }
/*     */     
/*  34 */     this.table = new int[this.playerNum][this.playerNum];
/*  35 */     for (int i = 0; i < this.playerNum; i++)
/*     */     {
/*  37 */       for (int j = 0; j < this.playerNum; j++)
/*     */       {
/*  39 */         this.table[i][j] = -1;
/*     */       }
/*     */     }
/*  42 */     this.roundNum = (this.playerNum - 1);
/*  43 */     this.roundMatchNum = (this.playerNum / 2);
/*  44 */     genRound(1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRealPlayerNum()
/*     */   {
/*  54 */     return this.realPlayerNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<ArrayList<Integer>> getSchedule()
/*     */   {
/*  64 */     List<ArrayList<Integer>> schedule = new ArrayList();
/*  65 */     for (int roundIndex = 1; roundIndex <= this.roundNum; roundIndex++)
/*     */     {
/*  67 */       ArrayList<Integer> round = new ArrayList();
/*  68 */       schedule.add(round);
/*  69 */       for (int i = 0; i < this.playerNum; i++)
/*     */       {
/*  71 */         for (int j = i + 1; j < this.playerNum; j++)
/*     */         {
/*  73 */           if (this.table[i][j] == roundIndex)
/*     */           {
/*  75 */             round.add(Integer.valueOf(i));
/*  76 */             round.add(Integer.valueOf(j));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*  81 */     return schedule;
/*     */   }
/*     */   
/*     */   private boolean genRound(int roundIndex)
/*     */   {
/*  86 */     List<Integer> occupies = new ArrayList();
/*  87 */     if (genMatch(roundIndex, 1, occupies))
/*     */     {
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   private boolean genMatch(int roundIndex, int matchIndex, List<Integer> occupies)
/*     */   {
/*  96 */     for (int i = 0; i < this.playerNum; i++)
/*     */     {
/*  98 */       if (!occupies.contains(Integer.valueOf(i)))
/*     */       {
/*     */ 
/*     */ 
/* 102 */         for (int j = i + 1; j < this.playerNum; j++)
/*     */         {
/* 104 */           if (!occupies.contains(Integer.valueOf(j)))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 109 */             if (-1 == this.table[i][j])
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 114 */               this.table[i][j] = roundIndex;
/*     */               
/* 116 */               if ((matchIndex == this.roundMatchNum) && (roundIndex == this.roundNum))
/*     */               {
/* 118 */                 return true;
/*     */               }
/*     */               
/* 121 */               occupies.add(Integer.valueOf(i));
/* 122 */               occupies.add(Integer.valueOf(j));
/*     */               boolean nextStepRst;
/* 124 */               boolean nextStepRst; if (matchIndex == this.roundMatchNum)
/*     */               {
/* 126 */                 nextStepRst = genRound(roundIndex + 1);
/*     */               }
/*     */               else
/*     */               {
/* 130 */                 nextStepRst = genMatch(roundIndex, matchIndex + 1, occupies);
/*     */               }
/*     */               
/* 133 */               if (true == nextStepRst)
/*     */               {
/* 135 */                 return true;
/*     */               }
/*     */               
/*     */ 
/* 139 */               occupies.remove(occupies.size() - 1);
/* 140 */               occupies.remove(occupies.size() - 1);
/* 141 */               this.table[i][j] = -1;
/*     */             } } }
/*     */       }
/*     */     }
/* 145 */     return false;
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {}
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\RoundRobinScheduleGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */