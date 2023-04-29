/*     */ package mzm.gsp.fashiondress.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SFashionDressCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFashionDressCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFashionDressCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String fashionDressName;
/*     */   public int menpai;
/*     */   public int gender;
/*     */   public int fashionShowType;
/*     */   public int modelChangeCfgId;
/*     */   public int modelId;
/*     */   public int effectTime;
/*     */   public int fashionDressType;
/*     */   public int fashionDressDyeType;
/*     */   public int clothesPressType;
/*     */   public int defaultHairDyeId;
/*     */   public int defaultClothDyeId;
/*     */   public int costItemId;
/*     */   public int costItemNum;
/*     */   public int unlockConditionId;
/*  34 */   public ArrayList<Integer> effectSkillList = new ArrayList();
/*  35 */   public ArrayList<Integer> propertySkillList = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  39 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  40 */     this.fashionDressName = rootElement.attributeValue("fashionDressName");
/*  41 */     this.menpai = Integer.valueOf(rootElement.attributeValue("menpai")).intValue();
/*  42 */     this.gender = Integer.valueOf(rootElement.attributeValue("gender")).intValue();
/*  43 */     this.fashionShowType = Integer.valueOf(rootElement.attributeValue("fashionShowType")).intValue();
/*  44 */     this.modelChangeCfgId = Integer.valueOf(rootElement.attributeValue("modelChangeCfgId")).intValue();
/*  45 */     this.modelId = Integer.valueOf(rootElement.attributeValue("modelId")).intValue();
/*  46 */     this.effectTime = Integer.valueOf(rootElement.attributeValue("effectTime")).intValue();
/*  47 */     this.fashionDressType = Integer.valueOf(rootElement.attributeValue("fashionDressType")).intValue();
/*  48 */     this.fashionDressDyeType = Integer.valueOf(rootElement.attributeValue("fashionDressDyeType")).intValue();
/*  49 */     this.clothesPressType = Integer.valueOf(rootElement.attributeValue("clothesPressType")).intValue();
/*  50 */     this.defaultHairDyeId = Integer.valueOf(rootElement.attributeValue("defaultHairDyeId")).intValue();
/*  51 */     this.defaultClothDyeId = Integer.valueOf(rootElement.attributeValue("defaultClothDyeId")).intValue();
/*  52 */     this.costItemId = Integer.valueOf(rootElement.attributeValue("costItemId")).intValue();
/*  53 */     this.costItemNum = Integer.valueOf(rootElement.attributeValue("costItemNum")).intValue();
/*  54 */     this.unlockConditionId = Integer.valueOf(rootElement.attributeValue("unlockConditionId")).intValue();
/*     */     
/*  56 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "effectSkillList");
/*  57 */     if (collectionElement == null)
/*     */     {
/*  59 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  62 */     List<?> _nodeList = collectionElement.elements();
/*  63 */     int _len = _nodeList.size();
/*  64 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  66 */       Element elem = (Element)_nodeList.get(i);
/*  67 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  74 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  81 */         this.effectSkillList.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  85 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "propertySkillList");
/*  86 */     if (collectionElement == null)
/*     */     {
/*  88 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  91 */     List<?> _nodeList = collectionElement.elements();
/*  92 */     int _len = _nodeList.size();
/*  93 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  95 */       Element elem = (Element)_nodeList.get(i);
/*  96 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 103 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 110 */         this.propertySkillList.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 117 */     _os_.marshal(this.id);
/* 118 */     _os_.marshal(this.fashionDressName, "UTF-8");
/* 119 */     _os_.marshal(this.menpai);
/* 120 */     _os_.marshal(this.gender);
/* 121 */     _os_.marshal(this.fashionShowType);
/* 122 */     _os_.marshal(this.modelChangeCfgId);
/* 123 */     _os_.marshal(this.modelId);
/* 124 */     _os_.marshal(this.effectTime);
/* 125 */     _os_.marshal(this.fashionDressType);
/* 126 */     _os_.marshal(this.fashionDressDyeType);
/* 127 */     _os_.marshal(this.clothesPressType);
/* 128 */     _os_.marshal(this.defaultHairDyeId);
/* 129 */     _os_.marshal(this.defaultClothDyeId);
/* 130 */     _os_.marshal(this.costItemId);
/* 131 */     _os_.marshal(this.costItemNum);
/* 132 */     _os_.marshal(this.unlockConditionId);
/* 133 */     _os_.compact_uint32(this.effectSkillList.size());
/* 134 */     for (Integer _v_ : this.effectSkillList)
/*     */     {
/* 136 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 138 */     _os_.compact_uint32(this.propertySkillList.size());
/* 139 */     for (Integer _v_ : this.propertySkillList)
/*     */     {
/* 141 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 143 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 148 */     this.id = _os_.unmarshal_int();
/* 149 */     this.fashionDressName = _os_.unmarshal_String("UTF-8");
/* 150 */     this.menpai = _os_.unmarshal_int();
/* 151 */     this.gender = _os_.unmarshal_int();
/* 152 */     this.fashionShowType = _os_.unmarshal_int();
/* 153 */     this.modelChangeCfgId = _os_.unmarshal_int();
/* 154 */     this.modelId = _os_.unmarshal_int();
/* 155 */     this.effectTime = _os_.unmarshal_int();
/* 156 */     this.fashionDressType = _os_.unmarshal_int();
/* 157 */     this.fashionDressDyeType = _os_.unmarshal_int();
/* 158 */     this.clothesPressType = _os_.unmarshal_int();
/* 159 */     this.defaultHairDyeId = _os_.unmarshal_int();
/* 160 */     this.defaultClothDyeId = _os_.unmarshal_int();
/* 161 */     this.costItemId = _os_.unmarshal_int();
/* 162 */     this.costItemNum = _os_.unmarshal_int();
/* 163 */     this.unlockConditionId = _os_.unmarshal_int();
/* 164 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 167 */       int _v_ = _os_.unmarshal_int();
/* 168 */       this.effectSkillList.add(Integer.valueOf(_v_));
/*     */     }
/* 170 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 173 */       int _v_ = _os_.unmarshal_int();
/* 174 */       this.propertySkillList.add(Integer.valueOf(_v_));
/*     */     }
/* 176 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 181 */     String path = dir + "mzm.gsp.fashiondress.confbean.SFashionDressCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 185 */       all = new java.util.HashMap();
/* 186 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 187 */       org.dom4j.Document doc = reader.read(new File(path));
/* 188 */       Element root = doc.getRootElement();
/* 189 */       List<?> nodeList = root.elements();
/* 190 */       int len = nodeList.size();
/* 191 */       for (int i = 0; i < len; i++)
/*     */       {
/* 193 */         Element elem = (Element)nodeList.get(i);
/* 194 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.fashiondress.confbean.SFashionDressCfg"))
/*     */         {
/*     */ 
/* 197 */           SFashionDressCfg obj = new SFashionDressCfg();
/* 198 */           obj.loadFromXml(elem);
/* 199 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 200 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 205 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFashionDressCfg> all)
/*     */   {
/* 211 */     String path = dir + "mzm.gsp.fashiondress.confbean.SFashionDressCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 215 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 216 */       org.dom4j.Document doc = reader.read(new File(path));
/* 217 */       Element root = doc.getRootElement();
/* 218 */       List<?> nodeList = root.elements();
/* 219 */       int len = nodeList.size();
/* 220 */       for (int i = 0; i < len; i++)
/*     */       {
/* 222 */         Element elem = (Element)nodeList.get(i);
/* 223 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.fashiondress.confbean.SFashionDressCfg"))
/*     */         {
/*     */ 
/* 226 */           SFashionDressCfg obj = new SFashionDressCfg();
/* 227 */           obj.loadFromXml(elem);
/* 228 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 229 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 234 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 240 */     all = new java.util.HashMap();
/*     */     
/* 242 */     String path = dir + "mzm.gsp.fashiondress.confbean.SFashionDressCfg.bny";
/*     */     try
/*     */     {
/* 245 */       File file = new File(path);
/* 246 */       if (file.exists())
/*     */       {
/* 248 */         byte[] bytes = new byte['Ѐ'];
/* 249 */         FileInputStream fis = new FileInputStream(file);
/* 250 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 251 */         int len = 0;
/* 252 */         while ((len = fis.read(bytes)) > 0)
/* 253 */           baos.write(bytes, 0, len);
/* 254 */         fis.close();
/* 255 */         bytes = baos.toByteArray();
/* 256 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 257 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 259 */           _os_.unmarshal_int();
/* 260 */           _os_.unmarshal_int();
/* 261 */           _os_.unmarshal_int();
/*     */         }
/* 263 */         _os_.unmarshal_int();
/* 264 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 267 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 269 */           SFashionDressCfg _v_ = new SFashionDressCfg();
/* 270 */           _v_.unmarshal(_os_);
/* 271 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 272 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 277 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 282 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFashionDressCfg> all)
/*     */   {
/* 289 */     String path = dir + "mzm.gsp.fashiondress.confbean.SFashionDressCfg.bny";
/*     */     try
/*     */     {
/* 292 */       File file = new File(path);
/* 293 */       if (file.exists())
/*     */       {
/* 295 */         byte[] bytes = new byte['Ѐ'];
/* 296 */         FileInputStream fis = new FileInputStream(file);
/* 297 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 298 */         int len = 0;
/* 299 */         while ((len = fis.read(bytes)) > 0)
/* 300 */           baos.write(bytes, 0, len);
/* 301 */         fis.close();
/* 302 */         bytes = baos.toByteArray();
/* 303 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 304 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 306 */           _os_.unmarshal_int();
/* 307 */           _os_.unmarshal_int();
/* 308 */           _os_.unmarshal_int();
/*     */         }
/* 310 */         _os_.unmarshal_int();
/* 311 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 314 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 316 */           SFashionDressCfg _v_ = new SFashionDressCfg();
/* 317 */           _v_.unmarshal(_os_);
/* 318 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 319 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 324 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 329 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SFashionDressCfg getOld(int key)
/*     */   {
/* 337 */     return (SFashionDressCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFashionDressCfg get(int key)
/*     */   {
/* 342 */     return (SFashionDressCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFashionDressCfg> getOldAll()
/*     */   {
/* 347 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFashionDressCfg> getAll()
/*     */   {
/* 352 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFashionDressCfg> newAll)
/*     */   {
/* 357 */     oldAll = all;
/* 358 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 363 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\confbean\SFashionDressCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */