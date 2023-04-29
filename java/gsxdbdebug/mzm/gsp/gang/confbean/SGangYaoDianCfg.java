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
/*     */ public class SGangYaoDianCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SGangYaoDianCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SGangYaoDianCfg> all = null;
/*     */   
/*     */   public int level;
/*  19 */   public java.util.ArrayList<Integer> itemIdList = new java.util.ArrayList();
/*     */   public int itemKindNum;
/*     */   public int itemNum;
/*     */   public int itemSilverPrice;
/*     */   public int itemBangGongPrice;
/*     */   public int maintainCostMoneyPerDay;
/*     */   public int levelUpNeedMoney;
/*     */   public int levelUpNeedTimeM;
/*     */   public int triggerMiFangProp;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  31 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/*     */     
/*  33 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "itemIdList");
/*  34 */     if (collectionElement == null)
/*     */     {
/*  36 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  39 */     List<?> _nodeList = collectionElement.elements();
/*  40 */     int _len = _nodeList.size();
/*  41 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  43 */       Element elem = (Element)_nodeList.get(i);
/*  44 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  51 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  58 */         this.itemIdList.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  61 */     this.itemKindNum = Integer.valueOf(rootElement.attributeValue("itemKindNum")).intValue();
/*  62 */     this.itemNum = Integer.valueOf(rootElement.attributeValue("itemNum")).intValue();
/*  63 */     this.itemSilverPrice = Integer.valueOf(rootElement.attributeValue("itemSilverPrice")).intValue();
/*  64 */     this.itemBangGongPrice = Integer.valueOf(rootElement.attributeValue("itemBangGongPrice")).intValue();
/*  65 */     this.maintainCostMoneyPerDay = Integer.valueOf(rootElement.attributeValue("maintainCostMoneyPerDay")).intValue();
/*  66 */     this.levelUpNeedMoney = Integer.valueOf(rootElement.attributeValue("levelUpNeedMoney")).intValue();
/*  67 */     this.levelUpNeedTimeM = Integer.valueOf(rootElement.attributeValue("levelUpNeedTimeM")).intValue();
/*  68 */     this.triggerMiFangProp = Integer.valueOf(rootElement.attributeValue("triggerMiFangProp")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  73 */     _os_.marshal(this.level);
/*  74 */     _os_.compact_uint32(this.itemIdList.size());
/*  75 */     for (Integer _v_ : this.itemIdList)
/*     */     {
/*  77 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  79 */     _os_.marshal(this.itemKindNum);
/*  80 */     _os_.marshal(this.itemNum);
/*  81 */     _os_.marshal(this.itemSilverPrice);
/*  82 */     _os_.marshal(this.itemBangGongPrice);
/*  83 */     _os_.marshal(this.maintainCostMoneyPerDay);
/*  84 */     _os_.marshal(this.levelUpNeedMoney);
/*  85 */     _os_.marshal(this.levelUpNeedTimeM);
/*  86 */     _os_.marshal(this.triggerMiFangProp);
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  92 */     this.level = _os_.unmarshal_int();
/*  93 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  96 */       int _v_ = _os_.unmarshal_int();
/*  97 */       this.itemIdList.add(Integer.valueOf(_v_));
/*     */     }
/*  99 */     this.itemKindNum = _os_.unmarshal_int();
/* 100 */     this.itemNum = _os_.unmarshal_int();
/* 101 */     this.itemSilverPrice = _os_.unmarshal_int();
/* 102 */     this.itemBangGongPrice = _os_.unmarshal_int();
/* 103 */     this.maintainCostMoneyPerDay = _os_.unmarshal_int();
/* 104 */     this.levelUpNeedMoney = _os_.unmarshal_int();
/* 105 */     this.levelUpNeedTimeM = _os_.unmarshal_int();
/* 106 */     this.triggerMiFangProp = _os_.unmarshal_int();
/* 107 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 112 */     String path = dir + "mzm.gsp.gang.confbean.SGangYaoDianCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 116 */       all = new java.util.TreeMap();
/* 117 */       SAXReader reader = new SAXReader();
/* 118 */       org.dom4j.Document doc = reader.read(new File(path));
/* 119 */       Element root = doc.getRootElement();
/* 120 */       List<?> nodeList = root.elements();
/* 121 */       int len = nodeList.size();
/* 122 */       for (int i = 0; i < len; i++)
/*     */       {
/* 124 */         Element elem = (Element)nodeList.get(i);
/* 125 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.gang.confbean.SGangYaoDianCfg"))
/*     */         {
/*     */ 
/* 128 */           SGangYaoDianCfg obj = new SGangYaoDianCfg();
/* 129 */           obj.loadFromXml(elem);
/* 130 */           if (all.put(Integer.valueOf(obj.level), obj) != null) {
/* 131 */             throw new RuntimeException("duplicate key : " + obj.level);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 136 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SGangYaoDianCfg> all)
/*     */   {
/* 142 */     String path = dir + "mzm.gsp.gang.confbean.SGangYaoDianCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 146 */       SAXReader reader = new SAXReader();
/* 147 */       org.dom4j.Document doc = reader.read(new File(path));
/* 148 */       Element root = doc.getRootElement();
/* 149 */       List<?> nodeList = root.elements();
/* 150 */       int len = nodeList.size();
/* 151 */       for (int i = 0; i < len; i++)
/*     */       {
/* 153 */         Element elem = (Element)nodeList.get(i);
/* 154 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.gang.confbean.SGangYaoDianCfg"))
/*     */         {
/*     */ 
/* 157 */           SGangYaoDianCfg obj = new SGangYaoDianCfg();
/* 158 */           obj.loadFromXml(elem);
/* 159 */           if (all.put(Integer.valueOf(obj.level), obj) != null) {
/* 160 */             throw new RuntimeException("duplicate key : " + obj.level);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 165 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 171 */     all = new java.util.TreeMap();
/*     */     
/* 173 */     String path = dir + "mzm.gsp.gang.confbean.SGangYaoDianCfg.bny";
/*     */     try
/*     */     {
/* 176 */       File file = new File(path);
/* 177 */       if (file.exists())
/*     */       {
/* 179 */         byte[] bytes = new byte['Ѐ'];
/* 180 */         FileInputStream fis = new FileInputStream(file);
/* 181 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 182 */         int len = 0;
/* 183 */         while ((len = fis.read(bytes)) > 0)
/* 184 */           baos.write(bytes, 0, len);
/* 185 */         fis.close();
/* 186 */         bytes = baos.toByteArray();
/* 187 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 188 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 190 */           _os_.unmarshal_int();
/* 191 */           _os_.unmarshal_int();
/* 192 */           _os_.unmarshal_int();
/*     */         }
/* 194 */         _os_.unmarshal_int();
/* 195 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 198 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 200 */           SGangYaoDianCfg _v_ = new SGangYaoDianCfg();
/* 201 */           _v_.unmarshal(_os_);
/* 202 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 203 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 208 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 213 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SGangYaoDianCfg> all)
/*     */   {
/* 220 */     String path = dir + "mzm.gsp.gang.confbean.SGangYaoDianCfg.bny";
/*     */     try
/*     */     {
/* 223 */       File file = new File(path);
/* 224 */       if (file.exists())
/*     */       {
/* 226 */         byte[] bytes = new byte['Ѐ'];
/* 227 */         FileInputStream fis = new FileInputStream(file);
/* 228 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 229 */         int len = 0;
/* 230 */         while ((len = fis.read(bytes)) > 0)
/* 231 */           baos.write(bytes, 0, len);
/* 232 */         fis.close();
/* 233 */         bytes = baos.toByteArray();
/* 234 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 235 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 237 */           _os_.unmarshal_int();
/* 238 */           _os_.unmarshal_int();
/* 239 */           _os_.unmarshal_int();
/*     */         }
/* 241 */         _os_.unmarshal_int();
/* 242 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 245 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 247 */           SGangYaoDianCfg _v_ = new SGangYaoDianCfg();
/* 248 */           _v_.unmarshal(_os_);
/* 249 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 250 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 255 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 260 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SGangYaoDianCfg getOld(int key)
/*     */   {
/* 268 */     return (SGangYaoDianCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SGangYaoDianCfg get(int key)
/*     */   {
/* 273 */     return (SGangYaoDianCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGangYaoDianCfg> getOldAll()
/*     */   {
/* 278 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SGangYaoDianCfg> getAll()
/*     */   {
/* 283 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SGangYaoDianCfg> newAll)
/*     */   {
/* 288 */     oldAll = all;
/* 289 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 294 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\confbean\SGangYaoDianCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */