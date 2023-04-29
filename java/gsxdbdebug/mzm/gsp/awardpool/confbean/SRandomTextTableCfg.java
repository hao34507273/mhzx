/*     */ package mzm.gsp.awardpool.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SRandomTextTableCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SRandomTextTableCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SRandomTextTableCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int typeId;
/*     */   public int itemId;
/*     */   public int itemNum;
/*     */   public int expType;
/*     */   public int maxExpNum;
/*     */   public int minExpNum;
/*     */   public int moneyType;
/*     */   public int maxMoneyNum;
/*     */   public int minMoneyNum;
/*     */   public int weight;
/*     */   public int preciousCfgId;
/*     */   public int weightCorrectionCfgId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  34 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  35 */     this.typeId = Integer.valueOf(rootElement.attributeValue("typeId")).intValue();
/*  36 */     this.itemId = Integer.valueOf(rootElement.attributeValue("itemId")).intValue();
/*  37 */     this.itemNum = Integer.valueOf(rootElement.attributeValue("itemNum")).intValue();
/*  38 */     this.expType = Integer.valueOf(rootElement.attributeValue("expType")).intValue();
/*  39 */     this.maxExpNum = Integer.valueOf(rootElement.attributeValue("maxExpNum")).intValue();
/*  40 */     this.minExpNum = Integer.valueOf(rootElement.attributeValue("minExpNum")).intValue();
/*  41 */     this.moneyType = Integer.valueOf(rootElement.attributeValue("moneyType")).intValue();
/*  42 */     this.maxMoneyNum = Integer.valueOf(rootElement.attributeValue("maxMoneyNum")).intValue();
/*  43 */     this.minMoneyNum = Integer.valueOf(rootElement.attributeValue("minMoneyNum")).intValue();
/*  44 */     this.weight = Integer.valueOf(rootElement.attributeValue("weight")).intValue();
/*  45 */     this.preciousCfgId = Integer.valueOf(rootElement.attributeValue("preciousCfgId")).intValue();
/*  46 */     this.weightCorrectionCfgId = Integer.valueOf(rootElement.attributeValue("weightCorrectionCfgId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  51 */     _os_.marshal(this.id);
/*  52 */     _os_.marshal(this.typeId);
/*  53 */     _os_.marshal(this.itemId);
/*  54 */     _os_.marshal(this.itemNum);
/*  55 */     _os_.marshal(this.expType);
/*  56 */     _os_.marshal(this.maxExpNum);
/*  57 */     _os_.marshal(this.minExpNum);
/*  58 */     _os_.marshal(this.moneyType);
/*  59 */     _os_.marshal(this.maxMoneyNum);
/*  60 */     _os_.marshal(this.minMoneyNum);
/*  61 */     _os_.marshal(this.weight);
/*  62 */     _os_.marshal(this.preciousCfgId);
/*  63 */     _os_.marshal(this.weightCorrectionCfgId);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  69 */     this.id = _os_.unmarshal_int();
/*  70 */     this.typeId = _os_.unmarshal_int();
/*  71 */     this.itemId = _os_.unmarshal_int();
/*  72 */     this.itemNum = _os_.unmarshal_int();
/*  73 */     this.expType = _os_.unmarshal_int();
/*  74 */     this.maxExpNum = _os_.unmarshal_int();
/*  75 */     this.minExpNum = _os_.unmarshal_int();
/*  76 */     this.moneyType = _os_.unmarshal_int();
/*  77 */     this.maxMoneyNum = _os_.unmarshal_int();
/*  78 */     this.minMoneyNum = _os_.unmarshal_int();
/*  79 */     this.weight = _os_.unmarshal_int();
/*  80 */     this.preciousCfgId = _os_.unmarshal_int();
/*  81 */     this.weightCorrectionCfgId = _os_.unmarshal_int();
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  87 */     String path = dir + "mzm.gsp.awardpool.confbean.SRandomTextTableCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  91 */       all = new java.util.HashMap();
/*  92 */       SAXReader reader = new SAXReader();
/*  93 */       org.dom4j.Document doc = reader.read(new File(path));
/*  94 */       Element root = doc.getRootElement();
/*  95 */       List<?> nodeList = root.elements();
/*  96 */       int len = nodeList.size();
/*  97 */       for (int i = 0; i < len; i++)
/*     */       {
/*  99 */         Element elem = (Element)nodeList.get(i);
/* 100 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.awardpool.confbean.SRandomTextTableCfg"))
/*     */         {
/*     */ 
/* 103 */           SRandomTextTableCfg obj = new SRandomTextTableCfg();
/* 104 */           obj.loadFromXml(elem);
/* 105 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 106 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 111 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SRandomTextTableCfg> all)
/*     */   {
/* 117 */     String path = dir + "mzm.gsp.awardpool.confbean.SRandomTextTableCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 121 */       SAXReader reader = new SAXReader();
/* 122 */       org.dom4j.Document doc = reader.read(new File(path));
/* 123 */       Element root = doc.getRootElement();
/* 124 */       List<?> nodeList = root.elements();
/* 125 */       int len = nodeList.size();
/* 126 */       for (int i = 0; i < len; i++)
/*     */       {
/* 128 */         Element elem = (Element)nodeList.get(i);
/* 129 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.awardpool.confbean.SRandomTextTableCfg"))
/*     */         {
/*     */ 
/* 132 */           SRandomTextTableCfg obj = new SRandomTextTableCfg();
/* 133 */           obj.loadFromXml(elem);
/* 134 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 135 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 140 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 146 */     all = new java.util.HashMap();
/*     */     
/* 148 */     String path = dir + "mzm.gsp.awardpool.confbean.SRandomTextTableCfg.bny";
/*     */     try
/*     */     {
/* 151 */       File file = new File(path);
/* 152 */       if (file.exists())
/*     */       {
/* 154 */         byte[] bytes = new byte['Ѐ'];
/* 155 */         FileInputStream fis = new FileInputStream(file);
/* 156 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 157 */         int len = 0;
/* 158 */         while ((len = fis.read(bytes)) > 0)
/* 159 */           baos.write(bytes, 0, len);
/* 160 */         fis.close();
/* 161 */         bytes = baos.toByteArray();
/* 162 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 163 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 165 */           _os_.unmarshal_int();
/* 166 */           _os_.unmarshal_int();
/* 167 */           _os_.unmarshal_int();
/*     */         }
/* 169 */         _os_.unmarshal_int();
/* 170 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 173 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 175 */           SRandomTextTableCfg _v_ = new SRandomTextTableCfg();
/* 176 */           _v_.unmarshal(_os_);
/* 177 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 178 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 183 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 188 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SRandomTextTableCfg> all)
/*     */   {
/* 195 */     String path = dir + "mzm.gsp.awardpool.confbean.SRandomTextTableCfg.bny";
/*     */     try
/*     */     {
/* 198 */       File file = new File(path);
/* 199 */       if (file.exists())
/*     */       {
/* 201 */         byte[] bytes = new byte['Ѐ'];
/* 202 */         FileInputStream fis = new FileInputStream(file);
/* 203 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 204 */         int len = 0;
/* 205 */         while ((len = fis.read(bytes)) > 0)
/* 206 */           baos.write(bytes, 0, len);
/* 207 */         fis.close();
/* 208 */         bytes = baos.toByteArray();
/* 209 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 210 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 212 */           _os_.unmarshal_int();
/* 213 */           _os_.unmarshal_int();
/* 214 */           _os_.unmarshal_int();
/*     */         }
/* 216 */         _os_.unmarshal_int();
/* 217 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 220 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 222 */           SRandomTextTableCfg _v_ = new SRandomTextTableCfg();
/* 223 */           _v_.unmarshal(_os_);
/* 224 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 225 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 230 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 235 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SRandomTextTableCfg getOld(int key)
/*     */   {
/* 243 */     return (SRandomTextTableCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SRandomTextTableCfg get(int key)
/*     */   {
/* 248 */     return (SRandomTextTableCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SRandomTextTableCfg> getOldAll()
/*     */   {
/* 253 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SRandomTextTableCfg> getAll()
/*     */   {
/* 258 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SRandomTextTableCfg> newAll)
/*     */   {
/* 263 */     oldAll = all;
/* 264 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 269 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\confbean\SRandomTextTableCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */