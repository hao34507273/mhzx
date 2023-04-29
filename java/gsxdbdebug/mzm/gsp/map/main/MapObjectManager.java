/*     */ package mzm.gsp.map.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.map.NPCModelInfo;
/*     */ import mzm.gsp.map.main.proto.MapMonsterStarLevelPrototype;
/*     */ import mzm.gsp.menpaipvp.main.MenpaiPVPInterface;
/*     */ import mzm.gsp.menpaistar.main.MenPaiStarInterface;
/*     */ import mzm.gsp.monster.confbean.SDarknessMonster;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ import mzm.gsp.qmhw.main.QMHWInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CloneRoleNPCMap;
/*     */ import xbean.CloneRoleNPCModel;
/*     */ import xbean.CloneRoleNpcs;
/*     */ import xtable.Clone_role_npc_model;
/*     */ import xtable.Clone_role_npc_models;
/*     */ import xtable.Clone_role_npc_of_general;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MapObjectManager
/*     */ {
/*  33 */   private static MapObjectManager instance = new MapObjectManager();
/*     */   
/*  35 */   private Map<Integer, MapMonsterStarLevelPrototype> monsterStarLevelPrototypes = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  40 */   private Map<Integer, Octets> npcModelInfoMap = Collections.synchronizedMap(new HashMap());
/*     */   
/*     */   private static final int MENPAI_NPC_TABLE_KEY = 1;
/*     */   
/*     */   static final long getMenpaiNpcTableKey()
/*     */   {
/*  46 */     return GameServerInfoManager.toGlobalId(1L);
/*     */   }
/*     */   
/*     */   static final long getMenpaiNpcTableKey(long zoneid)
/*     */   {
/*  51 */     return GameServerInfoManager.toGlobalId(1L, zoneid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static MapObjectManager getInstance()
/*     */   {
/*  60 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public void init()
/*     */   {
/*  66 */     final Map<CloneRoleNpcModelType, Map<Integer, CloneRoleNPCModel>> typeToCloneRoleNpcs = new HashMap();
/*  67 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       private void collectCloneRoleNpcModels(CloneRoleNpcModelType cloneRoleNpcModelType, Collection<Integer> npcCfgids, Map<Integer, CloneRoleNPCModel> xCloneRoleNPCModels)
/*     */       {
/*  72 */         for (Integer npcCfgid : npcCfgids)
/*     */         {
/*  74 */           CloneRoleNPCModel xCloneRoleNPCModel = (CloneRoleNPCModel)xCloneRoleNPCModels.get(npcCfgid);
/*  75 */           if (xCloneRoleNPCModel != null)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*  80 */             Map<Integer, CloneRoleNPCModel> cloneRoleNpcModelMap = (Map)typeToCloneRoleNpcs.get(cloneRoleNpcModelType);
/*  81 */             if (cloneRoleNpcModelMap == null)
/*     */             {
/*  83 */               cloneRoleNpcModelMap = new HashMap();
/*  84 */               typeToCloneRoleNpcs.put(cloneRoleNpcModelType, cloneRoleNpcModelMap);
/*     */             }
/*  86 */             cloneRoleNpcModelMap.put(npcCfgid, xCloneRoleNPCModel.copy());
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  93 */         CloneRoleNPCMap xCloneRoleNPCMap = Clone_role_npc_model.get(Long.valueOf(MapObjectManager.getMenpaiNpcTableKey()));
/*  94 */         if (xCloneRoleNPCMap == null)
/*     */         {
/*  96 */           return false;
/*     */         }
/*     */         
/*  99 */         Map<Integer, CloneRoleNPCModel> xCloneRoleNPCModels = xCloneRoleNPCMap.getNpc_map();
/*     */         
/* 101 */         List<Integer> npcCfgids = MenpaiPVPInterface.getAllMenpaiChampionNpcs();
/* 102 */         collectCloneRoleNpcModels(CloneRoleNpcModelType.MEN_PAI, npcCfgids, xCloneRoleNPCModels);
/*     */         
/*     */ 
/*     */ 
/* 106 */         List<Integer> npcCfgids = QMHWInterface.getQMHWRoleNpcList();
/* 107 */         collectCloneRoleNpcModels(CloneRoleNpcModelType.QI_MAI_HUI_WU, npcCfgids, xCloneRoleNPCModels);
/*     */         
/*     */ 
/*     */ 
/* 111 */         List<Integer> npcCfgids = MenPaiStarInterface.getNpcCfgids();
/* 112 */         collectCloneRoleNpcModels(CloneRoleNpcModelType.MEN_PAI_STAR, npcCfgids, xCloneRoleNPCModels);
/*     */         
/*     */ 
/* 115 */         return true;
/*     */       }
/*     */     }.call();
/* 118 */     if (!typeToCloneRoleNpcs.isEmpty())
/*     */     {
/* 120 */       for (Map.Entry<CloneRoleNpcModelType, Map<Integer, CloneRoleNPCModel>> entry : typeToCloneRoleNpcs.entrySet())
/*     */       {
/* 122 */         key = (CloneRoleNpcModelType)entry.getKey();
/* 123 */         for (final Map.Entry<Integer, CloneRoleNPCModel> cloneRoleNPCModelEntry : ((Map)entry.getValue()).entrySet())
/*     */         {
/* 125 */           new LogicProcedure()
/*     */           {
/*     */             protected boolean processImp()
/*     */               throws Exception
/*     */             {
/* 130 */               CloneRoleNpcs xCloneRoleNpcs = MapManager.createXCloneRoleNpcsIfNeeded(key, -1L);
/* 131 */               long cloneRoleNPCModelKey = Clone_role_npc_models.insert((CloneRoleNPCModel)cloneRoleNPCModelEntry.getValue()).longValue();
/* 132 */               xCloneRoleNpcs.getNpc_map().put(cloneRoleNPCModelEntry.getKey(), Long.valueOf(cloneRoleNPCModelKey));
/*     */               
/* 134 */               return true;
/*     */             }
/*     */           }.call();
/*     */         }
/*     */       }
/*     */       final CloneRoleNpcModelType key;
/* 140 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 145 */           Clone_role_npc_model.remove(Long.valueOf(MapObjectManager.getMenpaiNpcTableKey()));
/*     */           
/* 147 */           return true;
/*     */         }
/*     */       }.call();
/*     */     }
/*     */     
/*     */ 
/* 153 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 158 */         for (CloneRoleNpcModelType cloneRoleNpcModelType : )
/*     */         {
/* 160 */           if (cloneRoleNpcModelType.cachable)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 165 */             CloneRoleNpcs xCloneRoleNpcs = Clone_role_npc_of_general.select(Long.valueOf(cloneRoleNpcModelType.toKey()));
/* 166 */             if (xCloneRoleNpcs != null)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 171 */               for (Map.Entry<Integer, Long> entry : xCloneRoleNpcs.getNpc_map().entrySet())
/*     */               {
/* 173 */                 Integer npcCfgid = (Integer)entry.getKey();
/* 174 */                 long cloneRoleNPCModelKey = ((Long)entry.getValue()).longValue();
/* 175 */                 CloneRoleNPCModel xCloneRoleNPCModel = Clone_role_npc_models.select(Long.valueOf(cloneRoleNPCModelKey));
/* 176 */                 if (xCloneRoleNPCModel != null)
/*     */                 {
/*     */ 
/*     */ 
/*     */ 
/* 181 */                   MapObjectManager.this.initNpcModel(npcCfgid.intValue(), xCloneRoleNPCModel); }
/*     */               } }
/*     */           }
/*     */         }
/* 185 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */   public boolean removeCloneRoleNpcModel(int npcCfgid)
/*     */   {
/* 192 */     return this.npcModelInfoMap.remove(Integer.valueOf(npcCfgid)) != null;
/*     */   }
/*     */   
/*     */   public NPCModelInfo boxNpcModelInfo(int npcCfgid, CloneRoleNPCModel xCloneRoleNPCModel)
/*     */   {
/* 197 */     NPCModelInfo mapModelInfo = new NPCModelInfo();
/* 198 */     for (Map.Entry<Integer, String> entry : xCloneRoleNPCModel.getString_prop_map().entrySet())
/*     */     {
/* 200 */       mapModelInfo.string_props.put(entry.getKey(), entry.getValue());
/*     */     }
/* 202 */     for (Map.Entry<Integer, Integer> entry : xCloneRoleNPCModel.getInt_prop_map().entrySet())
/*     */     {
/* 204 */       mapModelInfo.int_props.put(entry.getKey(), entry.getValue());
/*     */     }
/* 206 */     mapModelInfo.id = npcCfgid;
/* 207 */     mapModelInfo.model.extramap.put(Integer.valueOf(12), Integer.valueOf(xCloneRoleNPCModel.getColorid()));
/* 208 */     mapModelInfo.model.modelid = xCloneRoleNPCModel.getModelid();
/* 209 */     mapModelInfo.model.name = ((String)xCloneRoleNPCModel.getString_prop_map().get(Integer.valueOf(0)));
/* 210 */     for (Map.Entry<Integer, Integer> entry : xCloneRoleNPCModel.getModel_info().entrySet())
/*     */     {
/* 212 */       mapModelInfo.model.extramap.put(entry.getKey(), entry.getValue());
/*     */     }
/* 214 */     return mapModelInfo;
/*     */   }
/*     */   
/*     */   public Octets boxNpcModel(int npcCfgid, CloneRoleNPCModel xCloneRoleNPCModel)
/*     */   {
/* 219 */     NPCModelInfo mapModelInfo = boxNpcModelInfo(npcCfgid, xCloneRoleNPCModel);
/* 220 */     OctetsStream os = new OctetsStream();
/* 221 */     return mapModelInfo.marshal(os);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void initNpcModel(int npcCfgid, CloneRoleNPCModel xCloneRoleNPCModel)
/*     */   {
/* 232 */     Octets npcModelData = boxNpcModel(npcCfgid, xCloneRoleNPCModel);
/* 233 */     this.npcModelInfoMap.put(Integer.valueOf(npcCfgid), npcModelData);
/*     */   }
/*     */   
/*     */   public Octets getNpcModelInfo(int npcId)
/*     */   {
/* 238 */     return (Octets)this.npcModelInfoMap.get(Integer.valueOf(npcId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getDarkMonsterFightId(int cfgid)
/*     */   {
/* 250 */     SDarknessMonster darknessMonster = SDarknessMonster.get(cfgid);
/* 251 */     if (darknessMonster == null)
/*     */     {
/* 253 */       return -1;
/*     */     }
/* 255 */     return darknessMonster.monsterFightTableId;
/*     */   }
/*     */   
/*     */   public void addMonsterStarLevelPrototype(MapMonsterStarLevelPrototype prototype)
/*     */   {
/* 260 */     this.monsterStarLevelPrototypes.put(Integer.valueOf(prototype.getMonsterCfgid()), prototype);
/*     */   }
/*     */   
/*     */   public MapMonsterStarLevelPrototype getMonsterStarLevelPrototype(int monsterCfgid)
/*     */   {
/* 265 */     return (MapMonsterStarLevelPrototype)this.monsterStarLevelPrototypes.get(Integer.valueOf(monsterCfgid));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\MapObjectManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */