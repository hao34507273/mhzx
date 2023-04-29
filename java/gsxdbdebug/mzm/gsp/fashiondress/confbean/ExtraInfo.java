/*     */ package mzm.gsp.fashiondress.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class ExtraInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*   9 */   public ArrayList<Pro2Value> prop_list = new ArrayList();
/*  10 */   public ArrayList<Integer> buff_list = new ArrayList();
/*     */   
/*     */ 
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  15 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "prop_list");
/*  16 */     if (collectionElement == null)
/*     */     {
/*  18 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  21 */     java.util.List<?> _nodeList = collectionElement.elements();
/*  22 */     int _len = _nodeList.size();
/*  23 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  25 */       Element elem = (Element)_nodeList.get(i);
/*  26 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.fashiondress.confbean.Pro2Value"))
/*     */       {
/*     */         Pro2Value _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  33 */           _v_ = new Pro2Value();
/*  34 */           _v_.loadFromXml(elem);
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  41 */         this.prop_list.add(_v_);
/*     */       }
/*     */     }
/*     */     
/*  45 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "buff_list");
/*  46 */     if (collectionElement == null)
/*     */     {
/*  48 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  51 */     java.util.List<?> _nodeList = collectionElement.elements();
/*  52 */     int _len = _nodeList.size();
/*  53 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  55 */       Element elem = (Element)_nodeList.get(i);
/*  56 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  63 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  70 */         this.buff_list.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _os_.compact_uint32(this.prop_list.size());
/*  78 */     for (Pro2Value _v_ : this.prop_list)
/*     */     {
/*  80 */       _os_.marshal(_v_);
/*     */     }
/*  82 */     _os_.compact_uint32(this.buff_list.size());
/*  83 */     for (Integer _v_ : this.buff_list)
/*     */     {
/*  85 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  92 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  95 */       Pro2Value _v_ = new Pro2Value();
/*  96 */       _v_.unmarshal(_os_);
/*  97 */       this.prop_list.add(_v_);
/*     */     }
/*  99 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 102 */       int _v_ = _os_.unmarshal_int();
/* 103 */       this.buff_list.add(Integer.valueOf(_v_));
/*     */     }
/* 105 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\confbean\ExtraInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */