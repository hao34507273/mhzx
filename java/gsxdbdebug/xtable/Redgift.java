/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.RedgiftRoleidSet;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Redgift
/*    */ {
/*    */   public static RedgiftRoleidSet get(Long key)
/*    */   {
/* 12 */     return (RedgiftRoleidSet)_Tables_.getInstance().redgift.get(key);
/*    */   }
/*    */   
/*    */   public static RedgiftRoleidSet get(Long key, RedgiftRoleidSet value)
/*    */   {
/* 17 */     return (RedgiftRoleidSet)_Tables_.getInstance().redgift.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RedgiftRoleidSet value)
/*    */   {
/* 22 */     _Tables_.getInstance().redgift.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().redgift.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RedgiftRoleidSet value)
/*    */   {
/* 32 */     return _Tables_.getInstance().redgift.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().redgift.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RedgiftRoleidSet> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().redgift.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RedgiftRoleidSet> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().redgift;
/*    */   }
/*    */   
/*    */   public static RedgiftRoleidSet select(Long key)
/*    */   {
/* 52 */     (RedgiftRoleidSet)getTable().select(key, new TField()
/*    */     {
/*    */       public RedgiftRoleidSet get(RedgiftRoleidSet v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Long> selectRoleidset(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Long> get(RedgiftRoleidSet v)
/*    */       {
/* 67 */         return v.getRoleidsetAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Redgift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */