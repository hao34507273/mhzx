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
/*     */ public class SDanceMysteryVisitorCfg extends SMysteryVisitorCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  15 */   private static volatile Map<Integer, SDanceMysteryVisitorCfg> oldAll = null;
/*     */   
/*  17 */   private static Map<Integer, SDanceMysteryVisitorCfg> all = null;
/*     */   
/*     */   public int mystery_visitor_npc_id;
/*     */   public int mystery_visitor_npc_service_id;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  24 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*  25 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/*  26 */     this.award_id = Integer.valueOf(rootElement.attributeValue("award_id")).intValue();
/*  27 */     this.mystery_visitor_npc_id = Integer.valueOf(rootElement.attributeValue("mystery_visitor_npc_id")).intValue();
/*  28 */     this.mystery_visitor_npc_service_id = Integer.valueOf(rootElement.attributeValue("mystery_visitor_npc_service_id")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  33 */     _os_.marshal(this.id);
/*  34 */     _os_.marshal(this.type);
/*  35 */     _os_.marshal(this.award_id);
/*  36 */     _os_.marshal(this.mystery_visitor_npc_id);
/*  37 */     _os_.marshal(this.mystery_visitor_npc_service_id);
/*  38 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  43 */     this.id = _os_.unmarshal_int();
/*  44 */     this.type = _os_.unmarshal_int();
/*  45 */     this.award_id = _os_.unmarshal_int();
/*  46 */     this.mystery_visitor_npc_id = _os_.unmarshal_int();
/*  47 */     this.mystery_visitor_npc_service_id = _os_.unmarshal_int();
/*  48 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  53 */     String path = dir + "mzm.gsp.homeland.confbean.SDanceMysteryVisitorCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  57 */       all = new java.util.HashMap();
/*  58 */       SAXReader reader = new SAXReader();
/*  59 */       org.dom4j.Document doc = reader.read(new File(path));
/*  60 */       Element root = doc.getRootElement();
/*  61 */       List<?> nodeList = root.elements();
/*  62 */       int len = nodeList.size();
/*  63 */       for (int i = 0; i < len; i++)
/*     */       {
/*  65 */         Element elem = (Element)nodeList.get(i);
/*  66 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.SDanceMysteryVisitorCfg"))
/*     */         {
/*     */ 
/*  69 */           SDanceMysteryVisitorCfg obj = new SDanceMysteryVisitorCfg();
/*  70 */           obj.loadFromXml(elem);
/*  71 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/*  72 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  77 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SDanceMysteryVisitorCfg> all)
/*     */   {
/*  83 */     String path = dir + "mzm.gsp.homeland.confbean.SDanceMysteryVisitorCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  87 */       SAXReader reader = new SAXReader();
/*  88 */       org.dom4j.Document doc = reader.read(new File(path));
/*  89 */       Element root = doc.getRootElement();
/*  90 */       List<?> nodeList = root.elements();
/*  91 */       int len = nodeList.size();
/*  92 */       for (int i = 0; i < len; i++)
/*     */       {
/*  94 */         Element elem = (Element)nodeList.get(i);
/*  95 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.homeland.confbean.SDanceMysteryVisitorCfg"))
/*     */         {
/*     */ 
/*  98 */           SDanceMysteryVisitorCfg obj = new SDanceMysteryVisitorCfg();
/*  99 */           obj.loadFromXml(elem);
/* 100 */           if (all.put(Integer.valueOf(obj.id), obj) != null) {
/* 101 */             throw new RuntimeException("duplicate key : " + obj.id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 106 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 112 */     all = new java.util.HashMap();
/*     */     
/* 114 */     String path = dir + "mzm.gsp.homeland.confbean.SDanceMysteryVisitorCfg.bny";
/*     */     try
/*     */     {
/* 117 */       File file = new File(path);
/* 118 */       if (file.exists())
/*     */       {
/* 120 */         byte[] bytes = new byte['Ѐ'];
/* 121 */         FileInputStream fis = new FileInputStream(file);
/* 122 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 123 */         int len = 0;
/* 124 */         while ((len = fis.read(bytes)) > 0)
/* 125 */           baos.write(bytes, 0, len);
/* 126 */         fis.close();
/* 127 */         bytes = baos.toByteArray();
/* 128 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 129 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 131 */           _os_.unmarshal_int();
/* 132 */           _os_.unmarshal_int();
/* 133 */           _os_.unmarshal_int();
/*     */         }
/* 135 */         _os_.unmarshal_int();
/* 136 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 139 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 141 */           SDanceMysteryVisitorCfg _v_ = new SDanceMysteryVisitorCfg();
/* 142 */           _v_.unmarshal(_os_);
/* 143 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 144 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 149 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 154 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SDanceMysteryVisitorCfg> all)
/*     */   {
/* 161 */     String path = dir + "mzm.gsp.homeland.confbean.SDanceMysteryVisitorCfg.bny";
/*     */     try
/*     */     {
/* 164 */       File file = new File(path);
/* 165 */       if (file.exists())
/*     */       {
/* 167 */         byte[] bytes = new byte['Ѐ'];
/* 168 */         FileInputStream fis = new FileInputStream(file);
/* 169 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 170 */         int len = 0;
/* 171 */         while ((len = fis.read(bytes)) > 0)
/* 172 */           baos.write(bytes, 0, len);
/* 173 */         fis.close();
/* 174 */         bytes = baos.toByteArray();
/* 175 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 176 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 178 */           _os_.unmarshal_int();
/* 179 */           _os_.unmarshal_int();
/* 180 */           _os_.unmarshal_int();
/*     */         }
/* 182 */         _os_.unmarshal_int();
/* 183 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 186 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 188 */           SDanceMysteryVisitorCfg _v_ = new SDanceMysteryVisitorCfg();
/* 189 */           _v_.unmarshal(_os_);
/* 190 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 191 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 196 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 201 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void handleData()
/*     */   {
/* 207 */     for (Map.Entry<Integer, SDanceMysteryVisitorCfg> entry : all.entrySet())
/*     */     {
/* 209 */       if (SMysteryVisitorCfg.get(((Integer)entry.getKey()).intValue()) != null)
/*     */       {
/* 211 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 215 */       SMysteryVisitorCfg.getAll().put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void handleData(Map<Integer, SDanceMysteryVisitorCfg> all, Map<Integer, SMysteryVisitorCfg> parent)
/*     */   {
/* 222 */     for (Map.Entry<Integer, SDanceMysteryVisitorCfg> entry : all.entrySet())
/*     */     {
/* 224 */       if (parent.get(entry.getKey()) != null)
/*     */       {
/* 226 */         throw new RuntimeException("load data failed, have complict key");
/*     */       }
/*     */       
/*     */ 
/* 230 */       parent.put(entry.getKey(), entry.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static SDanceMysteryVisitorCfg getOld(int key)
/*     */   {
/* 237 */     return (SDanceMysteryVisitorCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SDanceMysteryVisitorCfg get(int key)
/*     */   {
/* 242 */     return (SDanceMysteryVisitorCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SDanceMysteryVisitorCfg> getOldAllSelf()
/*     */   {
/* 247 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SDanceMysteryVisitorCfg> getAllSelf()
/*     */   {
/* 252 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SDanceMysteryVisitorCfg> newAll)
/*     */   {
/* 257 */     oldAll = all;
/* 258 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 263 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\confbean\SDanceMysteryVisitorCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */