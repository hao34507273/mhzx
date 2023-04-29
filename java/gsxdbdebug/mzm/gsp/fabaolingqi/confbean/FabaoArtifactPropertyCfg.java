/*     */ package mzm.gsp.fabaolingqi.confbean;
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
/*     */ public class FabaoArtifactPropertyCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, FabaoArtifactPropertyCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, FabaoArtifactPropertyCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int improveCfgId;
/*  20 */   public ArrayList<Integer> propertyTypes = new ArrayList();
/*  21 */   public ArrayList<Integer> initValues = new ArrayList();
/*  22 */   public ArrayList<Integer> finalValues = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  26 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  27 */     this.improveCfgId = Integer.valueOf(rootElement.attributeValue("improveCfgId")).intValue();
/*     */     
/*  29 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "propertyTypes");
/*  30 */     if (collectionElement == null)
/*     */     {
/*  32 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  35 */     List<?> _nodeList = collectionElement.elements();
/*  36 */     int _len = _nodeList.size();
/*  37 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  39 */       Element elem = (Element)_nodeList.get(i);
/*  40 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  47 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  54 */         this.propertyTypes.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  58 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "initValues");
/*  59 */     if (collectionElement == null)
/*     */     {
/*  61 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  64 */     List<?> _nodeList = collectionElement.elements();
/*  65 */     int _len = _nodeList.size();
/*  66 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  68 */       Element elem = (Element)_nodeList.get(i);
/*  69 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  76 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  83 */         this.initValues.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  87 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "finalValues");
/*  88 */     if (collectionElement == null)
/*     */     {
/*  90 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  93 */     List<?> _nodeList = collectionElement.elements();
/*  94 */     int _len = _nodeList.size();
/*  95 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  97 */       Element elem = (Element)_nodeList.get(i);
/*  98 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 105 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 112 */         this.finalValues.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 119 */     _os_.marshal(this.id);
/* 120 */     _os_.marshal(this.improveCfgId);
/* 121 */     _os_.compact_uint32(this.propertyTypes.size());
/* 122 */     for (Integer _v_ : this.propertyTypes)
/*     */     {
/* 124 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 126 */     _os_.compact_uint32(this.initValues.size());
/* 127 */     for (Integer _v_ : this.initValues)
/*     */     {
/* 129 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 131 */     _os_.compact_uint32(this.finalValues.size());
/* 132 */     for (Integer _v_ : this.finalValues)
/*     */     {
/* 134 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 136 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 141 */     this.id = _os_.unmarshal_int();
/* 142 */     this.improveCfgId = _os_.unmarshal_int();
/* 143 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 146 */       int _v_ = _os_.unmarshal_int();
/* 147 */       this.propertyTypes.add(Integer.valueOf(_v_));
/*     */     }
/* 149 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 152 */       int _v_ = _os_.unmarshal_int();
/* 153 */       this.initValues.add(Integer.valueOf(_v_));
/*     */     }
/* 155 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 158 */       int _v_ = _os_.unmarshal_int();
/* 159 */       this.finalValues.add(Integer.valueOf(_v_));
/*     */     }
/* 161 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 166 */     String path = dir + "mzm.gsp.fabaolingqi.confbean.FabaoArtifactPropertyCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 170 */       all = new java.util.HashMap();
/* 171 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 172 */       org.dom4j.Document doc = reader.read(new File(path));
/* 173 */       Element root = doc.getRootElement();
/* 174 */       List<?> nodeList = root.elements();
/* 175 */       int len = nodeList.size();
/* 176 */       for (int i = 0; i < len; i++)
/*     */       {
/* 178 */         Element elem = (Element)nodeList.get(i);
/* 179 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.fabaolingqi.confbean.FabaoArtifactPropertyCfg"))
/*     */         {
/*     */ 
/* 182 */           FabaoArtifactPropertyCfg obj = new FabaoArtifactPropertyCfg();
/* 183 */           obj.loadFromXml(elem);
/* 184 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 185 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 190 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, FabaoArtifactPropertyCfg> all)
/*     */   {
/* 196 */     String path = dir + "mzm.gsp.fabaolingqi.confbean.FabaoArtifactPropertyCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 200 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 201 */       org.dom4j.Document doc = reader.read(new File(path));
/* 202 */       Element root = doc.getRootElement();
/* 203 */       List<?> nodeList = root.elements();
/* 204 */       int len = nodeList.size();
/* 205 */       for (int i = 0; i < len; i++)
/*     */       {
/* 207 */         Element elem = (Element)nodeList.get(i);
/* 208 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.fabaolingqi.confbean.FabaoArtifactPropertyCfg"))
/*     */         {
/*     */ 
/* 211 */           FabaoArtifactPropertyCfg obj = new FabaoArtifactPropertyCfg();
/* 212 */           obj.loadFromXml(elem);
/* 213 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 214 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 219 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 225 */     all = new java.util.HashMap();
/*     */     
/* 227 */     String path = dir + "mzm.gsp.fabaolingqi.confbean.FabaoArtifactPropertyCfg.bny";
/*     */     try
/*     */     {
/* 230 */       File file = new File(path);
/* 231 */       if (file.exists())
/*     */       {
/* 233 */         byte[] bytes = new byte['Ѐ'];
/* 234 */         FileInputStream fis = new FileInputStream(file);
/* 235 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 236 */         int len = 0;
/* 237 */         while ((len = fis.read(bytes)) > 0)
/* 238 */           baos.write(bytes, 0, len);
/* 239 */         fis.close();
/* 240 */         bytes = baos.toByteArray();
/* 241 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 242 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 244 */           _os_.unmarshal_int();
/* 245 */           _os_.unmarshal_int();
/* 246 */           _os_.unmarshal_int();
/*     */         }
/* 248 */         _os_.unmarshal_int();
/* 249 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 252 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 254 */           FabaoArtifactPropertyCfg _v_ = new FabaoArtifactPropertyCfg();
/* 255 */           _v_.unmarshal(_os_);
/* 256 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 257 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 262 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 267 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, FabaoArtifactPropertyCfg> all)
/*     */   {
/* 274 */     String path = dir + "mzm.gsp.fabaolingqi.confbean.FabaoArtifactPropertyCfg.bny";
/*     */     try
/*     */     {
/* 277 */       File file = new File(path);
/* 278 */       if (file.exists())
/*     */       {
/* 280 */         byte[] bytes = new byte['Ѐ'];
/* 281 */         FileInputStream fis = new FileInputStream(file);
/* 282 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 283 */         int len = 0;
/* 284 */         while ((len = fis.read(bytes)) > 0)
/* 285 */           baos.write(bytes, 0, len);
/* 286 */         fis.close();
/* 287 */         bytes = baos.toByteArray();
/* 288 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 289 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 291 */           _os_.unmarshal_int();
/* 292 */           _os_.unmarshal_int();
/* 293 */           _os_.unmarshal_int();
/*     */         }
/* 295 */         _os_.unmarshal_int();
/* 296 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 299 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 301 */           FabaoArtifactPropertyCfg _v_ = new FabaoArtifactPropertyCfg();
/* 302 */           _v_.unmarshal(_os_);
/* 303 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 304 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 309 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 314 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static FabaoArtifactPropertyCfg getOld(int key)
/*     */   {
/* 322 */     return (FabaoArtifactPropertyCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static FabaoArtifactPropertyCfg get(int key)
/*     */   {
/* 327 */     return (FabaoArtifactPropertyCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, FabaoArtifactPropertyCfg> getOldAll()
/*     */   {
/* 332 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, FabaoArtifactPropertyCfg> getAll()
/*     */   {
/* 337 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, FabaoArtifactPropertyCfg> newAll)
/*     */   {
/* 342 */     oldAll = all;
/* 343 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 348 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\confbean\FabaoArtifactPropertyCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */