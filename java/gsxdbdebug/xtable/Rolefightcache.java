/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.FightCache;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Rolefightcache
/*    */ {
/*    */   public static FightCache get(Long key)
/*    */   {
/* 12 */     return (FightCache)_Tables_.getInstance().rolefightcache.get(key);
/*    */   }
/*    */   
/*    */   public static FightCache get(Long key, FightCache value)
/*    */   {
/* 17 */     return (FightCache)_Tables_.getInstance().rolefightcache.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FightCache value)
/*    */   {
/* 22 */     _Tables_.getInstance().rolefightcache.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().rolefightcache.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FightCache value)
/*    */   {
/* 32 */     return _Tables_.getInstance().rolefightcache.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().rolefightcache.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, FightCache> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().rolefightcache.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FightCache> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().rolefightcache;
/*    */   }
/*    */   
/*    */   public static FightCache select(Long key)
/*    */   {
/* 52 */     (FightCache)getTable().select(key, new TField()
/*    */     {
/*    */       public FightCache get(FightCache v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectRole_default_skill(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(FightCache v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getRole_default_skill());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Integer> selectPet_default_skills(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Integer> get(FightCache v)
/*    */       {
/* 78 */         return v.getPet_default_skillsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Integer> selectChild_default_skills(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Integer> get(FightCache v)
/*    */       {
/* 89 */         return v.getChild_default_skillsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectIsauto(Long key)
/*    */   {
/* 96 */     (Boolean)getTable().select(key, new TField()
/*    */     {
/*    */       public Boolean get(FightCache v)
/*    */       {
/* :0 */         return Boolean.valueOf(v.getIsauto());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Rolefightcache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */