/*     */ package mzm.gsp.group.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class GroupConsts
/*     */ {
/*  13 */   private static volatile GroupConsts oldInstance = null;
/*     */   
/*  15 */   private static GroupConsts instance = new GroupConsts();
/*     */   public int CREATE_GROUP_LEVEL;
/*     */   public int JOIN_GROUP_LEVEL;
/*     */   public int JOIN_GROUP_MAX_NUM;
/*     */   public int GROUP_MEMBER_MAX_NUM;
/*     */   
/*     */   public static GroupConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static GroupConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public int MEMBER_NUM_IN_GROUP_IMAGE;
/*     */   
/*     */   public int GROUP_NAME_MAX_LENGTH;
/*     */   
/*     */   public int GROUP_ANNOUNCEMENT_MAX_LENGTH;
/*     */   
/*     */   public int CLIENT_GROUP_LIST_REFRESH_INTERVAL;
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  42 */     instance.doLoadXml(dir);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String dir)
/*     */   {
/*  47 */     String path = dir + "mzm.gsp.group.confbean.GroupConsts.xml";
/*     */     try
/*     */     {
/*  50 */       SAXReader reader = new SAXReader();
/*  51 */       org.dom4j.Document doc = reader.read(new File(path));
/*  52 */       Element root = doc.getRootElement();
/*  53 */       Map<String, Element> data = new java.util.HashMap();
/*  54 */       java.util.List<?> nodeList = root.elements();
/*  55 */       int len = nodeList.size();
/*  56 */       for (int i = 0; i < len; i++)
/*     */       {
/*  58 */         Element element = (Element)nodeList.get(i);
/*  59 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  62 */           String name = element.attributeValue("name");
/*  63 */           if (data.put(name, element) != null)
/*  64 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/*  67 */       this.CREATE_GROUP_LEVEL = Integer.valueOf(((Element)data.get("CREATE_GROUP_LEVEL")).attributeValue("value")).intValue();
/*  68 */       this.JOIN_GROUP_LEVEL = Integer.valueOf(((Element)data.get("JOIN_GROUP_LEVEL")).attributeValue("value")).intValue();
/*  69 */       this.JOIN_GROUP_MAX_NUM = Integer.valueOf(((Element)data.get("JOIN_GROUP_MAX_NUM")).attributeValue("value")).intValue();
/*  70 */       this.GROUP_MEMBER_MAX_NUM = Integer.valueOf(((Element)data.get("GROUP_MEMBER_MAX_NUM")).attributeValue("value")).intValue();
/*  71 */       this.MEMBER_NUM_IN_GROUP_IMAGE = Integer.valueOf(((Element)data.get("MEMBER_NUM_IN_GROUP_IMAGE")).attributeValue("value")).intValue();
/*  72 */       this.GROUP_NAME_MAX_LENGTH = Integer.valueOf(((Element)data.get("GROUP_NAME_MAX_LENGTH")).attributeValue("value")).intValue();
/*  73 */       this.GROUP_ANNOUNCEMENT_MAX_LENGTH = Integer.valueOf(((Element)data.get("GROUP_ANNOUNCEMENT_MAX_LENGTH")).attributeValue("value")).intValue();
/*  74 */       this.CLIENT_GROUP_LIST_REFRESH_INTERVAL = Integer.valueOf(((Element)data.get("CLIENT_GROUP_LIST_REFRESH_INTERVAL")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  78 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String dir) {
/*  83 */     String path = dir + "mzm.gsp.group.confbean.GroupConsts.xml";
/*     */     try
/*     */     {
/*  86 */       SAXReader reader = new SAXReader();
/*  87 */       org.dom4j.Document doc = reader.read(new File(path));
/*  88 */       Element root = doc.getRootElement();
/*  89 */       Map<String, Element> data = new java.util.HashMap();
/*  90 */       java.util.List<?> nodeList = root.elements();
/*  91 */       int len = nodeList.size();
/*  92 */       for (int i = 0; i < len; i++)
/*     */       {
/*  94 */         Element element = (Element)nodeList.get(i);
/*  95 */         if (element.getName().equalsIgnoreCase("row"))
/*     */         {
/*     */ 
/*  98 */           String name = element.attributeValue("name");
/*  99 */           if (data.put(name, element) != null)
/* 100 */             throw new RuntimeException("duplicate const : " + name);
/*     */         }
/*     */       }
/* 103 */       this.CREATE_GROUP_LEVEL = Integer.valueOf(((Element)data.get("CREATE_GROUP_LEVEL")).attributeValue("value")).intValue();
/* 104 */       this.JOIN_GROUP_LEVEL = Integer.valueOf(((Element)data.get("JOIN_GROUP_LEVEL")).attributeValue("value")).intValue();
/* 105 */       this.JOIN_GROUP_MAX_NUM = Integer.valueOf(((Element)data.get("JOIN_GROUP_MAX_NUM")).attributeValue("value")).intValue();
/* 106 */       this.GROUP_MEMBER_MAX_NUM = Integer.valueOf(((Element)data.get("GROUP_MEMBER_MAX_NUM")).attributeValue("value")).intValue();
/* 107 */       this.MEMBER_NUM_IN_GROUP_IMAGE = Integer.valueOf(((Element)data.get("MEMBER_NUM_IN_GROUP_IMAGE")).attributeValue("value")).intValue();
/* 108 */       this.GROUP_NAME_MAX_LENGTH = Integer.valueOf(((Element)data.get("GROUP_NAME_MAX_LENGTH")).attributeValue("value")).intValue();
/* 109 */       this.GROUP_ANNOUNCEMENT_MAX_LENGTH = Integer.valueOf(((Element)data.get("GROUP_ANNOUNCEMENT_MAX_LENGTH")).attributeValue("value")).intValue();
/* 110 */       this.CLIENT_GROUP_LIST_REFRESH_INTERVAL = Integer.valueOf(((Element)data.get("CLIENT_GROUP_LIST_REFRESH_INTERVAL")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 114 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/* 118 */   public static void loadBny(String dir) { instance._loadBny(dir); }
/*     */   
/*     */   public void _loadBny(String dir) {
/* 121 */     String path = dir + "mzm.gsp.group.confbean.GroupConsts.bny";
/*     */     try
/*     */     {
/* 124 */       File file = new File(path);
/* 125 */       if (file.exists())
/*     */       {
/* 127 */         byte[] bytes = new byte['Ѐ'];
/* 128 */         FileInputStream fis = new FileInputStream(file);
/* 129 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 130 */         int len = 0;
/* 131 */         while ((len = fis.read(bytes)) > 0)
/* 132 */           baos.write(bytes, 0, len);
/* 133 */         fis.close();
/* 134 */         bytes = baos.toByteArray();
/* 135 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 136 */         this.CREATE_GROUP_LEVEL = _os_.unmarshal_int();
/* 137 */         this.JOIN_GROUP_LEVEL = _os_.unmarshal_int();
/* 138 */         this.JOIN_GROUP_MAX_NUM = _os_.unmarshal_int();
/* 139 */         this.GROUP_MEMBER_MAX_NUM = _os_.unmarshal_int();
/* 140 */         this.MEMBER_NUM_IN_GROUP_IMAGE = _os_.unmarshal_int();
/* 141 */         this.GROUP_NAME_MAX_LENGTH = _os_.unmarshal_int();
/* 142 */         this.GROUP_ANNOUNCEMENT_MAX_LENGTH = _os_.unmarshal_int();
/* 143 */         this.CLIENT_GROUP_LIST_REFRESH_INTERVAL = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 148 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String dir)
/*     */   {
/* 154 */     String path = dir + "mzm.gsp.group.confbean.GroupConsts.bny";
/*     */     try
/*     */     {
/* 157 */       File file = new File(path);
/* 158 */       if (file.exists())
/*     */       {
/* 160 */         byte[] bytes = new byte['Ѐ'];
/* 161 */         FileInputStream fis = new FileInputStream(file);
/* 162 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 163 */         int len = 0;
/* 164 */         while ((len = fis.read(bytes)) > 0)
/* 165 */           baos.write(bytes, 0, len);
/* 166 */         fis.close();
/* 167 */         bytes = baos.toByteArray();
/* 168 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 169 */         this.CREATE_GROUP_LEVEL = _os_.unmarshal_int();
/* 170 */         this.JOIN_GROUP_LEVEL = _os_.unmarshal_int();
/* 171 */         this.JOIN_GROUP_MAX_NUM = _os_.unmarshal_int();
/* 172 */         this.GROUP_MEMBER_MAX_NUM = _os_.unmarshal_int();
/* 173 */         this.MEMBER_NUM_IN_GROUP_IMAGE = _os_.unmarshal_int();
/* 174 */         this.GROUP_NAME_MAX_LENGTH = _os_.unmarshal_int();
/* 175 */         this.GROUP_ANNOUNCEMENT_MAX_LENGTH = _os_.unmarshal_int();
/* 176 */         this.CLIENT_GROUP_LIST_REFRESH_INTERVAL = _os_.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 181 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(GroupConsts newInstance)
/*     */   {
/* 187 */     oldInstance = instance;
/* 188 */     instance = newInstance;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 193 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\confbean\GroupConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */