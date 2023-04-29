/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.MergeMain;
/*     */ import xbean.CorpsGlobal;
/*     */ import xtable.Corpsglobal;
/*     */ 
/*     */ public class CorpsMerge implements mzm.gsp.MergeModule
/*     */ {
/*     */   List<xdb.Table> tables;
/*     */   
/*     */   public CorpsMerge()
/*     */   {
/*  17 */     this.tables = new java.util.ArrayList();
/*     */   }
/*     */   
/*     */   public List<xdb.Table> getHandleTables()
/*     */   {
/*  22 */     this.tables.add(xtable.Corps.getTable());
/*  23 */     this.tables.add(xtable.Role2corps.getTable());
/*  24 */     this.tables.add(Corpsglobal.getTable());
/*     */     
/*  26 */     return this.tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  32 */     if (!new PMergeCorpsGlobal(null).call())
/*     */     {
/*  34 */       MergeMain.formatLogError("[corps]CorpsMerge.handleMerge@ merge corps global failed!!!!", new Object[0]);
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     long mainKey = MergeMain.getMainZoneid();
/*  39 */     CorpsGlobal xGlobal = Corpsglobal.select(Long.valueOf(mainKey));
/*  40 */     if (xGlobal == null)
/*     */     {
/*  42 */       return true;
/*     */     }
/*     */     
/*  45 */     List<Long> corpsIds = new java.util.ArrayList(xGlobal.getAllcorpsids());
/*     */     
/*  47 */     Map<String, Long> name2Corpsid = new java.util.HashMap();
/*  48 */     Map<Long, String> duplicatedNameCorps = new java.util.HashMap();
/*     */     
/*  50 */     Iterator<Long> corpsIterator = corpsIds.iterator();
/*  51 */     while (corpsIterator.hasNext())
/*     */     {
/*  53 */       long corpsId = ((Long)corpsIterator.next()).longValue();
/*     */       
/*  55 */       if (!new PFindDuplicateName(name2Corpsid, duplicatedNameCorps, corpsId).call())
/*     */       {
/*  57 */         MergeMain.formatLogError("[corps]CorpsMerge.handleMerge@handle PFindDuplicateName error|corpsId=%d", new Object[] { Long.valueOf(corpsId) });
/*  58 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  62 */     Iterator<Map.Entry<Long, String>> duplicatedCorpsIter = duplicatedNameCorps.entrySet().iterator();
/*  63 */     while (duplicatedCorpsIter.hasNext())
/*     */     {
/*  65 */       Map.Entry<Long, String> entry = (Map.Entry)duplicatedCorpsIter.next();
/*  66 */       long corpsId = ((Long)entry.getKey()).longValue();
/*  67 */       String name = (String)entry.getValue();
/*     */       
/*  69 */       if (!new PHandleDuplicateName(corpsId, name, name2Corpsid).call())
/*     */       {
/*  71 */         MergeMain.formatLogError("[corps]CorpsMerge.handleMerge@handle duplicate name error|gangid=%d|name=%s", new Object[] { Long.valueOf(corpsId), name });
/*     */         
/*  73 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  77 */     return true;
/*     */   }
/*     */   
/*     */   private static class PFindDuplicateName extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long corpsId;
/*     */     final Map<String, Long> name2Corpsid;
/*     */     final Map<Long, String> duplicatedNameCorps;
/*     */     
/*     */     PFindDuplicateName(Map<String, Long> name2Corpsid, Map<Long, String> duplicatedNameCorps, long corpsId)
/*     */     {
/*  88 */       this.corpsId = corpsId;
/*  89 */       this.name2Corpsid = name2Corpsid;
/*  90 */       this.duplicatedNameCorps = duplicatedNameCorps;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  97 */       xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(this.corpsId));
/*  98 */       String name = xCorps.getCorpsname();
/*  99 */       Long oldCorpsid = (Long)this.name2Corpsid.get(name);
/* 100 */       if (oldCorpsid != null)
/*     */       {
/* 102 */         MergeMain.formatLogInfo("[corps]PHandleDisplayid.processImp@duplicated corps name|name=%s|corpsid1=%d|corpsid2=%d", new Object[] { name, Long.valueOf(oldCorpsid.longValue()), Long.valueOf(this.corpsId) });
/*     */         
/*     */ 
/*     */ 
/* 106 */         this.duplicatedNameCorps.put(Long.valueOf(this.corpsId), name);
/*     */       }
/*     */       else
/*     */       {
/* 110 */         this.name2Corpsid.put(name, Long.valueOf(this.corpsId));
/*     */       }
/* 112 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class PMergeCorpsGlobal
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 128 */       long mainKey = MergeMain.getMainZoneid();
/* 129 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/*     */ 
/* 132 */       lock(Corpsglobal.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/* 134 */       CorpsGlobal xMainGlobal = Corpsglobal.get(Long.valueOf(mainKey));
/* 135 */       CorpsGlobal xViceGlobal = Corpsglobal.get(Long.valueOf(viceKey));
/*     */       
/* 137 */       if (xMainGlobal == null)
/*     */       {
/* 139 */         Corpsglobal.insert(Long.valueOf(mainKey), xMainGlobal = xbean.Pod.newCorpsGlobal());
/*     */       }
/*     */       
/*     */ 
/* 143 */       if (xViceGlobal == null)
/*     */       {
/* 145 */         MergeMain.formatLogWarn("[corps]PMergeCorpsGlobal.processImp@vice record null|vice_key=%d", new Object[] { Long.valueOf(viceKey) });
/* 146 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 150 */       Iterator<Long> viceCorpsIter = xViceGlobal.getAllcorpsids().iterator();
/*     */       
/* 152 */       while (viceCorpsIter.hasNext())
/*     */       {
/* 154 */         long viceCorpsid = ((Long)viceCorpsIter.next()).longValue();
/* 155 */         if (!xMainGlobal.getAllcorpsids().add(Long.valueOf(viceCorpsid)))
/*     */         {
/*     */ 
/* 158 */           MergeMain.formatLogError("[corps]PMergeGangGlobal.processImp@duplicated corps id|id=%d", new Object[] { Long.valueOf(viceCorpsid) });
/* 159 */           return false;
/*     */         }
/* 161 */         viceCorpsIter.remove();
/*     */       }
/*     */       
/*     */ 
/* 165 */       Corpsglobal.remove(Long.valueOf(viceKey));
/*     */       
/* 167 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PHandleDuplicateName
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long corpsId;
/*     */     private final String oldName;
/*     */     private final Map<String, Long> name2CorpsId;
/*     */     
/*     */     PHandleDuplicateName(long corpsId, String oldName, Map<String, Long> name2CorpsId)
/*     */     {
/* 180 */       this.corpsId = corpsId;
/* 181 */       this.oldName = oldName;
/* 182 */       this.name2CorpsId = name2CorpsId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 189 */       xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(this.corpsId));
/*     */       
/* 191 */       if (!xCorps.getCorpsname().equals(this.oldName))
/*     */       {
/* 193 */         MergeMain.formatLogError("[corps]PHandleDuplicateName.processImp@unexpected name|gangid=%d|name=%s|duplicated_name=%s", new Object[] { Long.valueOf(this.corpsId), xCorps.getCorpsname(), this.oldName });
/*     */         
/*     */ 
/* 196 */         return false;
/*     */       }
/*     */       
/* 199 */       String newName = MergeMain.nextNameByDuplicated(this.oldName);
/* 200 */       while (this.name2CorpsId.containsKey(newName))
/*     */       {
/* 202 */         newName = MergeMain.nextNameByDuplicated(newName);
/*     */       }
/* 204 */       xCorps.setCorpsname(newName);
/*     */       
/*     */ 
/* 207 */       this.name2CorpsId.put(newName, Long.valueOf(this.corpsId));
/*     */       
/* 209 */       MergeMain.formatLogInfo("[corps]PHandleDuplicateName.processImp@handle duplicated name|corpsid=%d|old_name=%s|new_name=%s", new Object[] { Long.valueOf(this.corpsId), this.oldName, newName });
/*     */       
/*     */ 
/*     */ 
/* 213 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\CorpsMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */