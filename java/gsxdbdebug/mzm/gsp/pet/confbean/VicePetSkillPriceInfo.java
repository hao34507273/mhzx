/*    */ package mzm.gsp.pet.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class VicePetSkillPriceInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int id;
/* 10 */   public ArrayList<Integer> vicePetPrices = new ArrayList();
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/*    */     
/* 16 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "vicePetPrices");
/* 17 */     if (collectionElement == null)
/*    */     {
/* 19 */       throw new RuntimeException("collection type element does not find");
/*    */     }
/*    */     
/* 22 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 23 */     int _len = _nodeList.size();
/* 24 */     for (int i = 0; i < _len; i++)
/*    */     {
/* 26 */       Element elem = (Element)_nodeList.get(i);
/* 27 */       if (elem.getName().equalsIgnoreCase("int"))
/*    */       {
/*    */         int _v_;
/*    */         
/*    */ 
/*    */         try
/*    */         {
/* 34 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 41 */         this.vicePetPrices.add(Integer.valueOf(_v_));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 48 */     _os_.marshal(this.id);
/* 49 */     _os_.compact_uint32(this.vicePetPrices.size());
/* 50 */     for (Integer _v_ : this.vicePetPrices)
/*    */     {
/* 52 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 59 */     this.id = _os_.unmarshal_int();
/* 60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 63 */       int _v_ = _os_.unmarshal_int();
/* 64 */       this.vicePetPrices.add(Integer.valueOf(_v_));
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\confbean\VicePetSkillPriceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */