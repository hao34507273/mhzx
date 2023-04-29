/*     */ package mzm.gsp.fabao.confbean;
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
/*     */ public class SFabaoTempAttributeCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SFabaoTempAttributeCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SFabaoTempAttributeCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int proClassid;
/*     */   public int lv;
/*     */   public int color;
/*  22 */   public HashMap<Integer, Integer> proMap = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  26 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  27 */     this.proClassid = Integer.valueOf(rootElement.attributeValue("proClassid")).intValue();
/*  28 */     this.lv = Integer.valueOf(rootElement.attributeValue("lv")).intValue();
/*  29 */     this.color = Integer.valueOf(rootElement.attributeValue("color")).intValue();
/*     */     
/*  31 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "proMap");
/*  32 */     if (mapTypeElement == null)
/*     */     {
/*  34 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  37 */     List<?> entryNodeList = mapTypeElement.elements();
/*  38 */     int entryLen = entryNodeList.size();
/*  39 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  41 */       Element entryElement = (Element)entryNodeList.get(i);
/*  42 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  47 */         Element keyElem = null;
/*  48 */         Element valueElem = null;
/*     */         
/*  50 */         List<?> _nodeList = entryElement.elements();
/*  51 */         int _len = _nodeList.size();
/*  52 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  54 */           Element elem = (Element)_nodeList.get(j);
/*  55 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  57 */             keyElem = elem;
/*     */           }
/*  59 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  61 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  65 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  67 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  74 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  75 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  82 */         this.proMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  89 */     _os_.marshal(this.id);
/*  90 */     _os_.marshal(this.proClassid);
/*  91 */     _os_.marshal(this.lv);
/*  92 */     _os_.marshal(this.color);
/*  93 */     _os_.compact_uint32(this.proMap.size());
/*  94 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.proMap.entrySet())
/*     */     {
/*  96 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  97 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  99 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 104 */     this.id = _os_.unmarshal_int();
/* 105 */     this.proClassid = _os_.unmarshal_int();
/* 106 */     this.lv = _os_.unmarshal_int();
/* 107 */     this.color = _os_.unmarshal_int();
/* 108 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 111 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 113 */       int _v_ = _os_.unmarshal_int();
/* 114 */       this.proMap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 116 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 121 */     String path = dir + "mzm.gsp.fabao.confbean.SFabaoTempAttributeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 125 */       all = new HashMap();
/* 126 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 127 */       org.dom4j.Document doc = reader.read(new File(path));
/* 128 */       Element root = doc.getRootElement();
/* 129 */       List<?> nodeList = root.elements();
/* 130 */       int len = nodeList.size();
/* 131 */       for (int i = 0; i < len; i++)
/*     */       {
/* 133 */         Element elem = (Element)nodeList.get(i);
/* 134 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.fabao.confbean.SFabaoTempAttributeCfg"))
/*     */         {
/*     */ 
/* 137 */           SFabaoTempAttributeCfg obj = new SFabaoTempAttributeCfg();
/* 138 */           obj.loadFromXml(elem);
/* 139 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 140 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 145 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFabaoTempAttributeCfg> all)
/*     */   {
/* 151 */     String path = dir + "mzm.gsp.fabao.confbean.SFabaoTempAttributeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 155 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 156 */       org.dom4j.Document doc = reader.read(new File(path));
/* 157 */       Element root = doc.getRootElement();
/* 158 */       List<?> nodeList = root.elements();
/* 159 */       int len = nodeList.size();
/* 160 */       for (int i = 0; i < len; i++)
/*     */       {
/* 162 */         Element elem = (Element)nodeList.get(i);
/* 163 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.fabao.confbean.SFabaoTempAttributeCfg"))
/*     */         {
/*     */ 
/* 166 */           SFabaoTempAttributeCfg obj = new SFabaoTempAttributeCfg();
/* 167 */           obj.loadFromXml(elem);
/* 168 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 169 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 174 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 180 */     all = new HashMap();
/*     */     
/* 182 */     String path = dir + "mzm.gsp.fabao.confbean.SFabaoTempAttributeCfg.bny";
/*     */     try
/*     */     {
/* 185 */       File file = new File(path);
/* 186 */       if (file.exists())
/*     */       {
/* 188 */         byte[] bytes = new byte['Ѐ'];
/* 189 */         FileInputStream fis = new FileInputStream(file);
/* 190 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 191 */         int len = 0;
/* 192 */         while ((len = fis.read(bytes)) > 0)
/* 193 */           baos.write(bytes, 0, len);
/* 194 */         fis.close();
/* 195 */         bytes = baos.toByteArray();
/* 196 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 197 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 199 */           _os_.unmarshal_int();
/* 200 */           _os_.unmarshal_int();
/* 201 */           _os_.unmarshal_int();
/*     */         }
/* 203 */         _os_.unmarshal_int();
/* 204 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 207 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 209 */           SFabaoTempAttributeCfg _v_ = new SFabaoTempAttributeCfg();
/* 210 */           _v_.unmarshal(_os_);
/* 211 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 212 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 217 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 222 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFabaoTempAttributeCfg> all)
/*     */   {
/* 229 */     String path = dir + "mzm.gsp.fabao.confbean.SFabaoTempAttributeCfg.bny";
/*     */     try
/*     */     {
/* 232 */       File file = new File(path);
/* 233 */       if (file.exists())
/*     */       {
/* 235 */         byte[] bytes = new byte['Ѐ'];
/* 236 */         FileInputStream fis = new FileInputStream(file);
/* 237 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 238 */         int len = 0;
/* 239 */         while ((len = fis.read(bytes)) > 0)
/* 240 */           baos.write(bytes, 0, len);
/* 241 */         fis.close();
/* 242 */         bytes = baos.toByteArray();
/* 243 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 244 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 246 */           _os_.unmarshal_int();
/* 247 */           _os_.unmarshal_int();
/* 248 */           _os_.unmarshal_int();
/*     */         }
/* 250 */         _os_.unmarshal_int();
/* 251 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 254 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 256 */           SFabaoTempAttributeCfg _v_ = new SFabaoTempAttributeCfg();
/* 257 */           _v_.unmarshal(_os_);
/* 258 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 259 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 264 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 269 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SFabaoTempAttributeCfg getOld(int key)
/*     */   {
/* 277 */     return (SFabaoTempAttributeCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFabaoTempAttributeCfg get(int key)
/*     */   {
/* 282 */     return (SFabaoTempAttributeCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFabaoTempAttributeCfg> getOldAll()
/*     */   {
/* 287 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFabaoTempAttributeCfg> getAll()
/*     */   {
/* 292 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFabaoTempAttributeCfg> newAll)
/*     */   {
/* 297 */     oldAll = all;
/* 298 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 303 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\confbean\SFabaoTempAttributeCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */