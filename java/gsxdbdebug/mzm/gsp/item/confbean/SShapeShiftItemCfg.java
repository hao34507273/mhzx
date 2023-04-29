/*     */ package mzm.gsp.item.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SShapeShiftItemCfg extends SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SShapeShiftItemCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SShapeShiftItemCfg> all = null;
/*     */   
/*     */   public int useLevelMax;
/*     */   public int awardType;
/*     */   public int rewardCfgid;
/*  22 */   public java.util.ArrayList<Integer> buffIds = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  26 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  27 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  28 */     this.name = rootElement.attributeValue("name");
/*  29 */     this.namecolor = Integer.valueOf(rootElement.attributeValue("namecolor")).intValue();
/*  30 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  31 */     this.pilemax = Integer.valueOf(rootElement.attributeValue("pilemax")).intValue();
/*  32 */     this.sellSilver = Integer.valueOf(rootElement.attributeValue("sellSilver")).intValue();
/*  33 */     this.isProprietary = Boolean.valueOf(rootElement.attributeValue("isProprietary")).booleanValue();
/*  34 */     this.canSellAndThrow = Boolean.valueOf(rootElement.attributeValue("canSellAndThrow")).booleanValue();
/*  35 */     this.awardRoleLevelMin = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMin")).intValue();
/*  36 */     this.awardRoleLevelMax = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMax")).intValue();
/*  37 */     this.useLevel = Integer.valueOf(rootElement.attributeValue("useLevel")).intValue();
/*  38 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*  39 */     this.useLevelMax = Integer.valueOf(rootElement.attributeValue("useLevelMax")).intValue();
/*  40 */     this.awardType = Integer.valueOf(rootElement.attributeValue("awardType")).intValue();
/*  41 */     this.rewardCfgid = Integer.valueOf(rootElement.attributeValue("rewardCfgid")).intValue();
/*     */     
/*  43 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "buffIds");
/*  44 */     if (collectionElement == null)
/*     */     {
/*  46 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  49 */     List<?> _nodeList = collectionElement.elements();
/*  50 */     int _len = _nodeList.size();
/*  51 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  53 */       Element elem = (Element)_nodeList.get(i);
/*  54 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  61 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  68 */         this.buffIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _os_.marshal(this.id);
/*  76 */     _os_.marshal(this.type);
/*  77 */     _os_.marshal(this.name, "UTF-8");
/*  78 */     _os_.marshal(this.namecolor);
/*  79 */     _os_.marshal(this.icon);
/*  80 */     _os_.marshal(this.pilemax);
/*  81 */     _os_.marshal(this.sellSilver);
/*  82 */     _os_.marshal(this.isProprietary);
/*  83 */     _os_.marshal(this.canSellAndThrow);
/*  84 */     _os_.marshal(this.awardRoleLevelMin);
/*  85 */     _os_.marshal(this.awardRoleLevelMax);
/*  86 */     _os_.marshal(this.useLevel);
/*  87 */     _os_.marshal(this.sort);
/*  88 */     _os_.marshal(this.useLevelMax);
/*  89 */     _os_.marshal(this.awardType);
/*  90 */     _os_.marshal(this.rewardCfgid);
/*  91 */     _os_.compact_uint32(this.buffIds.size());
/*  92 */     for (Integer _v_ : this.buffIds)
/*     */     {
/*  94 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  96 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 101 */     this.id = _os_.unmarshal_int();
/* 102 */     this.type = _os_.unmarshal_int();
/* 103 */     this.name = _os_.unmarshal_String("UTF-8");
/* 104 */     this.namecolor = _os_.unmarshal_int();
/* 105 */     this.icon = _os_.unmarshal_int();
/* 106 */     this.pilemax = _os_.unmarshal_int();
/* 107 */     this.sellSilver = _os_.unmarshal_int();
/* 108 */     this.isProprietary = _os_.unmarshal_boolean();
/* 109 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/* 110 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/* 111 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/* 112 */     this.useLevel = _os_.unmarshal_int();
/* 113 */     this.sort = _os_.unmarshal_int();
/* 114 */     this.useLevelMax = _os_.unmarshal_int();
/* 115 */     this.awardType = _os_.unmarshal_int();
/* 116 */     this.rewardCfgid = _os_.unmarshal_int();
/* 117 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 120 */       int _v_ = _os_.unmarshal_int();
/* 121 */       this.buffIds.add(Integer.valueOf(_v_));
/*     */     }
/* 123 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 128 */     String path = dir + "mzm.gsp.item.confbean.SShapeShiftItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 132 */       all = new java.util.HashMap();
/* 133 */       SAXReader reader = new SAXReader();
/* 134 */       org.dom4j.Document doc = reader.read(new File(path));
/* 135 */       Element root = doc.getRootElement();
/* 136 */       List<?> nodeList = root.elements();
/* 137 */       int len = nodeList.size();
/* 138 */       for (int i = 0; i < len; i++)
/*     */       {
/* 140 */         Element elem = (Element)nodeList.get(i);
/* 141 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SShapeShiftItemCfg"))
/*     */         {
/*     */ 
/* 144 */           SShapeShiftItemCfg obj = new SShapeShiftItemCfg();
/* 145 */           obj.loadFromXml(elem);
/* 146 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 147 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 152 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SShapeShiftItemCfg> all)
/*     */   {
/* 158 */     String path = dir + "mzm.gsp.item.confbean.SShapeShiftItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 162 */       SAXReader reader = new SAXReader();
/* 163 */       org.dom4j.Document doc = reader.read(new File(path));
/* 164 */       Element root = doc.getRootElement();
/* 165 */       List<?> nodeList = root.elements();
/* 166 */       int len = nodeList.size();
/* 167 */       for (int i = 0; i < len; i++)
/*     */       {
/* 169 */         Element elem = (Element)nodeList.get(i);
/* 170 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SShapeShiftItemCfg"))
/*     */         {
/*     */ 
/* 173 */           SShapeShiftItemCfg obj = new SShapeShiftItemCfg();
/* 174 */           obj.loadFromXml(elem);
/* 175 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 176 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 181 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 187 */     all = new java.util.HashMap();
/*     */     
/* 189 */     String path = dir + "mzm.gsp.item.confbean.SShapeShiftItemCfg.bny";
/*     */     try
/*     */     {
/* 192 */       File file = new File(path);
/* 193 */       if (file.exists())
/*     */       {
/* 195 */         byte[] bytes = new byte['Ѐ'];
/* 196 */         FileInputStream fis = new FileInputStream(file);
/* 197 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 198 */         int len = 0;
/* 199 */         while ((len = fis.read(bytes)) > 0)
/* 200 */           baos.write(bytes, 0, len);
/* 201 */         fis.close();
/* 202 */         bytes = baos.toByteArray();
/* 203 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 204 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 206 */           _os_.unmarshal_int();
/* 207 */           _os_.unmarshal_int();
/* 208 */           _os_.unmarshal_int();
/*     */         }
/* 210 */         _os_.unmarshal_int();
/* 211 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 214 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 216 */           SShapeShiftItemCfg _v_ = new SShapeShiftItemCfg();
/* 217 */           _v_.unmarshal(_os_);
/* 218 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 219 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 224 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 229 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SShapeShiftItemCfg> all)
/*     */   {
/* 236 */     String path = dir + "mzm.gsp.item.confbean.SShapeShiftItemCfg.bny";
/*     */     try
/*     */     {
/* 239 */       File file = new File(path);
/* 240 */       if (file.exists())
/*     */       {
/* 242 */         byte[] bytes = new byte['Ѐ'];
/* 243 */         FileInputStream fis = new FileInputStream(file);
/* 244 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 245 */         int len = 0;
/* 246 */         while ((len = fis.read(bytes)) > 0)
/* 247 */           baos.write(bytes, 0, len);
/* 248 */         fis.close();
/* 249 */         bytes = baos.toByteArray();
/* 250 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 251 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 253 */           _os_.unmarshal_int();
/* 254 */           _os_.unmarshal_int();
/* 255 */           _os_.unmarshal_int();
/*     */         }
/* 257 */         _os_.unmarshal_int();
/* 258 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 261 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 263 */           SShapeShiftItemCfg _v_ = new SShapeShiftItemCfg();
/* 264 */           _v_.unmarshal(_os_);
/* 265 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 266 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 271 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 276 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 282 */     for (Map.Entry<Integer, SShapeShiftItemCfg> entry : all.entrySet())
/*     */     {
/* 284 */       if (SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 286 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 290 */       SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SShapeShiftItemCfg> all, Map<Integer, SItemCfg> parent)
/*     */   {
/* 297 */     for (Map.Entry<Integer, SShapeShiftItemCfg> entry : all.entrySet())
/*     */     {
/* 299 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 301 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 305 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SShapeShiftItemCfg getOld(int key)
/*     */   {
/* 312 */     return (SShapeShiftItemCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SShapeShiftItemCfg get(int key)
/*     */   {
/* 317 */     return (SShapeShiftItemCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SShapeShiftItemCfg> getOldAllSelf()
/*     */   {
/* 322 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SShapeShiftItemCfg> getAllSelf()
/*     */   {
/* 327 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SShapeShiftItemCfg> newAll)
/*     */   {
/* 332 */     oldAll = all;
/* 333 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 338 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SShapeShiftItemCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */