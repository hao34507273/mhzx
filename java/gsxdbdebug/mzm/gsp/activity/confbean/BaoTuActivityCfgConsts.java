/*     */ package mzm.gsp.activity.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class BaoTuActivityCfgConsts
/*     */ {
/*  13 */   private static volatile BaoTuActivityCfgConsts oldInstance = null;
/*     */   
/*  15 */   private static BaoTuActivityCfgConsts instance = new BaoTuActivityCfgConsts();
/*     */   public int ACTIVITYID;
/*     */   public int GRAPH_ID;
/*     */   public int NPC_ID;
/*     */   public int NPC_SERVICE;
/*     */   public int REWARDID1;
/*     */   
/*     */   public static BaoTuActivityCfgConsts getOldInstance() {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static BaoTuActivityCfgConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int AWARDRATE1;
/*     */   
/*     */   public int REWARDID2;
/*     */   
/*     */   public int AWARDRATE2;
/*     */   
/*     */   public int MAX_AWARD_COUNT;
/*     */   
/*     */   public int MONSTER_TYPE_ID;
/*     */   
/*     */   public int GUIDE_GRAPH_ID;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  45 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  50 */     String path = dir + "mzm.gsp.activity.confbean.BaoTuActivityCfgConsts.xml";
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
/*  70 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/*  71 */       this.GRAPH_ID = Integer.valueOf(((Element)data.get("GRAPH_ID")).attributeValue("value")).intValue();
/*  72 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/*  73 */       this.NPC_SERVICE = Integer.valueOf(((Element)data.get("NPC_SERVICE")).attributeValue("value")).intValue();
/*  74 */       this.REWARDID1 = Integer.valueOf(((Element)data.get("REWARDID1")).attributeValue("value")).intValue();
/*  75 */       this.AWARDRATE1 = Integer.valueOf(((Element)data.get("AWARDRATE1")).attributeValue("value")).intValue();
/*  76 */       this.REWARDID2 = Integer.valueOf(((Element)data.get("REWARDID2")).attributeValue("value")).intValue();
/*  77 */       this.AWARDRATE2 = Integer.valueOf(((Element)data.get("AWARDRATE2")).attributeValue("value")).intValue();
/*  78 */       this.MAX_AWARD_COUNT = Integer.valueOf(((Element)data.get("MAX_AWARD_COUNT")).attributeValue("value")).intValue();
/*  79 */       this.MONSTER_TYPE_ID = Integer.valueOf(((Element)data.get("MONSTER_TYPE_ID")).attributeValue("value")).intValue();
/*  80 */       this.GUIDE_GRAPH_ID = Integer.valueOf(((Element)data.get("GUIDE_GRAPH_ID")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  84 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  89 */     String path = dir + "mzm.gsp.activity.confbean.BaoTuActivityCfgConsts.xml";
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
/* 109 */       this.ACTIVITYID = Integer.valueOf(((Element)data.get("ACTIVITYID")).attributeValue("value")).intValue();
/* 110 */       this.GRAPH_ID = Integer.valueOf(((Element)data.get("GRAPH_ID")).attributeValue("value")).intValue();
/* 111 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/* 112 */       this.NPC_SERVICE = Integer.valueOf(((Element)data.get("NPC_SERVICE")).attributeValue("value")).intValue();
/* 113 */       this.REWARDID1 = Integer.valueOf(((Element)data.get("REWARDID1")).attributeValue("value")).intValue();
/* 114 */       this.AWARDRATE1 = Integer.valueOf(((Element)data.get("AWARDRATE1")).attributeValue("value")).intValue();
/* 115 */       this.REWARDID2 = Integer.valueOf(((Element)data.get("REWARDID2")).attributeValue("value")).intValue();
/* 116 */       this.AWARDRATE2 = Integer.valueOf(((Element)data.get("AWARDRATE2")).attributeValue("value")).intValue();
/* 117 */       this.MAX_AWARD_COUNT = Integer.valueOf(((Element)data.get("MAX_AWARD_COUNT")).attributeValue("value")).intValue();
/* 118 */       this.MONSTER_TYPE_ID = Integer.valueOf(((Element)data.get("MONSTER_TYPE_ID")).attributeValue("value")).intValue();
/* 119 */       this.GUIDE_GRAPH_ID = Integer.valueOf(((Element)data.get("GUIDE_GRAPH_ID")).attributeValue("value")).intValue();
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
/* 130 */     String path = dir + "mzm.gsp.activity.confbean.BaoTuActivityCfgConsts.bny";
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
/* 145 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 146 */         this.GRAPH_ID = _os_.unmarshal_int();
/* 147 */         this.NPC_ID = _os_.unmarshal_int();
/* 148 */         this.NPC_SERVICE = _os_.unmarshal_int();
/* 149 */         this.REWARDID1 = _os_.unmarshal_int();
/* 150 */         this.AWARDRATE1 = _os_.unmarshal_int();
/* 151 */         this.REWARDID2 = _os_.unmarshal_int();
/* 152 */         this.AWARDRATE2 = _os_.unmarshal_int();
/* 153 */         this.MAX_AWARD_COUNT = _os_.unmarshal_int();
/* 154 */         this.MONSTER_TYPE_ID = _os_.unmarshal_int();
/* 155 */         this.GUIDE_GRAPH_ID = _os_.unmarshal_int();
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
/* 166 */     String path = dir + "mzm.gsp.activity.confbean.BaoTuActivityCfgConsts.bny";
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
/* 181 */         this.ACTIVITYID = _os_.unmarshal_int();
/* 182 */         this.GRAPH_ID = _os_.unmarshal_int();
/* 183 */         this.NPC_ID = _os_.unmarshal_int();
/* 184 */         this.NPC_SERVICE = _os_.unmarshal_int();
/* 185 */         this.REWARDID1 = _os_.unmarshal_int();
/* 186 */         this.AWARDRATE1 = _os_.unmarshal_int();
/* 187 */         this.REWARDID2 = _os_.unmarshal_int();
/* 188 */         this.AWARDRATE2 = _os_.unmarshal_int();
/* 189 */         this.MAX_AWARD_COUNT = _os_.unmarshal_int();
/* 190 */         this.MONSTER_TYPE_ID = _os_.unmarshal_int();
/* 191 */         this.GUIDE_GRAPH_ID = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 196 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(BaoTuActivityCfgConsts newInstance)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\BaoTuActivityCfgConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */