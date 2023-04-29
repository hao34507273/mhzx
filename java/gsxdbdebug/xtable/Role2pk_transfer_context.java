/*    */ package xtable;
/*    */ 
/*    */ import xbean.PKRevengeItemTransferContext;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2pk_transfer_context
/*    */ {
/*    */   public static PKRevengeItemTransferContext get(Long key)
/*    */   {
/* 12 */     return (PKRevengeItemTransferContext)_Tables_.getInstance().role2pk_transfer_context.get(key);
/*    */   }
/*    */   
/*    */   public static PKRevengeItemTransferContext get(Long key, PKRevengeItemTransferContext value)
/*    */   {
/* 17 */     return (PKRevengeItemTransferContext)_Tables_.getInstance().role2pk_transfer_context.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, PKRevengeItemTransferContext value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2pk_transfer_context.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2pk_transfer_context.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, PKRevengeItemTransferContext value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2pk_transfer_context.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2pk_transfer_context.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, PKRevengeItemTransferContext> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2pk_transfer_context.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, PKRevengeItemTransferContext> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2pk_transfer_context;
/*    */   }
/*    */   
/*    */   public static PKRevengeItemTransferContext select(Long key)
/*    */   {
/* 52 */     (PKRevengeItemTransferContext)getTable().select(key, new TField()
/*    */     {
/*    */       public PKRevengeItemTransferContext get(PKRevengeItemTransferContext v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectMap_id(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(PKRevengeItemTransferContext v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getMap_id());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectPos_x(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(PKRevengeItemTransferContext v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getPos_x());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectPos_y(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(PKRevengeItemTransferContext v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getPos_y());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSession_id(Long key)
/*    */   {
/* 96 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(PKRevengeItemTransferContext v)
/*    */       {
/* :0 */         return Long.valueOf(v.getSession_id());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2pk_transfer_context.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */