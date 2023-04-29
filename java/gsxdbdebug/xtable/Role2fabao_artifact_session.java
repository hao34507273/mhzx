/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.FabaoArtifactSessionInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2fabao_artifact_session
/*    */ {
/*    */   public static FabaoArtifactSessionInfo get(Long key)
/*    */   {
/* 12 */     return (FabaoArtifactSessionInfo)_Tables_.getInstance().role2fabao_artifact_session.get(key);
/*    */   }
/*    */   
/*    */   public static FabaoArtifactSessionInfo get(Long key, FabaoArtifactSessionInfo value)
/*    */   {
/* 17 */     return (FabaoArtifactSessionInfo)_Tables_.getInstance().role2fabao_artifact_session.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FabaoArtifactSessionInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2fabao_artifact_session.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2fabao_artifact_session.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FabaoArtifactSessionInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2fabao_artifact_session.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2fabao_artifact_session.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, FabaoArtifactSessionInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2fabao_artifact_session.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FabaoArtifactSessionInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2fabao_artifact_session;
/*    */   }
/*    */   
/*    */   public static FabaoArtifactSessionInfo select(Long key)
/*    */   {
/* 52 */     (FabaoArtifactSessionInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public FabaoArtifactSessionInfo get(FabaoArtifactSessionInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Long> selectSessions(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Long> get(FabaoArtifactSessionInfo v)
/*    */       {
/* 67 */         return v.getSessionsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2fabao_artifact_session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */