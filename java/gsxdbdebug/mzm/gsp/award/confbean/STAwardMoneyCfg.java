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
/*     */ public class STAwardMoneyCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STAwardMoneyCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STAwardMoneyCfg> all = null;
/*     */   
/*     */   public int cfgId;
/*     */   public int awardId;
/*     */   public int levelType;
/*     */   public int levelMin;
/*     */   public int levelMax;
/*  23 */   public HashMap<Integer, Integer> moneyType2num = new HashMap();
/*  24 */   public HashMap<Integer, Integer> tokenType2num = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.cfgId = Integer.valueOf(rootElement.attributeValue("cfgId")).intValue();
/*  29 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/*  30 */     this.levelType = Integer.valueOf(rootElement.attributeValue("levelType")).intValue();
/*  31 */     this.levelMin = Integer.valueOf(rootElement.attributeValue("levelMin")).intValue();
/*  32 */     this.levelMax = Integer.valueOf(rootElement.attributeValue("levelMax")).intValue();
/*     */     
/*  34 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "moneyType2num");
/*  35 */     if (mapTypeElement == null)
/*     */     {
/*  37 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  40 */     List<?> entryNodeList = mapTypeElement.elements();
/*  41 */     int entryLen = entryNodeList.size();
/*  42 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  44 */       Element entryElement = (Element)entryNodeList.get(i);
/*  45 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  50 */         Element keyElem = null;
/*  51 */         Element valueElem = null;
/*     */         
/*  53 */         List<?> _nodeList = entryElement.elements();
/*  54 */         int _len = _nodeList.size();
/*  55 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  57 */           Element elem = (Element)_nodeList.get(j);
/*  58 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  60 */             keyElem = elem;
/*     */           }
/*  62 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  64 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  68 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  70 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  77 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  78 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  85 */         this.moneyType2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  89 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "tokenType2num");
/*  90 */     if (mapTypeElement == null)
/*     */     {
/*  92 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  95 */     List<?> entryNodeList = mapTypeElement.elements();
/*  96 */     int entryLen = entryNodeList.size();
/*  97 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  99 */       Element entryElement = (Element)entryNodeList.get(i);
/* 100 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 105 */         Element keyElem = null;
/* 106 */         Element valueElem = null;
/*     */         
/* 108 */         List<?> _nodeList = entryElement.elements();
/* 109 */         int _len = _nodeList.size();
/* 110 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 112 */           Element elem = (Element)_nodeList.get(j);
/* 113 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 115 */             keyElem = elem;
/*     */           }
/* 117 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 119 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 123 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 125 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 132 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 133 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 140 */         this.tokenType2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 147 */     _os_.marshal(this.cfgId);
/* 148 */     _os_.marshal(this.awardId);
/* 149 */     _os_.marshal(this.levelType);
/* 150 */     _os_.marshal(this.levelMin);
/* 151 */     _os_.marshal(this.levelMax);
/* 152 */     _os_.compact_uint32(this.moneyType2num.size());
/* 153 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.moneyType2num.entrySet())
/*     */     {
/* 155 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 156 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 158 */     _os_.compact_uint32(this.tokenType2num.size());
/* 159 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.tokenType2num.entrySet())
/*     */     {
/* 161 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 162 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 164 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 169 */     this.cfgId = _os_.unmarshal_int();
/* 170 */     this.awardId = _os_.unmarshal_int();
/* 171 */     this.levelType = _os_.unmarshal_int();
/* 172 */     this.levelMin = _os_.unmarshal_int();
/* 173 */     this.levelMax = _os_.unmarshal_int();
/* 174 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 177 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 179 */       int _v_ = _os_.unmarshal_int();
/* 180 */       this.moneyType2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 182 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 185 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 187 */       int _v_ = _os_.unmarshal_int();
/* 188 */       this.tokenType2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 190 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 195 */     String path = dir + "mzm.gsp.award.confbean.STAwardMoneyCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 199 */       all = new HashMap();
/* 200 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 201 */       org.dom4j.Document doc = reader.read(new File(path));
/* 202 */       Element root = doc.getRootElement();
/* 203 */       List<?> nodeList = root.elements();
/* 204 */       int len = nodeList.size();
/* 205 */       for (int i = 0; i < len; i++)
/*     */       {
/* 207 */         Element elem = (Element)nodeList.get(i);
/* 208 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.STAwardMoneyCfg"))
/*     */         {
/*     */ 
/* 211 */           STAwardMoneyCfg obj = new STAwardMoneyCfg();
/* 212 */           obj.loadFromXml(elem);
/* 213 */           if (all.put(Integer.valueOf(obj.cfgId), obj) != null) {
/* 214 */             throw new RuntimeException("duplicate key : " + obj.cfgId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 219 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STAwardMoneyCfg> all)
/*     */   {
/* 225 */     String path = dir + "mzm.gsp.award.confbean.STAwardMoneyCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 229 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 230 */       org.dom4j.Document doc = reader.read(new File(path));
/* 231 */       Element root = doc.getRootElement();
/* 232 */       List<?> nodeList = root.elements();
/* 233 */       int len = nodeList.size();
/* 234 */       for (int i = 0; i < len; i++)
/*     */       {
/* 236 */         Element elem = (Element)nodeList.get(i);
/* 237 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.award.confbean.STAwardMoneyCfg"))
/*     */         {
/*     */ 
/* 240 */           STAwardMoneyCfg obj = new STAwardMoneyCfg();
/* 241 */           obj.loadFromXml(elem);
/* 242 */           if (all.put(Integer.valueOf(obj.cfgId), obj) != null) {
/* 243 */             throw new RuntimeException("duplicate key : " + obj.cfgId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 248 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 254 */     all = new HashMap();
/*     */     
/* 256 */     String path = dir + "mzm.gsp.award.confbean.STAwardMoneyCfg.bny";
/*     */     try
/*     */     {
/* 259 */       File file = new File(path);
/* 260 */       if (file.exists())
/*     */       {
/* 262 */         byte[] bytes = new byte['Ѐ'];
/* 263 */         FileInputStream fis = new FileInputStream(file);
/* 264 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 265 */         int len = 0;
/* 266 */         while ((len = fis.read(bytes)) > 0)
/* 267 */           baos.write(bytes, 0, len);
/* 268 */         fis.close();
/* 269 */         bytes = baos.toByteArray();
/* 270 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 271 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 273 */           _os_.unmarshal_int();
/* 274 */           _os_.unmarshal_int();
/* 275 */           _os_.unmarshal_int();
/*     */         }
/* 277 */         _os_.unmarshal_int();
/* 278 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 281 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 283 */           STAwardMoneyCfg _v_ = new STAwardMoneyCfg();
/* 284 */           _v_.unmarshal(_os_);
/* 285 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 286 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 291 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 296 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STAwardMoneyCfg> all)
/*     */   {
/* 303 */     String path = dir + "mzm.gsp.award.confbean.STAwardMoneyCfg.bny";
/*     */     try
/*     */     {
/* 306 */       File file = new File(path);
/* 307 */       if (file.exists())
/*     */       {
/* 309 */         byte[] bytes = new byte['Ѐ'];
/* 310 */         FileInputStream fis = new FileInputStream(file);
/* 311 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 312 */         int len = 0;
/* 313 */         while ((len = fis.read(bytes)) > 0)
/* 314 */           baos.write(bytes, 0, len);
/* 315 */         fis.close();
/* 316 */         bytes = baos.toByteArray();
/* 317 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 318 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 320 */           _os_.unmarshal_int();
/* 321 */           _os_.unmarshal_int();
/* 322 */           _os_.unmarshal_int();
/*     */         }
/* 324 */         _os_.unmarshal_int();
/* 325 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 328 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 330 */           STAwardMoneyCfg _v_ = new STAwardMoneyCfg();
/* 331 */           _v_.unmarshal(_os_);
/* 332 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 333 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 338 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 343 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STAwardMoneyCfg getOld(int key)
/*     */   {
/* 351 */     return (STAwardMoneyCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STAwardMoneyCfg get(int key)
/*     */   {
/* 356 */     return (STAwardMoneyCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STAwardMoneyCfg> getOldAll()
/*     */   {
/* 361 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STAwardMoneyCfg> getAll()
/*     */   {
/* 366 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STAwardMoneyCfg> newAll)
/*     */   {
/* 371 */     oldAll = all;
/* 372 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 377 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\STAwardMoneyCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */