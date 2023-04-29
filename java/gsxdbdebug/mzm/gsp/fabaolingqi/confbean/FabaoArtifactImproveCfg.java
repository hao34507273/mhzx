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
/*     */ public class FabaoArtifactImproveCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, FabaoArtifactImproveCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, FabaoArtifactImproveCfg> all = null;
/*     */   
/*     */   public int id;
/*  19 */   public ArrayList<Integer> propertyTypes = new ArrayList();
/*  20 */   public ArrayList<Integer> improvedValues = new ArrayList();
/*  21 */   public ArrayList<Integer> itemFilterIds = new ArrayList();
/*  22 */   public ArrayList<Integer> itemNums = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  26 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*     */     
/*  28 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "propertyTypes");
/*  29 */     if (collectionElement == null)
/*     */     {
/*  31 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  34 */     List<?> _nodeList = collectionElement.elements();
/*  35 */     int _len = _nodeList.size();
/*  36 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  38 */       Element elem = (Element)_nodeList.get(i);
/*  39 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  46 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  53 */         this.propertyTypes.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  57 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "improvedValues");
/*  58 */     if (collectionElement == null)
/*     */     {
/*  60 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  63 */     List<?> _nodeList = collectionElement.elements();
/*  64 */     int _len = _nodeList.size();
/*  65 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  67 */       Element elem = (Element)_nodeList.get(i);
/*  68 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  75 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  82 */         this.improvedValues.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  86 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "itemFilterIds");
/*  87 */     if (collectionElement == null)
/*     */     {
/*  89 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  92 */     List<?> _nodeList = collectionElement.elements();
/*  93 */     int _len = _nodeList.size();
/*  94 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  96 */       Element elem = (Element)_nodeList.get(i);
/*  97 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 104 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 111 */         this.itemFilterIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 115 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "itemNums");
/* 116 */     if (collectionElement == null)
/*     */     {
/* 118 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 121 */     List<?> _nodeList = collectionElement.elements();
/* 122 */     int _len = _nodeList.size();
/* 123 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 125 */       Element elem = (Element)_nodeList.get(i);
/* 126 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 133 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 140 */         this.itemNums.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 147 */     _os_.marshal(this.id);
/* 148 */     _os_.compact_uint32(this.propertyTypes.size());
/* 149 */     for (Integer _v_ : this.propertyTypes)
/*     */     {
/* 151 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 153 */     _os_.compact_uint32(this.improvedValues.size());
/* 154 */     for (Integer _v_ : this.improvedValues)
/*     */     {
/* 156 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 158 */     _os_.compact_uint32(this.itemFilterIds.size());
/* 159 */     for (Integer _v_ : this.itemFilterIds)
/*     */     {
/* 161 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 163 */     _os_.compact_uint32(this.itemNums.size());
/* 164 */     for (Integer _v_ : this.itemNums)
/*     */     {
/* 166 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 168 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 173 */     this.id = _os_.unmarshal_int();
/* 174 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 177 */       int _v_ = _os_.unmarshal_int();
/* 178 */       this.propertyTypes.add(Integer.valueOf(_v_));
/*     */     }
/* 180 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 183 */       int _v_ = _os_.unmarshal_int();
/* 184 */       this.improvedValues.add(Integer.valueOf(_v_));
/*     */     }
/* 186 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 189 */       int _v_ = _os_.unmarshal_int();
/* 190 */       this.itemFilterIds.add(Integer.valueOf(_v_));
/*     */     }
/* 192 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 195 */       int _v_ = _os_.unmarshal_int();
/* 196 */       this.itemNums.add(Integer.valueOf(_v_));
/*     */     }
/* 198 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 203 */     String path = dir + "mzm.gsp.fabaolingqi.confbean.FabaoArtifactImproveCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 207 */       all = new java.util.HashMap();
/* 208 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 209 */       org.dom4j.Document doc = reader.read(new File(path));
/* 210 */       Element root = doc.getRootElement();
/* 211 */       List<?> nodeList = root.elements();
/* 212 */       int len = nodeList.size();
/* 213 */       for (int i = 0; i < len; i++)
/*     */       {
/* 215 */         Element elem = (Element)nodeList.get(i);
/* 216 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.fabaolingqi.confbean.FabaoArtifactImproveCfg"))
/*     */         {
/*     */ 
/* 219 */           FabaoArtifactImproveCfg obj = new FabaoArtifactImproveCfg();
/* 220 */           obj.loadFromXml(elem);
/* 221 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 222 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 227 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, FabaoArtifactImproveCfg> all)
/*     */   {
/* 233 */     String path = dir + "mzm.gsp.fabaolingqi.confbean.FabaoArtifactImproveCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 237 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 238 */       org.dom4j.Document doc = reader.read(new File(path));
/* 239 */       Element root = doc.getRootElement();
/* 240 */       List<?> nodeList = root.elements();
/* 241 */       int len = nodeList.size();
/* 242 */       for (int i = 0; i < len; i++)
/*     */       {
/* 244 */         Element elem = (Element)nodeList.get(i);
/* 245 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.fabaolingqi.confbean.FabaoArtifactImproveCfg"))
/*     */         {
/*     */ 
/* 248 */           FabaoArtifactImproveCfg obj = new FabaoArtifactImproveCfg();
/* 249 */           obj.loadFromXml(elem);
/* 250 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 251 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 256 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 262 */     all = new java.util.HashMap();
/*     */     
/* 264 */     String path = dir + "mzm.gsp.fabaolingqi.confbean.FabaoArtifactImproveCfg.bny";
/*     */     try
/*     */     {
/* 267 */       File file = new File(path);
/* 268 */       if (file.exists())
/*     */       {
/* 270 */         byte[] bytes = new byte['Ѐ'];
/* 271 */         FileInputStream fis = new FileInputStream(file);
/* 272 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 273 */         int len = 0;
/* 274 */         while ((len = fis.read(bytes)) > 0)
/* 275 */           baos.write(bytes, 0, len);
/* 276 */         fis.close();
/* 277 */         bytes = baos.toByteArray();
/* 278 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 279 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 281 */           _os_.unmarshal_int();
/* 282 */           _os_.unmarshal_int();
/* 283 */           _os_.unmarshal_int();
/*     */         }
/* 285 */         _os_.unmarshal_int();
/* 286 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 289 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 291 */           FabaoArtifactImproveCfg _v_ = new FabaoArtifactImproveCfg();
/* 292 */           _v_.unmarshal(_os_);
/* 293 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 294 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 299 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 304 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, FabaoArtifactImproveCfg> all)
/*     */   {
/* 311 */     String path = dir + "mzm.gsp.fabaolingqi.confbean.FabaoArtifactImproveCfg.bny";
/*     */     try
/*     */     {
/* 314 */       File file = new File(path);
/* 315 */       if (file.exists())
/*     */       {
/* 317 */         byte[] bytes = new byte['Ѐ'];
/* 318 */         FileInputStream fis = new FileInputStream(file);
/* 319 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 320 */         int len = 0;
/* 321 */         while ((len = fis.read(bytes)) > 0)
/* 322 */           baos.write(bytes, 0, len);
/* 323 */         fis.close();
/* 324 */         bytes = baos.toByteArray();
/* 325 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 326 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 328 */           _os_.unmarshal_int();
/* 329 */           _os_.unmarshal_int();
/* 330 */           _os_.unmarshal_int();
/*     */         }
/* 332 */         _os_.unmarshal_int();
/* 333 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 336 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 338 */           FabaoArtifactImproveCfg _v_ = new FabaoArtifactImproveCfg();
/* 339 */           _v_.unmarshal(_os_);
/* 340 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 341 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 346 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 351 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static FabaoArtifactImproveCfg getOld(int key)
/*     */   {
/* 359 */     return (FabaoArtifactImproveCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static FabaoArtifactImproveCfg get(int key)
/*     */   {
/* 364 */     return (FabaoArtifactImproveCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, FabaoArtifactImproveCfg> getOldAll()
/*     */   {
/* 369 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, FabaoArtifactImproveCfg> getAll()
/*     */   {
/* 374 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, FabaoArtifactImproveCfg> newAll)
/*     */   {
/* 379 */     oldAll = all;
/* 380 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 385 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\confbean\FabaoArtifactImproveCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */