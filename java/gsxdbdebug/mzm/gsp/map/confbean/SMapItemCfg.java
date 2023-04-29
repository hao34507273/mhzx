/*     */ package mzm.gsp.map.confbean;
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
/*     */ public class SMapItemCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMapItemCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMapItemCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public String templatename;
/*     */   public String name;
/*     */   public int modelId;
/*     */   public int handlerType;
/*     */   public int minLevel;
/*     */   public int maxLevel;
/*     */   public int needItemId;
/*     */   public int radius;
/*     */   public int needItemNum;
/*     */   public int openCostYuanBao;
/*     */   public int openCostGold;
/*     */   public int openCostSilver;
/*     */   public boolean isTeamMemberCanOpen;
/*     */   public int minNum;
/*  33 */   public java.util.LinkedList<CostMoneyBean> costMoney = new java.util.LinkedList();
/*     */   public int awardPoolId;
/*     */   public int fixAwardId;
/*     */   public int buffid;
/*     */   public int pveFightCfgid;
/*     */   public int costTime;
/*     */   public int maxCount;
/*     */   public int gatherInterval;
/*     */   public int dailyMaxGatherLimit;
/*     */   public int survivalTime;
/*     */   public int controllerId;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  47 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  48 */     this.templatename = rootElement.attributeValue("templatename");
/*  49 */     this.name = rootElement.attributeValue("name");
/*  50 */     this.modelId = Integer.valueOf(rootElement.attributeValue("modelId")).intValue();
/*  51 */     this.handlerType = Integer.valueOf(rootElement.attributeValue("handlerType")).intValue();
/*  52 */     this.minLevel = Integer.valueOf(rootElement.attributeValue("minLevel")).intValue();
/*  53 */     this.maxLevel = Integer.valueOf(rootElement.attributeValue("maxLevel")).intValue();
/*  54 */     this.needItemId = Integer.valueOf(rootElement.attributeValue("needItemId")).intValue();
/*  55 */     this.radius = Integer.valueOf(rootElement.attributeValue("radius")).intValue();
/*  56 */     this.needItemNum = Integer.valueOf(rootElement.attributeValue("needItemNum")).intValue();
/*  57 */     this.openCostYuanBao = Integer.valueOf(rootElement.attributeValue("openCostYuanBao")).intValue();
/*  58 */     this.openCostGold = Integer.valueOf(rootElement.attributeValue("openCostGold")).intValue();
/*  59 */     this.openCostSilver = Integer.valueOf(rootElement.attributeValue("openCostSilver")).intValue();
/*  60 */     this.isTeamMemberCanOpen = Boolean.valueOf(rootElement.attributeValue("isTeamMemberCanOpen")).booleanValue();
/*  61 */     this.minNum = Integer.valueOf(rootElement.attributeValue("minNum")).intValue();
/*     */     
/*  63 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "costMoney");
/*  64 */     if (collectionElement == null)
/*     */     {
/*  66 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  69 */     List<?> _nodeList = collectionElement.elements();
/*  70 */     int _len = _nodeList.size();
/*  71 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  73 */       Element elem = (Element)_nodeList.get(i);
/*  74 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.CostMoneyBean"))
/*     */       {
/*     */         CostMoneyBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  81 */           _v_ = new CostMoneyBean();
/*  82 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  89 */         this.costMoney.add(_v_);
/*     */       }
/*     */     }
/*  92 */     this.awardPoolId = Integer.valueOf(rootElement.attributeValue("awardPoolId")).intValue();
/*  93 */     this.fixAwardId = Integer.valueOf(rootElement.attributeValue("fixAwardId")).intValue();
/*  94 */     this.buffid = Integer.valueOf(rootElement.attributeValue("buffid")).intValue();
/*  95 */     this.pveFightCfgid = Integer.valueOf(rootElement.attributeValue("pveFightCfgid")).intValue();
/*  96 */     this.costTime = Integer.valueOf(rootElement.attributeValue("costTime")).intValue();
/*  97 */     this.maxCount = Integer.valueOf(rootElement.attributeValue("maxCount")).intValue();
/*  98 */     this.gatherInterval = Integer.valueOf(rootElement.attributeValue("gatherInterval")).intValue();
/*  99 */     this.dailyMaxGatherLimit = Integer.valueOf(rootElement.attributeValue("dailyMaxGatherLimit")).intValue();
/* 100 */     this.survivalTime = Integer.valueOf(rootElement.attributeValue("survivalTime")).intValue();
/* 101 */     this.controllerId = Integer.valueOf(rootElement.attributeValue("controllerId")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 106 */     _os_.marshal(this.id);
/* 107 */     _os_.marshal(this.templatename, "UTF-8");
/* 108 */     _os_.marshal(this.name, "UTF-8");
/* 109 */     _os_.marshal(this.modelId);
/* 110 */     _os_.marshal(this.handlerType);
/* 111 */     _os_.marshal(this.minLevel);
/* 112 */     _os_.marshal(this.maxLevel);
/* 113 */     _os_.marshal(this.needItemId);
/* 114 */     _os_.marshal(this.radius);
/* 115 */     _os_.marshal(this.needItemNum);
/* 116 */     _os_.marshal(this.openCostYuanBao);
/* 117 */     _os_.marshal(this.openCostGold);
/* 118 */     _os_.marshal(this.openCostSilver);
/* 119 */     _os_.marshal(this.isTeamMemberCanOpen);
/* 120 */     _os_.marshal(this.minNum);
/* 121 */     _os_.compact_uint32(this.costMoney.size());
/* 122 */     for (CostMoneyBean _v_ : this.costMoney)
/*     */     {
/* 124 */       _os_.marshal(_v_);
/*     */     }
/* 126 */     _os_.marshal(this.awardPoolId);
/* 127 */     _os_.marshal(this.fixAwardId);
/* 128 */     _os_.marshal(this.buffid);
/* 129 */     _os_.marshal(this.pveFightCfgid);
/* 130 */     _os_.marshal(this.costTime);
/* 131 */     _os_.marshal(this.maxCount);
/* 132 */     _os_.marshal(this.gatherInterval);
/* 133 */     _os_.marshal(this.dailyMaxGatherLimit);
/* 134 */     _os_.marshal(this.survivalTime);
/* 135 */     _os_.marshal(this.controllerId);
/* 136 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 141 */     this.id = _os_.unmarshal_int();
/* 142 */     this.templatename = _os_.unmarshal_String("UTF-8");
/* 143 */     this.name = _os_.unmarshal_String("UTF-8");
/* 144 */     this.modelId = _os_.unmarshal_int();
/* 145 */     this.handlerType = _os_.unmarshal_int();
/* 146 */     this.minLevel = _os_.unmarshal_int();
/* 147 */     this.maxLevel = _os_.unmarshal_int();
/* 148 */     this.needItemId = _os_.unmarshal_int();
/* 149 */     this.radius = _os_.unmarshal_int();
/* 150 */     this.needItemNum = _os_.unmarshal_int();
/* 151 */     this.openCostYuanBao = _os_.unmarshal_int();
/* 152 */     this.openCostGold = _os_.unmarshal_int();
/* 153 */     this.openCostSilver = _os_.unmarshal_int();
/* 154 */     this.isTeamMemberCanOpen = _os_.unmarshal_boolean();
/* 155 */     this.minNum = _os_.unmarshal_int();
/* 156 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 159 */       CostMoneyBean _v_ = new CostMoneyBean();
/* 160 */       _v_.unmarshal(_os_);
/* 161 */       this.costMoney.add(_v_);
/*     */     }
/* 163 */     this.awardPoolId = _os_.unmarshal_int();
/* 164 */     this.fixAwardId = _os_.unmarshal_int();
/* 165 */     this.buffid = _os_.unmarshal_int();
/* 166 */     this.pveFightCfgid = _os_.unmarshal_int();
/* 167 */     this.costTime = _os_.unmarshal_int();
/* 168 */     this.maxCount = _os_.unmarshal_int();
/* 169 */     this.gatherInterval = _os_.unmarshal_int();
/* 170 */     this.dailyMaxGatherLimit = _os_.unmarshal_int();
/* 171 */     this.survivalTime = _os_.unmarshal_int();
/* 172 */     this.controllerId = _os_.unmarshal_int();
/* 173 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 178 */     String path = dir + "mzm.gsp.map.confbean.SMapItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 182 */       all = new java.util.HashMap();
/* 183 */       SAXReader reader = new SAXReader();
/* 184 */       org.dom4j.Document doc = reader.read(new File(path));
/* 185 */       Element root = doc.getRootElement();
/* 186 */       List<?> nodeList = root.elements();
/* 187 */       int len = nodeList.size();
/* 188 */       for (int i = 0; i < len; i++)
/*     */       {
/* 190 */         Element elem = (Element)nodeList.get(i);
/* 191 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapItemCfg"))
/*     */         {
/*     */ 
/* 194 */           SMapItemCfg obj = new SMapItemCfg();
/* 195 */           obj.loadFromXml(elem);
/* 196 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 197 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 202 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMapItemCfg> all)
/*     */   {
/* 208 */     String path = dir + "mzm.gsp.map.confbean.SMapItemCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 212 */       SAXReader reader = new SAXReader();
/* 213 */       org.dom4j.Document doc = reader.read(new File(path));
/* 214 */       Element root = doc.getRootElement();
/* 215 */       List<?> nodeList = root.elements();
/* 216 */       int len = nodeList.size();
/* 217 */       for (int i = 0; i < len; i++)
/*     */       {
/* 219 */         Element elem = (Element)nodeList.get(i);
/* 220 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.SMapItemCfg"))
/*     */         {
/*     */ 
/* 223 */           SMapItemCfg obj = new SMapItemCfg();
/* 224 */           obj.loadFromXml(elem);
/* 225 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 226 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 231 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 237 */     all = new java.util.HashMap();
/*     */     
/* 239 */     String path = dir + "mzm.gsp.map.confbean.SMapItemCfg.bny";
/*     */     try
/*     */     {
/* 242 */       File file = new File(path);
/* 243 */       if (file.exists())
/*     */       {
/* 245 */         byte[] bytes = new byte['Ѐ'];
/* 246 */         FileInputStream fis = new FileInputStream(file);
/* 247 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 248 */         int len = 0;
/* 249 */         while ((len = fis.read(bytes)) > 0)
/* 250 */           baos.write(bytes, 0, len);
/* 251 */         fis.close();
/* 252 */         bytes = baos.toByteArray();
/* 253 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 254 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 256 */           _os_.unmarshal_int();
/* 257 */           _os_.unmarshal_int();
/* 258 */           _os_.unmarshal_int();
/*     */         }
/* 260 */         _os_.unmarshal_int();
/* 261 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 264 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 266 */           SMapItemCfg _v_ = new SMapItemCfg();
/* 267 */           _v_.unmarshal(_os_);
/* 268 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 269 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 274 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 279 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMapItemCfg> all)
/*     */   {
/* 286 */     String path = dir + "mzm.gsp.map.confbean.SMapItemCfg.bny";
/*     */     try
/*     */     {
/* 289 */       File file = new File(path);
/* 290 */       if (file.exists())
/*     */       {
/* 292 */         byte[] bytes = new byte['Ѐ'];
/* 293 */         FileInputStream fis = new FileInputStream(file);
/* 294 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 295 */         int len = 0;
/* 296 */         while ((len = fis.read(bytes)) > 0)
/* 297 */           baos.write(bytes, 0, len);
/* 298 */         fis.close();
/* 299 */         bytes = baos.toByteArray();
/* 300 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 301 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 303 */           _os_.unmarshal_int();
/* 304 */           _os_.unmarshal_int();
/* 305 */           _os_.unmarshal_int();
/*     */         }
/* 307 */         _os_.unmarshal_int();
/* 308 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 311 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 313 */           SMapItemCfg _v_ = new SMapItemCfg();
/* 314 */           _v_.unmarshal(_os_);
/* 315 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 316 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 321 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 326 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMapItemCfg getOld(int key)
/*     */   {
/* 334 */     return (SMapItemCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMapItemCfg get(int key)
/*     */   {
/* 339 */     return (SMapItemCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMapItemCfg> getOldAll()
/*     */   {
/* 344 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMapItemCfg> getAll()
/*     */   {
/* 349 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMapItemCfg> newAll)
/*     */   {
/* 354 */     oldAll = all;
/* 355 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 360 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\confbean\SMapItemCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */