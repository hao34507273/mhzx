/*     */ package mzm.gsp.activity3.confbean;
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
/*     */ public class STAllSurpriseGraph implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STAllSurpriseGraph> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STAllSurpriseGraph> all = null;
/*     */   
/*     */   public int id;
/*  19 */   public HashMap<Integer, Integer> graphId2finishCount = new HashMap();
/*  20 */   public HashMap<Integer, SurpriseGraphIds> type2GraphIds = new HashMap();
/*  21 */   public java.util.HashSet<Integer> needSynGraphIds = new java.util.HashSet();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*     */     
/*  27 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "graphId2finishCount");
/*  28 */     if (mapTypeElement == null)
/*     */     {
/*  30 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  33 */     List<?> entryNodeList = mapTypeElement.elements();
/*  34 */     int entryLen = entryNodeList.size();
/*  35 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  37 */       Element entryElement = (Element)entryNodeList.get(i);
/*  38 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  43 */         Element keyElem = null;
/*  44 */         Element valueElem = null;
/*     */         
/*  46 */         List<?> _nodeList = entryElement.elements();
/*  47 */         int _len = _nodeList.size();
/*  48 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  50 */           Element elem = (Element)_nodeList.get(j);
/*  51 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  53 */             keyElem = elem;
/*     */           }
/*  55 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  57 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  61 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  63 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  70 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  71 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  78 */         this.graphId2finishCount.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  82 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "type2GraphIds");
/*  83 */     if (mapTypeElement == null)
/*     */     {
/*  85 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  88 */     List<?> entryNodeList = mapTypeElement.elements();
/*  89 */     int entryLen = entryNodeList.size();
/*  90 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  92 */       Element entryElement = (Element)entryNodeList.get(i);
/*  93 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  98 */         Element keyElem = null;
/*  99 */         Element valueElem = null;
/*     */         
/* 101 */         List<?> _nodeList = entryElement.elements();
/* 102 */         int _len = _nodeList.size();
/* 103 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 105 */           Element elem = (Element)_nodeList.get(j);
/* 106 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 108 */             keyElem = elem;
/*     */           }
/* 110 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.SurpriseGraphIds")))
/*     */           {
/* 112 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 116 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 118 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         SurpriseGraphIds _v_;
/*     */         try
/*     */         {
/* 125 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 126 */           _v_ = new SurpriseGraphIds();
/* 127 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 134 */         this.type2GraphIds.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */     
/* 138 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "needSynGraphIds");
/* 139 */     if (collectionElement == null)
/*     */     {
/* 141 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 144 */     List<?> _nodeList = collectionElement.elements();
/* 145 */     int _len = _nodeList.size();
/* 146 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 148 */       Element elem = (Element)_nodeList.get(i);
/* 149 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 156 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 163 */         this.needSynGraphIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 170 */     _os_.marshal(this.id);
/* 171 */     _os_.compact_uint32(this.graphId2finishCount.size());
/* 172 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.graphId2finishCount.entrySet())
/*     */     {
/* 174 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 175 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 177 */     _os_.compact_uint32(this.type2GraphIds.size());
/* 178 */     for (java.util.Map.Entry<Integer, SurpriseGraphIds> _e_ : this.type2GraphIds.entrySet())
/*     */     {
/* 180 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 181 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 183 */     _os_.compact_uint32(this.needSynGraphIds.size());
/* 184 */     for (Integer _v_ : this.needSynGraphIds)
/*     */     {
/* 186 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 188 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 193 */     this.id = _os_.unmarshal_int();
/* 194 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 197 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 199 */       int _v_ = _os_.unmarshal_int();
/* 200 */       this.graphId2finishCount.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 202 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 205 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 207 */       SurpriseGraphIds _v_ = new SurpriseGraphIds();
/* 208 */       _v_.unmarshal(_os_);
/* 209 */       this.type2GraphIds.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 211 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 214 */       int _v_ = _os_.unmarshal_int();
/* 215 */       this.needSynGraphIds.add(Integer.valueOf(_v_));
/*     */     }
/* 217 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 222 */     String path = dir + "mzm.gsp.activity3.confbean.STAllSurpriseGraph.xml";
/*     */     
/*     */     try
/*     */     {
/* 226 */       all = new HashMap();
/* 227 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 228 */       org.dom4j.Document doc = reader.read(new File(path));
/* 229 */       Element root = doc.getRootElement();
/* 230 */       List<?> nodeList = root.elements();
/* 231 */       int len = nodeList.size();
/* 232 */       for (int i = 0; i < len; i++)
/*     */       {
/* 234 */         Element elem = (Element)nodeList.get(i);
/* 235 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.STAllSurpriseGraph"))
/*     */         {
/*     */ 
/* 238 */           STAllSurpriseGraph obj = new STAllSurpriseGraph();
/* 239 */           obj.loadFromXml(elem);
/* 240 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 241 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 246 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STAllSurpriseGraph> all)
/*     */   {
/* 252 */     String path = dir + "mzm.gsp.activity3.confbean.STAllSurpriseGraph.xml";
/*     */     
/*     */     try
/*     */     {
/* 256 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 257 */       org.dom4j.Document doc = reader.read(new File(path));
/* 258 */       Element root = doc.getRootElement();
/* 259 */       List<?> nodeList = root.elements();
/* 260 */       int len = nodeList.size();
/* 261 */       for (int i = 0; i < len; i++)
/*     */       {
/* 263 */         Element elem = (Element)nodeList.get(i);
/* 264 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity3.confbean.STAllSurpriseGraph"))
/*     */         {
/*     */ 
/* 267 */           STAllSurpriseGraph obj = new STAllSurpriseGraph();
/* 268 */           obj.loadFromXml(elem);
/* 269 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 270 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 275 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 281 */     all = new HashMap();
/*     */     
/* 283 */     String path = dir + "mzm.gsp.activity3.confbean.STAllSurpriseGraph.bny";
/*     */     try
/*     */     {
/* 286 */       File file = new File(path);
/* 287 */       if (file.exists())
/*     */       {
/* 289 */         byte[] bytes = new byte['Ѐ'];
/* 290 */         FileInputStream fis = new FileInputStream(file);
/* 291 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 292 */         int len = 0;
/* 293 */         while ((len = fis.read(bytes)) > 0)
/* 294 */           baos.write(bytes, 0, len);
/* 295 */         fis.close();
/* 296 */         bytes = baos.toByteArray();
/* 297 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 298 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 300 */           _os_.unmarshal_int();
/* 301 */           _os_.unmarshal_int();
/* 302 */           _os_.unmarshal_int();
/*     */         }
/* 304 */         _os_.unmarshal_int();
/* 305 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 308 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 310 */           STAllSurpriseGraph _v_ = new STAllSurpriseGraph();
/* 311 */           _v_.unmarshal(_os_);
/* 312 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 313 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 318 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 323 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STAllSurpriseGraph> all)
/*     */   {
/* 330 */     String path = dir + "mzm.gsp.activity3.confbean.STAllSurpriseGraph.bny";
/*     */     try
/*     */     {
/* 333 */       File file = new File(path);
/* 334 */       if (file.exists())
/*     */       {
/* 336 */         byte[] bytes = new byte['Ѐ'];
/* 337 */         FileInputStream fis = new FileInputStream(file);
/* 338 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 339 */         int len = 0;
/* 340 */         while ((len = fis.read(bytes)) > 0)
/* 341 */           baos.write(bytes, 0, len);
/* 342 */         fis.close();
/* 343 */         bytes = baos.toByteArray();
/* 344 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 345 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 347 */           _os_.unmarshal_int();
/* 348 */           _os_.unmarshal_int();
/* 349 */           _os_.unmarshal_int();
/*     */         }
/* 351 */         _os_.unmarshal_int();
/* 352 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 355 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 357 */           STAllSurpriseGraph _v_ = new STAllSurpriseGraph();
/* 358 */           _v_.unmarshal(_os_);
/* 359 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 360 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 365 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 370 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STAllSurpriseGraph getOld(int key)
/*     */   {
/* 378 */     return (STAllSurpriseGraph)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STAllSurpriseGraph get(int key)
/*     */   {
/* 383 */     return (STAllSurpriseGraph)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STAllSurpriseGraph> getOldAll()
/*     */   {
/* 388 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STAllSurpriseGraph> getAll()
/*     */   {
/* 393 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STAllSurpriseGraph> newAll)
/*     */   {
/* 398 */     oldAll = all;
/* 399 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 404 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\STAllSurpriseGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */