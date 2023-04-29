/*     */ package mzm.gsp.partner.confbean;
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
/*     */ public class SPartnerCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SPartnerCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SPartnerCfg> all = null;
/*     */   
/*     */   public int templateId;
/*     */   public String templateName;
/*     */   public String name;
/*     */   public int faction;
/*     */   public int sex;
/*     */   public int type;
/*     */   public int classType;
/*     */   public int classLevel;
/*     */   public int unlockItem;
/*     */   public int unlockItemNum;
/*     */   public int unlockItemId;
/*     */   public int unlockLevel;
/*     */   public int modelId;
/*     */   public int bornStr;
/*     */   public int bornDex;
/*     */   public int bornSpr;
/*     */   public int bornCon;
/*     */   public int bornSta;
/*     */   public double addStrPerLevel;
/*     */   public double addDexPerLevel;
/*     */   public double addSprPerLevel;
/*     */   public double addConPerLevel;
/*     */   public double addStaPerLevel;
/*     */   public double bornMaxHP;
/*     */   public double bornMaxMp;
/*     */   public double bornPhyAtk;
/*     */   public double bornPhyDef;
/*     */   public double bornMagAtk;
/*     */   public double bornMagDef;
/*     */   public double bornSealHitLevel;
/*     */   public double bornSealResLevel;
/*     */   public double bornPhyHitLevel;
/*     */   public double bornPhyDodgeLevel;
/*     */   public double bornMagHitLevel;
/*     */   public double bornMagDodogeLevel;
/*     */   public int bornPhyCrtRate;
/*     */   public int bornMagCrtRate;
/*     */   public int bornPhyCrtValue;
/*     */   public int bornMagCrtValue;
/*     */   public double bornSpeed;
/*     */   public int level2propertyId;
/*     */   public double phyCrtLevel;
/*     */   public double magCrtLevel;
/*     */   public double phyCrtDefLevel;
/*     */   public double magCrtDefLevel;
/*     */   public String partnerAI;
/*  64 */   public java.util.ArrayList<Integer> skills = new java.util.ArrayList();
/*     */   public int LoveId;
/*     */   public String rank;
/*     */   public int yuanCfgId;
/*     */   public int rankId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  72 */     this.templateId = Integer.valueOf(rootElement.attributeValue("templateId")).intValue();
/*  73 */     this.templateName = rootElement.attributeValue("templateName");
/*  74 */     this.name = rootElement.attributeValue("name");
/*  75 */     this.faction = Integer.valueOf(rootElement.attributeValue("faction")).intValue();
/*  76 */     this.sex = Integer.valueOf(rootElement.attributeValue("sex")).intValue();
/*  77 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  78 */     this.classType = Integer.valueOf(rootElement.attributeValue("classType")).intValue();
/*  79 */     this.classLevel = Integer.valueOf(rootElement.attributeValue("classLevel")).intValue();
/*  80 */     this.unlockItem = Integer.valueOf(rootElement.attributeValue("unlockItem")).intValue();
/*  81 */     this.unlockItemNum = Integer.valueOf(rootElement.attributeValue("unlockItemNum")).intValue();
/*  82 */     this.unlockItemId = Integer.valueOf(rootElement.attributeValue("unlockItemId")).intValue();
/*  83 */     this.unlockLevel = Integer.valueOf(rootElement.attributeValue("unlockLevel")).intValue();
/*  84 */     this.modelId = Integer.valueOf(rootElement.attributeValue("modelId")).intValue();
/*  85 */     this.bornStr = Integer.valueOf(rootElement.attributeValue("bornStr")).intValue();
/*  86 */     this.bornDex = Integer.valueOf(rootElement.attributeValue("bornDex")).intValue();
/*  87 */     this.bornSpr = Integer.valueOf(rootElement.attributeValue("bornSpr")).intValue();
/*  88 */     this.bornCon = Integer.valueOf(rootElement.attributeValue("bornCon")).intValue();
/*  89 */     this.bornSta = Integer.valueOf(rootElement.attributeValue("bornSta")).intValue();
/*  90 */     this.addStrPerLevel = Double.valueOf(rootElement.attributeValue("addStrPerLevel")).doubleValue();
/*  91 */     this.addDexPerLevel = Double.valueOf(rootElement.attributeValue("addDexPerLevel")).doubleValue();
/*  92 */     this.addSprPerLevel = Double.valueOf(rootElement.attributeValue("addSprPerLevel")).doubleValue();
/*  93 */     this.addConPerLevel = Double.valueOf(rootElement.attributeValue("addConPerLevel")).doubleValue();
/*  94 */     this.addStaPerLevel = Double.valueOf(rootElement.attributeValue("addStaPerLevel")).doubleValue();
/*  95 */     this.bornMaxHP = Double.valueOf(rootElement.attributeValue("bornMaxHP")).doubleValue();
/*  96 */     this.bornMaxMp = Double.valueOf(rootElement.attributeValue("bornMaxMp")).doubleValue();
/*  97 */     this.bornPhyAtk = Double.valueOf(rootElement.attributeValue("bornPhyAtk")).doubleValue();
/*  98 */     this.bornPhyDef = Double.valueOf(rootElement.attributeValue("bornPhyDef")).doubleValue();
/*  99 */     this.bornMagAtk = Double.valueOf(rootElement.attributeValue("bornMagAtk")).doubleValue();
/* 100 */     this.bornMagDef = Double.valueOf(rootElement.attributeValue("bornMagDef")).doubleValue();
/* 101 */     this.bornSealHitLevel = Double.valueOf(rootElement.attributeValue("bornSealHitLevel")).doubleValue();
/* 102 */     this.bornSealResLevel = Double.valueOf(rootElement.attributeValue("bornSealResLevel")).doubleValue();
/* 103 */     this.bornPhyHitLevel = Double.valueOf(rootElement.attributeValue("bornPhyHitLevel")).doubleValue();
/* 104 */     this.bornPhyDodgeLevel = Double.valueOf(rootElement.attributeValue("bornPhyDodgeLevel")).doubleValue();
/* 105 */     this.bornMagHitLevel = Double.valueOf(rootElement.attributeValue("bornMagHitLevel")).doubleValue();
/* 106 */     this.bornMagDodogeLevel = Double.valueOf(rootElement.attributeValue("bornMagDodogeLevel")).doubleValue();
/* 107 */     this.bornPhyCrtRate = Integer.valueOf(rootElement.attributeValue("bornPhyCrtRate")).intValue();
/* 108 */     this.bornMagCrtRate = Integer.valueOf(rootElement.attributeValue("bornMagCrtRate")).intValue();
/* 109 */     this.bornPhyCrtValue = Integer.valueOf(rootElement.attributeValue("bornPhyCrtValue")).intValue();
/* 110 */     this.bornMagCrtValue = Integer.valueOf(rootElement.attributeValue("bornMagCrtValue")).intValue();
/* 111 */     this.bornSpeed = Double.valueOf(rootElement.attributeValue("bornSpeed")).doubleValue();
/* 112 */     this.level2propertyId = Integer.valueOf(rootElement.attributeValue("level2propertyId")).intValue();
/* 113 */     this.phyCrtLevel = Double.valueOf(rootElement.attributeValue("phyCrtLevel")).doubleValue();
/* 114 */     this.magCrtLevel = Double.valueOf(rootElement.attributeValue("magCrtLevel")).doubleValue();
/* 115 */     this.phyCrtDefLevel = Double.valueOf(rootElement.attributeValue("phyCrtDefLevel")).doubleValue();
/* 116 */     this.magCrtDefLevel = Double.valueOf(rootElement.attributeValue("magCrtDefLevel")).doubleValue();
/* 117 */     this.partnerAI = rootElement.attributeValue("partnerAI");
/*     */     
/* 119 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "skills");
/* 120 */     if (collectionElement == null)
/*     */     {
/* 122 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 125 */     List<?> _nodeList = collectionElement.elements();
/* 126 */     int _len = _nodeList.size();
/* 127 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 129 */       Element elem = (Element)_nodeList.get(i);
/* 130 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 137 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 144 */         this.skills.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/* 147 */     this.LoveId = Integer.valueOf(rootElement.attributeValue("LoveId")).intValue();
/* 148 */     this.rank = rootElement.attributeValue("rank");
/* 149 */     this.yuanCfgId = Integer.valueOf(rootElement.attributeValue("yuanCfgId")).intValue();
/* 150 */     this.rankId = Integer.valueOf(rootElement.attributeValue("rankId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 155 */     _os_.marshal(this.templateId);
/* 156 */     _os_.marshal(this.templateName, "UTF-8");
/* 157 */     _os_.marshal(this.name, "UTF-8");
/* 158 */     _os_.marshal(this.faction);
/* 159 */     _os_.marshal(this.sex);
/* 160 */     _os_.marshal(this.type);
/* 161 */     _os_.marshal(this.classType);
/* 162 */     _os_.marshal(this.classLevel);
/* 163 */     _os_.marshal(this.unlockItem);
/* 164 */     _os_.marshal(this.unlockItemNum);
/* 165 */     _os_.marshal(this.unlockItemId);
/* 166 */     _os_.marshal(this.unlockLevel);
/* 167 */     _os_.marshal(this.modelId);
/* 168 */     _os_.marshal(this.bornStr);
/* 169 */     _os_.marshal(this.bornDex);
/* 170 */     _os_.marshal(this.bornSpr);
/* 171 */     _os_.marshal(this.bornCon);
/* 172 */     _os_.marshal(this.bornSta);
/* 173 */     _os_.marshal(this.addStrPerLevel);
/* 174 */     _os_.marshal(this.addDexPerLevel);
/* 175 */     _os_.marshal(this.addSprPerLevel);
/* 176 */     _os_.marshal(this.addConPerLevel);
/* 177 */     _os_.marshal(this.addStaPerLevel);
/* 178 */     _os_.marshal(this.bornMaxHP);
/* 179 */     _os_.marshal(this.bornMaxMp);
/* 180 */     _os_.marshal(this.bornPhyAtk);
/* 181 */     _os_.marshal(this.bornPhyDef);
/* 182 */     _os_.marshal(this.bornMagAtk);
/* 183 */     _os_.marshal(this.bornMagDef);
/* 184 */     _os_.marshal(this.bornSealHitLevel);
/* 185 */     _os_.marshal(this.bornSealResLevel);
/* 186 */     _os_.marshal(this.bornPhyHitLevel);
/* 187 */     _os_.marshal(this.bornPhyDodgeLevel);
/* 188 */     _os_.marshal(this.bornMagHitLevel);
/* 189 */     _os_.marshal(this.bornMagDodogeLevel);
/* 190 */     _os_.marshal(this.bornPhyCrtRate);
/* 191 */     _os_.marshal(this.bornMagCrtRate);
/* 192 */     _os_.marshal(this.bornPhyCrtValue);
/* 193 */     _os_.marshal(this.bornMagCrtValue);
/* 194 */     _os_.marshal(this.bornSpeed);
/* 195 */     _os_.marshal(this.level2propertyId);
/* 196 */     _os_.marshal(this.phyCrtLevel);
/* 197 */     _os_.marshal(this.magCrtLevel);
/* 198 */     _os_.marshal(this.phyCrtDefLevel);
/* 199 */     _os_.marshal(this.magCrtDefLevel);
/* 200 */     _os_.marshal(this.partnerAI, "UTF-8");
/* 201 */     _os_.compact_uint32(this.skills.size());
/* 202 */     for (Integer _v_ : this.skills)
/*     */     {
/* 204 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 206 */     _os_.marshal(this.LoveId);
/* 207 */     _os_.marshal(this.rank, "UTF-8");
/* 208 */     _os_.marshal(this.yuanCfgId);
/* 209 */     _os_.marshal(this.rankId);
/* 210 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 215 */     this.templateId = _os_.unmarshal_int();
/* 216 */     this.templateName = _os_.unmarshal_String("UTF-8");
/* 217 */     this.name = _os_.unmarshal_String("UTF-8");
/* 218 */     this.faction = _os_.unmarshal_int();
/* 219 */     this.sex = _os_.unmarshal_int();
/* 220 */     this.type = _os_.unmarshal_int();
/* 221 */     this.classType = _os_.unmarshal_int();
/* 222 */     this.classLevel = _os_.unmarshal_int();
/* 223 */     this.unlockItem = _os_.unmarshal_int();
/* 224 */     this.unlockItemNum = _os_.unmarshal_int();
/* 225 */     this.unlockItemId = _os_.unmarshal_int();
/* 226 */     this.unlockLevel = _os_.unmarshal_int();
/* 227 */     this.modelId = _os_.unmarshal_int();
/* 228 */     this.bornStr = _os_.unmarshal_int();
/* 229 */     this.bornDex = _os_.unmarshal_int();
/* 230 */     this.bornSpr = _os_.unmarshal_int();
/* 231 */     this.bornCon = _os_.unmarshal_int();
/* 232 */     this.bornSta = _os_.unmarshal_int();
/* 233 */     this.addStrPerLevel = _os_.unmarshal_float();
/* 234 */     this.addDexPerLevel = _os_.unmarshal_float();
/* 235 */     this.addSprPerLevel = _os_.unmarshal_float();
/* 236 */     this.addConPerLevel = _os_.unmarshal_float();
/* 237 */     this.addStaPerLevel = _os_.unmarshal_float();
/* 238 */     this.bornMaxHP = _os_.unmarshal_float();
/* 239 */     this.bornMaxMp = _os_.unmarshal_float();
/* 240 */     this.bornPhyAtk = _os_.unmarshal_float();
/* 241 */     this.bornPhyDef = _os_.unmarshal_float();
/* 242 */     this.bornMagAtk = _os_.unmarshal_float();
/* 243 */     this.bornMagDef = _os_.unmarshal_float();
/* 244 */     this.bornSealHitLevel = _os_.unmarshal_float();
/* 245 */     this.bornSealResLevel = _os_.unmarshal_float();
/* 246 */     this.bornPhyHitLevel = _os_.unmarshal_float();
/* 247 */     this.bornPhyDodgeLevel = _os_.unmarshal_float();
/* 248 */     this.bornMagHitLevel = _os_.unmarshal_float();
/* 249 */     this.bornMagDodogeLevel = _os_.unmarshal_float();
/* 250 */     this.bornPhyCrtRate = _os_.unmarshal_int();
/* 251 */     this.bornMagCrtRate = _os_.unmarshal_int();
/* 252 */     this.bornPhyCrtValue = _os_.unmarshal_int();
/* 253 */     this.bornMagCrtValue = _os_.unmarshal_int();
/* 254 */     this.bornSpeed = _os_.unmarshal_float();
/* 255 */     this.level2propertyId = _os_.unmarshal_int();
/* 256 */     this.phyCrtLevel = _os_.unmarshal_float();
/* 257 */     this.magCrtLevel = _os_.unmarshal_float();
/* 258 */     this.phyCrtDefLevel = _os_.unmarshal_float();
/* 259 */     this.magCrtDefLevel = _os_.unmarshal_float();
/* 260 */     this.partnerAI = _os_.unmarshal_String("UTF-8");
/* 261 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 264 */       int _v_ = _os_.unmarshal_int();
/* 265 */       this.skills.add(Integer.valueOf(_v_));
/*     */     }
/* 267 */     this.LoveId = _os_.unmarshal_int();
/* 268 */     this.rank = _os_.unmarshal_String("UTF-8");
/* 269 */     this.yuanCfgId = _os_.unmarshal_int();
/* 270 */     this.rankId = _os_.unmarshal_int();
/* 271 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 276 */     String path = dir + "mzm.gsp.partner.confbean.SPartnerCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 280 */       all = new java.util.HashMap();
/* 281 */       SAXReader reader = new SAXReader();
/* 282 */       org.dom4j.Document doc = reader.read(new File(path));
/* 283 */       Element root = doc.getRootElement();
/* 284 */       List<?> nodeList = root.elements();
/* 285 */       int len = nodeList.size();
/* 286 */       for (int i = 0; i < len; i++)
/*     */       {
/* 288 */         Element elem = (Element)nodeList.get(i);
/* 289 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.partner.confbean.SPartnerCfg"))
/*     */         {
/*     */ 
/* 292 */           SPartnerCfg obj = new SPartnerCfg();
/* 293 */           obj.loadFromXml(elem);
/* 294 */           if (all.put(Integer.valueOf(obj.templateId), obj) != null) {
/* 295 */             throw new RuntimeException("duplicate key : " + obj.templateId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 300 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SPartnerCfg> all)
/*     */   {
/* 306 */     String path = dir + "mzm.gsp.partner.confbean.SPartnerCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 310 */       SAXReader reader = new SAXReader();
/* 311 */       org.dom4j.Document doc = reader.read(new File(path));
/* 312 */       Element root = doc.getRootElement();
/* 313 */       List<?> nodeList = root.elements();
/* 314 */       int len = nodeList.size();
/* 315 */       for (int i = 0; i < len; i++)
/*     */       {
/* 317 */         Element elem = (Element)nodeList.get(i);
/* 318 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.partner.confbean.SPartnerCfg"))
/*     */         {
/*     */ 
/* 321 */           SPartnerCfg obj = new SPartnerCfg();
/* 322 */           obj.loadFromXml(elem);
/* 323 */           if (all.put(Integer.valueOf(obj.templateId), obj) != null) {
/* 324 */             throw new RuntimeException("duplicate key : " + obj.templateId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 329 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 335 */     all = new java.util.HashMap();
/*     */     
/* 337 */     String path = dir + "mzm.gsp.partner.confbean.SPartnerCfg.bny";
/*     */     try
/*     */     {
/* 340 */       File file = new File(path);
/* 341 */       if (file.exists())
/*     */       {
/* 343 */         byte[] bytes = new byte['Ѐ'];
/* 344 */         FileInputStream fis = new FileInputStream(file);
/* 345 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 346 */         int len = 0;
/* 347 */         while ((len = fis.read(bytes)) > 0)
/* 348 */           baos.write(bytes, 0, len);
/* 349 */         fis.close();
/* 350 */         bytes = baos.toByteArray();
/* 351 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 352 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 354 */           _os_.unmarshal_int();
/* 355 */           _os_.unmarshal_int();
/* 356 */           _os_.unmarshal_int();
/*     */         }
/* 358 */         _os_.unmarshal_int();
/* 359 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 362 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 364 */           SPartnerCfg _v_ = new SPartnerCfg();
/* 365 */           _v_.unmarshal(_os_);
/* 366 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 367 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 372 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 377 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SPartnerCfg> all)
/*     */   {
/* 384 */     String path = dir + "mzm.gsp.partner.confbean.SPartnerCfg.bny";
/*     */     try
/*     */     {
/* 387 */       File file = new File(path);
/* 388 */       if (file.exists())
/*     */       {
/* 390 */         byte[] bytes = new byte['Ѐ'];
/* 391 */         FileInputStream fis = new FileInputStream(file);
/* 392 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 393 */         int len = 0;
/* 394 */         while ((len = fis.read(bytes)) > 0)
/* 395 */           baos.write(bytes, 0, len);
/* 396 */         fis.close();
/* 397 */         bytes = baos.toByteArray();
/* 398 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 399 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 401 */           _os_.unmarshal_int();
/* 402 */           _os_.unmarshal_int();
/* 403 */           _os_.unmarshal_int();
/*     */         }
/* 405 */         _os_.unmarshal_int();
/* 406 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 409 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 411 */           SPartnerCfg _v_ = new SPartnerCfg();
/* 412 */           _v_.unmarshal(_os_);
/* 413 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 414 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 419 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 424 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SPartnerCfg getOld(int key)
/*     */   {
/* 432 */     return (SPartnerCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SPartnerCfg get(int key)
/*     */   {
/* 437 */     return (SPartnerCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPartnerCfg> getOldAll()
/*     */   {
/* 442 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPartnerCfg> getAll()
/*     */   {
/* 447 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SPartnerCfg> newAll)
/*     */   {
/* 452 */     oldAll = all;
/* 453 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 458 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\confbean\SPartnerCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */