/*     */ package mzm.gsp.awardpool.confbean;
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
/*     */ public class SLotteryViewRandomCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SLotteryViewRandomCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SLotteryViewRandomCfg> all = null;
/*     */   
/*     */   public int id;
/*  19 */   public HashMap<Integer, Integer> bagId2MaxNeedGrid = new HashMap();
/*  20 */   public java.util.ArrayList<Integer> typeIds = new java.util.ArrayList();
/*     */   public int weightCorrectionTypeCfgId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  25 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*     */     
/*  27 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "bagId2MaxNeedGrid");
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
/*  78 */         this.bagId2MaxNeedGrid.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  82 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "typeIds");
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
/* 107 */         this.typeIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/* 110 */     this.weightCorrectionTypeCfgId = Integer.valueOf(rootElement.attributeValue("weightCorrectionTypeCfgId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 115 */     _os_.marshal(this.id);
/* 116 */     _os_.compact_uint32(this.bagId2MaxNeedGrid.size());
/* 117 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.bagId2MaxNeedGrid.entrySet())
/*     */     {
/* 119 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 120 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 122 */     _os_.compact_uint32(this.typeIds.size());
/* 123 */     for (Integer _v_ : this.typeIds)
/*     */     {
/* 125 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 127 */     _os_.marshal(this.weightCorrectionTypeCfgId);
/* 128 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 133 */     this.id = _os_.unmarshal_int();
/* 134 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 137 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 139 */       int _v_ = _os_.unmarshal_int();
/* 140 */       this.bagId2MaxNeedGrid.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 142 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 145 */       int _v_ = _os_.unmarshal_int();
/* 146 */       this.typeIds.add(Integer.valueOf(_v_));
/*     */     }
/* 148 */     this.weightCorrectionTypeCfgId = _os_.unmarshal_int();
/* 149 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 154 */     String path = dir + "mzm.gsp.awardpool.confbean.SLotteryViewRandomCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 158 */       all = new HashMap();
/* 159 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 160 */       org.dom4j.Document doc = reader.read(new File(path));
/* 161 */       Element root = doc.getRootElement();
/* 162 */       List<?> nodeList = root.elements();
/* 163 */       int len = nodeList.size();
/* 164 */       for (int i = 0; i < len; i++)
/*     */       {
/* 166 */         Element elem = (Element)nodeList.get(i);
/* 167 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.awardpool.confbean.SLotteryViewRandomCfg"))
/*     */         {
/*     */ 
/* 170 */           SLotteryViewRandomCfg obj = new SLotteryViewRandomCfg();
/* 171 */           obj.loadFromXml(elem);
/* 172 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 173 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 178 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SLotteryViewRandomCfg> all)
/*     */   {
/* 184 */     String path = dir + "mzm.gsp.awardpool.confbean.SLotteryViewRandomCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 188 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 189 */       org.dom4j.Document doc = reader.read(new File(path));
/* 190 */       Element root = doc.getRootElement();
/* 191 */       List<?> nodeList = root.elements();
/* 192 */       int len = nodeList.size();
/* 193 */       for (int i = 0; i < len; i++)
/*     */       {
/* 195 */         Element elem = (Element)nodeList.get(i);
/* 196 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.awardpool.confbean.SLotteryViewRandomCfg"))
/*     */         {
/*     */ 
/* 199 */           SLotteryViewRandomCfg obj = new SLotteryViewRandomCfg();
/* 200 */           obj.loadFromXml(elem);
/* 201 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 202 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 207 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 213 */     all = new HashMap();
/*     */     
/* 215 */     String path = dir + "mzm.gsp.awardpool.confbean.SLotteryViewRandomCfg.bny";
/*     */     try
/*     */     {
/* 218 */       File file = new File(path);
/* 219 */       if (file.exists())
/*     */       {
/* 221 */         byte[] bytes = new byte['Ѐ'];
/* 222 */         FileInputStream fis = new FileInputStream(file);
/* 223 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 224 */         int len = 0;
/* 225 */         while ((len = fis.read(bytes)) > 0)
/* 226 */           baos.write(bytes, 0, len);
/* 227 */         fis.close();
/* 228 */         bytes = baos.toByteArray();
/* 229 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 230 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 232 */           _os_.unmarshal_int();
/* 233 */           _os_.unmarshal_int();
/* 234 */           _os_.unmarshal_int();
/*     */         }
/* 236 */         _os_.unmarshal_int();
/* 237 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 240 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 242 */           SLotteryViewRandomCfg _v_ = new SLotteryViewRandomCfg();
/* 243 */           _v_.unmarshal(_os_);
/* 244 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 245 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 250 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 255 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SLotteryViewRandomCfg> all)
/*     */   {
/* 262 */     String path = dir + "mzm.gsp.awardpool.confbean.SLotteryViewRandomCfg.bny";
/*     */     try
/*     */     {
/* 265 */       File file = new File(path);
/* 266 */       if (file.exists())
/*     */       {
/* 268 */         byte[] bytes = new byte['Ѐ'];
/* 269 */         FileInputStream fis = new FileInputStream(file);
/* 270 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 271 */         int len = 0;
/* 272 */         while ((len = fis.read(bytes)) > 0)
/* 273 */           baos.write(bytes, 0, len);
/* 274 */         fis.close();
/* 275 */         bytes = baos.toByteArray();
/* 276 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 277 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 279 */           _os_.unmarshal_int();
/* 280 */           _os_.unmarshal_int();
/* 281 */           _os_.unmarshal_int();
/*     */         }
/* 283 */         _os_.unmarshal_int();
/* 284 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 287 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 289 */           SLotteryViewRandomCfg _v_ = new SLotteryViewRandomCfg();
/* 290 */           _v_.unmarshal(_os_);
/* 291 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 292 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 297 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 302 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SLotteryViewRandomCfg getOld(int key)
/*     */   {
/* 310 */     return (SLotteryViewRandomCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SLotteryViewRandomCfg get(int key)
/*     */   {
/* 315 */     return (SLotteryViewRandomCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLotteryViewRandomCfg> getOldAll()
/*     */   {
/* 320 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLotteryViewRandomCfg> getAll()
/*     */   {
/* 325 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SLotteryViewRandomCfg> newAll)
/*     */   {
/* 330 */     oldAll = all;
/* 331 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 336 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\confbean\SLotteryViewRandomCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */