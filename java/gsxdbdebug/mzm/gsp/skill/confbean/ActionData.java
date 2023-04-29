/*     */ package mzm.gsp.skill.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class ActionData implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int duration;
/*  10 */   public ArrayList<BeAttackedBean> beAttackedList = new ArrayList();
/*  11 */   public ArrayList<Integer> effectlateTimes = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  15 */     this.duration = Integer.valueOf(rootElement.attributeValue("duration")).intValue();
/*     */     
/*  17 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "beAttackedList");
/*  18 */     if (collectionElement == null)
/*     */     {
/*  20 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  23 */     java.util.List<?> _nodeList = collectionElement.elements();
/*  24 */     int _len = _nodeList.size();
/*  25 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  27 */       Element elem = (Element)_nodeList.get(i);
/*  28 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.skill.confbean.BeAttackedBean"))
/*     */       {
/*     */         BeAttackedBean _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  35 */           _v_ = new BeAttackedBean();
/*  36 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  43 */         this.beAttackedList.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  47 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "effectlateTimes");
/*  48 */     if (collectionElement == null)
/*     */     {
/*  50 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  53 */     java.util.List<?> _nodeList = collectionElement.elements();
/*  54 */     int _len = _nodeList.size();
/*  55 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  57 */       Element elem = (Element)_nodeList.get(i);
/*  58 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  65 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  72 */         this.effectlateTimes.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _os_.marshal(this.duration);
/*  80 */     _os_.compact_uint32(this.beAttackedList.size());
/*  81 */     for (BeAttackedBean _v_ : this.beAttackedList)
/*     */     {
/*  83 */       _os_.marshal(_v_);
/*     */     }
/*  85 */     _os_.compact_uint32(this.effectlateTimes.size());
/*  86 */     for (Integer _v_ : this.effectlateTimes)
/*     */     {
/*  88 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  95 */     this.duration = _os_.unmarshal_int();
/*  96 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  99 */       BeAttackedBean _v_ = new BeAttackedBean();
/* 100 */       _v_.unmarshal(_os_);
/* 101 */       this.beAttackedList.add(_v_);
/*     */     }
/* 103 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 106 */       int _v_ = _os_.unmarshal_int();
/* 107 */       this.effectlateTimes.add(Integer.valueOf(_v_));
/*     */     }
/* 109 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\ActionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */