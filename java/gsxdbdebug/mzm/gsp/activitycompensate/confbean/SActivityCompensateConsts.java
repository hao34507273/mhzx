/*     */ package mzm.gsp.activitycompensate.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SActivityCompensateConsts
/*     */ {
/*  13 */   private static volatile SActivityCompensateConsts oldInstance = null;
/*     */   
/*  15 */   private static SActivityCompensateConsts instance = new SActivityCompensateConsts();
/*     */   public int FreeAwardModifyid;
/*     */   public int GoldAwardModifyid;
/*     */   public int YuanBaoAwardModifyid;
/*     */   public int MaxCompensateDays;
/*     */   public int RefreshTimeCfgid;
/*     */   
/*     */   public static SActivityCompensateConsts getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SActivityCompensateConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int NeedLevel;
/*     */   
/*     */   public int ZhenYaoActivityid;
/*     */   
/*     */   public int ZhenYaoDoublePointCost;
/*     */   
/*     */   public int ZhenYaoDoublePointFreeAward;
/*     */   
/*     */   public int ZhenYaoDoublePointGoldAward;
/*     */   
/*     */   public int ZhenYaoDoublePointYuanbaoAward;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  45 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  50 */     String path = dir + "mzm.gsp.activitycompensate.confbean.SActivityCompensateConsts.xml";
/*     */     try
/*     */     {
/*  53 */       SAXReader reader = new SAXReader();
/*  54 */       org.dom4j.Document doc = reader.read(new File(path));
/*  55 */       Element root = doc.getRootElement();
/*  56 */       Map<String, Element> data = new java.util.HashMap();
/*  57 */       java.util.List<?> nodeList = root.elements();
/*  58 */       int len = nodeList.size();
/*  59 */       for (int i = 0; i < len; i++)
/*     */       {
/*  61 */         Element element = (Element)nodeList.get(i);
/*  62 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  65 */           String name = element.attributeValue("name");
/*  66 */           if (data.put(name, element) != null)
/*  67 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  70 */       this.FreeAwardModifyid = Integer.valueOf(((Element)data.get("FreeAwardModifyid")).attributeValue("value")).intValue();
/*  71 */       this.GoldAwardModifyid = Integer.valueOf(((Element)data.get("GoldAwardModifyid")).attributeValue("value")).intValue();
/*  72 */       this.YuanBaoAwardModifyid = Integer.valueOf(((Element)data.get("YuanBaoAwardModifyid")).attributeValue("value")).intValue();
/*  73 */       this.MaxCompensateDays = Integer.valueOf(((Element)data.get("MaxCompensateDays")).attributeValue("value")).intValue();
/*  74 */       this.RefreshTimeCfgid = Integer.valueOf(((Element)data.get("RefreshTimeCfgid")).attributeValue("value")).intValue();
/*  75 */       this.NeedLevel = Integer.valueOf(((Element)data.get("NeedLevel")).attributeValue("value")).intValue();
/*  76 */       this.ZhenYaoActivityid = Integer.valueOf(((Element)data.get("ZhenYaoActivityid")).attributeValue("value")).intValue();
/*  77 */       this.ZhenYaoDoublePointCost = Integer.valueOf(((Element)data.get("ZhenYaoDoublePointCost")).attributeValue("value")).intValue();
/*  78 */       this.ZhenYaoDoublePointFreeAward = Integer.valueOf(((Element)data.get("ZhenYaoDoublePointFreeAward")).attributeValue("value")).intValue();
/*  79 */       this.ZhenYaoDoublePointGoldAward = Integer.valueOf(((Element)data.get("ZhenYaoDoublePointGoldAward")).attributeValue("value")).intValue();
/*  80 */       this.ZhenYaoDoublePointYuanbaoAward = Integer.valueOf(((Element)data.get("ZhenYaoDoublePointYuanbaoAward")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  84 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  89 */     String path = dir + "mzm.gsp.activitycompensate.confbean.SActivityCompensateConsts.xml";
/*     */     try
/*     */     {
/*  92 */       SAXReader reader = new SAXReader();
/*  93 */       org.dom4j.Document doc = reader.read(new File(path));
/*  94 */       Element root = doc.getRootElement();
/*  95 */       Map<String, Element> data = new java.util.HashMap();
/*  96 */       java.util.List<?> nodeList = root.elements();
/*  97 */       int len = nodeList.size();
/*  98 */       for (int i = 0; i < len; i++)
/*     */       {
/* 100 */         Element element = (Element)nodeList.get(i);
/* 101 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 104 */           String name = element.attributeValue("name");
/* 105 */           if (data.put(name, element) != null)
/* 106 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 109 */       this.FreeAwardModifyid = Integer.valueOf(((Element)data.get("FreeAwardModifyid")).attributeValue("value")).intValue();
/* 110 */       this.GoldAwardModifyid = Integer.valueOf(((Element)data.get("GoldAwardModifyid")).attributeValue("value")).intValue();
/* 111 */       this.YuanBaoAwardModifyid = Integer.valueOf(((Element)data.get("YuanBaoAwardModifyid")).attributeValue("value")).intValue();
/* 112 */       this.MaxCompensateDays = Integer.valueOf(((Element)data.get("MaxCompensateDays")).attributeValue("value")).intValue();
/* 113 */       this.RefreshTimeCfgid = Integer.valueOf(((Element)data.get("RefreshTimeCfgid")).attributeValue("value")).intValue();
/* 114 */       this.NeedLevel = Integer.valueOf(((Element)data.get("NeedLevel")).attributeValue("value")).intValue();
/* 115 */       this.ZhenYaoActivityid = Integer.valueOf(((Element)data.get("ZhenYaoActivityid")).attributeValue("value")).intValue();
/* 116 */       this.ZhenYaoDoublePointCost = Integer.valueOf(((Element)data.get("ZhenYaoDoublePointCost")).attributeValue("value")).intValue();
/* 117 */       this.ZhenYaoDoublePointFreeAward = Integer.valueOf(((Element)data.get("ZhenYaoDoublePointFreeAward")).attributeValue("value")).intValue();
/* 118 */       this.ZhenYaoDoublePointGoldAward = Integer.valueOf(((Element)data.get("ZhenYaoDoublePointGoldAward")).attributeValue("value")).intValue();
/* 119 */       this.ZhenYaoDoublePointYuanbaoAward = Integer.valueOf(((Element)data.get("ZhenYaoDoublePointYuanbaoAward")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 123 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 127 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 130 */     String path = dir + "mzm.gsp.activitycompensate.confbean.SActivityCompensateConsts.bny";
/*     */     try
/*     */     {
/* 133 */       File file = new File(path);
/* 134 */       if (file.exists())
/*     */       {
/* 136 */         byte[] bytes = new byte['Ѐ'];
/* 137 */         FileInputStream fis = new FileInputStream(file);
/* 138 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 139 */         int len = 0;
/* 140 */         while ((len = fis.read(bytes)) > 0)
/* 141 */           baos.write(bytes, 0, len);
/* 142 */         fis.close();
/* 143 */         bytes = baos.toByteArray();
/* 144 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 145 */         this.FreeAwardModifyid = _os_.unmarshal_int();
/* 146 */         this.GoldAwardModifyid = _os_.unmarshal_int();
/* 147 */         this.YuanBaoAwardModifyid = _os_.unmarshal_int();
/* 148 */         this.MaxCompensateDays = _os_.unmarshal_int();
/* 149 */         this.RefreshTimeCfgid = _os_.unmarshal_int();
/* 150 */         this.NeedLevel = _os_.unmarshal_int();
/* 151 */         this.ZhenYaoActivityid = _os_.unmarshal_int();
/* 152 */         this.ZhenYaoDoublePointCost = _os_.unmarshal_int();
/* 153 */         this.ZhenYaoDoublePointFreeAward = _os_.unmarshal_int();
/* 154 */         this.ZhenYaoDoublePointGoldAward = _os_.unmarshal_int();
/* 155 */         this.ZhenYaoDoublePointYuanbaoAward = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 160 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 166 */     String path = dir + "mzm.gsp.activitycompensate.confbean.SActivityCompensateConsts.bny";
/*     */     try
/*     */     {
/* 169 */       File file = new File(path);
/* 170 */       if (file.exists())
/*     */       {
/* 172 */         byte[] bytes = new byte['Ѐ'];
/* 173 */         FileInputStream fis = new FileInputStream(file);
/* 174 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 175 */         int len = 0;
/* 176 */         while ((len = fis.read(bytes)) > 0)
/* 177 */           baos.write(bytes, 0, len);
/* 178 */         fis.close();
/* 179 */         bytes = baos.toByteArray();
/* 180 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 181 */         this.FreeAwardModifyid = _os_.unmarshal_int();
/* 182 */         this.GoldAwardModifyid = _os_.unmarshal_int();
/* 183 */         this.YuanBaoAwardModifyid = _os_.unmarshal_int();
/* 184 */         this.MaxCompensateDays = _os_.unmarshal_int();
/* 185 */         this.RefreshTimeCfgid = _os_.unmarshal_int();
/* 186 */         this.NeedLevel = _os_.unmarshal_int();
/* 187 */         this.ZhenYaoActivityid = _os_.unmarshal_int();
/* 188 */         this.ZhenYaoDoublePointCost = _os_.unmarshal_int();
/* 189 */         this.ZhenYaoDoublePointFreeAward = _os_.unmarshal_int();
/* 190 */         this.ZhenYaoDoublePointGoldAward = _os_.unmarshal_int();
/* 191 */         this.ZhenYaoDoublePointYuanbaoAward = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 196 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SActivityCompensateConsts newInstance)
/*     */   {
/* 202 */     oldInstance = instance;
/* 203 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 208 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitycompensate\confbean\SActivityCompensateConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */