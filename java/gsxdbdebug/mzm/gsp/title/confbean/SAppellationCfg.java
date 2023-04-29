/*     */ package mzm.gsp.title.confbean;
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
/*     */ public class SAppellationCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SAppellationCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SAppellationCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templateName;
/*     */   public int bigAppellation;
/*     */   public int diyAppType;
/*     */   public String appellationName;
/*     */   public int appellationOutTime;
/*     */   public int appellationLimit;
/*     */   public int occupation;
/*  26 */   public java.util.ArrayList<Property2value> property2valueList = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  30 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  31 */     this.templateName = rootElement.attributeValue("templateName");
/*  32 */     this.bigAppellation = Integer.valueOf(rootElement.attributeValue("bigAppellation")).intValue();
/*  33 */     this.diyAppType = Integer.valueOf(rootElement.attributeValue("diyAppType")).intValue();
/*  34 */     this.appellationName = rootElement.attributeValue("appellationName");
/*  35 */     this.appellationOutTime = Integer.valueOf(rootElement.attributeValue("appellationOutTime")).intValue();
/*  36 */     this.appellationLimit = Integer.valueOf(rootElement.attributeValue("appellationLimit")).intValue();
/*  37 */     this.occupation = Integer.valueOf(rootElement.attributeValue("occupation")).intValue();
/*     */     
/*  39 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "property2valueList");
/*  40 */     if (collectionElement == null)
/*     */     {
/*  42 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  45 */     List<?> _nodeList = collectionElement.elements();
/*  46 */     int _len = _nodeList.size();
/*  47 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  49 */       Element elem = (Element)_nodeList.get(i);
/*  50 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.title.confbean.Property2value"))
/*     */       {
/*     */         Property2value _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  57 */           _v_ = new Property2value();
/*  58 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  65 */         this.property2valueList.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _os_.marshal(this.id);
/*  73 */     _os_.marshal(this.templateName, "UTF-8");
/*  74 */     _os_.marshal(this.bigAppellation);
/*  75 */     _os_.marshal(this.diyAppType);
/*  76 */     _os_.marshal(this.appellationName, "UTF-8");
/*  77 */     _os_.marshal(this.appellationOutTime);
/*  78 */     _os_.marshal(this.appellationLimit);
/*  79 */     _os_.marshal(this.occupation);
/*  80 */     _os_.compact_uint32(this.property2valueList.size());
/*  81 */     for (Property2value _v_ : this.property2valueList)
/*     */     {
/*  83 */       _os_.marshal(_v_);
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  90 */     this.id = _os_.unmarshal_int();
/*  91 */     this.templateName = _os_.unmarshal_String("UTF-8");
/*  92 */     this.bigAppellation = _os_.unmarshal_int();
/*  93 */     this.diyAppType = _os_.unmarshal_int();
/*  94 */     this.appellationName = _os_.unmarshal_String("UTF-8");
/*  95 */     this.appellationOutTime = _os_.unmarshal_int();
/*  96 */     this.appellationLimit = _os_.unmarshal_int();
/*  97 */     this.occupation = _os_.unmarshal_int();
/*  98 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 101 */       Property2value _v_ = new Property2value();
/* 102 */       _v_.unmarshal(_os_);
/* 103 */       this.property2valueList.add(_v_);
/*     */     }
/* 105 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 110 */     String path = dir + "mzm.gsp.title.confbean.SAppellationCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 114 */       all = new java.util.HashMap();
/* 115 */       SAXReader reader = new SAXReader();
/* 116 */       org.dom4j.Document doc = reader.read(new File(path));
/* 117 */       Element root = doc.getRootElement();
/* 118 */       List<?> nodeList = root.elements();
/* 119 */       int len = nodeList.size();
/* 120 */       for (int i = 0; i < len; i++)
/*     */       {
/* 122 */         Element elem = (Element)nodeList.get(i);
/* 123 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.title.confbean.SAppellationCfg"))
/*     */         {
/*     */ 
/* 126 */           SAppellationCfg obj = new SAppellationCfg();
/* 127 */           obj.loadFromXml(elem);
/* 128 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 129 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 134 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SAppellationCfg> all)
/*     */   {
/* 140 */     String path = dir + "mzm.gsp.title.confbean.SAppellationCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 144 */       SAXReader reader = new SAXReader();
/* 145 */       org.dom4j.Document doc = reader.read(new File(path));
/* 146 */       Element root = doc.getRootElement();
/* 147 */       List<?> nodeList = root.elements();
/* 148 */       int len = nodeList.size();
/* 149 */       for (int i = 0; i < len; i++)
/*     */       {
/* 151 */         Element elem = (Element)nodeList.get(i);
/* 152 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.title.confbean.SAppellationCfg"))
/*     */         {
/*     */ 
/* 155 */           SAppellationCfg obj = new SAppellationCfg();
/* 156 */           obj.loadFromXml(elem);
/* 157 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 158 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 163 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 169 */     all = new java.util.HashMap();
/*     */     
/* 171 */     String path = dir + "mzm.gsp.title.confbean.SAppellationCfg.bny";
/*     */     try
/*     */     {
/* 174 */       File file = new File(path);
/* 175 */       if (file.exists())
/*     */       {
/* 177 */         byte[] bytes = new byte['Ѐ'];
/* 178 */         FileInputStream fis = new FileInputStream(file);
/* 179 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 180 */         int len = 0;
/* 181 */         while ((len = fis.read(bytes)) > 0)
/* 182 */           baos.write(bytes, 0, len);
/* 183 */         fis.close();
/* 184 */         bytes = baos.toByteArray();
/* 185 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 186 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 188 */           _os_.unmarshal_int();
/* 189 */           _os_.unmarshal_int();
/* 190 */           _os_.unmarshal_int();
/*     */         }
/* 192 */         _os_.unmarshal_int();
/* 193 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 196 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 198 */           SAppellationCfg _v_ = new SAppellationCfg();
/* 199 */           _v_.unmarshal(_os_);
/* 200 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 201 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 206 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 211 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SAppellationCfg> all)
/*     */   {
/* 218 */     String path = dir + "mzm.gsp.title.confbean.SAppellationCfg.bny";
/*     */     try
/*     */     {
/* 221 */       File file = new File(path);
/* 222 */       if (file.exists())
/*     */       {
/* 224 */         byte[] bytes = new byte['Ѐ'];
/* 225 */         FileInputStream fis = new FileInputStream(file);
/* 226 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 227 */         int len = 0;
/* 228 */         while ((len = fis.read(bytes)) > 0)
/* 229 */           baos.write(bytes, 0, len);
/* 230 */         fis.close();
/* 231 */         bytes = baos.toByteArray();
/* 232 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 233 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 235 */           _os_.unmarshal_int();
/* 236 */           _os_.unmarshal_int();
/* 237 */           _os_.unmarshal_int();
/*     */         }
/* 239 */         _os_.unmarshal_int();
/* 240 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 243 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 245 */           SAppellationCfg _v_ = new SAppellationCfg();
/* 246 */           _v_.unmarshal(_os_);
/* 247 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 248 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 253 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 258 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SAppellationCfg getOld(int key)
/*     */   {
/* 266 */     return (SAppellationCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SAppellationCfg get(int key)
/*     */   {
/* 271 */     return (SAppellationCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAppellationCfg> getOldAll()
/*     */   {
/* 276 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAppellationCfg> getAll()
/*     */   {
/* 281 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SAppellationCfg> newAll)
/*     */   {
/* 286 */     oldAll = all;
/* 287 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 292 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\confbean\SAppellationCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */