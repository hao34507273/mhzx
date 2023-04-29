/*     */ package mzm.gsp.item.confbean;
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
/*     */ public class SQiLinAccumulateModeCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SQiLinAccumulateModeCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SQiLinAccumulateModeCfg> all = null;
/*     */   
/*     */   public int strengthLevel;
/*     */   public int id;
/*     */   public int initScore;
/*     */   public int needScore;
/*  22 */   public HashMap<Integer, Integer> itemid2MaxNum = new HashMap();
/*  23 */   public HashMap<Integer, Integer> itemid2Point = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.strengthLevel = Integer.valueOf(rootElement.attributeValue("strengthLevel")).intValue();
/*  28 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  29 */     this.initScore = Integer.valueOf(rootElement.attributeValue("initScore")).intValue();
/*  30 */     this.needScore = Integer.valueOf(rootElement.attributeValue("needScore")).intValue();
/*     */     
/*  32 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "itemid2MaxNum");
/*  33 */     if (mapTypeElement == null)
/*     */     {
/*  35 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  38 */     List<?> entryNodeList = mapTypeElement.elements();
/*  39 */     int entryLen = entryNodeList.size();
/*  40 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  42 */       Element entryElement = (Element)entryNodeList.get(i);
/*  43 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  48 */         Element keyElem = null;
/*  49 */         Element valueElem = null;
/*     */         
/*  51 */         List<?> _nodeList = entryElement.elements();
/*  52 */         int _len = _nodeList.size();
/*  53 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  55 */           Element elem = (Element)_nodeList.get(j);
/*  56 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  58 */             keyElem = elem;
/*     */           }
/*  60 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  62 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  66 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  68 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  75 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  76 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  83 */         this.itemid2MaxNum.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  87 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "itemid2Point");
/*  88 */     if (mapTypeElement == null)
/*     */     {
/*  90 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  93 */     List<?> entryNodeList = mapTypeElement.elements();
/*  94 */     int entryLen = entryNodeList.size();
/*  95 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  97 */       Element entryElement = (Element)entryNodeList.get(i);
/*  98 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 103 */         Element keyElem = null;
/* 104 */         Element valueElem = null;
/*     */         
/* 106 */         List<?> _nodeList = entryElement.elements();
/* 107 */         int _len = _nodeList.size();
/* 108 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 110 */           Element elem = (Element)_nodeList.get(j);
/* 111 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 113 */             keyElem = elem;
/*     */           }
/* 115 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 117 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 121 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 123 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 130 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 131 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 138 */         this.itemid2Point.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 145 */     _os_.marshal(this.strengthLevel);
/* 146 */     _os_.marshal(this.id);
/* 147 */     _os_.marshal(this.initScore);
/* 148 */     _os_.marshal(this.needScore);
/* 149 */     _os_.compact_uint32(this.itemid2MaxNum.size());
/* 150 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.itemid2MaxNum.entrySet())
/*     */     {
/* 152 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 153 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 155 */     _os_.compact_uint32(this.itemid2Point.size());
/* 156 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.itemid2Point.entrySet())
/*     */     {
/* 158 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 159 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 161 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 166 */     this.strengthLevel = _os_.unmarshal_int();
/* 167 */     this.id = _os_.unmarshal_int();
/* 168 */     this.initScore = _os_.unmarshal_int();
/* 169 */     this.needScore = _os_.unmarshal_int();
/* 170 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 173 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 175 */       int _v_ = _os_.unmarshal_int();
/* 176 */       this.itemid2MaxNum.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 178 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 181 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 183 */       int _v_ = _os_.unmarshal_int();
/* 184 */       this.itemid2Point.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 186 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 191 */     String path = dir + "mzm.gsp.item.confbean.SQiLinAccumulateModeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 195 */       all = new HashMap();
/* 196 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 197 */       org.dom4j.Document doc = reader.read(new File(path));
/* 198 */       Element root = doc.getRootElement();
/* 199 */       List<?> nodeList = root.elements();
/* 200 */       int len = nodeList.size();
/* 201 */       for (int i = 0; i < len; i++)
/*     */       {
/* 203 */         Element elem = (Element)nodeList.get(i);
/* 204 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SQiLinAccumulateModeCfg"))
/*     */         {
/*     */ 
/* 207 */           SQiLinAccumulateModeCfg obj = new SQiLinAccumulateModeCfg();
/* 208 */           obj.loadFromXml(elem);
/* 209 */           if (all.put(Integer.valueOf(obj.strengthLevel), obj) != null) {
/* 210 */             throw new RuntimeException("duplicate key : " + obj.strengthLevel);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 215 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SQiLinAccumulateModeCfg> all)
/*     */   {
/* 221 */     String path = dir + "mzm.gsp.item.confbean.SQiLinAccumulateModeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 225 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 226 */       org.dom4j.Document doc = reader.read(new File(path));
/* 227 */       Element root = doc.getRootElement();
/* 228 */       List<?> nodeList = root.elements();
/* 229 */       int len = nodeList.size();
/* 230 */       for (int i = 0; i < len; i++)
/*     */       {
/* 232 */         Element elem = (Element)nodeList.get(i);
/* 233 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SQiLinAccumulateModeCfg"))
/*     */         {
/*     */ 
/* 236 */           SQiLinAccumulateModeCfg obj = new SQiLinAccumulateModeCfg();
/* 237 */           obj.loadFromXml(elem);
/* 238 */           if (all.put(Integer.valueOf(obj.strengthLevel), obj) != null) {
/* 239 */             throw new RuntimeException("duplicate key : " + obj.strengthLevel);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 244 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 250 */     all = new HashMap();
/*     */     
/* 252 */     String path = dir + "mzm.gsp.item.confbean.SQiLinAccumulateModeCfg.bny";
/*     */     try
/*     */     {
/* 255 */       File file = new File(path);
/* 256 */       if (file.exists())
/*     */       {
/* 258 */         byte[] bytes = new byte['Ѐ'];
/* 259 */         FileInputStream fis = new FileInputStream(file);
/* 260 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 261 */         int len = 0;
/* 262 */         while ((len = fis.read(bytes)) > 0)
/* 263 */           baos.write(bytes, 0, len);
/* 264 */         fis.close();
/* 265 */         bytes = baos.toByteArray();
/* 266 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 267 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 269 */           _os_.unmarshal_int();
/* 270 */           _os_.unmarshal_int();
/* 271 */           _os_.unmarshal_int();
/*     */         }
/* 273 */         _os_.unmarshal_int();
/* 274 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 277 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 279 */           SQiLinAccumulateModeCfg _v_ = new SQiLinAccumulateModeCfg();
/* 280 */           _v_.unmarshal(_os_);
/* 281 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 282 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 287 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 292 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SQiLinAccumulateModeCfg> all)
/*     */   {
/* 299 */     String path = dir + "mzm.gsp.item.confbean.SQiLinAccumulateModeCfg.bny";
/*     */     try
/*     */     {
/* 302 */       File file = new File(path);
/* 303 */       if (file.exists())
/*     */       {
/* 305 */         byte[] bytes = new byte['Ѐ'];
/* 306 */         FileInputStream fis = new FileInputStream(file);
/* 307 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 308 */         int len = 0;
/* 309 */         while ((len = fis.read(bytes)) > 0)
/* 310 */           baos.write(bytes, 0, len);
/* 311 */         fis.close();
/* 312 */         bytes = baos.toByteArray();
/* 313 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 314 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 316 */           _os_.unmarshal_int();
/* 317 */           _os_.unmarshal_int();
/* 318 */           _os_.unmarshal_int();
/*     */         }
/* 320 */         _os_.unmarshal_int();
/* 321 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 324 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 326 */           SQiLinAccumulateModeCfg _v_ = new SQiLinAccumulateModeCfg();
/* 327 */           _v_.unmarshal(_os_);
/* 328 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 329 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 334 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 339 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SQiLinAccumulateModeCfg getOld(int key)
/*     */   {
/* 347 */     return (SQiLinAccumulateModeCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SQiLinAccumulateModeCfg get(int key)
/*     */   {
/* 352 */     return (SQiLinAccumulateModeCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SQiLinAccumulateModeCfg> getOldAll()
/*     */   {
/* 357 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SQiLinAccumulateModeCfg> getAll()
/*     */   {
/* 362 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SQiLinAccumulateModeCfg> newAll)
/*     */   {
/* 367 */     oldAll = all;
/* 368 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 373 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SQiLinAccumulateModeCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */