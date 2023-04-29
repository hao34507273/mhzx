/*     */ package mzm.gsp.gang.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class GangMiFangConst
/*     */ {
/*  13 */   private static volatile GangMiFangConst oldInstance = null;
/*     */   
/*  15 */   private static GangMiFangConst instance = new GangMiFangConst();
/*     */   public int NEED_YAODIAN_LEVEL;
/*     */   public int NEED_LIVELY_LOW_RATE;
/*     */   public int OPEN_DURATION;
/*     */   public int NEED_MATERIAL_NUM;
/*     */   
/*     */   public static GangMiFangConst getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static GangMiFangConst getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int LIAYO_SKILL_BAG_ID;
/*     */   
/*     */   public int NPC_ID;
/*     */   
/*     */   public int TASK_GRAPH_ID;
/*     */   
/*     */   public int TASK_ID;
/*     */   
/*     */   public int MIFANG_TIPS;
/*     */   public static void loadXml(String dir)
/*     */   {
/*  43 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  48 */     String path = dir + "mzm.gsp.gang.confbean.GangMiFangConst.xml";
/*     */     try
/*     */     {
/*  51 */       SAXReader reader = new SAXReader();
/*  52 */       org.dom4j.Document doc = reader.read(new File(path));
/*  53 */       Element root = doc.getRootElement();
/*  54 */       Map<String, Element> data = new java.util.HashMap();
/*  55 */       java.util.List<?> nodeList = root.elements();
/*  56 */       int len = nodeList.size();
/*  57 */       for (int i = 0; i < len; i++)
/*     */       {
/*  59 */         Element element = (Element)nodeList.get(i);
/*  60 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  63 */           String name = element.attributeValue("name");
/*  64 */           if (data.put(name, element) != null)
/*  65 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  68 */       this.NEED_YAODIAN_LEVEL = Integer.valueOf(((Element)data.get("NEED_YAODIAN_LEVEL")).attributeValue("value")).intValue();
/*  69 */       this.NEED_LIVELY_LOW_RATE = Integer.valueOf(((Element)data.get("NEED_LIVELY_LOW_RATE")).attributeValue("value")).intValue();
/*  70 */       this.OPEN_DURATION = Integer.valueOf(((Element)data.get("OPEN_DURATION")).attributeValue("value")).intValue();
/*  71 */       this.NEED_MATERIAL_NUM = Integer.valueOf(((Element)data.get("NEED_MATERIAL_NUM")).attributeValue("value")).intValue();
/*  72 */       this.LIAYO_SKILL_BAG_ID = Integer.valueOf(((Element)data.get("LIAYO_SKILL_BAG_ID")).attributeValue("value")).intValue();
/*  73 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/*  74 */       this.TASK_GRAPH_ID = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID")).attributeValue("value")).intValue();
/*  75 */       this.TASK_ID = Integer.valueOf(((Element)data.get("TASK_ID")).attributeValue("value")).intValue();
/*  76 */       this.MIFANG_TIPS = Integer.valueOf(((Element)data.get("MIFANG_TIPS")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  80 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  85 */     String path = dir + "mzm.gsp.gang.confbean.GangMiFangConst.xml";
/*     */     try
/*     */     {
/*  88 */       SAXReader reader = new SAXReader();
/*  89 */       org.dom4j.Document doc = reader.read(new File(path));
/*  90 */       Element root = doc.getRootElement();
/*  91 */       Map<String, Element> data = new java.util.HashMap();
/*  92 */       java.util.List<?> nodeList = root.elements();
/*  93 */       int len = nodeList.size();
/*  94 */       for (int i = 0; i < len; i++)
/*     */       {
/*  96 */         Element element = (Element)nodeList.get(i);
/*  97 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/* 100 */           String name = element.attributeValue("name");
/* 101 */           if (data.put(name, element) != null)
/* 102 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 105 */       this.NEED_YAODIAN_LEVEL = Integer.valueOf(((Element)data.get("NEED_YAODIAN_LEVEL")).attributeValue("value")).intValue();
/* 106 */       this.NEED_LIVELY_LOW_RATE = Integer.valueOf(((Element)data.get("NEED_LIVELY_LOW_RATE")).attributeValue("value")).intValue();
/* 107 */       this.OPEN_DURATION = Integer.valueOf(((Element)data.get("OPEN_DURATION")).attributeValue("value")).intValue();
/* 108 */       this.NEED_MATERIAL_NUM = Integer.valueOf(((Element)data.get("NEED_MATERIAL_NUM")).attributeValue("value")).intValue();
/* 109 */       this.LIAYO_SKILL_BAG_ID = Integer.valueOf(((Element)data.get("LIAYO_SKILL_BAG_ID")).attributeValue("value")).intValue();
/* 110 */       this.NPC_ID = Integer.valueOf(((Element)data.get("NPC_ID")).attributeValue("value")).intValue();
/* 111 */       this.TASK_GRAPH_ID = Integer.valueOf(((Element)data.get("TASK_GRAPH_ID")).attributeValue("value")).intValue();
/* 112 */       this.TASK_ID = Integer.valueOf(((Element)data.get("TASK_ID")).attributeValue("value")).intValue();
/* 113 */       this.MIFANG_TIPS = Integer.valueOf(((Element)data.get("MIFANG_TIPS")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 117 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 121 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 124 */     String path = dir + "mzm.gsp.gang.confbean.GangMiFangConst.bny";
/*     */     try
/*     */     {
/* 127 */       File file = new File(path);
/* 128 */       if (file.exists())
/*     */       {
/* 130 */         byte[] bytes = new byte['Ѐ'];
/* 131 */         FileInputStream fis = new FileInputStream(file);
/* 132 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 133 */         int len = 0;
/* 134 */         while ((len = fis.read(bytes)) > 0)
/* 135 */           baos.write(bytes, 0, len);
/* 136 */         fis.close();
/* 137 */         bytes = baos.toByteArray();
/* 138 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 139 */         this.NEED_YAODIAN_LEVEL = _os_.unmarshal_int();
/* 140 */         this.NEED_LIVELY_LOW_RATE = _os_.unmarshal_int();
/* 141 */         this.OPEN_DURATION = _os_.unmarshal_int();
/* 142 */         this.NEED_MATERIAL_NUM = _os_.unmarshal_int();
/* 143 */         this.LIAYO_SKILL_BAG_ID = _os_.unmarshal_int();
/* 144 */         this.NPC_ID = _os_.unmarshal_int();
/* 145 */         this.TASK_GRAPH_ID = _os_.unmarshal_int();
/* 146 */         this.TASK_ID = _os_.unmarshal_int();
/* 147 */         this.MIFANG_TIPS = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 152 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 158 */     String path = dir + "mzm.gsp.gang.confbean.GangMiFangConst.bny";
/*     */     try
/*     */     {
/* 161 */       File file = new File(path);
/* 162 */       if (file.exists())
/*     */       {
/* 164 */         byte[] bytes = new byte['Ѐ'];
/* 165 */         FileInputStream fis = new FileInputStream(file);
/* 166 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 167 */         int len = 0;
/* 168 */         while ((len = fis.read(bytes)) > 0)
/* 169 */           baos.write(bytes, 0, len);
/* 170 */         fis.close();
/* 171 */         bytes = baos.toByteArray();
/* 172 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 173 */         this.NEED_YAODIAN_LEVEL = _os_.unmarshal_int();
/* 174 */         this.NEED_LIVELY_LOW_RATE = _os_.unmarshal_int();
/* 175 */         this.OPEN_DURATION = _os_.unmarshal_int();
/* 176 */         this.NEED_MATERIAL_NUM = _os_.unmarshal_int();
/* 177 */         this.LIAYO_SKILL_BAG_ID = _os_.unmarshal_int();
/* 178 */         this.NPC_ID = _os_.unmarshal_int();
/* 179 */         this.TASK_GRAPH_ID = _os_.unmarshal_int();
/* 180 */         this.TASK_ID = _os_.unmarshal_int();
/* 181 */         this.MIFANG_TIPS = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 186 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(GangMiFangConst newInstance)
/*     */   {
/* 192 */     oldInstance = instance;
/* 193 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 198 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\confbean\GangMiFangConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */