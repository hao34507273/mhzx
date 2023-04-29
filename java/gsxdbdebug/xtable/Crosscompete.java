/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CrossCompete;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Crosscompete
/*    */ {
/*    */   public static CrossCompete get(Long key)
/*    */   {
/* 12 */     return (CrossCompete)_Tables_.getInstance().crosscompete.get(key);
/*    */   }
/*    */   
/*    */   public static CrossCompete get(Long key, CrossCompete value)
/*    */   {
/* 17 */     return (CrossCompete)_Tables_.getInstance().crosscompete.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CrossCompete value)
/*    */   {
/* 22 */     _Tables_.getInstance().crosscompete.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().crosscompete.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CrossCompete value)
/*    */   {
/* 32 */     return _Tables_.getInstance().crosscompete.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().crosscompete.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CrossCompete> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().crosscompete.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CrossCompete> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().crosscompete;
/*    */   }
/*    */   
/*    */   public static CrossCompete select(Long key)
/*    */   {
/* 52 */     (CrossCompete)getTable().select(key, new TField()
/*    */     {
/*    */       public CrossCompete get(CrossCompete v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, xbean.CrossCompeteSignUp> selectSignup_factions(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, xbean.CrossCompeteSignUp> get(CrossCompete v)
/*    */       {
/* 67 */         return v.getSignup_factionsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectMatchtimes(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(CrossCompete v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getMatchtimes());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<xbean.CrossCompeteMatch, xbean.CrossCompeteAgainst> selectAgainsts(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<xbean.CrossCompeteMatch, xbean.CrossCompeteAgainst> get(CrossCompete v)
/*    */       {
/* 89 */         return v.getAgainstsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.Set<Long> selectMiss_turn_factions(Long key)
/*    */   {
/* 96 */     (java.util.Set)getTable().select(key, new TField()
/*    */     {
/*    */       public java.util.Set<Long> get(CrossCompete v)
/*    */       {
/* :0 */         return v.getMiss_turn_factionsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Crosscompete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */