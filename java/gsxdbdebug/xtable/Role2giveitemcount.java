/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.GiveItemCount;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2giveitemcount
/*    */ {
/*    */   public static GiveItemCount get(Long key)
/*    */   {
/* 12 */     return (GiveItemCount)_Tables_.getInstance().role2giveitemcount.get(key);
/*    */   }
/*    */   
/*    */   public static GiveItemCount get(Long key, GiveItemCount value)
/*    */   {
/* 17 */     return (GiveItemCount)_Tables_.getInstance().role2giveitemcount.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GiveItemCount value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2giveitemcount.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2giveitemcount.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GiveItemCount value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2giveitemcount.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2giveitemcount.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GiveItemCount> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2giveitemcount.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GiveItemCount> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2giveitemcount;
/*    */   }
/*    */   
/*    */   public static GiveItemCount select(Long key)
/*    */   {
/* 52 */     (GiveItemCount)getTable().select(key, new TField()
/*    */     {
/*    */       public GiveItemCount get(GiveItemCount v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Integer> selectRoleid2count(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Integer> get(GiveItemCount v)
/*    */       {
/* 67 */         return v.getRoleid2countAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectCleartime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(GiveItemCount v)
/*    */       {
/* 78 */         return Long.valueOf(v.getCleartime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2giveitemcount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */