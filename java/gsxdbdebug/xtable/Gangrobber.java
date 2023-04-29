/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import xbean.GangRobber;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Gangrobber
/*    */ {
/*    */   public static GangRobber get(Long key)
/*    */   {
/* 12 */     return (GangRobber)_Tables_.getInstance().gangrobber.get(key);
/*    */   }
/*    */   
/*    */   public static GangRobber get(Long key, GangRobber value)
/*    */   {
/* 17 */     return (GangRobber)_Tables_.getInstance().gangrobber.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GangRobber value)
/*    */   {
/* 22 */     _Tables_.getInstance().gangrobber.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().gangrobber.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GangRobber value)
/*    */   {
/* 32 */     return _Tables_.getInstance().gangrobber.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().gangrobber.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GangRobber> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().gangrobber.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GangRobber> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().gangrobber;
/*    */   }
/*    */   
/*    */   public static GangRobber select(Long key)
/*    */   {
/* 52 */     (GangRobber)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public GangRobber get(GangRobber v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, xbean.GangMonsterRobber> selectGangrobberdatas(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, xbean.GangMonsterRobber> get(GangRobber v)
/*    */       {
/* 67 */         return v.getGangrobberdatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectStage(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(GangRobber v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getStage());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Integer> selectRoundopenset(Long key)
/*    */   {
/* 85 */     (Set)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Set<Integer> get(GangRobber v)
/*    */       {
/* 89 */         return v.getRoundopensetAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Gangrobber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */