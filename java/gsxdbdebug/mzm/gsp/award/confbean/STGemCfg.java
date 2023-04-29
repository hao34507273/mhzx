/*     */ package mzm.gsp.award.confbean;
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
/*     */ public class STGemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STGemCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STGemCfg> all = null;
/*     */   
/*     */   public int awardId;
/*     */   public int gemCfgId;
/*     */   public int littleCount;
/*     */   public int bigCount;
/*     */   public int awardMax;
/*     */   public int cycle;
/*     */   public int weightSum;
/*  25 */   public HashMap<Integer, Integer> itemId2weight = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  29 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/*  30 */     this.gemCfgId = Integer.valueOf(rootElement.attributeValue("gemCfgId")).intValue();
/*  31 */     this.littleCount = Integer.valueOf(rootElement.attributeValue("littleCount")).intValue();
/*  32 */     this.bigCount = Integer.valueOf(rootElement.attributeValue("bigCount")).intValue();
/*  33 */     this.awardMax = Integer.valueOf(rootElement.attributeValue("awardMax")).intValue();
/*  34 */     this.cycle = Integer.valueOf(rootElement.attributeValue("cycle")).intValue();
/*  35 */     this.weightSum = Integer.valueOf(rootElement.attributeValue("weightSum")).intValue();
/*     */     
/*  37 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "itemId2weight");
/*  38 */     if (mapTypeElement == null)
/*     */     {
/*  40 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  43 */     List<?> entryNodeList = mapTypeElement.elements();
/*  44 */     int entryLen = entryNodeList.size();
/*  45 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  47 */       Element entryElement = (Element)entryNodeList.get(i);
/*  48 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  53 */         Element keyElem = null;
/*  54 */         Element valueElem = null;
/*     */         
/*  56 */         List<?> _nodeList = entryElement.elements();
/*  57 */         int _len = _nodeList.size();
/*  58 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  60 */           Element elem = (Element)_nodeList.get(j);
/*  61 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  63 */             keyElem = elem;
/*     */           }
/*  65 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  67 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  71 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  73 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  80 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  81 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  88 */         this.itemId2weight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  95 */     _os_.marshal(this.awardId);
/*  96 */     _os_.marshal(this.gemCfgId);
/*  97 */     _os_.marshal(this.littleCount);
/*  98 */     _os_.marshal(this.bigCount);
/*  99 */     _os_.marshal(this.awardMax);
/* 100 */     _os_.marshal(this.cycle);
/* 101 */     _os_.marshal(this.weightSum);
/* 102 */     _os_.compact_uint32(this.itemId2weight.size());
/* 103 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.itemId2weight.entrySet())
/*     */     {
/* 105 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 106 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 108 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 113 */     this.awardId = _os_.unmarshal_int();
/* 114 */     this.gemCfgId = _os_.unmarshal_int();
/* 115 */     this.littleCount = _os_.unmarshal_int();
/* 116 */     this.bigCount = _os_.unmarshal_int();
/* 117 */     this.awardMax = _os_.unmarshal_int();
/* 118 */     this.cycle = _os_.unmarshal_int();
/* 119 */     this.weightSum = _os_.unmarshal_int();
/* 120 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 123 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 125 */       int _v_ = _os_.unmarshal_int();
/* 126 */       this.itemId2weight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 128 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 133 */     String path = dir + "mzm.gsp.award.confbean.STGemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 137 */       all = new HashMap();
/* 138 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 139 */       org.dom4j.Document doc = reader.read(new File(path));
/* 140 */       Element root = doc.getRootElement();
/* 141 */       List<?> nodeList = root.elements();
/* 142 */       int len = nodeList.size();
/* 143 */       for (int i = 0; i < len; i++)
/*     */       {
/* 145 */         Element elem = (Element)nodeList.get(i);
/* 146 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.STGemCfg"))
/*     */         {
/*     */ 
/* 149 */           STGemCfg obj = new STGemCfg();
/* 150 */           obj.loadFromXml(elem);
/* 151 */           if (all.put(Integer.valueOf(obj.awardId), obj) != null) {
/* 152 */             throw new RuntimeException("duplicate key : " + obj.awardId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 157 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STGemCfg> all)
/*     */   {
/* 163 */     String path = dir + "mzm.gsp.award.confbean.STGemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 167 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 168 */       org.dom4j.Document doc = reader.read(new File(path));
/* 169 */       Element root = doc.getRootElement();
/* 170 */       List<?> nodeList = root.elements();
/* 171 */       int len = nodeList.size();
/* 172 */       for (int i = 0; i < len; i++)
/*     */       {
/* 174 */         Element elem = (Element)nodeList.get(i);
/* 175 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.STGemCfg"))
/*     */         {
/*     */ 
/* 178 */           STGemCfg obj = new STGemCfg();
/* 179 */           obj.loadFromXml(elem);
/* 180 */           if (all.put(Integer.valueOf(obj.awardId), obj) != null) {
/* 181 */             throw new RuntimeException("duplicate key : " + obj.awardId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 186 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 192 */     all = new HashMap();
/*     */     
/* 194 */     String path = dir + "mzm.gsp.award.confbean.STGemCfg.bny";
/*     */     try
/*     */     {
/* 197 */       File file = new File(path);
/* 198 */       if (file.exists())
/*     */       {
/* 200 */         byte[] bytes = new byte['Ѐ'];
/* 201 */         FileInputStream fis = new FileInputStream(file);
/* 202 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 203 */         int len = 0;
/* 204 */         while ((len = fis.read(bytes)) > 0)
/* 205 */           baos.write(bytes, 0, len);
/* 206 */         fis.close();
/* 207 */         bytes = baos.toByteArray();
/* 208 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 209 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 211 */           _os_.unmarshal_int();
/* 212 */           _os_.unmarshal_int();
/* 213 */           _os_.unmarshal_int();
/*     */         }
/* 215 */         _os_.unmarshal_int();
/* 216 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 219 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 221 */           STGemCfg _v_ = new STGemCfg();
/* 222 */           _v_.unmarshal(_os_);
/* 223 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 224 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 229 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 234 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STGemCfg> all)
/*     */   {
/* 241 */     String path = dir + "mzm.gsp.award.confbean.STGemCfg.bny";
/*     */     try
/*     */     {
/* 244 */       File file = new File(path);
/* 245 */       if (file.exists())
/*     */       {
/* 247 */         byte[] bytes = new byte['Ѐ'];
/* 248 */         FileInputStream fis = new FileInputStream(file);
/* 249 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 250 */         int len = 0;
/* 251 */         while ((len = fis.read(bytes)) > 0)
/* 252 */           baos.write(bytes, 0, len);
/* 253 */         fis.close();
/* 254 */         bytes = baos.toByteArray();
/* 255 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 256 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 258 */           _os_.unmarshal_int();
/* 259 */           _os_.unmarshal_int();
/* 260 */           _os_.unmarshal_int();
/*     */         }
/* 262 */         _os_.unmarshal_int();
/* 263 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 266 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 268 */           STGemCfg _v_ = new STGemCfg();
/* 269 */           _v_.unmarshal(_os_);
/* 270 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 271 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 276 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 281 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STGemCfg getOld(int key)
/*     */   {
/* 289 */     return (STGemCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STGemCfg get(int key)
/*     */   {
/* 294 */     return (STGemCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STGemCfg> getOldAll()
/*     */   {
/* 299 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STGemCfg> getAll()
/*     */   {
/* 304 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STGemCfg> newAll)
/*     */   {
/* 309 */     oldAll = all;
/* 310 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 315 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\STGemCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */