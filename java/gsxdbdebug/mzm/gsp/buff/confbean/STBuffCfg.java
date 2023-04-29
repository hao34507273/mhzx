/*     */ package mzm.gsp.buff.confbean;
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
/*     */ public class STBuffCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STBuffCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STBuffCfg> all = null;
/*     */   
/*     */   public int buffid;
/*     */   public int bufStateType;
/*     */   public int mapEffect;
/*     */   public int offlineEffect;
/*     */   public int effectType;
/*     */   public int acculumaeCout;
/*     */   public int acculumaeCoutLimit;
/*     */   public int persistTime;
/*     */   public boolean canDelete;
/*  27 */   public java.util.ArrayList<BuffEffect> effectList = new java.util.ArrayList();
/*  28 */   public java.util.LinkedList<Integer> auraBuffList = new java.util.LinkedList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.buffid = Integer.valueOf(rootElement.attributeValue("buffid")).intValue();
/*  33 */     this.bufStateType = Integer.valueOf(rootElement.attributeValue("bufStateType")).intValue();
/*  34 */     this.mapEffect = Integer.valueOf(rootElement.attributeValue("mapEffect")).intValue();
/*  35 */     this.offlineEffect = Integer.valueOf(rootElement.attributeValue("offlineEffect")).intValue();
/*  36 */     this.effectType = Integer.valueOf(rootElement.attributeValue("effectType")).intValue();
/*  37 */     this.acculumaeCout = Integer.valueOf(rootElement.attributeValue("acculumaeCout")).intValue();
/*  38 */     this.acculumaeCoutLimit = Integer.valueOf(rootElement.attributeValue("acculumaeCoutLimit")).intValue();
/*  39 */     this.persistTime = Integer.valueOf(rootElement.attributeValue("persistTime")).intValue();
/*  40 */     this.canDelete = Boolean.valueOf(rootElement.attributeValue("canDelete")).booleanValue();
/*     */     
/*  42 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "effectList");
/*  43 */     if (collectionElement == null)
/*     */     {
/*  45 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  48 */     List<?> _nodeList = collectionElement.elements();
/*  49 */     int _len = _nodeList.size();
/*  50 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  52 */       Element elem = (Element)_nodeList.get(i);
/*  53 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.buff.confbean.BuffEffect"))
/*     */       {
/*     */         BuffEffect _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  60 */           _v_ = new BuffEffect();
/*  61 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  68 */         this.effectList.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  72 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "auraBuffList");
/*  73 */     if (collectionElement == null)
/*     */     {
/*  75 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  78 */     List<?> _nodeList = collectionElement.elements();
/*  79 */     int _len = _nodeList.size();
/*  80 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  82 */       Element elem = (Element)_nodeList.get(i);
/*  83 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  90 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  97 */         this.auraBuffList.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 104 */     _os_.marshal(this.buffid);
/* 105 */     _os_.marshal(this.bufStateType);
/* 106 */     _os_.marshal(this.mapEffect);
/* 107 */     _os_.marshal(this.offlineEffect);
/* 108 */     _os_.marshal(this.effectType);
/* 109 */     _os_.marshal(this.acculumaeCout);
/* 110 */     _os_.marshal(this.acculumaeCoutLimit);
/* 111 */     _os_.marshal(this.persistTime);
/* 112 */     _os_.marshal(this.canDelete);
/* 113 */     _os_.compact_uint32(this.effectList.size());
/* 114 */     for (BuffEffect _v_ : this.effectList)
/*     */     {
/* 116 */       _os_.marshal(_v_);
/*     */     }
/* 118 */     _os_.compact_uint32(this.auraBuffList.size());
/* 119 */     for (Integer _v_ : this.auraBuffList)
/*     */     {
/* 121 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 123 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 128 */     this.buffid = _os_.unmarshal_int();
/* 129 */     this.bufStateType = _os_.unmarshal_int();
/* 130 */     this.mapEffect = _os_.unmarshal_int();
/* 131 */     this.offlineEffect = _os_.unmarshal_int();
/* 132 */     this.effectType = _os_.unmarshal_int();
/* 133 */     this.acculumaeCout = _os_.unmarshal_int();
/* 134 */     this.acculumaeCoutLimit = _os_.unmarshal_int();
/* 135 */     this.persistTime = _os_.unmarshal_int();
/* 136 */     this.canDelete = _os_.unmarshal_boolean();
/* 137 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 140 */       BuffEffect _v_ = new BuffEffect();
/* 141 */       _v_.unmarshal(_os_);
/* 142 */       this.effectList.add(_v_);
/*     */     }
/* 144 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 147 */       int _v_ = _os_.unmarshal_int();
/* 148 */       this.auraBuffList.add(Integer.valueOf(_v_));
/*     */     }
/* 150 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 155 */     String path = dir + "mzm.gsp.buff.confbean.STBuffCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 159 */       all = new java.util.HashMap();
/* 160 */       SAXReader reader = new SAXReader();
/* 161 */       org.dom4j.Document doc = reader.read(new File(path));
/* 162 */       Element root = doc.getRootElement();
/* 163 */       List<?> nodeList = root.elements();
/* 164 */       int len = nodeList.size();
/* 165 */       for (int i = 0; i < len; i++)
/*     */       {
/* 167 */         Element elem = (Element)nodeList.get(i);
/* 168 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.buff.confbean.STBuffCfg"))
/*     */         {
/*     */ 
/* 171 */           STBuffCfg obj = new STBuffCfg();
/* 172 */           obj.loadFromXml(elem);
/* 173 */           if (all.put(Integer.valueOf(obj.buffid), obj) != null) {
/* 174 */             throw new RuntimeException("duplicate key : " + obj.buffid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 179 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STBuffCfg> all)
/*     */   {
/* 185 */     String path = dir + "mzm.gsp.buff.confbean.STBuffCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 189 */       SAXReader reader = new SAXReader();
/* 190 */       org.dom4j.Document doc = reader.read(new File(path));
/* 191 */       Element root = doc.getRootElement();
/* 192 */       List<?> nodeList = root.elements();
/* 193 */       int len = nodeList.size();
/* 194 */       for (int i = 0; i < len; i++)
/*     */       {
/* 196 */         Element elem = (Element)nodeList.get(i);
/* 197 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.buff.confbean.STBuffCfg"))
/*     */         {
/*     */ 
/* 200 */           STBuffCfg obj = new STBuffCfg();
/* 201 */           obj.loadFromXml(elem);
/* 202 */           if (all.put(Integer.valueOf(obj.buffid), obj) != null) {
/* 203 */             throw new RuntimeException("duplicate key : " + obj.buffid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 208 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 214 */     all = new java.util.HashMap();
/*     */     
/* 216 */     String path = dir + "mzm.gsp.buff.confbean.STBuffCfg.bny";
/*     */     try
/*     */     {
/* 219 */       File file = new File(path);
/* 220 */       if (file.exists())
/*     */       {
/* 222 */         byte[] bytes = new byte['Ѐ'];
/* 223 */         FileInputStream fis = new FileInputStream(file);
/* 224 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 225 */         int len = 0;
/* 226 */         while ((len = fis.read(bytes)) > 0)
/* 227 */           baos.write(bytes, 0, len);
/* 228 */         fis.close();
/* 229 */         bytes = baos.toByteArray();
/* 230 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 231 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 233 */           _os_.unmarshal_int();
/* 234 */           _os_.unmarshal_int();
/* 235 */           _os_.unmarshal_int();
/*     */         }
/* 237 */         _os_.unmarshal_int();
/* 238 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 241 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 243 */           STBuffCfg _v_ = new STBuffCfg();
/* 244 */           _v_.unmarshal(_os_);
/* 245 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 246 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 251 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 256 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STBuffCfg> all)
/*     */   {
/* 263 */     String path = dir + "mzm.gsp.buff.confbean.STBuffCfg.bny";
/*     */     try
/*     */     {
/* 266 */       File file = new File(path);
/* 267 */       if (file.exists())
/*     */       {
/* 269 */         byte[] bytes = new byte['Ѐ'];
/* 270 */         FileInputStream fis = new FileInputStream(file);
/* 271 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 272 */         int len = 0;
/* 273 */         while ((len = fis.read(bytes)) > 0)
/* 274 */           baos.write(bytes, 0, len);
/* 275 */         fis.close();
/* 276 */         bytes = baos.toByteArray();
/* 277 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 278 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 280 */           _os_.unmarshal_int();
/* 281 */           _os_.unmarshal_int();
/* 282 */           _os_.unmarshal_int();
/*     */         }
/* 284 */         _os_.unmarshal_int();
/* 285 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 288 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 290 */           STBuffCfg _v_ = new STBuffCfg();
/* 291 */           _v_.unmarshal(_os_);
/* 292 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 293 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 298 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 303 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STBuffCfg getOld(int key)
/*     */   {
/* 311 */     return (STBuffCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STBuffCfg get(int key)
/*     */   {
/* 316 */     return (STBuffCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STBuffCfg> getOldAll()
/*     */   {
/* 321 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STBuffCfg> getAll()
/*     */   {
/* 326 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STBuffCfg> newAll)
/*     */   {
/* 331 */     oldAll = all;
/* 332 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 337 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\confbean\STBuffCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */