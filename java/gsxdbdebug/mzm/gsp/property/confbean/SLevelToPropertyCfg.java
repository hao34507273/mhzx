/*     */ package mzm.gsp.property.confbean;
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
/*     */ public class SLevelToPropertyCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SLevelToPropertyCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SLevelToPropertyCfg> all = null;
/*     */   
/*     */   public int templateId;
/*     */   public String templateName;
/*     */   public int level2propertyId;
/*     */   public int level;
/*     */   public double addMaxHpPerLevel;
/*     */   public double addMaxMpPerLevel;
/*     */   public double addPhyAtkPerLevel;
/*     */   public double addPhyDefPerLevel;
/*     */   public double addMagAtkPerLevel;
/*     */   public double addMagDefPerLevel;
/*     */   public double addSpeedPerLevelPerLevel;
/*     */   public double addSealHitLevelPerLevel;
/*     */   public double addSealResLevelPerLevel;
/*     */   public double addPhyHitLevelPerLevel;
/*     */   public double addPhyDodgeLevelPerLevel;
/*     */   public double addMagHitLevelPerLevel;
/*     */   public double addMagDodgeLevelPerLevel;
/*     */   public double addPhyCrtRatePerLevel;
/*     */   public double addMagCrtRatePerLevel;
/*     */   public double addPhyCrtValuePerLevel;
/*     */   public double addMagCrtValuePerLevel;
/*     */   public double addPhyCrtLevelPerLevel;
/*     */   public double addMagCrtLevelPerLevel;
/*     */   public double addPhyCrtLevelDefPerLevel;
/*     */   public double addMagCrtLevelDefPerLevel;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  46 */     this.templateId = Integer.valueOf(rootElement.attributeValue("templateId")).intValue();
/*  47 */     this.templateName = rootElement.attributeValue("templateName");
/*  48 */     this.level2propertyId = Integer.valueOf(rootElement.attributeValue("level2propertyId")).intValue();
/*  49 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  50 */     this.addMaxHpPerLevel = Double.valueOf(rootElement.attributeValue("addMaxHpPerLevel")).doubleValue();
/*  51 */     this.addMaxMpPerLevel = Double.valueOf(rootElement.attributeValue("addMaxMpPerLevel")).doubleValue();
/*  52 */     this.addPhyAtkPerLevel = Double.valueOf(rootElement.attributeValue("addPhyAtkPerLevel")).doubleValue();
/*  53 */     this.addPhyDefPerLevel = Double.valueOf(rootElement.attributeValue("addPhyDefPerLevel")).doubleValue();
/*  54 */     this.addMagAtkPerLevel = Double.valueOf(rootElement.attributeValue("addMagAtkPerLevel")).doubleValue();
/*  55 */     this.addMagDefPerLevel = Double.valueOf(rootElement.attributeValue("addMagDefPerLevel")).doubleValue();
/*  56 */     this.addSpeedPerLevelPerLevel = Double.valueOf(rootElement.attributeValue("addSpeedPerLevelPerLevel")).doubleValue();
/*  57 */     this.addSealHitLevelPerLevel = Double.valueOf(rootElement.attributeValue("addSealHitLevelPerLevel")).doubleValue();
/*  58 */     this.addSealResLevelPerLevel = Double.valueOf(rootElement.attributeValue("addSealResLevelPerLevel")).doubleValue();
/*  59 */     this.addPhyHitLevelPerLevel = Double.valueOf(rootElement.attributeValue("addPhyHitLevelPerLevel")).doubleValue();
/*  60 */     this.addPhyDodgeLevelPerLevel = Double.valueOf(rootElement.attributeValue("addPhyDodgeLevelPerLevel")).doubleValue();
/*  61 */     this.addMagHitLevelPerLevel = Double.valueOf(rootElement.attributeValue("addMagHitLevelPerLevel")).doubleValue();
/*  62 */     this.addMagDodgeLevelPerLevel = Double.valueOf(rootElement.attributeValue("addMagDodgeLevelPerLevel")).doubleValue();
/*  63 */     this.addPhyCrtRatePerLevel = Double.valueOf(rootElement.attributeValue("addPhyCrtRatePerLevel")).doubleValue();
/*  64 */     this.addMagCrtRatePerLevel = Double.valueOf(rootElement.attributeValue("addMagCrtRatePerLevel")).doubleValue();
/*  65 */     this.addPhyCrtValuePerLevel = Double.valueOf(rootElement.attributeValue("addPhyCrtValuePerLevel")).doubleValue();
/*  66 */     this.addMagCrtValuePerLevel = Double.valueOf(rootElement.attributeValue("addMagCrtValuePerLevel")).doubleValue();
/*  67 */     this.addPhyCrtLevelPerLevel = Double.valueOf(rootElement.attributeValue("addPhyCrtLevelPerLevel")).doubleValue();
/*  68 */     this.addMagCrtLevelPerLevel = Double.valueOf(rootElement.attributeValue("addMagCrtLevelPerLevel")).doubleValue();
/*  69 */     this.addPhyCrtLevelDefPerLevel = Double.valueOf(rootElement.attributeValue("addPhyCrtLevelDefPerLevel")).doubleValue();
/*  70 */     this.addMagCrtLevelDefPerLevel = Double.valueOf(rootElement.attributeValue("addMagCrtLevelDefPerLevel")).doubleValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _os_.marshal(this.templateId);
/*  76 */     _os_.marshal(this.templateName, "UTF-8");
/*  77 */     _os_.marshal(this.level2propertyId);
/*  78 */     _os_.marshal(this.level);
/*  79 */     _os_.marshal(this.addMaxHpPerLevel);
/*  80 */     _os_.marshal(this.addMaxMpPerLevel);
/*  81 */     _os_.marshal(this.addPhyAtkPerLevel);
/*  82 */     _os_.marshal(this.addPhyDefPerLevel);
/*  83 */     _os_.marshal(this.addMagAtkPerLevel);
/*  84 */     _os_.marshal(this.addMagDefPerLevel);
/*  85 */     _os_.marshal(this.addSpeedPerLevelPerLevel);
/*  86 */     _os_.marshal(this.addSealHitLevelPerLevel);
/*  87 */     _os_.marshal(this.addSealResLevelPerLevel);
/*  88 */     _os_.marshal(this.addPhyHitLevelPerLevel);
/*  89 */     _os_.marshal(this.addPhyDodgeLevelPerLevel);
/*  90 */     _os_.marshal(this.addMagHitLevelPerLevel);
/*  91 */     _os_.marshal(this.addMagDodgeLevelPerLevel);
/*  92 */     _os_.marshal(this.addPhyCrtRatePerLevel);
/*  93 */     _os_.marshal(this.addMagCrtRatePerLevel);
/*  94 */     _os_.marshal(this.addPhyCrtValuePerLevel);
/*  95 */     _os_.marshal(this.addMagCrtValuePerLevel);
/*  96 */     _os_.marshal(this.addPhyCrtLevelPerLevel);
/*  97 */     _os_.marshal(this.addMagCrtLevelPerLevel);
/*  98 */     _os_.marshal(this.addPhyCrtLevelDefPerLevel);
/*  99 */     _os_.marshal(this.addMagCrtLevelDefPerLevel);
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 105 */     this.templateId = _os_.unmarshal_int();
/* 106 */     this.templateName = _os_.unmarshal_String("UTF-8");
/* 107 */     this.level2propertyId = _os_.unmarshal_int();
/* 108 */     this.level = _os_.unmarshal_int();
/* 109 */     this.addMaxHpPerLevel = _os_.unmarshal_float();
/* 110 */     this.addMaxMpPerLevel = _os_.unmarshal_float();
/* 111 */     this.addPhyAtkPerLevel = _os_.unmarshal_float();
/* 112 */     this.addPhyDefPerLevel = _os_.unmarshal_float();
/* 113 */     this.addMagAtkPerLevel = _os_.unmarshal_float();
/* 114 */     this.addMagDefPerLevel = _os_.unmarshal_float();
/* 115 */     this.addSpeedPerLevelPerLevel = _os_.unmarshal_float();
/* 116 */     this.addSealHitLevelPerLevel = _os_.unmarshal_float();
/* 117 */     this.addSealResLevelPerLevel = _os_.unmarshal_float();
/* 118 */     this.addPhyHitLevelPerLevel = _os_.unmarshal_float();
/* 119 */     this.addPhyDodgeLevelPerLevel = _os_.unmarshal_float();
/* 120 */     this.addMagHitLevelPerLevel = _os_.unmarshal_float();
/* 121 */     this.addMagDodgeLevelPerLevel = _os_.unmarshal_float();
/* 122 */     this.addPhyCrtRatePerLevel = _os_.unmarshal_float();
/* 123 */     this.addMagCrtRatePerLevel = _os_.unmarshal_float();
/* 124 */     this.addPhyCrtValuePerLevel = _os_.unmarshal_float();
/* 125 */     this.addMagCrtValuePerLevel = _os_.unmarshal_float();
/* 126 */     this.addPhyCrtLevelPerLevel = _os_.unmarshal_float();
/* 127 */     this.addMagCrtLevelPerLevel = _os_.unmarshal_float();
/* 128 */     this.addPhyCrtLevelDefPerLevel = _os_.unmarshal_float();
/* 129 */     this.addMagCrtLevelDefPerLevel = _os_.unmarshal_float();
/* 130 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 135 */     String path = dir + "mzm.gsp.property.confbean.SLevelToPropertyCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 139 */       all = new java.util.HashMap();
/* 140 */       SAXReader reader = new SAXReader();
/* 141 */       org.dom4j.Document doc = reader.read(new File(path));
/* 142 */       Element root = doc.getRootElement();
/* 143 */       List<?> nodeList = root.elements();
/* 144 */       int len = nodeList.size();
/* 145 */       for (int i = 0; i < len; i++)
/*     */       {
/* 147 */         Element elem = (Element)nodeList.get(i);
/* 148 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.property.confbean.SLevelToPropertyCfg"))
/*     */         {
/*     */ 
/* 151 */           SLevelToPropertyCfg obj = new SLevelToPropertyCfg();
/* 152 */           obj.loadFromXml(elem);
/* 153 */           if (all.put(Integer.valueOf(obj.templateId), obj) != null) {
/* 154 */             throw new RuntimeException("duplicate key : " + obj.templateId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 159 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SLevelToPropertyCfg> all)
/*     */   {
/* 165 */     String path = dir + "mzm.gsp.property.confbean.SLevelToPropertyCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 169 */       SAXReader reader = new SAXReader();
/* 170 */       org.dom4j.Document doc = reader.read(new File(path));
/* 171 */       Element root = doc.getRootElement();
/* 172 */       List<?> nodeList = root.elements();
/* 173 */       int len = nodeList.size();
/* 174 */       for (int i = 0; i < len; i++)
/*     */       {
/* 176 */         Element elem = (Element)nodeList.get(i);
/* 177 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.property.confbean.SLevelToPropertyCfg"))
/*     */         {
/*     */ 
/* 180 */           SLevelToPropertyCfg obj = new SLevelToPropertyCfg();
/* 181 */           obj.loadFromXml(elem);
/* 182 */           if (all.put(Integer.valueOf(obj.templateId), obj) != null) {
/* 183 */             throw new RuntimeException("duplicate key : " + obj.templateId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 188 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 194 */     all = new java.util.HashMap();
/*     */     
/* 196 */     String path = dir + "mzm.gsp.property.confbean.SLevelToPropertyCfg.bny";
/*     */     try
/*     */     {
/* 199 */       File file = new File(path);
/* 200 */       if (file.exists())
/*     */       {
/* 202 */         byte[] bytes = new byte['Ѐ'];
/* 203 */         FileInputStream fis = new FileInputStream(file);
/* 204 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 205 */         int len = 0;
/* 206 */         while ((len = fis.read(bytes)) > 0)
/* 207 */           baos.write(bytes, 0, len);
/* 208 */         fis.close();
/* 209 */         bytes = baos.toByteArray();
/* 210 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 211 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 213 */           _os_.unmarshal_int();
/* 214 */           _os_.unmarshal_int();
/* 215 */           _os_.unmarshal_int();
/*     */         }
/* 217 */         _os_.unmarshal_int();
/* 218 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 221 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 223 */           SLevelToPropertyCfg _v_ = new SLevelToPropertyCfg();
/* 224 */           _v_.unmarshal(_os_);
/* 225 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 226 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 231 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 236 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SLevelToPropertyCfg> all)
/*     */   {
/* 243 */     String path = dir + "mzm.gsp.property.confbean.SLevelToPropertyCfg.bny";
/*     */     try
/*     */     {
/* 246 */       File file = new File(path);
/* 247 */       if (file.exists())
/*     */       {
/* 249 */         byte[] bytes = new byte['Ѐ'];
/* 250 */         FileInputStream fis = new FileInputStream(file);
/* 251 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 252 */         int len = 0;
/* 253 */         while ((len = fis.read(bytes)) > 0)
/* 254 */           baos.write(bytes, 0, len);
/* 255 */         fis.close();
/* 256 */         bytes = baos.toByteArray();
/* 257 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 258 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 260 */           _os_.unmarshal_int();
/* 261 */           _os_.unmarshal_int();
/* 262 */           _os_.unmarshal_int();
/*     */         }
/* 264 */         _os_.unmarshal_int();
/* 265 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 268 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 270 */           SLevelToPropertyCfg _v_ = new SLevelToPropertyCfg();
/* 271 */           _v_.unmarshal(_os_);
/* 272 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 273 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 278 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 283 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SLevelToPropertyCfg getOld(int key)
/*     */   {
/* 291 */     return (SLevelToPropertyCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SLevelToPropertyCfg get(int key)
/*     */   {
/* 296 */     return (SLevelToPropertyCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLevelToPropertyCfg> getOldAll()
/*     */   {
/* 301 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLevelToPropertyCfg> getAll()
/*     */   {
/* 306 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SLevelToPropertyCfg> newAll)
/*     */   {
/* 311 */     oldAll = all;
/* 312 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 317 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\property\confbean\SLevelToPropertyCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */