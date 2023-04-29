/*     */ package mzm.gsp.singlebattle.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SSingleBattleCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SSingleBattleCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SSingleBattleCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int playLibId;
/*     */   public int battleType;
/*     */   public int synchroInterval;
/*     */   public int matchDuration;
/*     */   public int prepareDuration;
/*     */   public int waitCleanDuration;
/*     */   public int cleanDuration;
/*     */   public int fightMap;
/*     */   public int camp1;
/*     */   public int camp2;
/*     */   public int protectedInterval;
/*     */   public double winnerAddPoint;
/*     */   public double loserAddPoint;
/*     */   public double drawAddPoint;
/*     */   public double winCampMvpAddPoint;
/*     */   public double loseCampMvpAddPoint;
/*     */   public double drawCampMvpAddPoint;
/*     */   public int addPointPerKillOne;
/*     */   public int cutPointPerBeKilled;
/*     */   public int addKillPointMax;
/*     */   public int defaultRevivalTime;
/*     */   public int diffScores;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  44 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  45 */     this.playLibId = Integer.valueOf(rootElement.attributeValue("playLibId")).intValue();
/*  46 */     this.battleType = Integer.valueOf(rootElement.attributeValue("battleType")).intValue();
/*  47 */     this.synchroInterval = Integer.valueOf(rootElement.attributeValue("synchroInterval")).intValue();
/*  48 */     this.matchDuration = Integer.valueOf(rootElement.attributeValue("matchDuration")).intValue();
/*  49 */     this.prepareDuration = Integer.valueOf(rootElement.attributeValue("prepareDuration")).intValue();
/*  50 */     this.waitCleanDuration = Integer.valueOf(rootElement.attributeValue("waitCleanDuration")).intValue();
/*  51 */     this.cleanDuration = Integer.valueOf(rootElement.attributeValue("cleanDuration")).intValue();
/*  52 */     this.fightMap = Integer.valueOf(rootElement.attributeValue("fightMap")).intValue();
/*  53 */     this.camp1 = Integer.valueOf(rootElement.attributeValue("camp1")).intValue();
/*  54 */     this.camp2 = Integer.valueOf(rootElement.attributeValue("camp2")).intValue();
/*  55 */     this.protectedInterval = Integer.valueOf(rootElement.attributeValue("protectedInterval")).intValue();
/*  56 */     this.winnerAddPoint = Double.valueOf(rootElement.attributeValue("winnerAddPoint")).doubleValue();
/*  57 */     this.loserAddPoint = Double.valueOf(rootElement.attributeValue("loserAddPoint")).doubleValue();
/*  58 */     this.drawAddPoint = Double.valueOf(rootElement.attributeValue("drawAddPoint")).doubleValue();
/*  59 */     this.winCampMvpAddPoint = Double.valueOf(rootElement.attributeValue("winCampMvpAddPoint")).doubleValue();
/*  60 */     this.loseCampMvpAddPoint = Double.valueOf(rootElement.attributeValue("loseCampMvpAddPoint")).doubleValue();
/*  61 */     this.drawCampMvpAddPoint = Double.valueOf(rootElement.attributeValue("drawCampMvpAddPoint")).doubleValue();
/*  62 */     this.addPointPerKillOne = Integer.valueOf(rootElement.attributeValue("addPointPerKillOne")).intValue();
/*  63 */     this.cutPointPerBeKilled = Integer.valueOf(rootElement.attributeValue("cutPointPerBeKilled")).intValue();
/*  64 */     this.addKillPointMax = Integer.valueOf(rootElement.attributeValue("addKillPointMax")).intValue();
/*  65 */     this.defaultRevivalTime = Integer.valueOf(rootElement.attributeValue("defaultRevivalTime")).intValue();
/*  66 */     this.diffScores = Integer.valueOf(rootElement.attributeValue("diffScores")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  71 */     _os_.marshal(this.id);
/*  72 */     _os_.marshal(this.playLibId);
/*  73 */     _os_.marshal(this.battleType);
/*  74 */     _os_.marshal(this.synchroInterval);
/*  75 */     _os_.marshal(this.matchDuration);
/*  76 */     _os_.marshal(this.prepareDuration);
/*  77 */     _os_.marshal(this.waitCleanDuration);
/*  78 */     _os_.marshal(this.cleanDuration);
/*  79 */     _os_.marshal(this.fightMap);
/*  80 */     _os_.marshal(this.camp1);
/*  81 */     _os_.marshal(this.camp2);
/*  82 */     _os_.marshal(this.protectedInterval);
/*  83 */     _os_.marshal(this.winnerAddPoint);
/*  84 */     _os_.marshal(this.loserAddPoint);
/*  85 */     _os_.marshal(this.drawAddPoint);
/*  86 */     _os_.marshal(this.winCampMvpAddPoint);
/*  87 */     _os_.marshal(this.loseCampMvpAddPoint);
/*  88 */     _os_.marshal(this.drawCampMvpAddPoint);
/*  89 */     _os_.marshal(this.addPointPerKillOne);
/*  90 */     _os_.marshal(this.cutPointPerBeKilled);
/*  91 */     _os_.marshal(this.addKillPointMax);
/*  92 */     _os_.marshal(this.defaultRevivalTime);
/*  93 */     _os_.marshal(this.diffScores);
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  99 */     this.id = _os_.unmarshal_int();
/* 100 */     this.playLibId = _os_.unmarshal_int();
/* 101 */     this.battleType = _os_.unmarshal_int();
/* 102 */     this.synchroInterval = _os_.unmarshal_int();
/* 103 */     this.matchDuration = _os_.unmarshal_int();
/* 104 */     this.prepareDuration = _os_.unmarshal_int();
/* 105 */     this.waitCleanDuration = _os_.unmarshal_int();
/* 106 */     this.cleanDuration = _os_.unmarshal_int();
/* 107 */     this.fightMap = _os_.unmarshal_int();
/* 108 */     this.camp1 = _os_.unmarshal_int();
/* 109 */     this.camp2 = _os_.unmarshal_int();
/* 110 */     this.protectedInterval = _os_.unmarshal_int();
/* 111 */     this.winnerAddPoint = _os_.unmarshal_float();
/* 112 */     this.loserAddPoint = _os_.unmarshal_float();
/* 113 */     this.drawAddPoint = _os_.unmarshal_float();
/* 114 */     this.winCampMvpAddPoint = _os_.unmarshal_float();
/* 115 */     this.loseCampMvpAddPoint = _os_.unmarshal_float();
/* 116 */     this.drawCampMvpAddPoint = _os_.unmarshal_float();
/* 117 */     this.addPointPerKillOne = _os_.unmarshal_int();
/* 118 */     this.cutPointPerBeKilled = _os_.unmarshal_int();
/* 119 */     this.addKillPointMax = _os_.unmarshal_int();
/* 120 */     this.defaultRevivalTime = _os_.unmarshal_int();
/* 121 */     this.diffScores = _os_.unmarshal_int();
/* 122 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 127 */     String path = dir + "mzm.gsp.singlebattle.confbean.SSingleBattleCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 131 */       all = new java.util.HashMap();
/* 132 */       SAXReader reader = new SAXReader();
/* 133 */       org.dom4j.Document doc = reader.read(new File(path));
/* 134 */       Element root = doc.getRootElement();
/* 135 */       List<?> nodeList = root.elements();
/* 136 */       int len = nodeList.size();
/* 137 */       for (int i = 0; i < len; i++)
/*     */       {
/* 139 */         Element elem = (Element)nodeList.get(i);
/* 140 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.singlebattle.confbean.SSingleBattleCfg"))
/*     */         {
/*     */ 
/* 143 */           SSingleBattleCfg obj = new SSingleBattleCfg();
/* 144 */           obj.loadFromXml(elem);
/* 145 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 146 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 151 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SSingleBattleCfg> all)
/*     */   {
/* 157 */     String path = dir + "mzm.gsp.singlebattle.confbean.SSingleBattleCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 161 */       SAXReader reader = new SAXReader();
/* 162 */       org.dom4j.Document doc = reader.read(new File(path));
/* 163 */       Element root = doc.getRootElement();
/* 164 */       List<?> nodeList = root.elements();
/* 165 */       int len = nodeList.size();
/* 166 */       for (int i = 0; i < len; i++)
/*     */       {
/* 168 */         Element elem = (Element)nodeList.get(i);
/* 169 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.singlebattle.confbean.SSingleBattleCfg"))
/*     */         {
/*     */ 
/* 172 */           SSingleBattleCfg obj = new SSingleBattleCfg();
/* 173 */           obj.loadFromXml(elem);
/* 174 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 175 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 180 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 186 */     all = new java.util.HashMap();
/*     */     
/* 188 */     String path = dir + "mzm.gsp.singlebattle.confbean.SSingleBattleCfg.bny";
/*     */     try
/*     */     {
/* 191 */       File file = new File(path);
/* 192 */       if (file.exists())
/*     */       {
/* 194 */         byte[] bytes = new byte['Ѐ'];
/* 195 */         FileInputStream fis = new FileInputStream(file);
/* 196 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 197 */         int len = 0;
/* 198 */         while ((len = fis.read(bytes)) > 0)
/* 199 */           baos.write(bytes, 0, len);
/* 200 */         fis.close();
/* 201 */         bytes = baos.toByteArray();
/* 202 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 203 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 205 */           _os_.unmarshal_int();
/* 206 */           _os_.unmarshal_int();
/* 207 */           _os_.unmarshal_int();
/*     */         }
/* 209 */         _os_.unmarshal_int();
/* 210 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 213 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 215 */           SSingleBattleCfg _v_ = new SSingleBattleCfg();
/* 216 */           _v_.unmarshal(_os_);
/* 217 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 218 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 223 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 228 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SSingleBattleCfg> all)
/*     */   {
/* 235 */     String path = dir + "mzm.gsp.singlebattle.confbean.SSingleBattleCfg.bny";
/*     */     try
/*     */     {
/* 238 */       File file = new File(path);
/* 239 */       if (file.exists())
/*     */       {
/* 241 */         byte[] bytes = new byte['Ѐ'];
/* 242 */         FileInputStream fis = new FileInputStream(file);
/* 243 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 244 */         int len = 0;
/* 245 */         while ((len = fis.read(bytes)) > 0)
/* 246 */           baos.write(bytes, 0, len);
/* 247 */         fis.close();
/* 248 */         bytes = baos.toByteArray();
/* 249 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 250 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 252 */           _os_.unmarshal_int();
/* 253 */           _os_.unmarshal_int();
/* 254 */           _os_.unmarshal_int();
/*     */         }
/* 256 */         _os_.unmarshal_int();
/* 257 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 260 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 262 */           SSingleBattleCfg _v_ = new SSingleBattleCfg();
/* 263 */           _v_.unmarshal(_os_);
/* 264 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 265 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 270 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 275 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SSingleBattleCfg getOld(int key)
/*     */   {
/* 283 */     return (SSingleBattleCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SSingleBattleCfg get(int key)
/*     */   {
/* 288 */     return (SSingleBattleCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSingleBattleCfg> getOldAll()
/*     */   {
/* 293 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSingleBattleCfg> getAll()
/*     */   {
/* 298 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SSingleBattleCfg> newAll)
/*     */   {
/* 303 */     oldAll = all;
/* 304 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 309 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\confbean\SSingleBattleCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */