/*    */ package xtable;
/*    */ 
/*    */ import xbean.AccountNumBean;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Accountnum
/*    */ {
/*    */   public static AccountNumBean get(Long key)
/*    */   {
/* 12 */     return (AccountNumBean)_Tables_.getInstance().accountnum.get(key);
/*    */   }
/*    */   
/*    */   public static AccountNumBean get(Long key, AccountNumBean value)
/*    */   {
/* 17 */     return (AccountNumBean)_Tables_.getInstance().accountnum.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, AccountNumBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().accountnum.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().accountnum.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, AccountNumBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().accountnum.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().accountnum.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, AccountNumBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().accountnum.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, AccountNumBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().accountnum;
/*    */   }
/*    */   
/*    */   public static AccountNumBean select(Long key)
/*    */   {
/* 52 */     (AccountNumBean)getTable().select(key, new TField()
/*    */     {
/*    */       public AccountNumBean get(AccountNumBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectUsernum(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(AccountNumBean v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getUsernum());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Accountnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */