/*     */ package mzm.gsp.item.confbean;
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
/*     */ public class SEquipTransferInherit implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SEquipTransferInherit> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SEquipTransferInherit> all = null;
/*     */   
/*     */   public int equipmentLevel;
/*     */   public int id;
/*     */   public int fixOnePointNeedSilver;
/*     */   public int transferHunNeedItemNum;
/*     */   public int transferHunNeedSilver;
/*     */   public int inheritNeedSilver;
/*     */   public int qilingMaxLevel;
/*     */   public int refreshHunCostItemId;
/*     */   public int refreshHunCostItemNum;
/*     */   public int usePoint;
/*  28 */   public ArrayList<MoneyType2Num> moneytype2num = new ArrayList();
/*  29 */   public ArrayList<LockHunNeedItemInfo> lockHunNeedItemInfos = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  33 */     this.equipmentLevel = Integer.valueOf(rootElement.attributeValue("equipmentLevel")).intValue();
/*  34 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  35 */     this.fixOnePointNeedSilver = Integer.valueOf(rootElement.attributeValue("fixOnePointNeedSilver")).intValue();
/*  36 */     this.transferHunNeedItemNum = Integer.valueOf(rootElement.attributeValue("transferHunNeedItemNum")).intValue();
/*  37 */     this.transferHunNeedSilver = Integer.valueOf(rootElement.attributeValue("transferHunNeedSilver")).intValue();
/*  38 */     this.inheritNeedSilver = Integer.valueOf(rootElement.attributeValue("inheritNeedSilver")).intValue();
/*  39 */     this.qilingMaxLevel = Integer.valueOf(rootElement.attributeValue("qilingMaxLevel")).intValue();
/*  40 */     this.refreshHunCostItemId = Integer.valueOf(rootElement.attributeValue("refreshHunCostItemId")).intValue();
/*  41 */     this.refreshHunCostItemNum = Integer.valueOf(rootElement.attributeValue("refreshHunCostItemNum")).intValue();
/*  42 */     this.usePoint = Integer.valueOf(rootElement.attributeValue("usePoint")).intValue();
/*     */     
/*  44 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "moneytype2num");
/*  45 */     if (collectionElement == null)
/*     */     {
/*  47 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  50 */     List<?> _nodeList = collectionElement.elements();
/*  51 */     int _len = _nodeList.size();
/*  52 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  54 */       Element elem = (Element)_nodeList.get(i);
/*  55 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.MoneyType2Num"))
/*     */       {
/*     */         MoneyType2Num _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  62 */           _v_ = new MoneyType2Num();
/*  63 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  70 */         this.moneytype2num.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  74 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "lockHunNeedItemInfos");
/*  75 */     if (collectionElement == null)
/*     */     {
/*  77 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  80 */     List<?> _nodeList = collectionElement.elements();
/*  81 */     int _len = _nodeList.size();
/*  82 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  84 */       Element elem = (Element)_nodeList.get(i);
/*  85 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.LockHunNeedItemInfo"))
/*     */       {
/*     */         LockHunNeedItemInfo _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  92 */           _v_ = new LockHunNeedItemInfo();
/*  93 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 100 */         this.lockHunNeedItemInfos.add(_v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 107 */     _os_.marshal(this.equipmentLevel);
/* 108 */     _os_.marshal(this.id);
/* 109 */     _os_.marshal(this.fixOnePointNeedSilver);
/* 110 */     _os_.marshal(this.transferHunNeedItemNum);
/* 111 */     _os_.marshal(this.transferHunNeedSilver);
/* 112 */     _os_.marshal(this.inheritNeedSilver);
/* 113 */     _os_.marshal(this.qilingMaxLevel);
/* 114 */     _os_.marshal(this.refreshHunCostItemId);
/* 115 */     _os_.marshal(this.refreshHunCostItemNum);
/* 116 */     _os_.marshal(this.usePoint);
/* 117 */     _os_.compact_uint32(this.moneytype2num.size());
/* 118 */     for (MoneyType2Num _v_ : this.moneytype2num)
/*     */     {
/* 120 */       _os_.marshal(_v_);
/*     */     }
/* 122 */     _os_.compact_uint32(this.lockHunNeedItemInfos.size());
/* 123 */     for (LockHunNeedItemInfo _v_ : this.lockHunNeedItemInfos)
/*     */     {
/* 125 */       _os_.marshal(_v_);
/*     */     }
/* 127 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 132 */     this.equipmentLevel = _os_.unmarshal_int();
/* 133 */     this.id = _os_.unmarshal_int();
/* 134 */     this.fixOnePointNeedSilver = _os_.unmarshal_int();
/* 135 */     this.transferHunNeedItemNum = _os_.unmarshal_int();
/* 136 */     this.transferHunNeedSilver = _os_.unmarshal_int();
/* 137 */     this.inheritNeedSilver = _os_.unmarshal_int();
/* 138 */     this.qilingMaxLevel = _os_.unmarshal_int();
/* 139 */     this.refreshHunCostItemId = _os_.unmarshal_int();
/* 140 */     this.refreshHunCostItemNum = _os_.unmarshal_int();
/* 141 */     this.usePoint = _os_.unmarshal_int();
/* 142 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 145 */       MoneyType2Num _v_ = new MoneyType2Num();
/* 146 */       _v_.unmarshal(_os_);
/* 147 */       this.moneytype2num.add(_v_);
/*     */     }
/* 149 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 152 */       LockHunNeedItemInfo _v_ = new LockHunNeedItemInfo();
/* 153 */       _v_.unmarshal(_os_);
/* 154 */       this.lockHunNeedItemInfos.add(_v_);
/*     */     }
/* 156 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 161 */     String path = dir + "mzm.gsp.item.confbean.SEquipTransferInherit.xml";
/*     */     
/*     */     try
/*     */     {
/* 165 */       all = new java.util.HashMap();
/* 166 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 167 */       org.dom4j.Document doc = reader.read(new File(path));
/* 168 */       Element root = doc.getRootElement();
/* 169 */       List<?> nodeList = root.elements();
/* 170 */       int len = nodeList.size();
/* 171 */       for (int i = 0; i < len; i++)
/*     */       {
/* 173 */         Element elem = (Element)nodeList.get(i);
/* 174 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SEquipTransferInherit"))
/*     */         {
/*     */ 
/* 177 */           SEquipTransferInherit obj = new SEquipTransferInherit();
/* 178 */           obj.loadFromXml(elem);
/* 179 */           if (all.put(Integer.valueOf(obj.equipmentLevel), obj) != null) {
/* 180 */             throw new RuntimeException("duplicate key : " + obj.equipmentLevel);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 185 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SEquipTransferInherit> all)
/*     */   {
/* 191 */     String path = dir + "mzm.gsp.item.confbean.SEquipTransferInherit.xml";
/*     */     
/*     */     try
/*     */     {
/* 195 */       org.dom4j.io.SAXReader reader = new org.dom4j.io.SAXReader();
/* 196 */       org.dom4j.Document doc = reader.read(new File(path));
/* 197 */       Element root = doc.getRootElement();
/* 198 */       List<?> nodeList = root.elements();
/* 199 */       int len = nodeList.size();
/* 200 */       for (int i = 0; i < len; i++)
/*     */       {
/* 202 */         Element elem = (Element)nodeList.get(i);
/* 203 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.item.confbean.SEquipTransferInherit"))
/*     */         {
/*     */ 
/* 206 */           SEquipTransferInherit obj = new SEquipTransferInherit();
/* 207 */           obj.loadFromXml(elem);
/* 208 */           if (all.put(Integer.valueOf(obj.equipmentLevel), obj) != null) {
/* 209 */             throw new RuntimeException("duplicate key : " + obj.equipmentLevel);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 214 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 220 */     all = new java.util.HashMap();
/*     */     
/* 222 */     String path = dir + "mzm.gsp.item.confbean.SEquipTransferInherit.bny";
/*     */     try
/*     */     {
/* 225 */       File file = new File(path);
/* 226 */       if (file.exists())
/*     */       {
/* 228 */         byte[] bytes = new byte['Ѐ'];
/* 229 */         FileInputStream fis = new FileInputStream(file);
/* 230 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 231 */         int len = 0;
/* 232 */         while ((len = fis.read(bytes)) > 0)
/* 233 */           baos.write(bytes, 0, len);
/* 234 */         fis.close();
/* 235 */         bytes = baos.toByteArray();
/* 236 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 237 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 239 */           _os_.unmarshal_int();
/* 240 */           _os_.unmarshal_int();
/* 241 */           _os_.unmarshal_int();
/*     */         }
/* 243 */         _os_.unmarshal_int();
/* 244 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 247 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 249 */           SEquipTransferInherit _v_ = new SEquipTransferInherit();
/* 250 */           _v_.unmarshal(_os_);
/* 251 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 252 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 257 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 262 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SEquipTransferInherit> all)
/*     */   {
/* 269 */     String path = dir + "mzm.gsp.item.confbean.SEquipTransferInherit.bny";
/*     */     try
/*     */     {
/* 272 */       File file = new File(path);
/* 273 */       if (file.exists())
/*     */       {
/* 275 */         byte[] bytes = new byte['Ѐ'];
/* 276 */         FileInputStream fis = new FileInputStream(file);
/* 277 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 278 */         int len = 0;
/* 279 */         while ((len = fis.read(bytes)) > 0)
/* 280 */           baos.write(bytes, 0, len);
/* 281 */         fis.close();
/* 282 */         bytes = baos.toByteArray();
/* 283 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 284 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 286 */           _os_.unmarshal_int();
/* 287 */           _os_.unmarshal_int();
/* 288 */           _os_.unmarshal_int();
/*     */         }
/* 290 */         _os_.unmarshal_int();
/* 291 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 294 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 296 */           SEquipTransferInherit _v_ = new SEquipTransferInherit();
/* 297 */           _v_.unmarshal(_os_);
/* 298 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 299 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 304 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 309 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SEquipTransferInherit getOld(int key)
/*     */   {
/* 317 */     return (SEquipTransferInherit)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SEquipTransferInherit get(int key)
/*     */   {
/* 322 */     return (SEquipTransferInherit)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SEquipTransferInherit> getOldAll()
/*     */   {
/* 327 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SEquipTransferInherit> getAll()
/*     */   {
/* 332 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SEquipTransferInherit> newAll)
/*     */   {
/* 337 */     oldAll = all;
/* 338 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 343 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\SEquipTransferInherit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */