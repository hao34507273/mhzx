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
/*     */ public class SLotteryItem extends SItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SLotteryItem> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SLotteryItem> all = null;
/*     */   
/*     */   public int lotteryType;
/*     */   public int randomTextId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  25 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  26 */     this.name = rootElement.attributeValue("name");
/*  27 */     this.namecolor = Integer.valueOf(rootElement.attributeValue("namecolor")).intValue();
/*  28 */     this.icon = Integer.valueOf(rootElement.attributeValue("icon")).intValue();
/*  29 */     this.pilemax = Integer.valueOf(rootElement.attributeValue("pilemax")).intValue();
/*  30 */     this.sellSilver = Integer.valueOf(rootElement.attributeValue("sellSilver")).intValue();
/*  31 */     this.isProprietary = Boolean.valueOf(rootElement.attributeValue("isProprietary")).booleanValue();
/*  32 */     this.canSellAndThrow = Boolean.valueOf(rootElement.attributeValue("canSellAndThrow")).booleanValue();
/*  33 */     this.awardRoleLevelMin = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMin")).intValue();
/*  34 */     this.awardRoleLevelMax = Integer.valueOf(rootElement.attributeValue("awardRoleLevelMax")).intValue();
/*  35 */     this.useLevel = Integer.valueOf(rootElement.attributeValue("useLevel")).intValue();
/*  36 */     this.sort = Integer.valueOf(rootElement.attributeValue("sort")).intValue();
/*  37 */     this.lotteryType = Integer.valueOf(rootElement.attributeValue("lotteryType")).intValue();
/*  38 */     this.randomTextId = Integer.valueOf(rootElement.attributeValue("randomTextId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  43 */     _os_.marshal(this.id);
/*  44 */     _os_.marshal(this.type);
/*  45 */     _os_.marshal(this.name, "UTF-8");
/*  46 */     _os_.marshal(this.namecolor);
/*  47 */     _os_.marshal(this.icon);
/*  48 */     _os_.marshal(this.pilemax);
/*  49 */     _os_.marshal(this.sellSilver);
/*  50 */     _os_.marshal(this.isProprietary);
/*  51 */     _os_.marshal(this.canSellAndThrow);
/*  52 */     _os_.marshal(this.awardRoleLevelMin);
/*  53 */     _os_.marshal(this.awardRoleLevelMax);
/*  54 */     _os_.marshal(this.useLevel);
/*  55 */     _os_.marshal(this.sort);
/*  56 */     _os_.marshal(this.lotteryType);
/*  57 */     _os_.marshal(this.randomTextId);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  63 */     this.id = _os_.unmarshal_int();
/*  64 */     this.type = _os_.unmarshal_int();
/*  65 */     this.name = _os_.unmarshal_String("UTF-8");
/*  66 */     this.namecolor = _os_.unmarshal_int();
/*  67 */     this.icon = _os_.unmarshal_int();
/*  68 */     this.pilemax = _os_.unmarshal_int();
/*  69 */     this.sellSilver = _os_.unmarshal_int();
/*  70 */     this.isProprietary = _os_.unmarshal_boolean();
/*  71 */     this.canSellAndThrow = _os_.unmarshal_boolean();
/*  72 */     this.awardRoleLevelMin = _os_.unmarshal_int();
/*  73 */     this.awardRoleLevelMax = _os_.unmarshal_int();
/*  74 */     this.useLevel = _os_.unmarshal_int();
/*  75 */     this.sort = _os_.unmarshal_int();
/*  76 */     this.lotteryType = _os_.unmarshal_int();
/*  77 */     this.randomTextId = _os_.unmarshal_int();
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  83 */     String path = dir + "mzm.gsp.item.confbean.SLotteryItem.xml";
/*     */     
/*     */     try
/*     */     {
/*  87 */       all = new java.util.HashMap();
/*  88 */       SAXReader reader = new SAXReader();
/*  89 */       org.dom4j.Document doc = reader.read(new File(path));
/*  90 */       Element root = doc.getRootElement();
/*  91 */       List<?> nodeList = root.elements();
/*  92 */       int len = nodeList.size();
/*  93 */       for (int i = 0; i < len; i++)
/*     */       {
/*  95 */         Element elem = (Element)nodeList.get(i);
/*  96 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SLotteryItem"))
/*     */         {
/*     */ 
/*  99 */           SLotteryItem obj = new SLotteryItem();
/* 100 */           obj.loadFromXml(elem);
/* 101 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 102 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 107 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SLotteryItem> all)
/*     */   {
/* 113 */     String path = dir + "mzm.gsp.item.confbean.SLotteryItem.xml";
/*     */     
/*     */     try
/*     */     {
/* 117 */       SAXReader reader = new SAXReader();
/* 118 */       org.dom4j.Document doc = reader.read(new File(path));
/* 119 */       Element root = doc.getRootElement();
/* 120 */       List<?> nodeList = root.elements();
/* 121 */       int len = nodeList.size();
/* 122 */       for (int i = 0; i < len; i++)
/*     */       {
/* 124 */         Element elem = (Element)nodeList.get(i);
/* 125 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SLotteryItem"))
/*     */         {
/*     */ 
/* 128 */           SLotteryItem obj = new SLotteryItem();
/* 129 */           obj.loadFromXml(elem);
/* 130 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 131 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 136 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 142 */     all = new java.util.HashMap();
/*     */     
/* 144 */     String path = dir + "mzm.gsp.item.confbean.SLotteryItem.bny";
/*     */     try
/*     */     {
/* 147 */       File file = new File(path);
/* 148 */       if (file.exists())
/*     */       {
/* 150 */         byte[] bytes = new byte['Ѐ'];
/* 151 */         FileInputStream fis = new FileInputStream(file);
/* 152 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 153 */         int len = 0;
/* 154 */         while ((len = fis.read(bytes)) > 0)
/* 155 */           baos.write(bytes, 0, len);
/* 156 */         fis.close();
/* 157 */         bytes = baos.toByteArray();
/* 158 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 159 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 161 */           _os_.unmarshal_int();
/* 162 */           _os_.unmarshal_int();
/* 163 */           _os_.unmarshal_int();
/*     */         }
/* 165 */         _os_.unmarshal_int();
/* 166 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 169 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 171 */           SLotteryItem _v_ = new SLotteryItem();
/* 172 */           _v_.unmarshal(_os_);
/* 173 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 174 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 179 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 184 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SLotteryItem> all)
/*     */   {
/* 191 */     String path = dir + "mzm.gsp.item.confbean.SLotteryItem.bny";
/*     */     try
/*     */     {
/* 194 */       File file = new File(path);
/* 195 */       if (file.exists())
/*     */       {
/* 197 */         byte[] bytes = new byte['Ѐ'];
/* 198 */         FileInputStream fis = new FileInputStream(file);
/* 199 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 200 */         int len = 0;
/* 201 */         while ((len = fis.read(bytes)) > 0)
/* 202 */           baos.write(bytes, 0, len);
/* 203 */         fis.close();
/* 204 */         bytes = baos.toByteArray();
/* 205 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 206 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 208 */           _os_.unmarshal_int();
/* 209 */           _os_.unmarshal_int();
/* 210 */           _os_.unmarshal_int();
/*     */         }
/* 212 */         _os_.unmarshal_int();
/* 213 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 216 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 218 */           SLotteryItem _v_ = new SLotteryItem();
/* 219 */           _v_.unmarshal(_os_);
/* 220 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 221 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 226 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 231 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 237 */     for (Map.Entry<Integer, SLotteryItem> entry : all.entrySet())
/*     */     {
/* 239 */       if (SItemCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 241 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 245 */       SItemCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SLotteryItem> all, Map<Integer, SItemCfg> parent)
/*     */   {
/* 252 */     for (Map.Entry<Integer, SLotteryItem> entry : all.entrySet())
/*     */     {
/* 254 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 256 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 260 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SLotteryItem getOld(int key)
/*     */   {
/* 267 */     return (SLotteryItem)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SLotteryItem get(int key)
/*     */   {
/* 272 */     return (SLotteryItem)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLotteryItem> getOldAllSelf()
/*     */   {
/* 277 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SLotteryItem> getAllSelf()
/*     */   {
/* 282 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SLotteryItem> newAll)
/*     */   {
/* 287 */     oldAll = all;
/* 288 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 293 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SLotteryItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */