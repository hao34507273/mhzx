/*     */ package mzm.gsp.map.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.List;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SMapNPC implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int mapCfgId;
/*     */   public int instanceId;
/*     */   public int templateId;
/*     */   public int pathType;
/*     */   public int dir;
/*     */   public String name;
/*     */   public int velocity;
/*     */   public int regisOnStart;
/*  17 */   public java.util.ArrayList<Point> pathPoints = new java.util.ArrayList();
/*     */   public Point orignalPoint;
/*  19 */   public java.util.HashMap<Integer, StateSet> visibleByTaskState = new java.util.HashMap();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  23 */     this.mapCfgId = Integer.valueOf(rootElement.attributeValue("mapCfgId")).intValue();
/*  24 */     this.instanceId = Integer.valueOf(rootElement.attributeValue("instanceId")).intValue();
/*  25 */     this.templateId = Integer.valueOf(rootElement.attributeValue("templateId")).intValue();
/*  26 */     this.pathType = Integer.valueOf(rootElement.attributeValue("pathType")).intValue();
/*  27 */     this.dir = Integer.valueOf(rootElement.attributeValue("dir")).intValue();
/*  28 */     this.name = rootElement.attributeValue("name");
/*  29 */     this.velocity = Integer.valueOf(rootElement.attributeValue("velocity")).intValue();
/*  30 */     this.regisOnStart = Integer.valueOf(rootElement.attributeValue("regisOnStart")).intValue();
/*     */     
/*  32 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "pathPoints");
/*  33 */     if (collectionElement == null)
/*     */     {
/*  35 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  38 */     List<?> _nodeList = collectionElement.elements();
/*  39 */     int _len = _nodeList.size();
/*  40 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  42 */       Element elem = (Element)_nodeList.get(i);
/*  43 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.Point"))
/*     */       {
/*     */         Point _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  50 */           _v_ = new Point();
/*  51 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  58 */         this.pathPoints.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  62 */     Element beanElement = util.XmlHelper.getVariableElement(rootElement, "orignalPoint");
/*  63 */     if (beanElement == null)
/*     */     {
/*  65 */       throw new RuntimeException("beanElement element does not find");
/*     */     }
/*     */     
/*  68 */     List<?> _nodeList = beanElement.elements();
/*  69 */     int _len = _nodeList.size();
/*  70 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  72 */       Element elem = (Element)_nodeList.get(i);
/*  73 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.Point"))
/*     */       {
/*     */ 
/*     */         try
/*     */         {
/*     */ 
/*  79 */           this.orignalPoint = new Point();
/*  80 */           this.orignalPoint.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e) {}
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  90 */     Element mapTypeElement = util.XmlHelper.getVariableElement(rootElement, "visibleByTaskState");
/*  91 */     if (mapTypeElement == null)
/*     */     {
/*  93 */       throw new RuntimeException("map type element does not find");
/*     */     }
/*     */     
/*  96 */     List<?> entryNodeList = mapTypeElement.elements();
/*  97 */     int entryLen = entryNodeList.size();
/*  98 */     for (int i = 0; i < entryLen; i++)
/*     */     {
/* 100 */       Element entryElement = (Element)entryNodeList.get(i);
/* 101 */       if (entryElement.getName().equalsIgnoreCase("entry"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 106 */         Element keyElem = null;
/* 107 */         Element valueElem = null;
/*     */         
/* 109 */         List<?> _nodeList = entryElement.elements();
/* 110 */         int _len = _nodeList.size();
/* 111 */         for (int j = 0; j < _len; j++)
/*     */         {
/* 113 */           Element elem = (Element)_nodeList.get(j);
/* 114 */           if ((keyElem == null) && (elem.getName().equalsIgnoreCase("int")))
/*     */           {
/* 116 */             keyElem = elem;
/*     */           }
/* 118 */           else if ((valueElem == null) && (elem.getName().equalsIgnoreCase("mzm.gsp.map.confbean.StateSet")))
/*     */           {
/* 120 */             valueElem = elem;
/*     */           }
/*     */         }
/*     */         
/* 124 */         if ((keyElem == null) || (valueElem == null))
/*     */         {
/* 126 */           throw new RuntimeException("map entry element MUST have key and value child element.");
/*     */         }
/*     */         
/*     */         int _k_;
/*     */         StateSet _v_;
/*     */         try
/*     */         {
/* 133 */           _k_ = Integer.valueOf(keyElem.getText()).intValue();
/* 134 */           _v_ = new StateSet();
/* 135 */           _v_.loadFromXml(valueElem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/* 142 */         this.visibleByTaskState.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 149 */     _os_.marshal(this.mapCfgId);
/* 150 */     _os_.marshal(this.instanceId);
/* 151 */     _os_.marshal(this.templateId);
/* 152 */     _os_.marshal(this.pathType);
/* 153 */     _os_.marshal(this.dir);
/* 154 */     _os_.marshal(this.name, "UTF-8");
/* 155 */     _os_.marshal(this.velocity);
/* 156 */     _os_.marshal(this.regisOnStart);
/* 157 */     _os_.compact_uint32(this.pathPoints.size());
/* 158 */     for (Point _v_ : this.pathPoints)
/*     */     {
/* 160 */       _os_.marshal(_v_);
/*     */     }
/* 162 */     _os_.marshal(this.orignalPoint);
/* 163 */     _os_.compact_uint32(this.visibleByTaskState.size());
/* 164 */     for (java.util.Map.Entry<Integer, StateSet> _e_ : this.visibleByTaskState.entrySet())
/*     */     {
/* 166 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 167 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 169 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 174 */     this.mapCfgId = _os_.unmarshal_int();
/* 175 */     this.instanceId = _os_.unmarshal_int();
/* 176 */     this.templateId = _os_.unmarshal_int();
/* 177 */     this.pathType = _os_.unmarshal_int();
/* 178 */     this.dir = _os_.unmarshal_int();
/* 179 */     this.name = _os_.unmarshal_String("UTF-8");
/* 180 */     this.velocity = _os_.unmarshal_int();
/* 181 */     this.regisOnStart = _os_.unmarshal_int();
/* 182 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 185 */       Point _v_ = new Point();
/* 186 */       _v_.unmarshal(_os_);
/* 187 */       this.pathPoints.add(_v_);
/*     */     }
/* 189 */     this.orignalPoint = new Point();
/* 190 */     this.orignalPoint.unmarshal(_os_);
/* 191 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 194 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 196 */       StateSet _v_ = new StateSet();
/* 197 */       _v_.unmarshal(_os_);
/* 198 */       this.visibleByTaskState.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 200 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\confbean\SMapNPC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */