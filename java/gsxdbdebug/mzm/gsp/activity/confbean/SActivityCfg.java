/*     */ package mzm.gsp.activity.confbean;
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
/*     */ public class SActivityCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SActivityCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SActivityCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int activityLogicType;
/*     */   public int activityType;
/*     */   public boolean couldBeSingleTeam;
/*     */   public int personMax;
/*     */   public int personMin;
/*     */   public int levelMax;
/*     */   public int levelMin;
/*     */   public int serverLevelMin;
/*     */   public int recommendCount;
/*     */   public int recommendAwardId;
/*     */   public int count;
/*     */   public boolean bigReset;
/*     */   public int resetDataBigTurn;
/*  32 */   public java.util.ArrayList<Integer> activityTimeIds = new java.util.ArrayList();
/*     */   public int activityLimitTimeid;
/*     */   public int product;
/*     */   public boolean restartOpen;
/*     */   public int awardActiveTimes;
/*     */   public int awardActiveValue;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  41 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  42 */     this.activityLogicType = Integer.valueOf(rootElement.attributeValue("activityLogicType")).intValue();
/*  43 */     this.activityType = Integer.valueOf(rootElement.attributeValue("activityType")).intValue();
/*  44 */     this.couldBeSingleTeam = Boolean.valueOf(rootElement.attributeValue("couldBeSingleTeam")).booleanValue();
/*  45 */     this.personMax = Integer.valueOf(rootElement.attributeValue("personMax")).intValue();
/*  46 */     this.personMin = Integer.valueOf(rootElement.attributeValue("personMin")).intValue();
/*  47 */     this.levelMax = Integer.valueOf(rootElement.attributeValue("levelMax")).intValue();
/*  48 */     this.levelMin = Integer.valueOf(rootElement.attributeValue("levelMin")).intValue();
/*  49 */     this.serverLevelMin = Integer.valueOf(rootElement.attributeValue("serverLevelMin")).intValue();
/*  50 */     this.recommendCount = Integer.valueOf(rootElement.attributeValue("recommendCount")).intValue();
/*  51 */     this.recommendAwardId = Integer.valueOf(rootElement.attributeValue("recommendAwardId")).intValue();
/*  52 */     this.count = Integer.valueOf(rootElement.attributeValue("count")).intValue();
/*  53 */     this.bigReset = Boolean.valueOf(rootElement.attributeValue("bigReset")).booleanValue();
/*  54 */     this.resetDataBigTurn = Integer.valueOf(rootElement.attributeValue("resetDataBigTurn")).intValue();
/*     */     
/*  56 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "activityTimeIds");
/*  57 */     if (collectionElement == null)
/*     */     {
/*  59 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  62 */     List<?> _nodeList = collectionElement.elements();
/*  63 */     int _len = _nodeList.size();
/*  64 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  66 */       Element elem = (Element)_nodeList.get(i);
/*  67 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  74 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  81 */         this.activityTimeIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*  84 */     this.activityLimitTimeid = Integer.valueOf(rootElement.attributeValue("activityLimitTimeid")).intValue();
/*  85 */     this.product = Integer.valueOf(rootElement.attributeValue("product")).intValue();
/*  86 */     this.restartOpen = Boolean.valueOf(rootElement.attributeValue("restartOpen")).booleanValue();
/*  87 */     this.awardActiveTimes = Integer.valueOf(rootElement.attributeValue("awardActiveTimes")).intValue();
/*  88 */     this.awardActiveValue = Integer.valueOf(rootElement.attributeValue("awardActiveValue")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  93 */     _os_.marshal(this.id);
/*  94 */     _os_.marshal(this.activityLogicType);
/*  95 */     _os_.marshal(this.activityType);
/*  96 */     _os_.marshal(this.couldBeSingleTeam);
/*  97 */     _os_.marshal(this.personMax);
/*  98 */     _os_.marshal(this.personMin);
/*  99 */     _os_.marshal(this.levelMax);
/* 100 */     _os_.marshal(this.levelMin);
/* 101 */     _os_.marshal(this.serverLevelMin);
/* 102 */     _os_.marshal(this.recommendCount);
/* 103 */     _os_.marshal(this.recommendAwardId);
/* 104 */     _os_.marshal(this.count);
/* 105 */     _os_.marshal(this.bigReset);
/* 106 */     _os_.marshal(this.resetDataBigTurn);
/* 107 */     _os_.compact_uint32(this.activityTimeIds.size());
/* 108 */     for (Integer _v_ : this.activityTimeIds)
/*     */     {
/* 110 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 112 */     _os_.marshal(this.activityLimitTimeid);
/* 113 */     _os_.marshal(this.product);
/* 114 */     _os_.marshal(this.restartOpen);
/* 115 */     _os_.marshal(this.awardActiveTimes);
/* 116 */     _os_.marshal(this.awardActiveValue);
/* 117 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 122 */     this.id = _os_.unmarshal_int();
/* 123 */     this.activityLogicType = _os_.unmarshal_int();
/* 124 */     this.activityType = _os_.unmarshal_int();
/* 125 */     this.couldBeSingleTeam = _os_.unmarshal_boolean();
/* 126 */     this.personMax = _os_.unmarshal_int();
/* 127 */     this.personMin = _os_.unmarshal_int();
/* 128 */     this.levelMax = _os_.unmarshal_int();
/* 129 */     this.levelMin = _os_.unmarshal_int();
/* 130 */     this.serverLevelMin = _os_.unmarshal_int();
/* 131 */     this.recommendCount = _os_.unmarshal_int();
/* 132 */     this.recommendAwardId = _os_.unmarshal_int();
/* 133 */     this.count = _os_.unmarshal_int();
/* 134 */     this.bigReset = _os_.unmarshal_boolean();
/* 135 */     this.resetDataBigTurn = _os_.unmarshal_int();
/* 136 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 139 */       int _v_ = _os_.unmarshal_int();
/* 140 */       this.activityTimeIds.add(Integer.valueOf(_v_));
/*     */     }
/* 142 */     this.activityLimitTimeid = _os_.unmarshal_int();
/* 143 */     this.product = _os_.unmarshal_int();
/* 144 */     this.restartOpen = _os_.unmarshal_boolean();
/* 145 */     this.awardActiveTimes = _os_.unmarshal_int();
/* 146 */     this.awardActiveValue = _os_.unmarshal_int();
/* 147 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 152 */     String path = dir + "mzm.gsp.activity.confbean.SActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 156 */       all = new java.util.HashMap();
/* 157 */       SAXReader reader = new SAXReader();
/* 158 */       org.dom4j.Document doc = reader.read(new File(path));
/* 159 */       Element root = doc.getRootElement();
/* 160 */       List<?> nodeList = root.elements();
/* 161 */       int len = nodeList.size();
/* 162 */       for (int i = 0; i < len; i++)
/*     */       {
/* 164 */         Element elem = (Element)nodeList.get(i);
/* 165 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity.confbean.SActivityCfg"))
/*     */         {
/*     */ 
/* 168 */           SActivityCfg obj = new SActivityCfg();
/* 169 */           obj.loadFromXml(elem);
/* 170 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 171 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 176 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SActivityCfg> all)
/*     */   {
/* 182 */     String path = dir + "mzm.gsp.activity.confbean.SActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 186 */       SAXReader reader = new SAXReader();
/* 187 */       org.dom4j.Document doc = reader.read(new File(path));
/* 188 */       Element root = doc.getRootElement();
/* 189 */       List<?> nodeList = root.elements();
/* 190 */       int len = nodeList.size();
/* 191 */       for (int i = 0; i < len; i++)
/*     */       {
/* 193 */         Element elem = (Element)nodeList.get(i);
/* 194 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity.confbean.SActivityCfg"))
/*     */         {
/*     */ 
/* 197 */           SActivityCfg obj = new SActivityCfg();
/* 198 */           obj.loadFromXml(elem);
/* 199 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 200 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 205 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 211 */     all = new java.util.HashMap();
/*     */     
/* 213 */     String path = dir + "mzm.gsp.activity.confbean.SActivityCfg.bny";
/*     */     try
/*     */     {
/* 216 */       File file = new File(path);
/* 217 */       if (file.exists())
/*     */       {
/* 219 */         byte[] bytes = new byte['Ѐ'];
/* 220 */         FileInputStream fis = new FileInputStream(file);
/* 221 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 222 */         int len = 0;
/* 223 */         while ((len = fis.read(bytes)) > 0)
/* 224 */           baos.write(bytes, 0, len);
/* 225 */         fis.close();
/* 226 */         bytes = baos.toByteArray();
/* 227 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 228 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 230 */           _os_.unmarshal_int();
/* 231 */           _os_.unmarshal_int();
/* 232 */           _os_.unmarshal_int();
/*     */         }
/* 234 */         _os_.unmarshal_int();
/* 235 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 238 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 240 */           SActivityCfg _v_ = new SActivityCfg();
/* 241 */           _v_.unmarshal(_os_);
/* 242 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 243 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 248 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 253 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SActivityCfg> all)
/*     */   {
/* 260 */     String path = dir + "mzm.gsp.activity.confbean.SActivityCfg.bny";
/*     */     try
/*     */     {
/* 263 */       File file = new File(path);
/* 264 */       if (file.exists())
/*     */       {
/* 266 */         byte[] bytes = new byte['Ѐ'];
/* 267 */         FileInputStream fis = new FileInputStream(file);
/* 268 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 269 */         int len = 0;
/* 270 */         while ((len = fis.read(bytes)) > 0)
/* 271 */           baos.write(bytes, 0, len);
/* 272 */         fis.close();
/* 273 */         bytes = baos.toByteArray();
/* 274 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 275 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 277 */           _os_.unmarshal_int();
/* 278 */           _os_.unmarshal_int();
/* 279 */           _os_.unmarshal_int();
/*     */         }
/* 281 */         _os_.unmarshal_int();
/* 282 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 285 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 287 */           SActivityCfg _v_ = new SActivityCfg();
/* 288 */           _v_.unmarshal(_os_);
/* 289 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 290 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 295 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 300 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SActivityCfg getOld(int key)
/*     */   {
/* 308 */     return (SActivityCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SActivityCfg get(int key)
/*     */   {
/* 313 */     return (SActivityCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SActivityCfg> getOldAll()
/*     */   {
/* 318 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SActivityCfg> getAll()
/*     */   {
/* 323 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SActivityCfg> newAll)
/*     */   {
/* 328 */     oldAll = all;
/* 329 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 334 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\SActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */