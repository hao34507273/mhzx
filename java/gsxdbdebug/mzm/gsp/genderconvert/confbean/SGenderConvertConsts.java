/*     */ package mzm.gsp.genderconvert.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SGenderConvertConsts
/*     */ {
/*  18 */   private static volatile SGenderConvertConsts oldInstance = null;
/*  19 */   private static SGenderConvertConsts instance = new SGenderConvertConsts();
/*     */   
/*     */   public static SGenderConvertConsts getOldInstance()
/*     */   {
/*  23 */     return oldInstance;
/*     */   }
/*     */   
/*     */   public static SGenderConvertConsts getInstance()
/*     */   {
/*  28 */     return instance;
/*     */   }
/*     */   
/*  31 */   public ArrayList<Integer> ActiveNeedGolds = new ArrayList();
/*     */   public int MONEY_TYPE;
/*     */   public int MONEY_NUM;
/*     */   public int LEVLE_LIMIT;
/*     */   public int CONVERT_CD_IN_HOUR;
/*     */   
/*     */   public static void loadXml(String paramString)
/*     */   {
/*  39 */     instance.doLoadXml(paramString);
/*     */   }
/*     */   
/*     */   private void doLoadXml(String paramString)
/*     */   {
/*  44 */     String str1 = paramString + "mzm.gsp.genderconvert.confbean.SGenderConvertConsts.xml";
/*     */     try
/*     */     {
/*  47 */       SAXReader localSAXReader = new SAXReader();
/*  48 */       Document localDocument = localSAXReader.read(new File(str1));
/*  49 */       Element localElement1 = localDocument.getRootElement();
/*  50 */       HashMap localHashMap = new HashMap();
/*  51 */       List localList = localElement1.elements();
/*  52 */       int i = localList.size();
/*  53 */       for (int j = 0; j < i; j++)
/*     */       {
/*  55 */         Element localElement2 = (Element)localList.get(j);
/*  56 */         if (localElement2.getName().equalsIgnoreCase("row"))
/*     */         {
/*  58 */           String str2 = localElement2.attributeValue("name");
/*  59 */           if (localHashMap.put(str2, localElement2) != null) {
/*  60 */             throw new RuntimeException("duplicate const : " + str2);
/*     */           }
/*     */         }
/*     */       }
/*  64 */       this.MONEY_TYPE = Integer.valueOf(((Element)localHashMap.get("MONEY_TYPE")).attributeValue("value")).intValue();
/*  65 */       this.MONEY_NUM = Integer.valueOf(((Element)localHashMap.get("MONEY_NUM")).attributeValue("value")).intValue();
/*  66 */       this.LEVLE_LIMIT = Integer.valueOf(((Element)localHashMap.get("LEVLE_LIMIT")).attributeValue("value")).intValue();
/*  67 */       this.CONVERT_CD_IN_HOUR = Integer.valueOf(((Element)localHashMap.get("CONVERT_CD_IN_HOUR")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*  71 */       throw new RuntimeException("load " + str1 + " failed", localException);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadXml(String paramString)
/*     */   {
/*  77 */     String str1 = paramString + "mzm.gsp.genderconvert.confbean.SGenderConvertConsts.xml";
/*     */     try
/*     */     {
/*  80 */       SAXReader localSAXReader = new SAXReader();
/*  81 */       Document localDocument = localSAXReader.read(new File(str1));
/*  82 */       Element localElement1 = localDocument.getRootElement();
/*  83 */       HashMap localHashMap = new HashMap();
/*  84 */       List localList = localElement1.elements();
/*  85 */       int i = localList.size();
/*  86 */       for (int j = 0; j < i; j++)
/*     */       {
/*  88 */         Element localElement2 = (Element)localList.get(j);
/*  89 */         if (localElement2.getName().equalsIgnoreCase("row"))
/*     */         {
/*  91 */           String str2 = localElement2.attributeValue("name");
/*  92 */           if (localHashMap.put(str2, localElement2) != null) {
/*  93 */             throw new RuntimeException("duplicate const : " + str2);
/*     */           }
/*     */         }
/*     */       }
/*  97 */       this.MONEY_TYPE = Integer.valueOf(((Element)localHashMap.get("MONEY_TYPE")).attributeValue("value")).intValue();
/*  98 */       this.MONEY_NUM = Integer.valueOf(((Element)localHashMap.get("MONEY_NUM")).attributeValue("value")).intValue();
/*  99 */       this.LEVLE_LIMIT = Integer.valueOf(((Element)localHashMap.get("LEVLE_LIMIT")).attributeValue("value")).intValue();
/* 100 */       this.CONVERT_CD_IN_HOUR = Integer.valueOf(((Element)localHashMap.get("CONVERT_CD_IN_HOUR")).attributeValue("value")).intValue();
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/* 104 */       throw new RuntimeException("load " + str1 + " failed", localException);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String paramString)
/*     */   {
/* 110 */     instance._loadBny(paramString);
/*     */   }
/*     */   
/*     */   public void _loadBny(String paramString)
/*     */   {
/* 115 */     String str = paramString + "mzm.gsp.genderconvert.confbean.SGenderConvertConsts.bny";
/*     */     try
/*     */     {
/* 118 */       File localFile = new File(str);
/* 119 */       if (localFile.exists())
/*     */       {
/* 121 */         byte[] arrayOfByte = new byte['Ѐ'];
/* 122 */         FileInputStream localFileInputStream = new FileInputStream(localFile);
/* 123 */         ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
/* 124 */         int i = 0;
/* 125 */         while ((i = localFileInputStream.read(arrayOfByte)) > 0) {
/* 126 */           localByteArrayOutputStream.write(arrayOfByte, 0, i);
/*     */         }
/* 128 */         localFileInputStream.close();
/* 129 */         arrayOfByte = localByteArrayOutputStream.toByteArray();
/* 130 */         OctetsStream localOctetsStream = OctetsStream.wrap(Octets.wrap(arrayOfByte));
/* 131 */         this.MONEY_TYPE = localOctetsStream.unmarshal_int();
/* 132 */         this.MONEY_NUM = localOctetsStream.unmarshal_int();
/* 133 */         this.LEVLE_LIMIT = localOctetsStream.unmarshal_int();
/* 134 */         this.CONVERT_CD_IN_HOUR = localOctetsStream.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/* 139 */       throw new RuntimeException("load " + str + " failed", localException);
/*     */     }
/*     */   }
/*     */   
/*     */   public void reLoadBny(String paramString)
/*     */   {
/* 145 */     String str = paramString + "mzm.gsp.genderconvert.confbean.SGenderConvertConsts.bny";
/*     */     try
/*     */     {
/* 148 */       File localFile = new File(str);
/* 149 */       if (localFile.exists())
/*     */       {
/* 151 */         byte[] arrayOfByte = new byte['Ѐ'];
/* 152 */         FileInputStream localFileInputStream = new FileInputStream(localFile);
/* 153 */         ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
/* 154 */         int i = 0;
/* 155 */         while ((i = localFileInputStream.read(arrayOfByte)) > 0) {
/* 156 */           localByteArrayOutputStream.write(arrayOfByte, 0, i);
/*     */         }
/* 158 */         localFileInputStream.close();
/* 159 */         arrayOfByte = localByteArrayOutputStream.toByteArray();
/* 160 */         OctetsStream localOctetsStream = OctetsStream.wrap(Octets.wrap(arrayOfByte));
/* 161 */         this.MONEY_TYPE = localOctetsStream.unmarshal_int();
/* 162 */         this.MONEY_NUM = localOctetsStream.unmarshal_int();
/* 163 */         this.LEVLE_LIMIT = localOctetsStream.unmarshal_int();
/* 164 */         this.CONVERT_CD_IN_HOUR = localOctetsStream.unmarshal_int();
/*     */       }
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/* 169 */       throw new RuntimeException("load " + str + " failed", localException);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setInstance(SGenderConvertConsts paramSGenderConvertConsts)
/*     */   {
/* 175 */     oldInstance = instance;
/* 176 */     instance = paramSGenderConvertConsts;
/*     */   }
/*     */   
/*     */   public static void resetOldInstance()
/*     */   {
/* 181 */     oldInstance = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genderconvert\confbean\SGenderConvertConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */