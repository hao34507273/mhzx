/*    */ package mzm.gsp.map.main.proto;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.StarLevelWrapper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MapMonsterStarLevelPrototype
/*    */ {
/*    */   private int monsterCfgid;
/*    */   private int initStarLevel;
/*    */   private Map<Integer, StarLevelWrapper> starLevelWrapperMap;
/*    */   
/*    */   public int getMonsterCfgid()
/*    */   {
/* 22 */     return this.monsterCfgid;
/*    */   }
/*    */   
/*    */   public void setMonsterCfgid(int monsterCfgid)
/*    */   {
/* 27 */     this.monsterCfgid = monsterCfgid;
/* 28 */     this.initStarLevel = Integer.MAX_VALUE;
/*    */   }
/*    */   
/*    */   public void setStarLevelWrappers(List<StarLevelWrapper> starLevelWrappers)
/*    */   {
/* 33 */     if (this.starLevelWrapperMap == null)
/*    */     {
/* 35 */       this.starLevelWrapperMap = new HashMap();
/*    */     }
/*    */     
/* 38 */     for (StarLevelWrapper wrapper : starLevelWrappers)
/*    */     {
/* 40 */       int starLevel = wrapper.getStarLevel();
/* 41 */       if (starLevel < this.initStarLevel)
/*    */       {
/* 43 */         this.initStarLevel = starLevel;
/*    */       }
/* 45 */       this.starLevelWrapperMap.put(Integer.valueOf(starLevel), wrapper);
/*    */     }
/*    */   }
/*    */   
/*    */   public int getInitStarLevel()
/*    */   {
/* 51 */     return this.initStarLevel;
/*    */   }
/*    */   
/*    */   public boolean isValid()
/*    */   {
/* 56 */     return (this.starLevelWrapperMap != null) && (!this.starLevelWrapperMap.isEmpty());
/*    */   }
/*    */   
/*    */   public boolean isMaxStarLevel(int starLevel)
/*    */   {
/* 61 */     if (!isValid())
/*    */     {
/* 63 */       return true;
/*    */     }
/*    */     
/* 66 */     return !this.starLevelWrapperMap.containsKey(Integer.valueOf(starLevel + 1));
/*    */   }
/*    */   
/*    */   public String getName(int starLevel)
/*    */   {
/* 71 */     if (!isValid())
/*    */     {
/* 73 */       return null;
/*    */     }
/*    */     
/* 76 */     StarLevelWrapper starLevelWrapper = (StarLevelWrapper)this.starLevelWrapperMap.get(Integer.valueOf(starLevel));
/* 77 */     if (starLevelWrapper == null)
/*    */     {
/* 79 */       return null;
/*    */     }
/* 81 */     return starLevelWrapper.getName();
/*    */   }
/*    */   
/*    */   public Integer getFightid(int starLevel)
/*    */   {
/* 86 */     if (!isValid())
/*    */     {
/* 88 */       return Integer.valueOf(0);
/*    */     }
/*    */     
/* 91 */     StarLevelWrapper starLevelWrapper = (StarLevelWrapper)this.starLevelWrapperMap.get(Integer.valueOf(starLevel));
/* 92 */     if (starLevelWrapper == null)
/*    */     {
/* 94 */       return Integer.valueOf(0);
/*    */     }
/* 96 */     return Integer.valueOf(starLevelWrapper.getFightId());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\proto\MapMonsterStarLevelPrototype.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */