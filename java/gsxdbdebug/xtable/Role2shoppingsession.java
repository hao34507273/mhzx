/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Shoppoingid2Sessionid;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2shoppingsession
/*    */ {
/*    */   public static Shoppoingid2Sessionid get(Long key)
/*    */   {
/* 12 */     return (Shoppoingid2Sessionid)_Tables_.getInstance().role2shoppingsession.get(key);
/*    */   }
/*    */   
/*    */   public static Shoppoingid2Sessionid get(Long key, Shoppoingid2Sessionid value)
/*    */   {
/* 17 */     return (Shoppoingid2Sessionid)_Tables_.getInstance().role2shoppingsession.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Shoppoingid2Sessionid value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2shoppingsession.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2shoppingsession.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Shoppoingid2Sessionid value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2shoppingsession.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2shoppingsession.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Shoppoingid2Sessionid> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2shoppingsession.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Shoppoingid2Sessionid> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2shoppingsession;
/*    */   }
/*    */   
/*    */   public static Shoppoingid2Sessionid select(Long key)
/*    */   {
/* 52 */     (Shoppoingid2Sessionid)getTable().select(key, new TField()
/*    */     {
/*    */       public Shoppoingid2Sessionid get(Shoppoingid2Sessionid v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Long> selectShoppingid2sessionid(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Long> get(Shoppoingid2Sessionid v)
/*    */       {
/* 67 */         return v.getShoppingid2sessionidAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2shoppingsession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */