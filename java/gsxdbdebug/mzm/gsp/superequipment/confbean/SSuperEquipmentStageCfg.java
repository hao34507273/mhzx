/*     */ package mzm.gsp.superequipment.confbean;
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
/*     */ public class SSuperEquipmentStageCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SSuperEquipmentStageCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SSuperEquipmentStageCfg> all = null;
/*     */   
/*     */   public int stage;
/*     */   public int maxStrengthLevel;
/*     */   public int maxGemLevel;
/*     */   public int gemSlotNum;
/*     */   public int requiredLevel;
/*     */   public int requiredEquipmentQuality;
/*     */   public int requiredEquipmentLevel;
/*     */   public int requiredStrengthLevel;
/*     */   public int requiredRoleLevel;
/*     */   public int requiredServerLevel;
/*     */   public int requiredCurrencyType;
/*     */   public int requiredCurrencyNum;
/*  30 */   public java.util.ArrayList<SuperEquipmentStageRequiredItem> requiredItems = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  34 */     this.stage = Integer.valueOf(rootElement.attributeValue("stage")).intValue();
/*  35 */     this.maxStrengthLevel = Integer.valueOf(rootElement.attributeValue("maxStrengthLevel")).intValue();
/*  36 */     this.maxGemLevel = Integer.valueOf(rootElement.attributeValue("maxGemLevel")).intValue();
/*  37 */     this.gemSlotNum = Integer.valueOf(rootElement.attributeValue("gemSlotNum")).intValue();
/*  38 */     this.requiredLevel = Integer.valueOf(rootElement.attributeValue("requiredLevel")).intValue();
/*  39 */     this.requiredEquipmentQuality = Integer.valueOf(rootElement.attributeValue("requiredEquipmentQuality")).intValue();
/*  40 */     this.requiredEquipmentLevel = Integer.valueOf(rootElement.attributeValue("requiredEquipmentLevel")).intValue();
/*  41 */     this.requiredStrengthLevel = Integer.valueOf(rootElement.attributeValue("requiredStrengthLevel")).intValue();
/*  42 */     this.requiredRoleLevel = Integer.valueOf(rootElement.attributeValue("requiredRoleLevel")).intValue();
/*  43 */     this.requiredServerLevel = Integer.valueOf(rootElement.attributeValue("requiredServerLevel")).intValue();
/*  44 */     this.requiredCurrencyType = Integer.valueOf(rootElement.attributeValue("requiredCurrencyType")).intValue();
/*  45 */     this.requiredCurrencyNum = Integer.valueOf(rootElement.attributeValue("requiredCurrencyNum")).intValue();
/*     */     
/*  47 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "requiredItems");
/*  48 */     if (collectionElement == null)
/*     */     {
/*  50 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  53 */     List<?> _nodeList = collectionElement.elements();
/*  54 */     int _len = _nodeList.size();
/*  55 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  57 */       Element elem = (Element)_nodeList.get(i);
/*  58 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.confbean.SuperEquipmentStageRequiredItem"))
/*     */       {
/*     */         SuperEquipmentStageRequiredItem _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  65 */           _v_ = new SuperEquipmentStageRequiredItem();
/*  66 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  73 */         this.requiredItems.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  80 */     _os_.marshal(this.stage);
/*  81 */     _os_.marshal(this.maxStrengthLevel);
/*  82 */     _os_.marshal(this.maxGemLevel);
/*  83 */     _os_.marshal(this.gemSlotNum);
/*  84 */     _os_.marshal(this.requiredLevel);
/*  85 */     _os_.marshal(this.requiredEquipmentQuality);
/*  86 */     _os_.marshal(this.requiredEquipmentLevel);
/*  87 */     _os_.marshal(this.requiredStrengthLevel);
/*  88 */     _os_.marshal(this.requiredRoleLevel);
/*  89 */     _os_.marshal(this.requiredServerLevel);
/*  90 */     _os_.marshal(this.requiredCurrencyType);
/*  91 */     _os_.marshal(this.requiredCurrencyNum);
/*  92 */     _os_.compact_uint32(this.requiredItems.size());
/*  93 */     for (SuperEquipmentStageRequiredItem _v_ : this.requiredItems)
/*     */     {
/*  95 */       _os_.marshal(_v_);
/*     */     }
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 102 */     this.stage = _os_.unmarshal_int();
/* 103 */     this.maxStrengthLevel = _os_.unmarshal_int();
/* 104 */     this.maxGemLevel = _os_.unmarshal_int();
/* 105 */     this.gemSlotNum = _os_.unmarshal_int();
/* 106 */     this.requiredLevel = _os_.unmarshal_int();
/* 107 */     this.requiredEquipmentQuality = _os_.unmarshal_int();
/* 108 */     this.requiredEquipmentLevel = _os_.unmarshal_int();
/* 109 */     this.requiredStrengthLevel = _os_.unmarshal_int();
/* 110 */     this.requiredRoleLevel = _os_.unmarshal_int();
/* 111 */     this.requiredServerLevel = _os_.unmarshal_int();
/* 112 */     this.requiredCurrencyType = _os_.unmarshal_int();
/* 113 */     this.requiredCurrencyNum = _os_.unmarshal_int();
/* 114 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 117 */       SuperEquipmentStageRequiredItem _v_ = new SuperEquipmentStageRequiredItem();
/* 118 */       _v_.unmarshal(_os_);
/* 119 */       this.requiredItems.add(_v_);
/*     */     }
/* 121 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 126 */     String path = dir + "mzm.gsp.superequipment.confbean.SSuperEquipmentStageCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 130 */       all = new java.util.TreeMap();
/* 131 */       SAXReader reader = new SAXReader();
/* 132 */       org.dom4j.Document doc = reader.read(new File(path));
/* 133 */       Element root = doc.getRootElement();
/* 134 */       List<?> nodeList = root.elements();
/* 135 */       int len = nodeList.size();
/* 136 */       for (int i = 0; i < len; i++)
/*     */       {
/* 138 */         Element elem = (Element)nodeList.get(i);
/* 139 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.confbean.SSuperEquipmentStageCfg"))
/*     */         {
/*     */ 
/* 142 */           SSuperEquipmentStageCfg obj = new SSuperEquipmentStageCfg();
/* 143 */           obj.loadFromXml(elem);
/* 144 */           if (all.put(Integer.valueOf(obj.stage), obj) != null) {
/* 145 */             throw new RuntimeException("duplicate key : " + obj.stage);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 150 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SSuperEquipmentStageCfg> all)
/*     */   {
/* 156 */     String path = dir + "mzm.gsp.superequipment.confbean.SSuperEquipmentStageCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 160 */       SAXReader reader = new SAXReader();
/* 161 */       org.dom4j.Document doc = reader.read(new File(path));
/* 162 */       Element root = doc.getRootElement();
/* 163 */       List<?> nodeList = root.elements();
/* 164 */       int len = nodeList.size();
/* 165 */       for (int i = 0; i < len; i++)
/*     */       {
/* 167 */         Element elem = (Element)nodeList.get(i);
/* 168 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.confbean.SSuperEquipmentStageCfg"))
/*     */         {
/*     */ 
/* 171 */           SSuperEquipmentStageCfg obj = new SSuperEquipmentStageCfg();
/* 172 */           obj.loadFromXml(elem);
/* 173 */           if (all.put(Integer.valueOf(obj.stage), obj) != null) {
/* 174 */             throw new RuntimeException("duplicate key : " + obj.stage);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 179 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 185 */     all = new java.util.TreeMap();
/*     */     
/* 187 */     String path = dir + "mzm.gsp.superequipment.confbean.SSuperEquipmentStageCfg.bny";
/*     */     try
/*     */     {
/* 190 */       File file = new File(path);
/* 191 */       if (file.exists())
/*     */       {
/* 193 */         byte[] bytes = new byte['Ѐ'];
/* 194 */         FileInputStream fis = new FileInputStream(file);
/* 195 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 196 */         int len = 0;
/* 197 */         while ((len = fis.read(bytes)) > 0)
/* 198 */           baos.write(bytes, 0, len);
/* 199 */         fis.close();
/* 200 */         bytes = baos.toByteArray();
/* 201 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 202 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 204 */           _os_.unmarshal_int();
/* 205 */           _os_.unmarshal_int();
/* 206 */           _os_.unmarshal_int();
/*     */         }
/* 208 */         _os_.unmarshal_int();
/* 209 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 212 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 214 */           SSuperEquipmentStageCfg _v_ = new SSuperEquipmentStageCfg();
/* 215 */           _v_.unmarshal(_os_);
/* 216 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 217 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 222 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 227 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SSuperEquipmentStageCfg> all)
/*     */   {
/* 234 */     String path = dir + "mzm.gsp.superequipment.confbean.SSuperEquipmentStageCfg.bny";
/*     */     try
/*     */     {
/* 237 */       File file = new File(path);
/* 238 */       if (file.exists())
/*     */       {
/* 240 */         byte[] bytes = new byte['Ѐ'];
/* 241 */         FileInputStream fis = new FileInputStream(file);
/* 242 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 243 */         int len = 0;
/* 244 */         while ((len = fis.read(bytes)) > 0)
/* 245 */           baos.write(bytes, 0, len);
/* 246 */         fis.close();
/* 247 */         bytes = baos.toByteArray();
/* 248 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 249 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 251 */           _os_.unmarshal_int();
/* 252 */           _os_.unmarshal_int();
/* 253 */           _os_.unmarshal_int();
/*     */         }
/* 255 */         _os_.unmarshal_int();
/* 256 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 259 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 261 */           SSuperEquipmentStageCfg _v_ = new SSuperEquipmentStageCfg();
/* 262 */           _v_.unmarshal(_os_);
/* 263 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 264 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 269 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 274 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SSuperEquipmentStageCfg getOld(int key)
/*     */   {
/* 282 */     return (SSuperEquipmentStageCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SSuperEquipmentStageCfg get(int key)
/*     */   {
/* 287 */     return (SSuperEquipmentStageCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSuperEquipmentStageCfg> getOldAll()
/*     */   {
/* 292 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SSuperEquipmentStageCfg> getAll()
/*     */   {
/* 297 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SSuperEquipmentStageCfg> newAll)
/*     */   {
/* 302 */     oldAll = all;
/* 303 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 308 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\confbean\SSuperEquipmentStageCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */