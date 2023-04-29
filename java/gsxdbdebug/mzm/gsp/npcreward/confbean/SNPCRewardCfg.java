/*     */ package mzm.gsp.npcreward.confbean;
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
/*     */ public class SNPCRewardCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SNPCRewardCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SNPCRewardCfg> all = null;
/*     */   
/*     */   public int activityCfgid;
/*     */   public int openCfgid;
/*     */   public int npcCfgid;
/*     */   public int npcRewardServiceCfgid;
/*     */   public int awardType;
/*     */   public int awardCfgid;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  27 */     this.activityCfgid = Integer.valueOf(rootElement.attributeValue("activityCfgid")).intValue();
/*  28 */     this.openCfgid = Integer.valueOf(rootElement.attributeValue("openCfgid")).intValue();
/*  29 */     this.npcCfgid = Integer.valueOf(rootElement.attributeValue("npcCfgid")).intValue();
/*  30 */     this.npcRewardServiceCfgid = Integer.valueOf(rootElement.attributeValue("npcRewardServiceCfgid")).intValue();
/*  31 */     this.awardType = Integer.valueOf(rootElement.attributeValue("awardType")).intValue();
/*  32 */     this.awardCfgid = Integer.valueOf(rootElement.attributeValue("awardCfgid")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  37 */     _os_.marshal(this.activityCfgid);
/*  38 */     _os_.marshal(this.openCfgid);
/*  39 */     _os_.marshal(this.npcCfgid);
/*  40 */     _os_.marshal(this.npcRewardServiceCfgid);
/*  41 */     _os_.marshal(this.awardType);
/*  42 */     _os_.marshal(this.awardCfgid);
/*  43 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  48 */     this.activityCfgid = _os_.unmarshal_int();
/*  49 */     this.openCfgid = _os_.unmarshal_int();
/*  50 */     this.npcCfgid = _os_.unmarshal_int();
/*  51 */     this.npcRewardServiceCfgid = _os_.unmarshal_int();
/*  52 */     this.awardType = _os_.unmarshal_int();
/*  53 */     this.awardCfgid = _os_.unmarshal_int();
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  59 */     String path = dir + "mzm.gsp.npcreward.confbean.SNPCRewardCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  63 */       all = new java.util.HashMap();
/*  64 */       SAXReader reader = new SAXReader();
/*  65 */       org.dom4j.Document doc = reader.read(new File(path));
/*  66 */       Element root = doc.getRootElement();
/*  67 */       List<?> nodeList = root.elements();
/*  68 */       int len = nodeList.size();
/*  69 */       for (int i = 0; i < len; i++)
/*     */       {
/*  71 */         Element elem = (Element)nodeList.get(i);
/*  72 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.npcreward.confbean.SNPCRewardCfg"))
/*     */         {
/*     */ 
/*  75 */           SNPCRewardCfg obj = new SNPCRewardCfg();
/*  76 */           obj.loadFromXml(elem);
/*  77 */           if (all.put(Integer.valueOf(obj.activityCfgid), obj) != null) {
/*  78 */             throw new RuntimeException("duplicate key : " + obj.activityCfgid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  83 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SNPCRewardCfg> all)
/*     */   {
/*  89 */     String path = dir + "mzm.gsp.npcreward.confbean.SNPCRewardCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  93 */       SAXReader reader = new SAXReader();
/*  94 */       org.dom4j.Document doc = reader.read(new File(path));
/*  95 */       Element root = doc.getRootElement();
/*  96 */       List<?> nodeList = root.elements();
/*  97 */       int len = nodeList.size();
/*  98 */       for (int i = 0; i < len; i++)
/*     */       {
/* 100 */         Element elem = (Element)nodeList.get(i);
/* 101 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.npcreward.confbean.SNPCRewardCfg"))
/*     */         {
/*     */ 
/* 104 */           SNPCRewardCfg obj = new SNPCRewardCfg();
/* 105 */           obj.loadFromXml(elem);
/* 106 */           if (all.put(Integer.valueOf(obj.activityCfgid), obj) != null) {
/* 107 */             throw new RuntimeException("duplicate key : " + obj.activityCfgid);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 112 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 118 */     all = new java.util.HashMap();
/*     */     
/* 120 */     String path = dir + "mzm.gsp.npcreward.confbean.SNPCRewardCfg.bny";
/*     */     try
/*     */     {
/* 123 */       File file = new File(path);
/* 124 */       if (file.exists())
/*     */       {
/* 126 */         byte[] bytes = new byte['Ѐ'];
/* 127 */         FileInputStream fis = new FileInputStream(file);
/* 128 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 129 */         int len = 0;
/* 130 */         while ((len = fis.read(bytes)) > 0)
/* 131 */           baos.write(bytes, 0, len);
/* 132 */         fis.close();
/* 133 */         bytes = baos.toByteArray();
/* 134 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 135 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 137 */           _os_.unmarshal_int();
/* 138 */           _os_.unmarshal_int();
/* 139 */           _os_.unmarshal_int();
/*     */         }
/* 141 */         _os_.unmarshal_int();
/* 142 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 145 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 147 */           SNPCRewardCfg _v_ = new SNPCRewardCfg();
/* 148 */           _v_.unmarshal(_os_);
/* 149 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 150 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 155 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 160 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SNPCRewardCfg> all)
/*     */   {
/* 167 */     String path = dir + "mzm.gsp.npcreward.confbean.SNPCRewardCfg.bny";
/*     */     try
/*     */     {
/* 170 */       File file = new File(path);
/* 171 */       if (file.exists())
/*     */       {
/* 173 */         byte[] bytes = new byte['Ѐ'];
/* 174 */         FileInputStream fis = new FileInputStream(file);
/* 175 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 176 */         int len = 0;
/* 177 */         while ((len = fis.read(bytes)) > 0)
/* 178 */           baos.write(bytes, 0, len);
/* 179 */         fis.close();
/* 180 */         bytes = baos.toByteArray();
/* 181 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 182 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 184 */           _os_.unmarshal_int();
/* 185 */           _os_.unmarshal_int();
/* 186 */           _os_.unmarshal_int();
/*     */         }
/* 188 */         _os_.unmarshal_int();
/* 189 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 192 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 194 */           SNPCRewardCfg _v_ = new SNPCRewardCfg();
/* 195 */           _v_.unmarshal(_os_);
/* 196 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 197 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 202 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 207 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SNPCRewardCfg getOld(int key)
/*     */   {
/* 215 */     return (SNPCRewardCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SNPCRewardCfg get(int key)
/*     */   {
/* 220 */     return (SNPCRewardCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SNPCRewardCfg> getOldAll()
/*     */   {
/* 225 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SNPCRewardCfg> getAll()
/*     */   {
/* 230 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SNPCRewardCfg> newAll)
/*     */   {
/* 235 */     oldAll = all;
/* 236 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 241 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npcreward\confbean\SNPCRewardCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */