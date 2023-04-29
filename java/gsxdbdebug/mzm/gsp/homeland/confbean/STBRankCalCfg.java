/*     */ package mzm.gsp.homeland.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class STBRankCalCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STBRankCalCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STBRankCalCfg> all = null;
/*     */   
/*     */   public int rank;
/*     */   public int scoreLow;
/*     */   public int scoreHigh;
/*     */   public int dishesController;
/*     */   public int deshesLibId;
/*  23 */   public ArrayList<Integer> mapItemCfgIds = new ArrayList();
/*  24 */   public ArrayList<Integer> controllerIds = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  28 */     this.rank = Integer.valueOf(rootElement.attributeValue("rank")).intValue();
/*  29 */     this.scoreLow = Integer.valueOf(rootElement.attributeValue("scoreLow")).intValue();
/*  30 */     this.scoreHigh = Integer.valueOf(rootElement.attributeValue("scoreHigh")).intValue();
/*  31 */     this.dishesController = Integer.valueOf(rootElement.attributeValue("dishesController")).intValue();
/*  32 */     this.deshesLibId = Integer.valueOf(rootElement.attributeValue("deshesLibId")).intValue();
/*     */     
/*  34 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "mapItemCfgIds");
/*  35 */     if (collectionElement == null)
/*     */     {
/*  37 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  40 */     List<?> _nodeList = collectionElement.elements();
/*  41 */     int _len = _nodeList.size();
/*  42 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  44 */       Element elem = (Element)_nodeList.get(i);
/*  45 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  52 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  59 */         this.mapItemCfgIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  63 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "controllerIds");
/*  64 */     if (collectionElement == null)
/*     */     {
/*  66 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  69 */     List<?> _nodeList = collectionElement.elements();
/*  70 */     int _len = _nodeList.size();
/*  71 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  73 */       Element elem = (Element)_nodeList.get(i);
/*  74 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  81 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  88 */         this.controllerIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  95 */     _os_.marshal(this.rank);
/*  96 */     _os_.marshal(this.scoreLow);
/*  97 */     _os_.marshal(this.scoreHigh);
/*  98 */     _os_.marshal(this.dishesController);
/*  99 */     _os_.marshal(this.deshesLibId);
/* 100 */     _os_.compact_uint32(this.mapItemCfgIds.size());
/* 101 */     for (Integer _v_ : this.mapItemCfgIds)
/*     */     {
/* 103 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 105 */     _os_.compact_uint32(this.controllerIds.size());
/* 106 */     for (Integer _v_ : this.controllerIds)
/*     */     {
/* 108 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 110 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 115 */     this.rank = _os_.unmarshal_int();
/* 116 */     this.scoreLow = _os_.unmarshal_int();
/* 117 */     this.scoreHigh = _os_.unmarshal_int();
/* 118 */     this.dishesController = _os_.unmarshal_int();
/* 119 */     this.deshesLibId = _os_.unmarshal_int();
/* 120 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 123 */       int _v_ = _os_.unmarshal_int();
/* 124 */       this.mapItemCfgIds.add(Integer.valueOf(_v_));
/*     */     }
/* 126 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 129 */       int _v_ = _os_.unmarshal_int();
/* 130 */       this.controllerIds.add(Integer.valueOf(_v_));
/*     */     }
/* 132 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 137 */     String path = dir + "mzm.gsp.homeland.confbean.STBRankCalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 141 */       all = new java.util.HashMap();
/* 142 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 143 */       org.dom4j.Document doc = reader.read(new File(path));
/* 144 */       Element root = doc.getRootElement();
/* 145 */       List<?> nodeList = root.elements();
/* 146 */       int len = nodeList.size();
/* 147 */       for (int i = 0; i < len; i++)
/*     */       {
/* 149 */         Element elem = (Element)nodeList.get(i);
/* 150 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.STBRankCalCfg"))
/*     */         {
/*     */ 
/* 153 */           STBRankCalCfg obj = new STBRankCalCfg();
/* 154 */           obj.loadFromXml(elem);
/* 155 */           if (all.put(Integer.valueOf(obj.rank), obj) != null) {
/* 156 */             throw new RuntimeException("duplicate key : " + obj.rank);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 161 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STBRankCalCfg> all)
/*     */   {
/* 167 */     String path = dir + "mzm.gsp.homeland.confbean.STBRankCalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 171 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 172 */       org.dom4j.Document doc = reader.read(new File(path));
/* 173 */       Element root = doc.getRootElement();
/* 174 */       List<?> nodeList = root.elements();
/* 175 */       int len = nodeList.size();
/* 176 */       for (int i = 0; i < len; i++)
/*     */       {
/* 178 */         Element elem = (Element)nodeList.get(i);
/* 179 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.STBRankCalCfg"))
/*     */         {
/*     */ 
/* 182 */           STBRankCalCfg obj = new STBRankCalCfg();
/* 183 */           obj.loadFromXml(elem);
/* 184 */           if (all.put(Integer.valueOf(obj.rank), obj) != null) {
/* 185 */             throw new RuntimeException("duplicate key : " + obj.rank);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 190 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 196 */     all = new java.util.HashMap();
/*     */     
/* 198 */     String path = dir + "mzm.gsp.homeland.confbean.STBRankCalCfg.bny";
/*     */     try
/*     */     {
/* 201 */       File file = new File(path);
/* 202 */       if (file.exists())
/*     */       {
/* 204 */         byte[] bytes = new byte['Ѐ'];
/* 205 */         FileInputStream fis = new FileInputStream(file);
/* 206 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 207 */         int len = 0;
/* 208 */         while ((len = fis.read(bytes)) > 0)
/* 209 */           baos.write(bytes, 0, len);
/* 210 */         fis.close();
/* 211 */         bytes = baos.toByteArray();
/* 212 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 213 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 215 */           _os_.unmarshal_int();
/* 216 */           _os_.unmarshal_int();
/* 217 */           _os_.unmarshal_int();
/*     */         }
/* 219 */         _os_.unmarshal_int();
/* 220 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 223 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 225 */           STBRankCalCfg _v_ = new STBRankCalCfg();
/* 226 */           _v_.unmarshal(_os_);
/* 227 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 228 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 233 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 238 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STBRankCalCfg> all)
/*     */   {
/* 245 */     String path = dir + "mzm.gsp.homeland.confbean.STBRankCalCfg.bny";
/*     */     try
/*     */     {
/* 248 */       File file = new File(path);
/* 249 */       if (file.exists())
/*     */       {
/* 251 */         byte[] bytes = new byte['Ѐ'];
/* 252 */         FileInputStream fis = new FileInputStream(file);
/* 253 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 254 */         int len = 0;
/* 255 */         while ((len = fis.read(bytes)) > 0)
/* 256 */           baos.write(bytes, 0, len);
/* 257 */         fis.close();
/* 258 */         bytes = baos.toByteArray();
/* 259 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 260 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 262 */           _os_.unmarshal_int();
/* 263 */           _os_.unmarshal_int();
/* 264 */           _os_.unmarshal_int();
/*     */         }
/* 266 */         _os_.unmarshal_int();
/* 267 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 270 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 272 */           STBRankCalCfg _v_ = new STBRankCalCfg();
/* 273 */           _v_.unmarshal(_os_);
/* 274 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 275 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 280 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 285 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STBRankCalCfg getOld(int key)
/*     */   {
/* 293 */     return (STBRankCalCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STBRankCalCfg get(int key)
/*     */   {
/* 298 */     return (STBRankCalCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STBRankCalCfg> getOldAll()
/*     */   {
/* 303 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STBRankCalCfg> getAll()
/*     */   {
/* 308 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STBRankCalCfg> newAll)
/*     */   {
/* 313 */     oldAll = all;
/* 314 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 319 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\confbean\STBRankCalCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */