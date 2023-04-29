/*    */ package xtable;
/*    */ 
/*    */ import java.util.Set;
/*    */ import xbean.BanNpcServices;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Bannpcservice
/*    */ {
/*    */   public static BanNpcServices get(Long key)
/*    */   {
/* 12 */     return (BanNpcServices)_Tables_.getInstance().bannpcservice.get(key);
/*    */   }
/*    */   
/*    */   public static BanNpcServices get(Long key, BanNpcServices value)
/*    */   {
/* 17 */     return (BanNpcServices)_Tables_.getInstance().bannpcservice.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, BanNpcServices value)
/*    */   {
/* 22 */     _Tables_.getInstance().bannpcservice.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().bannpcservice.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, BanNpcServices value)
/*    */   {
/* 32 */     return _Tables_.getInstance().bannpcservice.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().bannpcservice.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, BanNpcServices> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().bannpcservice.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, BanNpcServices> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().bannpcservice;
/*    */   }
/*    */   
/*    */   public static BanNpcServices select(Long key)
/*    */   {
/* 52 */     (BanNpcServices)getTable().select(key, new TField()
/*    */     {
/*    */       public BanNpcServices get(BanNpcServices v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Integer> selectNpcservices(Long key)
/*    */   {
/* 63 */     (Set)getTable().select(key, new TField()
/*    */     {
/*    */       public Set<Integer> get(BanNpcServices v)
/*    */       {
/* 67 */         return v.getNpcservicesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Bannpcservice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */