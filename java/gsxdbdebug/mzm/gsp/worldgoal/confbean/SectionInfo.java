/*     */ package mzm.gsp.worldgoal.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.TreeMap;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SectionInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int map_cfg_id;
/*     */   public int x;
/*     */   public int y;
/*     */   public int section_total_point;
/*     */   public int section_complete_award_mail_id;
/*  14 */   public TreeMap<Integer, Integer> trigger_points = new TreeMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  18 */     this.map_cfg_id = Integer.valueOf(rootElement.attributeValue("map_cfg_id")).intValue();
/*  19 */     this.x = Integer.valueOf(rootElement.attributeValue("x")).intValue();
/*  20 */     this.y = Integer.valueOf(rootElement.attributeValue("y")).intValue();
/*  21 */     this.section_total_point = Integer.valueOf(rootElement.attributeValue("section_total_point")).intValue();
/*  22 */     this.section_complete_award_mail_id = Integer.valueOf(rootElement.attributeValue("section_complete_award_mail_id")).intValue();
/*     */     
/*  24 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "trigger_points");
/*  25 */     if (mapTypeElement == null)
/*     */     {
/*  27 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  30 */     java.util.List<?> entryNodeList = mapTypeElement.elements();
/*  31 */     int entryLen = entryNodeList.size();
/*  32 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/*  34 */       Element entryElement = (Element)entryNodeList.get(i);
/*  35 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  40 */         Element keyElem = null;
/*  41 */         Element valueElem = null;
/*     */         
/*  43 */         java.util.List<?> _nodeList = entryElement.elements();
/*  44 */         int _len = _nodeList.size();
/*  45 */         for (int j = 0; j < _len; j++)
/*     */         {
/*  47 */           Element elem = (Element)_nodeList.get(j);
/*  48 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  50 */             keyElem = elem;
/*     */           }
/*  52 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/*  54 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/*  58 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/*  60 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         int _v_;
/*     */         try
/*     */         {
/*  67 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/*  68 */           _v_ = Integer.valueOf(valueElem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  75 */         this.trigger_points.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  82 */     _os_.marshal(this.map_cfg_id);
/*  83 */     _os_.marshal(this.x);
/*  84 */     _os_.marshal(this.y);
/*  85 */     _os_.marshal(this.section_total_point);
/*  86 */     _os_.marshal(this.section_complete_award_mail_id);
/*  87 */     _os_.compact_uint32(this.trigger_points.size());
/*  88 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.trigger_points.entrySet())
/*     */     {
/*  90 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  91 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  98 */     this.map_cfg_id = _os_.unmarshal_int();
/*  99 */     this.x = _os_.unmarshal_int();
/* 100 */     this.y = _os_.unmarshal_int();
/* 101 */     this.section_total_point = _os_.unmarshal_int();
/* 102 */     this.section_complete_award_mail_id = _os_.unmarshal_int();
/* 103 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 106 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 108 */       int _v_ = _os_.unmarshal_int();
/* 109 */       this.trigger_points.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 111 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\confbean\SectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */