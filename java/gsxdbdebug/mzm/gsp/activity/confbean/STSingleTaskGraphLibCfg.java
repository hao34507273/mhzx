/*     */ package mzm.gsp.activity.confbean;
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
/*     */ public class STSingleTaskGraphLibCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, STSingleTaskGraphLibCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, STSingleTaskGraphLibCfg> all = null;
/*     */   
/*     */   public int graphLibId;
/*     */   public int weightSum;
/*  20 */   public HashMap<Integer, Integer> graphId2weight = new HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.graphLibId = Integer.valueOf(rootElement.attributeValue("graphLibId")).intValue();
/*  25 */     this.weightSum = Integer.valueOf(rootElement.attributeValue("weightSum")).intValue();
/*     */     
/*  27 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "graphId2weight");
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
/*  78 */         this.graphId2weight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  85 */     _os_.marshal(this.graphLibId);
/*  86 */     _os_.marshal(this.weightSum);
/*  87 */     _os_.compact_uint32(this.graphId2weight.size());
/*  88 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.graphId2weight.entrySet())
/*     */     {
/*  90 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  91 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  98 */     this.graphLibId = _os_.unmarshal_int();
/*  99 */     this.weightSum = _os_.unmarshal_int();
/* 100 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 103 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 105 */       int _v_ = _os_.unmarshal_int();
/* 106 */       this.graphId2weight.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 108 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 113 */     String path = dir + "mzm.gsp.activity.confbean.STSingleTaskGraphLibCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 117 */       all = new HashMap();
/* 118 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 119 */       org.dom4j.Document doc = reader.read(new File(path));
/* 120 */       Element root = doc.getRootElement();
/* 121 */       List<?> nodeList = root.elements();
/* 122 */       int len = nodeList.size();
/* 123 */       for (int i = 0; i < len; i++)
/*     */       {
/* 125 */         Element elem = (Element)nodeList.get(i);
/* 126 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity.confbean.STSingleTaskGraphLibCfg"))
/*     */         {
/*     */ 
/* 129 */           STSingleTaskGraphLibCfg obj = new STSingleTaskGraphLibCfg();
/* 130 */           obj.loadFromXml(elem);
/* 131 */           if (all.put(Integer.valueOf(obj.graphLibId), obj) != null) {
/* 132 */             throw new RuntimeException("duplicate key : " + obj.graphLibId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 137 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STSingleTaskGraphLibCfg> all)
/*     */   {
/* 143 */     String path = dir + "mzm.gsp.activity.confbean.STSingleTaskGraphLibCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 147 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 148 */       org.dom4j.Document doc = reader.read(new File(path));
/* 149 */       Element root = doc.getRootElement();
/* 150 */       List<?> nodeList = root.elements();
/* 151 */       int len = nodeList.size();
/* 152 */       for (int i = 0; i < len; i++)
/*     */       {
/* 154 */         Element elem = (Element)nodeList.get(i);
/* 155 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity.confbean.STSingleTaskGraphLibCfg"))
/*     */         {
/*     */ 
/* 158 */           STSingleTaskGraphLibCfg obj = new STSingleTaskGraphLibCfg();
/* 159 */           obj.loadFromXml(elem);
/* 160 */           if (all.put(Integer.valueOf(obj.graphLibId), obj) != null) {
/* 161 */             throw new RuntimeException("duplicate key : " + obj.graphLibId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 166 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 172 */     all = new HashMap();
/*     */     
/* 174 */     String path = dir + "mzm.gsp.activity.confbean.STSingleTaskGraphLibCfg.bny";
/*     */     try
/*     */     {
/* 177 */       File file = new File(path);
/* 178 */       if (file.exists())
/*     */       {
/* 180 */         byte[] bytes = new byte['Ѐ'];
/* 181 */         FileInputStream fis = new FileInputStream(file);
/* 182 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 183 */         int len = 0;
/* 184 */         while ((len = fis.read(bytes)) > 0)
/* 185 */           baos.write(bytes, 0, len);
/* 186 */         fis.close();
/* 187 */         bytes = baos.toByteArray();
/* 188 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 189 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 191 */           _os_.unmarshal_int();
/* 192 */           _os_.unmarshal_int();
/* 193 */           _os_.unmarshal_int();
/*     */         }
/* 195 */         _os_.unmarshal_int();
/* 196 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 199 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 201 */           STSingleTaskGraphLibCfg _v_ = new STSingleTaskGraphLibCfg();
/* 202 */           _v_.unmarshal(_os_);
/* 203 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 204 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 209 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 214 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STSingleTaskGraphLibCfg> all)
/*     */   {
/* 221 */     String path = dir + "mzm.gsp.activity.confbean.STSingleTaskGraphLibCfg.bny";
/*     */     try
/*     */     {
/* 224 */       File file = new File(path);
/* 225 */       if (file.exists())
/*     */       {
/* 227 */         byte[] bytes = new byte['Ѐ'];
/* 228 */         FileInputStream fis = new FileInputStream(file);
/* 229 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 230 */         int len = 0;
/* 231 */         while ((len = fis.read(bytes)) > 0)
/* 232 */           baos.write(bytes, 0, len);
/* 233 */         fis.close();
/* 234 */         bytes = baos.toByteArray();
/* 235 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 236 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 238 */           _os_.unmarshal_int();
/* 239 */           _os_.unmarshal_int();
/* 240 */           _os_.unmarshal_int();
/*     */         }
/* 242 */         _os_.unmarshal_int();
/* 243 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 246 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 248 */           STSingleTaskGraphLibCfg _v_ = new STSingleTaskGraphLibCfg();
/* 249 */           _v_.unmarshal(_os_);
/* 250 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 251 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 256 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 261 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static STSingleTaskGraphLibCfg getOld(int key)
/*     */   {
/* 269 */     return (STSingleTaskGraphLibCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STSingleTaskGraphLibCfg get(int key)
/*     */   {
/* 274 */     return (STSingleTaskGraphLibCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STSingleTaskGraphLibCfg> getOldAll()
/*     */   {
/* 279 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STSingleTaskGraphLibCfg> getAll()
/*     */   {
/* 284 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STSingleTaskGraphLibCfg> newAll)
/*     */   {
/* 289 */     oldAll = all;
/* 290 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 295 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\STSingleTaskGraphLibCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */