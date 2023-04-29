/*     */ package mzm.gsp.mounts.confbean;
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
/*     */ public class SMountsRankOriginalCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMountsRankOriginalCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMountsRankOriginalCfg> all = null;
/*     */   
/*     */   public int id;
/*     */   public int mountsCfgId;
/*     */   public int mountsRank;
/*     */   public int rankUpCostMountsNum;
/*  22 */   public java.util.ArrayList<Pro2Value> proList = new java.util.ArrayList();
/*     */   public int activeSkillCfgId;
/*     */   public int activeSkillLevel;
/*     */   public int needRoleLevel;
/*     */   public int rankUpCostItemId;
/*     */   public int rankUpcostItemType;
/*     */   public int rankUpCostItemIdNum;
/*     */   public int rankUpNeedScoreNum;
/*     */   public int rankUpConvertScore;
/*     */   public int unlockItemId;
/*     */   public int unlockItemIdNum;
/*     */   public int speed;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  37 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  38 */     this.mountsCfgId = Integer.valueOf(rootElement.attributeValue("mountsCfgId")).intValue();
/*  39 */     this.mountsRank = Integer.valueOf(rootElement.attributeValue("mountsRank")).intValue();
/*  40 */     this.rankUpCostMountsNum = Integer.valueOf(rootElement.attributeValue("rankUpCostMountsNum")).intValue();
/*     */     
/*  42 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "proList");
/*  43 */     if (collectionElement == null)
/*     */     {
/*  45 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  48 */     List<?> _nodeList = collectionElement.elements();
/*  49 */     int _len = _nodeList.size();
/*  50 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  52 */       Element elem = (Element)_nodeList.get(i);
/*  53 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.mounts.confbean.Pro2Value"))
/*     */       {
/*     */         Pro2Value _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  60 */           _v_ = new Pro2Value();
/*  61 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  68 */         this.proList.add(_v_);
/*     */       }
/*     */     }
/*  71 */     this.activeSkillCfgId = Integer.valueOf(rootElement.attributeValue("activeSkillCfgId")).intValue();
/*  72 */     this.activeSkillLevel = Integer.valueOf(rootElement.attributeValue("activeSkillLevel")).intValue();
/*  73 */     this.needRoleLevel = Integer.valueOf(rootElement.attributeValue("needRoleLevel")).intValue();
/*  74 */     this.rankUpCostItemId = Integer.valueOf(rootElement.attributeValue("rankUpCostItemId")).intValue();
/*  75 */     this.rankUpcostItemType = Integer.valueOf(rootElement.attributeValue("rankUpcostItemType")).intValue();
/*  76 */     this.rankUpCostItemIdNum = Integer.valueOf(rootElement.attributeValue("rankUpCostItemIdNum")).intValue();
/*  77 */     this.rankUpNeedScoreNum = Integer.valueOf(rootElement.attributeValue("rankUpNeedScoreNum")).intValue();
/*  78 */     this.rankUpConvertScore = Integer.valueOf(rootElement.attributeValue("rankUpConvertScore")).intValue();
/*  79 */     this.unlockItemId = Integer.valueOf(rootElement.attributeValue("unlockItemId")).intValue();
/*  80 */     this.unlockItemIdNum = Integer.valueOf(rootElement.attributeValue("unlockItemIdNum")).intValue();
/*  81 */     this.speed = Integer.valueOf(rootElement.attributeValue("speed")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  86 */     _os_.marshal(this.id);
/*  87 */     _os_.marshal(this.mountsCfgId);
/*  88 */     _os_.marshal(this.mountsRank);
/*  89 */     _os_.marshal(this.rankUpCostMountsNum);
/*  90 */     _os_.compact_uint32(this.proList.size());
/*  91 */     for (Pro2Value _v_ : this.proList)
/*     */     {
/*  93 */       _os_.marshal(_v_);
/*     */     }
/*  95 */     _os_.marshal(this.activeSkillCfgId);
/*  96 */     _os_.marshal(this.activeSkillLevel);
/*  97 */     _os_.marshal(this.needRoleLevel);
/*  98 */     _os_.marshal(this.rankUpCostItemId);
/*  99 */     _os_.marshal(this.rankUpcostItemType);
/* 100 */     _os_.marshal(this.rankUpCostItemIdNum);
/* 101 */     _os_.marshal(this.rankUpNeedScoreNum);
/* 102 */     _os_.marshal(this.rankUpConvertScore);
/* 103 */     _os_.marshal(this.unlockItemId);
/* 104 */     _os_.marshal(this.unlockItemIdNum);
/* 105 */     _os_.marshal(this.speed);
/* 106 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 111 */     this.id = _os_.unmarshal_int();
/* 112 */     this.mountsCfgId = _os_.unmarshal_int();
/* 113 */     this.mountsRank = _os_.unmarshal_int();
/* 114 */     this.rankUpCostMountsNum = _os_.unmarshal_int();
/* 115 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 118 */       Pro2Value _v_ = new Pro2Value();
/* 119 */       _v_.unmarshal(_os_);
/* 120 */       this.proList.add(_v_);
/*     */     }
/* 122 */     this.activeSkillCfgId = _os_.unmarshal_int();
/* 123 */     this.activeSkillLevel = _os_.unmarshal_int();
/* 124 */     this.needRoleLevel = _os_.unmarshal_int();
/* 125 */     this.rankUpCostItemId = _os_.unmarshal_int();
/* 126 */     this.rankUpcostItemType = _os_.unmarshal_int();
/* 127 */     this.rankUpCostItemIdNum = _os_.unmarshal_int();
/* 128 */     this.rankUpNeedScoreNum = _os_.unmarshal_int();
/* 129 */     this.rankUpConvertScore = _os_.unmarshal_int();
/* 130 */     this.unlockItemId = _os_.unmarshal_int();
/* 131 */     this.unlockItemIdNum = _os_.unmarshal_int();
/* 132 */     this.speed = _os_.unmarshal_int();
/* 133 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 138 */     String path = dir + "mzm.gsp.mounts.confbean.SMountsRankOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 142 */       all = new java.util.HashMap();
/* 143 */       SAXReader reader = new SAXReader();
/* 144 */       org.dom4j.Document doc = reader.read(new File(path));
/* 145 */       Element root = doc.getRootElement();
/* 146 */       List<?> nodeList = root.elements();
/* 147 */       int len = nodeList.size();
/* 148 */       for (int i = 0; i < len; i++)
/*     */       {
/* 150 */         Element elem = (Element)nodeList.get(i);
/* 151 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.mounts.confbean.SMountsRankOriginalCfg"))
/*     */         {
/*     */ 
/* 154 */           SMountsRankOriginalCfg obj = new SMountsRankOriginalCfg();
/* 155 */           obj.loadFromXml(elem);
/* 156 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 157 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 162 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMountsRankOriginalCfg> all)
/*     */   {
/* 168 */     String path = dir + "mzm.gsp.mounts.confbean.SMountsRankOriginalCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 172 */       SAXReader reader = new SAXReader();
/* 173 */       org.dom4j.Document doc = reader.read(new File(path));
/* 174 */       Element root = doc.getRootElement();
/* 175 */       List<?> nodeList = root.elements();
/* 176 */       int len = nodeList.size();
/* 177 */       for (int i = 0; i < len; i++)
/*     */       {
/* 179 */         Element elem = (Element)nodeList.get(i);
/* 180 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.mounts.confbean.SMountsRankOriginalCfg"))
/*     */         {
/*     */ 
/* 183 */           SMountsRankOriginalCfg obj = new SMountsRankOriginalCfg();
/* 184 */           obj.loadFromXml(elem);
/* 185 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 186 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 191 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 197 */     all = new java.util.HashMap();
/*     */     
/* 199 */     String path = dir + "mzm.gsp.mounts.confbean.SMountsRankOriginalCfg.bny";
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
/* 226 */           SMountsRankOriginalCfg _v_ = new SMountsRankOriginalCfg();
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
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMountsRankOriginalCfg> all)
/*     */   {
/* 246 */     String path = dir + "mzm.gsp.mounts.confbean.SMountsRankOriginalCfg.bny";
/*     */     try
/*     */     {
/* 249 */       File file = new File(path);
/* 250 */       if (file.exists())
/*     */       {
/* 252 */         byte[] bytes = new byte['Ѐ'];
/* 253 */         FileInputStream fis = new FileInputStream(file);
/* 254 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 255 */         int len = 0;
/* 256 */         while ((len = fis.read(bytes)) > 0)
/* 257 */           baos.write(bytes, 0, len);
/* 258 */         fis.close();
/* 259 */         bytes = baos.toByteArray();
/* 260 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 261 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 263 */           _os_.unmarshal_int();
/* 264 */           _os_.unmarshal_int();
/* 265 */           _os_.unmarshal_int();
/*     */         }
/* 267 */         _os_.unmarshal_int();
/* 268 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 271 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 273 */           SMountsRankOriginalCfg _v_ = new SMountsRankOriginalCfg();
/* 274 */           _v_.unmarshal(_os_);
/* 275 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 276 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 281 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 286 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMountsRankOriginalCfg getOld(int key)
/*     */   {
/* 294 */     return (SMountsRankOriginalCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMountsRankOriginalCfg get(int key)
/*     */   {
/* 299 */     return (SMountsRankOriginalCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMountsRankOriginalCfg> getOldAll()
/*     */   {
/* 304 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMountsRankOriginalCfg> getAll()
/*     */   {
/* 309 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMountsRankOriginalCfg> newAll)
/*     */   {
/* 314 */     oldAll = all;
/* 315 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 320 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\confbean\SMountsRankOriginalCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */