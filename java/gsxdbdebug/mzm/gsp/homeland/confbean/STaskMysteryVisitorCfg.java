/*     */ package mzm.gsp.homeland.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class STaskMysteryVisitorCfg extends SMysteryVisitorCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, STaskMysteryVisitorCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, STaskMysteryVisitorCfg> all = null;
/*     */   
/*     */   public int task_graph_id;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  23 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  24 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  25 */     this.award_id = Integer.valueOf(rootElement.attributeValue("award_id")).intValue();
/*  26 */     this.task_graph_id = Integer.valueOf(rootElement.attributeValue("task_graph_id")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  31 */     _os_.marshal(this.id);
/*  32 */     _os_.marshal(this.type);
/*  33 */     _os_.marshal(this.award_id);
/*  34 */     _os_.marshal(this.task_graph_id);
/*  35 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  40 */     this.id = _os_.unmarshal_int();
/*  41 */     this.type = _os_.unmarshal_int();
/*  42 */     this.award_id = _os_.unmarshal_int();
/*  43 */     this.task_graph_id = _os_.unmarshal_int();
/*  44 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  49 */     String path = dir + "mzm.gsp.homeland.confbean.STaskMysteryVisitorCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  53 */       all = new java.util.HashMap();
/*  54 */       SAXReader reader = new SAXReader();
/*  55 */       org.dom4j.Document doc = reader.read(new File(path));
/*  56 */       Element root = doc.getRootElement();
/*  57 */       List<?> nodeList = root.elements();
/*  58 */       int len = nodeList.size();
/*  59 */       for (int i = 0; i < len; i++)
/*     */       {
/*  61 */         Element elem = (Element)nodeList.get(i);
/*  62 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.STaskMysteryVisitorCfg"))
/*     */         {
/*     */ 
/*  65 */           STaskMysteryVisitorCfg obj = new STaskMysteryVisitorCfg();
/*  66 */           obj.loadFromXml(elem);
/*  67 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  68 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  73 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, STaskMysteryVisitorCfg> all)
/*     */   {
/*  79 */     String path = dir + "mzm.gsp.homeland.confbean.STaskMysteryVisitorCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  83 */       SAXReader reader = new SAXReader();
/*  84 */       org.dom4j.Document doc = reader.read(new File(path));
/*  85 */       Element root = doc.getRootElement();
/*  86 */       List<?> nodeList = root.elements();
/*  87 */       int len = nodeList.size();
/*  88 */       for (int i = 0; i < len; i++)
/*     */       {
/*  90 */         Element elem = (Element)nodeList.get(i);
/*  91 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.STaskMysteryVisitorCfg"))
/*     */         {
/*     */ 
/*  94 */           STaskMysteryVisitorCfg obj = new STaskMysteryVisitorCfg();
/*  95 */           obj.loadFromXml(elem);
/*  96 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  97 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 102 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 108 */     all = new java.util.HashMap();
/*     */     
/* 110 */     String path = dir + "mzm.gsp.homeland.confbean.STaskMysteryVisitorCfg.bny";
/*     */     try
/*     */     {
/* 113 */       File file = new File(path);
/* 114 */       if (file.exists())
/*     */       {
/* 116 */         byte[] bytes = new byte['Ѐ'];
/* 117 */         FileInputStream fis = new FileInputStream(file);
/* 118 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 119 */         int len = 0;
/* 120 */         while ((len = fis.read(bytes)) > 0)
/* 121 */           baos.write(bytes, 0, len);
/* 122 */         fis.close();
/* 123 */         bytes = baos.toByteArray();
/* 124 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 125 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 127 */           _os_.unmarshal_int();
/* 128 */           _os_.unmarshal_int();
/* 129 */           _os_.unmarshal_int();
/*     */         }
/* 131 */         _os_.unmarshal_int();
/* 132 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 135 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 137 */           STaskMysteryVisitorCfg _v_ = new STaskMysteryVisitorCfg();
/* 138 */           _v_.unmarshal(_os_);
/* 139 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 140 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 145 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 150 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, STaskMysteryVisitorCfg> all)
/*     */   {
/* 157 */     String path = dir + "mzm.gsp.homeland.confbean.STaskMysteryVisitorCfg.bny";
/*     */     try
/*     */     {
/* 160 */       File file = new File(path);
/* 161 */       if (file.exists())
/*     */       {
/* 163 */         byte[] bytes = new byte['Ѐ'];
/* 164 */         FileInputStream fis = new FileInputStream(file);
/* 165 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 166 */         int len = 0;
/* 167 */         while ((len = fis.read(bytes)) > 0)
/* 168 */           baos.write(bytes, 0, len);
/* 169 */         fis.close();
/* 170 */         bytes = baos.toByteArray();
/* 171 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 172 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 174 */           _os_.unmarshal_int();
/* 175 */           _os_.unmarshal_int();
/* 176 */           _os_.unmarshal_int();
/*     */         }
/* 178 */         _os_.unmarshal_int();
/* 179 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 182 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 184 */           STaskMysteryVisitorCfg _v_ = new STaskMysteryVisitorCfg();
/* 185 */           _v_.unmarshal(_os_);
/* 186 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 187 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 192 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 197 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 203 */     for (Map.Entry<Integer, STaskMysteryVisitorCfg> entry : all.entrySet())
/*     */     {
/* 205 */       if (SMysteryVisitorCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 207 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 211 */       SMysteryVisitorCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, STaskMysteryVisitorCfg> all, Map<Integer, SMysteryVisitorCfg> parent)
/*     */   {
/* 218 */     for (Map.Entry<Integer, STaskMysteryVisitorCfg> entry : all.entrySet())
/*     */     {
/* 220 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 222 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 226 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static STaskMysteryVisitorCfg getOld(int key)
/*     */   {
/* 233 */     return (STaskMysteryVisitorCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static STaskMysteryVisitorCfg get(int key)
/*     */   {
/* 238 */     return (STaskMysteryVisitorCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, STaskMysteryVisitorCfg> getOldAllSelf()
/*     */   {
/* 243 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, STaskMysteryVisitorCfg> getAllSelf()
/*     */   {
/* 248 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, STaskMysteryVisitorCfg> newAll)
/*     */   {
/* 253 */     oldAll = all;
/* 254 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 259 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\confbean\STaskMysteryVisitorCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */