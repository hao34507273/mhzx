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
/*     */ public class STGemTable implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STGemTable> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STGemTable> all = null;
/*     */   
/*     */   public int gemCfgId;
/*     */   public int gemLibId;
/*     */   public int dropLvLow;
/*     */   public int dropSerLvInterval;
/*     */   public int littleCount;
/*     */   public int bigCount;
/*     */   public int awardMax;
/*     */   public int cycle;
/*     */   public int weightSum;
/*  27 */   public HashMap<Integer, Integer> itemId2weight = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  31 */     this.gemCfgId = Integer.valueOf(rootElement.attributeValue("gemCfgId")).intValue();
/*  32 */     this.gemLibId = Integer.valueOf(rootElement.attributeValue("gemLibId")).intValue();
/*  33 */     this.dropLvLow = Integer.valueOf(rootElement.attributeValue("dropLvLow")).intValue();
/*  34 */     this.dropSerLvInterval = Integer.valueOf(rootElement.attributeValue("dropSerLvInterval")).intValue();
/*  35 */     this.littleCount = Integer.valueOf(rootElement.attributeValue("littleCount")).intValue();
/*  36 */     this.bigCount = Integer.valueOf(rootElement.attributeValue("bigCount")).intValue();
/*  37 */     this.awardMax = Integer.valueOf(rootElement.attributeValue("awardMax")).intValue();
/*  38 */     this.cycle = Integer.valueOf(rootElement.attributeValue("cycle")).intValue();
/*  39 */     this.weightSum = Integer.valueOf(rootElement.attributeValue("weightSum")).intValue();
/*     */     
/*  41 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "itemId2weight");
/*  42 */     if (mapTypeElement == null)
/*     */     {
/*  44 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  47 */     List<?> entryNodeList = mapTypeElement.elements();
/*  48 */     int entryLen = entryNodeList.size();
/*  49 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  51 */       Element entryElement = (Element)entryNodeList.get(i);
/*  52 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  57 */         Element keyElem = null;
/*  58 */         Element valueElem = null;
/*     */         
/*  60 */         List<?> _nodeList = entryElement.elements();
/*  61 */         int _len = _nodeList.size();
/*  62 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  64 */           Element elem = (Element)_nodeList.get(j);
/*  65 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  67 */             keyElem = elem;
/*     */           }
/*  69 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  71 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  75 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  77 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  84 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  85 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  92 */         this.itemId2weight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  99 */     _os_.marshal(this.gemCfgId);
/* 100 */     _os_.marshal(this.gemLibId);
/* 101 */     _os_.marshal(this.dropLvLow);
/* 102 */     _os_.marshal(this.dropSerLvInterval);
/* 103 */     _os_.marshal(this.littleCount);
/* 104 */     _os_.marshal(this.bigCount);
/* 105 */     _os_.marshal(this.awardMax);
/* 106 */     _os_.marshal(this.cycle);
/* 107 */     _os_.marshal(this.weightSum);
/* 108 */     _os_.compact_uint32(this.itemId2weight.size());
/* 109 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.itemId2weight.entrySet())
/*     */     {
/* 111 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 112 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 119 */     this.gemCfgId = _os_.unmarshal_int();
/* 120 */     this.gemLibId = _os_.unmarshal_int();
/* 121 */     this.dropLvLow = _os_.unmarshal_int();
/* 122 */     this.dropSerLvInterval = _os_.unmarshal_int();
/* 123 */     this.littleCount = _os_.unmarshal_int();
/* 124 */     this.bigCount = _os_.unmarshal_int();
/* 125 */     this.awardMax = _os_.unmarshal_int();
/* 126 */     this.cycle = _os_.unmarshal_int();
/* 127 */     this.weightSum = _os_.unmarshal_int();
/* 128 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 131 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 133 */       int _v_ = _os_.unmarshal_int();
/* 134 */       this.itemId2weight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 136 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 141 */     String path = dir + "mzm.gsp.award.confbean.STGemTable.xml";
/*     */     
/*     */     try
/*     */     {
/* 145 */       all = new HashMap();
/* 146 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 147 */       org.dom4j.Document doc = reader.read(new File(path));
/* 148 */       Element root = doc.getRootElement();
/* 149 */       List<?> nodeList = root.elements();
/* 150 */       int len = nodeList.size();
/* 151 */       for (int i = 0; i < len; i++)
/*     */       {
/* 153 */         Element elem = (Element)nodeList.get(i);
/* 154 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.STGemTable"))
/*     */         {
/*     */ 
/* 157 */           STGemTable obj = new STGemTable();
/* 158 */           obj.loadFromXml(elem);
/* 159 */           if (all.put(Integer.valueOf(obj.gemCfgId), obj) != null) {
/* 160 */             throw new RuntimeException("duplicate key : " + obj.gemCfgId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 165 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STGemTable> all)
/*     */   {
/* 171 */     String path = dir + "mzm.gsp.award.confbean.STGemTable.xml";
/*     */     
/*     */     try
/*     */     {
/* 175 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 176 */       org.dom4j.Document doc = reader.read(new File(path));
/* 177 */       Element root = doc.getRootElement();
/* 178 */       List<?> nodeList = root.elements();
/* 179 */       int len = nodeList.size();
/* 180 */       for (int i = 0; i < len; i++)
/*     */       {
/* 182 */         Element elem = (Element)nodeList.get(i);
/* 183 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.STGemTable"))
/*     */         {
/*     */ 
/* 186 */           STGemTable obj = new STGemTable();
/* 187 */           obj.loadFromXml(elem);
/* 188 */           if (all.put(Integer.valueOf(obj.gemCfgId), obj) != null) {
/* 189 */             throw new RuntimeException("duplicate key : " + obj.gemCfgId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 194 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 200 */     all = new HashMap();
/*     */     
/* 202 */     String path = dir + "mzm.gsp.award.confbean.STGemTable.bny";
/*     */     try
/*     */     {
/* 205 */       File file = new File(path);
/* 206 */       if (file.exists())
/*     */       {
/* 208 */         byte[] bytes = new byte['Ѐ'];
/* 209 */         FileInputStream fis = new FileInputStream(file);
/* 210 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 211 */         int len = 0;
/* 212 */         while ((len = fis.read(bytes)) > 0)
/* 213 */           baos.write(bytes, 0, len);
/* 214 */         fis.close();
/* 215 */         bytes = baos.toByteArray();
/* 216 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 217 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 219 */           _os_.unmarshal_int();
/* 220 */           _os_.unmarshal_int();
/* 221 */           _os_.unmarshal_int();
/*     */         }
/* 223 */         _os_.unmarshal_int();
/* 224 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 227 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 229 */           STGemTable _v_ = new STGemTable();
/* 230 */           _v_.unmarshal(_os_);
/* 231 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 232 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 237 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 242 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STGemTable> all)
/*     */   {
/* 249 */     String path = dir + "mzm.gsp.award.confbean.STGemTable.bny";
/*     */     try
/*     */     {
/* 252 */       File file = new File(path);
/* 253 */       if (file.exists())
/*     */       {
/* 255 */         byte[] bytes = new byte['Ѐ'];
/* 256 */         FileInputStream fis = new FileInputStream(file);
/* 257 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 258 */         int len = 0;
/* 259 */         while ((len = fis.read(bytes)) > 0)
/* 260 */           baos.write(bytes, 0, len);
/* 261 */         fis.close();
/* 262 */         bytes = baos.toByteArray();
/* 263 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 264 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 266 */           _os_.unmarshal_int();
/* 267 */           _os_.unmarshal_int();
/* 268 */           _os_.unmarshal_int();
/*     */         }
/* 270 */         _os_.unmarshal_int();
/* 271 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 274 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 276 */           STGemTable _v_ = new STGemTable();
/* 277 */           _v_.unmarshal(_os_);
/* 278 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 279 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 284 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 289 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STGemTable getOld(int key)
/*     */   {
/* 297 */     return (STGemTable)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STGemTable get(int key)
/*     */   {
/* 302 */     return (STGemTable)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STGemTable> getOldAll()
/*     */   {
/* 307 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STGemTable> getAll()
/*     */   {
/* 312 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STGemTable> newAll)
/*     */   {
/* 317 */     oldAll = all;
/* 318 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 323 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\STGemTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */