/*    */ package mzm.gsp.children.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ChildrenEquipStageBean implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int needLevel;
/*    */   public int mainItemid;
/* 11 */   public ArrayList<Integer> subItemids = new ArrayList();
/*    */   public int needItemNum;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.needLevel = Integer.valueOf(rootElement.attributeValue("needLevel")).intValue();
/* 17 */     this.mainItemid = Integer.valueOf(rootElement.attributeValue("mainItemid")).intValue();
/*    */     
/* 19 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "subItemids");
/* 20 */     if (collectionElement == null)
/*    */     {
/* 22 */       throw new RuntimeException("collection type element does not find");
/*    */     }
/*    */     
/* 25 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 26 */     int _len = _nodeList.size();
/* 27 */     for (int i = 0; i < _len; i++)
/*    */     {
/* 29 */       Element elem = (Element)_nodeList.get(i);
/* 30 */       if (elem.getName().equalsIgnoreCase("int"))
/*    */       {
/*    */         int _v_;
/*    */         
/*    */ 
/*    */         try
/*    */         {
/* 37 */           _v_ = Integer.valueOf(elem.getText()).intValue();
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 44 */         this.subItemids.add(Integer.valueOf(_v_));
/*    */       }
/*    */     }
/* 47 */     this.needItemNum = Integer.valueOf(rootElement.attributeValue("needItemNum")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 52 */     _os_.marshal(this.needLevel);
/* 53 */     _os_.marshal(this.mainItemid);
/* 54 */     _os_.compact_uint32(this.subItemids.size());
/* 55 */     for (Integer _v_ : this.subItemids)
/*    */     {
/* 57 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 59 */     _os_.marshal(this.needItemNum);
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 65 */     this.needLevel = _os_.unmarshal_int();
/* 66 */     this.mainItemid = _os_.unmarshal_int();
/* 67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 70 */       int _v_ = _os_.unmarshal_int();
/* 71 */       this.subItemids.add(Integer.valueOf(_v_));
/*    */     }
/* 73 */     this.needItemNum = _os_.unmarshal_int();
/* 74 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\ChildrenEquipStageBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */