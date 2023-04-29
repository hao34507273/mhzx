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
/*     */ public class SAwardTypeId2ItemSubId implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SAwardTypeId2ItemSubId> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SAwardTypeId2ItemSubId> all = null;
/*     */   
/*     */   public int awardTypeId;
/*  19 */   public HashMap<Integer, Integer> bagId2MaxNeedGrid = new HashMap();
/*  20 */   public java.util.ArrayList<Integer> itemSubIds = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.awardTypeId = Integer.valueOf(rootElement.attributeValue("awardTypeId")).intValue();
/*     */     
/*  26 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "bagId2MaxNeedGrid");
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
/*  77 */         this.bagId2MaxNeedGrid.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  81 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "itemSubIds");
/*  82 */     if (collectionElement == null)
/*     */     {
/*  84 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  87 */     List<?> _nodeList = collectionElement.elements();
/*  88 */     int _len = _nodeList.size();
/*  89 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  91 */       Element elem = (Element)_nodeList.get(i);
/*  92 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  99 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 106 */         this.itemSubIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 113 */     _os_.marshal(this.awardTypeId);
/* 114 */     _os_.compact_uint32(this.bagId2MaxNeedGrid.size());
/* 115 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.bagId2MaxNeedGrid.entrySet())
/*     */     {
/* 117 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 118 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 120 */     _os_.compact_uint32(this.itemSubIds.size());
/* 121 */     for (Integer _v_ : this.itemSubIds)
/*     */     {
/* 123 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 125 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 130 */     this.awardTypeId = _os_.unmarshal_int();
/* 131 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 134 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 136 */       int _v_ = _os_.unmarshal_int();
/* 137 */       this.bagId2MaxNeedGrid.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 139 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 142 */       int _v_ = _os_.unmarshal_int();
/* 143 */       this.itemSubIds.add(Integer.valueOf(_v_));
/*     */     }
/* 145 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 150 */     String path = dir + "mzm.gsp.awardpool.confbean.SAwardTypeId2ItemSubId.xml";
/*     */     
/*     */     try
/*     */     {
/* 154 */       all = new HashMap();
/* 155 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 156 */       org.dom4j.Document doc = reader.read(new File(path));
/* 157 */       Element root = doc.getRootElement();
/* 158 */       List<?> nodeList = root.elements();
/* 159 */       int len = nodeList.size();
/* 160 */       for (int i = 0; i < len; i++)
/*     */       {
/* 162 */         Element elem = (Element)nodeList.get(i);
/* 163 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.awardpool.confbean.SAwardTypeId2ItemSubId"))
/*     */         {
/*     */ 
/* 166 */           SAwardTypeId2ItemSubId obj = new SAwardTypeId2ItemSubId();
/* 167 */           obj.loadFromXml(elem);
/* 168 */           if (all.put(Integer.valueOf(obj.awardTypeId), obj) != null) {
/* 169 */             throw new RuntimeException("duplicate key : " + obj.awardTypeId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 174 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SAwardTypeId2ItemSubId> all)
/*     */   {
/* 180 */     String path = dir + "mzm.gsp.awardpool.confbean.SAwardTypeId2ItemSubId.xml";
/*     */     
/*     */     try
/*     */     {
/* 184 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 185 */       org.dom4j.Document doc = reader.read(new File(path));
/* 186 */       Element root = doc.getRootElement();
/* 187 */       List<?> nodeList = root.elements();
/* 188 */       int len = nodeList.size();
/* 189 */       for (int i = 0; i < len; i++)
/*     */       {
/* 191 */         Element elem = (Element)nodeList.get(i);
/* 192 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.awardpool.confbean.SAwardTypeId2ItemSubId"))
/*     */         {
/*     */ 
/* 195 */           SAwardTypeId2ItemSubId obj = new SAwardTypeId2ItemSubId();
/* 196 */           obj.loadFromXml(elem);
/* 197 */           if (all.put(Integer.valueOf(obj.awardTypeId), obj) != null) {
/* 198 */             throw new RuntimeException("duplicate key : " + obj.awardTypeId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 203 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 209 */     all = new HashMap();
/*     */     
/* 211 */     String path = dir + "mzm.gsp.awardpool.confbean.SAwardTypeId2ItemSubId.bny";
/*     */     try
/*     */     {
/* 214 */       File file = new File(path);
/* 215 */       if (file.exists())
/*     */       {
/* 217 */         byte[] bytes = new byte['Ѐ'];
/* 218 */         FileInputStream fis = new FileInputStream(file);
/* 219 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 220 */         int len = 0;
/* 221 */         while ((len = fis.read(bytes)) > 0)
/* 222 */           baos.write(bytes, 0, len);
/* 223 */         fis.close();
/* 224 */         bytes = baos.toByteArray();
/* 225 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 226 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 228 */           _os_.unmarshal_int();
/* 229 */           _os_.unmarshal_int();
/* 230 */           _os_.unmarshal_int();
/*     */         }
/* 232 */         _os_.unmarshal_int();
/* 233 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 236 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 238 */           SAwardTypeId2ItemSubId _v_ = new SAwardTypeId2ItemSubId();
/* 239 */           _v_.unmarshal(_os_);
/* 240 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 241 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 246 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 251 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SAwardTypeId2ItemSubId> all)
/*     */   {
/* 258 */     String path = dir + "mzm.gsp.awardpool.confbean.SAwardTypeId2ItemSubId.bny";
/*     */     try
/*     */     {
/* 261 */       File file = new File(path);
/* 262 */       if (file.exists())
/*     */       {
/* 264 */         byte[] bytes = new byte['Ѐ'];
/* 265 */         FileInputStream fis = new FileInputStream(file);
/* 266 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 267 */         int len = 0;
/* 268 */         while ((len = fis.read(bytes)) > 0)
/* 269 */           baos.write(bytes, 0, len);
/* 270 */         fis.close();
/* 271 */         bytes = baos.toByteArray();
/* 272 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 273 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 275 */           _os_.unmarshal_int();
/* 276 */           _os_.unmarshal_int();
/* 277 */           _os_.unmarshal_int();
/*     */         }
/* 279 */         _os_.unmarshal_int();
/* 280 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 283 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 285 */           SAwardTypeId2ItemSubId _v_ = new SAwardTypeId2ItemSubId();
/* 286 */           _v_.unmarshal(_os_);
/* 287 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 288 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 293 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 298 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SAwardTypeId2ItemSubId getOld(int key)
/*     */   {
/* 306 */     return (SAwardTypeId2ItemSubId)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SAwardTypeId2ItemSubId get(int key)
/*     */   {
/* 311 */     return (SAwardTypeId2ItemSubId)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAwardTypeId2ItemSubId> getOldAll()
/*     */   {
/* 316 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SAwardTypeId2ItemSubId> getAll()
/*     */   {
/* 321 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SAwardTypeId2ItemSubId> newAll)
/*     */   {
/* 326 */     oldAll = all;
/* 327 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 332 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\confbean\SAwardTypeId2ItemSubId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */