/*     */ package mzm.gsp.award.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import org.dom4j.Element;
/*     */ 
/*     */ public class DropItemIds implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*   9 */   public ArrayList<Integer> itemIds = new ArrayList();
/*  10 */   public ArrayList<Integer> dropCfgIds = new ArrayList();
/*     */   
/*     */ 
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/*  15 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "itemIds");
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
/*  26 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  33 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  40 */         this.itemIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */     
/*  44 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "dropCfgIds");
/*  45 */     if (collectionElement == null)
/*     */     {
/*  47 */       throw new RuntimeException("collection type element does not find");
/*     */     }
/*     */     
/*  50 */     java.util.List<?> _nodeList = collectionElement.elements();
/*  51 */     int _len = _nodeList.size();
/*  52 */     for (int i = 0; i < _len; i++)
/*     */     {
/*  54 */       Element elem = (Element)_nodeList.get(i);
/*  55 */       if (elem.getName().equalsIgnoreCase("int"))
/*     */       {
/*     */         int _v_;
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  62 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*     */           continue;
/*     */         }
/*     */         
/*  69 */         this.dropCfgIds.add(Integer.valueOf(_v_));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  76 */     _os_.compact_uint32(this.itemIds.size());
/*  77 */     for (Integer _v_ : this.itemIds)
/*     */     {
/*  79 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  81 */     _os_.compact_uint32(this.dropCfgIds.size());
/*  82 */     for (Integer _v_ : this.dropCfgIds)
/*     */     {
/*  84 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  91 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/*  94 */       int _v_ = _os_.unmarshal_int();
/*  95 */       this.itemIds.add(Integer.valueOf(_v_));
/*     */     }
/*  97 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*     */ 
/* 100 */       int _v_ = _os_.unmarshal_int();
/* 101 */       this.dropCfgIds.add(Integer.valueOf(_v_));
/*     */     }
/* 103 */     return _os_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\DropItemIds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */