/*     */ package mzm.gsp.npc.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SServiceTransfor
/*     */   implements Marshal
/*     */ {
/*  20 */   private static volatile Map<Integer, SServiceTransfor> oldAll = null;
/*  21 */   private static Map<Integer, SServiceTransfor> all = null;
/*     */   public static int serviceId;
/*     */   public int needitem;
/*     */   public int fightitem;
/*     */   public int mapId;
/*     */   public int x;
/*     */   public int y;
/*     */   
/*     */   public void loadFromXml(Element paramElement)
/*     */   {
/*  31 */     serviceId = Integer.valueOf(paramElement.attributeValue("serviceId")).intValue();
/*  32 */     this.needitem = Integer.valueOf(paramElement.attributeValue("needitem")).intValue();
/*  33 */     this.fightitem = Integer.valueOf(paramElement.attributeValue("fightitem")).intValue();
/*  34 */     this.mapId = Integer.valueOf(paramElement.attributeValue("mapId")).intValue();
/*  35 */     this.x = Integer.valueOf(paramElement.attributeValue("x")).intValue();
/*  36 */     this.y = Integer.valueOf(paramElement.attributeValue("y")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream paramOctetsStream)
/*     */   {
/*  41 */     paramOctetsStream.marshal(serviceId);
/*  42 */     paramOctetsStream.marshal(this.needitem);
/*  43 */     paramOctetsStream.marshal(this.fightitem);
/*  44 */     paramOctetsStream.marshal(this.mapId);
/*  45 */     paramOctetsStream.marshal(this.x);
/*  46 */     paramOctetsStream.marshal(this.y);
/*  47 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream paramOctetsStream)
/*     */     throws MarshalException
/*     */   {
/*  53 */     serviceId = paramOctetsStream.unmarshal_int();
/*  54 */     this.needitem = paramOctetsStream.unmarshal_int();
/*  55 */     this.fightitem = paramOctetsStream.unmarshal_int();
/*  56 */     this.mapId = paramOctetsStream.unmarshal_int();
/*  57 */     this.x = paramOctetsStream.unmarshal_int();
/*  58 */     this.y = paramOctetsStream.unmarshal_int();
/*  59 */     return paramOctetsStream;
/*     */   }
/*     */   
/*     */   public static void loadXml(String paramString)
/*     */   {
/*  64 */     String str = paramString + "mzm.gsp.npc.confbean.SServiceTransfor.xml";
/*     */     try
/*     */     {
/*  67 */       all = new HashMap();
/*  68 */       SAXReader localSAXReader = new SAXReader();
/*  69 */       Document localDocument = localSAXReader.read(new File(str));
/*  70 */       Element localElement1 = localDocument.getRootElement();
/*  71 */       List localList = localElement1.elements();
/*  72 */       int i = localList.size();
/*  73 */       for (int j = 0; j < i; j++)
/*     */       {
/*  75 */         Element localElement2 = (Element)localList.get(j);
/*  76 */         if (localElement2.getName().equalsIgnoreCase("mzm.gsp.npc.confbean.SServiceTransfor"))
/*     */         {
/*  78 */           SServiceTransfor localSServiceTransfor = new SServiceTransfor();
/*  79 */           localSServiceTransfor.loadFromXml(localElement2);
/*  80 */           if (all.put(Integer.valueOf(serviceId), localSServiceTransfor) != null) {
/*  81 */             throw new RuntimeException("duplicate key : " + serviceId);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*  88 */       throw new RuntimeException("load " + str + " failed", localException);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String paramString, Map<Integer, SServiceTransfor> paramMap)
/*     */   {
/*  94 */     String str = paramString + "mzm.gsp.npc.confbean.SServiceTransfor.xml";
/*     */     try
/*     */     {
/*  97 */       SAXReader localSAXReader = new SAXReader();
/*  98 */       Document localDocument = localSAXReader.read(new File(str));
/*  99 */       Element localElement1 = localDocument.getRootElement();
/* 100 */       List localList = localElement1.elements();
/* 101 */       int i = localList.size();
/* 102 */       for (int j = 0; j < i; j++)
/*     */       {
/* 104 */         Element localElement2 = (Element)localList.get(j);
/* 105 */         if (localElement2.getName().equalsIgnoreCase("mzm.gsp.npc.confbean.SServiceTransfor"))
/*     */         {
/* 107 */           SServiceTransfor localSServiceTransfor = new SServiceTransfor();
/* 108 */           localSServiceTransfor.loadFromXml(localElement2);
/* 109 */           if (paramMap.put(Integer.valueOf(serviceId), localSServiceTransfor) != null) {
/* 110 */             throw new RuntimeException("duplicate key : " + serviceId);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/* 117 */       throw new RuntimeException("load " + str + " failed", localException);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String paramString)
/*     */   {
/* 123 */     all = new HashMap();
/*     */     
/* 125 */     String str = paramString + "mzm.gsp.npc.confbean.SServiceTransfor.bny";
/*     */     try
/*     */     {
/* 128 */       File localFile = new File(str);
/* 129 */       if (localFile.exists())
/*     */       {
/* 131 */         byte[] arrayOfByte = new byte['Ѐ'];
/* 132 */         FileInputStream localFileInputStream = new FileInputStream(localFile);
/* 133 */         ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
/* 134 */         int i = 0;
/* 135 */         while ((i = localFileInputStream.read(arrayOfByte)) > 0) {
/* 136 */           localByteArrayOutputStream.write(arrayOfByte, 0, i);
/*     */         }
/* 138 */         localFileInputStream.close();
/* 139 */         arrayOfByte = localByteArrayOutputStream.toByteArray();
/* 140 */         OctetsStream localOctetsStream = OctetsStream.wrap(Octets.wrap(arrayOfByte));
/* 141 */         for (int j = localOctetsStream.uncompact_uint32(); j > 0; j--)
/*     */         {
/* 143 */           localOctetsStream.unmarshal_int();
/* 144 */           localOctetsStream.unmarshal_int();
/* 145 */           localOctetsStream.unmarshal_int();
/*     */         }
/* 147 */         localOctetsStream.unmarshal_int();
/* 148 */         for (j = localOctetsStream.uncompact_uint32(); j > 0; j--)
/*     */         {
/* 150 */           int k = localOctetsStream.unmarshal_int();
/*     */           
/* 152 */           SServiceTransfor localSServiceTransfor = new SServiceTransfor();
/* 153 */           localSServiceTransfor.unmarshal(localOctetsStream);
/* 154 */           if (all.put(Integer.valueOf(k), localSServiceTransfor) != null) {
/* 155 */             throw new RuntimeException("duplicate key : " + k);
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 161 */         throw new RuntimeException("file not exist : " + str);
/*     */       }
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/* 166 */       throw new RuntimeException("load " + str + " failed", localException);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadBny(String paramString, Map<Integer, SServiceTransfor> paramMap)
/*     */   {
/* 172 */     String str = paramString + "mzm.gsp.npc.confbean.SServiceTransfor.bny";
/*     */     try
/*     */     {
/* 175 */       File localFile = new File(str);
/* 176 */       if (localFile.exists())
/*     */       {
/* 178 */         byte[] arrayOfByte = new byte['Ѐ'];
/* 179 */         FileInputStream localFileInputStream = new FileInputStream(localFile);
/* 180 */         ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
/* 181 */         int i = 0;
/* 182 */         while ((i = localFileInputStream.read(arrayOfByte)) > 0) {
/* 183 */           localByteArrayOutputStream.write(arrayOfByte, 0, i);
/*     */         }
/* 185 */         localFileInputStream.close();
/* 186 */         arrayOfByte = localByteArrayOutputStream.toByteArray();
/* 187 */         OctetsStream localOctetsStream = OctetsStream.wrap(Octets.wrap(arrayOfByte));
/* 188 */         for (int j = localOctetsStream.uncompact_uint32(); j > 0; j--)
/*     */         {
/* 190 */           localOctetsStream.unmarshal_int();
/* 191 */           localOctetsStream.unmarshal_int();
/* 192 */           localOctetsStream.unmarshal_int();
/*     */         }
/* 194 */         localOctetsStream.unmarshal_int();
/* 195 */         for (j = localOctetsStream.uncompact_uint32(); j > 0; j--)
/*     */         {
/* 197 */           int k = localOctetsStream.unmarshal_int();
/*     */           
/* 199 */           SServiceTransfor localSServiceTransfor = new SServiceTransfor();
/* 200 */           localSServiceTransfor.unmarshal(localOctetsStream);
/* 201 */           if (paramMap.put(Integer.valueOf(k), localSServiceTransfor) != null) {
/* 202 */             throw new RuntimeException("duplicate key : " + k);
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 208 */         throw new RuntimeException("file not exist : " + str);
/*     */       }
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/* 213 */       throw new RuntimeException("load " + str + " failed", localException);
/*     */     }
/*     */   }
/*     */   
/*     */   public static int getserviceId()
/*     */   {
/* 219 */     return serviceId;
/*     */   }
/*     */   
/*     */   public static SServiceTransfor getOld(int paramInt)
/*     */   {
/* 224 */     return (SServiceTransfor)oldAll.get(Integer.valueOf(paramInt));
/*     */   }
/*     */   
/*     */   public static SServiceTransfor get(int paramInt)
/*     */   {
/* 229 */     return (SServiceTransfor)all.get(Integer.valueOf(paramInt));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SServiceTransfor> getOldAll()
/*     */   {
/* 234 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SServiceTransfor> getAll()
/*     */   {
/* 239 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SServiceTransfor> paramMap)
/*     */   {
/* 244 */     oldAll = all;
/* 245 */     all = paramMap;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 250 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\confbean\SServiceTransfor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */