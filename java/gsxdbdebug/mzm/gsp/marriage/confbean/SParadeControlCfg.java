/*     */ package mzm.gsp.marriage.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SParadeControlCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SParadeControlCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SParadeControlCfg> all = null;
/*     */   
/*     */   public int paradeLevelid;
/*  19 */   public TreeMap<Integer, ParadeNumCfg> num2CfgMap = new TreeMap();
/*  20 */   public java.util.ArrayList<Integer> robSeqNums = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.paradeLevelid = Integer.valueOf(rootElement.attributeValue("paradeLevelid")).intValue();
/*     */     
/*  26 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "num2CfgMap");
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
/*  54 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.marriage.confbean.ParadeNumCfg")))
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
/*     */         ParadeNumCfg _v_;
/*     */         try
/*     */         {
/*  69 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  70 */           _v_ = new ParadeNumCfg();
/*  71 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  78 */         this.num2CfgMap.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */     
/*  82 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "robSeqNums");
/*  83 */     if (collectionElement == null)
/*     */     {
/*  85 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  88 */     List<?> _nodeList = collectionElement.elements();
/*  89 */     int _len = _nodeList.size();
/*  90 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  92 */       Element elem = (Element)_nodeList.get(i);
/*  93 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/* 100 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 107 */         this.robSeqNums.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 114 */     _os_.marshal(this.paradeLevelid);
/* 115 */     _os_.compact_uint32(this.num2CfgMap.size());
/* 116 */     for (java.util.Map.Entry<Integer, ParadeNumCfg> _e_ : this.num2CfgMap.entrySet())
/*     */     {
/* 118 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 119 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 121 */     _os_.compact_uint32(this.robSeqNums.size());
/* 122 */     for (Integer _v_ : this.robSeqNums)
/*     */     {
/* 124 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 126 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 131 */     this.paradeLevelid = _os_.unmarshal_int();
/* 132 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 135 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 137 */       ParadeNumCfg _v_ = new ParadeNumCfg();
/* 138 */       _v_.unmarshal(_os_);
/* 139 */       this.num2CfgMap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 141 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 144 */       int _v_ = _os_.unmarshal_int();
/* 145 */       this.robSeqNums.add(Integer.valueOf(_v_));
/*     */     }
/* 147 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 152 */     String path = dir + "mzm.gsp.marriage.confbean.SParadeControlCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 156 */       all = new java.util.HashMap();
/* 157 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 158 */       org.dom4j.Document doc = reader.read(new File(path));
/* 159 */       Element root = doc.getRootElement();
/* 160 */       List<?> nodeList = root.elements();
/* 161 */       int len = nodeList.size();
/* 162 */       for (int i = 0; i < len; i++)
/*     */       {
/* 164 */         Element elem = (Element)nodeList.get(i);
/* 165 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.marriage.confbean.SParadeControlCfg"))
/*     */         {
/*     */ 
/* 168 */           SParadeControlCfg obj = new SParadeControlCfg();
/* 169 */           obj.loadFromXml(elem);
/* 170 */           if (all.put(Integer.valueOf(obj.paradeLevelid), obj) != null) {
/* 171 */             throw new RuntimeException("duplicate key : " + obj.paradeLevelid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SParadeControlCfg> all)
/*     */   {
/* 182 */     String path = dir + "mzm.gsp.marriage.confbean.SParadeControlCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 186 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 187 */       org.dom4j.Document doc = reader.read(new File(path));
/* 188 */       Element root = doc.getRootElement();
/* 189 */       List<?> nodeList = root.elements();
/* 190 */       int len = nodeList.size();
/* 191 */       for (int i = 0; i < len; i++)
/*     */       {
/* 193 */         Element elem = (Element)nodeList.get(i);
/* 194 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.marriage.confbean.SParadeControlCfg"))
/*     */         {
/*     */ 
/* 197 */           SParadeControlCfg obj = new SParadeControlCfg();
/* 198 */           obj.loadFromXml(elem);
/* 199 */           if (all.put(Integer.valueOf(obj.paradeLevelid), obj) != null) {
/* 200 */             throw new RuntimeException("duplicate key : " + obj.paradeLevelid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 205 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 211 */     all = new java.util.HashMap();
/*     */     
/* 213 */     String path = dir + "mzm.gsp.marriage.confbean.SParadeControlCfg.bny";
/*     */     try
/*     */     {
/* 216 */       File file = new File(path);
/* 217 */       if (file.exists())
/*     */       {
/* 219 */         byte[] bytes = new byte['Ѐ'];
/* 220 */         FileInputStream fis = new FileInputStream(file);
/* 221 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 222 */         int len = 0;
/* 223 */         while ((len = fis.read(bytes)) > 0)
/* 224 */           baos.write(bytes, 0, len);
/* 225 */         fis.close();
/* 226 */         bytes = baos.toByteArray();
/* 227 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 228 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 230 */           _os_.unmarshal_int();
/* 231 */           _os_.unmarshal_int();
/* 232 */           _os_.unmarshal_int();
/*     */         }
/* 234 */         _os_.unmarshal_int();
/* 235 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 238 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 240 */           SParadeControlCfg _v_ = new SParadeControlCfg();
/* 241 */           _v_.unmarshal(_os_);
/* 242 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 243 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 248 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 253 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SParadeControlCfg> all)
/*     */   {
/* 260 */     String path = dir + "mzm.gsp.marriage.confbean.SParadeControlCfg.bny";
/*     */     try
/*     */     {
/* 263 */       File file = new File(path);
/* 264 */       if (file.exists())
/*     */       {
/* 266 */         byte[] bytes = new byte['Ѐ'];
/* 267 */         FileInputStream fis = new FileInputStream(file);
/* 268 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 269 */         int len = 0;
/* 270 */         while ((len = fis.read(bytes)) > 0)
/* 271 */           baos.write(bytes, 0, len);
/* 272 */         fis.close();
/* 273 */         bytes = baos.toByteArray();
/* 274 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 275 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 277 */           _os_.unmarshal_int();
/* 278 */           _os_.unmarshal_int();
/* 279 */           _os_.unmarshal_int();
/*     */         }
/* 281 */         _os_.unmarshal_int();
/* 282 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 285 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 287 */           SParadeControlCfg _v_ = new SParadeControlCfg();
/* 288 */           _v_.unmarshal(_os_);
/* 289 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 290 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 295 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 300 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SParadeControlCfg getOld(int key)
/*     */   {
/* 308 */     return (SParadeControlCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SParadeControlCfg get(int key)
/*     */   {
/* 313 */     return (SParadeControlCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SParadeControlCfg> getOldAll()
/*     */   {
/* 318 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SParadeControlCfg> getAll()
/*     */   {
/* 323 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SParadeControlCfg> newAll)
/*     */   {
/* 328 */     oldAll = all;
/* 329 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 334 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\confbean\SParadeControlCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */