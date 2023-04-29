/*     */ package mzm.gsp.superequipment.wushi.confbean;
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
/*     */ public class SWuShiAccumulateFragmentCountInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SWuShiAccumulateFragmentCountInfo> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SWuShiAccumulateFragmentCountInfo> all = null;
/*     */   
/*     */   public int typeId;
/*  19 */   public java.util.TreeMap<Integer, Integer> accumulateFragCount2cfgIdMap = new java.util.TreeMap();
/*  20 */   public HashMap<Integer, Integer> cfgId2accumulateFragCountMap = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.typeId = Integer.valueOf(rootElement.attributeValue("typeId")).intValue();
/*     */     
/*  26 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "accumulateFragCount2cfgIdMap");
/*  27 */     if (mapTypeElement == null)
/*     */     {
/*  29 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  32 */     List<?> entryNodeList = mapTypeElement.elements();
/*  33 */     int entryLen = entryNodeList.size();
/*  34 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  36 */       Element entryElement = (Element)entryNodeList.get(i);
/*  37 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  42 */         Element keyElem = null;
/*  43 */         Element valueElem = null;
/*     */         
/*  45 */         List<?> _nodeList = entryElement.elements();
/*  46 */         int _len = _nodeList.size();
/*  47 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  49 */           Element elem = (Element)_nodeList.get(j);
/*  50 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  52 */             keyElem = elem;
/*     */           }
/*  54 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  56 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  60 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  62 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  69 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  70 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  77 */         this.accumulateFragCount2cfgIdMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  81 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "cfgId2accumulateFragCountMap");
/*  82 */     if (mapTypeElement == null)
/*     */     {
/*  84 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  87 */     List<?> entryNodeList = mapTypeElement.elements();
/*  88 */     int entryLen = entryNodeList.size();
/*  89 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  91 */       Element entryElement = (Element)entryNodeList.get(i);
/*  92 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  97 */         Element keyElem = null;
/*  98 */         Element valueElem = null;
/*     */         
/* 100 */         List<?> _nodeList = entryElement.elements();
/* 101 */         int _len = _nodeList.size();
/* 102 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 104 */           Element elem = (Element)_nodeList.get(j);
/* 105 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 107 */             keyElem = elem;
/*     */           }
/* 109 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 111 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 115 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 117 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 124 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 125 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 132 */         this.cfgId2accumulateFragCountMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 139 */     _os_.marshal(this.typeId);
/* 140 */     _os_.compact_uint32(this.accumulateFragCount2cfgIdMap.size());
/* 141 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.accumulateFragCount2cfgIdMap.entrySet())
/*     */     {
/* 143 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 144 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 146 */     _os_.compact_uint32(this.cfgId2accumulateFragCountMap.size());
/* 147 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.cfgId2accumulateFragCountMap.entrySet())
/*     */     {
/* 149 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 150 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 152 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 157 */     this.typeId = _os_.unmarshal_int();
/* 158 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 161 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 163 */       int _v_ = _os_.unmarshal_int();
/* 164 */       this.accumulateFragCount2cfgIdMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 166 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 169 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 171 */       int _v_ = _os_.unmarshal_int();
/* 172 */       this.cfgId2accumulateFragCountMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 174 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 179 */     String path = dir + "mzm.gsp.superequipment.wushi.confbean.SWuShiAccumulateFragmentCountInfo.xml";
/*     */     
/*     */     try
/*     */     {
/* 183 */       all = new HashMap();
/* 184 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 185 */       org.dom4j.Document doc = reader.read(new File(path));
/* 186 */       Element root = doc.getRootElement();
/* 187 */       List<?> nodeList = root.elements();
/* 188 */       int len = nodeList.size();
/* 189 */       for (int i = 0; i < len; i++)
/*     */       {
/* 191 */         Element elem = (Element)nodeList.get(i);
/* 192 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.wushi.confbean.SWuShiAccumulateFragmentCountInfo"))
/*     */         {
/*     */ 
/* 195 */           SWuShiAccumulateFragmentCountInfo obj = new SWuShiAccumulateFragmentCountInfo();
/* 196 */           obj.loadFromXml(elem);
/* 197 */           if (all.put(Integer.valueOf(obj.typeId), obj) != null) {
/* 198 */             throw new RuntimeException("duplicate key : " + obj.typeId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 203 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SWuShiAccumulateFragmentCountInfo> all)
/*     */   {
/* 209 */     String path = dir + "mzm.gsp.superequipment.wushi.confbean.SWuShiAccumulateFragmentCountInfo.xml";
/*     */     
/*     */     try
/*     */     {
/* 213 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 214 */       org.dom4j.Document doc = reader.read(new File(path));
/* 215 */       Element root = doc.getRootElement();
/* 216 */       List<?> nodeList = root.elements();
/* 217 */       int len = nodeList.size();
/* 218 */       for (int i = 0; i < len; i++)
/*     */       {
/* 220 */         Element elem = (Element)nodeList.get(i);
/* 221 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.superequipment.wushi.confbean.SWuShiAccumulateFragmentCountInfo"))
/*     */         {
/*     */ 
/* 224 */           SWuShiAccumulateFragmentCountInfo obj = new SWuShiAccumulateFragmentCountInfo();
/* 225 */           obj.loadFromXml(elem);
/* 226 */           if (all.put(Integer.valueOf(obj.typeId), obj) != null) {
/* 227 */             throw new RuntimeException("duplicate key : " + obj.typeId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 232 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 238 */     all = new HashMap();
/*     */     
/* 240 */     String path = dir + "mzm.gsp.superequipment.wushi.confbean.SWuShiAccumulateFragmentCountInfo.bny";
/*     */     try
/*     */     {
/* 243 */       File file = new File(path);
/* 244 */       if (file.exists())
/*     */       {
/* 246 */         byte[] bytes = new byte['Ѐ'];
/* 247 */         FileInputStream fis = new FileInputStream(file);
/* 248 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 249 */         int len = 0;
/* 250 */         while ((len = fis.read(bytes)) > 0)
/* 251 */           baos.write(bytes, 0, len);
/* 252 */         fis.close();
/* 253 */         bytes = baos.toByteArray();
/* 254 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 255 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 257 */           _os_.unmarshal_int();
/* 258 */           _os_.unmarshal_int();
/* 259 */           _os_.unmarshal_int();
/*     */         }
/* 261 */         _os_.unmarshal_int();
/* 262 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 265 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 267 */           SWuShiAccumulateFragmentCountInfo _v_ = new SWuShiAccumulateFragmentCountInfo();
/* 268 */           _v_.unmarshal(_os_);
/* 269 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 270 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 275 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 280 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SWuShiAccumulateFragmentCountInfo> all)
/*     */   {
/* 287 */     String path = dir + "mzm.gsp.superequipment.wushi.confbean.SWuShiAccumulateFragmentCountInfo.bny";
/*     */     try
/*     */     {
/* 290 */       File file = new File(path);
/* 291 */       if (file.exists())
/*     */       {
/* 293 */         byte[] bytes = new byte['Ѐ'];
/* 294 */         FileInputStream fis = new FileInputStream(file);
/* 295 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 296 */         int len = 0;
/* 297 */         while ((len = fis.read(bytes)) > 0)
/* 298 */           baos.write(bytes, 0, len);
/* 299 */         fis.close();
/* 300 */         bytes = baos.toByteArray();
/* 301 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 302 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 304 */           _os_.unmarshal_int();
/* 305 */           _os_.unmarshal_int();
/* 306 */           _os_.unmarshal_int();
/*     */         }
/* 308 */         _os_.unmarshal_int();
/* 309 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 312 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 314 */           SWuShiAccumulateFragmentCountInfo _v_ = new SWuShiAccumulateFragmentCountInfo();
/* 315 */           _v_.unmarshal(_os_);
/* 316 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 317 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 322 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 327 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SWuShiAccumulateFragmentCountInfo getOld(int key)
/*     */   {
/* 335 */     return (SWuShiAccumulateFragmentCountInfo)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SWuShiAccumulateFragmentCountInfo get(int key)
/*     */   {
/* 340 */     return (SWuShiAccumulateFragmentCountInfo)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SWuShiAccumulateFragmentCountInfo> getOldAll()
/*     */   {
/* 345 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SWuShiAccumulateFragmentCountInfo> getAll()
/*     */   {
/* 350 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SWuShiAccumulateFragmentCountInfo> newAll)
/*     */   {
/* 355 */     oldAll = all;
/* 356 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 361 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\confbean\SWuShiAccumulateFragmentCountInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */