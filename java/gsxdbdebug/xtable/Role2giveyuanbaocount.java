/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.GiveYuanbaoCount;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2giveyuanbaocount
/*    */ {
/*    */   public static GiveYuanbaoCount get(Long key)
/*    */   {
/* 12 */     return (GiveYuanbaoCount)_Tables_.getInstance().role2giveyuanbaocount.get(key);
/*    */   }
/*    */   
/*    */   public static GiveYuanbaoCount get(Long key, GiveYuanbaoCount value)
/*    */   {
/* 17 */     return (GiveYuanbaoCount)_Tables_.getInstance().role2giveyuanbaocount.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GiveYuanbaoCount value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2giveyuanbaocount.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2giveyuanbaocount.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GiveYuanbaoCount value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2giveyuanbaocount.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2giveyuanbaocount.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, GiveYuanbaoCount> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2giveyuanbaocount.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GiveYuanbaoCount> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2giveyuanbaocount;
/*    */   }
/*    */   
/*    */   public static GiveYuanbaoCount select(Long key)
/*    */   {
/* 52 */     (GiveYuanbaoCount)getTable().select(key, new TField()
/*    */     {
/*    */       public GiveYuanbaoCount get(GiveYuanbaoCount v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Long> selectRoleid2count(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Long> get(GiveYuanbaoCount v)
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
/*    */       public Long get(GiveYuanbaoCount v)
/*    */       {
/* 78 */         return Long.valueOf(v.getCleartime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2giveyuanbaocount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */