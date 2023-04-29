/*     */ package mzm.gsp.pvc.confbean;
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
/*     */ public class SPVCRobotCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SPVCRobotCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SPVCRobotCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int classid;
/*     */   public int levelMax;
/*     */   public int levelMin;
/*     */   public int occupation;
/*     */   public int gender;
/*     */   public int roleRobotid;
/*  25 */   public java.util.ArrayList<Integer> petRobotids = new java.util.ArrayList();
/*     */   public int partnerRobotCount;
/*  27 */   public HashMap<Integer, Integer> partnerRandomMap = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  31 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  32 */     this.classid = Integer.valueOf(rootElement.attributeValue("classid")).intValue();
/*  33 */     this.levelMax = Integer.valueOf(rootElement.attributeValue("levelMax")).intValue();
/*  34 */     this.levelMin = Integer.valueOf(rootElement.attributeValue("levelMin")).intValue();
/*  35 */     this.occupation = Integer.valueOf(rootElement.attributeValue("occupation")).intValue();
/*  36 */     this.gender = Integer.valueOf(rootElement.attributeValue("gender")).intValue();
/*  37 */     this.roleRobotid = Integer.valueOf(rootElement.attributeValue("roleRobotid")).intValue();
/*     */     
/*  39 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "petRobotids");
/*  40 */     if (collectionElement == null)
/*     */     {
/*  42 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  45 */     List<?> _nodeList = collectionElement.elements();
/*  46 */     int _len = _nodeList.size();
/*  47 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  49 */       Element elem = (Element)_nodeList.get(i);
/*  50 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  57 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  64 */         this.petRobotids.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  67 */     this.partnerRobotCount = Integer.valueOf(rootElement.attributeValue("partnerRobotCount")).intValue();
/*     */     
/*  69 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "partnerRandomMap");
/*  70 */     if (mapTypeElement == null)
/*     */     {
/*  72 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  75 */     List<?> entryNodeList = mapTypeElement.elements();
/*  76 */     int entryLen = entryNodeList.size();
/*  77 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  79 */       Element entryElement = (Element)entryNodeList.get(i);
/*  80 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  85 */         Element keyElem = null;
/*  86 */         Element valueElem = null;
/*     */         
/*  88 */         List<?> _nodeList = entryElement.elements();
/*  89 */         int _len = _nodeList.size();
/*  90 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  92 */           Element elem = (Element)_nodeList.get(j);
/*  93 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  95 */             keyElem = elem;
/*     */           }
/*  97 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  99 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 103 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 105 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/* 112 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 113 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 120 */         this.partnerRandomMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 127 */     _os_.marshal(this.id);
/* 128 */     _os_.marshal(this.classid);
/* 129 */     _os_.marshal(this.levelMax);
/* 130 */     _os_.marshal(this.levelMin);
/* 131 */     _os_.marshal(this.occupation);
/* 132 */     _os_.marshal(this.gender);
/* 133 */     _os_.marshal(this.roleRobotid);
/* 134 */     _os_.compact_uint32(this.petRobotids.size());
/* 135 */     for (Integer _v_ : this.petRobotids)
/*     */     {
/* 137 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 139 */     _os_.marshal(this.partnerRobotCount);
/* 140 */     _os_.compact_uint32(this.partnerRandomMap.size());
/* 141 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.partnerRandomMap.entrySet())
/*     */     {
/* 143 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 144 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 146 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 151 */     this.id = _os_.unmarshal_int();
/* 152 */     this.classid = _os_.unmarshal_int();
/* 153 */     this.levelMax = _os_.unmarshal_int();
/* 154 */     this.levelMin = _os_.unmarshal_int();
/* 155 */     this.occupation = _os_.unmarshal_int();
/* 156 */     this.gender = _os_.unmarshal_int();
/* 157 */     this.roleRobotid = _os_.unmarshal_int();
/* 158 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 161 */       int _v_ = _os_.unmarshal_int();
/* 162 */       this.petRobotids.add(Integer.valueOf(_v_));
/*     */     }
/* 164 */     this.partnerRobotCount = _os_.unmarshal_int();
/* 165 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 168 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 170 */       int _v_ = _os_.unmarshal_int();
/* 171 */       this.partnerRandomMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 173 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 178 */     String path = dir + "mzm.gsp.pvc.confbean.SPVCRobotCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 182 */       all = new HashMap();
/* 183 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 184 */       org.dom4j.Document doc = reader.read(new File(path));
/* 185 */       Element root = doc.getRootElement();
/* 186 */       List<?> nodeList = root.elements();
/* 187 */       int len = nodeList.size();
/* 188 */       for (int i = 0; i < len; i++)
/*     */       {
/* 190 */         Element elem = (Element)nodeList.get(i);
/* 191 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.pvc.confbean.SPVCRobotCfg"))
/*     */         {
/*     */ 
/* 194 */           SPVCRobotCfg obj = new SPVCRobotCfg();
/* 195 */           obj.loadFromXml(elem);
/* 196 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 197 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 202 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SPVCRobotCfg> all)
/*     */   {
/* 208 */     String path = dir + "mzm.gsp.pvc.confbean.SPVCRobotCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 212 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 213 */       org.dom4j.Document doc = reader.read(new File(path));
/* 214 */       Element root = doc.getRootElement();
/* 215 */       List<?> nodeList = root.elements();
/* 216 */       int len = nodeList.size();
/* 217 */       for (int i = 0; i < len; i++)
/*     */       {
/* 219 */         Element elem = (Element)nodeList.get(i);
/* 220 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.pvc.confbean.SPVCRobotCfg"))
/*     */         {
/*     */ 
/* 223 */           SPVCRobotCfg obj = new SPVCRobotCfg();
/* 224 */           obj.loadFromXml(elem);
/* 225 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 226 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 231 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 237 */     all = new HashMap();
/*     */     
/* 239 */     String path = dir + "mzm.gsp.pvc.confbean.SPVCRobotCfg.bny";
/*     */     try
/*     */     {
/* 242 */       File file = new File(path);
/* 243 */       if (file.exists())
/*     */       {
/* 245 */         byte[] bytes = new byte['Ѐ'];
/* 246 */         FileInputStream fis = new FileInputStream(file);
/* 247 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 248 */         int len = 0;
/* 249 */         while ((len = fis.read(bytes)) > 0)
/* 250 */           baos.write(bytes, 0, len);
/* 251 */         fis.close();
/* 252 */         bytes = baos.toByteArray();
/* 253 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 254 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 256 */           _os_.unmarshal_int();
/* 257 */           _os_.unmarshal_int();
/* 258 */           _os_.unmarshal_int();
/*     */         }
/* 260 */         _os_.unmarshal_int();
/* 261 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 264 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 266 */           SPVCRobotCfg _v_ = new SPVCRobotCfg();
/* 267 */           _v_.unmarshal(_os_);
/* 268 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 269 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 274 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 279 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SPVCRobotCfg> all)
/*     */   {
/* 286 */     String path = dir + "mzm.gsp.pvc.confbean.SPVCRobotCfg.bny";
/*     */     try
/*     */     {
/* 289 */       File file = new File(path);
/* 290 */       if (file.exists())
/*     */       {
/* 292 */         byte[] bytes = new byte['Ѐ'];
/* 293 */         FileInputStream fis = new FileInputStream(file);
/* 294 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 295 */         int len = 0;
/* 296 */         while ((len = fis.read(bytes)) > 0)
/* 297 */           baos.write(bytes, 0, len);
/* 298 */         fis.close();
/* 299 */         bytes = baos.toByteArray();
/* 300 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 301 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 303 */           _os_.unmarshal_int();
/* 304 */           _os_.unmarshal_int();
/* 305 */           _os_.unmarshal_int();
/*     */         }
/* 307 */         _os_.unmarshal_int();
/* 308 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 311 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 313 */           SPVCRobotCfg _v_ = new SPVCRobotCfg();
/* 314 */           _v_.unmarshal(_os_);
/* 315 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 316 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 321 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 326 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SPVCRobotCfg getOld(int key)
/*     */   {
/* 334 */     return (SPVCRobotCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SPVCRobotCfg get(int key)
/*     */   {
/* 339 */     return (SPVCRobotCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPVCRobotCfg> getOldAll()
/*     */   {
/* 344 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPVCRobotCfg> getAll()
/*     */   {
/* 349 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SPVCRobotCfg> newAll)
/*     */   {
/* 354 */     oldAll = all;
/* 355 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 360 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pvc\confbean\SPVCRobotCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */