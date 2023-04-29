/*     */ package mzm.gsp.gang.confbean;
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
/*     */ public class SGangLevelCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SGangLevelCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SGangLevelCfg> all = null;
/*     */   
/*     */   public int level;
/*     */   public int maintainCostMoneyPerDay;
/*     */   public int levelUpNeedMoney;
/*     */   public int levelUpNeedTimeM;
/*     */   public int needBuildingLevel;
/*     */   public int needBuildingNum;
/*     */   public int xiangFangMaxLevel;
/*     */   public int jinKuMaxLevel;
/*     */   public int yaoDianMaxLevel;
/*     */   public int cangKuMaxLevel;
/*     */   public int shuYuanMaxLevel;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  32 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*  33 */     this.maintainCostMoneyPerDay = Integer.valueOf(rootElement.attributeValue("maintainCostMoneyPerDay")).intValue();
/*  34 */     this.levelUpNeedMoney = Integer.valueOf(rootElement.attributeValue("levelUpNeedMoney")).intValue();
/*  35 */     this.levelUpNeedTimeM = Integer.valueOf(rootElement.attributeValue("levelUpNeedTimeM")).intValue();
/*  36 */     this.needBuildingLevel = Integer.valueOf(rootElement.attributeValue("needBuildingLevel")).intValue();
/*  37 */     this.needBuildingNum = Integer.valueOf(rootElement.attributeValue("needBuildingNum")).intValue();
/*  38 */     this.xiangFangMaxLevel = Integer.valueOf(rootElement.attributeValue("xiangFangMaxLevel")).intValue();
/*  39 */     this.jinKuMaxLevel = Integer.valueOf(rootElement.attributeValue("jinKuMaxLevel")).intValue();
/*  40 */     this.yaoDianMaxLevel = Integer.valueOf(rootElement.attributeValue("yaoDianMaxLevel")).intValue();
/*  41 */     this.cangKuMaxLevel = Integer.valueOf(rootElement.attributeValue("cangKuMaxLevel")).intValue();
/*  42 */     this.shuYuanMaxLevel = Integer.valueOf(rootElement.attributeValue("shuYuanMaxLevel")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  47 */     _os_.marshal(this.level);
/*  48 */     _os_.marshal(this.maintainCostMoneyPerDay);
/*  49 */     _os_.marshal(this.levelUpNeedMoney);
/*  50 */     _os_.marshal(this.levelUpNeedTimeM);
/*  51 */     _os_.marshal(this.needBuildingLevel);
/*  52 */     _os_.marshal(this.needBuildingNum);
/*  53 */     _os_.marshal(this.xiangFangMaxLevel);
/*  54 */     _os_.marshal(this.jinKuMaxLevel);
/*  55 */     _os_.marshal(this.yaoDianMaxLevel);
/*  56 */     _os_.marshal(this.cangKuMaxLevel);
/*  57 */     _os_.marshal(this.shuYuanMaxLevel);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  63 */     this.level = _os_.unmarshal_int();
/*  64 */     this.maintainCostMoneyPerDay = _os_.unmarshal_int();
/*  65 */     this.levelUpNeedMoney = _os_.unmarshal_int();
/*  66 */     this.levelUpNeedTimeM = _os_.unmarshal_int();
/*  67 */     this.needBuildingLevel = _os_.unmarshal_int();
/*  68 */     this.needBuildingNum = _os_.unmarshal_int();
/*  69 */     this.xiangFangMaxLevel = _os_.unmarshal_int();
/*  70 */     this.jinKuMaxLevel = _os_.unmarshal_int();
/*  71 */     this.yaoDianMaxLevel = _os_.unmarshal_int();
/*  72 */     this.cangKuMaxLevel = _os_.unmarshal_int();
/*  73 */     this.shuYuanMaxLevel = _os_.unmarshal_int();
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.gang.confbean.SGangLevelCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  83 */       all = new java.util.TreeMap();
/*  84 */       SAXReader reader = new SAXReader();
/*  85 */       org.dom4j.Document doc = reader.read(new File(path));
/*  86 */       Element root = doc.getRootElement();
/*  87 */       List<?> nodeList = root.elements();
/*  88 */       int len = nodeList.size();
/*  89 */       for (int i = 0; i < len; i++)
/*     */       {
/*  91 */         Element elem = (Element)nodeList.get(i);
/*  92 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.gang.confbean.SGangLevelCfg"))
/*     */         {
/*     */ 
/*  95 */           SGangLevelCfg obj = new SGangLevelCfg();
/*  96 */           obj.loadFromXml(elem);
/*  97 */           if (all.put(Integer.valueOf(obj.level), obj) != null) {
/*  98 */             throw new RuntimeException("duplicate key : " + obj.level);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 103 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SGangLevelCfg> all)
/*     */   {
/* 109 */     String path = dir + "mzm.gsp.gang.confbean.SGangLevelCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 113 */       SAXReader reader = new SAXReader();
/* 114 */       org.dom4j.Document doc = reader.read(new File(path));
/* 115 */       Element root = doc.getRootElement();
/* 116 */       List<?> nodeList = root.elements();
/* 117 */       int len = nodeList.size();
/* 118 */       for (int i = 0; i < len; i++)
/*     */       {
/* 120 */         Element elem = (Element)nodeList.get(i);
/* 121 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.gang.confbean.SGangLevelCfg"))
/*     */         {
/*     */ 
/* 124 */           SGangLevelCfg obj = new SGangLevelCfg();
/* 125 */           obj.loadFromXml(elem);
/* 126 */           if (all.put(Integer.valueOf(obj.level), obj) != null) {
/* 127 */             throw new RuntimeException("duplicate key : " + obj.level);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 132 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 138 */     all = new java.util.TreeMap();
/*     */     
/* 140 */     String path = dir + "mzm.gsp.gang.confbean.SGangLevelCfg.bny";
/*     */     try
/*     */     {
/* 143 */       File file = new File(path);
/* 144 */       if (file.exists())
/*     */       {
/* 146 */         byte[] bytes = new byte['Ѐ'];
/* 147 */         FileInputStream fis = new FileInputStream(file);
/* 148 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 149 */         int len = 0;
/* 150 */         while ((len = fis.read(bytes)) > 0)
/* 151 */           baos.write(bytes, 0, len);
/* 152 */         fis.close();
/* 153 */         bytes = baos.toByteArray();
/* 154 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 155 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 157 */           _os_.unmarshal_int();
/* 158 */           _os_.unmarshal_int();
/* 159 */           _os_.unmarshal_int();
/*     */         }
/* 161 */         _os_.unmarshal_int();
/* 162 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 165 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 167 */           SGangLevelCfg _v_ = new SGangLevelCfg();
/* 168 */           _v_.unmarshal(_os_);
/* 169 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 170 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 175 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 180 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SGangLevelCfg> all)
/*     */   {
/* 187 */     String path = dir + "mzm.gsp.gang.confbean.SGangLevelCfg.bny";
/*     */     try
/*     */     {
/* 190 */       File file = new File(path);
/* 191 */       if (file.exists())
/*     */       {
/* 193 */         byte[] bytes = new byte['Ѐ'];
/* 194 */         FileInputStream fis = new FileInputStream(file);
/* 195 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 196 */         int len = 0;
/* 197 */         while ((len = fis.read(bytes)) > 0)
/* 198 */           baos.write(bytes, 0, len);
/* 199 */         fis.close();
/* 200 */         bytes = baos.toByteArray();
/* 201 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 202 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 204 */           _os_.unmarshal_int();
/* 205 */           _os_.unmarshal_int();
/* 206 */           _os_.unmarshal_int();
/*     */         }
/* 208 */         _os_.unmarshal_int();
/* 209 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 212 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 214 */           SGangLevelCfg _v_ = new SGangLevelCfg();
/* 215 */           _v_.unmarshal(_os_);
/* 216 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 217 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 222 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 227 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SGangLevelCfg getOld(int key)
/*     */   {
/* 235 */     return (SGangLevelCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SGangLevelCfg get(int key)
/*     */   {
/* 240 */     return (SGangLevelCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGangLevelCfg> getOldAll()
/*     */   {
/* 245 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGangLevelCfg> getAll()
/*     */   {
/* 250 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SGangLevelCfg> newAll)
/*     */   {
/* 255 */     oldAll = all;
/* 256 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 261 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\confbean\SGangLevelCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */