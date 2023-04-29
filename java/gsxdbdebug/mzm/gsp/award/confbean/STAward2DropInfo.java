/*     */ package mzm.gsp.award.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class STAward2DropInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STAward2DropInfo> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STAward2DropInfo> all = null;
/*     */   
/*     */   public int id;
/*  19 */   public HashMap<Integer, DropItemIds> awardId2dropInfo = new HashMap();
/*  20 */   public ArrayList<Integer> globalItemIds = new ArrayList();
/*  21 */   public ArrayList<Integer> globalItemDropIds = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*     */     
/*  27 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "awardId2dropInfo");
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
/*  55 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.DropItemIds")))
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
/*     */         DropItemIds _v_;
/*     */         try
/*     */         {
/*  70 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  71 */           _v_ = new DropItemIds();
/*  72 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  79 */         this.awardId2dropInfo.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */     
/*  83 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "globalItemIds");
/*  84 */     if (collectionElement == null)
/*     */     {
/*  86 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  89 */     List<?> _nodeList = collectionElement.elements();
/*  90 */     int _len = _nodeList.size();
/*  91 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  93 */       Element elem = (Element)_nodeList.get(i);
/*  94 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 101 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 108 */         this.globalItemIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/* 112 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "globalItemDropIds");
/* 113 */     if (collectionElement == null)
/*     */     {
/* 115 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/* 118 */     List<?> _nodeList = collectionElement.elements();
/* 119 */     int _len = _nodeList.size();
/* 120 */     for (int i = 0; i < _len; i++)
/*     */     {
/* 122 */       Element elem = (Element)_nodeList.get(i);
/* 123 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 130 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 137 */         this.globalItemDropIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 144 */     _os_.marshal(this.id);
/* 145 */     _os_.compact_uint32(this.awardId2dropInfo.size());
/* 146 */     for (java.util.Map.Entry<Integer, DropItemIds> _e_ : this.awardId2dropInfo.entrySet())
/*     */     {
/* 148 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 149 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 151 */     _os_.compact_uint32(this.globalItemIds.size());
/* 152 */     for (Integer _v_ : this.globalItemIds)
/*     */     {
/* 154 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 156 */     _os_.compact_uint32(this.globalItemDropIds.size());
/* 157 */     for (Integer _v_ : this.globalItemDropIds)
/*     */     {
/* 159 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 161 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 166 */     this.id = _os_.unmarshal_int();
/* 167 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 170 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 172 */       DropItemIds _v_ = new DropItemIds();
/* 173 */       _v_.unmarshal(_os_);
/* 174 */       this.awardId2dropInfo.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 176 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 179 */       int _v_ = _os_.unmarshal_int();
/* 180 */       this.globalItemIds.add(Integer.valueOf(_v_));
/*     */     }
/* 182 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 185 */       int _v_ = _os_.unmarshal_int();
/* 186 */       this.globalItemDropIds.add(Integer.valueOf(_v_));
/*     */     }
/* 188 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 193 */     String path = dir + "mzm.gsp.award.confbean.STAward2DropInfo.xml";
/*     */     
/*     */     try
/*     */     {
/* 197 */       all = new HashMap();
/* 198 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 199 */       org.dom4j.Document doc = reader.read(new File(path));
/* 200 */       Element root = doc.getRootElement();
/* 201 */       List<?> nodeList = root.elements();
/* 202 */       int len = nodeList.size();
/* 203 */       for (int i = 0; i < len; i++)
/*     */       {
/* 205 */         Element elem = (Element)nodeList.get(i);
/* 206 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.STAward2DropInfo"))
/*     */         {
/*     */ 
/* 209 */           STAward2DropInfo obj = new STAward2DropInfo();
/* 210 */           obj.loadFromXml(elem);
/* 211 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 212 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 217 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STAward2DropInfo> all)
/*     */   {
/* 223 */     String path = dir + "mzm.gsp.award.confbean.STAward2DropInfo.xml";
/*     */     
/*     */     try
/*     */     {
/* 227 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 228 */       org.dom4j.Document doc = reader.read(new File(path));
/* 229 */       Element root = doc.getRootElement();
/* 230 */       List<?> nodeList = root.elements();
/* 231 */       int len = nodeList.size();
/* 232 */       for (int i = 0; i < len; i++)
/*     */       {
/* 234 */         Element elem = (Element)nodeList.get(i);
/* 235 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.STAward2DropInfo"))
/*     */         {
/*     */ 
/* 238 */           STAward2DropInfo obj = new STAward2DropInfo();
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
/*     */   public static void loadBny(String dir)
/*     */   {
/* 252 */     all = new HashMap();
/*     */     
/* 254 */     String path = dir + "mzm.gsp.award.confbean.STAward2DropInfo.bny";
/*     */     try
/*     */     {
/* 257 */       File file = new File(path);
/* 258 */       if (file.exists())
/*     */       {
/* 260 */         byte[] bytes = new byte['Ѐ'];
/* 261 */         FileInputStream fis = new FileInputStream(file);
/* 262 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 263 */         int len = 0;
/* 264 */         while ((len = fis.read(bytes)) > 0)
/* 265 */           baos.write(bytes, 0, len);
/* 266 */         fis.close();
/* 267 */         bytes = baos.toByteArray();
/* 268 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 269 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 271 */           _os_.unmarshal_int();
/* 272 */           _os_.unmarshal_int();
/* 273 */           _os_.unmarshal_int();
/*     */         }
/* 275 */         _os_.unmarshal_int();
/* 276 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 279 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 281 */           STAward2DropInfo _v_ = new STAward2DropInfo();
/* 282 */           _v_.unmarshal(_os_);
/* 283 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 284 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 289 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 294 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STAward2DropInfo> all)
/*     */   {
/* 301 */     String path = dir + "mzm.gsp.award.confbean.STAward2DropInfo.bny";
/*     */     try
/*     */     {
/* 304 */       File file = new File(path);
/* 305 */       if (file.exists())
/*     */       {
/* 307 */         byte[] bytes = new byte['Ѐ'];
/* 308 */         FileInputStream fis = new FileInputStream(file);
/* 309 */         java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 310 */         int len = 0;
/* 311 */         while ((len = fis.read(bytes)) > 0)
/* 312 */           baos.write(bytes, 0, len);
/* 313 */         fis.close();
/* 314 */         bytes = baos.toByteArray();
/* 315 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 316 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 318 */           _os_.unmarshal_int();
/* 319 */           _os_.unmarshal_int();
/* 320 */           _os_.unmarshal_int();
/*     */         }
/* 322 */         _os_.unmarshal_int();
/* 323 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 326 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 328 */           STAward2DropInfo _v_ = new STAward2DropInfo();
/* 329 */           _v_.unmarshal(_os_);
/* 330 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 331 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 336 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 341 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STAward2DropInfo getOld(int key)
/*     */   {
/* 349 */     return (STAward2DropInfo)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STAward2DropInfo get(int key)
/*     */   {
/* 354 */     return (STAward2DropInfo)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STAward2DropInfo> getOldAll()
/*     */   {
/* 359 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STAward2DropInfo> getAll()
/*     */   {
/* 364 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STAward2DropInfo> newAll)
/*     */   {
/* 369 */     oldAll = all;
/* 370 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 375 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\STAward2DropInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */