/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.FabaoArtifactRecords;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2fabao_artifact
/*    */ {
/*    */   public static FabaoArtifactRecords get(Long key)
/*    */   {
/* 12 */     return (FabaoArtifactRecords)_Tables_.getInstance().role2fabao_artifact.get(key);
/*    */   }
/*    */   
/*    */   public static FabaoArtifactRecords get(Long key, FabaoArtifactRecords value)
/*    */   {
/* 17 */     return (FabaoArtifactRecords)_Tables_.getInstance().role2fabao_artifact.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FabaoArtifactRecords value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2fabao_artifact.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2fabao_artifact.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FabaoArtifactRecords value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2fabao_artifact.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2fabao_artifact.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, FabaoArtifactRecords> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2fabao_artifact.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FabaoArtifactRecords> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2fabao_artifact;
/*    */   }
/*    */   
/*    */   public static FabaoArtifactRecords select(Long key)
/*    */   {
/* 52 */     (FabaoArtifactRecords)getTable().select(key, new TField()
/*    */     {
/*    */       public FabaoArtifactRecords get(FabaoArtifactRecords v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, xbean.FabaoArtifactRecord> selectRecords(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, xbean.FabaoArtifactRecord> get(FabaoArtifactRecords v)
/*    */       {
/* 67 */         return v.getRecordsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectEquipped_artifact_class(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(FabaoArtifactRecords v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getEquipped_artifact_class());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2fabao_artifact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */