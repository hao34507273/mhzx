/*     */ package mzm.gsp.changemodelcard.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SOriginalChangeModelCardLevelCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SOriginalChangeModelCardLevelCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SOriginalChangeModelCardLevelCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int cardCfgId;
/*     */   public int useCostEssence;
/*     */   public int effectPersistMinute;
/*     */   public int effectPersistPVPFight;
/*     */   public int useCount;
/*     */   public int level;
/*     */   public int upgradeExp;
/*     */   public int provideExp;
/*     */   public int sellScore;
/*     */   public int unlockItemId;
/*     */   public int dyeId;
/*  30 */   public HashMap<Integer, Integer> propMap = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  34 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  35 */     this.cardCfgId = Integer.valueOf(rootElement.attributeValue("cardCfgId")).intValue();
/*  36 */     this.useCostEssence = Integer.valueOf(rootElement.attributeValue("useCostEssence")).intValue();
/*  37 */     this.effectPersistMinute = Integer.valueOf(rootElement.attributeValue("effectPersistMinute")).intValue();
/*  38 */     this.effectPersistPVPFight = Integer.valueOf(rootElement.attributeValue("effectPersistPVPFight")).intValue();
/*  39 */     this.useCount = Integer.valueOf(rootElement.attributeValue("useCount")).intValue();
/*  40 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  41 */     this.upgradeExp = Integer.valueOf(rootElement.attributeValue("upgradeExp")).intValue();
/*  42 */     this.provideExp = Integer.valueOf(rootElement.attributeValue("provideExp")).intValue();
/*  43 */     this.sellScore = Integer.valueOf(rootElement.attributeValue("sellScore")).intValue();
/*  44 */     this.unlockItemId = Integer.valueOf(rootElement.attributeValue("unlockItemId")).intValue();
/*  45 */     this.dyeId = Integer.valueOf(rootElement.attributeValue("dyeId")).intValue();
/*     */     
/*  47 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "propMap");
/*  48 */     if (mapTypeElement == null)
/*     */     {
/*  50 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  53 */     List<?> entryNodeList = mapTypeElement.elements();
/*  54 */     int entryLen = entryNodeList.size();
/*  55 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  57 */       Element entryElement = (Element)entryNodeList.get(i);
/*  58 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  63 */         Element keyElem = null;
/*  64 */         Element valueElem = null;
/*     */         
/*  66 */         List<?> _nodeList = entryElement.elements();
/*  67 */         int _len = _nodeList.size();
/*  68 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  70 */           Element elem = (Element)_nodeList.get(j);
/*  71 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  73 */             keyElem = elem;
/*     */           }
/*  75 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  77 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  81 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  83 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  90 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  91 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  98 */         this.propMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 105 */     _os_.marshal(this.id);
/* 106 */     _os_.marshal(this.cardCfgId);
/* 107 */     _os_.marshal(this.useCostEssence);
/* 108 */     _os_.marshal(this.effectPersistMinute);
/* 109 */     _os_.marshal(this.effectPersistPVPFight);
/* 110 */     _os_.marshal(this.useCount);
/* 111 */     _os_.marshal(this.level);
/* 112 */     _os_.marshal(this.upgradeExp);
/* 113 */     _os_.marshal(this.provideExp);
/* 114 */     _os_.marshal(this.sellScore);
/* 115 */     _os_.marshal(this.unlockItemId);
/* 116 */     _os_.marshal(this.dyeId);
/* 117 */     _os_.compact_uint32(this.propMap.size());
/* 118 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.propMap.entrySet())
/*     */     {
/* 120 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 121 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 123 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 128 */     this.id = _os_.unmarshal_int();
/* 129 */     this.cardCfgId = _os_.unmarshal_int();
/* 130 */     this.useCostEssence = _os_.unmarshal_int();
/* 131 */     this.effectPersistMinute = _os_.unmarshal_int();
/* 132 */     this.effectPersistPVPFight = _os_.unmarshal_int();
/* 133 */     this.useCount = _os_.unmarshal_int();
/* 134 */     this.level = _os_.unmarshal_int();
/* 135 */     this.upgradeExp = _os_.unmarshal_int();
/* 136 */     this.provideExp = _os_.unmarshal_int();
/* 137 */     this.sellScore = _os_.unmarshal_int();
/* 138 */     this.unlockItemId = _os_.unmarshal_int();
/* 139 */     this.dyeId = _os_.unmarshal_int();
/* 140 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 143 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 145 */       int _v_ = _os_.unmarshal_int();
/* 146 */       this.propMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 148 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 153 */     String path = dir + "mzm.gsp.changemodelcard.confbean.SOriginalChangeModelCardLevelCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 157 */       all = new HashMap();
/* 158 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 159 */       org.dom4j.Document doc = reader.read(new File(path));
/* 160 */       Element root = doc.getRootElement();
/* 161 */       List<?> nodeList = root.elements();
/* 162 */       int len = nodeList.size();
/* 163 */       for (int i = 0; i < len; i++)
/*     */       {
/* 165 */         Element elem = (Element)nodeList.get(i);
/* 166 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.changemodelcard.confbean.SOriginalChangeModelCardLevelCfg"))
/*     */         {
/*     */ 
/* 169 */           SOriginalChangeModelCardLevelCfg obj = new SOriginalChangeModelCardLevelCfg();
/* 170 */           obj.loadFromXml(elem);
/* 171 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 172 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 177 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SOriginalChangeModelCardLevelCfg> all)
/*     */   {
/* 183 */     String path = dir + "mzm.gsp.changemodelcard.confbean.SOriginalChangeModelCardLevelCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 187 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 188 */       org.dom4j.Document doc = reader.read(new File(path));
/* 189 */       Element root = doc.getRootElement();
/* 190 */       List<?> nodeList = root.elements();
/* 191 */       int len = nodeList.size();
/* 192 */       for (int i = 0; i < len; i++)
/*     */       {
/* 194 */         Element elem = (Element)nodeList.get(i);
/* 195 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.changemodelcard.confbean.SOriginalChangeModelCardLevelCfg"))
/*     */         {
/*     */ 
/* 198 */           SOriginalChangeModelCardLevelCfg obj = new SOriginalChangeModelCardLevelCfg();
/* 199 */           obj.loadFromXml(elem);
/* 200 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 201 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 206 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 212 */     all = new HashMap();
/*     */     
/* 214 */     String path = dir + "mzm.gsp.changemodelcard.confbean.SOriginalChangeModelCardLevelCfg.bny";
/*     */     try
/*     */     {
/* 217 */       File file = new File(path);
/* 218 */       if (file.exists())
/*     */       {
/* 220 */         byte[] bytes = new byte['Ѐ'];
/* 221 */         FileInputStream fis = new FileInputStream(file);
/* 222 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 223 */         int len = 0;
/* 224 */         while ((len = fis.read(bytes)) > 0)
/* 225 */           baos.write(bytes, 0, len);
/* 226 */         fis.close();
/* 227 */         bytes = baos.toByteArray();
/* 228 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 229 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 231 */           _os_.unmarshal_int();
/* 232 */           _os_.unmarshal_int();
/* 233 */           _os_.unmarshal_int();
/*     */         }
/* 235 */         _os_.unmarshal_int();
/* 236 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 239 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 241 */           SOriginalChangeModelCardLevelCfg _v_ = new SOriginalChangeModelCardLevelCfg();
/* 242 */           _v_.unmarshal(_os_);
/* 243 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 244 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 249 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 254 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SOriginalChangeModelCardLevelCfg> all)
/*     */   {
/* 261 */     String path = dir + "mzm.gsp.changemodelcard.confbean.SOriginalChangeModelCardLevelCfg.bny";
/*     */     try
/*     */     {
/* 264 */       File file = new File(path);
/* 265 */       if (file.exists())
/*     */       {
/* 267 */         byte[] bytes = new byte['Ѐ'];
/* 268 */         FileInputStream fis = new FileInputStream(file);
/* 269 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 270 */         int len = 0;
/* 271 */         while ((len = fis.read(bytes)) > 0)
/* 272 */           baos.write(bytes, 0, len);
/* 273 */         fis.close();
/* 274 */         bytes = baos.toByteArray();
/* 275 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 276 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 278 */           _os_.unmarshal_int();
/* 279 */           _os_.unmarshal_int();
/* 280 */           _os_.unmarshal_int();
/*     */         }
/* 282 */         _os_.unmarshal_int();
/* 283 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 286 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 288 */           SOriginalChangeModelCardLevelCfg _v_ = new SOriginalChangeModelCardLevelCfg();
/* 289 */           _v_.unmarshal(_os_);
/* 290 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 291 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 296 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 301 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SOriginalChangeModelCardLevelCfg getOld(int key)
/*     */   {
/* 309 */     return (SOriginalChangeModelCardLevelCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SOriginalChangeModelCardLevelCfg get(int key)
/*     */   {
/* 314 */     return (SOriginalChangeModelCardLevelCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOriginalChangeModelCardLevelCfg> getOldAll()
/*     */   {
/* 319 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOriginalChangeModelCardLevelCfg> getAll()
/*     */   {
/* 324 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SOriginalChangeModelCardLevelCfg> newAll)
/*     */   {
/* 329 */     oldAll = all;
/* 330 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 335 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\confbean\SOriginalChangeModelCardLevelCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */