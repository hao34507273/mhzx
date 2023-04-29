/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.HulaWorldInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Hulaworld
/*    */ {
/*    */   public static HulaWorldInfo get(Long key)
/*    */   {
/* 12 */     return (HulaWorldInfo)_Tables_.getInstance().hulaworld.get(key);
/*    */   }
/*    */   
/*    */   public static HulaWorldInfo get(Long key, HulaWorldInfo value)
/*    */   {
/* 17 */     return (HulaWorldInfo)_Tables_.getInstance().hulaworld.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, HulaWorldInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().hulaworld.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().hulaworld.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, HulaWorldInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().hulaworld.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().hulaworld.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, HulaWorldInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().hulaworld.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, HulaWorldInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().hulaworld;
/*    */   }
/*    */   
/*    */   public static HulaWorldInfo select(Long key)
/*    */   {
/* 52 */     (HulaWorldInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public HulaWorldInfo get(HulaWorldInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.List<xbean.HulaMonsterInfo> selectMonsters(Long key)
/*    */   {
/* 63 */     (java.util.List)getTable().select(key, new TField()
/*    */     {
/*    */       public java.util.List<xbean.HulaMonsterInfo> get(HulaWorldInfo v)
/*    */       {
/* 67 */         return v.getMonstersAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectRoleids(Long key)
/*    */   {
/* 74 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(HulaWorldInfo v)
/*    */       {
/* 78 */         return v.getRoleidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectMaxseq(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(HulaWorldInfo v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getMaxseq());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Hulaworld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */