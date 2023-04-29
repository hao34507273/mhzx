/*     */ package mzm.gsp.midautumnholiday.confbean;
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
/*     */ public class SOriginalComposeCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SOriginalComposeCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SOriginalComposeCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int groupId;
/*     */   public int createItemId;
/*     */   public int createItemNum;
/*     */   public int isBind;
/*  23 */   public HashMap<Integer, Integer> costItemId2costItemNum = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  28 */     this.groupId = Integer.valueOf(rootElement.attributeValue("groupId")).intValue();
/*  29 */     this.createItemId = Integer.valueOf(rootElement.attributeValue("createItemId")).intValue();
/*  30 */     this.createItemNum = Integer.valueOf(rootElement.attributeValue("createItemNum")).intValue();
/*  31 */     this.isBind = Integer.valueOf(rootElement.attributeValue("isBind")).intValue();
/*     */     
/*  33 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "costItemId2costItemNum");
/*  34 */     if (mapTypeElement == null)
/*     */     {
/*  36 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  39 */     List<?> entryNodeList = mapTypeElement.elements();
/*  40 */     int entryLen = entryNodeList.size();
/*  41 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  43 */       Element entryElement = (Element)entryNodeList.get(i);
/*  44 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  49 */         Element keyElem = null;
/*  50 */         Element valueElem = null;
/*     */         
/*  52 */         List<?> _nodeList = entryElement.elements();
/*  53 */         int _len = _nodeList.size();
/*  54 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  56 */           Element elem = (Element)_nodeList.get(j);
/*  57 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  59 */             keyElem = elem;
/*     */           }
/*  61 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  63 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  67 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  69 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  76 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  77 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  84 */         this.costItemId2costItemNum.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  91 */     _os_.marshal(this.id);
/*  92 */     _os_.marshal(this.groupId);
/*  93 */     _os_.marshal(this.createItemId);
/*  94 */     _os_.marshal(this.createItemNum);
/*  95 */     _os_.marshal(this.isBind);
/*  96 */     _os_.compact_uint32(this.costItemId2costItemNum.size());
/*  97 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.costItemId2costItemNum.entrySet())
/*     */     {
/*  99 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 100 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 107 */     this.id = _os_.unmarshal_int();
/* 108 */     this.groupId = _os_.unmarshal_int();
/* 109 */     this.createItemId = _os_.unmarshal_int();
/* 110 */     this.createItemNum = _os_.unmarshal_int();
/* 111 */     this.isBind = _os_.unmarshal_int();
/* 112 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 115 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 117 */       int _v_ = _os_.unmarshal_int();
/* 118 */       this.costItemId2costItemNum.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 120 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 125 */     String path = dir + "mzm.gsp.midautumnholiday.confbean.SOriginalComposeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 129 */       all = new HashMap();
/* 130 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 131 */       org.dom4j.Document doc = reader.read(new File(path));
/* 132 */       Element root = doc.getRootElement();
/* 133 */       List<?> nodeList = root.elements();
/* 134 */       int len = nodeList.size();
/* 135 */       for (int i = 0; i < len; i++)
/*     */       {
/* 137 */         Element elem = (Element)nodeList.get(i);
/* 138 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.midautumnholiday.confbean.SOriginalComposeCfg"))
/*     */         {
/*     */ 
/* 141 */           SOriginalComposeCfg obj = new SOriginalComposeCfg();
/* 142 */           obj.loadFromXml(elem);
/* 143 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 144 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 149 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SOriginalComposeCfg> all)
/*     */   {
/* 155 */     String path = dir + "mzm.gsp.midautumnholiday.confbean.SOriginalComposeCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 159 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 160 */       org.dom4j.Document doc = reader.read(new File(path));
/* 161 */       Element root = doc.getRootElement();
/* 162 */       List<?> nodeList = root.elements();
/* 163 */       int len = nodeList.size();
/* 164 */       for (int i = 0; i < len; i++)
/*     */       {
/* 166 */         Element elem = (Element)nodeList.get(i);
/* 167 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.midautumnholiday.confbean.SOriginalComposeCfg"))
/*     */         {
/*     */ 
/* 170 */           SOriginalComposeCfg obj = new SOriginalComposeCfg();
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
/*     */   public static void loadBny(String dir)
/*     */   {
/* 184 */     all = new HashMap();
/*     */     
/* 186 */     String path = dir + "mzm.gsp.midautumnholiday.confbean.SOriginalComposeCfg.bny";
/*     */     try
/*     */     {
/* 189 */       File file = new File(path);
/* 190 */       if (file.exists())
/*     */       {
/* 192 */         byte[] bytes = new byte['Ѐ'];
/* 193 */         FileInputStream fis = new FileInputStream(file);
/* 194 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 195 */         int len = 0;
/* 196 */         while ((len = fis.read(bytes)) > 0)
/* 197 */           baos.write(bytes, 0, len);
/* 198 */         fis.close();
/* 199 */         bytes = baos.toByteArray();
/* 200 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 201 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 203 */           _os_.unmarshal_int();
/* 204 */           _os_.unmarshal_int();
/* 205 */           _os_.unmarshal_int();
/*     */         }
/* 207 */         _os_.unmarshal_int();
/* 208 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 211 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 213 */           SOriginalComposeCfg _v_ = new SOriginalComposeCfg();
/* 214 */           _v_.unmarshal(_os_);
/* 215 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 216 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 221 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 226 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SOriginalComposeCfg> all)
/*     */   {
/* 233 */     String path = dir + "mzm.gsp.midautumnholiday.confbean.SOriginalComposeCfg.bny";
/*     */     try
/*     */     {
/* 236 */       File file = new File(path);
/* 237 */       if (file.exists())
/*     */       {
/* 239 */         byte[] bytes = new byte['Ѐ'];
/* 240 */         FileInputStream fis = new FileInputStream(file);
/* 241 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 242 */         int len = 0;
/* 243 */         while ((len = fis.read(bytes)) > 0)
/* 244 */           baos.write(bytes, 0, len);
/* 245 */         fis.close();
/* 246 */         bytes = baos.toByteArray();
/* 247 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 248 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 250 */           _os_.unmarshal_int();
/* 251 */           _os_.unmarshal_int();
/* 252 */           _os_.unmarshal_int();
/*     */         }
/* 254 */         _os_.unmarshal_int();
/* 255 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 258 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 260 */           SOriginalComposeCfg _v_ = new SOriginalComposeCfg();
/* 261 */           _v_.unmarshal(_os_);
/* 262 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 263 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 268 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 273 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SOriginalComposeCfg getOld(int key)
/*     */   {
/* 281 */     return (SOriginalComposeCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SOriginalComposeCfg get(int key)
/*     */   {
/* 286 */     return (SOriginalComposeCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOriginalComposeCfg> getOldAll()
/*     */   {
/* 291 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SOriginalComposeCfg> getAll()
/*     */   {
/* 296 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SOriginalComposeCfg> newAll)
/*     */   {
/* 301 */     oldAll = all;
/* 302 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 307 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\midautumnholiday\confbean\SOriginalComposeCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */