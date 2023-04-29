/*     */ package mzm.gsp.activity2.confbean;
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
/*     */ public class SMemoryCompetitionActivityCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SMemoryCompetitionActivityCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SMemoryCompetitionActivityCfg> all = null;
/*     */   
/*     */   public int activity_cfg_id;
/*     */   public int idip_switch_id;
/*     */   public int npc_id;
/*     */   public int npc_service_id;
/*  22 */   public java.util.ArrayList<Integer> memory_competition_cfg_id_list = new java.util.ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  26 */     this.activity_cfg_id = Integer.valueOf(rootElement.attributeValue("activity_cfg_id")).intValue();
/*  27 */     this.idip_switch_id = Integer.valueOf(rootElement.attributeValue("idip_switch_id")).intValue();
/*  28 */     this.npc_id = Integer.valueOf(rootElement.attributeValue("npc_id")).intValue();
/*  29 */     this.npc_service_id = Integer.valueOf(rootElement.attributeValue("npc_service_id")).intValue();
/*     */     
/*  31 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "memory_competition_cfg_id_list");
/*  32 */     if (collectionElement == null)
/*     */     {
/*  34 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  37 */     List<?> _nodeList = collectionElement.elements();
/*  38 */     int _len = _nodeList.size();
/*  39 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  41 */       Element elem = (Element)_nodeList.get(i);
/*  42 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  49 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  56 */         this.memory_competition_cfg_id_list.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  63 */     _os_.marshal(this.activity_cfg_id);
/*  64 */     _os_.marshal(this.idip_switch_id);
/*  65 */     _os_.marshal(this.npc_id);
/*  66 */     _os_.marshal(this.npc_service_id);
/*  67 */     _os_.compact_uint32(this.memory_competition_cfg_id_list.size());
/*  68 */     for (Integer _v_ : this.memory_competition_cfg_id_list)
/*     */     {
/*  70 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  77 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  78 */     this.idip_switch_id = _os_.unmarshal_int();
/*  79 */     this.npc_id = _os_.unmarshal_int();
/*  80 */     this.npc_service_id = _os_.unmarshal_int();
/*  81 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  84 */       int _v_ = _os_.unmarshal_int();
/*  85 */       this.memory_competition_cfg_id_list.add(Integer.valueOf(_v_));
/*     */     }
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/*  92 */     String path = dir + "mzm.gsp.activity2.confbean.SMemoryCompetitionActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/*  96 */       all = new java.util.HashMap();
/*  97 */       SAXReader reader = new SAXReader();
/*  98 */       org.dom4j.Document doc = reader.read(new File(path));
/*  99 */       Element root = doc.getRootElement();
/* 100 */       List<?> nodeList = root.elements();
/* 101 */       int len = nodeList.size();
/* 102 */       for (int i = 0; i < len; i++)
/*     */       {
/* 104 */         Element elem = (Element)nodeList.get(i);
/* 105 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity2.confbean.SMemoryCompetitionActivityCfg"))
/*     */         {
/*     */ 
/* 108 */           SMemoryCompetitionActivityCfg obj = new SMemoryCompetitionActivityCfg();
/* 109 */           obj.loadFromXml(elem);
/* 110 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 111 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 116 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SMemoryCompetitionActivityCfg> all)
/*     */   {
/* 122 */     String path = dir + "mzm.gsp.activity2.confbean.SMemoryCompetitionActivityCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 126 */       SAXReader reader = new SAXReader();
/* 127 */       org.dom4j.Document doc = reader.read(new File(path));
/* 128 */       Element root = doc.getRootElement();
/* 129 */       List<?> nodeList = root.elements();
/* 130 */       int len = nodeList.size();
/* 131 */       for (int i = 0; i < len; i++)
/*     */       {
/* 133 */         Element elem = (Element)nodeList.get(i);
/* 134 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.activity2.confbean.SMemoryCompetitionActivityCfg"))
/*     */         {
/*     */ 
/* 137 */           SMemoryCompetitionActivityCfg obj = new SMemoryCompetitionActivityCfg();
/* 138 */           obj.loadFromXml(elem);
/* 139 */           if (all.put(Integer.valueOf(obj.activity_cfg_id), obj) != null) {
/* 140 */             throw new RuntimeException("duplicate key : " + obj.activity_cfg_id);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 145 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 151 */     all = new java.util.HashMap();
/*     */     
/* 153 */     String path = dir + "mzm.gsp.activity2.confbean.SMemoryCompetitionActivityCfg.bny";
/*     */     try
/*     */     {
/* 156 */       File file = new File(path);
/* 157 */       if (file.exists())
/*     */       {
/* 159 */         byte[] bytes = new byte['Ѐ'];
/* 160 */         FileInputStream fis = new FileInputStream(file);
/* 161 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 162 */         int len = 0;
/* 163 */         while ((len = fis.read(bytes)) > 0)
/* 164 */           baos.write(bytes, 0, len);
/* 165 */         fis.close();
/* 166 */         bytes = baos.toByteArray();
/* 167 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 168 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 170 */           _os_.unmarshal_int();
/* 171 */           _os_.unmarshal_int();
/* 172 */           _os_.unmarshal_int();
/*     */         }
/* 174 */         _os_.unmarshal_int();
/* 175 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 178 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 180 */           SMemoryCompetitionActivityCfg _v_ = new SMemoryCompetitionActivityCfg();
/* 181 */           _v_.unmarshal(_os_);
/* 182 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 183 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 188 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 193 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SMemoryCompetitionActivityCfg> all)
/*     */   {
/* 200 */     String path = dir + "mzm.gsp.activity2.confbean.SMemoryCompetitionActivityCfg.bny";
/*     */     try
/*     */     {
/* 203 */       File file = new File(path);
/* 204 */       if (file.exists())
/*     */       {
/* 206 */         byte[] bytes = new byte['Ѐ'];
/* 207 */         FileInputStream fis = new FileInputStream(file);
/* 208 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 209 */         int len = 0;
/* 210 */         while ((len = fis.read(bytes)) > 0)
/* 211 */           baos.write(bytes, 0, len);
/* 212 */         fis.close();
/* 213 */         bytes = baos.toByteArray();
/* 214 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 215 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 217 */           _os_.unmarshal_int();
/* 218 */           _os_.unmarshal_int();
/* 219 */           _os_.unmarshal_int();
/*     */         }
/* 221 */         _os_.unmarshal_int();
/* 222 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 225 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 227 */           SMemoryCompetitionActivityCfg _v_ = new SMemoryCompetitionActivityCfg();
/* 228 */           _v_.unmarshal(_os_);
/* 229 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 230 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 235 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 240 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SMemoryCompetitionActivityCfg getOld(int key)
/*     */   {
/* 248 */     return (SMemoryCompetitionActivityCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SMemoryCompetitionActivityCfg get(int key)
/*     */   {
/* 253 */     return (SMemoryCompetitionActivityCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMemoryCompetitionActivityCfg> getOldAll()
/*     */   {
/* 258 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SMemoryCompetitionActivityCfg> getAll()
/*     */   {
/* 263 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SMemoryCompetitionActivityCfg> newAll)
/*     */   {
/* 268 */     oldAll = all;
/* 269 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 274 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity2\confbean\SMemoryCompetitionActivityCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */