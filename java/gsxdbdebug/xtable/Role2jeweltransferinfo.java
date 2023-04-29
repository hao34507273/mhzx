/*    */ package xtable;
/*    */ 
/*    */ import xbean.JewelTransferInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2jeweltransferinfo
/*    */ {
/*    */   public static JewelTransferInfo get(Long key)
/*    */   {
/* 12 */     return (JewelTransferInfo)_Tables_.getInstance().role2jeweltransferinfo.get(key);
/*    */   }
/*    */   
/*    */   public static JewelTransferInfo get(Long key, JewelTransferInfo value)
/*    */   {
/* 17 */     return (JewelTransferInfo)_Tables_.getInstance().role2jeweltransferinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, JewelTransferInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2jeweltransferinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2jeweltransferinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, JewelTransferInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2jeweltransferinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2jeweltransferinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, JewelTransferInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2jeweltransferinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, JewelTransferInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2jeweltransferinfo;
/*    */   }
/*    */   
/*    */   public static JewelTransferInfo select(Long key)
/*    */   {
/* 52 */     (JewelTransferInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public JewelTransferInfo get(JewelTransferInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectCount(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(JewelTransferInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getCount());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2jeweltransferinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */