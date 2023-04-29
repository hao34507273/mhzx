/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CombineGangsInfo;
/*     */ import xbean.CombiningGangsKey;
/*     */ import xbean.GangGlobal;
/*     */ import xdb.Table;
/*     */ import xtable.Gangcombine;
/*     */ import xtable.Gangglobal;
/*     */ 
/*     */ public class GangMergeModule implements MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  25 */     List<Table> tables = new ArrayList();
/*     */     
/*  27 */     tables.add(Gangglobal.getTable());
/*  28 */     tables.add(xtable.Role2gangmember.getTable());
/*  29 */     tables.add(xtable.Gang.getTable());
/*  30 */     tables.add(xtable.Role2outgang.getTable());
/*  31 */     tables.add(Gangcombine.getTable());
/*     */     
/*  33 */     return tables;
/*     */   }
/*     */   
/*     */   public boolean handleMerge()
/*     */   {
/*  38 */     if (!new PMergeGangGlobal(null).call()) {
/*  39 */       MergeMain.formatLogError("GangMergeModule.handleMerge@merge gang global failed!!!!", new Object[0]);
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     long mainKey = MergeMain.getMainZoneid();
/*  44 */     GangGlobal xGlobal = Gangglobal.select(Long.valueOf(mainKey));
/*  45 */     if (xGlobal == null) {
/*  46 */       return true;
/*     */     }
/*     */     
/*  49 */     List<Long> sortGangs = new ArrayList(xGlobal.getAllgangids());
/*     */     
/*  51 */     java.util.Collections.sort(sortGangs);
/*     */     
/*  53 */     Map<String, Long> name2Gangid = new HashMap();
/*  54 */     Map<Long, String> duplicatedNameGangs = new HashMap();
/*     */     
/*  56 */     Iterator<Long> sortGangIterator = sortGangs.iterator();
/*  57 */     int nextDisplayid = 1;
/*  58 */     while (sortGangIterator.hasNext()) {
/*  59 */       long gangid = ((Long)sortGangIterator.next()).longValue();
/*     */       
/*  61 */       if (!new PHandleDisplayid(gangid, nextDisplayid, name2Gangid, duplicatedNameGangs).call()) {
/*  62 */         MergeMain.formatLogError("GangMergeModule.handleMerge@handle displayid error|gangid=%d|displayid=%d", new Object[] { Long.valueOf(gangid), Integer.valueOf(nextDisplayid) });
/*     */         
/*     */ 
/*  65 */         return false;
/*     */       }
/*     */       
/*  68 */       nextDisplayid++;
/*     */     }
/*     */     
/*  71 */     Iterator<Map.Entry<Long, String>> duplicatedGangIter = duplicatedNameGangs.entrySet().iterator();
/*  72 */     while (duplicatedGangIter.hasNext()) {
/*  73 */       Map.Entry<Long, String> entry = (Map.Entry)duplicatedGangIter.next();
/*  74 */       long gangid = ((Long)entry.getKey()).longValue();
/*  75 */       String name = (String)entry.getValue();
/*     */       
/*  77 */       if (!new PHandleDuplicateName(gangid, name, name2Gangid).call()) {
/*  78 */         MergeMain.formatLogError("GangMergeModule.handleMerge@handle duplicate name error|gangid=%d|name=%s", new Object[] { Long.valueOf(gangid), name });
/*     */         
/*     */ 
/*  81 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  85 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class PMergeGangGlobal
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 100 */       long mainKey = MergeMain.getMainZoneid();
/* 101 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/*     */ 
/* 104 */       lock(Gangglobal.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/* 106 */       GangGlobal xMainGlobal = Gangglobal.get(Long.valueOf(mainKey));
/* 107 */       GangGlobal xViceGlobal = Gangglobal.get(Long.valueOf(viceKey));
/*     */       
/* 109 */       if (xMainGlobal == null) {
/* 110 */         xMainGlobal = xbean.Pod.newGangGlobal();
/* 111 */         Gangglobal.insert(Long.valueOf(mainKey), xMainGlobal);
/*     */       }
/*     */       
/*     */ 
/* 115 */       if (xViceGlobal == null) {
/* 116 */         MergeMain.formatLogWarn("PMergeGangGlobal.processImp@vice record null|vice_key=%d", new Object[] { Long.valueOf(viceKey) });
/*     */         
/* 118 */         setNextDisplayid(xMainGlobal);
/*     */         
/* 120 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 124 */       Iterator<Long> viceGangIter = xViceGlobal.getAllgangids().iterator();
/*     */       
/* 126 */       while (viceGangIter.hasNext()) {
/* 127 */         long viceGangid = ((Long)viceGangIter.next()).longValue();
/* 128 */         if (!xMainGlobal.getAllgangids().add(Long.valueOf(viceGangid)))
/*     */         {
/* 130 */           MergeMain.formatLogError("PMergeGangGlobal.processImp@duplicated gang id|id=%d", new Object[] { Long.valueOf(viceGangid) });
/* 131 */           return false;
/*     */         }
/* 133 */         viceGangIter.remove();
/*     */       }
/*     */       
/*     */ 
/* 137 */       Iterator<Map.Entry<CombiningGangsKey, CombineGangsInfo>> combineIter = xViceGlobal.getCombine().entrySet().iterator();
/* 138 */       while (combineIter.hasNext()) {
/* 139 */         Map.Entry<CombiningGangsKey, CombineGangsInfo> entry = (Map.Entry)combineIter.next();
/* 140 */         combineIter.remove();
/*     */         
/* 142 */         if (xMainGlobal.getCombine().put(entry.getKey(), entry.getValue()) != null)
/*     */         {
/* 144 */           MergeMain.formatLogError("PMergeGangGlobal.processImp@duplicated combine key|key=%s", new Object[] { entry.getKey() });
/* 145 */           return false;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 150 */       setNextDisplayid(xMainGlobal);
/*     */       
/*     */ 
/* 153 */       Gangglobal.remove(Long.valueOf(viceKey));
/*     */       
/* 155 */       return true;
/*     */     }
/*     */     
/*     */     private void setNextDisplayid(GangGlobal xGlobal) {
/* 159 */       if (xGlobal == null) {
/* 160 */         return;
/*     */       }
/* 162 */       xGlobal.setNextdisplayid(xGlobal.getAllgangids().size() + 1);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class PHandleDisplayid
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long gangid;
/*     */     
/*     */ 
/*     */     private final int displayid;
/*     */     
/*     */     private final Map<String, Long> name2Gangid;
/*     */     
/*     */     private final Map<Long, String> duplicatedNameGangs;
/*     */     
/*     */ 
/*     */     PHandleDisplayid(long gangid, int displayid, Map<String, Long> name2Gangid, Map<Long, String> duplicatedNameGangs)
/*     */     {
/* 183 */       this.gangid = gangid;
/* 184 */       this.displayid = displayid;
/* 185 */       this.name2Gangid = name2Gangid;
/* 186 */       this.duplicatedNameGangs = duplicatedNameGangs;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 191 */       xbean.Gang xGang = xtable.Gang.get(Long.valueOf(this.gangid));
/* 192 */       xGang.setDisplayid(this.displayid);
/*     */       
/* 194 */       MergeMain.formatLogInfo("PHandleDisplayid.processImp@handle displayid|gangid=%d|displayid=%d", new Object[] { Long.valueOf(this.gangid), Integer.valueOf(this.displayid) });
/*     */       
/* 196 */       String name = xGang.getName();
/*     */       
/* 198 */       Long oldGangid = (Long)this.name2Gangid.get(name);
/* 199 */       if (oldGangid != null) {
/* 200 */         MergeMain.formatLogInfo("PHandleDisplayid.processImp@duplicated gang name|name=%s|gangid1=%d|gangid2=%d", new Object[] { name, Long.valueOf(oldGangid.longValue()), Long.valueOf(this.gangid) });
/*     */         
/*     */ 
/*     */ 
/* 204 */         this.duplicatedNameGangs.put(Long.valueOf(this.gangid), name);
/*     */       }
/*     */       else {
/* 207 */         this.name2Gangid.put(name, Long.valueOf(this.gangid));
/*     */       }
/*     */       
/* 210 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PHandleDuplicateName
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long gangid;
/*     */     private final String oldName;
/*     */     private final Map<String, Long> name2Gangid;
/*     */     
/*     */     PHandleDuplicateName(long gangid, String oldName, Map<String, Long> name2Gangid)
/*     */     {
/* 223 */       this.gangid = gangid;
/* 224 */       this.oldName = oldName;
/* 225 */       this.name2Gangid = name2Gangid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 231 */       xbean.Gang xGang = xtable.Gang.select(Long.valueOf(this.gangid));
/*     */       
/* 233 */       long leaderid = xGang.getBangzhuid();
/*     */       
/* 235 */       String leaderName = mzm.gsp.role.main.RoleInterface.getName(leaderid);
/*     */       
/*     */ 
/* 238 */       xGang = xtable.Gang.get(Long.valueOf(this.gangid));
/*     */       
/* 240 */       if (!xGang.getName().equals(this.oldName)) {
/* 241 */         MergeMain.formatLogError("PHandleDuplicateName.processImp@unexpected name|gangid=%d|name=%s|duplicated_name=%s", new Object[] { Long.valueOf(this.gangid), xGang.getName(), this.oldName });
/*     */         
/*     */ 
/* 244 */         return false;
/*     */       }
/*     */       
/* 247 */       String newName = MergeMain.nextNameByDuplicated(this.oldName);
/* 248 */       while (this.name2Gangid.containsKey(newName)) {
/* 249 */         newName = MergeMain.nextNameByDuplicated(newName);
/*     */       }
/*     */       
/* 252 */       xGang.setName(newName);
/*     */       
/*     */ 
/* 255 */       this.name2Gangid.put(newName, Long.valueOf(this.gangid));
/*     */       
/* 257 */       MergeMain.formatLogInfo("PHandleDuplicateName.processImp@handle duplicated name|gangid=%d|old_name=%s|new_name=%s|leaderid=%d|leadername=%s", new Object[] { Long.valueOf(this.gangid), this.oldName, newName, Long.valueOf(leaderid), leaderName });
/*     */       
/*     */ 
/*     */ 
/* 261 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\GangMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */