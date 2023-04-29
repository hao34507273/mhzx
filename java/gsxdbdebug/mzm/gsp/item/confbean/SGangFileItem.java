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
/*     */ public class SGangFileItem extends SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SGangFileItem> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SGangFileItem> all = null;
/*     */   
/*     */   public int maxUseCount;
/*     */   public int rewardId;
/*     */   public int addGangMoneyNum;
/*     */   public int carrymax;
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
/*  39 */     this.maxUseCount = Integer.valueOf(rootElement.attributeValue("maxUseCount")).intValue();
/*  40 */     this.rewardId = Integer.valueOf(rootElement.attributeValue("rewardId")).intValue();
/*  41 */     this.addGangMoneyNum = Integer.valueOf(rootElement.attributeValue("addGangMoneyNum")).intValue();
/*  42 */     this.carrymax = Integer.valueOf(rootElement.attributeValue("carrymax")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  47 */     _os_.marshal(this.id);
/*  48 */     _os_.marshal(this.type);
/*  49 */     _os_.marshal(this.name, "UTF-8");
/*  50 */     _os_.marshal(this.namecolor);
/*  51 */     _os_.marshal(this.icon);
/*  52 */     _os_.marshal(this.pilemax);
/*  53 */     _os_.marshal(this.sellSilver);
/*  54 */     _os_.marshal(this.isProprietary);
/*  55 */     _os_.marshal(this.canSellAndThrow);
/*  56 */     _os_.marshal(this.awardRoleLevelMin);
/*  57 */     _os_.marshal(this.awardRoleLevelMax);
/*  58 */     _os_.marshal(this.useLevel);
/*  59 */     _os_.marshal(this.sort);
/*  60 */     _os_.marshal(this.maxUseCount);
/*  61 */     _os_.marshal(this.rewardId);
/*  62 */     _os_.marshal(this.addGangMoneyNum);
/*  63 */     _os_.marshal(this.carrymax);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  69 */     this.id = _os_.unmarshal_int();
/*  70 */     this.type = _os_.unmarshal_int();
/*  71 */     this.name = _os_.unmarshal_String("UTF-8");
/*  72 */     this.namecolor = _os_.unmarshal_int();
/*  73 */     this.icon = _os_.unmarshal_int();
/*  74 */     this.pilemax = _os_.unmarshal_int();
/*  75 */     this.sellSilver = _os_.unmarshal_int();
/*  76 */     this.isProprietary = _os_.unmarshal_boolean();
/*  77 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/*  78 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/*  79 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/*  80 */     this.useLevel = _os_.unmarshal_int();
/*  81 */     this.sort = _os_.unmarshal_int();
/*  82 */     this.maxUseCount = _os_.unmarshal_int();
/*  83 */     this.rewardId = _os_.unmarshal_int();
/*  84 */     this.addGangMoneyNum = _os_.unmarshal_int();
/*  85 */     this.carrymax = _os_.unmarshal_int();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  91 */     String path = dir + "mzm.gsp.item.confbean.SGangFileItem.xml";
/*     */     
/*     */     try
/*     */     {
/*  95 */       all = new java.util.HashMap();
/*  96 */       SAXReader reader = new SAXReader();
/*  97 */       org.dom4j.Document doc = reader.read(new File(path));
/*  98 */       Element root = doc.getRootElement();
/*  99 */       List<?> nodeList = root.elements();
/* 100 */       int len = nodeList.size();
/* 101 */       for (int i = 0; i < len; i++)
/*     */       {
/* 103 */         Element elem = (Element)nodeList.get(i);
/* 104 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SGangFileItem"))
/*     */         {
/*     */ 
/* 107 */           SGangFileItem obj = new SGangFileItem();
/* 108 */           obj.loadFromXml(elem);
/* 109 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 110 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 115 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SGangFileItem> all)
/*     */   {
/* 121 */     String path = dir + "mzm.gsp.item.confbean.SGangFileItem.xml";
/*     */     
/*     */     try
/*     */     {
/* 125 */       SAXReader reader = new SAXReader();
/* 126 */       org.dom4j.Document doc = reader.read(new File(path));
/* 127 */       Element root = doc.getRootElement();
/* 128 */       List<?> nodeList = root.elements();
/* 129 */       int len = nodeList.size();
/* 130 */       for (int i = 0; i < len; i++)
/*     */       {
/* 132 */         Element elem = (Element)nodeList.get(i);
/* 133 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SGangFileItem"))
/*     */         {
/*     */ 
/* 136 */           SGangFileItem obj = new SGangFileItem();
/* 137 */           obj.loadFromXml(elem);
/* 138 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 139 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 144 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 150 */     all = new java.util.HashMap();
/*     */     
/* 152 */     String path = dir + "mzm.gsp.item.confbean.SGangFileItem.bny";
/*     */     try
/*     */     {
/* 155 */       File file = new File(path);
/* 156 */       if (file.exists())
/*     */       {
/* 158 */         byte[] bytes = new byte['Ѐ'];
/* 159 */         FileInputStream fis = new FileInputStream(file);
/* 160 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 161 */         int len = 0;
/* 162 */         while ((len = fis.read(bytes)) > 0)
/* 163 */           baos.write(bytes, 0, len);
/* 164 */         fis.close();
/* 165 */         bytes = baos.toByteArray();
/* 166 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 167 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 169 */           _os_.unmarshal_int();
/* 170 */           _os_.unmarshal_int();
/* 171 */           _os_.unmarshal_int();
/*     */         }
/* 173 */         _os_.unmarshal_int();
/* 174 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 177 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 179 */           SGangFileItem _v_ = new SGangFileItem();
/* 180 */           _v_.unmarshal(_os_);
/* 181 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 182 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 187 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 192 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SGangFileItem> all)
/*     */   {
/* 199 */     String path = dir + "mzm.gsp.item.confbean.SGangFileItem.bny";
/*     */     try
/*     */     {
/* 202 */       File file = new File(path);
/* 203 */       if (file.exists())
/*     */       {
/* 205 */         byte[] bytes = new byte['Ѐ'];
/* 206 */         FileInputStream fis = new FileInputStream(file);
/* 207 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 208 */         int len = 0;
/* 209 */         while ((len = fis.read(bytes)) > 0)
/* 210 */           baos.write(bytes, 0, len);
/* 211 */         fis.close();
/* 212 */         bytes = baos.toByteArray();
/* 213 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 214 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 216 */           _os_.unmarshal_int();
/* 217 */           _os_.unmarshal_int();
/* 218 */           _os_.unmarshal_int();
/*     */         }
/* 220 */         _os_.unmarshal_int();
/* 221 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 224 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 226 */           SGangFileItem _v_ = new SGangFileItem();
/* 227 */           _v_.unmarshal(_os_);
/* 228 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 229 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 234 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 239 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 245 */     for (Map.Entry<Integer, SGangFileItem> entry : all.entrySet())
/*     */     {
/* 247 */       if (SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 249 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 253 */       SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SGangFileItem> all, Map<Integer, SItemCfg> parent)
/*     */   {
/* 260 */     for (Map.Entry<Integer, SGangFileItem> entry : all.entrySet())
/*     */     {
/* 262 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 264 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 268 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SGangFileItem getOld(int key)
/*     */   {
/* 275 */     return (SGangFileItem)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SGangFileItem get(int key)
/*     */   {
/* 280 */     return (SGangFileItem)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGangFileItem> getOldAllSelf()
/*     */   {
/* 285 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGangFileItem> getAllSelf()
/*     */   {
/* 290 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SGangFileItem> newAll)
/*     */   {
/* 295 */     oldAll = all;
/* 296 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 301 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SGangFileItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */