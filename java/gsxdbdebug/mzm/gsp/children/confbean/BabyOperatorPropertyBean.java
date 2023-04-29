/*    */ package mzm.gsp.children.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class BabyOperatorPropertyBean implements Marshal
/*    */ {
/*    */   public int add_property_type;
/*    */   public int add_property_type_value;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.add_property_type = Integer.valueOf(rootElement.attributeValue("add_property_type")).intValue();
/* 15 */     this.add_property_type_value = Integer.valueOf(rootElement.attributeValue("add_property_type_value")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.add_property_type);
/* 21 */     _os_.marshal(this.add_property_type_value);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.add_property_type = _os_.unmarshal_int();
/* 28 */     this.add_property_type_value = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\BabyOperatorPropertyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */