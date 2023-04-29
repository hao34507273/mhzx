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
/*     */ public class SFabaoItem extends SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SFabaoItem> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SFabaoItem> all = null;
/*     */   
/*     */   public int faobaoType;
/*     */   public int classid;
/*     */   public int rank;
/*     */   public boolean canCompose;
/*     */   public int fragmentId;
/*     */   public int fragmentCount;
/*     */   public boolean canUseYuanBao;
/*     */   public int rankId;
/*     */   public int rankExp;
/*     */   public int attrId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  33 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  34 */     this.name = rootElement.attributeValue("name");
/*  35 */     this.namecolor = Integer.valueOf(rootElement.attributeValue("namecolor")).intValue();
/*  36 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  37 */     this.pilemax = Integer.valueOf(rootElement.attributeValue("pilemax")).intValue();
/*  38 */     this.sellSilver = Integer.valueOf(rootElement.attributeValue("sellSilver")).intValue();
/*  39 */     this.isProprietary = Boolean.valueOf(rootElement.attributeValue("isProprietary")).booleanValue();
/*  40 */     this.canSellAndThrow = Boolean.valueOf(rootElement.attributeValue("canSellAndThrow")).booleanValue();
/*  41 */     this.awardRoleLevelMin = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMin")).intValue();
/*  42 */     this.awardRoleLevelMax = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMax")).intValue();
/*  43 */     this.useLevel = Integer.valueOf(rootElement.attributeValue("useLevel")).intValue();
/*  44 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*  45 */     this.faobaoType = Integer.valueOf(rootElement.attributeValue("faobaoType")).intValue();
/*  46 */     this.classid = Integer.valueOf(rootElement.attributeValue("classid")).intValue();
/*  47 */     this.rank = Integer.valueOf(rootElement.attributeValue("rank")).intValue();
/*  48 */     this.canCompose = Boolean.valueOf(rootElement.attributeValue("canCompose")).booleanValue();
/*  49 */     this.fragmentId = Integer.valueOf(rootElement.attributeValue("fragmentId")).intValue();
/*  50 */     this.fragmentCount = Integer.valueOf(rootElement.attributeValue("fragmentCount")).intValue();
/*  51 */     this.canUseYuanBao = Boolean.valueOf(rootElement.attributeValue("canUseYuanBao")).booleanValue();
/*  52 */     this.rankId = Integer.valueOf(rootElement.attributeValue("rankId")).intValue();
/*  53 */     this.rankExp = Integer.valueOf(rootElement.attributeValue("rankExp")).intValue();
/*  54 */     this.attrId = Integer.valueOf(rootElement.attributeValue("attrId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  59 */     _os_.marshal(this.id);
/*  60 */     _os_.marshal(this.type);
/*  61 */     _os_.marshal(this.name, "UTF-8");
/*  62 */     _os_.marshal(this.namecolor);
/*  63 */     _os_.marshal(this.icon);
/*  64 */     _os_.marshal(this.pilemax);
/*  65 */     _os_.marshal(this.sellSilver);
/*  66 */     _os_.marshal(this.isProprietary);
/*  67 */     _os_.marshal(this.canSellAndThrow);
/*  68 */     _os_.marshal(this.awardRoleLevelMin);
/*  69 */     _os_.marshal(this.awardRoleLevelMax);
/*  70 */     _os_.marshal(this.useLevel);
/*  71 */     _os_.marshal(this.sort);
/*  72 */     _os_.marshal(this.faobaoType);
/*  73 */     _os_.marshal(this.classid);
/*  74 */     _os_.marshal(this.rank);
/*  75 */     _os_.marshal(this.canCompose);
/*  76 */     _os_.marshal(this.fragmentId);
/*  77 */     _os_.marshal(this.fragmentCount);
/*  78 */     _os_.marshal(this.canUseYuanBao);
/*  79 */     _os_.marshal(this.rankId);
/*  80 */     _os_.marshal(this.rankExp);
/*  81 */     _os_.marshal(this.attrId);
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  87 */     this.id = _os_.unmarshal_int();
/*  88 */     this.type = _os_.unmarshal_int();
/*  89 */     this.name = _os_.unmarshal_String("UTF-8");
/*  90 */     this.namecolor = _os_.unmarshal_int();
/*  91 */     this.icon = _os_.unmarshal_int();
/*  92 */     this.pilemax = _os_.unmarshal_int();
/*  93 */     this.sellSilver = _os_.unmarshal_int();
/*  94 */     this.isProprietary = _os_.unmarshal_boolean();
/*  95 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/*  96 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/*  97 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/*  98 */     this.useLevel = _os_.unmarshal_int();
/*  99 */     this.sort = _os_.unmarshal_int();
/* 100 */     this.faobaoType = _os_.unmarshal_int();
/* 101 */     this.classid = _os_.unmarshal_int();
/* 102 */     this.rank = _os_.unmarshal_int();
/* 103 */     this.canCompose = _os_.unmarshal_boolean();
/* 104 */     this.fragmentId = _os_.unmarshal_int();
/* 105 */     this.fragmentCount = _os_.unmarshal_int();
/* 106 */     this.canUseYuanBao = _os_.unmarshal_boolean();
/* 107 */     this.rankId = _os_.unmarshal_int();
/* 108 */     this.rankExp = _os_.unmarshal_int();
/* 109 */     this.attrId = _os_.unmarshal_int();
/* 110 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 115 */     String path = dir + "mzm.gsp.item.confbean.SFabaoItem.xml";
/*     */     
/*     */     try
/*     */     {
/* 119 */       all = new java.util.HashMap();
/* 120 */       SAXReader reader = new SAXReader();
/* 121 */       org.dom4j.Document doc = reader.read(new File(path));
/* 122 */       Element root = doc.getRootElement();
/* 123 */       List<?> nodeList = root.elements();
/* 124 */       int len = nodeList.size();
/* 125 */       for (int i = 0; i < len; i++)
/*     */       {
/* 127 */         Element elem = (Element)nodeList.get(i);
/* 128 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SFabaoItem"))
/*     */         {
/*     */ 
/* 131 */           SFabaoItem obj = new SFabaoItem();
/* 132 */           obj.loadFromXml(elem);
/* 133 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 134 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 139 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SFabaoItem> all)
/*     */   {
/* 145 */     String path = dir + "mzm.gsp.item.confbean.SFabaoItem.xml";
/*     */     
/*     */     try
/*     */     {
/* 149 */       SAXReader reader = new SAXReader();
/* 150 */       org.dom4j.Document doc = reader.read(new File(path));
/* 151 */       Element root = doc.getRootElement();
/* 152 */       List<?> nodeList = root.elements();
/* 153 */       int len = nodeList.size();
/* 154 */       for (int i = 0; i < len; i++)
/*     */       {
/* 156 */         Element elem = (Element)nodeList.get(i);
/* 157 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SFabaoItem"))
/*     */         {
/*     */ 
/* 160 */           SFabaoItem obj = new SFabaoItem();
/* 161 */           obj.loadFromXml(elem);
/* 162 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 163 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 168 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 174 */     all = new java.util.HashMap();
/*     */     
/* 176 */     String path = dir + "mzm.gsp.item.confbean.SFabaoItem.bny";
/*     */     try
/*     */     {
/* 179 */       File file = new File(path);
/* 180 */       if (file.exists())
/*     */       {
/* 182 */         byte[] bytes = new byte['Ѐ'];
/* 183 */         FileInputStream fis = new FileInputStream(file);
/* 184 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 185 */         int len = 0;
/* 186 */         while ((len = fis.read(bytes)) > 0)
/* 187 */           baos.write(bytes, 0, len);
/* 188 */         fis.close();
/* 189 */         bytes = baos.toByteArray();
/* 190 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 191 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 193 */           _os_.unmarshal_int();
/* 194 */           _os_.unmarshal_int();
/* 195 */           _os_.unmarshal_int();
/*     */         }
/* 197 */         _os_.unmarshal_int();
/* 198 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 201 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 203 */           SFabaoItem _v_ = new SFabaoItem();
/* 204 */           _v_.unmarshal(_os_);
/* 205 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 206 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 211 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 216 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SFabaoItem> all)
/*     */   {
/* 223 */     String path = dir + "mzm.gsp.item.confbean.SFabaoItem.bny";
/*     */     try
/*     */     {
/* 226 */       File file = new File(path);
/* 227 */       if (file.exists())
/*     */       {
/* 229 */         byte[] bytes = new byte['Ѐ'];
/* 230 */         FileInputStream fis = new FileInputStream(file);
/* 231 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 232 */         int len = 0;
/* 233 */         while ((len = fis.read(bytes)) > 0)
/* 234 */           baos.write(bytes, 0, len);
/* 235 */         fis.close();
/* 236 */         bytes = baos.toByteArray();
/* 237 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 238 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 240 */           _os_.unmarshal_int();
/* 241 */           _os_.unmarshal_int();
/* 242 */           _os_.unmarshal_int();
/*     */         }
/* 244 */         _os_.unmarshal_int();
/* 245 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 248 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 250 */           SFabaoItem _v_ = new SFabaoItem();
/* 251 */           _v_.unmarshal(_os_);
/* 252 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 253 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 258 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 263 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 269 */     for (Map.Entry<Integer, SFabaoItem> entry : all.entrySet())
/*     */     {
/* 271 */       if (SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 273 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 277 */       SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SFabaoItem> all, Map<Integer, SItemCfg> parent)
/*     */   {
/* 284 */     for (Map.Entry<Integer, SFabaoItem> entry : all.entrySet())
/*     */     {
/* 286 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 288 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 292 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SFabaoItem getOld(int key)
/*     */   {
/* 299 */     return (SFabaoItem)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SFabaoItem get(int key)
/*     */   {
/* 304 */     return (SFabaoItem)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFabaoItem> getOldAllSelf()
/*     */   {
/* 309 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SFabaoItem> getAllSelf()
/*     */   {
/* 314 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SFabaoItem> newAll)
/*     */   {
/* 319 */     oldAll = all;
/* 320 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 325 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SFabaoItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */