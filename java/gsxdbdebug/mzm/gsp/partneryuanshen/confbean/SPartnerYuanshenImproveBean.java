/*     */ package mzm.gsp.partneryuanshen.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class SPartnerYuanshenImproveBean implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int improveRequiredItemSiftId;
/*     */   public int improveRequiredItemNum;
/*  11 */   public ArrayList<Integer> propertyTypes = new ArrayList();
/*  12 */   public ArrayList<Integer> propertyRatios = new ArrayList();
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  16 */     this.improveRequiredItemSiftId = Integer.valueOf(rootElement.attributeValue("improveRequiredItemSiftId")).intValue();
/*  17 */     this.improveRequiredItemNum = Integer.valueOf(rootElement.attributeValue("improveRequiredItemNum")).intValue();
/*     */     
/*  19 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "propertyTypes");
/*  20 */     if (collectionElement == null)
/*     */     {
/*  22 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  25 */     java.util.List<?> _nodeList = collectionElement.elements();
/*  26 */     int _len = _nodeList.size();
/*  27 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  29 */       Element elem = (Element)_nodeList.get(i);
/*  30 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  37 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  44 */         this.propertyTypes.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  48 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "propertyRatios");
/*  49 */     if (collectionElement == null)
/*     */     {
/*  51 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  54 */     java.util.List<?> _nodeList = collectionElement.elements();
/*  55 */     int _len = _nodeList.size();
/*  56 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  58 */       Element elem = (Element)_nodeList.get(i);
/*  59 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  66 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  73 */         this.propertyRatios.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  80 */     _os_.marshal(this.improveRequiredItemSiftId);
/*  81 */     _os_.marshal(this.improveRequiredItemNum);
/*  82 */     _os_.compact_uint32(this.propertyTypes.size());
/*  83 */     for (Integer _v_ : this.propertyTypes)
/*     */     {
/*  85 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  87 */     _os_.compact_uint32(this.propertyRatios.size());
/*  88 */     for (Integer _v_ : this.propertyRatios)
/*     */     {
/*  90 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  92 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  97 */     this.improveRequiredItemSiftId = _os_.unmarshal_int();
/*  98 */     this.improveRequiredItemNum = _os_.unmarshal_int();
/*  99 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 102 */       int _v_ = _os_.unmarshal_int();
/* 103 */       this.propertyTypes.add(Integer.valueOf(_v_));
/*     */     }
/* 105 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 108 */       int _v_ = _os_.unmarshal_int();
/* 109 */       this.propertyRatios.add(Integer.valueOf(_v_));
/*     */     }
/* 111 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\confbean\SPartnerYuanshenImproveBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */