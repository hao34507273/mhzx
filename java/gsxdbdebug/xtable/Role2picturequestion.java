/*    */ package xtable;
/*    */ 
/*    */ import xbean.RolePictureQuestionInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2picturequestion
/*    */ {
/*    */   public static RolePictureQuestionInfo get(Long key)
/*    */   {
/* 12 */     return (RolePictureQuestionInfo)_Tables_.getInstance().role2picturequestion.get(key);
/*    */   }
/*    */   
/*    */   public static RolePictureQuestionInfo get(Long key, RolePictureQuestionInfo value)
/*    */   {
/* 17 */     return (RolePictureQuestionInfo)_Tables_.getInstance().role2picturequestion.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RolePictureQuestionInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2picturequestion.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2picturequestion.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RolePictureQuestionInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2picturequestion.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2picturequestion.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, RolePictureQuestionInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2picturequestion.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RolePictureQuestionInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2picturequestion;
/*    */   }
/*    */   
/*    */   public static RolePictureQuestionInfo select(Long key)
/*    */   {
/* 52 */     (RolePictureQuestionInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public RolePictureQuestionInfo get(RolePictureQuestionInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectPicinfoid(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(RolePictureQuestionInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getPicinfoid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectRightnum(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RolePictureQuestionInfo v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getRightnum());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectTotalnum(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RolePictureQuestionInfo v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getTotalnum());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectUsehelpnum(Long key)
/*    */   {
/* 96 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RolePictureQuestionInfo v)
/*    */       {
/* :0 */         return Integer.valueOf(v.getUsehelpnum());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2picturequestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */