/*     */ package mzm.gsp.superequipment.wushi.confbean;
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
/*     */ public class WuShiCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, WuShiCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, WuShiCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String name;
/*     */   public int icon;
/*     */   public int wuShiLevel;
/*     */   public String source;
/*     */   public int typeId;
/*     */   public int appearanceTypeId;
/*     */   public int nextLevelId;
/*     */   public int isShow;
/*     */   public int fragmentItemId;
/*     */   public int fragmentCount;
/*  29 */   public ArrayList<Integer> properTypes = new ArrayList();
/*  30 */   public ArrayList<Integer> propertyValues = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  34 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  35 */     this.name = rootElement.attributeValue("name");
/*  36 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  37 */     this.wuShiLevel = Integer.valueOf(rootElement.attributeValue("wuShiLevel")).intValue();
/*  38 */     this.source = rootElement.attributeValue("source");
/*  39 */     this.typeId = Integer.valueOf(rootElement.attributeValue("typeId")).intValue();
/*  40 */     this.appearanceTypeId = Integer.valueOf(rootElement.attributeValue("appearanceTypeId")).intValue();
/*  41 */     this.nextLevelId = Integer.valueOf(rootElement.attributeValue("nextLevelId")).intValue();
/*  42 */     this.isShow = Integer.valueOf(rootElement.attributeValue("isShow")).intValue();
/*  43 */     this.fragmentItemId = Integer.valueOf(rootElement.attributeValue("fragmentItemId")).intValue();
/*  44 */     this.fragmentCount = Integer.valueOf(rootElement.attributeValue("fragmentCount")).intValue();
/*     */     
/*  46 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "properTypes");
/*  47 */     if (collectionElement == null)
/*     */     {
/*  49 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  52 */     List<?> _nodeList = collectionElement.elements();
/*  53 */     int _len = _nodeList.size();
/*  54 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  56 */       Element elem = (Element)_nodeList.get(i);
/*  57 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  64 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  71 */         this.properTypes.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  75 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "propertyValues");
/*  76 */     if (collectionElement == null)
/*     */     {
/*  78 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  81 */     List<?> _nodeList = collectionElement.elements();
/*  82 */     int _len = _nodeList.size();
/*  83 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  85 */       Element elem = (Element)_nodeList.get(i);
/*  86 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  93 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 100 */         this.propertyValues.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 107 */     _os_.marshal(this.id);
/* 108 */     _os_.marshal(this.name, "UTF-8");
/* 109 */     _os_.marshal(this.icon);
/* 110 */     _os_.marshal(this.wuShiLevel);
/* 111 */     _os_.marshal(this.source, "UTF-8");
/* 112 */     _os_.marshal(this.typeId);
/* 113 */     _os_.marshal(this.appearanceTypeId);
/* 114 */     _os_.marshal(this.nextLevelId);
/* 115 */     _os_.marshal(this.isShow);
/* 116 */     _os_.marshal(this.fragmentItemId);
/* 117 */     _os_.marshal(this.fragmentCount);
/* 118 */     _os_.compact_uint32(this.properTypes.size());
/* 119 */     for (Integer _v_ : this.properTypes)
/*     */     {
/* 121 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 123 */     _os_.compact_uint32(this.propertyValues.size());
/* 124 */     for (Integer _v_ : this.propertyValues)
/*     */     {
/* 126 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 128 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 133 */     this.id = _os_.unmarshal_int();
/* 134 */     this.name = _os_.unmarshal_String("UTF-8");
/* 135 */     this.icon = _os_.unmarshal_int();
/* 136 */     this.wuShiLevel = _os_.unmarshal_int();
/* 137 */     this.source = _os_.unmarshal_String("UTF-8");
/* 138 */     this.typeId = _os_.unmarshal_int();
/* 139 */     this.appearanceTypeId = _os_.unmarshal_int();
/* 140 */     this.nextLevelId = _os_.unmarshal_int();
/* 141 */     this.isShow = _os_.unmarshal_int();
/* 142 */     this.fragmentItemId = _os_.unmarshal_int();
/* 143 */     this.fragmentCount = _os_.unmarshal_int();
/* 144 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 147 */       int _v_ = _os_.unmarshal_int();
/* 148 */       this.properTypes.add(Integer.valueOf(_v_));
/*     */     }
/* 150 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 153 */       int _v_ = _os_.unmarshal_int();
/* 154 */       this.propertyValues.add(Integer.valueOf(_v_));
/*     */     }
/* 156 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 161 */     String path = dir + "mzm.gsp.superequipment.wushi.confbean.WuShiCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 165 */       all = new java.util.HashMap();
/* 166 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 167 */       org.dom4j.Document doc = reader.read(new File(path));
/* 168 */       Element root = doc.getRootElement();
/* 169 */       List<?> nodeList = root.elements();
/* 170 */       int len = nodeList.size();
/* 171 */       for (int i = 0; i < len; i++)
/*     */       {
/* 173 */         Element elem = (Element)nodeList.get(i);
/* 174 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.wushi.confbean.WuShiCfg"))
/*     */         {
/*     */ 
/* 177 */           WuShiCfg obj = new WuShiCfg();
/* 178 */           obj.loadFromXml(elem);
/* 179 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 180 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 185 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, WuShiCfg> all)
/*     */   {
/* 191 */     String path = dir + "mzm.gsp.superequipment.wushi.confbean.WuShiCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 195 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 196 */       org.dom4j.Document doc = reader.read(new File(path));
/* 197 */       Element root = doc.getRootElement();
/* 198 */       List<?> nodeList = root.elements();
/* 199 */       int len = nodeList.size();
/* 200 */       for (int i = 0; i < len; i++)
/*     */       {
/* 202 */         Element elem = (Element)nodeList.get(i);
/* 203 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.wushi.confbean.WuShiCfg"))
/*     */         {
/*     */ 
/* 206 */           WuShiCfg obj = new WuShiCfg();
/* 207 */           obj.loadFromXml(elem);
/* 208 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 209 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 214 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 220 */     all = new java.util.HashMap();
/*     */     
/* 222 */     String path = dir + "mzm.gsp.superequipment.wushi.confbean.WuShiCfg.bny";
/*     */     try
/*     */     {
/* 225 */       File file = new File(path);
/* 226 */       if (file.exists())
/*     */       {
/* 228 */         byte[] bytes = new byte['Ѐ'];
/* 229 */         FileInputStream fis = new FileInputStream(file);
/* 230 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 231 */         int len = 0;
/* 232 */         while ((len = fis.read(bytes)) > 0)
/* 233 */           baos.write(bytes, 0, len);
/* 234 */         fis.close();
/* 235 */         bytes = baos.toByteArray();
/* 236 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 237 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 239 */           _os_.unmarshal_int();
/* 240 */           _os_.unmarshal_int();
/* 241 */           _os_.unmarshal_int();
/*     */         }
/* 243 */         _os_.unmarshal_int();
/* 244 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 247 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 249 */           WuShiCfg _v_ = new WuShiCfg();
/* 250 */           _v_.unmarshal(_os_);
/* 251 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 252 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 257 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 262 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, WuShiCfg> all)
/*     */   {
/* 269 */     String path = dir + "mzm.gsp.superequipment.wushi.confbean.WuShiCfg.bny";
/*     */     try
/*     */     {
/* 272 */       File file = new File(path);
/* 273 */       if (file.exists())
/*     */       {
/* 275 */         byte[] bytes = new byte['Ѐ'];
/* 276 */         FileInputStream fis = new FileInputStream(file);
/* 277 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 278 */         int len = 0;
/* 279 */         while ((len = fis.read(bytes)) > 0)
/* 280 */           baos.write(bytes, 0, len);
/* 281 */         fis.close();
/* 282 */         bytes = baos.toByteArray();
/* 283 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 284 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 286 */           _os_.unmarshal_int();
/* 287 */           _os_.unmarshal_int();
/* 288 */           _os_.unmarshal_int();
/*     */         }
/* 290 */         _os_.unmarshal_int();
/* 291 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 294 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 296 */           WuShiCfg _v_ = new WuShiCfg();
/* 297 */           _v_.unmarshal(_os_);
/* 298 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 299 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 304 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 309 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static WuShiCfg getOld(int key)
/*     */   {
/* 317 */     return (WuShiCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static WuShiCfg get(int key)
/*     */   {
/* 322 */     return (WuShiCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, WuShiCfg> getOldAll()
/*     */   {
/* 327 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, WuShiCfg> getAll()
/*     */   {
/* 332 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, WuShiCfg> newAll)
/*     */   {
/* 337 */     oldAll = all;
/* 338 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 343 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\confbean\WuShiCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */