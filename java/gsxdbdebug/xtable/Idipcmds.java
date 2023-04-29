/*    */ package xtable;
/*    */ 
/*    */ import xbean.IDIPCmdInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Idipcmds
/*    */ {
/*    */   public static IDIPCmdInfo get(String key)
/*    */   {
/* 12 */     return (IDIPCmdInfo)_Tables_.getInstance().idipcmds.get(key);
/*    */   }
/*    */   
/*    */   public static IDIPCmdInfo get(String key, IDIPCmdInfo value)
/*    */   {
/* 17 */     return (IDIPCmdInfo)_Tables_.getInstance().idipcmds.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(String key, IDIPCmdInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().idipcmds.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(String key)
/*    */   {
/* 27 */     _Tables_.getInstance().idipcmds.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(String key, IDIPCmdInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().idipcmds.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(String key)
/*    */   {
/* 37 */     return _Tables_.getInstance().idipcmds.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<String, IDIPCmdInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().idipcmds.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<String, IDIPCmdInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().idipcmds;
/*    */   }
/*    */   
/*    */   public static IDIPCmdInfo select(String key)
/*    */   {
/* 52 */     (IDIPCmdInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public IDIPCmdInfo get(IDIPCmdInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectTimestamp(String key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(IDIPCmdInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getTimestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static byte[] selectReqdata(String key)
/*    */   {
/* 74 */     (byte[])getTable().select(key, new TField()
/*    */     {
/*    */       public byte[] get(IDIPCmdInfo v)
/*    */       {
/* 78 */         return v.getReqdataCopy();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static byte[] selectRspdata(String key)
/*    */   {
/* 85 */     (byte[])getTable().select(key, new TField()
/*    */     {
/*    */       public byte[] get(IDIPCmdInfo v)
/*    */       {
/* 89 */         return v.getRspdataCopy();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Idipcmds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */